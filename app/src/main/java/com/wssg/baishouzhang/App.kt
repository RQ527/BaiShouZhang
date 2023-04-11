package com.wssg.baishouzhang

import android.app.Application

/**
 * ...
 * @author RQ527 (Ran Sixiang)
 * @email 1799796122@qq.com
 * @date 2023/4/11
 * @Description:
 */
class App : Application() {

    companion object {
        lateinit var mContext: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
    }

}