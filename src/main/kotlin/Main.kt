import data.*
import java.time.LocalDate

fun main(args: Array<String>) {


    val year = 5
    cypressMountainViewCondo(year = year, myHouseGrowthRate = 0.06)

}

fun cypressMountainViewCondo(year: Int = 10, myHouseGrowthRate: Double = 0.063){
    println("\n\nMountain view condo")
    val mountainViewCondo = PurchaseEvaluation()
    mountainViewCondo.init().apply {
        // Set the purchase price
        housePurchasePrice = 850000.0

        // GrowthRate estimate
        houseEarliesRecordDate = MyDate(1992,10,6)
        houseEarliesRecordPrice = 150000.0

        houseCurrentDate = MyDate.now()
        houseCurrentPrice = housePurchasePrice

        // Tune values
        numberOfYearsHolding = year
        interestRate30Years = 0.02875
        monthlyRent = 2200.0
        houseGrowthRate = myHouseGrowthRate
        stockGrowthRate = 0.1
        rentOutRent = 2600.0
        HOA = 544.0

        // Transaction history data
        houseTransactionData = CypressMountainView()

    }
    mountainViewCondo.start()
}