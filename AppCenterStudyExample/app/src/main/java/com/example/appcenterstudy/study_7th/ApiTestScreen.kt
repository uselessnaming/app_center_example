package com.example.appcenterstudy.study_7th

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcenterstudy.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

val KEY =  "vmT9%2Fs1RcJq8a2EZgIHRD%2FwBd0TxQrnyHNAaYCZ1VVgz1XXF2NxRn%2FVYj8T688r%2FR%2FX6E7EmndHARvn5I%2FzHhA%3D%3D"

@Composable
fun ApiTestScreen(){

    var isClicked by remember{mutableStateOf(false)}

    val areaAPI = RetrofitClient.getAreaAPI()
    lateinit var resultData : ResponseDTO

    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        if (isClicked){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
            ){
                runBlocking{
                    dataFetch(
                        coroutineScope = coroutineScope,
                        onDataChange = {
                            resultData = it
                        },
                        areaAPI = areaAPI
                    )
                }

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "API TEST"
                )

                LazyColumn{
                    val resultList = resultData.response.body.items.items
                    items(resultList){data ->
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "appDate : ${data.appDate} " +
                                    "\n" +
                                    "bsn_ne : ${data.bsn_se}" +
                                    "\n" +
                                    "bsshName : ${data.bsshName}" +
                                    "\n" +
                                    "crType : ${data.crType}" +
                                    "\n" +
                                    "representer name : ${data.repName}" +
                                    "\n" +
                                    "road name : ${data.roadName}"
                        )
                    }
                }
            }
        }
        else {
            Button(
                onClick = {
                    isClicked = !isClicked
                }
            ) {
                Text(
                    text = "정보 확인"
                )
            }
        }
    }
}

suspend fun dataFetch(
    coroutineScope : CoroutineScope,
    onDataChange : (ResponseDTO) -> Unit,
    areaAPI: AreaAPI
){
    val result = coroutineScope.async(Dispatchers.IO){
        val call = areaAPI.getData(
            serviceKey = KEY,
            pageNo = "1",
            rows = "10"
        )
        val response = call.execute()
        var resultData : ResponseDTO? = null
        Log.d("STUDY TEST","resultdata : ${response.code()}")
        try{
            if(response.isSuccessful){
                when(response.code()){
                    //Success
                    200 -> {
                        resultData = response.body() ?: throw NullPointerException("Data is NULL")
                    }
                    //not exact information
                    401 -> {
                        throw Exception("401 : 정확하지 않은 정보입니다.")
                    }
                    //api server occurs error
                    500 -> {
                        throw Exception("500 : API 서버 오류 발생")
                    }
                }
            } else {
                throw Exception("접속 불가 오류")
            }
        } catch(e : Exception){
            throw Exception("Error : ${e.message}")
        }
        return@async resultData
    }.await()

    onDataChange(result ?: throw NullPointerException("Data is NULL"))
}
