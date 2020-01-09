package com.example.mobileappassignment.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileappassignment.R

/**
 * A simple [Fragment] subclass.
 */
class myprofile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_myprofile, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "My profile"

        return view
    }




}
