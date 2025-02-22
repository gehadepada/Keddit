package com.example.keddit

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.keddit.databinding.ActivityLauncherBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Launcher : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backgroundImage: ImageView = binding.launch
        val fadeIn: Animation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        binding.launch.startAnimation(fadeIn)

        auth = FirebaseAuth.getInstance()
            Handler(Looper.getMainLooper()).postDelayed({
                if (auth.currentUser != null) {
                    startActivity(Intent(this, Login::class.java))
                } else {
                    startActivity(Intent(this, RegisterActivity::class.java))
                }

        finish()


        },3000)
    }
}
