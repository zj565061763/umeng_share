package com.sd.demo.umeng.share

import android.os.Bundle
import android.util.Log
import android.view.View
import com.sd.demo.umeng.share.databinding.ActivityShareBinding
import com.umeng.socialize.ShareAction
import com.umeng.socialize.UMShareListener
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMWeb

/**
 * 分享
 */
class ShareActivity : BaseActivity(), View.OnClickListener {
    private val TAG = ShareActivity::class.java.simpleName
    private val IMAGE_URL = "https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epGX5k008stLSSLCX1niaVCeQKTA2suMIRSFQeqOUAY14C6o8GkUb4Uc9DxoRoE8KlSM2QSLRlZP8A/132"

    private lateinit var _binding: ActivityShareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityShareBinding.inflate(layoutInflater)
        setContentView(_binding.root)
    }

    override fun onClick(v: View?) {
        when (v) {
            _binding.btnShareQq -> shareQQ()
            _binding.btnShareQzone -> shareQzone()
            _binding.btnShareWechat -> shareWechat()
            _binding.btnShareWechatMoments -> shareWechatMoments()
            _binding.btnShareSina -> shareSina()
        }
    }

    private fun shareAction(): ShareAction {
        val web = UMWeb("https://www.baidu.com").apply {
            this.title = "This is title"
            this.description = "This is description"
            this.setThumb(UMImage(this@ShareActivity, IMAGE_URL))
        }
        return ShareAction(this).apply {
            this.withMedia(web)
            this.setCallback(_umShareListener)
        }
    }

    private fun shareQQ() {
        shareAction().apply {
            this.platform = SHARE_MEDIA.QQ
        }.share()
    }

    private fun shareQzone() {
        shareAction().apply {
            this.platform = SHARE_MEDIA.QZONE
        }.share()
    }

    private fun shareWechat() {
        shareAction().apply {
            this.platform = SHARE_MEDIA.WEIXIN
        }.share()
    }

    private fun shareWechatMoments() {
        shareAction().apply {
            this.platform = SHARE_MEDIA.WEIXIN_CIRCLE
        }.share()
    }

    private fun shareSina() {
        shareAction().apply {
            this.platform = SHARE_MEDIA.SINA
        }.share()
    }

    private val _umShareListener = object : UMShareListener {
        override fun onStart(platform: SHARE_MEDIA) {
            Log.i(TAG, "onStart ${platform}")
        }

        override fun onResult(platform: SHARE_MEDIA) {
            Log.i(TAG, "onResult ${platform}")
        }

        override fun onError(platform: SHARE_MEDIA, throwable: Throwable) {
            Log.e(TAG, "onError ${platform} throwable:${throwable}")
        }

        override fun onCancel(platform: SHARE_MEDIA) {
            Log.i(TAG, "onCancel ${platform}")
        }
    }
}