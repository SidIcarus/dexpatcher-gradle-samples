package com.dnt7.padguide.db;

import lanchon.dexpatcher.annotation.DexAction;
import lanchon.dexpatcher.annotation.DexEdit;
import lanchon.dexpatcher.annotation.DexIgnore;
import lanchon.dexpatcher.annotation.DexReplace;

@DexEdit(contentOnly = true, defaultAction = DexAction.IGNORE)
public class e {
    @DexIgnore
    public boolean c = false;
    @DexIgnore
    public int f = 0;

    @DexReplace
    public void b() {
        this.c = true;
        this.f = 0;
        // Disable request for gamekiji.com/getTimestamp.jsp
        // Didn't work properly and didn't seem to be necessary anyway.
    }
}
