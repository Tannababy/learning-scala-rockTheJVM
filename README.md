# learning-scala-rockTheJVM

📖 I am learning Scala using materials from the [Scala & Functional Programming Essentials course.](https://www.udemy.com/course/rock-the-jvm-scala-for-beginners/) 
I'll be documenting my progress in this repo with notes and practice code.


## ✅ Topics to cover

---
- [x] Basics:
- -[x] Valuables, Variables and Types
- -[x] Expressions
- -[x] Functions
- -[x] String operations
- -[x] Recursion
---
- [ ] Object Oriented Programming:
- -[x] Syntactic Sugar: method Notations
- -[x] Scala Objects
- -[x] Inheritance
- - -[x] Abstract classes
- - - [x] Traits
- -[ ] Generics
- -[ ] Anonymous classes
- -[ ] Case classes
- -[ ] Enums
- -[ ] Exceptions
---
- [ ] Functional Programming:
- -[ ] Anonymous functions
- -[ ] Higher - order functions and Curries
- -[ ] Collections
- - -[ ] List
- - -[ ] Array
- - -[ ] Vector
- -[ ] Tuples and Maps
- -[ ] Pattern matching
---

## 🧠 Key Takeaways 

- Everything in Scala is an expression 
- Recursion over loops
- All "operators" are methods
- String interpolation: s, f, raw
- Infix notation allows for methods with 1 parameter to be written like natural langauge (object method parameter)
- Unary operators are the same as prefix notation, it only works with (+, -, !, ~)
- Postfix notation is only used with methods that have no parameters
- Apply() allows for objects to be called like a method
- Scala doesn't have the "static" keyword and instead makes use of Singleton objects 
- Objects are their own class/type and the only instance of that type
- Scala companions (class and object of same name in the same scope) can access each other's private members
- Access modifiers: 
- - private
- - protected 
- - public (default)
- overRIDING = unique implementation of super class fields/methods (inheritance, abstraction)
- overLOADING = multiple method signatures with the same name and different parameter types (polymorphism)
- Abstract class Vs Traits 
- - multiple traits may be inherited by the same class but classes can only be extended once
- - All classes are extended from Any class
- - AnyVal
- - AnyRef
- - Nothing can extend anything in Scala




