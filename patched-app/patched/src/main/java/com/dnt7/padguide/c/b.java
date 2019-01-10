package com.dnt7.padguide.c;

import lanchon.dexpatcher.annotation.DexReplace;

@DexReplace
public class b {
    public static boolean a = false;
    public static String b = "201302DNTMYQUEST";
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g;
    public static final String h;
    public static final String i;
    public static final String j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static long n;
    public static int o;
    public static int p;
    public static int q;

    static {
        String var0;
        if (a) {
            var0 = "http://paddev.dnt7.com";
        } else {
            var0 = "http://pad.dnt7.com";
        }


        c = var0;
        e = c + "/images/";
        f = c + "/upload/";
        i = e + "wicons/";
        j = e + "wicons/";
        k = e + "youtube/";
        m = f + "image_board/";

        String newBase = "http://miru.info/padguide";
        d = newBase + "/api/";
        String newBaseImagesE = newBase + "/images/";
        g = newBaseImagesE + "icons/";
        h = newBaseImagesE + "icons/";
        // This was originally under 'texture'
        l = newBaseImagesE + "icons/";

        n = 1500L;
        o = 3;
        p = 3;
        q = 3;
    }
}
