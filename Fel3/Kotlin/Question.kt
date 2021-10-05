
data class Question(val text:String,val answers:List<Answer>) {
    fun printer(){
        println("Kerdes:    $text");
        for(i in answers){
            i.printer();
        }
    }
}