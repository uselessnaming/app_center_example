package com.example.appcenterstudy.study_4th

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.example.appcenterstudy.ui.theme.AppCenterStudyTheme

@Composable
fun TestLayout(){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ){
        LoginScreen()
    }

}

@Preview
@Composable
fun TT(){
    AppCenterStudyTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
        ){
            LoginScreen()
        }
    }
}


@Composable
fun ComposeButton(
    size : Dp,
    buttonTest : ImageVector,
    onClick : () -> Unit,
){
    Box(
        modifier = Modifier.size(size)
    ){
        IconButton(
            onClick = onClick
        ) {
            Icon(
                imageVector = buttonTest,
                contentDescription = null
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(){

    var test by remember{mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "로그인 화면",
            fontSize = 26.sp,
        )

        TextField(
            value = test,
            onValueChange = {
                test = it
            }
        )

        Text(
            text = "test"
        )
    }
}