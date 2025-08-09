package lectures.oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahahahahha")
  }

  /*
  What the compiler executes is:

  class AnonymousClasses$$anon$1 extends Animal {
    override def eat : Unit = println("hahahahahahahha")
  }
  val funnyAnimal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass) // prints the new class compiler created => class lectures.oop.AnonymousClasses$$anon$1

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help")
  }

  val chi = new Person("Chi") {
    override def sayHi: Unit = println("Hi, my nam eis Chi, how can I be of service")
  }

  /*
  Exercise: expand MyList functionality
  1. Create Generic trait = MyPredicate[T] to test whether something of type T passes a condition
  2. Generic trait = MyTransformer[A, B] contains method to convert something of type A to type B
  3. Implement the following functions on MyList:
                                          - map(transformer) => MyList of diff type
                                          - filter(predicate) => MyList
                                          - flatMap(transformer from A to MyList[B] => MyList[B]
   */
  


}