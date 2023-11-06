package com.example.appcenterstudy.study_7th

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface AreaAPI {

    @GET("getData")
    fun getData(
        @Query("serviceKey") serviceKey : String,
        @Query("pageNo") pageNo : String,
        @Query("numOfRows") rows : String,
        @Query("PRPSNTV_NM") presenterName : String = "",
        @Query("BSSH_NM") coName : String = "",
        @Query("RDNMADR") roadName : String = "",
        @Query("APPN_DE") appDate : String = "",
        @Query("CPR_SE") crp_se : String = "",
        @Query("BSN_SE") bsn_se : String = ""
    ) : Call<ResponseDTO>
}