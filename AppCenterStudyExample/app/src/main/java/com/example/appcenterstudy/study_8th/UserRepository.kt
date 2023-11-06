package com.example.appcenterstudy.study_8th

import android.content.Context
import android.util.Log

class UserRepository(context : Context) {
    private var userDB : UserDB
    private var userDao : UserDao

    init {
        userDB = UserDB.getInstance(context)
        userDao = userDB.UserDao()
    }

    fun insertUser(user : User){
        userDao.addUser(user)
    }

    fun deleteUser(user : User){
        userDao.delUser(user)
    }

    fun updateUser(user : User){
        userDao.update(user)
    }

    fun getUserById(id : String, passwd : String) : User? {
        return userDao.getUserById(id, passwd)
    }

    fun checkDupUser(id : String) : Boolean{
        return userDao.checkDupId(id) != null
    }
}