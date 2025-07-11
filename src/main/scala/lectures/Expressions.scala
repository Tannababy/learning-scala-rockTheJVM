package lectures

object Expressions extends App{

  val x = 2 + 3

  // Everything in Scala is an Expression

  // Basic operators --> + - / * & |
  // Relational operators --> (test for equality) == !=
  // Relational operators between numbers --> > >= < <=
  // Logical operators --> && ||

  // Statements/Instructions (Do) Vs Expressions (Value and/ Type)

  var aVariable = 3
  aVariable += 2 // side effects
  println(aVariable)

  // If Expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 10
  println(aConditionedValue)

  // If expressions can also be passed to printLn directly
  println(if (aCondition) 5 else 10)

  val aWeirdValue = (aVariable = 5)
  println(aWeirdValue) // once it doesn't return a value the type = () => Unit (like void)

  // code block - is equal to the type of the last expression in the code block
  //            - all local variables are not visible outside codeblock
  val aCodeBlock = {
    val a = 4
    val b = a + 2

    if (b > 5) "I am greater than five" else "I am not greater than five"
  }

  // Exercise
  // ---------------
  // 1. The difference between "Hello, world" and println("Hello, world")
  // "Hello, world" =  String literal
  // println("Hello, world")  = is an expression (side effect) of value Unit
  //
  // 2. What does this evaluate to ->
   val someValue = {
     2 < 3
   }
   println(someValue)
  // Ans: true (Boolean)

  // 3. What does this evaluate to ->
     val someOtherValue = {
       if (someValue) 219 else 908
       42
     }
   println(someOtherValue)
  // Ans: 42
}
