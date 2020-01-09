package com.example.mobileappassignment.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileappassignment.Classes.Group
import com.example.mobileappassignment.R

class Forum : AppCompatActivity() {
    public lateinit var group : Group

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum)

        // Get intent
        group = intent.getSerializableExtra("group") as Group

    }
}
