package com.example.thefirsthomework.respository

import com.example.thefirsthomework.api.WanAndroid
import com.example.thefirsthomework.model.LoginResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * description ： TODO:类的作用
 * author : lfy
 * email : 1623658271@qq.com
 * date : 2022/3/12 22:50
 */
class MyRetrofit {
    fun loginPost(username: String, password: String): Call<LoginResponse> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com")
            .addConverterFactory(GsonConverterFactory.create())//添加转换器
            .build()
        val wanAndroid = retrofit.create(WanAndroid::class.java)
        return wanAndroid.login(username, password)
    }
}