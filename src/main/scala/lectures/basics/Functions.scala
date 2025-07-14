package lectures.basics

object Functions  extends App {

  // because expressions can also be blocks, a code block or sing expression will evaluate to it's last line
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  // Scala 3 requires the distinction between functions with/out parentheses

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello ", 3))

  // functions that only execute side effects are necessary when displaying something on screen, logging something, writing to a file, (nothing to do with computation)
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  // code blocks allow you to nest functions (auxiliary functions inside function)
  def aBigFunction(n: Int): Int = {

    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  /*
  Exercises
    1. A greeting function (name, age) => "Hi, my name is $name, and I am $age years old."
    2. Factorial function 1 * 2 * 3 * .. * n (computes product of all integers up to n (recursive))
    3. Fibonacci function
      f(1) = 1
      f(2) = 1
      f(n) = f(n - 1) + f(n - 2)
    4. Tests if our number is prime.
   */
  // Solutions

  // 1)
  def greeting(name: String, age: Int): String = "Hi my name is " + name + ", and I am " + age + " years old."


  // to run println, call it outside function
    println(greeting("Lotanna", 30))



  // 2)
  def factorialFunction(max: Int): Int = {
    if (max <= 1) 1
    else max * factorialFunction(max - 1)
  }

  println(factorialFunction(5))

  // 3)
  def fibonacciFunction(n: Int): Int =
    if (n <= 1) n
    else fibonacciFunction(n - 1) + fibonacciFunction(n - 2)

  // 1 1 2 3 5 8 13
  println(fibonacciFunction(7))


  // 4) stuck on this one
  def primeNumbersTest(n: Int): Boolean = {

    def isPrimUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimUntil(t - 1)
    }

    isPrimUntil(n / 2)
  }

  println(primeNumbersTest((37)))

}
