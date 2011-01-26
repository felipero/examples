package transit

class CenarioController {

  static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
  CenarioService cenarioService

  def index = {
    redirect(action: "list", params: params)
  }

  def list = {
    session['some_att'] = 345
    params.max = Math.min(params.max ? params.int('max') : 10, 100)
    [cenarioInstanceList: Cenario.list(params), cenarioInstanceTotal: Cenario.count()]
  }

  def search = {
    session['some_att'] = 345
    render(view: 'list', model:[cenarioInstanceList: cenarioService.filter(params), cenarioInstanceTotal:0])
  }

  def create = {
    def cenarioInstance = new Cenario()
    cenarioInstance.properties = params
    return [cenarioInstance: cenarioInstance]
  }

  def save = {
    def cenarioInstance = new Cenario(params)
    if (cenarioInstance.save(flush: true)) {
      flash.message = "${message(code: 'default.created.message', args: [message(code: 'cenario.label', default: 'Cenario'), cenarioInstance.id])}"
      redirect(action: "show", id: cenarioInstance.id)
    }
    else {
      render(view: "create", model: [cenarioInstance: cenarioInstance])
    }
  }

  def show = {
    def cenarioInstance = Cenario.get(params.id)
    if (!cenarioInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cenario.label', default: 'Cenario'), params.id])}"
      redirect(action: "list")
    }
    else {
      [cenarioInstance: cenarioInstance]
    }
  }

  def edit = {
    def cenarioInstance = Cenario.get(params.id)
    if (!cenarioInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cenario.label', default: 'Cenario'), params.id])}"
      redirect(action: "list")
    }
    else {
      return [cenarioInstance: cenarioInstance]
    }
  }

  def update = {
    def cenarioInstance = Cenario.get(params.id)
    if (cenarioInstance) {
      if (params.version) {
        def version = params.version.toLong()
        if (cenarioInstance.version > version) {

          cenarioInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'cenario.label', default: 'Cenario')] as Object[], "Another user has updated this Cenario while you were editing")
          render(view: "edit", model: [cenarioInstance: cenarioInstance])
          return
        }
      }
      cenarioInstance.properties = params
      if (!cenarioInstance.hasErrors() && cenarioInstance.save(flush: true)) {
        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'cenario.label', default: 'Cenario'), cenarioInstance.id])}"
        redirect(action: "show", id: cenarioInstance.id)
      }
      else {
        render(view: "edit", model: [cenarioInstance: cenarioInstance])
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cenario.label', default: 'Cenario'), params.id])}"
      redirect(action: "list")
    }
  }

  def delete = {
    def cenarioInstance = Cenario.get(params.id)
    if (cenarioInstance) {
      try {
        cenarioInstance.delete(flush: true)
        flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'cenario.label', default: 'Cenario'), params.id])}"
        redirect(action: "list")
      }
      catch (org.springframework.dao.DataIntegrityViolationException e) {
        flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'cenario.label', default: 'Cenario'), params.id])}"
        redirect(action: "show", id: params.id)
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'cenario.label', default: 'Cenario'), params.id])}"
      redirect(action: "list")
    }
  }
}
