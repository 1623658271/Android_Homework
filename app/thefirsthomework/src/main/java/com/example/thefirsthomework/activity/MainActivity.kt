package com.example.thefirsthomework.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.thefirsthomework.R
import com.example.thefirsthomework.databinding.ActivityMainBinding
import com.example.thefirsthomework.model.User
import com.example.thefirsthomework.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var myViewModel:MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        myViewModel = MyViewModel(this)
        dataBinding.loginMessage = myViewModel
        val user = User()
        myViewModel.getUser().value = user
        lifecycle.addObserver(myViewModel)
    }

    fun clickEvent(view: android.view.View) {
        myViewModel.login(this)
    }

}