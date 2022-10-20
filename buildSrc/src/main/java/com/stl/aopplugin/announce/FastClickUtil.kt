package com.stl.aopplugin.announce

object FastClickUtil {
    private const val MIN_DELAY_TIME = 500 // 两次点击间隔不能少于500ms
    private var lastClickTime: Long = 0
    val isFastClick: Boolean
        get() {
            val currentClickTime = System.currentTimeMillis()
            val fastClick = currentClickTime - lastClickTime < MIN_DELAY_TIME
            if (!fastClick) {
                lastClickTime = currentClickTime
            }
            return fastClick
        }
}