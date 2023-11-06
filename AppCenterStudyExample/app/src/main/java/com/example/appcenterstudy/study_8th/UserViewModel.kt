package com.example.appcenterstudy.study_8th

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UserViewModel(context : Context) : ViewModel() {

    private val userRepo : UserRepository = UserRepository(context)

    private val _user : MutableLiveData<User> = MutableLiveData()

    val user : LiveData<User>
        get() = _user

    suspend fun login(id : String, passwd : String) =
        viewModelScope.async(Dispatchers.IO) {
            val result = userRepo.getUserById(id, passwd)
            var message = "로그인 성공"
            if(result == null){
                message = "로그인 실패.\n정보를 확인해주세요"
            } else {
                _user.postValue(result!!)
            }
            return@async message
        }.await()

    fun insertUser(user : User){
        viewModelScope.launch(Dispatchers.IO){
            userRepo.insertUser(user)
        }
    }

    suspend fun checkDupUser(id : String) : Boolean =
        viewModelScope.async(Dispatchers.IO) {
            return@async userRepo.checkDupUser(id)
        }.await()
}