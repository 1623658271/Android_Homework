package com.example.thefirsthomework.model

import android.provider.ContactsContract

/**
 * description ： TODO:类的作用
 * author : lfy
 * email : 1623658271@qq.com
 * date : 2022/3/12 22:35
 */
class LoginResponse {
    private lateinit var data:ContactsContract.Data
    private var errorCode:Int = 0
    private lateinit var errorMsg:String
    fun setData(data:ContactsContract.Data) {
        this.data = data
    }
    fun getData():ContactsContract.Data {
        return data
    }

    fun setErrorCode(errorCode:Int) {
        this.errorCode = errorCode
    }
    fun getErrorCode():Int {
        return errorCode
    }

    fun setErrorMsg(errorMsg:String) {
        this.errorMsg = errorMsg
    }
    fun getErrorMsg():String {
        return errorMsg
    }
}