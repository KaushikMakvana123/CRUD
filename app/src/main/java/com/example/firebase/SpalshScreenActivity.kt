package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.firebase.databinding.ActivitySpalshScreenBinding

class SpalshScreenActivity : AppCompatActivity() {



    lateinit var  binding: ActivitySpalshScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpalshScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {


        Handler().postDelayed(
            {
                val i = Intent(this@SpalshScreenActivity, CreateAccountActivity::class.java)
                startActivity(i)
                finish()
            }, 5000)

    }
}