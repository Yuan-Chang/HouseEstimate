class Info(housePrice: Int, utils: Utils) {

    val houseInsuranceRate = 0.0022
    val propertyTaxRate = 0.012
    val downPaymentRate = 0.2

    val yearsOfLoan = 30
    val interestRate = 0.03125

    val incomeTaxRate = 0.277
    val HOA = 544
    val houseGrowthRate = 0.05
    val stockGrowthRate = 0.1
    val monthlyRent = 2200

    val monthlyHouseInsuranceFee = housePrice * houseInsuranceRate / 12
    val monthlyPropertyTax = housePrice * propertyTaxRate / 12
    val downPayment = housePrice * downPaymentRate
    val loanTotal = housePrice - downPayment
    val firstMonthInterestFee = loanTotal * interestRate / 12

    val firstMonthFeeNoTaxDeduction = firstMonthInterestFee +
            monthlyPropertyTax +
            HOA +
            monthlyHouseInsuranceFee

    val firstMonthInterestDeduction = utils.getMonthlyInterestDeduction(
        loanTotal = loanTotal,
        monthlyInterest = firstMonthInterestFee,
        incomeTaxRate = incomeTaxRate,
        interestRate = interestRate
    )

    val firstMonthFeeWithTaxDeduction = firstMonthFeeNoTaxDeduction - firstMonthInterestDeduction

    val monthlyMortgagePayment = utils.getMonthlyMortgagePayment(
        loanTotal = loanTotal,
        interestRate = interestRate,
        years = yearsOfLoan
    )

    val firstMonthPayToTheProperty = monthlyMortgagePayment - firstMonthInterestFee

}