
package callByName

/*
 * This file demonstrates the difference between call-by-name and call-by-value in Scala.
 * It shows two approaches: using function parameters (with parentheses) and by-name parameters (without parentheses).
 */

package withParentheses {
    // 'add' takes two functions as parameters (call-by-name simulation)
    def add(x: () => Int, y: () => Int): Int = {
        println("add body started")
        // Each time x() or y() is called, the computation is performed again.
        println(s"Computing: ${x()} + ${y()}")
        x() + y()
    }

    // Simulates an expensive computation
    def expensiveComputation(n: Int): Int = {
        println(s"Expensive computation for $n")
        Thread.sleep(1000) // Simulates a costly computation
        n * n
    }

    @main def testCallByName = {
        println("Before calling add...")
        // Passes functions as arguments (lambdas)
        val result = add(() => expensiveComputation(3), () => expensiveComputation(4))
        println(s"Result: $result")
    }
}

package withoutParentheses {
    // 'add' takes by-name parameters (call-by-name)
    def add(x: => Int, y: => Int): Int = {
        println("add body started")
        // Each time x or y is used, the computation is performed again.
        println(s"Computing: $x + $y")
        x + y
    }

    // Simulates an expensive computation
    def expensiveComputation(n: Int): Int = {
        println(s"Expensive computation for $n")
        Thread.sleep(1000) // Simulates a costly computation
        n * n
    }

    @main def testCallByName = {
        println("Before calling add...")
        // Passes expressions directly; they are evaluated each time they are used in 'add'.
        val result = add(expensiveComputation(3), expensiveComputation(4))
        println(s"Result: $result")
    }
}



