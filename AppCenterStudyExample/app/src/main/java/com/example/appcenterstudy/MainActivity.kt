package com.example.appcenterstudy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.appcenterstudy.databinding.ActivityMainBinding
import com.example.appcenterstudy.study_3rd.DataViewModel
import com.example.appcenterstudy.study_3rd.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentContainerView, HomeFragment()).commit()

        Log.d("TEST_FRAGMENT","Activity onCreate Success")
    }
}