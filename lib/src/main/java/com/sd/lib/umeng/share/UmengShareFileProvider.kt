package com.sd.lib.umeng.share

import android.content.Context
import androidx.core.content.FileProvider

internal class UmengShareFileProvider : FileProvider() {
    companion object {
        @JvmStatic
        fun getAuthority(context: Context): String {
            return "${context.packageName}.f-fp-lib-umeng-share"
        }
    }
}