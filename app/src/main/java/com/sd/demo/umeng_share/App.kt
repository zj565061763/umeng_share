package com.sd.demo.umeng_share

import android.app.Application
import com.sd.lib.umeng_common.LibUmengCommon
import com.umeng.commonsdk.UMConfigure

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        UMConfigure.setLogEnabled(true)
        LibUmengCommon.preInit(this, "59892f08310c9307b60023d0")
    }
}