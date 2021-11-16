package com.example.quizui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(
    private val list: List<Item>,
    private val listener: ReadQuestion
    ) :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {


    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    var counter_create: Int = 0
    var counter_bind: Int = 0


    // 1. user defined ViewHolder type - Embedded class!
    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val textView1: TextView = itemView.findViewById(R.id.question_view_1)
        val textView2: TextView = itemView.findViewById(R.id.answer_view_1)
        val textView3: TextView = itemView.findViewById(R.id.answer_view_2)
        val textView4: TextView = itemView.findViewById(R.id.answer_view_3)
        val textView5: TextView = itemView.findViewById(R.id.answer_view_4)
        init{
            itemView.setOnClickListener(this)
        }


        override fun onClick(p0: View?) {
            val currentPosition = this.adapterPosition
            Log.d("mainActivity", "AdapterPosition: $currentPosition")
            listener.onItemClick(currentPosition)
        }
    }

    // 2. Called only a few times = number of items on screen + a few more ones
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_items, parent, false)
        ++counter_create

        Log.d("mainActivity", "AdapterPosition: $counter_create")
        return DataViewHolder(itemView)
    }


    // 3. Called many times, when we scroll the list
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentItem = list[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.question
        holder.textView2.text = currentItem.answer1
        holder.textView3.text = currentItem.answer2
        holder.textView4.text = currentItem.answer3
        holder.textView5.text = currentItem.answer4
        ++counter_bind

        Log.d("mainActivity", "AdapterPosition: $counter_bind")
    }


    // 4.
    override fun getItemCount() = list.size
}