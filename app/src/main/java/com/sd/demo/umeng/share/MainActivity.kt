package com.sd.demo.umeng.share

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.sd.demo.umeng.share.databinding.ActivityMainBinding
import com.sd.lib.umeng.common.LibUmengCommon
import com.sd.lib.umeng.share.LibUmengShare
import com.tencent.tauth.Tencent


class MainActivity : BaseActivity(), View.OnClickListener {
    private val _binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(_binding.root)

        LibUmengCommon.init()
        LibUmengShare.init(
            context = this,
            wechatAppId = getString(R.string.wechat_app_id),
            wechatAppSecret = getString(R.string.wechat_app_secret),
            qqAppId = getString(R.string.qq_app_id),
            qqAppKey = getString(R.string.qq_app_key),
            sinaAppKey = getString(R.string.sina_app_key),
            sinaAppSecret = getString(R.string.sina_app_secret),
        )

        // 错误码:2002 错误信息:授权失败
        Tencent.setIsPermissionGranted(true)
    }

    override fun onClick(v: View?) {
        when (v) {
            _binding.btnLogin -> startActivity(Intent(this, LoginActivity::class.java))
            _binding.btnShare -> startActivity(Intent(this, ShareActivity::class.java))
        }
    }
}

inline fun logMsg(block: () -> String) {
    Log.i("umeng-share-demo", block())
}