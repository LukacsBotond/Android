package com.example.quizui
data class Answer(val answer:String,val correct:Boolean){
    fun printer(){
        println(answer)
    }
}