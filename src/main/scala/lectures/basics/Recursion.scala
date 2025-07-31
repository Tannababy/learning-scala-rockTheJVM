package lectures.basics

import scala.annotation.tailrec
import scala.jdk.Accumulator


object Recursion extends App {

  //  def factorial(n: Int): Int = {
  //    if (n <= 1) 1
  //    else {
  //      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
  //      val result = n * factorial(n - 1)
  //      println("Computed factorial of " + n) // no tail recursion as println and result come after function calling itself
  //
  //      result
  //    }
  //  }
  //
  //  println(factorial(10))
  //  println(factorial(5000)) - will cause stack overflow error because the recursive depth is too large for the memory in the stack


  /*
  anotherFactorial(10) = factHelper(10, 1)
  factHelper(9, 10 * 1)
  factHelper(8, 9 * 10 * 1)
  factHelper(7, 8 * 9 * 10 * 1)
  factHelper(6, 7 * 8 * 9 * 10 * 1)
  factHelper(5, 6 * 7 * 8 * 9 * 10 * 1)
  factHelper(4, 5 *  6 * 7 * 8 * 9 * 10 * 1)
  factHelper(3, 4 * 5 *  6 * 7 * 8 * 9 * 10 * 1)
  factHelper(2, 3 * 4 * 5 *  6 * 7 * 8 * 9 * 10 * 1)
  factHelper(1, 2 * 3 * 4 * 5 *  6 * 7 * 8 * 9 * 10 * 1)
  factHelper(2 * 3 * 4 * 5 *  6 * 7 * 8 * 9 * 10 * 1)
  */

  // great for big numbers e.g. BigInt
  def anotherFactorial(n: Int): Int = {

    // TAIL RECURSION = recursive call as the LAST expression of function/ codepath
    //                  saves stack memory as compiler will replace last expression with new one

    @tailrec //annotation lets compiler know if it isn't a tail rec, compiler will complain
    def factHelper(x: Int, accumulator: Int): Int =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // last line of factHelper function

    factHelper(n, 1)
  }


  // When you need loops, USE_TAIL_RECURSION

  /*
   1. Concatenate a string n times
   2. IsPrime function tail recursive
   3. Fibonaci function, tail recursive.
   */

  // SOLUTIONS

  // Q.1 - Concatenate a string n times
  // recursive function
  def concatStrings(n: Int, str: String): String = {

    if (n <= 1) str
    else str + concatStrings(n - 1, str)
  }
  // tail recursive version
  @tailrec
  def tailRecConcatStr(str: String, n: Int, accumulator: String): String = {

    if (n <= 0) accumulator
    else tailRecConcatStr(str, n -1, str + accumulator)
  }

  println(tailRecConcatStr("hello ", 7, ""))


  // Q.2 - IsPrime function

  def IsPrime(n: Int): Boolean = {

    @tailrec
    def isPrimeTailrecHelper(middleNum: Int, isStillPrime: Boolean): Boolean  = { // isStillPrime acts as an accumulator
       if (!isStillPrime) false
       else if (middleNum <= 1) true
       else isPrimeTailrecHelper(middleNum - 1, n % middleNum != 0 && isStillPrime) // n % middleNum != 0 is an expression that evaluates to a boolean
    }

    isPrimeTailrecHelper(n / 2, true)
  }

  println(IsPrime(37))

  // Q.3 - Fibonacci (needs debugging)

  def fibonacciTailrec(n: Int, accumulator: Int): Int = {

    if (n <= 1) accumulator
    else fibonacciTailrec(n - 1, n + accumulator)
  }

  println(fibonacciTailrec(7, 1))
}
