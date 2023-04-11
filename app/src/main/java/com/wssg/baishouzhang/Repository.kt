package com.wssg.baishouzhang

import com.wssg.baishouzhang.room.AppDataBase
import com.wssg.baishouzhang.room.RoomBean

/**
 * ...
 * @author RQ527 (Ran Sixiang)
 * @email 1799796122@qq.com
 * @date 2023/4/10
 * @Description:
 */
object Repository {
    suspend fun getAll() = AppDataBase.INSTANCE.dao().getAll()

    suspend fun insert(roomBean: RoomBean) = AppDataBase.INSTANCE.dao().add(roomBean)
}