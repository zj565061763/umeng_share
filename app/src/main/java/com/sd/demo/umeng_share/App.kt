package com.sd.demo.umeng_share

import android.app.Application
import com.sd.lib.umeng_common.LibUmengCommon
import com.umeng.commonsdk.UMConfigure

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        LibUmengCommon.preInit(this)
    }
}