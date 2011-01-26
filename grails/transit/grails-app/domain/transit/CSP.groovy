package transit

class CSP {

  Integer codigo
  String nome

//  static belongsTo = [cenario:Cenario]

  static constraints = {
  }

  def getValue() {
    return "${this.codigo} - ${this.nome}"
  }
}
