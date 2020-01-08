package com.example.mobileappassignment.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileappassignment.Classes.Comment
import com.example.mobileappassignment.R

class CommentAdapter(val array : ArrayList<Comment>, val context : Context) : RecyclerView.Adapter<CommentAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val commentlist : Comment = array[position]
        holder?.commentView.text = commentlist.comments
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                parent?.context
            ).inflate(R.layout.commentlayout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return array.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val commentView = view.findViewById(R.id.commentDetails) as TextView
    }
}