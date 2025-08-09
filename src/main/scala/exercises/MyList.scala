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

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
//  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
}

//
object Empty extends MyList[Nothing] { // objects can extend classes but cannot be extended
  def head: Nothing = throw new NoSuchElementException // because list is empty there should be no tail
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](newNum: B): MyList[B] = new Cons(newNum, Empty)
  def printItems: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
//  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] { // equivalent to a node in a linked list
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](newNum: B): MyList[B] = new Cons(newNum, this)
  def printItems: String = {
    if (t.isEmpty) s"$h"
    else s"$h ${t.printItems}" // .printItems method is called recursively here to print each item till htail is empty
  }

  def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new Cons(transformer.convert(h), t.map(transformer))

}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def convert(element: A): B
}

object ListTester extends App{
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

  /*
  [2, 4, 6].map(MyTransformer.convert(element * 2)) the head will be transformed first and the tail will remain the last 2 Ints
  = new Cons(4, [4, 6].map(MyTransformer.convert(element * 2)) the h will remain but the next head will be the 2nd Int
  = new Cons(4, new Cons(8, [6].map(MyTransformer.convert(element * 2))
  = new Cons(4, new Cons(8, new Cons(12, Empty.map(MyTransformer.convert(element * 2))
  = new Cons(4, new Cons(8, new Cons(12, Empty)))
   */
  println(listOfInts.map(new MyTransformer[Int, Int] {
    override def convert(element: Int): Int = element * 2
  }).toString)

}