package com.sd.demo.umeng_share.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.umeng.socialize.UMShareAPI

open class BaseActivity : AppCompatActivity() {
    private var _shareAPI: UMShareAPI? = null

    val shareAPI by lazy {
        UMShareAPI.get(this).also { _shareAPI = it }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        shareAPI.onActivityResult(requestCode, resultCode, data)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        shareAPI.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _shareAPI?.release()
    }
}