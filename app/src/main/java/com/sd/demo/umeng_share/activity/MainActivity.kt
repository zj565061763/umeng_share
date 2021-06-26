package com.sd.demo.umeng_share.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sd.demo.umeng_share.databinding.ActivityMainBinding
import com.sd.lib.umeng_share.LibUmengShare
import com.umeng.commonsdk.UMConfigure
import com.umeng.socialize.UMAuthListener
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.bean.SHARE_MEDIA

class MainActivity : AppCompatActivity(), View.OnClickListener {
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

        LibUmengShare.init(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data)
    }

    override fun onClick(v: View?) {
        when (v) {
            _binding.btnLoginQq -> {

            }
            _binding.btnLoginWechat -> {

            }
            _binding.btnLoginSina -> {

            }
        }
    }

    /**
     * 授权监听
     */
    private val _umAuthListener = object : UMAuthListener {
        override fun onStart(platform: SHARE_MEDIA) {
        }

        override fun onComplete(platform: SHARE_MEDIA, action: Int, data: MutableMap<String, String>) {
        }

        override fun onError(platform: SHARE_MEDIA, action: Int, throwable: Throwable) {
        }

        override fun onCancel(platform: SHARE_MEDIA, action: Int) {
        }
    }
}