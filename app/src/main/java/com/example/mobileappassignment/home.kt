package com.example.mobileappassignment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileappassignment.Classes.Group
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.grouplayout.*

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
