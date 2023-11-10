package com.example.appcenterstudy.study_8th

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.appcenterstudy.ui.theme.AppCenterStudyTheme

@Composable
fun AlarmDialog(
    width : Dp,
    height : Dp,
    text : String,
    onOkClick : () -> Unit,
    onDismissRequest : () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = Modifier
                .width(width)
                .height(height)
                .background(color = Color.White, shape= RoundedCornerShape(size = 25.dp))
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "알림",
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.weight(1f))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = text,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .height(100.dp),
            ){
                Box(
                    modifier = Modifier.fillMaxHeight()
                        .weight(1f)
                        .clickable{
                            onDismissRequest()
                        },
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "취소",
                        fontSize = 20.sp
                    )
                }
                Box(
                    modifier = Modifier.fillMaxHeight()
                        .weight(1f)
                        .clickable{
                            onOkClick()
                        },
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "확인",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TestPre(){
    AppCenterStudyTheme {
        val configuration = LocalConfiguration.current
        val width = configuration.screenWidthDp
        val height = configuration.screenHeightDp
        var dialogState by remember{mutableStateOf(false)}
        Column(
            Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ){
            AlarmDialog(
                width = (width * 0.8).dp,
                height = (height * 0.4).dp,
                text = "test",
                onOkClick = { /*TODO*/ },
                onDismissRequest = {
                    dialogState = !dialogState
                }
            )
        }
    }
}