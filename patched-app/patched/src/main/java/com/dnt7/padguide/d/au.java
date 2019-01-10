//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dnt7.padguide.d;

import android.view.View;
import android.view.View.OnClickListener;

import com.dnt7.padguide.b.b;

import lanchon.dexpatcher.annotation.DexAction;
import lanchon.dexpatcher.annotation.DexEdit;
import lanchon.dexpatcher.annotation.DexIgnore;
import lanchon.dexpatcher.annotation.DexPrepend;

@DexEdit(defaultAction = DexAction.IGNORE)
public class au extends b implements OnClickListener {
    @DexEdit
    boolean b = true;

    // Set 'purchased' to true before the 'check purchased' function (easier to hook this way)
    @DexPrepend
    void V() {
        b = true;
    }

    @DexIgnore
    public void onClick(View var1) {
        // per interface requirements
    }
}
