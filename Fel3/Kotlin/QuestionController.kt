import java.io.File

object QuestionController {
    private val questions = mutableListOf<Question>()
    private var totalQuestion: Int = 5
    private var correctNr: Int = 0
    init {
        val file = File("./questions.txt")
        var fileLines = mutableListOf<String>()
        file.forEachLine { fileLines.add(it) }
        var index = 0
        var quest: String = ""
        val answers = mutableListOf<String>()
        var correct: Int
        for (i in fileLines) {
            // println(i)
            if (index % 6 == 0) quest = i
            if (index % 6 < 5 && index % 6 > 0) answers.add(i)
            if (index % 6 == 5) {
                correct = i.toInt()
                insert(quest, answers, correct)
                answers.clear()
            }
            index++
        }
    }

    private fun insert(question: String, answers: List<String>, correct: Int) {
        val ans = mutableListOf<Answer>()
        var index = 0
        for (i in answers) {
            if (index == correct - 1) {
                ans.add(Answer(i, true))
            } else {
                ans.add(Answer(i, false))
            }
            index++
        }
        questions.add(Question(question, ans))
    }

    fun randomizeQuestions(): Question {
        val nrQuestions = questions.size
        return questions[((0..nrQuestions - 1).random())]
    }

    fun doQuiz() {
        totalQuestion = (3..5).random()
        var answer: String?
        for (i in 1..totalQuestion) {
            println()
            println()
            val question = randomizeQuestions()
            question.printer()
            println("Answer: 0/1/2/3?")
            answer = readLine()
            if (answer != null) {
                if (question.correctAnswer(answer.toInt())) {
                    println("Helyes valasz")
                    correctNr++;
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

