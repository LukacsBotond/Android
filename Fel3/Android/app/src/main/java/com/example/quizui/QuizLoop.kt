package com.example.quizui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


/**
 * A simple [Fragment] subclass.
 * Use the [QuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizLoop : Fragment(R.layout.fragment_quiz_loop) {
    private lateinit var sendAnswer: Button
    private var totQuestion:Int = 5
    private var currQuestion:Int = 0;
    private val kerdesek:QuestionController = QuestionController

    private val args : QuizLoopArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_loop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(activity, "Quiz starts", Toast.LENGTH_SHORT).show()
        Log.d("mainActivity", "Quiz start")

        sendAnswer = view.findViewById(R.id.qiuzSendAnswer)
        kerdesek.oneQuiz(view)

        sendAnswer.setOnClickListener{
            if(totQuestion == currQuestion){
                startQuizFinal()
            }
            else{
                try{
                    kerdesek.checkQuiz(view)
                    kerdesek.oneQuiz(view)
                    currQuestion++
                }catch (exception: NoSuchFieldError){
                    Log.d("mainActivity", "Do nothing")
                }
            }
        }
    }
    private fun startQuizFinal(){

        val userName = args.userName

        val corrQuestion:Int = kerdesek.getcorrectNr()
        Log.d("mainActivity", "Username: $userName")
        Log.d("mainActivity", "totQuestion: $totQuestion")
        Log.d("mainActivity", "corrQuestion: $corrQuestion")
        felh[userName]?.score ?: "$corrQuestion / $totQuestion"
        this.findNavController().navigate(QuizLoopDirections.actionQuizLoopToQuizFinal(userName,totQuestion,corrQuestion))
        /*
        val fr = parentFragmentManager.beginTransaction()
        fr.replace((requireView().parent as ViewGroup).id,QuizFinal.newInstance(userName,totQuestion,corrQuestion))
        fr.commit()
*/
        Log.d("mainActivity", "Next fragment")
    }
}