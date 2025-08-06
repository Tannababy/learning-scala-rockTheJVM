package lectures.basics

object CBNvsCBV extends App {

  // both line 7 and 8 will print the same value
  def callByValue(x: Long): Unit = {
    println("by value: " + 12345678912345L)
    println("by value: " + 12345678912345L)
  }

  // line 13 and 14 will print different results as the parameter was passed as an expression and therefore recomputes
  // on each line of the code block
  def callByName(x: => Long): Unit = {
    println("by name: " + System.nanoTime())
    println("by name: " + System.nanoTime())
  }

  callByValue(12345678912345L)
  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  // this will not crash because only the first int is called (println(x))
  def printFirst(x: Int, y: => Int): Unit = println(x)
}
