package com.okeanarium.ocean

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class RaspisanieFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_raspisanie, container, false)
        view.findViewById<ImageView>(R.id.backBtn2).setOnClickListener { (activity as MainActivity?)?.openSeans() }
        return view
    }



}