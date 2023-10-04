package com.example.appcenterstudy.MVP

import android.os.Bundle
import android.view.AbsSavedState
import androidx.activity.ComponentActivity
import com.example.appcenterstudy.databinding.ActivityMvpBinding
import org.json.JSONObject

class MvpActivity : ComponentActivity(), Contract.View {

    private lateinit var presenter: Presenter
    private lateinit var repository: InfoRepository
    private lateinit var binding : ActivityMvpBinding

    override fun onCreate(savedInstanceState : Bundle?){
        binding = ActivityMvpBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)

        repository = InfoRepository(this)
        presenter = Presenter(this@MvpActivity, repository)

        presenter.initInfo()
        initButtonListener()
    }

    override fun showInfo(info : JSONObject){
        binding.outputName.text = info.getString("name")
        binding.outputEmail.text = info.getString("email")
    }

    fun initButtonListener(){
        binding.btnSave.setOnClickListener {
            var info = JSONObject()
            info.put("name",binding.editName.text.toString())
            info.put("email",binding.editEmail.text.toString())

            binding.editName.text.clear()
            binding.editEmail.text.clear()

            presenter.setInfo(info)
            presenter.saveInfo(info)
        }
    }
}