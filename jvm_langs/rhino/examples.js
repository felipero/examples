// Acessando classes e constandes
print(Packages.java.lang.Math.PI)

// Importação de classes
importClass(Packages.java.util.Random);

// Instanciação de objetos
var rnd = new Random()

// Chamada de métodos
rnd.nextInt()
rnd.nextInt(200)

var Car = function() {
  return  this;
}

var apolo = Car();
var verona = Car();
var golf = new Car();

apolo == verona // TRUE
apolo === verona // TRUE
apolo == golf // FALSE
apolo === golf // FALSE

function Person( arg) {
  this.name = arg;
}

var bob = new Person( "Bob" );
var alice = new Person( "Alice" );

print(bob.name)