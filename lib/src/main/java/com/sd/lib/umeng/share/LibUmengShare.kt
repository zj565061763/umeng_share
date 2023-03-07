package com.sd.lib.umeng.share

import android.content.Context
import androidx.core.content.FileProvider
import com.umeng.socialize.PlatformConfig
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.UMShareConfig

object LibUmengShare {
    @JvmOverloads
    @JvmStatic
    fun init(
        context: Context,
        wechatAppId: String = "",
        wechatAppSecret: String = "",
        qqAppId: String = "",
        qqAppKey: String = "",
        sinaAppKey: String = "",
        sinaAppSecret: String = "",
    ) {
        UMShareAPI.get(context).setShareConfig(
            UMShareConfig().apply {
                this.isNeedAuthOnGetUserInfo(true)
            }
        )

        val authority = "${context.packageName}.f-fp-lib-umeng-share"
        PlatformConfig.setFileProvider(authority)

        PlatformConfig.setWeixin(wechatAppId, wechatAppSecret)
        PlatformConfig.setQQZone(qqAppId, qqAppKey)
        PlatformConfig.setSinaWeibo(sinaAppKey, sinaAppSecret, "http://sns.whalecloud.com")
    }
}

internal class UmengShareFileProvider : FileProvider()