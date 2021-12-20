package com.example.bazaar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bazaar.RecycleView.DataAdapter
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.viewModel.TimelineView
import com.example.bazaar.viewModel.TimelineViewFactory
import com.example.bazaar.RecycleView.DataAdapter.OnItemClickListener
import com.example.bazaar.Support.TimeStampChecker
import com.example.bazaar.fragment.ProfileDirections
import com.google.android.material.bottomnavigation.BottomNavigationView

class Timeline : Fragment(), OnItemClickListener {
    private val TAG: String = javaClass.simpleName
    lateinit var adapter: DataAdapter
    private lateinit var timelineView:TimelineView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = TimelineViewFactory(MarketPlaceRepository())
        timelineView = ViewModelProvider(this,factory)[TimelineView::class.java]
        bottomNav.visibility = View.VISIBLE

        val timeStampChecker = TimeStampChecker()
        if(!timeStampChecker.check()){
            this.findNavController()
                .navigate(ProfileDirections.actionProfileToLogin())
        }

    /*
        val bottomNav = view?.findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        if (bottomNav != null) {
            Log.d(TAG, "Set bottom navigation visible")
            bottomNav.visibility = View.VISIBLE
        }
        else{
            Log.d(TAG, "Bottom nav is null for some reason")
        }

     */
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "TimelineOnCreateView")
        // Inflate the layout for this fragment
        val layout =  inflater.inflate(R.layout.fragment_timeline, container, false)

        timelineView.isSuccessful.observe(this.viewLifecycleOwner){
            Log.d(TAG, "Got products successfully = $it")
            adapter = DataAdapter(timelineView.list, this)
            Log.d(TAG, "start RecycleView")
            // connect RecyclerView to the adapter
            val adapter = DataAdapter(timelineView.list, this)
            val recyclerView : RecyclerView = layout.findViewById(R.id.recycler_view)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this.context )
            recyclerView.setHasFixedSize(true)
        }
        return layout
    }
    override fun onItemClick(position: Int) {
        timelineView.currentPosition = position
        //TODO navigate to detail
        //findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        Log.d(TAG, "Navigate to details = $position")
    }
}





