import kotlin.Comparable

data class Date(val year: Int, val month: Int, val day: Int) : Comparable<Date>, Comparator<Date>{
    override operator fun compareTo(other: Date) : Int = when {
		year != other.year -> year - other.year
		month != other.month -> month - other.month
		else -> day - other.day
	}

    override fun compare(p0: Date, p1: Date): Int = when{
		year != p0.year -> year - p1.year
		month != p0.month -> month - p1.month
		else -> p0.day - p1.day
    }

}

fun Date.checkLeap(): Boolean {
    if (this.year % 4 == 0) {
        if (this.year % 100 == 0 && this.year % 400 != 0) return true
    }
    return false
}

fun Date.vailidDate(): Boolean {
    val dates = listOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    if (this.month > 12 || this.month < 1) return false;
    if (this.month == 2) {
        if (this.checkLeap() && this.day > 29) return false;
    }
    if (this.day > dates[this.month-1] || this.day < 0) return false;

    return true;
}



