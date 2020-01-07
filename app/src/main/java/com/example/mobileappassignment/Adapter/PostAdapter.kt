package com.example.mobileappassignment.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileappassignment.Classes.ForumPost
import com.example.mobileappassignment.R

class PostAdapter(val array : ArrayList<ForumPost>) : RecyclerView.Adapter<PostAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val forumpost : ForumPost = array[position]
        holder?.title.text = forumpost.title
        holder?.details.text = forumpost.details
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                parent?.context
            ).inflate(R.layout.postlayout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return array.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val title = view.findViewById(R.id.postTitle) as TextView
        val details = view.findViewById(R.id.postDetails) as TextView
    }
}

