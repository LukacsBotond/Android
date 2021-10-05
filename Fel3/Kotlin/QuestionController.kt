import java.io.File

object QuestionController{
    private val questions = mutableListOf<Question>();
    
    init{
        val file = File("./questions.txt")
        var fileLines = mutableListOf<String>();
        file.forEachLine {fileLines.add(it)}
        var index = 0;
        var quest :String = "";
        val answers = mutableListOf<String>();
        var correct : Int;
        for (i in fileLines){
            println(i)
            if(index %6 == 0) quest = i;
            if(index %6 < 5 && index %6 > 0)  answers.add(i);
            if(index %6 == 5){
                    correct = i.toInt();
                    insert(quest, answers, correct)
                    answers.clear()
                }
            index++;
        }
    }

    private fun insert(question:String, answers:List<String>,correct:Int){
        val ans = mutableListOf<Answer>();
        var index = 0;
        for(i in answers){
            if(index == correct){
                ans.add(Answer(i, true));
            }
            else{
                ans.add(Answer(i, false));
            }
        }
        questions.add(Question(question, ans));
    }


    fun randomizeQuestions(){
        val nrQuestions = questions.size;
        questions[((0..nrQuestions).random())].printer()
    }

    fun doQuiz(){
        
    }

}