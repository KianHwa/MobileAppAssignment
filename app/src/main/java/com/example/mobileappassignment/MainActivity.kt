package com.example.mobileappassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.databinding.DataBindingUtil
import com.example.mobileappassignment.Classes.ForumPost
import com.example.mobileappassignment.Classes.Group
import com.example.mobileappassignment.Classes.User
import com.example.mobileappassignment.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_add_post.*
import kotlinx.android.synthetic.main.fragment_group.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.postlayout.*

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var firebase : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        actionBar!!.setDisplayHomeAsUpEnabled(false)

        firebase = FirebaseDatabase.getInstance().reference

        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        drawerLayout = binding.drawerLayout

        val navController = this.findNavController(R.id.myNavHostFragment)

        NavigationUI.setupActionBarWithNavController(this,navController, drawerLayout)

        NavigationUI.setupWithNavController(binding.navView, navController)


    }

    /*public fun addNewPost(view: View){
        val title = etPostTitle.text.toString()
        val detail = etPostDetails.text.toString()


        val id = firebase.child("forumposts").push().key as String
        val forumPost = ForumPost(postID = id, title = title, details = detail)
        firebase.child("forumposts").child(id).setValue(forumPost)

    }*/

    public fun addGroup(view: View){
        val grpname : String = etGroupName.text.toString()
        val grpdesc : String = etGroupDesc.text.toString()

        val id = firebase.child("groups").push().key as String
        val grouplist = Group(groupID = id, groupName = grpname, groupDescription = grpdesc)
        firebase.child("groups").child(id).setValue(grouplist)



    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}
