class CostEstimator(
    private val utils: Utils,
    private val houseSellingFeeRate: Double,
    private val loanTotal: Double,
    private val interestRate: Double,
    private val incomeTaxRate: Double,
    private val hoa: Double,
    private val monthlyInsuranceFee: Double,
    private val monthlyHoaGrowthRate: Double,
    private val monthlyRentGrowthRate: Double,
    private val monthlyMortgagePayment: Double,
    private val monthlyInsuranceGrowthRate: Double,
    private val monthlyPropertyTax: Double,
    private val monthlyStockGrowthRate: Double,
    private val monthlyRent: Double,
    private val rentOutRent: Double,
    private val monthlyRentOutRentGrowthRate: Double,
    private val rentOutPropertyManagementFee: Double
) {

    fun getSellingFee(sellingPrice: Double) = sellingPrice * houseSellingFeeRate

    fun getCostEstimateReport(years: Int, taxDeduction: Boolean = true): CostEstimateReport {
        val months = years * 12

        var hoa = hoa
        var monthlyRent = monthlyRent
        var monthlyInsuranceFee = monthlyInsuranceFee
        var totalInterestPaid = 0.0
        var totalPrinciplePaid = 0.0
        var totalHoaPaid = 0.0
        var totalInsuranceFeePaid = 0.0
        var totalPropertyTaxPaid = 0.0
        var totalInvestedInStock = 0.0
        var totalStockCost = 0.0
        var loanRemain = loanTotal

        for (i in 1..months) {
            val monthlyInterest = getMonthlyInterest(loanRemain = loanRemain)
            val interestWithTaxDeduction = getInterestWithTaxDeduction(monthlyInterest)

            val interest = if (taxDeduction) {
                interestWithTaxDeduction
            } else {
                monthlyInterest
            }

            val principle = getMonthlyPrinciple(monthlyInterest = monthlyInterest)

            totalInterestPaid += interest
            totalHoaPaid += hoa
            totalInsuranceFeePaid += monthlyInsuranceFee
            totalPropertyTaxPaid += monthlyPropertyTax
            totalPrinciplePaid += principle

            val monthlyTotalPaid = interest + hoa + monthlyInsuranceFee + monthlyPropertyTax + principle

            // Deduct rent here if it is primary house
            totalInvestedInStock += (monthlyTotalPaid - monthlyRent)
            totalStockCost += monthlyTotalPaid

            hoa *= (1 + monthlyHoaGrowthRate)
            monthlyInsuranceFee *= (1 + monthlyInsuranceGrowthRate)
            monthlyRent *= (1 + monthlyRentGrowthRate)
            totalInvestedInStock *= (1 + monthlyStockGrowthRate)
            loanRemain -= principle

        }

        val costEstimateReport = CostEstimateReport(
            totalInterestPaid = totalInterestPaid,
            totalPrinciplePaid = totalPrinciplePaid,
            totalHoaPaid = totalHoaPaid,
            totalInsuranceFeePaid = totalInsuranceFeePaid,
            totalPropertyTaxPaid = totalPropertyTaxPaid,
            totalFee = totalInterestPaid + totalHoaPaid + totalInsuranceFeePaid + totalPropertyTaxPaid,
            totalInvestedInStock = totalInvestedInStock,
            totalStockCost = totalStockCost
        )

        costEstimateReport.apply {
            totalPaid = totalFee + totalPrinciplePaid
        }

        return costEstimateReport

    }

    fun getRentOutTotalFee(years: Int): RentOutCostEstimateReport {
        val months = years * 12

        var hoa = hoa
        var monthlyInsuranceFee = monthlyInsuranceFee
        var rentOutRent = rentOutRent
        var rentOutTotalFee = 0.0
        var loanRemain = loanTotal
        var totalRentOutRent = 0.0
        var totalPaid = 0.0
        var monthlyRent = monthlyRent

        for (i in 1..months) {
            val monthlyInterest = getMonthlyInterest(loanRemain = loanRemain)
            val interestWithTaxDeduction = getInterestWithTaxDeduction(monthlyInterest)
            val principle = getMonthlyPrinciple(monthlyInterest = monthlyInterest)

            val managementFee = rentOutRent*rentOutPropertyManagementFee

            val rentOutFee =
                interestWithTaxDeduction + deductTax(hoa + monthlyInsuranceFee + monthlyPropertyTax + managementFee) + monthlyRent

            rentOutTotalFee += rentOutFee
            totalRentOutRent += deductTax(rentOutRent)
            totalPaid += (rentOutFee + principle)

            hoa *= (1 + monthlyHoaGrowthRate)
            monthlyInsuranceFee *= (1 + monthlyInsuranceGrowthRate)
            rentOutRent *= (1 + monthlyRentOutRentGrowthRate)
            monthlyRent *= (1 + monthlyRentGrowthRate)
            loanRemain -= principle

        }

        return RentOutCostEstimateReport(
            totalFee = rentOutTotalFee,
            totalPaid = totalPaid,
            totalRentReceived = totalRentOutRent
        )

    }

    private fun deductTax(amount: Double) = amount * (1 - incomeTaxRate)
    private fun getMonthlyInterest(loanRemain: Double) = loanRemain * interestRate / 12
    private fun getInterestWithTaxDeduction(monthlyInterest:Double) = utils.getMonthlyInterestWithTaxDeduction(
        loanTotal = loanTotal,
        monthlyInterest = monthlyInterest,
        incomeTaxRate = incomeTaxRate,
        interestRate = interestRate
    )
    private fun getMonthlyPrinciple(monthlyInterest: Double) = monthlyMortgagePayment - monthlyInterest

    data class CostEstimateReport(
        var totalInterestPaid: Double = 0.0,
        var totalPrinciplePaid: Double = 0.0,
        var totalHoaPaid: Double = 0.0,
        var totalInsuranceFeePaid: Double = 0.0,
        var totalPropertyTaxPaid: Double = 0.0,
        var totalFee: Double = 0.0,
        var totalPaid: Double = 0.0,
        var totalInvestedInStock: Double = 0.0,
        var totalStockCost: Double = 0.0
    )

    data class RentOutCostEstimateReport(
        var totalFee: Double = 0.0,
        var totalPaid: Double = 0.0,
        var totalRentReceived: Double = 0.0
    )

}