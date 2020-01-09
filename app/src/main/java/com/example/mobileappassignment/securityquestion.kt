package com.example.mobileappassignment


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mobileappassignment.Classes.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_securityquestion.*
import kotlinx.android.synthetic.main.fragment_securityquestion.view.*


/**
 * A simple [Fragment] subclass.
 */
class securityquestion : Fragment() {
    private lateinit var dbReference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view =  inflater.inflate(R.layout.fragment_securityquestion, container, false)

        val activity = activity as securityquestion1

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbReference = FirebaseDatabase.getInstance().reference

        //val ans1 = view.findViewById<TextView>(R.id.etPostAnswer)
        val ans = etPostAnswer.text.toString()
        val ans1 : View = view.findViewById(R.id.etPostAnswer1) as EditText

        val bundle = this.arguments
        val user1 = bundle?.getString("name")
        val email = bundle?.getString("email")
        val pass = bundle?.getString("pass")

        //val user1 = arguments?.getString("Username")
        //val email = arguments?.getString("Email")
        //val pass = arguments?.getString("Password")

        val btn : View = view.findViewById(R.id.setAnswerBtn) as Button


        view.etPostAnswer.addTextChangedListener(object :TextWatcher{

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                btn.isEnabled = true
                view.etPostAnswer1.isEnabled = false
                btn.setOnClickListener{
                    val id = dbReference.child("users").push().key as String
                    val user = User(userID = id,name = user1.toString(), email = email.toString(), password = pass.toString(),answer = ans.toString())
                    dbReference.child("users").child(id).setValue(user)

                    Toast.makeText(context, "Registered successful", Toast.LENGTH_SHORT).show()
                }
            }
            })

        view.etPostAnswer1.addTextChangedListener(object :TextWatcher{

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                btn.isEnabled = true
                view.etPostAnswer.isEnabled = false
                btn.setOnClickListener{
                    //register1()
                }
            }
        })


    }

    private fun register(usern: String, email1: String, pass1: String,ans123:String){


    }

}
