package com.example.quizui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast


/**
 * A simple [Fragment] subclass.
 * Use the [QuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizFragment : Fragment(R.layout.fragment_qiuz) {
    private lateinit var sendAnswer: Button;
    private val kerdesek:QuestionController = QuestionController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_qiuz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(activity, "Quiz starts", Toast.LENGTH_SHORT).show()
        Log.d("mainActivity", "Quiz start")

        sendAnswer = view.findViewById(R.id.qiuzSendAnswer)
        kerdesek.oneQuiz(view)

        sendAnswer.setOnClickListener{
            kerdesek.oneQuiz(view)
        }
    }

}