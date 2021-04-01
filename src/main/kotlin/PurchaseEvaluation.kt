import data.Alberta600Sunnyvale
import data.CharterOaksLosGatos
import data.CypressMountainView
import data.LassenLosAltos

class PurchaseEvaluation : Base() {

    val housePurchasePrice by lazy { compositionRoot.housePurchasePrice }
    val firstMonthFeeWithTaxDeduction by lazy { compositionRoot.firstMonthFeeWithTaxDeduction }
    val firstMonthFeeNoTaxDeduction by lazy { compositionRoot.firstMonthFeeNoTaxDeduction }
    val firstMonthPayToTheProperty by lazy { compositionRoot.firstMonthPayToTheProperty }
    val houseGrowthRateEstimator by lazy { compositionRoot.houseGrowthRateEstimator }
    val profitEstimator by lazy { compositionRoot.profitEstimator }
    val estimateHouseGrowthRate by lazy { compositionRoot.houseGrowthRate }

    val houseEarliesRecordDate by lazy { compositionRoot.houseEarliesRecordDate }
    val houseEarliesRecordPrice by lazy { compositionRoot.houseEarliesRecordPrice }
    val houseCurrentDate by lazy { compositionRoot.houseCurrentDate }
    val houseCurrentPrice by lazy { compositionRoot.houseCurrentPrice }
    val numberOfYearsHolding by lazy { compositionRoot.numberOfYearsHolding }
    val utils by lazy { compositionRoot.utils }
    val linearRegressionEstimator by lazy { compositionRoot.linearRegressionEstimator }
    val houseGrowthRate by lazy { compositionRoot.houseGrowthRate }

    fun init() = compositionRoot

    fun start() {

        println("First month fee with Tax deduction: ${firstMonthFeeWithTaxDeduction}")
        println("First month principle: ${firstMonthPayToTheProperty}")
        println("Total monthly payment ${firstMonthFeeWithTaxDeduction + firstMonthPayToTheProperty}")

        println("\nGrowth rate estimate\n==================================")

        houseGrowthRateEstimator.init(startDate = houseEarliesRecordDate, startPrice = houseEarliesRecordPrice)
        val purchasePriceGrowthRate =
            houseGrowthRateEstimator.calculateGrowthRate(endDate = houseCurrentDate, endPrice = houseCurrentPrice) - 1

        val years = utils.getYearsDiff(houseEarliesRecordDate, houseCurrentDate)
        println("${housePurchasePrice} purchase price $years years growth rate is ${purchasePriceGrowthRate}")

        println("\n\nProfit estimate $numberOfYearsHolding years. House growth rate: ${houseGrowthRate}\n=====================================")
        profitEstimator.init(
            numberOfYears = numberOfYearsHolding,
            estimateGrowthRate = estimateHouseGrowthRate,
            houseGrowthRateEstimator = houseGrowthRateEstimator
        )
        val profitReport = profitEstimator.getProfitReport()
        println("target selling price: ${profitReport.targetPrice}")
        println("house profit: ${profitReport.houseProfit} percent: ${profitReport.houseProfitPercent}")
        println("stock profit: ${profitReport.stockProfit} percent: ${profitReport.stockProfitPercent}")
        println("house profit if rent out: ${profitReport.rentOutProfit} percent: ${profitReport.rentOutProfitPercent}")

        // Linear regression analysis
        println("\nLinear regression estimate\n==================================")
        val linearRegressionReport = linearRegressionEstimator.getReport()
        linearRegressionReport?.let {
            println("estimate price: ${it.estimateTodayPrice}\n" +
                    "growthRate: ${it.growthRate}\n" +
                    "slop: ${it.slop}\n" +
                    "intercept: ${it.intercept}\n" +
                    "dataSize: ${it.dateSize}\n" +
                    "yearsPeriod:${it.yearsPeriod}"
            )
//            linearRegressionEstimator.printPythonPlotData(data = it.data)
        }


    }

}

