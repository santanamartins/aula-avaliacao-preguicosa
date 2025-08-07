
package callByValue

/*
 * This file demonstrates call-by-value in Scala.
 * All arguments are evaluated before the function is called.
 */

def add(x: Int, y: Int): Int = {
    println("add body started")
    // x and y have already been computed before entering this function
    println(s"Computing: $x + $y")
    x + y
}

// Simulates an expensive computation
def expensiveComputation(n: Int): Int = {
    println(s"Expensive computation for $n")
    Thread.sleep(1000) // Simulates a costly computation
    n * n
}

@main def testCallByValue = {
    println("=== Call by Value Example ===")
    println("Before calling add...")
    // Both expensiveComputation(3) and expensiveComputation(4) are evaluated before 'add' is called
    val result = add(expensiveComputation(3), expensiveComputation(4))
    println(s"Result: $result")
}

