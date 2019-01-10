package com.dnt7.padguide;

import android.app.Application;

import com.dnt7.padguide.c.c;
import com.dnt7.padguide.c.g;
import com.dnt7.padguide.c.i;
import com.dnt7.padguide.c.m;
import com.flurry.android.FlurryAgent.Builder;

import lanchon.dexpatcher.annotation.DexEdit;
import lanchon.dexpatcher.annotation.DexReplace;

@DexEdit
public class PadGuideApplication extends Application {
    public PadGuideApplication() {
    }

    @DexReplace
    public void onCreate() {
        super.onCreate();

        // Logging init?
        g.a();

        // using dadguide flurry api key since it doesn't like not having flurry enabled
        new Builder()
                .withLogEnabled(false)
                .build(this, "FRXSHR9GK38PG52RHD3S");

        // Android universal image loader init?
        i.a(this);

        // Android universal image loader init?
        c.a(this);

        // Something related to themes?
        m.a(this);
    }
}
