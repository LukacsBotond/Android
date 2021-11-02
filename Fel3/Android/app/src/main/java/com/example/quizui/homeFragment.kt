package com.example.quizui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("mainActivity", "Home screen")
        val sendAnswer:Button = view.findViewById(R.id.button3)
        val readQuestions:Button = view.findViewById(R.id.button4)

        sendAnswer.setOnClickListener{
            Log.d("mainActivity", "Quiz start clicked")
            val fr = parentFragmentManager.beginTransaction()
            fr.replace((requireView().parent as ViewGroup).id,QiuzStart())
            fr.commit()
        }

        readQuestions.setOnClickListener{
            Log.d("mainActivity", "ReadQuestions clicked")
            val fr = parentFragmentManager.beginTransaction()
            fr.replace((requireView().parent as ViewGroup).id,ReadQuestions.newInstance())
            fr.commit()
        }
    }
}