package com.example.qrazy.qrazyapplication;

import android.graphics.drawable.Drawable;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class AppInfo {
    public String appName ; // 应用名
    public String packageName ; // 包名
    public String versionName ; // 版本名
    public int versionCode = 0; // 版本号
    public Drawable appIcon = null; // 应用图标
    public int SYSTEM_APP;//是否为系统应用
    public long firstInstallTime;//第一次安装时间
    public long lastUpdateTime;//最后一次升级时间
    SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    @Override
    public String toString() {

        return appName+"--"+packageName+"--"+versionName+"--"+versionCode+"--"+data.format(firstInstallTime)+"--"+data.format(lastUpdateTime);
       // return "-----------------------------";
    }

    @Override
    public int hashCode() {
        return appName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Log.e("------","--"+this.appName+(((AppInfo)obj).appName)+"---"+versionCode+"--"+((AppInfo)obj).versionCode);
        return this.appName.equals(((AppInfo)obj).appName)
                ;
    }
}
