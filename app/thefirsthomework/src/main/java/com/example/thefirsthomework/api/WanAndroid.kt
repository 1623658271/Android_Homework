package com.example.thefirsthomework.api

import com.example.thefirsthomework.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * description ： TODO:类的作用
 * author : lfy
 * email : 1623658271@qq.com
 * date : 2022/3/12 22:29
 */
interface WanAndroid {
    @POST("user/login")
    @FormUrlEncoded
    fun login(@Field("username")username:String,@Field("password")password:String):Call<LoginResponse>
}