package com.example.appcenterstudy.study_8th

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

//토큰 저장
fun saveAuthToken(context : Context, token : String){
    val authTokenKey = stringPreferencesKey("auth_token")

    runBlocking{
        context.dataStore.edit{
            it[authTokenKey] = token
        }
    }
}

//토큰 읽기
fun readAuthToken(context : Context) : String?{
    val authTokenKey = stringPreferencesKey("auth_token")

    return runBlocking{
        context.dataStore.data.first()[authTokenKey]
    }
}