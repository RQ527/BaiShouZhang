package com.wssg.baishouzhang.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wssg.baishouzhang.Repository
import com.wssg.baishouzhang.base.BaseViewModel
import com.wssg.baishouzhang.bean.HomeData
import com.wssg.baishouzhang.room.RoomBean
import com.wssg.baishouzhang.network.ApiService
import com.wssg.baishouzhang.network.api

/**
 * ...
 * @author RQ527 (Ran Sixiang)
 * @email 1799796122@qq.com
 * @date 2023/4/10
 * @Description:
 */
class MainViewModel : BaseViewModel() {
    val homeLiveData: LiveData<HomeData>
        get() = _homeLiveData
    private val _homeLiveData = MutableLiveData<HomeData>()
    fun getData() {
        launch(_homeLiveData) { ApiService::class.api.getData() }
    }


    val allLiveData: LiveData<List<RoomBean>>
        get() = _allLiveData
    private val _allLiveData = MutableLiveData<List<RoomBean>>()
    fun getAll() {
        launch(_allLiveData) { Repository.getAll() }
    }

    fun insert(roomBean: RoomBean) = launch { Repository.insert(roomBean) }
}