package com.sd.demo.umeng_share.activity

import android.os.Bundle
import com.sd.demo.umeng_share.databinding.ActivityShareBinding

class ShareActivity : BaseActivity() {
    private lateinit var _binding: ActivityShareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityShareBinding.inflate(layoutInflater)
        setContentView(_binding.root)
    }
}