package com.example.quizui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit


class MainActivity : AppCompatActivity() {
    
    /*
    private val getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK){
            val contracUri = result.data?.data
            if(contracUri != null){
                var projection = arrayOf(
                    ContractsContract.C
                )
            }
        }
    }
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm: FragmentManager = supportFragmentManager
            fm.commit {
            setReorderingAllowed(true)
            add<QiuzStart>(R.id.fragment_qiuz_start)
        }
    }
}