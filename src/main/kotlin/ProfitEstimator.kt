import java.time.LocalDate
import java.util.*

class ProfitEstimator(
    private val utils: Utils,
    private val costEstimator: CostEstimator,
    private val purchaseHousePrice: Double,
    private val capitalTaxRate: Double
) {

    private var numberOfYears: Int = 0
    private var estimateGrowthRate: Double = 0.0
    private lateinit var houseGrowthRateEstimator: HouseGrowthRateEstimator

    fun init(numberOfYears: Int, estimateGrowthRate: Double, houseGrowthRateEstimator: HouseGrowthRateEstimator) {
        this.numberOfYears = numberOfYears
        this.estimateGrowthRate = estimateGrowthRate
        this.houseGrowthRateEstimator = houseGrowthRateEstimator
    }

    fun getProfitReport(): ProfitAnalysisReport {
        val currentDate = LocalDate.now()
        val endDate = MyDate(
            year = currentDate.year + numberOfYears,
            month = currentDate.monthValue,
            day = currentDate.dayOfMonth
        )

        val estimatePrice = houseGrowthRateEstimator.estimateHousePrice(
            endDate = endDate,
            growthRate = estimateGrowthRate
        )

        val sellingFee = costEstimator.getSellingFee(sellingPrice = estimatePrice)

        val costEstimateReport = costEstimator.getCostEstimateReport(years = numberOfYears)

        // House profit
        val houseProfit = estimatePrice - purchaseHousePrice - sellingFee - costEstimateReport.totalFee
        val houseProfitPercent = getHouseProfit(houseProfit) / costEstimateReport.totalPaid

        // Stock profit
        val stockProfit =
            (costEstimateReport.totalInvestedInStock - costEstimateReport.totalStockCost) * (1 - capitalTaxRate)
        val stockProfitPercent = stockProfit / costEstimateReport.totalStockCost

        // Rent out
        val rentOutCostEstimateReport = costEstimator.getRentOutTotalFee(years = numberOfYears)

        // Rent out house profit
        val rentOutHouseProfit = estimatePrice - purchaseHousePrice - sellingFee - rentOutCostEstimateReport.totalFee + rentOutCostEstimateReport.totalRentReceived
        val rentOutHouseProfitPercent = rentOutHouseProfit / rentOutCostEstimateReport.totalPaid

        val profitAnalysisReport = ProfitAnalysisReport(
            targetPrice = estimatePrice,
            houseProfit = houseProfit,
            houseProfitPercent = houseProfitPercent,
            stockProfit = stockProfit,
            stockProfitPercent = stockProfitPercent,
            rentOutProfit = rentOutHouseProfit,
            rentOutProfitPercent = rentOutHouseProfitPercent
        )

        return profitAnalysisReport

    }

    fun getHouseProfit(profit:Double): Double {
        val taxExempt = 250000

        return if (profit <= taxExempt) profit
        else {
            taxExempt + (profit - taxExempt)*(1-capitalTaxRate)
        }
    }


}

data class ProfitAnalysisReport(
    var targetPrice: Double = 0.0,
    var houseProfit: Double = 0.0,
    var houseProfitPercent: Double = 0.0,
    var stockProfit: Double = 0.0,
    var stockProfitPercent: Double = 0.0,
    var rentOutProfit: Double = 0.0,
    var rentOutProfitPercent: Double = 0.0
)