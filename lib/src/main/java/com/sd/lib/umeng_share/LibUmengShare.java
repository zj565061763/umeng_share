package com.sd.lib.umeng_share;

import android.content.Context;

import com.sd.lib.umeng_share.provider.LibUmengShareFileProvider;
import com.umeng.analytics.MobclickAgent;
import com.umeng.socialize.PlatformConfig;

public class LibUmengShare
{
    private LibUmengShare()
    {
    }

    public static void init(Context context)
    {
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);

        final String authority = LibUmengShareFileProvider.getAuthority(context);
        PlatformConfig.setQQZone(
                context.getString(R.string.lib_umeng_share_qq_app_id),
                context.getString(R.string.lib_umeng_share_qq_app_key));
        PlatformConfig.setQQFileProvider(authority);


        PlatformConfig.setWeixin(
                context.getString(R.string.lib_umeng_share_wechat_app_id),
                context.getString(R.string.lib_umeng_share_wechat_app_secret));
        PlatformConfig.setWXFileProvider(authority);


        PlatformConfig.setSinaWeibo(
                context.getString(R.string.lib_umeng_share_sina_app_key),
                context.getString(R.string.lib_umeng_share_sina_app_secret),
                "http://sns.whalecloud.com");
        PlatformConfig.setSinaFileProvider(authority);
    }
}