package com.sd.demo.umeng.share

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sd.demo.umeng.share.databinding.ActivityLoginBinding
import com.umeng.socialize.UMAuthListener
import com.umeng.socialize.bean.SHARE_MEDIA

class LoginActivity : BaseActivity(), View.OnClickListener {
    private val _binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(_binding.root)
    }

    override fun onClick(v: View?) {
        when (v) {
            _binding.btnLoginWechat -> loginWechat()
            _binding.btnLoginQq -> loginQQ()
            _binding.btnLoginSina -> loginSina()
        }
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
     * 新浪登录
     */
    private fun loginSina() {
        val isInstall = shareAPI.isInstall(this, SHARE_MEDIA.SINA)
        if (!isInstall) {
            Toast.makeText(this, "新浪微博未安装", Toast.LENGTH_SHORT).show()
            return
        }

        shareAPI.deleteOauth(this, SHARE_MEDIA.SINA, null)
        shareAPI.getPlatformInfo(this, SHARE_MEDIA.SINA, _umAuthListener)
    }

    /**
     * 授权监听
     */
    private val _umAuthListener = object : UMAuthListener {
        override fun onStart(platform: SHARE_MEDIA) {
            logMsg { "login onStart $platform" }
        }

        override fun onComplete(platform: SHARE_MEDIA, action: Int, data: MutableMap<String, String>) {
            logMsg { "login onComplete $platform data:${data}" }
        }

        override fun onError(platform: SHARE_MEDIA, action: Int, throwable: Throwable) {
            logMsg { "login onError $platform throwable:${throwable}" }
        }

        override fun onCancel(platform: SHARE_MEDIA, action: Int) {
            logMsg { "login onCancel $platform" }
        }
    }
}