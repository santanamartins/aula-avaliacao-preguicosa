
package lazyListBasics

/*
 * This file demonstrates the use of LazyList in Scala.
 * LazyList allows elements to be computed only when needed (lazy evaluation).
 */

def expensiveElement(n: Int): Int = {
    println(s"🔄 Computing element $n...") // Shows when each element is actually computed
    Thread.sleep(500) // Simulates a costly computation
    n * n
}

// Create a LazyList of expensive elements
val lazyNumbers = expensiveElement(1) 
    #:: expensiveElement(2) 
    #:: expensiveElement(3) 
    #:: expensiveElement(4) 
    #:: expensiveElement(5) 
    #:: LazyList.empty[Int]

@main def run = {
    println("First access to lazyNumbers:")
    // The elements are computed as they are accessed
    lazyNumbers.foreach{ n =>
        println(s"Element: $n")
    }
    println("Second access to lazyNumbers:")
    // The elements are not recomputed; LazyList caches them
    lazyNumbers.foreach{ n =>
        println(s"Element: $n")
    }
}