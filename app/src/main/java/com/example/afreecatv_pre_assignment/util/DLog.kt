package com.example.afreecatv_pre_assignment.util

import android.util.Log
import com.example.afreecatv_pre_assignment.BuildConfig

/** ===========================================================
 * @objectName : DLog
 * @author : jaehyeok.yu
 * @createDate : 2022-07-21
 * @description : Debug일때만 Log 출력하는 object class
 * =========================================================== */

object DLog {
    fun e(tag: String?, message: String?) {
        if (BuildConfig.DEBUG) Log.e(tag, message!!)
    }

    fun d(tag: String?, message: String?) {
        if (BuildConfig.DEBUG) Log.d(tag, message!!)
    }

    fun i(tag: String?, message: String?) {
        if (BuildConfig.DEBUG) Log.i(tag, message!!)
    }

    fun w(tag: String?, message: String?) {
        if (BuildConfig.DEBUG) Log.w(tag, message!!)
    }
}