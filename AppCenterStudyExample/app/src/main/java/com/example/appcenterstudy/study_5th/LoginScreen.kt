package com.example.appcenterstudy.study_5th

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appcenterstudy.ui.theme.AppCenterStudyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController : NavController
){
    var idState by remember{ mutableStateOf("") }
    var passwdState by remember{mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 10.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "로그인 화면",
            fontSize = 30.sp,
        )

        Spacer(Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                modifier = Modifier.weight(1f),
                text = "아이디",
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                textAlign = TextAlign.Center
            )

            TextField(
                modifier = Modifier.weight(3f),
                value = idState,
                onValueChange = {
                    idState = it
                }
            )
        }

        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                modifier = Modifier.weight(1f),
                text = "비밀번호",
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                textAlign = TextAlign.Center
            )

            TextField(
                modifier = Modifier.weight(3f),
                value = passwdState,
                onValueChange = {
                    passwdState = it
                }
            )
        }

        Spacer(Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                modifier = Modifier.width(100.dp),
                onClick = {
                    //로그인
                    navController.navigate(Screens.HomeScreen.name)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text(
                    text = "로그인",
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 1.dp),
                text = "회원 가입",
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
            Box(
                Modifier
                    .width(2.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 1.dp),
                text = "아이디 찾기",
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
            Box(
                Modifier
                    .width(2.dp)
                    .fillMaxHeight()
                    .background(Color.Gray)
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 1.dp),
                text = "비밀번호 찾기",
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
        }

        Spacer(Modifier.weight(1f))
    }
}

@Preview
@Composable
fun TestLogin(){
    AppCenterStudyTheme {
        LoginScreen(navController = rememberNavController())
    }
}