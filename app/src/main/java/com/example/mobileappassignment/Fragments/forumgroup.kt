package com.example.mobileappassignment.Fragments


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileappassignment.Activity.AddPost
import com.example.mobileappassignment.Activity.Forum
import com.example.mobileappassignment.Adapter.PostAdapter
import com.example.mobileappassignment.Classes.ForumPost
import com.example.mobileappassignment.Classes.Group
import com.example.mobileappassignment.R
import com.google.firebase.database.*

/**
 * A simple [Fragment] subclass.
 */
class forumgroup : Fragment(){
    private lateinit var dbReference: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Get activity
        val activity = activity as Forum
        val group : Group = activity.group
        activity.supportActionBar?.setTitle(group.groupName)

        val view =  inflater.inflate(R.layout.fragment_forumgroup, container, false)

        val linearLayout = LinearLayoutManager(context)

        val recyclerView = view.findViewById(R.id.postRecycleView) as RecyclerView
        recyclerView.layoutManager = linearLayout

        val forumlist = arrayListOf<ForumPost>()
        val adapter = PostAdapter(forumlist,activity)
        recyclerView.adapter = adapter
        //===================================================================


        dbReference = FirebaseDatabase.getInstance().reference
        dbReference.child("forumposts").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val forum = forumlist.clear() // Empty the list
                for(data in p0.children){
                    val forum = data.getValue(ForumPost::class.java) as ForumPost
                    if(forum.groupID.equals(group.groupID)) {
                        forumlist.add(
                            ForumPost(
                                title = forum.title,
                                details = forum.details,
                                likes = forum.likes
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

        val groupname = view.findViewById(R.id.groupNameView) as TextView
        val groupdetails = view.findViewById(R.id.groupDetailsView) as TextView

        groupname.text = group.groupName
        groupdetails.text = group.groupDescription

        val addPostButton: View = view.findViewById(R.id.addPost)
        addPostButton.setOnClickListener { view ->

            val intent = Intent(activity, AddPost::class.java)
            intent.putExtra("groupId", group.groupID)
            startActivity(intent)

            /*var bundle = bundleOf("value" to groupID)
            view.findNavController().navigate(R.id.action_forumgroup_to_addPostFragment, bundle)*/
        }

        return view
    }




}