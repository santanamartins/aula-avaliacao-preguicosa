package shortCircuit

// This file demonstrates short-circuit evaluation in Scala.
// It also shows how to implement custom logical operations using by-name parameters.
def positive(n: Int): Boolean = {
    println(s"Checking if $n is positive")
    // Shows when the check is performed
    n > 0
}

def even(n: Int): Boolean = {
    println(s"Checking if $n is even")
    // Shows when the check is performed
    n % 2 == 0
}

package nativeAnd {
    // Demonstrates native short-circuiting with '&&'
    @main def testShortCircuit = {
        println(positive(4) && even(4) )
        println(positive(-4) && even(-4))
    }
}

package customAnd {
    // Custom 'and' function using by-name parameter for right operand
    def customAnd(left: Boolean, right: => Boolean): Boolean = {
        if (!left) false else right
    }

    @main def testCustomAnd = {
        println(customAnd(positive(4), even(4)))
        println(customAnd(positive(-4), even(-4)))
    }
}

package conditionalAdd {
    // Adds two numbers only if both are positive, using by-name parameters
    def optionalAdd(x: => Int, y: => Int): Option[Int] = {
        if (!positive(x)) None
        else if (!positive(y)) None
        else Some(x + y)
    }

    @main def testConditionalAdd = {
        println(optionalAdd(4, 2))  // Should print 6
        println(optionalAdd(-4, 2)) // Should print 2
        println(optionalAdd(4, -2)) // Should print None
        println(optionalAdd(-4, -2)) // Should print None
    }
}





