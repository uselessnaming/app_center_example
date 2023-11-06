package com.example.appcenterstudy.study_7th

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("item")
    val items : List<Datas>
)
