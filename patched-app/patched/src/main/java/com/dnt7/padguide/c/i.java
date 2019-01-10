//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dnt7.padguide.c;

import android.content.Context;

import com.dnt7.padguide.f.k;

import lanchon.dexpatcher.annotation.DexEdit;
import lanchon.dexpatcher.annotation.DexIgnore;
import lanchon.dexpatcher.annotation.DexReplace;

@DexEdit
public class i {
    @DexReplace
    public static String b(int var0) {
        return "portrait_" + k.a(String.valueOf(var0), 4, "0") + ".png";
    }

    @DexIgnore
    public static void a(Context var0) {
        // This is used by PadGuideApplication so it needs to be declared.
    }
}
