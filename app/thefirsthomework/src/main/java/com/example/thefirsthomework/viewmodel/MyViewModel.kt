package com.example.thefirsthomework.viewmodel

import android.content.Context
import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.*
import com.example.thefirsthomework.model.User
import com.example.thefirsthomework.respository.MyRetrofit
import com.example.thefirsthomework.view.IViewChange

/**
 * description ： TODO:类的作用
 * author : lfy
 * email : 1623658271@qq.com
 * date : 2022/3/12 22:58
 */
class MyViewModel(context: Context):ViewModel(),IViewChange,LifecycleObserver {
    private var user:MutableLiveData<User> = MutableLiveData()
    private var context:Context = context

    fun getUser():MutableLiveData<User>{
        return user
    }

    fun login(context: Context){
        Thread{
            val myRetrofit = MyRetrofit()
            val call = myRetrofit.loginPost(user.value!!.username, user.value!!.password)
            val response = call.execute()
            Looper.prepare()
            if(response.body()!!.getErrorCode()==0){
                showOKOrNot(context,true)
            }else{
                showOKOrNot(context,false)
            }
        }.start()
    }

    override fun showOKOrNot(context: Context,flag:Boolean) {

        if(flag) {
            Toast.makeText(context, "登陆成功", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "登陆失败", Toast.LENGTH_SHORT).show()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate1(){
        Toast.makeText(context,"活动开机Lifecycle1",Toast.LENGTH_SHORT).show()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onCreate2(){
        Toast.makeText(context,"活动关机Lifecycle2",Toast.LENGTH_SHORT).show()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onCreate3(){
        Toast.makeText(context,"活动暂停Lifecycle3",Toast.LENGTH_SHORT).show()
    }

}