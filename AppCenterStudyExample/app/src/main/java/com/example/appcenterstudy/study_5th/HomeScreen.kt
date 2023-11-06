package com.example.appcenterstudy.study_5th

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController : NavController
){
    //뒤로가기 클릭 여부
    var backPressed by remember{mutableStateOf(false)}

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    //back event
    BackHandler {
        //뒤로가기 두 번에 종료
        if (backPressed){
            (context as? Activity)?.finish()
        } else {
            backPressed = true
            Toast.makeText(context,"한 번 더 누르면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show()

            coroutineScope.launch(Dispatchers.Main){
                delay(2000)
                backPressed = false
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AppBar(
            title = "HomeScreen",
            navIcon = Icons.Filled.Home,
            onNavClick = {
                navController.navigate(Screens.HomeScreen.name)
            },
            menuIcon = Icons.Filled.Menu,
            onMenuClick = {
                //menu open
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "투두",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}