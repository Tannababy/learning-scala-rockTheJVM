package lectures.oop

object Objects {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  // COMPANIONS - both class and objects named with the same name in the same scope

  object Person { // type + its only instance defined
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, mum: Person): Person = new Person("child")
  }
  class Person(val name: String) {
    // instance-level functionality
  }

  println(Person.N_EYES)
  println(Person.canFly)

  def main(args: Array[String]): Unit = {
    // Scala Applications = Scala object with
    // def main(args: Array[String]: Unit = {}
    // "static" in Java is replaced by a single method in a Scala object

    // Scala object = SINGLETON INSTANCE
    val mary = Person
    val pere = Person
    println(mary == pere) // point to same instance

    val mum1 = new Person("Ibiere")
    val mum2 = new Person("Tanna")
    println(mum1 == mum2) // will result in false because the "new" creates new instances of the class in memory

    val baby = Person(mum1, mum2)
    println(baby.name)
  }
}
