package com.wssg.baishouzhang.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ...
 * @author RQ527 (Ran Sixiang)
 * @email 1799796122@qq.com
 * @date 2023/4/10
 * @Description:
 */
abstract class BaseViewModel : ViewModel() {

    /**
     * 网络请求错误
     */
    val netErrorLiveData: LiveData<Boolean>
        get() = _netErrorLiveData
    private val _netErrorLiveData = MutableLiveData<Boolean>()

    /**
     * 本地请求错误
     */
    val localErrorLiveData: LiveData<Boolean>
        get() = _localErrorLiveData
    private val _localErrorLiveData = MutableLiveData<Boolean>()

    /**
     * 有返回值的请求
     */
    fun <T : Any> launch(
        liveData: MutableLiveData<T>,
        isNet: Boolean = true,
        block: suspend () -> T
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = block()
                if (isNet) _netErrorLiveData.postValue(false)
                else _localErrorLiveData.postValue(false)
                liveData.postValue(data)
            } catch (e: Exception) {
                e.printStackTrace()
                if (isNet) _netErrorLiveData.postValue(true)
                else _localErrorLiveData.postValue(true)
            }
        }
    }

    /**
     * 无返回指定的请求
     */
    fun launch(isNet: Boolean = false, block: suspend () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                block()
                if (!isNet) _localErrorLiveData.postValue(false)
                else _netErrorLiveData.postValue(false)
            } catch (e: Exception) {
                if (!isNet) _localErrorLiveData.postValue(true)
                else _netErrorLiveData.postValue(true)
            }
        }
    }
}