package com.sd.demo.umeng_share.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.sd.demo.umeng_share.databinding.ActivityMainBinding
import com.sd.lib.umeng_common.LibUmengCommon
import com.sd.lib.umeng_share.LibUmengShare
import com.tencent.tauth.Tencent


class MainActivity : BaseActivity(), View.OnClickListener {
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        initUmengSDK()
    }

    private fun initUmengSDK() {
        LibUmengCommon.init(this, "")
        LibUmengShare.init(this)

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