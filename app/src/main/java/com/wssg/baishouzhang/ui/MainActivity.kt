package com.wssg.baishouzhang.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.wssg.baishouzhang.viewmodel.MainViewModel
import com.wssg.baishouzhang.R
import com.wssg.baishouzhang.base.BaseBindActivity
import com.wssg.baishouzhang.databinding.ActivityMainBinding
import com.wssg.baishouzhang.room.RoomBean


class MainActivity : BaseBindActivity<ActivityMainBinding>() {

    private val mViewModel by viewModels<MainViewModel>()
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.button.setOnClickListener {
            mViewModel.insert(RoomBean(1,"测试","测试"))
            mViewModel.getAll()
        }
        mViewModel.homeLiveData.observe(this){

        }
        mViewModel.netErrorLiveData.observe(this){
            if (it) Toast.makeText(this, "网络错误~", Toast.LENGTH_SHORT).show()
        }
        mViewModel.allLiveData.observe(this){

        }
    }

}