package com.example.appcenterstudy.study_5th

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appcenterstudy.study_8th.AlarmDialog
import com.example.appcenterstudy.study_8th.UserViewModel
import com.example.appcenterstudy.ui.theme.AppCenterStudyTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController : NavController
){
    var idState by remember{ mutableStateOf("") }
    var passwdState by remember{mutableStateOf("")}

    val coroutineScope = rememberCoroutineScope()
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val height = configuration.screenHeightDp

    var showDialog by remember{mutableStateOf(false)}
    var dialogMessage by remember{mutableStateOf("")}

    val context = LocalContext.current
    val userViewModel = UserViewModel(context)

    if (showDialog){
        AlarmDialog(
            width = (width * 0.8).dp,
            height = (height * 0.3).dp,
            text = dialogMessage,
            onOkClick = {
                showDialog = false
            },
            onDismissRequest = {
                showDialog = false
            }
        )
        if (dialogMessage == "로그인 성공"){
            //로그인
            navController.navigate(Screens.HomeScreen.name)
        } else if (dialogMessage == "로그인 실패.\n" + "정보를 확인해주세요"){
            idState = ""
            passwdState = ""
        }
    }

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
                },
                singleLine = true,
                maxLines = 1
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
                },
                singleLine = true,
                maxLines = 1,
                visualTransformation = PasswordVisualTransformation()
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
                    coroutineScope.launch(Dispatchers.IO){
                        /**
                         * id가 NotEmpty, passwd가 NotEmpty일 때 로그인 수행
                         */
                        if (idState.isNotEmpty() && passwdState.isNotEmpty()){
                            dialogMessage = userViewModel.login(idState, passwdState)
                        } else if (idState.isEmpty()){
                            dialogMessage = "아이디를 입력해주세요"
                        } else {
                            dialogMessage = "비밀번호를 입력해주세요"
                        }
                        showDialog = true
                    }
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
                    .padding(bottom = 1.dp)
                    .clickable{
                        navController.navigate(Screens.AddUserScreen.name)
                    },
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