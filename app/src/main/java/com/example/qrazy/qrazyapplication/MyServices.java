package com.example.qrazy.qrazyapplication;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyServices extends IntentService {

    public MyServices() {
        super("MyServices");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        List<AppInfo> appList = new ArrayList<AppInfo>();

        ApplicationInfoUtil.getAllProgramInfo(appList,this);
        for (AppInfo app:appList) {
            app.toString();
            Log.e("------",app.toString());
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("------","onDestory");
    }
}
