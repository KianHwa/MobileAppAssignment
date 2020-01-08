package com.example.mobileappassignment.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mobileappassignment.Classes.Group
import com.example.mobileappassignment.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_create_group.*

class createGroup : Fragment() {
    private lateinit var mDbReference: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_group, container, false)

        mDbReference = FirebaseDatabase.getInstance().reference

        val btn: View = view.findViewById(R.id.btnAddGroup)
        btn.setOnClickListener { view ->
            val grpname : String = etGroupName.text.toString()
            val grpdesc : String = etGroupDesc.text.toString()

            val id = mDbReference.child("groups").push().key as String
            val grouplist = Group(groupID = id, groupName = grpname, groupDescription = grpdesc)
            mDbReference.child("groups").child(id).setValue(grouplist)

            Toast.makeText(context,"Successfully created a group",
                Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
