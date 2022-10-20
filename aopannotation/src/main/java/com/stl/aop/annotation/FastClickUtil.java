package com.stl.aop.annotation;


import android.util.Log;

public class FastClickUtil {
    public static final int MIN_DELAY_TIME = 500;  // 两次点击间隔不能少于500ms
    private static long lastClickTime;

    public static boolean isFastClick() {
        long currentClickTime = System.currentTimeMillis();
        boolean fastClick = (currentClickTime - lastClickTime) < MIN_DELAY_TIME;
        if (!fastClick) {
            lastClickTime = currentClickTime;
        }
        Log.e("wjr","---- isFastClick" + fastClick);
        return fastClick;
    }
}
