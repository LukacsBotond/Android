package com.example.bazaar.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bazaar.R
import com.example.bazaar.RecycleView.DataAdapter
import com.example.bazaar.Support.TimeStampChecker
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.bottomNav
import com.example.bazaar.viewModel.MyProductsView
import com.example.bazaar.viewModel.MyProductsViewFactroy
import com.example.bazaar.viewModel.TimelineView
import com.example.bazaar.viewModel.TimelineViewFactory

class MyProducts : Fragment(), DataAdapter.OnItemClickListener {
    private val TAG: String = javaClass.simpleName
    lateinit var adapter: DataAdapter
    private lateinit var myProductsView: MyProductsView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomNav.visibility = View.VISIBLE
        val factory = MyProductsViewFactroy(MarketPlaceRepository())
        myProductsView = ViewModelProvider(this,factory)[MyProductsView::class.java]

        val timeStampChecker = TimeStampChecker()
        if(!timeStampChecker.check()){
            this.findNavController()
                .navigate(ProfileDirections.actionProfileToLogin())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_my_products, container, false)
        myProductsView.timelineView.isSuccessful.observe(this.viewLifecycleOwner){
            Log.d(TAG, "Got products successfully = $it")
            adapter = DataAdapter(myProductsView.timelineView.list, this)
            Log.d(TAG, "start RecycleView")
            // connect RecyclerView to the adapter
            val adapter = DataAdapter(myProductsView.timelineView.list, this)
            val recyclerView : RecyclerView = layout.findViewById(R.id.myOrders_recycler_view)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this.context )
            recyclerView.setHasFixedSize(true)
        }
        return layout
    }

    override fun onItemClick(position: Int) {
        myProductsView.timelineView.currentPosition = position
        //TODO navigate to detail
        //findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        Log.d(TAG, "Navigate to details = $position")
    }
}