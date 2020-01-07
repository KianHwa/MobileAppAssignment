package com.example.mobileappassignment.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileappassignment.R

class Forum : AppCompatActivity() {
    public lateinit var groupId : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum)

        // Get intent
        groupId = intent.getSerializableExtra("groupId") as String

    }
}
