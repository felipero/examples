class Montadora(type):

    def __new__(cls, name, bases, dct):
        print "Inicializando a classe", name

        if 'models' in dct:
            for model in dct['models']:
                dct[model] = model.upper()

        return type.__new__(cls, name, bases, dct)

class GM:
    __metaclass__ =  Montadora
    models = ["celta", "corsa", "astra", "vectra"]


print "Modelos:", GM.models
print GM.celta
print GM.vectra

