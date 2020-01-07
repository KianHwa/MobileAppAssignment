package com.example.mobileappassignment.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileappassignment.Classes.Group
import com.example.mobileappassignment.Activity.Forum
import com.example.mobileappassignment.R

class GroupAdapter(val array : ArrayList<Group>, val context : Context) : RecyclerView.Adapter<GroupAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val grouplist : Group = array[position]
        holder?.groupName.text = grouplist.groupName
        holder?.cardView.setOnClickListener{
            val intent = Intent(context, Forum::class.java)
            intent.putExtra("groupId", grouplist.groupID)
            context.startActivity(intent)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                parent?.context
            ).inflate(R.layout.grouplayout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return array.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val groupName = view.findViewById(R.id.groupName) as TextView
        val cardView = view.findViewById<CardView>(R.id.CardView)
    }
}