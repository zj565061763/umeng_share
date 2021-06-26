package com.sd.demo.umeng_share.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.sd.demo.umeng_share.databinding.ActivityMainBinding
import com.sd.lib.umeng_share.LibUmengShare
import com.umeng.commonsdk.UMConfigure
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.UMShareConfig


class MainActivity : BaseActivity(), View.OnClickListener {
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
            _binding.btnLogin -> startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}