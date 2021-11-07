package com.example.quizui

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var list: MutableList<Item> = generateDummyList().toMutableList()
    var currentPosition: Int = 0

    init {
        Log.d("mainActivity", "MainViewModel constructor")
    }
    fun addItem(item: Item) {
        list.add(item)
    }

    fun getItem(): Item {
        return list[currentPosition]
    }

    fun generateDummyList(): List<Item>{
        Log.d("xxx", "generateDummyList")
        val quests: MutableList<Question> = QuestionController.getQuestions()
        val list = ArrayList<Item>()
        for (i in 0 until quests.size ){
            val drawable = when (i%2){
                0 -> R.drawable.ic_baseline_access_alarm_24
                else -> R.drawable.ic_baseline_android_24
            }
            val item = Item(drawable, quests[i].text, "${quests[i].answers[0]}", "${quests[i].answers[1]}","${quests[i].answers[2]}","${quests[i].answers[3]}")
            list += item
        }
        return list
    }

}
