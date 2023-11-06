package com.example.appcenterstudy.study_7th

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("header")
    val header : Header,
    @SerializedName("body")
    val body : Body
)
