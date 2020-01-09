package com.example.mobileappassignment.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.mobileappassignment.R

/**
 * A simple [Fragment] subclass.
 */
class setting : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Setting"


        val themeBtn = view.findViewById(R.id.btnTheme) as Button
        themeBtn.setOnClickListener{
            (activity as AppCompatActivity).setTheme(AppCompatDelegate.MODE_NIGHT_NO)
        }



        return view
    }


}
