package com.example.mobileappassignment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.mobileappassignment.Classes.User
import com.google.firebase.database.*

/**
 * A simple [Fragment] subclass.
 */
class verifyuser : Fragment() {

    private lateinit var dbReference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_verifyuser, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbReference = FirebaseDatabase.getInstance().reference

        val btn : View  =view.findViewById(R.id.ProceedBtn)

        val ans = view.findViewById(R.id.etVerifyUser) as EditText
        val ans1 = view.findViewById(R.id.etVerifyAnswer) as EditText
        var id = ""



        btn.setOnClickListener{
            val duration = Toast.LENGTH_SHORT
            dbReference.child("users").addValueEventListener(object : ValueEventListener{


                override fun onDataChange(p0: DataSnapshot) {
                    for(data in p0.children){
                        if(ans.text.toString().isNotEmpty()){
                            val user = data.getValue(User::class.java) as User

                            if(user.answer.equals(ans1.text.toString())){
                                id = user.userID
                                Toast.makeText(context,"Verify Succesfully",duration).show()
                                val bundle = bundleOf("email" to ans.text.toString(), "answer" to ans1.text.toString() , "id" to  id)
                                view.findNavController().navigate(R.id.action_verifyuser_to_resetpassword,bundle)
                            }else{
                                Toast.makeText(context,"Verify Failed",duration).show()
                            }
                        }else{
                            Toast.makeText(context,"The email is not exist",duration).show()

                        }
                    }
                }

                override fun onCancelled(p0: DatabaseError) {
                    Log.e("ERROR", "ERROR")
                }


            })

        }
    }

}
