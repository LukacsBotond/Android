package com.example.quizui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ReadQuestion : Fragment(), DataAdapter.OnItemClickListener {
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("mainActivity", "ListFragment - onCreateView")
        // Inflate the layout for this fragment
        val layout =  inflater.inflate(R.layout.fragment_read_question, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        // connect RecyclerView to the adapter
        val adapter = DataAdapter(viewModel.list, this)
        val recycler_view : RecyclerView = layout.findViewById(R.id.recycler_view)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this.context )
        recycler_view.setHasFixedSize(true)

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("mainActivity", "Read Question")
    }

    override fun onItemClick(position: Int) {
        viewModel.currentPosition = position
        //findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        Log.d("mainActivity", "AdapterPosition: $position")
    }
}