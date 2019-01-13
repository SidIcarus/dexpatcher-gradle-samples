//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dnt7.padguide.d;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dnt7.padguide.b.b;

import lanchon.dexpatcher.annotation.DexAction;
import lanchon.dexpatcher.annotation.DexAdd;
import lanchon.dexpatcher.annotation.DexEdit;
import lanchon.dexpatcher.annotation.DexIgnore;
import lanchon.dexpatcher.annotation.DexPrepend;
import lanchon.dexpatcher.annotation.DexWrap;

@DexEdit(defaultAction = DexAction.IGNORE)
public class au extends b implements OnClickListener {
    @DexIgnore
    private Context g = null;
    @DexIgnore
    private TextView bE = null;

    @DexEdit
    boolean b = true;


    @DexPrepend
    void V() {
        // Set 'purchased' to true before the 'check purchased' function (easier to hook this way)
        b = true;
    }

    @DexIgnore
    public void onClick(View var1) {
        // per interface requirements
    }

    // The 'image quality' setting on dadguide is counterproductive. Setting it to 'low' results
    // in a better user experience. Doing some magic to auto toggle it from high, and preventing
    // users from changing it back.
    @DexWrap()
    public View a(LayoutInflater param1, ViewGroup param2, Bundle param3) {
        // The original 'a' is the onCreate method.
        // Hook it to toggle the image quality setting to low if necessary.
        View v = a(param1, param2, param3);
        String imageQuality = bE.getText().toString();
        if (imageQuality.equals(this.g.getResources().getString(2131099753))) {
            // The image quality was high, so call the original ad() to toggle it to low.
            source_ad();
        }
        return v;
    }

    // Rename the method that toggles the image quality to low/high and adjusts the textview.
    @DexEdit(target = "ad")
    private void source_ad() { throw null; }

    // Add a new stub method in place of ad() which does nothing on click.
    @DexAdd
    private void ad() {
    }
}
