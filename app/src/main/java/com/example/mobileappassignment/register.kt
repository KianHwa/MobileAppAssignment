package com.example.mobileappassignment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_register.*

/**
 * A simple [Fragment] subclass.
 */
class register : Fragment() {

    private lateinit var dbReference: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view  = inflater.inflate(R.layout.fragment_register, container, false)

        dbReference = FirebaseDatabase.getInstance().reference

        val btn : View = view.findViewById(R.id.btn_register)
        btn.setOnClickListener{

            val name = et_name.text.toString()
            val email = et_email.text.toString()
            val pass = et_password.text.toString()
            val repass = et_repassword.text.toString()

            if(pass.equals(repass)) {
                //val id = dbReference.child("Users").push().key as String
                //val user = User(userID = id,name = name, email = email, password = pass,answer = "")
                //dbReference.child("users").child(id).setValue(user)

                // Toast.makeText(context, "Registered successful", Toast.LENGTH_SHORT).show()

                //val intent = Intent(activity,securityquestion::class.java)
                //intent.putExtra("name",name)
                //intent.putExtra("email",email)
                //intent.putExtra("pass",pass)
                //startActivity(intent)

                val bundle = bundleOf("name" to name , "email" to email , "pass" to pass)
                view.findNavController().navigate(R.id.action_register_to_securityquestion,bundle)
            }//else{
            //Toast.makeText(context, "Password wrong", Toast.LENGTH_SHORT).show()
            // }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipeLeft.setOnClickListener{
            view.findNavController().navigate(R.id.action_register_to_login)
        }
    }


}