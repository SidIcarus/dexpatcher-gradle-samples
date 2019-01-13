//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.vending.expansion.downloader;

import android.content.Context;

import lanchon.dexpatcher.annotation.DexAction;
import lanchon.dexpatcher.annotation.DexEdit;
import lanchon.dexpatcher.annotation.DexWrap;

// This class originally com/google/android/vending/expansion/downloader/Helpers.java
@DexEdit(defaultAction = DexAction.IGNORE)
public class d {

    @DexWrap
    public static String a(Context var0, boolean var1, int var2) {
        // SplashActivity calls this with a hardcoded version number. Need to override it to the
        // current expansion pack value.
        var2 = 220;
        return a(var0, var1, var2);
    }

}
