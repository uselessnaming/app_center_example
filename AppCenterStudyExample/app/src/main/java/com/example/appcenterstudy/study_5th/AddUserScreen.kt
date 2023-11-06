package com.example.appcenterstudy.study_5th

import android.util.Log
import androidx.annotation.experimental.Experimental
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appcenterstudy.study_8th.AlarmDialog
import com.example.appcenterstudy.study_8th.User
import com.example.appcenterstudy.study_8th.UserViewModel
import com.example.appcenterstudy.ui.theme.AppCenterStudyTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddUserScreen(
    navController: NavController
){
    var isDuplicated by remember{mutableStateOf(true)}

    var idState by remember{ mutableStateOf("") }
    var passwdState by remember{mutableStateOf("")}
    var name by remember{ mutableStateOf("") }

    var showDialog by remember{mutableStateOf(false)}
    var dialogMessage by remember{mutableStateOf("")}

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val userViewModel = UserViewModel(context)

    val width = configuration.screenWidthDp
    val height = configuration.screenHeightDp

    if (showDialog){
        AlarmDialog(
            width = (width * 0.8).dp,
            height = (height * 0.3).dp,
            text = dialogMessage,
            onOkClick = {
                showDialog = false
                if (dialogMessage == "추가 완료"){
                    navController.navigate(Screens.LoginScreen.name)
                }
            },
            onDismissRequest = {
                showDialog = false
            }
        )
    }

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
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
        ){
            Spacer(Modifier.weight(1f))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    modifier = Modifier.width(100.dp),
                    text = "아이디",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(500),
                    textAlign = TextAlign.Center
                )

                TextField(
                    modifier = Modifier.weight(1f),
                    value = idState,
                    onValueChange = {
                        idState = it
                    }
                )

                Button(
                    modifier = Modifier
                        .width(125.dp)
                        .padding(horizontal = 10.dp)
                        .border(
                            width = 0.5.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(25.dp)
                        ),
                    onClick = {
                        /**
                         * idState가 비어있으면 내용을 입력해주세요
                         */
                        coroutineScope.launch(Dispatchers.IO){
                            if (idState.isNotEmpty()){
                                /**
                                 * 중복된 아이디 있을 때 >> 아이디가 이미 존재합니다.
                                 * 없을 때 >> 확인 완료 후 isDuplicated false로 변환
                                 **/
                                if (!userViewModel.checkDupUser(idState)) {
                                    dialogMessage = "사용 가능한 아이디입니다."
                                    isDuplicated = false
                                } else {
                                    dialogMessage = "아이디가 존재합니다."
                                    isDuplicated = true
                                }
                            } else {
                                dialogMessage = "아이디를 입력해주세요."
                            }
                            showDialog = true
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Unspecified,
                        contentColor = if(isDuplicated) Color.Black else Color.Gray
                    ),
                    enabled = isDuplicated
                ) {
                    Text(
                        text = "중복 확인",
                        fontWeight = FontWeight(600)
                    )
                }
            }
            Spacer(Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    modifier = Modifier.width(100.dp),
                    text = "비밀번호",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(500),
                    textAlign = TextAlign.Center
                )

                TextField(
                    modifier = Modifier.weight(1f),
                    value = passwdState,
                    onValueChange = {
                        passwdState = it
                    }
                )
            }
            Spacer(Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    modifier = Modifier.width(100.dp),
                    text = "이름",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(500),
                    textAlign = TextAlign.Center
                )

                TextField(
                    modifier = Modifier.weight(1f),
                    value = name,
                    onValueChange = {
                        name = it
                    },
                )
            }
            Spacer(Modifier.height(50.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Button(
                    onClick = {
                        navController.navigateUp()
                    }
                ) {
                    Text(
                        text = "취소"
                    )
                }

                Spacer(Modifier.width(30.dp))

                Button(
                    onClick = {
                        /**
                         * isDuplicated가 false고 passwdState와 nameState가 isNotEmpty일 때 회원 가입
                         */
                        if (passwdState.isNotEmpty() && name.isNotEmpty()){
                            Log.d("AppcenterTest","isDuplicated : ${isDuplicated}")
                            if (!isDuplicated){
                                coroutineScope.launch(Dispatchers.IO){
                                    val newUser = User(
                                        id = idState,
                                        passwd = passwdState,
                                        name = name
                                    )
                                    userViewModel.insertUser(newUser)
                                    dialogMessage = "추가 완료"
                                }
                            } else {
                                dialogMessage = "중복 처리를 확인해주세요."
                            }
                        } else if (passwdState.isEmpty()) {
                            dialogMessage = "비밀번호를 입력해주세요."
                        } else {
                            dialogMessage = "이름을 입력해주세요."
                        }
                        showDialog = true
                    }
                ) {
                    Text(
                        text = "추가"
                    )
                }
            }
            Spacer(Modifier.weight(1f))
        }
    }
}

@Composable
@Preview
fun Test(){
    AppCenterStudyTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ){
            AddUserScreen(navController = rememberNavController())
        }
    }
}