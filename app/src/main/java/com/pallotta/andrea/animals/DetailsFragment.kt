package com.pallotta.andrea.animals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val ARG_PARAM1 = "ITEM"

class DetailsFragment: Fragment() {

    private var itemName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { itemName = it.getString(ARG_PARAM1) }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.letter_details_fragment, container, false)
        myView.findViewById<TextView>(R.id.letter_animal_name).text = itemName
        return myView
    }

    companion object {
        // use this factory method to create a new instance of this fragment
        fun newInstance(param1: String) = WelcomeFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
            }
        }
    }

}