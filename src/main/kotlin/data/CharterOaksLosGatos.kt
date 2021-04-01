package data

import MyDate

class CharterOaksLosGatos : TransactionData() {
    override val data = listOf(
        //unit 109
        MyDate(2009, 3, 2) to 665000,
        MyDate(1978, 7, 1) to 88000,

        //200
        MyDate(2006, 3, 23) to 735000,
        MyDate(2021, 1, 28) to 1200000,

        // 107 Cherry hill
        MyDate(1977, 2, 1) to 65000,
        MyDate(2003, 6, 19) to 510000,
        MyDate(2019, 10, 21) to 1150000,

        // 127 spruce hill
        MyDate(1988, 4, 29) to 179000,
        MyDate(1995, 4, 11) to 220000,
        MyDate(2000, 8, 15) to 515000,
        MyDate(2008, 4, 9) to 760000,
        MyDate(2011, 7, 21) to 650000,
        MyDate(2016, 8, 16) to 1075000,
    )
}