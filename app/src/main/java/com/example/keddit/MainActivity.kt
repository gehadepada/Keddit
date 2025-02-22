
package com.example.keddit

import android.R.attr.fragment
import android.graphics.Insets.add
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

import com.example.keddit.databinding.ActivityMainBinding
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val fragments: List<Fragment>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
                supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, MainFragment(), "MAIN_FRAGMENT_TAG")
                .commit()
        }


    }
}