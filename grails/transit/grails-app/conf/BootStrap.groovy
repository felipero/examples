import transit.CSP

class BootStrap {

    def init = { servletContext ->
      def csp = new CSP()
      csp.nome = "Felipe"
      csp.codigo = 54
      csp.save(flush:true)
    }
    def destroy = {
    }
}
