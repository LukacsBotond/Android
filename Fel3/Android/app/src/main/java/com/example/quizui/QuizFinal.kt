package com.example.quizui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlin.properties.Delegates

/**
 * A simple [Fragment] subclass.
 * Use the [QuizFinal.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizFinal : Fragment() {
    private val args: QuizFinalArgs by navArgs()
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


        nameText.text = args.userName
        Log.d("mainActivity", "name set")
        val result = "${args.corrQuestion} / ${args.totQuestion}"
        resultText.text = result
        Log.d("mainActivity", "result set")

        val ret: Button = view.findViewById(R.id.button6)
        ret.setOnClickListener{
            this.findNavController().navigate(QuizFinalDirections.actionQuizFinalToHomeFragment2())
        }
    }
}