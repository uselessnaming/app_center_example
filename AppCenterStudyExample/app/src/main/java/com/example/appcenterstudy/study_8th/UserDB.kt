package com.example.appcenterstudy.study_8th

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version=1)
abstract class UserDB : RoomDatabase() {

    abstract fun UserDao() : UserDao

    companion object{
        private var instance : UserDB? = null

        fun getInstance(context : Context) : UserDB = instance ?: synchronized(this){
            instance ?: buildDatabase(context).also{instance = it}
        }

        private fun buildDatabase(context : Context) : UserDB {
            return Room.databaseBuilder(
                context,
                UserDB::class.java,
                "User.db").build()
        }
    }
}