//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.vending.expansion.downloader;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.a.a.b.a.a.c;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class d {
    public static Random a = new Random(SystemClock.uptimeMillis());
    private static final Pattern b = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    public static int a(int var0) {
        switch(var0) {
            case 1:
                var0 = c.state_idle;
                break;
            case 2:
                var0 = c.state_fetching_url;
                break;
            case 3:
                var0 = c.state_connecting;
                break;
            case 4:
                var0 = c.state_downloading;
                break;
            case 5:
                var0 = c.state_completed;
                break;
            case 6:
                var0 = c.state_paused_network_unavailable;
                break;
            case 7:
                var0 = c.state_paused_by_request;
                break;
            case 8:
                var0 = c.state_paused_wifi_disabled;
                break;
            case 9:
                var0 = c.state_paused_wifi_unavailable;
                break;
            case 10:
                var0 = c.state_paused_wifi_disabled;
                break;
            case 11:
                var0 = c.state_paused_wifi_unavailable;
                break;
            case 12:
                var0 = c.state_paused_roaming;
                break;
            case 13:
                var0 = c.state_paused_network_setup_failure;
                break;
            case 14:
                var0 = c.state_paused_sdcard_unavailable;
                break;
            case 15:
                var0 = c.state_failed_unlicensed;
                break;
            case 16:
                var0 = c.state_failed_fetching_url;
                break;
            case 17:
                var0 = c.state_failed_sdcard_full;
                break;
            case 18:
                var0 = c.state_failed_cancelled;
                break;
            default:
                var0 = c.state_unknown;
        }

        return var0;
    }

    public static long a(File var0) {
        StatFs var3 = new StatFs(var0.getPath());
        long var1 = (long)var3.getAvailableBlocks();
        return (long)var3.getBlockSize() * (var1 - 4L);
    }

    public static File a(String var0) {
        File var1 = Environment.getDownloadCacheDirectory();
        if (!var0.startsWith(var1.getPath())) {
            File var2 = Environment.getExternalStorageDirectory();
            var1 = var2;
            if (!var0.startsWith(var2.getPath())) {
                throw new IllegalArgumentException("Cannot determine filesystem root for " + var0);
            }
        }

        return var1;
    }

    public static String a(float var0) {
        return String.format("%.2f", 1000.0F * var0 / 1024.0F);
    }

    public static String a(long var0) {
        SimpleDateFormat var2;
        if (var0 > 3600000L) {
            var2 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        } else {
            var2 = new SimpleDateFormat("mm:ss", Locale.getDefault());
        }

        return var2.format(new Date(var0 - (long)TimeZone.getDefault().getRawOffset()));
    }

    public static String a(long var0, long var2) {
        String var4;
        if (var2 == 0L) {
            var4 = "";
        } else {
            var4 = String.format("%.2f", (float)var0 / 1048576.0F) + "MB /" + String.format("%.2f", (float)var2 / 1048576.0F) + "MB";
        }

        return var4;
    }

    public static String a(Context var0) {
        File var1 = Environment.getExternalStorageDirectory();
        return var1.toString() + com.google.android.vending.expansion.downloader.a.a + var0.getPackageName();
    }

    public static String a(Context var0, String var1) {
        return a(var0) + File.separator + var1;
    }

    public static String a(Context var0, boolean var1, int var2) {
        StringBuilder var3 = new StringBuilder();
        String var4;
        if (var1) {
            var4 = "main.";
        } else {
            var4 = "patch.";
        }

        return var3.append(var4).append(var2).append(".").append(var0.getPackageName()).append(".obb").toString();
    }

    public static boolean a() {
        boolean var0;
        if (!Environment.getExternalStorageState().equals("mounted")) {
            var0 = false;
        } else {
            var0 = true;
        }

        return var0;
    }

    public static boolean a(Context var0, String var1, long var2, boolean var4) {
        File var5 = new File(a(var0, var1));
        if (var5.exists()) {
            if (var5.length() == var2) {
                var4 = true;
                return var4;
            }

            if (var4) {
                var5.delete();
            }
        }

        var4 = false;
        return var4;
    }

    public static String b(long var0, long var2) {
        String var4;
        if (var2 == 0L) {
            var4 = "";
        } else {
            var4 = Long.toString(100L * var0 / var2) + "%";
        }

        return var4;
    }

    public static boolean b(String var0) {
        var0 = var0.replaceFirst("/+", "/");
        boolean var1;
        if (!var0.startsWith(Environment.getDownloadCacheDirectory().toString()) && !var0.startsWith(Environment.getExternalStorageDirectory().toString())) {
            var1 = false;
        } else {
            var1 = true;
        }

        return var1;
    }
}
