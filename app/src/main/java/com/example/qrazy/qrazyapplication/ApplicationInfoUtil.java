package com.example.qrazy.qrazyapplication;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ApplicationInfoUtil {
    public static final int DEFAULT = 0; // 默认 所有应用
    public static final int SYSTEM_APP = DEFAULT + 1; // 系统应用
    public static final int NONSYSTEM_APP = DEFAULT + 2; // 非系统应用

    /**
     * 根据包名获取相应的应用信息
     *
     * @param context
     * @param packageName
     * @return 返回包名所对应的应用程序的名称。
     */
    public static String getProgramNameByPackageName(Context context,
                                                     String packageName) {
        PackageManager pm = context.getPackageManager();
        String name = null;
        try {
            name = pm.getApplicationLabel(
                    pm.getApplicationInfo(packageName,
                            PackageManager.GET_META_DATA)).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return name;
    }

    /**
     * 获取手机所有应用信息
     *
     * @param allApplist
     * @param context
     */
    public static void getAllProgramInfo(List<AppInfo> allApplist,
                                         Context context) {

        getAllProgramInfo(allApplist, context, DEFAULT);
    }

    /**
     * 获取手机所有应用信息
     *
     * @param applist
     * @param context
     * @param type
     *            标识符 是否区分系统和非系统应用
     */
    public static void getAllProgramInfo(List<AppInfo> applist,
                                         Context context, int type) {
        ArrayList<AppInfo> appList = new ArrayList<>(); // 用来存储获取的应用信息数据
        List<PackageInfo> packages = context.getPackageManager()
                .getInstalledPackages(0);

        for (int i = 0; i < packages.size(); i++) {
            PackageInfo packageInfo = packages.get(i);
            AppInfo tmpInfo = new AppInfo();
            tmpInfo.appName = packageInfo.applicationInfo.loadLabel(
                    context.getPackageManager()).toString();
            tmpInfo.packageName = packageInfo.packageName;
            tmpInfo.versionName = packageInfo.versionName;
            tmpInfo.versionCode = packageInfo.versionCode;
            tmpInfo.appIcon = packageInfo.applicationInfo.loadIcon(context
                    .getPackageManager());
            tmpInfo.firstInstallTime = packageInfo.firstInstallTime;
            tmpInfo.lastUpdateTime = packageInfo.lastUpdateTime;
            switch (type) {
                case NONSYSTEM_APP:
                    if (!isSystemAPP(packageInfo)) {
                        applist.add(tmpInfo);

                    }
                    break;
                case SYSTEM_APP:
                    if (isSystemAPP(packageInfo)) {
                        applist.add(tmpInfo);
                    }
                    break;
                default:
                    applist.add(tmpInfo);
                    break;
            }

        }
    }

    /**
     * 获取所有系统应用信息
     *
     * @param context
     * @return
     */
    public static List<AppInfo> getAllSystemProgramInfo(Context context) {
        List<AppInfo> systemAppList = new ArrayList<>();
        getAllProgramInfo(systemAppList, context, SYSTEM_APP);
        return systemAppList;
    }

    /**
     * 获取所有非系统应用信息
     *
     * @param context
     * @return
     */
    public static List<AppInfo> getAllNonsystemProgramInfo(Context context) {
        List<AppInfo> nonsystemAppList = new ArrayList<>();
        getAllProgramInfo(nonsystemAppList, context, NONSYSTEM_APP);
        return nonsystemAppList;
    }

    /**
     * 判断是否是系统应用
     *
     * @param packageInfo
     * @return
     */
    public static Boolean isSystemAPP(PackageInfo packageInfo) {
        if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) { // 非系统应用
            return false;
        } else { // 系统应用
            return true;
        }
    }


    public static Object combineSydwCore(Object sourceBean,Object targetBean){
        Class sourceBeanClass = sourceBean.getClass();
        Class targetBeanClass = targetBean.getClass();

        Field[] sourceFields = sourceBeanClass.getDeclaredFields();
        Field[] targetFields = sourceBeanClass.getDeclaredFields();
        for(int i=0; i<sourceFields.length; i++){
            Field sourceField = sourceFields[i];
            Field targetField = targetFields[i];
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
            try {
                if( !(sourceField.get(sourceBean) == null) &&  !"serialVersionUID".equals(sourceField.getName().toString())){
                    targetField.set(targetBean,sourceField.get(sourceBean));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return targetBean;
    }
    public static String getheadUrlPath(){
        String guid = "1234";
        String format = String.format("%09d", Long.parseLong(guid));
        return format;

    }
}