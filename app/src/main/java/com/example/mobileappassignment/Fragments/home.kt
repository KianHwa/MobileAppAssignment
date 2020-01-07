package com.example.mobileappassignment.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobileappassignment.R
import com.google.firebase.database.*

/**
 * A simple [Fragment] subclass.
 */
class home : Fragment() {
    private lateinit var mDbReference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }
}
