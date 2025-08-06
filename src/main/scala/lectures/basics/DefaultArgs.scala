package lectures.basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  /*
  when calling a function with the same param types, initialise one of them to a default value
  for the compilers understanding

  by initialising the accumulator with 1, the compiler will assume that it is it's default
  value unless another value is passed instead
   */
  @tailrec
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n-1, n*acc)

  //  val fact10 = trFact(10, 2)
  val fact10 = trFact(10)

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("saving picture")
//  savePicture(800, 900)
  /*
   1. pass in every leading argument
   2. name the arguments (allows you to pass them in different order)
  /
   */
}
