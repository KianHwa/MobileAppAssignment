package com.example.mobileappassignment.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileappassignment.Adapter.CommentAdapter
import com.example.mobileappassignment.Classes.Comment
import com.example.mobileappassignment.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_comment.*
import kotlinx.android.synthetic.main.commentlayout.*

class CommentList : AppCompatActivity() {
    private lateinit var mDbReference: DatabaseReference
    public lateinit var postID : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        postID = intent.getSerializableExtra("postid") as String
        mDbReference = FirebaseDatabase.getInstance().reference

        val linearLayout = LinearLayoutManager(this)

        val recyclerView = findViewById(R.id.commentRecyclerView) as RecyclerView
        recyclerView.layoutManager = linearLayout

        val commentlist = arrayListOf<Comment>()
        val adapter = CommentAdapter(commentlist, this)
        recyclerView.adapter = adapter

        mDbReference = FirebaseDatabase.getInstance().reference
        mDbReference.child("comments").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val comment = commentlist.clear() // Empty the list
                    for (data in p0.children) {
                        val comment = data.getValue(Comment::class.java) as Comment
                        if(comment.postID.equals(postID)) {
                            commentlist.add(
                                Comment(
                                    comments = comment.comments,
                                    postID = comment.postID
                                )
                            )
                        }
                    }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.e("ERROR","ERROR")
            }
        })



        val btn = findViewById<Button>(R.id.btnComment)

        btn.setOnClickListener{
            val peopleComment = etCommentArea.text.toString()

            val id = mDbReference.child("comments").push().key as String
            val comment = Comment(comments = peopleComment, postID = postID)
            mDbReference.child("comments").child(id).setValue(comment)

            Toast.makeText(this, "You commented on the post",
                Toast.LENGTH_SHORT).show()

        }



    }
}
