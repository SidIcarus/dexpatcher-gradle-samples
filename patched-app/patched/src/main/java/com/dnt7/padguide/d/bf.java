package com.dnt7.padguide.d;

import android.widget.RadioGroup;

import com.dnt7.padguide.b.b;

import java.util.ArrayList;

import lanchon.dexpatcher.annotation.DexAction;
import lanchon.dexpatcher.annotation.DexEdit;
import lanchon.dexpatcher.annotation.DexIgnore;
import lanchon.dexpatcher.annotation.DexWrap;

// This inflates the items on the util fragment.
// I'm hiding the monster/friend/board tab, which mostly don't work or are garbage.
// The 'etc' tab is mostly fine except for the 'support' option, which I'm hiding here.
@DexEdit(contentOnly = true, defaultAction = DexAction.IGNORE)
public class bf extends b {
    @DexIgnore
    private RadioGroup ak = null;

    @DexIgnore
    private ArrayList h = null;

    @DexWrap
    private void b(int var1) {
        if (var1 < 3) {
            // The first three menu items have been hidden, but the first one will be selected by
            // default. If we have any of those three saved / defaulted to selected, adjust the
            // selection to the first visible tab (3) and force that tab to be picked.
            var1 = 3;
            this.ak.check(this.ak.getChildAt(var1).getId());
        }
        b(var1);
        // This removes the 'support' link from the menu
        this.h.remove(0);
    }
}
