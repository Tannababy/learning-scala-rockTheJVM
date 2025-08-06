package lectures.basics

object StringOps extends App{

  val str: String = "Hello, I am learning how to code in Scala"

  println(str.charAt(2))
  println(str.substring(7, 20))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase)
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') // +: prefixes, :+ suffixes
  println(str.reverse)
  println(str.take(2)) // takes 1st two items

  // Scala-specific: String interpolators

  // S-interpolators
  val name = "Silver"
  val age = 12
  val greeting = s"Hello, my name is $name, and I am $age years old."
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old."

  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"

  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  // / the "\n" will not be escaped here because the escaped string is not directly contained
  // within the raw interpolated string like it is in line 38
  println(raw"$escaped")
}
