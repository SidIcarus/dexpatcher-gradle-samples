package com.dnt7.padguide.activity;

import lanchon.dexpatcher.annotation.DexEdit;
import lanchon.dexpatcher.annotation.DexIgnore;

@DexEdit(contentOnly = true)
public class DownloaderExpansionActivity {
    // When releasing:
    // 1) Update version id/name
    // 2) If uploading new expansion pack:
    //   2a) Sync version id in DownloaderExpansionActivity
    //   2b) Sync version id in com/google/android/vending/expansion/downloader/d.java
    // 3) Upload APK
    // 5) BEFORE RELEASING:
    //      Click on the + sign next to the uploaded APK
    //      Select the latest expansion file
    //      OR
    //      Upload new expansion file
    // 6) Release to internal test
    // App will now work from internal test or from Android Studio

    @DexEdit
    private static final a[] B =
            new a[]{new DownloaderExpansionActivity.a(true, 220, 61094585L)};

    @DexIgnore
    private static class a {
        public final boolean a;
        public final int b;
        public final long c;

        @DexIgnore
        a(boolean var1, int var2, long var3) {
            this.a = var1;
            this.b = var2;
            this.c = var3;
        }
    }
}
