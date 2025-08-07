
package lazyexample

/*
 * This file demonstrates the difference between eager and lazy evaluation in Scala.
 */

def inc(x: Int): Int = {
    println("Applying inc to " + x) // Shows when the function is actually called
    x + 1
}

@main def run = {
    // Eager evaluation: 'inc(10)' is called immediately
    val eagerVal = inc(10)
    println("Binding eagerVal finished")
    println("Eager value: " + eagerVal)

    println()

    // Lazy evaluation: 'inc(20)' is not called until 'lazyVal' is accessed
    lazy val lazyVal = inc(20)
    println("Binding lazyVal finished")
    println("Accessing lazy value: " + lazyVal)
}