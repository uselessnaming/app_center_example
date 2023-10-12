package com.example.appcenterstudy.study_5th

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddUserScreen(
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ){
        AppBar(
            title = "회원 가입",
            navIcon = Icons.Filled.ArrowBack,
            onNavClick = {
                navController.navigateUp()
            },
            menuIcon = null
        )

        Column(
            modifier = Modifier.fillMaxSize()
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
        ){

        }
    }
}