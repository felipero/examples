def grande = 'large'
def pequena = 'pequena'
def fina = 'fina'
def visa = 'Visa'
def master = 'Mastercard'
def Azeitonas = 'Azeitonas'
def Cebola = 'Cebola'
def Atum = 'Atum'

orderInfo = [:]

def methodMissing(String name, args)
{
  orderInfo[name] = args
}

def acceptOrder(index, closure)
{
  closure.delegate = this
  closure()
    println "Validando e processando a ordem $index:"
  orderInfo.each { key, value ->
    println "${key} -> ${value.join(', ')}"
  }
  println "\n"
}
