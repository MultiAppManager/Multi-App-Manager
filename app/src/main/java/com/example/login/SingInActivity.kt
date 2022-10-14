package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.login.databinding.ActivitySingInBinding
import com.google.firebase.auth.FirebaseAuth

class SingInActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySingInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivitySingInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.SingUp.setOnClickListener {
            val intent = Intent(this, SingUpActivity::class.java)
            startActivity(intent)

        }
            binding.SingIn.setOnClickListener {
                val name = binding.Username.text.toString()
                val pass = binding.Passaword.text.toString()

                if (name.isNotEmpty() && pass.isNotEmpty()) {

                    firebaseAuth.signInWithEmailAndPassword(name, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent1 = Intent(this, MainActivity::class.java)
                            startActivity(intent1)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Empty Filed Are Not Allowed !!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
