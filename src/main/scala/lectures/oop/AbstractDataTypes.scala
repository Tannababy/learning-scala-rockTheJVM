package lectures.oop

object AbstractDataTypes extends App {

  // abstract = classes which contain unimplemented(abstract) fields or methods
  //            cannot be instantiated
  //            made to be extended later on
  //            override keyword is not needed as no prior implementation exists
  //            can have abstract and non - abstract members (fields, methods)
  abstract class Animal {

    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat = println("crunch crunch")
  }

  // traits - have abstract fields and methods
  //          can be inherited unlike reg abstract classes
  //          a class can inherit multiple traits
  trait ColdBlooded
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I am eatining ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor params (Scala 3 allows this now)
  // 2 - multiple traits may be inherited by the same class but classes can only be extended once
  // 3 - traits = behavior , abstract class = a type of thing

}
