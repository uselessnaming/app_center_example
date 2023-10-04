package com.example.appcenterstudy

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import com.example.appcenterstudy.databinding.ActivityMvcBinding

class MvcActivity : ComponentActivity() {

    private lateinit var binding : ActivityMvcBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        var count = 0

        binding.btnTest.setOnClickListener {
            count += 1
            binding.btnTest.text = count.toString()
        }

    }
}