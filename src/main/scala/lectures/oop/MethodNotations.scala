package lectures.oop

import scala.language.postfixOps

object MethodNotations extends App {

  // when working within the same package, classes of the same name cant exist on their own
  // instead they can be contained within an object
  class Person(val name: String, favouriteMovie: String) {

    def likes(movie: String): Boolean = movie == favouriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    // space required between unary method names and return type to avoid confusing the compiler
    def unary_! : String = s"${name}, what the heck!" //  == def ! : String = s"${name}, what the heck!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi my name is ${name} and I like ${favouriteMovie}"
  }

  val mary = new Person("Mary", "Inception")
  //    object.method(parameter)
  println(mary.likes("Inception"))

  // SYNTACTIC SUGAR

  // 1) Infix notation = operator notation
  //                  only works with methods that have only 1 parameter
  println(mary likes "Inception") // equivalent to line 13

  // 'operators' in Scala
  val tom = new Person("Tom","Fight Club")
  println(mary hangOutWith tom)

  // Scala has very flexible method naming
  // math operators, characters etc are allowed as method name

  // ALL OPERATORS ARE METHODS
  // control + space after <number>. shows all available methods and proper operators

  // 2) Prefix notation -
  // Unary operators - methods w/ unary underscore prefixed
  //                   only works w/ - + ~ !
  val x = -1 // equivalent w/ 1.unary_-
  val y = 1.unary_-

  println(!mary) // method ! is prefixed to object mary
  println(mary.unary_!)

  // 3) Post notation -
  // functions that do not receive any parameters are used
  println(mary.isAlive) // regular notation
  println(mary isAlive) // post notation

  // apply() - used when to call an object like a function when method has no params e.g println(mary())
  println(mary.apply())
  println(mary()) // equivalent  to line 54
}
