package com.example.mobileappassignment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.mobileappassignment.Classes.ForumPost
import com.example.mobileappassignment.Classes.User
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_add_post.*
import kotlinx.android.synthetic.main.fragment_group.*

class AddPost : Fragment() {
    private lateinit var mDbReference: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_post, container, false)
        val groupID = arguments?.getString("value")

        mDbReference = FirebaseDatabase.getInstance().reference

        val btn: View = view.findViewById(R.id.addPostBtn)
        btn.setOnClickListener { view ->
            val title = etPostTitle.text.toString()
            val detail = etPostDetails.text.toString()


            val id = mDbReference.child("forumposts").push().key as String
            val forumPost = ForumPost(postID = id, groupID = groupID.toString(), title = title, details = detail)
            mDbReference.child("forumposts").child(id).setValue(forumPost)
        }

        return view
    }
}
