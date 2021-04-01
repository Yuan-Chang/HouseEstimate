import java.util.*

class HouseGrowthRateEstimator(private val utils: Utils) {

    lateinit var startDate: MyDate
    private var startPrice: Double = 0.0

    fun init(startDate: MyDate, startPrice: Double) {
        this.startDate = startDate
        this.startPrice = startPrice
    }

    fun calculateGrowthRate(endDate: MyDate, endPrice: Double): Double {
        val years = utils.getYearsDiff(startDate = startDate, endDate = endDate)
        val profitPercent = endPrice / startPrice

        return utils.getRootOf(profitPercent, years)
    }

    fun estimateHousePrice(numberOfYears: Double, growthRate: Double): Double {
        return utils.getCompoundPrice(startPrice = startPrice, growthRate = growthRate, years = numberOfYears)
    }

    fun estimateHousePrice(endDate: MyDate, growthRate: Double): Double {
        val years = utils.getYearsDiff(startDate = startDate, endDate = endDate)
        return utils.getCompoundPrice(startPrice = startPrice, growthRate = growthRate, years = years)
    }
}