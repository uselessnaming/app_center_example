package com.example.appcenterstudy.study_5th

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title : String,
    navIcon : ImageVector,
    onNavClick : () -> Unit,
    menuIcon : ImageVector?,
    onMenuClick : () -> Unit = {}
){
    TopAppBar(
        title = {
            Text(title)
        },
        navigationIcon = {
            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = onNavClick
            ) {
                Icon(
                    imageVector = navIcon,
                    contentDescription = "Navigation Icon"
                )
            }
        },
        actions = {
            if (menuIcon != null){
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = onMenuClick
                ) {
                    Icon(
                        imageVector = menuIcon,
                        contentDescription = "Menu Icon"
                    )
                }
            } else {
                Spacer(Modifier.size(24.dp))
            }
        }
    )
}