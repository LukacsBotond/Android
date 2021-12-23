package com.example.bazaar.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.SwitchCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bazaar.R
import com.example.bazaar.api.MarketPlaceRepository
import com.example.bazaar.bottomNav
import com.example.bazaar.viewModel.AddProductView
import com.example.bazaar.viewModel.AddProductViewFactory
import com.example.bazaar.viewModel.RegisterViewModel
import com.example.bazaar.viewModel.RegisterViewModelFactory

class AddProduct : Fragment() {
    val TAG: String = javaClass.simpleName
    private lateinit var addProductViewModel: AddProductView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomNav.visibility = View.VISIBLE
        val factory = AddProductViewFactory(MarketPlaceRepository())
        addProductViewModel = ViewModelProvider(this, factory)[AddProductView::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleEditText:EditText = view.findViewById(R.id.product_add_title_editText)
        val descriptionEditText:EditText = view.findViewById(R.id.product_add_description_editText)
        val pricePerUnitEditText:EditText = view.findViewById(R.id.product_add_pricePerUnit_editText)
        val unitsEditText:EditText = view.findViewById(R.id.product_add_units_editText)
        val isActiveSwitch:SwitchCompat = view.findViewById(R.id.product_add_isActive_switch)
        val ratingEditText:EditText = view.findViewById(R.id.product_add_rating_editText)
        val unitTypeEditText:EditText = view.findViewById(R.id.product_add_unitType_editText)
        val priceTypeEditText:EditText = view.findViewById(R.id.product_add_priceType_EditText)

        val sendButton:Button = view.findViewById(R.id.product_add_send)

        sendButton.setOnClickListener {
            //TODO prepare to send
            Log.d(TAG, "prepare to add product")

            addProductViewModel.title = titleEditText.text.toString()
            addProductViewModel.description = descriptionEditText.text.toString()
            addProductViewModel.price_per_unit = pricePerUnitEditText.text.toString()
            addProductViewModel.units = unitsEditText.text.toString()
            addProductViewModel.is_active = isActiveSwitch.text.toString()
            addProductViewModel.rating = ratingEditText.text.toString()
            addProductViewModel.amount_type = unitTypeEditText.text.toString()
            addProductViewModel.price_per_type = priceTypeEditText.text.toString()

            addProductViewModel.addProduct()

            addProductViewModel.isSuccessful.observe(this.viewLifecycleOwner){
                Log.d(TAG, "Product added successfully: $it")
                if(it == true) {
                    this.findNavController()
                        .navigate(AddProductDirections.actionAddProductToMyProducts())
                }
            }
        }
    }

}