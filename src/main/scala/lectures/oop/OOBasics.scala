package lectures.oop

object OOBasics extends App {

  val person = new Person("Ibiere", 27)
  println(person.x)
  person.greet("Silver")
  person.greet()
}

// constructor
class Person(name: String, age: Int) {
  // body
  val x = 2

  // Note: last line of codeblock must run first before class println
  println(1 + 3)

  // a function is a method once inside a class
  // because we want to use 2 different names, we use the keyword to reference the class name
  def greet(name: String): Unit = println(s"${this.name} says: Hi $name")

  // Overloading, if 2 methods with the same param list but diff return will cause compiler errors
  def greet(): Unit = println(s"Hi, I am $name.")

  // multiple constructors
  def this(name: String) = this(name, 0)

}

// class parameters are NOT FIELDS. to make a param a field, val must be added to them
