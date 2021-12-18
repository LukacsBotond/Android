package com.example.bazaar.RecycleView

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bazaar.R
import com.example.bazaar.api.types.Reponse.ProductResponse

class DataAdapter(
    private val list : List<ProductResponse>,
    private val listener: OnItemClickListener
    ):
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    var counter_create: Int = 0
    var counter_bind: Int = 0


    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        //val imageView: ImageView = itemView.findViewById(R.id.)
        val usernameTextView: TextView = itemView.findViewById(R.id.Timeline_product_username)
        val titleTextView: TextView = itemView.findViewById(R.id.Timeline_product_title)
        val statusTextView: TextView = itemView.findViewById(R.id.Timeline_product_status)
        val priceTextView: TextView = itemView.findViewById(R.id.Timeline_product_Price)

        init{
            itemView.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val currentPosition = this.adapterPosition
//            Log.d("xxx", "AdapterPosition: $currentPosition")
            listener.onItemClick(currentPosition)

        }
    }

    // 2. Called only a few times = number of items on screen + a few more ones
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_timeline_products, parent, false)
        ++counter_create
//        Log.d("xxx", "onCreateViewHolder: $counter_create")
        return DataViewHolder(itemView)
    }

    // 3. Called many times, when we scroll the list
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentItem = list[position]
        //holder.imageView.setImageResource(currentItem.imageResource)
        holder.usernameTextView.text = currentItem.username
        holder.titleTextView.text = currentItem.title
        if(currentItem.isActive) holder.statusTextView.text = "Active"
        else holder.statusTextView.text = "Inactive"
        holder.priceTextView.text = currentItem.price_per_unit
        ++counter_bind
        Log.d("xxx", "onBindViewHolder: $counter_bind")
    }


    // 4.
    override fun getItemCount() = list.size


}
