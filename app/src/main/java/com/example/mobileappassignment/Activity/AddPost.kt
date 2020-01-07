package com.example.mobileappassignment.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.mobileappassignment.Classes.ForumPost
import com.example.mobileappassignment.Fragments.AddPost
import com.example.mobileappassignment.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_add_post.*

class AddPost : AppCompatActivity() {
    private lateinit var mDbReference: DatabaseReference
    public lateinit var groupID : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        groupID = intent.getSerializableExtra("groupId") as String
        mDbReference = FirebaseDatabase.getInstance().reference

        val btn = findViewById(R.id.addPostBtn) as Button
        btn.setOnClickListener { view ->
            val title = etPostTitle.text.toString()
            val detail = etPostDetails.text.toString()


            val id = mDbReference.child("forumposts").push().key as String
            val forumPost = ForumPost(postID = id, groupID = groupID.toString(), title = title, details = detail)
            mDbReference.child("forumposts").child(id).setValue(forumPost)
        }

    }


}

