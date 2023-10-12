package com.example.appcenterstudy.study_5th

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController : NavController
){
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
            modifier = Modifier.fillMaxSize()
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