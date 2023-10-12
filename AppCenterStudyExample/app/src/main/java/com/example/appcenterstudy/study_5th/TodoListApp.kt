package com.example.appcenterstudy.study_5th

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun TodoListApp(){
    val navController = rememberNavController()

    //navigate
    NavHost(
        navController = navController,
        startDestination = Screens.LoginScreen.name
    ){
        composable(Screens.LoginScreen.name){
            LoginScreen(
                navController = navController
            )
        }
        composable(Screens.HomeScreen.name){
            HomeScreen(
                navController = navController
            )
        }
        composable(Screens.AddUserScreen.name){
            AddUserScreen(
                navController = navController
            )
        }
    }
}