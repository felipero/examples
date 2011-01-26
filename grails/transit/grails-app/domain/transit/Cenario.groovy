package transit

class Cenario {

  String descricao
  String nome
  Boolean sentido
  CSP csp
//  static hasOne = [csp:CSP]

  static constraints = {
    csp(nullable:true)
  }
}
