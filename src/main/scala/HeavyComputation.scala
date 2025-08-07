package heavyComputation


def heavyComputation(): Int = {
    // This function simulates a very expensive computation.
    println("Performing heavy computation...")
    Thread.sleep(5000) // Simulate a long computation
    42 // The result of the computation
}

@main def run = {
    // 'cachedData' is a lazy value: heavyComputation() will only run if 'cachedData' is accessed
    lazy val cachedData = heavyComputation()
    // Randomly decide if we need the data
    val isDataNeeded = scala.util.Random.nextBoolean()

    if (isDataNeeded) {
        println("Data is needed, accessing cachedData...")
        println(s"Cached data: $cachedData") // Triggers computation if needed
        println(s"New access to cachedData: ${cachedData + 1}") // Uses cached value
    } else {
        println("Data is not needed, skipping access to cachedData.")
    }
}