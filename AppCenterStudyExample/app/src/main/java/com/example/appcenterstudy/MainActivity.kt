package com.example.appcenterstudy

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.appcenterstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //View binding
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //기존 방식
        val textView : TextView = findViewById(R.id.tv_test)
        textView.text = "Hello"

        //view binding
        binding.tvTest.text = "Hello"

        //data binding >> ViewModel + LiveData와 많이 사용
        binding.test = "Hello2"

        //fragment 띄우기
        binding.btnChange.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_main,FragmentA())
                .commit()
        }
    }

    //생애주기
    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause(){
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}