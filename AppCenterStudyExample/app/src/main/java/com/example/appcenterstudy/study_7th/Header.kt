package com.example.appcenterstudy.study_7th

import com.google.gson.annotations.SerializedName

data class Header(
    @SerializedName("resultCode")
    val resultCode : String,
    @SerializedName("resultMsg")
    val resultMsg : String
)
