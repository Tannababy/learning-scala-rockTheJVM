package exercises

abstract class MyList {

  /*
      methods
      head = returns first element of the list
      tail = contains remainder of the list
      isEmpty = is this list empty
      add(int) => new list with this element added
      toString => override a string representation of the list
   */

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(newNum: Int): MyList // instead of modifying the list, a new list is created each time
  def printItems: String
  // Polymorphic call
  override def toString: String = s"[ $printItems ]" // override because toString, hashCode and equals already exist iin super class AnyRef
}

object Empty extends MyList { // objects can extend classes but cannot be extended
  def head: Int = throw new NoSuchElementException // because list is empty there should be no tail
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(newNum: Int): MyList = new Cons(newNum, Empty)
  def printItems: String = ""
}

class Cons(h: Int, t: MyList) extends MyList { // equivalent to a node in a linked list
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(newNum: Int): MyList = new Cons(newNum, this)
  def printItems: String = {
    if (tail.isEmpty) s"$head"
    else s"$head ${tail.printItems}" // .printItems method is called recursively here to print each item till htail is empty
  }
}

object listTester extends App{
  val list = new Cons(1, Empty)
  val list2 = new Cons(2, new Cons(4, new Cons(6, Empty)))
  println(list2.head)
  println(list2.tail.head)

  println(list.add(3).head)

  println(list2.toString)
}