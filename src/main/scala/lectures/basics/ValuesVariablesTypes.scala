package lectures.basics

// extends App to run in terminal
object ValuesVariablesTypes extends App{

  // Vals are immutable
  val x: Int = 45
  println(x)

  // Var are mutable and useful for side effects
  var y: Int = 1
  y += 1
  println(y)

  // compiler can automatically infer types when omitted
  // basic types: Boolean, Int, Long (must end with L), Double,
  //              Float (must end wit f)
  // Characters & Strings

  var aBoolean = false
  var aLong = 123445566777L
  var aDouble = 3.456
  var aFloat = 24.5f
  var aChar = 'L'
  var aString = "This is going well"
}
