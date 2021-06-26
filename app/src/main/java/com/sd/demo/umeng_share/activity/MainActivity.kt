package com.sd.demo.umeng_share.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.sd.demo.umeng_share.databinding.ActivityMainBinding
import com.sd.lib.umeng_share.LibUmengShare
import com.umeng.commonsdk.UMConfigure
import com.umeng.socialize.UMAuthListener
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.UMShareConfig
import com.umeng.socialize.bean.SHARE_MEDIA


class MainActivity : BaseActivity(), View.OnClickListener {
    private val TAG = MainActivity::class.java.simpleName
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        initUmengSDK()
    }

    private fun initUmengSDK() {
        UMConfigure.init(this, "59892f08310c9307b60023d0", "Umeng",
                UMConfigure.DEVICE_TYPE_PHONE,
                "669c30a9584623e70e8cd01b0381dcb4")

        val config = UMShareConfig()
        config.isNeedAuthOnGetUserInfo(true)
        UMShareAPI.get(this).setShareConfig(config)

        LibUmengShare.init(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            _binding.btnLoginQq -> loginQQ()
            _binding.btnLoginWechat -> loginWechat()
            _binding.btnLoginSina -> {

            }
        }
    }

    /**
     * QQ登录
     */
    private fun loginQQ() {
        val isInstall = shareAPI.isInstall(this, SHARE_MEDIA.QQ)
        if (!isInstall) {
            Toast.makeText(this, "QQ未安装", Toast.LENGTH_SHORT).show()
            return
        }

        shareAPI.getPlatformInfo(this, SHARE_MEDIA.QQ, _umAuthListener)
    }

    /**
     * 微信登录
     */
    private fun loginWechat() {
        val isInstall = shareAPI.isInstall(this, SHARE_MEDIA.WEIXIN)
        if (!isInstall) {
            Toast.makeText(this, "微信未安装", Toast.LENGTH_SHORT).show()
            return
        }

        shareAPI.getPlatformInfo(this, SHARE_MEDIA.WEIXIN, _umAuthListener)
    }

    /**
     * 授权监听
     */
    private val _umAuthListener = object : UMAuthListener {
        override fun onStart(platform: SHARE_MEDIA) {
            Log.i(TAG, "onStart ${platform}")
        }

        override fun onComplete(platform: SHARE_MEDIA, action: Int, data: MutableMap<String, String>) {
            Log.i(TAG, "onComplete ${platform} data:${data}")
        }

        override fun onError(platform: SHARE_MEDIA, action: Int, throwable: Throwable) {
            Log.e(TAG, "onError ${platform} throwable:${throwable}")
        }

        override fun onCancel(platform: SHARE_MEDIA, action: Int) {
            Log.i(TAG, "onCancel ${platform}")
        }
    }
}