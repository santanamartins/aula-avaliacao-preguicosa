
/*
 * This example demonstrates how value bindings work in Scala.
 * Each 'val' is evaluated when it is defined, and the result is stored.
 * The print statements help visualize the order of evaluation.
 */

@main def run = {
    // 'x' is defined by evaluating the block below.
    val x = {
        println("Defining x") // This will print when 'x' is being bound.
        10 // The value assigned to 'x'.
    }
    println("Binding of x complete") // Shows that 'x' is now available.

    // 'y' depends on 'x'.
    val y = {
        println("Defining y") // This will print when 'y' is being bound.
        x + 5 // Uses the value of 'x'.
    }
    println("Binding of y complete") // Shows that 'y' is now available.
    println(x) // Prints the value of 'x'.
    println(y) // Prints the value of 'y'.
}