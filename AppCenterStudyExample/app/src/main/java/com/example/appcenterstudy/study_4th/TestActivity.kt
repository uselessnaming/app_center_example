package com.example.appcenterstudy.study_4th

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.appcenterstudy.study_5th.LoginScreen
import com.example.appcenterstudy.ui.theme.AppCenterStudyTheme

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