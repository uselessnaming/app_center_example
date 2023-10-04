package com.example.appcenterstudy.study_1st.MVP

import org.json.JSONObject

interface InfoDataSource {
    interface LoadInfoCallback{
        fun onInfoLoaded(info : JSONObject)
        fun onDataNotAvailable()
    }

    fun getInfo(callback : LoadInfoCallback)
    fun saveInfo(info : JSONObject)
}