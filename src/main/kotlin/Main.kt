import data.*
import java.time.LocalDate

fun main(args: Array<String>) {

//    losGatosTownHouse()
    val year = 5
//    cypressMountainViewCondo1b(year = year, myHouseGrowthRate = 0.0531)
    cypressMountainViewCondo(year = year, myHouseGrowthRate = 0.06)
//    OrtegaMountainView(year = year,myHouseGrowthRate = 0.083)


    // Quick test something
    val houseGrowthRateEstimator = HouseGrowthRateEstimator(Utils())
//    houseGrowthRateEstimator.init(startDate = MyDate(1978,7,1), startPrice = 88000.0)
//    val estimateGrowthRate = houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate.now(), endPrice = 1195000.0) - 1
//    val estimatePrice = houseGrowthRateEstimator.estimateHousePrice(endDate = MyDate(2021,3,22), growthRate = 0.1023067561116291)
//
//
//    println("\n\n==================================")
////    println("estimatePrice:$estimatePrice")
//    println("growthRate:$estimateGrowthRate")
//
//    houseGrowthRateEstimator.init(startDate = MyDate(1977,2,1), startPrice = 65000.0)
//    println("growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2019,10,21), endPrice = 1150000.0) - 1}")
//
//    houseGrowthRateEstimator.init(startDate = MyDate(1988, 4, 29), startPrice = 179000.0)
//    println("growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2016, 8, 16), endPrice = 1075000.0) - 1}")
//
//    houseGrowthRateEstimator.init(startDate = MyDate(1991, 3, 15), startPrice = 230000.0)
//    println("growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2020, 5, 22), endPrice = 1260000.0) - 1}")
//
//    houseGrowthRateEstimator.init(startDate = MyDate(1994, 12, 1), startPrice = 230000.0)
//    println("growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2013, 10, 10), endPrice = 750000.0) - 1}")
//
//    houseGrowthRateEstimator.init(startDate = MyDate(1994, 12, 1), startPrice = 230000.0)
//    println("growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2020, 11, 12), endPrice = 1240000.0) - 1}")
//
//    houseGrowthRateEstimator.init(startDate = MyDate(1973, 11, 9), startPrice = 42500.0)
//    println("growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2020, 2, 27), endPrice = 1275000.0) - 1}")
//
//    houseGrowthRateEstimator.init(startDate = MyDate(2007, 1, 6), startPrice = 785000.0)
//    println("growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2017, 5, 22), endPrice = 1110000.0) - 1}")
//
//    houseGrowthRateEstimator.init(startDate = MyDate(1977, 7, 21), startPrice = 84000.0)
//    println("growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2020, 7, 7), endPrice = 1270000.0) - 1}")
//
    houseGrowthRateEstimator.init(startDate = MyDate(1992,10,6), startPrice = 150000.0)
    println("M 1992 now 830000 growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate.now(), endPrice = 830000.0) - 1}")
    println("M 1992 now 850000 growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate.now(), endPrice = 850000.0) - 1}")
    println("M 1992 2017 purchase growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2017,9,15), endPrice = 911000.0) - 1}")
    println("M 1992 2009 purchase growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2009,7,24), endPrice = 415500.0) - 1}")
    println("M 1992 2008 purchase growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2008,4,8), endPrice = 455000.0) - 1}")
    println("M 1992 2012 purchase growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2012,5,1), endPrice = 405000.0) - 1}")
    println("M 1992 2013 purchase growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2013,1,9), endPrice = 450000.0) - 1}")

    //mid point 0.063

//    houseGrowthRateEstimator.init(startDate = MyDate(1994,10,19), startPrice = 174000.0)
//    println("M ort 1994 now growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate.now(), endPrice = 1050000.0) - 1}")
//    println("M ort 2017 now growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2017, 11, 7), endPrice = 1100000.0) - 1}")
//    println("M ort 2009 now growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2009, 10, 28), endPrice = 545000.0) - 1}")
//    println("M ort 2010 now growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2010, 12, 10), endPrice = 470000.0) - 1}")
//    println("M ort 2012 now growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate(2012, 2, 22), endPrice = 510000.0) - 1}")

    //mid point: 0.073

//    houseGrowthRateEstimator.init(startDate = MyDate(1988,4,25), startPrice = 164000.0)
//    println("M cupertino 1988 now growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate.now(), endPrice = 1100000.0) - 1}")
//
//    houseGrowthRateEstimator.init(startDate = MyDate(1978,7,1), startPrice = 88000.0)
//    println("M los gatos 1988 now growthRate:${houseGrowthRateEstimator.calculateGrowthRate(endDate = MyDate.now(), endPrice = 1200000.0) - 1}")

    val utils = Utils()
    println(utils.getCompoundPrice(startPrice = 0.0,monthlyAdding = 210.0,0.08,8.79))

}

fun OrtegaMountainView(year: Int = 10, myHouseGrowthRate: Double = 0.073) {
    println("\n\nOrt condo")
    val purchaseEvaluate = PurchaseEvaluation()
    purchaseEvaluate.init().apply {
        // Set the purchase price
        housePurchasePrice = 1050000.0

        // GrowthRate estimate
        // House transaction record
        houseEarliesRecordDate = MyDate(1994,10,19)
        houseEarliesRecordPrice = 174000.0

        houseCurrentDate = MyDate.now()
        houseCurrentPrice = housePurchasePrice

        // Tune values
        numberOfYearsHolding = year
        interestRate30Years = 0.03125
        monthlyRent = 2200.0
        houseGrowthRate = myHouseGrowthRate
        stockGrowthRate = 0.15
        rentOutRent = 2600.0
        HOA = 482.0

        // Transaction history data
        houseTransactionData = Ort505Mountainview()

    }
    purchaseEvaluate.start()
}

fun losGatosTownHouse(year: Int = 10){
    println("\n\nLos Gatos condo")
    val housePurchase = PurchaseEvaluation()
    housePurchase.init().apply {
        // Set the purchase price
        housePurchasePrice = 1200000.0

        // GrowthRate estimate
        // House transaction record
        houseEarliesRecordDate = MyDate(1978,7,1)
        houseEarliesRecordPrice = 88000.0

        houseCurrentDate = MyDate.now()
        houseCurrentPrice = housePurchasePrice

        // Tune values
        numberOfYearsHolding = year
        interestRate30Years = 0.03125
        monthlyRent = 2200.0
        houseGrowthRate = 0.063
        stockGrowthRate = 0.1
        rentOutRent = 2500.0
        HOA = 497.0

        // Transaction history data
        houseTransactionData = CharterOaksLosGatos()

    }
    housePurchase.start()
}

fun cypressMountainViewCondo(year: Int = 10, myHouseGrowthRate: Double = 0.063){
    println("\n\nMountain view condo")
    val mountainViewCondo = PurchaseEvaluation()
    mountainViewCondo.init().apply {
        // Set the purchase price
        housePurchasePrice = 850000.0

        // GrowthRate estimate
        // House transaction record
//        houseEarliesRecordDate = MyDate(2001,7,4)
//        houseEarliesRecordPrice = 320000.0
//        MyDate(1992,10,6) to 150000,

//        MyDate(1994,6,9) to 142000,
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

    //house model => https://www.redfin.com/CA/Mountain-View/505-Cypress-Point-Dr-94043/unit-203/home/1174517
}

fun cypressMountainViewCondo1b(year: Int = 10, myHouseGrowthRate: Double = 0.063){
    println("\n\nMountain view condo")
    val mountainViewCondo = PurchaseEvaluation()
    mountainViewCondo.init().apply {
        // Set the purchase price
        housePurchasePrice = 585000.0

        // GrowthRate estimate
        // House transaction record
//        houseEarliesRecordDate = MyDate(2001,7,4)
//        houseEarliesRecordPrice = 320000.0
//        MyDate(1992,10,6) to 150000,

//        MyDate(1994,6,9) to 142000,
        houseEarliesRecordDate = MyDate(1991,6,18)
        houseEarliesRecordPrice = 125000.0

        houseCurrentDate = MyDate.now()
        houseCurrentPrice = housePurchasePrice

        // Tune values
        numberOfYearsHolding = year
        interestRate30Years = 0.03125
        monthlyRent = 2200.0
        houseGrowthRate = myHouseGrowthRate
        stockGrowthRate = 0.15
        rentOutRent = 2000.0
        HOA = 477.0

        // Transaction history data
        houseTransactionData = CypressMountainView()

    }
    mountainViewCondo.start()

    //house model => https://www.redfin.com/CA/Mountain-View/505-Cypress-Point-Dr-94043/unit-203/home/1174517
}

fun lassenLosAltos(){
    println("\n\nLassen los altos condo\n======================================\n")
    val losAltosCondo = PurchaseEvaluation()
    losAltosCondo.init().apply {
        // Set the purchase price
        housePurchasePrice = 1200000.0

        // GrowthRate estimate
        // House transaction record
        houseEarliesRecordDate = MyDate(1987, 3, 26)
        houseEarliesRecordPrice = 185500.0
        houseCurrentDate = MyDate.now()
        houseCurrentPrice = housePurchasePrice

        // Tune values
        numberOfYearsHolding = 10
        interestRate30Years = 0.03125
        monthlyRent = 2200.0
        houseGrowthRate = 0.068
        stockGrowthRate = 0.1

        // Transaction history data
        houseTransactionData = LassenLosAltos()

    }
    losAltosCondo.start()
}

fun albertaSunnyvale(){
    println("\n\nAlberta condo\n======================================\n")
    val alberta = PurchaseEvaluation()
    alberta.init().apply {
        // Set the purchase price
        housePurchasePrice = 849000.0

        // GrowthRate estimate
        // House transaction record
        houseEarliesRecordDate = MyDate(1987, 12, 11)
        houseEarliesRecordPrice = 140000.0

        houseCurrentDate = MyDate.now()
        houseCurrentPrice = housePurchasePrice

        // Tune values
        numberOfYearsHolding = 5
        interestRate30Years = 0.03125
        monthlyRent = 2200.0
        houseGrowthRate = 0.05
        stockGrowthRate = 0.1
        rentOutRent = 2500.0

        // Transaction history data
        houseTransactionData = Alberta600Sunnyvale()

    }
    alberta.start()
}