import data.TransactionData

class CompositionRoot {

    // House info
    var housePurchasePrice = 800000.0
    var HOA = 544.0

    // Loan info
    var yearsOfLoan = 30
    var interestRate30Years = 0.03125
    var interestRate7Years = 0.025

    // Basic constant
    var houseInsuranceRate = 0.0022
    var propertyTaxRate = 0.012
    var downPaymentRate = 0.2
    var incomeTaxRate = 0.41
    var capitalTaxRate = 0.15 + 0.093

    // Estimate
    var stockGrowthRate = 0.1
    var houseGrowthRate = 0.05
    var houseSellingFeeRate = 0.1
    var hoaGrowthRate = 0.034
    var rentGrowthRate = 0.02
    var rentOutRentGrowthRate = 0.02

    // Cost
    var monthlyRent = 2200.0

    // Rent out
    var rentOutRent = 2500.0
    var rentOutPropertyManagementFee = 0.08

    // Property transaction history for evaluation
    var houseEarliesRecordDate = MyDate(0, 0, 0)
    var houseEarliesRecordPrice: Double = 0.0
    var houseCurrentDate = MyDate(0, 0, 0)
    var houseCurrentPrice: Double = 0.0
    var houseTransactionData: TransactionData? = null

    // Profit estimate
    var numberOfYearsHolding = 5


    val interestRate get() = if (yearsOfLoan == 30) interestRate30Years else interestRate7Years
    val monthlyHouseInsuranceFee get() = housePurchasePrice * houseInsuranceRate / 12
    val monthlyPropertyTax get() = housePurchasePrice * propertyTaxRate / 12
    val downPayment get() = housePurchasePrice * downPaymentRate
    val loanTotal get() = housePurchasePrice - downPayment
    val firstMonthInterestFee get() = loanTotal * interestRate / 12

    val firstMonthFeeNoTaxDeduction
        get() = firstMonthInterestFee +
                monthlyPropertyTax +
                HOA +
                monthlyHouseInsuranceFee

    val firstMonthInterestDeduction
        get() = utils.getMonthlyInterestDeduction(
            loanTotal = loanTotal,
            monthlyInterest = firstMonthInterestFee,
            incomeTaxRate = incomeTaxRate,
            interestRate = interestRate
        )

    val firstMonthFeeWithTaxDeduction get() = firstMonthFeeNoTaxDeduction - firstMonthInterestDeduction

    val monthlyMortgagePayment
        get() = utils.getMonthlyMortgagePayment(
            loanTotal = loanTotal,
            interestRate = interestRate,
            years = yearsOfLoan
        )

    val firstMonthPayToTheProperty get() = monthlyMortgagePayment - firstMonthInterestFee

    val monthlyHoaGrowthRate get() = utils.getRootOf(hoaGrowthRate + 1, 12.0) - 1
    val monthlyRentGrowRate get() = utils.getRootOf(rentGrowthRate + 1, 12.0) - 1
    val monthlyHouseGrowRate get() = utils.getRootOf(houseGrowthRate + 1, 12.0) - 1
    val monthlyInsuranceGrowRate get() = monthlyHouseGrowRate
    val monthlyStockGrowthRate get() = utils.getRootOf(stockGrowthRate + 1, 12.0) - 1
    val monthlyRentOutRentGrowthRate get() = utils.getRootOf(rentOutRentGrowthRate + 1, 12.0) - 1

    val utils by lazy { Utils() }

    val houseGrowthRateEstimator
        get() = HouseGrowthRateEstimator(utils)

    val profitEstimator
        get() = ProfitEstimator(
            utils = utils,
            costEstimator = costEstimator,
            purchaseHousePrice = housePurchasePrice,
            capitalTaxRate = capitalTaxRate
        )

    val costEstimator
        get() = CostEstimator(
            utils = utils,
            houseSellingFeeRate = houseSellingFeeRate,
            loanTotal = loanTotal,
            interestRate = interestRate,
            incomeTaxRate = incomeTaxRate,
            monthlyHoaGrowthRate = monthlyHoaGrowthRate,
            monthlyRentGrowthRate = monthlyRentGrowRate,
            monthlyMortgagePayment = monthlyMortgagePayment,
            hoa = HOA,
            monthlyInsuranceFee = monthlyHouseInsuranceFee,
            monthlyInsuranceGrowthRate= monthlyInsuranceGrowRate,
            monthlyPropertyTax = monthlyPropertyTax,
            monthlyStockGrowthRate = monthlyStockGrowthRate,
            monthlyRent = monthlyRent,
            rentOutRent = rentOutRent,
            monthlyRentOutRentGrowthRate = monthlyRentOutRentGrowthRate,
            rentOutPropertyManagementFee = rentOutPropertyManagementFee
        )

    val linearRegressionEstimator
        get() = LinearRegressionEstimator(utils = utils, houseTransactionData = houseTransactionData)


}