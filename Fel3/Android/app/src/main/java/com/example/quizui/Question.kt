package com.example.quizui

data class Question(val text:String, var answers:List<Answer>) {
    fun printer(){
        println("Kerdes:    $text")
        answers = answers.shuffled()
        for(i in answers){
            //println(i);
            i.printer()
        }
    }
    fun correctAnswer(index:Int):Boolean{
        if(index < 0 || index >= answers.size){
            throw RuntimeException("Hibas index")
        }
        return answers[index].correct
    }

    fun correctAnswerByString(answer:String):Boolean{
        for(i in 0..4){
            if(answers[i].answer == answer){
                return answers[i].correct
            }
        }
        return false;
    }

}