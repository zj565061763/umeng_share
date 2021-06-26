package com.sd.demo.umeng_share.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sd.demo.umeng_share.R
import com.umeng.commonsdk.UMConfigure
import com.umeng.socialize.UMShareAPI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUmengSDK()
    }

    private fun initUmengSDK() {
        UMConfigure.init(this, "59892f08310c9307b60023d0", "Umeng",
                UMConfigure.DEVICE_TYPE_PHONE,
                "669c30a9584623e70e8cd01b0381dcb4")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data)
    }
}