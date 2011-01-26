package tdcg

class CarroController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [carroInstanceList: Carro.list(params), carroInstanceTotal: Carro.count()]
    }

    def create = {
        def carroInstance = new Carro()
        carroInstance.properties = params
        return [carroInstance: carroInstance]
    }

    def save = {
        def carroInstance = new Carro(params)
        if (carroInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'carro.label', default: 'Carro'), carroInstance.id])}"
            redirect(action: "show", id: carroInstance.id)
        }
        else {
            render(view: "create", model: [carroInstance: carroInstance])
        }
    }

    def show = {
        def carroInstance = Carro.get(params.id)
        if (!carroInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'carro.label', default: 'Carro'), params.id])}"
            redirect(action: "list")
        }
        else {
            [carroInstance: carroInstance]
        }
    }

    def edit = {
        def carroInstance = Carro.get(params.id)
        if (!carroInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'carro.label', default: 'Carro'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [carroInstance: carroInstance]
        }
    }

    def update = {
        def carroInstance = Carro.get(params.id)
        if (carroInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (carroInstance.version > version) {
                    
                    carroInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'carro.label', default: 'Carro')] as Object[], "Another user has updated this Carro while you were editing")
                    render(view: "edit", model: [carroInstance: carroInstance])
                    return
                }
            }
            carroInstance.properties = params
            if (!carroInstance.hasErrors() && carroInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'carro.label', default: 'Carro'), carroInstance.id])}"
                redirect(action: "show", id: carroInstance.id)
            }
            else {
                render(view: "edit", model: [carroInstance: carroInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'carro.label', default: 'Carro'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def carroInstance = Carro.get(params.id)
        if (carroInstance) {
            try {
                carroInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'carro.label', default: 'Carro'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'carro.label', default: 'Carro'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'carro.label', default: 'Carro'), params.id])}"
            redirect(action: "list")
        }
    }
}
