//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dnt7.padguide.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.dnt7.padguide.c.e;
import com.dnt7.padguide.c.g;
import com.dnt7.padguide.db.a.bd;
import com.dnt7.padguide.e.b;
import com.dnt7.padguide.e.b.a;
import com.dnt7.padguide.f.k;
import java.io.IOException;
import java.util.HashMap;

public class RegistrationIntentService extends IntentService {
    public RegistrationIntentService() {
        super("PadGuide");
    }

    public static void a(Context var0, String var1) {
        if (k.d(var1)) {
            bd.b(var0, "PUSH_TOKEN", var1);
        }

        String var2 = bd.a(var0, "PUSH_TOKEN", "");
        if (k.d(var2)) {
            HashMap var5 = new HashMap();
            var5.put("GID", "3");
            var5.put("DEVICE_ID", var2);
            var5.put("USER_KEY", e.s(var0));
            var5.put("OS", "A");
            var5.put("SERVER", e.f(var0));

            for(int var3 = 0; var3 < 6; ++var3) {
                byte var4;
                if (var3 == 5) {
                    var4 = 0;
                } else {
                    var4 = 1;
                }

                int var6 = bd.b(var0, k.a("PUSH_SETTING_%02d", new Object[]{var3}), var4);
                var5.put(k.a("PUSH_%02d", new Object[]{var3}), k.a("%d", new Object[]{var6}));
            }

            b.a(var0, "http://api.gamekiji.com/api/regPushSetting.jsp", var5, (a)null);
        } else {
            g.a("PadGuide", "Push Token Error");
        }

    }

    protected void onHandleIntent(Intent var1) {
        com.google.android.gms.iid.a var3 = com.google.android.gms.iid.a.c(this);

        try {
            String var4 = var3.a(this.getString(2131100366), "GCM", (Bundle)null);
            if (!var4.equals(bd.a(this, "PUSH_TOKEN", ""))) {
                a(this, var4);
            }
        } catch (IOException var2) {
            g.b("PadGuide", var2);
        }

    }
}
