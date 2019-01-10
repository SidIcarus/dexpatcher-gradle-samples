//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dnt7.padguide;

import android.app.Application;
import com.dnt7.padguide.c.c;
import com.dnt7.padguide.c.g;
import com.dnt7.padguide.c.i;
import com.dnt7.padguide.c.m;
import com.flurry.android.FlurryAgent.Builder;
import org.acra.ACRA;
import org.acra.a.a;

@a(
        j = "",
        k = "http://pad.dnt7.com/api/crashLog.jsp"
)
public class PadGuideApplication extends Application {
    public PadGuideApplication() {
    }

    public void onCreate() {
        super.onCreate();
        g.a();
        ACRA.init(this);
        (new Builder()).withLogEnabled(false).build(this, "WWDKQ2JFJK3X9D2BFNH7");
        i.a(this);
        c.a(this);
        m.a(this);
    }

    public void onLowMemory() {
        super.onLowMemory();
    }
}
