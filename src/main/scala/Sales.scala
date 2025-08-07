

package sales

/*
 * This file demonstrates the use of lazy values in a real-world context (sales report).
 * Expensive calculations (sum, average, max) are only performed if needed, and only once.
 */

case class SalesReport(sales: List[Double]) {
    // Lazy value: total sales are only calculated if accessed
    lazy val totalSales: Double = {
        println("Calculating total sales...")
        sales.sum
    }
    // Lazy value: average sales, depends on totalSales
    lazy val averageSales: Double = {
        println("Calculating average sales...")
        if (sales.isEmpty) 0.0 else totalSales / sales.size
    }
    // Lazy value: biggest sale
    lazy val biggestSale: Option[Double] = {
        println("Finding biggest sale...")
        if (sales.isEmpty) None else Some(sales.max)
    }
}

def printReport(report: SalesReport): Unit = {
    // Accesses lazy values; calculations are performed only once per report
    println(s"Total Sales: ${report.totalSales}")
    println(s"Average Sales: ${report.averageSales}")
    report.biggestSale match {
        case Some(sale) => println(s"Biggest Sale: $sale")
        case None => println("No sales data available.")
    }
}

@main def run = {
    val report = new SalesReport(List(100.0, 200.0, 300.0))

    println("Sales report created.")
    println("First report...")
    printReport(report)
    println("Second report...")
    printReport(report)
}