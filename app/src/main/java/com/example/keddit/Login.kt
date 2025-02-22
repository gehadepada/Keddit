package com.example.keddit

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.example.keddit.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity :: class.java))

        }
        binding.btnLogin.setOnClickListener {
            val email = binding.editEmail.text.toString().trim()
            val password = binding.editPassword.text.toString()
            validate(email, password)
        }
    }

    private fun validate(  email: String,  password: String) {
        if (email.isEmpty()) {
            binding.editEmail.error = "Email is required"
            return
        }

        if (password.isEmpty()) {
            binding.editPassword.error = "Password is required"
            return
        }
        if (password.length< 6) {
            binding.editPassword.error = "Password size should greater than 6 "
            return
        } else {
            startAuth(email ,password);
        }
    }
    private fun startAuth(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { authResult ->

                val user = authResult.user

                 startActivity(Intent(this, MainActivity::class.java))
                 finish()
            }
            .addOnFailureListener { exception ->

                binding.editEmail.error = "Authentication failed: ${exception.message}"
            }
    }

}
