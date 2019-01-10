//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dnt7.padguide.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Messenger;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.dnt7.padguide.b.e;
import com.dnt7.padguide.c.m;
import com.dnt7.padguide.service.ExpansionDownloaderService;
import com.google.android.vending.expansion.downloader.DownloadProgressInfo;
import com.google.android.vending.expansion.downloader.b;
import com.google.android.vending.expansion.downloader.c;
import com.google.android.vending.expansion.downloader.d;
import com.google.android.vending.expansion.downloader.f;
import com.google.android.vending.expansion.downloader.g;

public class DownloaderExpansionActivity extends e implements com.google.android.vending.expansion.downloader.e {
    private static final DownloaderExpansionActivity.a[] B = new DownloaderExpansionActivity.a[]{new DownloaderExpansionActivity.a(true, 215, 54656013L)};
    private g A;
    private boolean C;
    private ProgressBar n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private View t;
    private View u;
    private Button v;
    private Button w;
    private boolean x;
    private int y;
    private f z;

    public DownloaderExpansionActivity() {
    }

    public static boolean a(Context var0) {
        boolean var1 = false;
        DownloaderExpansionActivity.a[] var2 = B;
        int var3 = var2.length;
        int var4 = 0;

        while(true) {
            if (var4 >= var3) {
                var1 = true;
                break;
            }

            DownloaderExpansionActivity.a var5 = var2[var4];
            if (!d.a(var0, d.a(var0, var5.a, var5.b), var5.c, false)) {
                break;
            }

            ++var4;
        }

        return var1;
    }

    private void b(boolean var1) {
        this.x = var1;
        int var2;
        if (var1) {
            var2 = 2131100429;
        } else {
            var2 = 2131100428;
        }

        this.v.setText(var2);
    }

    private void e(int var1) {
        if (this.y != var1) {
            this.y = var1;
            this.o.setText(d.a(var1));
        }

    }

    private void h() {
        this.A = b.a(this, ExpansionDownloaderService.class);
        this.n = (ProgressBar)this.findViewById(2131493011);
        this.o = (TextView)this.findViewById(2131493007);
        this.p = (TextView)this.findViewById(2131493009);
        this.q = (TextView)this.findViewById(2131493010);
        this.r = (TextView)this.findViewById(2131493012);
        this.s = (TextView)this.findViewById(2131493013);
        this.t = this.findViewById(2131493008);
        this.u = this.findViewById(2131493016);
        this.v = (Button)this.findViewById(2131493014);
        this.w = (Button)this.findViewById(2131493021);
        this.v.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
                if (DownloaderExpansionActivity.this.x) {
                    DownloaderExpansionActivity.this.z.i_();
                } else {
                    DownloaderExpansionActivity.this.z.h_();
                }

                DownloaderExpansionActivity var3 = DownloaderExpansionActivity.this;
                boolean var2;
                if (!DownloaderExpansionActivity.this.x) {
                    var2 = true;
                } else {
                    var2 = false;
                }

                var3.b(var2);
            }
        });
        this.w.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
                DownloaderExpansionActivity.this.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
            }
        });
        ((Button)this.findViewById(2131493020)).setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
                DownloaderExpansionActivity.this.z.a(1);
                DownloaderExpansionActivity.this.z.i_();
                DownloaderExpansionActivity.this.u.setVisibility(8);
            }
        });
    }

    private void i() {
        // $FF: Couldn't be decompiled
    }

    public void a(Messenger var1) {
        this.z = c.a(var1);
        this.z.a(this.A.a());
    }

    public void a(DownloadProgressInfo var1) {
        this.r.setText(this.getString(2131100368, new Object[]{d.a(var1.d)}));
        this.s.setText(this.getString(2131100462, new Object[]{d.a(var1.c)}));
        var1.a = var1.a;
        this.n.setMax((int)(var1.a >> 8));
        this.n.setProgress((int)(var1.b >> 8));
        this.q.setText(Long.toString(var1.b * 100L / var1.a) + "%");
        this.p.setText(d.a(var1.b, var1.a));
    }

    public void c(int var1) {
        boolean var2 = true;
        byte var3 = 0;
        this.e(var1);
        Intent var4 = new Intent();
        var4.putExtra("DOWNLOAD_STATE", var1);
        boolean var5;
        boolean var6;
        boolean var7;
        switch(var1) {
            case 1:
                var5 = true;
                var6 = false;
                var7 = false;
                break;
            case 2:
            case 3:
                var5 = true;
                var6 = false;
                var7 = false;
                break;
            case 4:
                var5 = false;
                var6 = false;
                var7 = false;
                break;
            case 5:
                this.setResult(-1, var4);
                this.finish();
                return;
            case 6:
            case 10:
            case 11:
            case 13:
            case 17:
            default:
                var5 = true;
                var6 = true;
                var7 = false;
                break;
            case 7:
                var5 = false;
                var6 = true;
                var7 = false;
                break;
            case 8:
            case 9:
                var5 = false;
                var6 = true;
                var7 = true;
                var2 = false;
                break;
            case 12:
            case 14:
                var5 = false;
                var6 = true;
                var7 = false;
                break;
            case 15:
                var5 = false;
                var6 = true;
                var7 = false;
                var2 = false;
                break;
            case 16:
            case 18:
            case 19:
                var5 = false;
                var6 = true;
                var7 = false;
                var2 = false;
        }

        byte var8;
        if (var2) {
            var8 = 0;
        } else {
            var8 = 8;
        }

        if (this.t.getVisibility() != var8) {
            this.t.setVisibility(var8);
        }

        byte var9;
        if (var7) {
            var9 = var3;
        } else {
            var9 = 8;
        }

        if (this.u.getVisibility() != var9) {
            this.u.setVisibility(var9);
        }

        this.n.setIndeterminate(var5);
        this.b(var6);
    }

    public void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.d(m.a(this).a(1));
        this.setContentView(2130903080);
        this.h();
        if (!a((Context)this)) {
            this.i();
        } else {
            this.finish();
        }

    }

    protected void onDestroy() {
        this.C = true;
        super.onDestroy();
    }

    protected void onStart() {
        if (this.A != null) {
            this.A.a(this);
        }

        super.onStart();
    }

    protected void onStop() {
        if (this.A != null) {
            this.A.b(this);
        }

        super.onStop();
    }

    private static class a {
        public final boolean a;
        public final int b;
        public final long c;

        a(boolean var1, int var2, long var3) {
            this.a = var1;
            this.b = var2;
            this.c = var3;
        }
    }
}
