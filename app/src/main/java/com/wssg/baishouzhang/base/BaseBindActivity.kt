package com.wssg.baishouzhang.base

import android.graphics.Color
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding

/**
 * ...
 * @author RQ527 (Ran Sixiang)
 * @email 1799796122@qq.com
 * @date 2023/4/11
 * @Description:
 */
abstract class BaseBindActivity<VB : ViewBinding> : AppCompatActivity() {

    protected val mBinding: VB by lazy {
        DataBindingUtil.setContentView(this, getLayoutId())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        cancelStatusBar()
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    /**
     * 沉浸式状态栏
     */
    private fun cancelStatusBar(isBlack: Boolean = true) {
        val window = this.window
        val decorView = window.decorView

        // 这是 Android 做了兼容的 Compat 包
        // 下面这个设置后会沉浸式状态栏和导航栏
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val windowInsetsController = WindowCompat.getInsetsController(this.window, decorView)
        // 设置状态栏字体颜色为黑色
        windowInsetsController.isAppearanceLightStatusBars = isBlack
        //把状态栏颜色设置成透明
        window.statusBarColor = Color.TRANSPARENT
    }
}