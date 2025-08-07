

package callByNeed

/*
 * This file demonstrates different parameter evaluation strategies (call-by-value, call-by-name, call-by-need)
 * using division as an example.
 * When running each version, you will notice that the by-need version performs the least amount of evaluations.
 */

// Example: division with value parameters (not lazy)
def divideByValue(x: Int, y: Int): Option[Int] = {
  println("Started division...")
  if (y == 0) None else Some(x / y)
}

// Example: division with by-name parameters (call-by-name)
def divideByName(x: => Int, y: => Int): Option[Int] = {
  println("Started division...")
  if (y == 0) None else Some(x / y)
}

// Example: division with call-by-need (memoized by-name)
def divideByNeed(x: => Int, y: => Int): Option[Int] = {
  println("Started division...")
  lazy val cachedX = x // call-by-need
  lazy val cachedY = y // call-by-need
  if (cachedY == 0) None else Some(cachedX / cachedY)
}

@main def testSquare = {

  def longProcess(x: Int): Int = {
    println("Long process running...")
    Thread.sleep(1000) // Simulate a long computation
    x
  }

  println("Testing divideByValue:")
  println(divideByValue(longProcess(10), longProcess(2))) // Should print Some(5)
  println(divideByValue(longProcess(10), longProcess(0))) // Should print None

  println()
  println("Testing divideByName:")
  println(divideByName(longProcess(10), longProcess(2))) // Should print Some(5)
  println(divideByName(longProcess(10), longProcess(0))) // Should print None

  println()
  println("Testing divideByNeed:")
  println(divideByNeed(longProcess(10), longProcess(2))) // Should print Some(5)
  println(divideByNeed(longProcess(10), longProcess(0))) // Should print None
}
