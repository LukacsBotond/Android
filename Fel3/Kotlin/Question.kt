
data class Question(val text:String,val answers:List<Answer>) {
    fun printer(){
        println("Kerdes:    $text");
        for(i in answers){
            //println(i);
            i.printer();
        }
    }

    fun correctAnswer(index:Int):Boolean{
        if(index < 0 || index >= answers.size){
            throw RuntimeException("Hibbas index");
        }
        return answers[index].correct;
    }

}