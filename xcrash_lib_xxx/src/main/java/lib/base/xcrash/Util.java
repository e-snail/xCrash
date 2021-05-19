package lib.base.xcrash;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Util {


    static String getProcessName(Context ctx, int pid) {

        //get from ActivityManager
        try {
            ActivityManager manager = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
            if (manager != null) {
                List<ActivityManager.RunningAppProcessInfo> processInfoList = manager.getRunningAppProcesses();
                if (processInfoList != null) {
                    for (ActivityManager.RunningAppProcessInfo processInfo : processInfoList) {
                        if (processInfo.pid == pid && !TextUtils.isEmpty(processInfo.processName)) {
                            return processInfo.processName; //OK
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }

        //get from /proc/PID/cmdline
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = br.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
                if (!TextUtils.isEmpty(processName)) {
                    return processName; //OK
                }
            }
        } catch (Exception ignored) {
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception ignored) {
            }
        }

        //failed
        return null;
    }

    @SuppressWarnings("deprecation")
    static String getAbiList() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return android.text.TextUtils.join(",", Build.SUPPORTED_ABIS);
        } else {
            String abi = Build.CPU_ABI;
            String abi2 = Build.CPU_ABI2;
            if (TextUtils.isEmpty(abi2)) {
                return abi;
            } else {
                return abi + "," + abi2;
            }
        }
    }

    public static String getSystemProperty(String key, String defaultValue) {
        try {
            Class<?> clz = Class.forName("android.os.SystemProperties");
            Method get = clz.getMethod("get", String.class, String.class);
            return (String) get.invoke(clz, key, defaultValue);
        } catch (NoSuchMethodException var4) {
            var4.printStackTrace();
        } catch (IllegalAccessException var5) {
            var5.printStackTrace();
        } catch (InvocationTargetException var6) {
            var6.printStackTrace();
        } catch (ClassNotFoundException var7) {
            var7.printStackTrace();
        }

        return defaultValue;
    }

    public static boolean isMIUI() {
        String property = getSystemProperty("ro.miui.ui.version.name", "");
        return !TextUtils.isEmpty(property);
    }

    public static String getMobileModel() {
        String mobileModel = null;
        if (isMIUI()) {
            String deviceName = "";

            try {
                Class systemProperties = Class.forName("android.os.SystemProperties");
                Method get = systemProperties.getDeclaredMethod("get", String.class, String.class);
                deviceName = (String) get.invoke(systemProperties, "ro.product.marketname", "");
                if (TextUtils.isEmpty(deviceName)) {
                    deviceName = (String) get.invoke(systemProperties, "ro.product.model", "");
                }
            } catch (InvocationTargetException var3) {
                var3.printStackTrace();
            } catch (NoSuchMethodException var4) {
                var4.printStackTrace();
            } catch (IllegalAccessException var5) {
                var5.printStackTrace();
            } catch (ClassNotFoundException var6) {
                var6.printStackTrace();
            }

            mobileModel = deviceName;
        } else {
            mobileModel = Build.MODEL;
        }

        if (mobileModel == null) {
            mobileModel = "";
        }

        return mobileModel;
    }
}
