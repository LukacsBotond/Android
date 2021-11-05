package com.example.quizui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quizui.databinding.FragmentQiuzStartBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        // Inflate the layout for this fragment
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_qiuz_start, container, false)
        binding.button3.setOnClickListener{
            this.findNavController().navigate(R.id.qiuzStart)
        }

         */
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("mainActivity", "Home screen")
        val sendAnswer:Button = view.findViewById(R.id.button3)
        val readQuestions:Button = view.findViewById(R.id.button4)
        val addQuestions:Button = view.findViewById(R.id.button5)

        sendAnswer.setOnClickListener{
            Log.d("mainActivity", "Quiz start clicked")
            //this.findNavController().navigate(StartFragmentDirections)
            this.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToQiuzStart())
            /*
            val fr = parentFragmentManager.beginTransaction()
            fr.replace((requireView().parent as ViewGroup).id,QiuzStart())
            fr.commit()

             */
        }

        readQuestions.setOnClickListener{
            Log.d("mainActivity", "ReadQuestions clicked")
            this.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToReadQuestion())
                /*
            val fr = parentFragmentManager.beginTransaction()
            fr.replace((requireView().parent as ViewGroup).id,ReadQuestion.newInstance())
            fr.commit()

                 */
        }
        addQuestions.setOnClickListener{
            this.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAddQuestion())
        }

    }
}