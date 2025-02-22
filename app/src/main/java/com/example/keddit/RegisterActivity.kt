package com.example.keddit

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.keddit.databinding.ActivityLoginBinding
import com.example.keddit.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.btnLoginR.setOnClickListener{
            startActivity(Intent(this , Login::class.java))
        }

        binding.btnRegister.setOnClickListener {
            val name = binding.editName.text.toString()
            val phone = binding.editPhone.text.toString()
            val email = binding.editEmail.text.toString().trim()
            val password = binding.editPassword.text.toString()
            validate(name , phone ,email, password)
        }
    }

    private fun validate( name:String ,phone :String , email: String,  password: String )  {
        if (email.isEmpty()) {
            binding.editEmail.error = "Email is required"
            return
        }

        if (password.isEmpty()) {
            binding.editPassword.error = "Password is required"
            return
        }
        if (name.isEmpty()) {
            binding.editName.error = "Name is required"
            return
        }

        if (phone.isEmpty()) {
            binding.editPhone.error = "Phone is required"
            return
        }
        if (password.length< 6) {
            binding.editPassword.error = "Password size should greater than 6 "
            return
        } else {
            startAuth(name ,phone ,email ,password);
        }
    }
    private fun startAuth(name :String ,phone :String ,email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
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