package com.wssg.baishouzhang.network

import com.wssg.baishouzhang.bean.HomeData
import retrofit2.http.GET

/**
 * ...
 * @author RQ527 (Ran Sixiang)
 * @email 1799796122@qq.com
 * @date 2023/4/10
 * @Description:
 */
interface ApiService : IApi {
    @GET("/")
    suspend fun getData(): HomeData
}