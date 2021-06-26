package com.sd.demo.umeng_share.activity

import android.os.Bundle
import android.view.View
import com.sd.demo.umeng_share.databinding.ActivityShareBinding

class ShareActivity : BaseActivity(), View.OnClickListener {
    private lateinit var _binding: ActivityShareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityShareBinding.inflate(layoutInflater)
        setContentView(_binding.root)
    }

    override fun onClick(v: View?) {
        when (v) {
            _binding.btnShareQq -> shareQQ()
            _binding.btnShareWechat -> shareWechat()
            _binding.btnShareSina -> shareSina()
        }
    }

    private fun shareQQ() {

    }

    private fun shareWechat() {

    }

    private fun shareSina() {

    }
}