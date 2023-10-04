package com.example.appcenterstudy.study_1st.MVP

import org.json.JSONObject

interface Contract {
    interface View{
        //textview에 info를 보여줌
        fun showInfo(info : JSONObject)
    }

    interface Presenter{
        fun initInfo()
        fun setInfo(info : JSONObject)
        fun saveInfo(info : JSONObject)
    }
}