package com.example.qrazy.qrazyapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData() {
        var recyclerView:RecyclerView = findViewById(R.id.recyclerview)
        var mAdapter: KotAdapter?= KotAdapter(this)
       // val tv = findViewById<TextView>(R.id.tv_text)
        recyclerView?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView?.adapter = mAdapter

        val appList = ArrayList<AppInfo>()
        ApplicationInfoUtil.getAllProgramInfo(appList, this)
        val appList2 = ArrayList<AppInfo>()
        ApplicationInfoUtil.getAllProgramInfo(appList2, this)
        val appList3 = ArrayList<AppInfo>()
        val map = HashMap<AppInfo,Int>()
        map.hashCode()
        map.put(appList.get(1),1)
        map.put(appList2.get(1),2)
        Log.e("------","--"+map.size+"---")
        appList3.add(appList.get(11))
        appList3.add(appList2.get(11))
        var appInfo:AppInfo = AppInfo()
        appInfo.appName = "123"
        appInfo.firstInstallTime=134255

        var appInfo2:AppInfo = AppInfo()
        appInfo2.lastUpdateTime =2345623
        appInfo2.versionName = ApplicationInfoUtil.getheadUrlPath()

        var appInfo3:AppInfo = ApplicationInfoUtil.combineSydwCore(appInfo,appInfo2) as AppInfo
        appList3.add(appInfo3)
        mAdapter?.setData(appList3)
        mAdapter?.notifyDataSetChanged()
        //tv.setText(s)

        /*val intent = Intent().setClass(this, MyServices::class.java)
        startService(intent)*/
    }

}

