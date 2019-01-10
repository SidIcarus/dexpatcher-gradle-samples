//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dnt7.padguide.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.support.v4.a.f;
import com.dnt7.padguide.c.e;
import com.dnt7.padguide.c.g;
import com.dnt7.padguide.c.i;
import com.dnt7.padguide.db.b;
import com.dnt7.padguide.db.d;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {
    private Context a;
    private boolean b = false;
    private boolean c = false;
    private Timer d;
    private TimerTask e;
    private ProgressDialog f;
    private int g = 1;
    private BroadcastReceiver h = new BroadcastReceiver() {
        public void onReceive(Context var1, Intent var2) {
            if (var2.getAction().equals("createDatabase")) {
                if (!com.dnt7.padguide.db.b.c(SplashActivity.this.a)) {
                    SplashActivity.this.f();
                } else {
                    SplashActivity.this.b = false;
                    com.dnt7.padguide.c.a.a(SplashActivity.this.a);
                    SplashActivity.this.h();
                }
            }

        }
    };
    private SplashActivity.a i;

    public SplashActivity() {
    }

    private void a() {
        Builder var1 = new Builder(this);
        var1.setCancelable(false);
        var1.setMessage(2131100015);
        var1.setNegativeButton(2131099934, new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
                SplashActivity.this.finish();
            }
        });
        var1.setPositiveButton(2131099943, new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
                Intent var3 = SplashActivity.this.getBaseContext().getPackageManager().getLaunchIntentForPackage(SplashActivity.this.getBaseContext().getPackageName());
                var3.addFlags(67108864);
                SplashActivity.this.startActivity(var3);
            }
        });
        var1.show();
    }

    private void a(int var1) {
        PreferenceManager.getDefaultSharedPreferences(this.a).edit().putInt("EXPANSION_FILE_CHECK_CNT", var1 + 1).commit();
        this.startActivity((new Intent(this.a, DownloaderExpansionActivity.class)).addFlags(67108864));
    }

    private void b() {
        if (!this.getSharedPreferences("setting", 0).getBoolean("WRITE_EXTERNAL_STORAGE", false) && com.dnt7.padguide.c.e.b(this.a).equals(com.dnt7.padguide.c.e.a[2])) {
            this.k();
        } else if (this.c()) {
            File var1 = com.dnt7.padguide.c.i.a(1);
            File var2 = com.dnt7.padguide.c.i.a(2);
            if (var1.exists() && var1.listFiles().length != 0) {
                this.h();
            } else if (DownloaderExpansionActivity.a(this.a)) {
                if (this.i == null || this.i.getStatus().equals(Status.FINISHED)) {
                    this.i = new SplashActivity.a(null);
                    this.i.execute(new Void[0]);
                }
            } else {
                SharedPreferences var3 = PreferenceManager.getDefaultSharedPreferences(this.a);
                int var4 = var3.getInt("EXPANSION_FILE_CHECK_CNT", 0);
                if (var4 > 2) {
                    if (!var1.exists()) {
                        var1.mkdirs();
                    }

                    if (!var2.exists()) {
                        var2.mkdirs();
                    }

                    this.h();
                    var3.edit().remove("EXPANSION_FILE_CHECK_CNT").commit();
                } else {
                    this.a(var4);
                }
            }
        }

    }

    private boolean c() {
        boolean var1 = true;
        boolean var2 = var1;
        if (VERSION.SDK_INT >= 23) {
            if (this.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                var2 = var1;
            } else {
                int var3 = this.g;
                android.support.v4.app.a.a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, var3);
                var2 = false;
            }
        }

        return var2;
    }

    private void d() {
        IntentFilter var1 = new IntentFilter();
        var1.addAction("createDatabase");
        android.support.v4.a.f.a(this.a).a(this.h, var1);
    }

    private void e() {
        try {
            android.support.v4.a.f.a(this.a).a(this.h);
        } catch (Exception var2) {
            com.dnt7.padguide.c.g.b("PadGuide", var2);
        }

    }

    private void f() {
        Builder var1 = new Builder(this);
        var1.setTitle(2131100332);
        var1.setMessage(2131100071);
        var1.setNegativeButton(2131099943, new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
                SplashActivity.this.finish();
            }
        });
        var1.show();
    }

    private void g() {
        SharedPreferences var1 = this.getSharedPreferences("setting", 0);
        int var2 = var1.getInt("CHECK_CNT", 0);
        var1.edit().putInt("CHECK_CNT", var2 + 1).commit();
        var2 = var1.getInt("CHECK_CNT_1", 0);
        var1.edit().putInt("CHECK_CNT_1", var2 + 1).commit();
    }

    private void h() {
        if (this.b) {
            this.f = new ProgressDialog(this.a);
            this.f.setProgressStyle(1);
            this.f.setCancelable(false);
            this.f.setMessage(this.a.getString(2131100280));
            this.f.show();
            com.dnt7.padguide.db.f var1 = new com.dnt7.padguide.db.f(this.a);
            b var2 = new b(this.a, var1);
            var2.a(this.b);
            var2.a(0, this.f);
        } else if (!this.getSharedPreferences("setting", 0).getBoolean("AGREE_TERMS", false)) {
            this.j();
        } else {
            this.i();
        }

    }

    private void i() {
        this.d = new Timer();
        this.e = new TimerTask() {
            public void run() {
                Intent var1 = (new Intent(SplashActivity.this.a, MainActivity.class)).addFlags(67108864);
                if (SplashActivity.this.getSharedPreferences("setting", 0).getBoolean("isFirstLoad", true)) {
                    var1.putExtra("selected", 4);
                }

                SplashActivity.this.startActivity(var1);
                SplashActivity.this.finish();
            }
        };
        this.d.schedule(this.e, 1000L);
    }

    private void j() {
        Builder var1 = new Builder(this);
        var1.setCancelable(false);
        var1.setTitle(2131100181);
        var1.setMessage(2131100180);
        var1.setNegativeButton(2131099938, new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
                Builder var3 = new Builder(SplashActivity.this.a);
                var3.setCancelable(false);
                var3.setTitle(2131100181);
                var3.setMessage(2131100179);
                var3.setPositiveButton(17039370, new OnClickListener() {
                    public void onClick(DialogInterface var1, int var2) {
                        SplashActivity.this.j();
                    }
                });
                var3.show();
            }
        });
        var1.setPositiveButton(2131099925, new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
                SplashActivity.this.getSharedPreferences("setting", 0).edit().putBoolean("AGREE_TERMS", true).commit();
                SplashActivity.this.h();
            }
        });
        var1.show();
    }

    private void k() {
        Builder var1 = new Builder(this);
        var1.setCancelable(false);
        var1.setMessage(2131100337);
        var1.setPositiveButton(2131099925, new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
                SplashActivity.this.getSharedPreferences("setting", 0).edit().putBoolean("WRITE_EXTERNAL_STORAGE", true).commit();
                SplashActivity.this.b();
            }
        });
        var1.show();
    }

    protected void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.a = this;
        this.setContentView(2130903213);
        this.d();
        if (!com.dnt7.padguide.db.b.c(this)) {
            this.b = true;
            com.dnt7.padguide.db.f var2 = new com.dnt7.padguide.db.f(this.a);
            if (!(new b(this.a, var2)).a()) {
                this.c = true;
            }
        }

        if (!com.dnt7.padguide.db.d.c(this)) {
            com.dnt7.padguide.db.d.d(this);
        }

        if (!this.b) {
            this.g();
            com.dnt7.padguide.c.a.a(this.a);
        }

    }

    protected void onDestroy() {
        this.e();

        try {
            if (this.f != null && this.f.isShowing()) {
                this.f.dismiss();
                this.f = null;
            }
        } catch (Exception var2) {
            com.dnt7.padguide.c.g.b("PadGuide", var2);
        }

        super.onDestroy();
    }

    public void onRequestPermissionsResult(int var1, String[] var2, int[] var3) {
        super.onRequestPermissionsResult(var1, var2, var3);
        if (var3[0] == 0) {
            if (var1 == this.g) {
                this.getSharedPreferences("setting", 0).edit().putBoolean("WRITE_EXTERNAL_STORAGE", true).commit();
                this.b();
            }
        } else {
            this.finish();
        }

    }

    protected void onStart() {
        super.onStart();
        if (this.c) {
            this.a();
        } else {
            this.b();
        }

    }

    protected void onStop() {
        super.onStop();
    }

    private class a extends AsyncTask<Void, String, Void> {
        private ProgressDialog b;

        private a() {
        }

        protected Void a(Void... param1) {
            // $FF: Couldn't be decompiled
        }

        protected void a(Void var1) {
            SplashActivity.this.h();

            try {
                if (this.b != null) {
                    this.b.dismiss();
                    this.b = null;
                }
            } catch (Exception var3) {
                com.dnt7.padguide.c.g.b("PadGuide", var3);
            }

            super.onPostExecute(var1);
        }

        protected void a(String... var1) {
            if (var1[0].equals("progress")) {
                this.b.setProgress(Integer.parseInt(var1[1]));
            } else if (var1[0].equals("max")) {
                this.b.setMax(Integer.parseInt(var1[1]));
            }

            super.onProgressUpdate(var1);
        }

        protected void onPreExecute() {
            this.b = new ProgressDialog(SplashActivity.this.a);
            this.b.setCancelable(false);
            this.b.setProgressStyle(1);
            this.b.setMessage(SplashActivity.this.a.getString(2131100326));
            this.b.show();
            super.onPreExecute();
        }
    }
}
