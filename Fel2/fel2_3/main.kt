fun main() {

    var d = Date(2000, 1, 1)
    println("$d leap year? ${d.checkLeap()}")
    println("$d valid date? ${d.vailidDate()}")

    var validNr = 0;
    var dates = mutableListOf<Date>();
    while(validNr <= 10){
        //println("try:")
        val year = (0..3000).random();
        val month = (1..30).random();
        val day = (1..50).random();
        //println("$year $month $day")
        val randDate = Date( year,month,day  )
        if(randDate.vailidDate()){
            dates.add(randDate);
            validNr++;
        }
        else{
            println(randDate)
        }
    }
    println("Correct dates")
    dates .forEach { println(it) }
    println("Sort")
    dates.sortBy{ it } 
    dates.forEach{println(it)}
    println("reverse Sort")
    dates.sortByDescending { it }
    dates.forEach{println(it)}
    println("my sort")
    dates.sortWith( compareBy { it.month }  )
    dates.forEach{println(it)}
}
 