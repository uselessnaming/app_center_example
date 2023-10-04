package com.example.appcenterstudy.MVP

import android.content.Context
import org.json.JSONObject

class InfoRepository(context : Context) : InfoDataSource {
    private val infoLocalDataSource = InfoLocalDataSource(context)

    override fun getInfo(callback: InfoDataSource.LoadInfoCallback) {
        infoLocalDataSource.getInfo(callback)
    }

    override fun saveInfo(info: JSONObject) {
        infoLocalDataSource.saveInfo(info)
    }
}