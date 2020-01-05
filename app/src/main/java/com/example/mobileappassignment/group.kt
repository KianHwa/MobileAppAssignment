package com.example.mobileappassignment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileappassignment.Classes.Group
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_forumgroup.*
import kotlinx.android.synthetic.main.fragment_group.*

/**
 * A simple [Fragment] subclass.
 */
class group : Fragment(){
    private lateinit var dbReference: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_group, container, false)
        var text = "";

        val linearLayout = LinearLayoutManager(context)

        val recyclerView = view.findViewById(R.id.groupRecycleView) as RecyclerView
        recyclerView.layoutManager = linearLayout

        val grouplist = arrayListOf<Group>()
        val adapter = GroupAdapter(grouplist)
        recyclerView.adapter = adapter

        dbReference = FirebaseDatabase.getInstance().reference
        dbReference.child("groups").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val group = grouplist.clear() // Empty the list
                for(data in p0.children){
                    val group = data.getValue(Group::class.java) as Group
                        grouplist.add(
                            Group(
                                groupID = group.groupID,
                                groupName = group.groupName,
                                groupDescription = group.groupDescription,
                                peopleJoined = 0
                            )
                        )
                }

                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.e("ERROR","ERROR")
            }
        })






        val goBtn: View = view.findViewById(R.id.button)
        goBtn.setOnClickListener { view ->
            var bundle = bundleOf("value" to grouplist[0].groupID)
            view.findNavController().navigate(R.id.action_groupFragment_to_forumgroup,bundle)
}
        return view;
    }


}