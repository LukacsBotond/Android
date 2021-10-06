
data class Question(val text:String,var answers:List<Answer>) {
    fun printer(){
        println("Kerdes:    $text");
        answers = answers.shuffled();
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