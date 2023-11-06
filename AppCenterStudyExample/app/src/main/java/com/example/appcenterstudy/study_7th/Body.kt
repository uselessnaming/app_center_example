package com.example.appcenterstudy.study_7th

import com.google.gson.annotations.SerializedName

data class Body(
    @SerializedName("pageNo")
    val pageNo : Int,
    @SerializedName("numOfRows")
    val rows : Int,
    @SerializedName("totalCount")
    val totalCount : Int,
    @SerializedName("items")
    val items : Item
)
