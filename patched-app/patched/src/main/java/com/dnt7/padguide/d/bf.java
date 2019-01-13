package com.dnt7.padguide.d;

import com.dnt7.padguide.b.b;

import java.util.ArrayList;

import lanchon.dexpatcher.annotation.DexAction;
import lanchon.dexpatcher.annotation.DexEdit;
import lanchon.dexpatcher.annotation.DexIgnore;
import lanchon.dexpatcher.annotation.DexPrepend;

// This inflates the items on the util fragment.
// I'm hiding the monster/friend/board tab, which mostly don't work or are garbage.
// The 'etc' tab is mostly fine except for the 'support' option, which I'm hiding here.
@DexEdit(contentOnly = true, defaultAction = DexAction.IGNORE)
public class bf extends b {
    @DexIgnore
    private ArrayList h = null;

    @DexPrepend
    private void b(int var1) {
        // This removes the 'support' link from the menu
        this.h.remove(0);
    }
}
