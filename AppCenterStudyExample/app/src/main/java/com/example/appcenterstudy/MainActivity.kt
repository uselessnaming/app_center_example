package com.example.appcenterstudy

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.databinding.DataBindingUtil
import com.example.appcenterstudy.databinding.ActivityMainBinding
import com.example.appcenterstudy.study_3rd.DataViewModel
import com.example.appcenterstudy.study_3rd.HomeFragment
import com.example.appcenterstudy.study_4th.LoginScreen
import com.example.appcenterstudy.ui.theme.AppCenterStudyTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCenterStudyTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ){
                    LoginScreen()
                }
            }
        }
    }
}