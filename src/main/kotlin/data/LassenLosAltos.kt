package data

import MyDate

class LassenLosAltos : TransactionData() {
    override val data = listOf(
        //unit 7
        MyDate(1987, 3, 26) to 185500,
        MyDate(1989, 2, 23) to 256000,
        MyDate(2012, 4, 11) to 542000,
        MyDate(2017, 9, 13) to 1450000,

        //unit 6
        MyDate(1988, 12, 9) to 216000,
        MyDate(1992, 9, 11) to 229000,
        MyDate(2005, 11, 4) to 585000,

        //unit 3
        MyDate(1980, 10, 2) to 164500,
        MyDate(1999, 9, 2) to 419000,
        MyDate(2009, 6, 19) to 575000,


    )
}