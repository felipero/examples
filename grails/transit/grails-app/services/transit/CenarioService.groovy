package transit

class CenarioService {

    static transactional = true

    def filter(params) {
      def nome = params.nome ? params.nome : null
      def sentido = params.sentido ? params.sentido : null
      def csp

      if(params.csp){
       csp = transit.CSP.findById(1)
      }
      def cenario = new Cenario(nome: nome, sentido: sentido, csp : csp )
      Cenario.findAll(cenario)
      
    }
}
