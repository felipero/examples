def dslDef = new File('GroovyPizzaDSL.groovy').text

def dsl = new File('orderPizza.dsl').text

def orders = dsl.split("\n\n").collect{ it.trim()}

def script = """
${dslDef}
"""

orders.eachWithIndex {order, index ->
    script += """\n acceptOrder(${index + 1}) { $order } \n"""
}

new GroovyShell().evaluate(script)
