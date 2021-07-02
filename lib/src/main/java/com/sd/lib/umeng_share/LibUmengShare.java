package com.sd.lib.umeng_share;

import android.content.Context;

import com.sd.lib.umeng_share.provider.LibUmengShareFileProvider;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;

public class LibUmengShare {
    private LibUmengShare() {
    }

    public static void init(Context context) {
        final UMShareConfig config = new UMShareConfig();
        config.isNeedAuthOnGetUserInfo(true);
        UMShareAPI.get(context).setShareConfig(config);

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
