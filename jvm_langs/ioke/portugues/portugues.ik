
PortuguesDefaultBehavior = Reflector other:mimic(DefaultBehavior)

PortuguesDefaultBehavior celula = cell(:cell)
PortuguesDefaultBehavior imitar = cell(:mimic)
PortuguesDefaultBehavior se = cell(:if)
PortuguesDefaultBehavior metodo = cell(:method)
PortuguesDefaultBehavior funcao = cell(:fn)
PortuguesDefaultBehavior Origem = Origin
PortuguesDefaultBehavior faca = cell(:do)
PortuguesDefaultBehavior com = cell(:with)
PortuguesDefaultBehavior si_proprio = method(self)
PortuguesDefaultBehavior imprimir = Origin cell(:print)
PortuguesDefaultBehavior plotar = Origin cell(:println)

DefaultBehavior mimic!(PortuguesDefaultBehavior)
