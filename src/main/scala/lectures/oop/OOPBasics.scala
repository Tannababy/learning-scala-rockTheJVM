package lectures.oop

object OOPBasics extends App {

    val person = new Person("Ibiere", 27)
    println(person.x)
    person.greet("Silver")
    person.greet()

    val exampleAuthor = new Writer("Ibiere", "Briggs", 1997)
    val imposter = new Writer("Ibiere", "Briggs", 1997)
    val novel = new Novel("Things Fall Apart", 2020, exampleAuthor)

    println(novel.authorAge)
    println(novel.isWrittenBy(exampleAuthor))

    val counter = new Counter
    counter.increment.print
    counter.increment.increment.increment.print
    counter.increment(15).print

  // constructor
  class Person(name: String, age: Int) {
    // body
    val x = 2

    // Note: last line of codeblock must run first before class println
    println(1 + 3)

    // a function is a method once inside a class
    // because we want to use 2 different names, we use the keyword "this" to reference the class name
    def greet(name: String): Unit = println(s"${this.name} says: Hi $name")

    // Overloading, 2 methods with the same param list but diff return type will cause compiler errors
    def greet(): Unit = println(s"Hi, I am $name.")

    // multiple constructors
    def this(name: String) = this(name, 0)

  }

  /*
  Exercise

  Novel and a Writer

  Writer: first name, surname, year
    - method fullname

  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of novel


  */

  /*
  Counter class
    - receives an int value
    - method that returns a current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive and amount
    */

  class Writer(firstName: String, lastName: String, val year: Int) { // the parameter "year" was converted to field with val to make accessible to other classes

    def fullName: String = s"$firstName $lastName"
  }

  class Novel(name: String, yearOfRelease: Int, author: Writer) {

    def authorAge = yearOfRelease - author.year // authors age @ year of release = release year - autor age

    def isWrittenBy(author: Writer) = author == this.author

    def copy(newYear: Int): Novel = new Novel(name, newYear, author)


  }

  class Counter(val count: Int = 0) { // by initialising in constructor, when instantiated, it will default to what it was initialised as

    def increment = {
      println("incrementing")
      // for immutability a new instance of counter must be made every time
      new Counter(count + 1)
    }

    def decrement = {
      println("decrementing")
      // for immutability a new instance of counter must be made every time
      new Counter(count - 1)
    }

    //overloaded methods for counters  of any number inc/dec
    def increment(n: Int): Counter = {
      if (n <= 0) this
      else increment.increment(n -1)
    }

    def decrement(n: Int): Counter = {
      if (n <= 0) this
      else decrement.decrement(n - 1)
    }

    def print = println(count)
  }


  // class parameters are NOT FIELDS. to make a param a field, val must be added to them

}




