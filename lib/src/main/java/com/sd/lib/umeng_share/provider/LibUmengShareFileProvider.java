package com.sd.lib.umeng_share.provider;

import android.content.Context;
import android.support.v4.content.FileProvider;

public class LibUmengShareFileProvider extends FileProvider
{
    public static String getAuthority(Context context)
    {
        final String packageName = context.getPackageName();
        return packageName + LibUmengShareFileProvider.class.getSimpleName();
    }
}