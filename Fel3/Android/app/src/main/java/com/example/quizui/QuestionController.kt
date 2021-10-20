package com.example.quizui

import java.io.File

object QuestionController {
    private val questions = mutableListOf<Question>()
    private var totalQuestion = 5
    private var correctNr = 0
    init {
        val file = File("./questions.txt")
        val fileLines = mutableListOf<String>()
        file.forEachLine { fileLines.add(it) }
        var quest = ""
        val answers = mutableListOf<String>()
        var correct: Int
        for ((index, i) in fileLines.withIndex()) {
            // println(i)
            if (index % 6 == 0) quest = i
            if (index % 6 in 1..4) answers.add(i)
            if (index % 6 == 5) {
                correct = i.toInt()
                insert(quest, answers, correct)
                answers.clear()
            }
        }
    }

    private fun insert(question: String, answers: List<String>, correct: Int) {
        val ans = mutableListOf<Answer>()
        for ((index, i) in answers.withIndex()) {
            if (index == correct - 1) {
                ans.add(Answer(i, true))
            } else {
                ans.add(Answer(i, false))
            }
        }
        questions.add(Question(question, ans))
    }

    private fun randomizeQuestions(): Question {
        val nrQuestions = questions.size
        return questions[((0 until nrQuestions).random())]
    }

    fun doQuiz() {
        totalQuestion = (3..5).random()
        var answer: String?
        for (i in 1..totalQuestion) {
            println()
            println()
            val question = randomizeQuestions()
            question.printer()
            println("com.example.quizui.Answer: 0/1/2/3?")
            answer = readLine()
            if (answer != null) {
                if (question.correctAnswer(answer.toInt())) {
                    println("Helyes valasz")
                    correctNr++
                } else {
                    println("Helytelen valasz")
                }
            }
            println()
            println()
            println("total/correct $totalQuestion / $correctNr")
        }
    }
}

