import data.TransactionData
import org.nield.kotlinstatistics.simpleRegression

class LinearRegressionEstimator(val utils: Utils, val houseTransactionData: TransactionData?) {
    fun getReport(startDate: MyDate = MyDate(1000, 1, 1), endDate: MyDate = MyDate.now()): LinearRegressionReport? {

        if (houseTransactionData == null) return null

        val data = houseTransactionData.data.filter { it.first.toTime() > startDate.toTime() && it.first.toTime() < endDate.toTime() }
        val earliestDate = data.minBy { it.first.toDate().time }!!.first
        val earliestTime = earliestDate.toDate().time

        val mappingData =
            data.map {
                it.first.toDate().time - earliestTime to it.second
//                it.first.year.toLong() to it.second
            }

        val regression = mappingData.simpleRegression(xSelector = { it.first }, ySelector = { it.second })

        val slop = regression.slope
        val today = MyDate.now()
        val intercept = regression.intercept
        val estimateTodayPrice = slop * (today.toDate().time - earliestTime) + intercept
        val dataSize = mappingData.size

        val yearsDiff = utils.getYearsDiff(earliestDate, endDate)
        val growthRate = utils.getRootOf(estimateTodayPrice / intercept, yearsDiff) - 1

        return LinearRegressionReport(
            earliestDate = earliestDate,
            estimateTodayPrice = estimateTodayPrice,
            intercept = intercept,
            growthRate = growthRate,
            slop = slop,
            dateSize = dataSize,
            yearsPeriod = yearsDiff,
            data = mappingData
        )
    }

    fun printPythonPlotData(data: List<Pair<Long, Int>>){
        data.forEach {
            println("[${it.first},${it.second}],")
        }
    }
}

data class LinearRegressionReport(
    var earliestDate: MyDate,
    var estimateTodayPrice: Double,
    var growthRate: Double,
    var intercept: Double,
    var slop: Double,
    var dateSize: Int,
    var yearsPeriod: Double,
    var data: List<Pair<Long, Int>>
)