package exercises

abstract class MyList[+A] {

  /*
      methods
      head = returns first element of the list
      tail = contains remainder of the list
      isEmpty = is this list empty
      add(int) => new list with this element added
      toString => override a string representation of the list
   */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](newNum: B): MyList[B] // instead of modifying the list, a new list is created each time
  def printItems: String
  // Polymorphic call
  override def toString: String = s"[ $printItems ]" // override because toString, hashCode and equals already exist iin super class AnyRef
}

//
object Empty extends MyList[Nothing] { // objects can extend classes but cannot be extended
  def head: Nothing = throw new NoSuchElementException // because list is empty there should be no tail
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](newNum: B): MyList[B] = new Cons(newNum, Empty)
  def printItems: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] { // equivalent to a node in a linked list
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](newNum: B): MyList[B] = new Cons(newNum, this)
  def printItems: String = {
    if (tail.isEmpty) s"$h"
    else s"$h ${t.printItems}" // .printItems method is called recursively here to print each item till htail is empty
  }
}

object listTester extends App{
//  val list = new Cons(1, Empty)
//  val list2 = new Cons(2, new Cons(4, new Cons(6, Empty)))
//  println(list2.head)
//  println(list2.tail.head)
//
//  println(list.add(3).head)
//
//  println(list2.toString)
  val listOfInts: MyList[Int] = new Cons(2, new Cons(4, new Cons(6, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hi", new Cons("there", new Cons("!", Empty)))

  println(listOfInts.toString)
  println(listOfStrings.toString)
}