package com.example.mobileappassignment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.mobileappassignment.Classes.User
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_login.*


/**
 * A simple [Fragment] subclass.
 */
class login : Fragment() {

    private lateinit var dbReference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_login, container, false
        )
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbReference = FirebaseDatabase.getInstance().reference

        val loginbtn: View = view.findViewById(R.id.btn_login)

        val email1 = view.findViewById(R.id.login_email) as EditText

        val pass1 = view.findViewById(R.id.login_password) as EditText

        swipeLeft2.setOnClickListener{
            view.findNavController().navigate(R.id.action_login_to_register)
        }

        loginbtn.setOnClickListener{
            login(email1.text.toString(), pass1.text.toString())
        }
    }

    private fun login(email:String,pass:String) {
        val duration = Toast.LENGTH_SHORT


        dbReference.child("users").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                for (data in p0.children) {
                        if (email.isNotEmpty()) {
                            val user = data.getValue(User::class.java) as User

                            if (user.email.equals(email) && user.pass.equals(pass)) {
                                Toast.makeText(context, "Login successful", duration).show()
                                view?.findNavController()?.navigate(R.id.action_login_to_homeFragment)
                            } else {
                                Toast.makeText(context, "Login failed", duration).show()
                            }
                        } else {
                            Toast.makeText(context, "Email is not registered", duration).show()
                        }
                    }
                }

            override fun onCancelled(p0: DatabaseError) {
                Log.e("ERROR", "ERROR")
            }
        })

    }
    }
