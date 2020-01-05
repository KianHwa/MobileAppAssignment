package com.example.mobileappassignment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileappassignment.Classes.ForumPost
import com.example.mobileappassignment.Classes.Group
import com.example.mobileappassignment.Classes.User
import com.google.android.material.snackbar.Snackbar
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
        val view =  inflater.inflate(R.layout.fragment_forumgroup, container, false)
        val groupID = arguments?.getString("value")

        val testing1view = view.findViewById(R.id.testing1) as TextView
        testing1view.text = groupID.toString()

        val linearLayout = LinearLayoutManager(context)

        val recyclerView = view.findViewById(R.id.postRecycleView) as RecyclerView
        recyclerView.layoutManager = linearLayout

        val forumlist = arrayListOf<ForumPost>()
        val adapter = PostAdapter(forumlist)
        recyclerView.adapter = adapter
        //===================================================================

        //val grouplist = arrayListOf<Group>()


        dbReference = FirebaseDatabase.getInstance().reference
        dbReference.child("forumposts").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val forum = forumlist.clear() // Empty the list
                for(data in p0.children){
                    val forum = data.getValue(ForumPost::class.java) as ForumPost
                    if(forum.groupID.equals(groupID)) {
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


        //=============================================
        /*dbReference = FirebaseDatabase.getInstance().reference
        dbReference.child("groups").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val forum = forumlist.clear() // Empty the list
                for(data in p0.children){
                    val forum = data.getValue(ForumPost::class.java) as ForumPost

                    forumlist.add(
                        ForumPost(
                            title = forum.title,
                            details = forum.details,
                            likes = 0
                        )
                    )
                }
                adapter.notifyDataSetChanged()
            }
            override fun onCancelled(p0: DatabaseError) {
                Log.e("ERROR","ERROR")
            }
        })

*/


        val addPostButton: View = view.findViewById(R.id.addPost)
        addPostButton.setOnClickListener { view ->
            var bundle = bundleOf("value" to groupID)
            view.findNavController().navigate(R.id.action_forumgroup_to_addPostFragment, bundle)
        }

        return view
    }




}