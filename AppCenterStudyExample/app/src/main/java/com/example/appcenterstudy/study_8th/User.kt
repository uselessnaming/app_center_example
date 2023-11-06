package com.example.appcenterstudy.study_8th

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @ColumnInfo val id : String,
    @ColumnInfo val passwd : String,
    @ColumnInfo val name : String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo val userKey : Int = 0
)