import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.math.pow


class Utils {

    private val MAX_LOAN_DEDUCTION_AMOUNT = 750000
    val houseInsuranceRate = 0.0022
    val propertyTaxRate = 0.012
    val downPaymentRate = 0.2

    fun getMonthlyInterestWithTaxDeduction(
        loanTotal: Double,
        monthlyInterest: Double,
        incomeTaxRate: Double,
        interestRate: Double
    ): Double {
        return monthlyInterest - getMonthlyInterestDeduction(loanTotal, monthlyInterest, incomeTaxRate, interestRate)
    }

    fun getMonthlyInterestDeduction(
        loanTotal: Double,
        monthlyInterest: Double,
        incomeTaxRate: Double,
        interestRate: Double
    ): Double {
        return if (loanTotal > MAX_LOAN_DEDUCTION_AMOUNT) {
            MAX_LOAN_DEDUCTION_AMOUNT * interestRate * incomeTaxRate / 12
        } else {
            monthlyInterest * incomeTaxRate
        }
    }

    fun getMonthlyPropertyDeduction(propertyTax: Double) = 0
    fun getMonthlyPropertyWithTaxDeduction(propertyTax: Double): Double {
        return propertyTax / 12 - getMonthlyPropertyDeduction(propertyTax)
    }

    fun getMonthlyMortgagePayment(loanTotal: Double, interestRate: Double, years: Int): Double {
        val P = loanTotal
        val i = interestRate / 12
        val n = years * 12

        return P * i * (1 + i).pow(n) / ((1 + i).pow(n) - 1)
    }

    fun getHouseGrowthRate(startYear: Double, startPrice: Double, endYear: Double, endPrice: Double): Double {
        val profitPercent = endPrice / startPrice
        return getRootOf(profitPercent, endYear - startYear)
    }

    fun getRootOf(number: Double, root: Double) = number.pow(1 / root)

    fun getCompoundPrice(startPrice: Double, growthRate: Double, years: Double): Double {
        return startPrice * (1 + growthRate).pow(years)
    }

    fun getCompoundPrice(startPrice: Double, monthlyAdding:Double, growthRate: Double, years: Double): Double {
        val months = years*12
        var principle = startPrice
        val monthlyGrowthRate = getRootOf(growthRate+1,12.0)
        println(monthlyGrowthRate)
        for (i in 1..months.toInt()){
            principle += monthlyAdding
            principle *= monthlyGrowthRate
        }
        println("months:${months}")
        return principle
    }

    fun getHouseInsuranceFee(housePrice: Int) = housePrice * houseInsuranceRate
    fun getPropertyTaxFee(housePrice: Int) = housePrice * propertyTaxRate
    fun getDownPayment(housePrice: Int) = housePrice * downPaymentRate

    fun getYearsDiff(startDate: MyDate, endDate: MyDate): Double {
        val start = LocalDate.of(startDate.year, startDate.month, startDate.day)
        val end = LocalDate.of(endDate.year, endDate.month, endDate.day)
        val years = ChronoUnit.DAYS.between(start,end)/365.0

        return years
    }

}