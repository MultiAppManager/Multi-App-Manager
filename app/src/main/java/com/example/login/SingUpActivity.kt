package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.login.databinding.ActivitySingUpBinding
import com.google.firebase.auth.FirebaseAuth

class SingUpActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySingUpBinding
    private lateinit var firebaseAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivitySingUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.SingIn.setOnClickListener{
            val intent = Intent(this,SingInActivity::class.java)
            startActivity(intent)

        }
        binding.SingUP.setOnClickListener{
            val name = binding.Username.text.toString()
            val pass = binding.Passaword.text.toString()
            val confirmPassword = binding.confirmPassword.text.toString()

            if (name.isNotEmpty() && pass.isNotEmpty() && confirmPassword.isNotEmpty()){
                if(pass == confirmPassword){

                    firebaseAuth.createUserWithEmailAndPassword(name,pass).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent(this,SingInActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Empty Filed Are Not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}