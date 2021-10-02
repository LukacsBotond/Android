data class Date(val year: Int, val month: Int, val day: Int) {}

fun Date.checkLeap(): Boolean {
    if ((this.year % 100 == 0 && this.year % 400 != 0) && this.year % 4 == 0) {
        return true
    }
    return false
}
