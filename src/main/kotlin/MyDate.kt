import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class MyDate(var year: Int, var month: Int, var day: Int) {

    constructor(date: Date) : this(0,0,0){
        val localeDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        year = localeDate.year
        month = localeDate.monthValue
        day = localeDate.dayOfMonth
    }

    fun toDate(): Date {
        val simpleDateFormat = SimpleDateFormat("yyyy-M-dd")
        return simpleDateFormat.parse("$year-$month-$day")
    }

    fun toTime(): Long {
        return this.toDate().time
    }

    override fun toString(): String {
        return "MyDate(year=$year, month=$month, day=$day)"
    }

    companion object {
        fun now(): MyDate {
            val currentDate = LocalDate.now()
            return MyDate(year = currentDate.year, month = currentDate.monthValue, day = currentDate.dayOfMonth)
        }
    }

}