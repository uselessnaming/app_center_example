package com.example.appcenterstudy.study_8th

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Insert
    fun addUser(user : User)

    @Delete
    fun delUser(user : User)

    @Update
    fun update(user : User)

    @Query("SELECT * FROM User WHERE id = (:id) and passwd = (:passwd)")
    fun getUserById(id : String, passwd : String) : User?

    @Query("SELECT * FROM User WHERE id = (:id)")
    fun checkDupId(id : String) : User?
}