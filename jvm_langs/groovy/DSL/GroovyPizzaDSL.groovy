class PizzaDSL {
    def grande = 'large'
    def pequena = 'pequena'
    def fina = 'fina'
    def visa = 'Visa'
    def master = 'Mastercard'
    def Azeitonas = 'Azeitonas'
    def Cebola = 'Cebola'
    def Atum = 'Atum'
    
    def pedidos = [:]
    
    def methodMissing(String name, args) {
        pedidos[name] = args
    }
    
    def imprimir(index, closure) {
        closure.delegate = this
        closure()
        println "Validando e processando a ordem $index:"
        println pedidos
        pedidos.each { key, value ->
            println "${key} -> ${value.join(', ')}"
        }
        println "\n"
    }
}

def dsl = new File('orderPizza.dsl').text

def orders = dsl.split("\n\n").collect{ it.trim()}


def script = """
def pd = new PizzaDSL()
"""

orders.eachWithIndex {order, index ->
    script += """\n pd.imprimir(${index + 1}) { $order } \n"""
}

new GroovyShell(PizzaDSL.getClassLoader()).evaluate(script)

