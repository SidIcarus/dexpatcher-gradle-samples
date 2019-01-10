package com.dnt7.padguide.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import lanchon.dexpatcher.annotation.DexEdit;
import lanchon.dexpatcher.annotation.DexIgnore;
import lanchon.dexpatcher.annotation.DexReplace;

@DexEdit
public class RegistrationIntentService extends IntentService {
    @DexIgnore
    public RegistrationIntentService() {
        super("PadGuide");
    }

    @DexReplace
    public static void a(Context var0, String var1) {
    }

    @DexIgnore
    protected void onHandleIntent(Intent var1) {
    }
}
