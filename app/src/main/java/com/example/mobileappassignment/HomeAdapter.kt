package com.example.mobileappassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileappassignment.Classes.User

class HomeAdapter(val array : ArrayList<User>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.userlayout,parent,false))
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user : User = array[position]
        holder?.name.text = user.name
        holder?.email.text = user.email
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val name = view.findViewById(R.id.name) as TextView
        val email = view.findViewById(R.id.email) as TextView

    }
}

