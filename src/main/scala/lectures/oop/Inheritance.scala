package lectures.oop

object Inheritance extends App {

  // single class inheritance
  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat // by extending Animal, Cat can call on its parent method eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  // because eat is a protected method, cat can access it but outside the cat class,
  // only the public crunch method could be accessed
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    // since the class Person is constructed with 2 parameters, it must be extended with them
    // only work around is to define an auxiliary function within Person that takes less/more params
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    override def eat = {
      super.eat
      println("crunch, crunch")
    }

//    override val creatureType= "domestic" (now overridden directly in constructor)
  }

  // fields can be directly overridden in the constructor
//  class Dog(dogType: String) extends Animal {
//    override val creatureType = dogType
//  }

  val dog = new Dog("Pitbull")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("Doberman")
  unknownAnimal.eat

  /*
   overRIDING vs overLOADING
   -------------------------
   super

   preventing overrides
   1. use final keyword on field/method
   2. use final on the entire class prevents extending
   3. seal the class = extends classes in THIS FILE, but prevents extension in other files (sealed keyword)
   */

}
