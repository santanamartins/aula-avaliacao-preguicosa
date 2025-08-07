
/*
 * This file demonstrates searching for prime numbers using both strict and lazy evaluation.
 */

def isPrime(n: Int): Boolean = {
  println(s"Checking if $n is prime...") // Shows when primality is checked
  n >= 2 && (2 to math.sqrt(n).toInt).forall(n % _ != 0)
}

def range(start: Int, end: Int): List[Int] = {
    if (start > end) Nil
    else {
      println(s"Generating number $start") // Shows when each number is generated
      start :: range(start + 1, end)
    }
}

def kPrimesInRange(start: Int, end: Int, k: Int): List[Int] = {
  println(s"Finding first $k primes in range [$start, $end]")
  // Strict (eager) search for the first k primes in the range
  range(start, end)
    .filter(isPrime)
    .take(k)
    .toList
}

@main def testKPrimesInRange(): Unit = {
  // Test strict (eager) search
  println(kPrimesInRange(1, 15, 5)) // Should print first 5 primes in range
}

def rangeLazy(start: Int, end: Int): LazyList[Int] = {
  if (start > end) LazyList.empty
  else {
    println(s"Generating number $start") // Shows when each number is generated (lazily)
    start
  } #:: rangeLazy(start + 1, end)
}

def kPrimesInRangeLazy(start: Int, end: Int, k: Int): LazyList[Int] = {
  println(s"Finding first $k primes in range [$start, $end]")
  // Lazy search for the first k primes in the range
  rangeLazy(start, end)
    .filter(isPrime)
    .take(k)
}

@main def testLazyPrimes(): Unit = {
  // Test lazy search
  println(kPrimesInRangeLazy(1, 15, 5).toList) // Should print first 5 primes in range
}

