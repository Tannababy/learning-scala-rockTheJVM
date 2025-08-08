package lectures.oop

object Generics extends App {

  // list should generally be covariant
  class MyList[+A] {
    // use the type A
    // def add(element: A): MyList[A] = ??? // this is not allowed
    // it is the code version of
    // { val animalList: CovariantList[Animal] = new CovariantList[Cat]
    // can animalList.add(new Dog)? }
    def add[B >: A](element: B): MyList[B] = ??? // This means if you put in an element of the supertype B, the List of type A will then return a List of the supertype

  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyIntList = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. List[Cat] extends List[Animal] = COVARIANCE
  // relationship goes from parent class to substitution by subclass
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // can animalList.add(new Dog)? No because in this case only new cats can be added

  // 2. INVARIANCE
  // here all classes exist on their own
  class InvariantList[A]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. CONTRAVARIANCE
  // here the relationship goes from child to parent class
  // this works to provide the more specialised subclass with the general methods of super class
  class Contravariant[-A]
  val contravariantList: Contravariant[Cat] = new Contravariant[Animal]

  // bounded types
  // upper bounded types [A <: Type]
  // below class Cage only accepts SUBtype classes of the type A
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  // lower bounded types [A >: Type]
  // meaning it only accepts SUPERtype classes of the type A

}
