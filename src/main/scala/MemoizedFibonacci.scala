
package memoizedFibonacci

/*
 * This file demonstrates memoization (caching) in the computation of Fibonacci numbers.
 * The result of each Fibonacci calculation is stored, so repeated calls are fast.
 * As result, we have a lazily infinite sequence of Fibonacci numbers.
 */

import scala.collection.mutable

object Fibonacci {
    // 'memo' stores previously computed Fibonacci values
    private val memo: mutable.Map[Int, Int] = mutable.Map()

    def apply(n: Int): Int = {
        if (n <= 1) return n
        // If 'n' is not in the cache, compute and store it
        memo.getOrElseUpdate(n, {
            println(s"Computing F($n) (thunk evaluation)...")
            apply(n - 1) + apply(n - 2)
        })
    }
}

@main def testMemoizedFibonacci = {
    // The first call will compute and cache values
    println(Fibonacci(4))
    // The second call will reuse cached values
    println(Fibonacci(5))
}