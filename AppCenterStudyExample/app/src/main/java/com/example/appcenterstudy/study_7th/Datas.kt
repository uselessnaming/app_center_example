package com.example.appcenterstudy.study_7th

import com.google.gson.annotations.SerializedName

data class Datas(
    @SerializedName("RPRSNTV_NM")
    val repName : String,
    @SerializedName("BSSH_NM")
    val bsshName : String,
    @SerializedName("RDNMADR")
    val roadName : String,
    @SerializedName("APPN_DE")
    val appDate : String,
    @SerializedName("CPR_SE")
    val crType : String,
    @SerializedName("BSN_SE")
    val bsn_se : String
)
