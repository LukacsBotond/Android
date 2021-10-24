package com.example.quizui

import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

object QuestionController {
    private val questions = mutableListOf<Question>()
    private var totalQuestion = 5
    private var correctNr = 0
    private lateinit var question: Question
    init{
        val bigString =
                "? val modosithato?\n" +
                "igen\n" +
                "nem\n" +
                "talan\n" +
                "biztos\n" +
                "2\n" +
                "? hozzadhato uj tarolo:\n" +
                "mutableListOf<String>()\n" +
                "String\n" +
                "ListOf<Int>\n" +
                "Int\n" +
                "1\n" +
                "? ++ operator mit csinal?\n" +
                "ilyen operator nincs\n" +
                "kivon 1-et\n" +
                "hoozzaad 1-et\n" +
                "lenullazza a valtozot\n" +
                "3\n"+
                "? txt fajl megnyitasa androidon\n"+
                "konnyu\n"+
                "gyerekjatek\n"+
                "bonyolult\n"+
                "nem lehetseges\n"+
                "3"
        val lines = bigString.lines()
        var quest = ""
        val answers = mutableListOf<String>()
        var correct: Int
        for ((index, i) in lines.withIndex()) {
            if (index % 6 == 0) quest = i
            if (index % 6 in 1..4) answers.add(i)
            if (index % 6 == 5) {
                correct = i.toInt()
                insert(quest, answers, correct)
                answers.clear()
            }
        }

    }


    //! this works fine when compiling on PC, but it don't copy the file to the phone
        /*
    init {
        try {
            val file = File("question")
            val fileLines = mutableListOf<String>()
            file.forEachLine { fileLines.add(it) }
            var quest = ""
            val answers = mutableListOf<String>()
            var correct: Int
            for ((index, i) in fileLines.withIndex()) {
                if (index % 6 == 0) quest = i
                if (index % 6 in 1..4) answers.add(i)
                if (index % 6 == 5) {
                    correct = i.toInt()
                    insert(quest, answers, correct)
                    answers.clear()
                }
            }
        }catch (e: FileNotFoundException) {
            Log.e("mainActivity", "Nincs fajl")
            //just to chash it as it failed already
            val file = File("question")
            val fileLines = mutableListOf<String>()
            file.forEachLine { fileLines.add(it) }
        }
    }

         */

    fun getcorrectNr():Int{
        return correctNr
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
            question = randomizeQuestions()

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

    fun oneQuiz(view:View){
        val kerdes = view.findViewById<TextView>(R.id.QuizQuestion)
        val radiog = view.findViewById<RadioGroup>(R.id.radioGroup)
        question = randomizeQuestions()

        kerdes.text = question.text
        val checked = radiog.checkedRadioButtonId
        radiog.findViewById<RadioButton>(R.id.radioButton).text = question.answers[0].answer
        radiog.findViewById<RadioButton>(R.id.radioButton2).text = question.answers[1].answer
        radiog.findViewById<RadioButton>(R.id.radioButton3).text = question.answers[2].answer
        radiog.findViewById<RadioButton>(R.id.radioButton4).text = question.answers[3].answer
        Log.d("mainActivity", "Checked $checked")
        radiog.clearCheck()
    }

    fun checkQuiz(view: View): Boolean{
        val radiog = view.findViewById<RadioGroup>(R.id.radioGroup)
        val checked = radiog.checkedRadioButtonId
        if (checked == -1){
            Log.d("mainActivity", "Nonce checked")
            throw NoSuchFieldError("None checked")
        }
        val selectedRadioButton = view.findViewById<RadioButton>(checked)
        Log.d("mainActivity", checked.toString())
        if(question.correctAnswerByString(selectedRadioButton.text as String)){
            Log.d("mainActivity", "Correct answer")
            correctNr++
            return true
        }
        Log.d("mainActivity", "Incorrect answer")
        return false

    }
}

