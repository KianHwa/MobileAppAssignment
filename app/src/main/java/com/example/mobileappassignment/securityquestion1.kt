package com.example.mobileappassignment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileappassignment.Classes.User
import com.example.mobileappassignment.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_securityquestion1.*


class securityquestion1 : AppCompatActivity() {
    private lateinit var dbReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_securityquestion1)

        dbReference = FirebaseDatabase.getInstance().reference

        val btn = findViewById(R.id.setAnswerBtn) as Button

        val intent = intent

        etPostAnswer.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                btn.isEnabled = true
                etPostAnswer1.isEnabled = false
                btn.setOnClickListener{view ->
                    val user = intent.getSerializableExtra("name") as String
                    val email =intent.getSerializableExtra("email")as String
                    val pass = intent.getSerializableExtra("pass")as String

                    val ans = etPostAnswer.text.toString()
                    val ans1 = etPostAnswer1.text.toString()

                    val id = dbReference.child("users").push().key as String
                    val user1 = User(userID = id,name = user, email = email, password = pass,answer = ans)
                    dbReference.child("users").child(id).setValue(user1)

                    Toast.makeText(applicationContext,"Registered successful", Toast.LENGTH_SHORT).show()

                }
            }
        })

        etPostAnswer1.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                btn.isEnabled = true
                etPostAnswer.isEnabled = false
                btn.setOnClickListener{
                    //register1()
                }
            }
        })


    }

}
