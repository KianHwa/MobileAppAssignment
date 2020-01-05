package com.example.mobileappassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileappassignment.Classes.Group

class GroupAdapter(val array : ArrayList<Group>) : RecyclerView.Adapter<GroupAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val grouplist : Group = array[position]
        holder?.groupName.text = grouplist.groupName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.grouplayout,parent,false))
    }

    override fun getItemCount(): Int {
        return array.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val groupName = view.findViewById(R.id.groupName) as TextView
    }
}