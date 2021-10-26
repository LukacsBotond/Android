package com.example.quizui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [QuizFinal.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizFinal : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_final, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameText = view.findViewById<TextView>(R.id.FinalUsername)
        val resultText = view.findViewById<TextView>(R.id.FinalQuizResult)

        nameText.text = arguments?.getString("userName")?: "NullBob"
        Log.d("mainActivity", "name set")
        val result = "${arguments?.getInt("corrQuestion")} / ${arguments?.getInt("totQuestion")}"
        resultText.text = result
        Log.d("mainActivity", "result set")
    }
    companion object {
        fun newInstance(userName: String,totQuestion:Int,corrQuestion:Int): QuizFinal {
            val fragment = QuizFinal()
            val args = Bundle()
            args.putInt("totQuestion", totQuestion)
            args.putInt("corrQuestion",corrQuestion)
            args.putString("userName", userName)

            Log.d("mainActivity", "QuizFinal")
            Log.d("mainActivity", "Username: $userName")
            Log.d("mainActivity", "totQuestion: $totQuestion")
            Log.d("mainActivity", "corrQuestion: $corrQuestion")
            fragment.arguments = args
            return fragment
    }
    }
}