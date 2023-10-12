package com.example.appcenterstudy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.appcenterstudy.study_5th.TodoListApp
import com.example.appcenterstudy.ui.theme.AppCenterStudyTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCenterStudyTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ){
                    TodoListApp()
                }
            }
        }
    }
}