package com.sd.demo.umeng.share

import android.os.Bundle
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
    private val IMAGE_URL = "https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epGX5k008stLSSLCX1niaVCeQKTA2suMIRSFQeqOUAY14C6o8GkUb4Uc9DxoRoE8KlSM2QSLRlZP8A/132"
    private val _binding by lazy { ActivityShareBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(_binding.root)
    }

    override fun onClick(v: View?) {
        when (v) {
            _binding.btnShareWechat -> shareWechat()
            _binding.btnShareWechatMoments -> shareWechatMoments()
            _binding.btnShareQq -> shareQQ()
            _binding.btnShareQzone -> shareQzone()
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

    private fun shareSina() {
        shareAction().apply {
            this.platform = SHARE_MEDIA.SINA
        }.share()
    }

    private val _umShareListener = object : UMShareListener {
        override fun onStart(platform: SHARE_MEDIA) {
            logMsg { "share onStart $platform" }
        }

        override fun onResult(platform: SHARE_MEDIA) {
            logMsg { "share onResult $platform" }
        }

        override fun onError(platform: SHARE_MEDIA, throwable: Throwable) {
            logMsg { "share onError $platform throwable:${throwable}" }
        }

        override fun onCancel(platform: SHARE_MEDIA) {
            logMsg { "share onCancel $platform" }
        }
    }
}