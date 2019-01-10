//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dnt7.padguide.d;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.a.a.a.a.d;
import com.a.a.a.a.e;
import com.a.a.a.a.f;
import com.a.a.a.a.d.a;
import com.a.a.a.a.d.c;
import com.dnt7.padguide.activity.MainActivity;
import com.dnt7.padguide.b.b;
import com.dnt7.padguide.c.g;
import com.dnt7.padguide.db.a.bd;
import com.dnt7.padguide.f.k;
import com.dnt7.padguide.service.RegistrationIntentService;
import com.dnt7.padguide.widget.MultiStatusImageButton;
import com.dnt7.padguide.widget.TintButton;
import com.dnt7.padguide.widget.TintImageButton;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class au extends b implements OnClickListener {
    boolean a = false;
    private TintButton aA = null;
    private TintButton aB = null;
    private TintButton aC = null;
    private TintButton aD = null;
    private TintButton aE = null;
    private TintButton aF = null;
    private TintButton aG = null;
    private TintButton aH = null;
    private TintButton aI = null;
    private TintButton aJ = null;
    private TintButton aK = null;
    private TintButton aL = null;
    private TintButton aM = null;
    private TintButton aN = null;
    private TintButton aO = null;
    private TintButton aP = null;
    private ImageButton aQ = null;
    private ImageButton aR = null;
    private ImageButton aS = null;
    private ImageButton aT = null;
    private ImageButton aU = null;
    private ImageButton aV = null;
    private ImageButton aW = null;
    private ImageButton aX = null;
    private ImageButton aY = null;
    private TintImageButton aZ = null;
    private TextView aj = null;
    private ImageButton ak = null;
    private ImageButton al = null;
    private ImageButton am = null;
    private ImageButton an = null;
    private ImageButton ao = null;
    private ImageButton ap = null;
    private MultiStatusImageButton aq = null;
    private MultiStatusImageButton ar = null;
    private TintButton as = null;
    private TintButton at = null;
    private TintButton au = null;
    private TintButton av = null;
    private TintButton aw = null;
    private TintButton ax = null;
    private TintButton ay = null;
    private TintButton az = null;
    boolean b = false;
    private View bA = null;
    private View bB = null;
    private TextView bC = null;
    private TextView bD = null;
    private TextView bE = null;
    private SharedPreferences bF = null;
    private ColorMatrixColorFilter bG;
    private int bH = 0;
    private OnEditorActionListener bI = new OnEditorActionListener() {
        public boolean onEditorAction(TextView var1, int var2, KeyEvent var3) {
            if (var2 == 6) {
                au.this.i.removeTextChangedListener(au.this.bJ);
                au.this.i.setCursorVisible(false);
                au.this.d(var1.getText().toString().trim());
            }

            return false;
        }
    };
    private TextWatcher bJ = new TextWatcher() {
        public void afterTextChanged(Editable var1) {
            if (var1.toString().trim().length() >= 3) {
                au.this.d(var1.toString().trim());
            }

        }

        public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
        }

        public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
        }
    };
    private OnClickListener bK = new OnClickListener() {
        public void onClick(View var1) {
            String var2 = (String)var1.getTag();
            var2 = var2.substring(var2.lastIndexOf(61) + 1);
            if (k.d(var2)) {
                com.dnt7.padguide.f.b.c(au.this.g, var2);
            }

        }
    };
    private TintImageButton ba = null;
    private TintImageButton bb = null;
    private TintImageButton bc = null;
    private TextView bd = null;
    private TextView be = null;
    private TextView bf = null;
    private TextView bg = null;
    private ViewGroup bh = null;
    private ViewGroup bi = null;
    private ViewGroup bj = null;
    private ViewGroup bk = null;
    private ViewGroup bl = null;
    private ViewGroup bm = null;
    private ViewGroup bn = null;
    private ViewGroup bo = null;
    private ViewGroup bp = null;
    private ViewGroup bq = null;
    private ViewGroup br = null;
    private ViewGroup bs = null;
    private ViewGroup bt = null;
    private ViewGroup bu = null;
    private ViewGroup bv = null;
    private ViewGroup bw = null;
    private ViewGroup bx = null;
    private ViewGroup by = null;
    private ViewGroup bz = null;
    d c;
    com.a.a.a.a.d.d d = new com.a.a.a.a.d.d() {
        public void a(e var1, f var2) {
            com.dnt7.padguide.c.g.a("PadGuide", "Query inventory finished.");
            if (var1.c()) {
                au.this.b("Failed to query inventory: " + var1);
            } else {
                com.dnt7.padguide.c.g.a("PadGuide", "Query inventory was successful.");
                com.a.a.a.a.g var6 = var2.a("pad_remove_ads");
                au var4 = au.this;
                boolean var3;
                if (var6 != null && au.this.a(var6)) {
                    var3 = true;
                } else {
                    var3 = false;
                }

                var4.b = var3;
                StringBuilder var7 = (new StringBuilder()).append("User is ");
                String var5;
                if (au.this.b) {
                    var5 = "PREMIUM";
                } else {
                    var5 = "NOT PREMIUM";
                }

                com.dnt7.padguide.c.g.a("PadGuide", var7.append(var5).toString());
                au.this.V();
                au.this.U();
                au.this.a(false);
                com.dnt7.padguide.c.g.a("PadGuide", "Initial inventory query finished; enabling main UI.");
            }

        }
    };
    com.a.a.a.a.d.b e = new com.a.a.a.a.d.b() {
        public void a(e var1, com.a.a.a.a.g var2) {
            com.dnt7.padguide.c.g.a("PadGuide", "Purchase finished: " + var1 + ", purchase: " + var2);
            if (var1.c()) {
                if (!au.this.a) {
                    au.this.b("Error purchasing: " + var1);
                }

                au.this.a(false);
            } else if (!au.this.a(var2)) {
                au.this.b("Error purchasing. Authenticity verification failed.");
                au.this.a(false);
            } else {
                com.dnt7.padguide.c.g.a("PadGuide", "Purchase successful.");
                if (var2.b().equals("pad_remove_ads")) {
                    com.dnt7.padguide.c.g.a("PadGuide", "Purchase is premium upgrade. Congratulating user.");
                    au.this.b = true;
                    au.this.V();
                    au.this.U();
                    au.this.a(false);
                }
            }

        }
    };
    a f = new a() {
    };
    private Context g = null;
    private ScrollView h = null;
    private EditText i = null;

    public au() {
    }

    private void X() {
        // $FF: Couldn't be decompiled
    }

    private void Y() {
        Resources var1 = this.g.getResources();
        String var2 = this.bF.getString("userID", (String)null);
        int var3;
        if (k.b(var2) && var2.length() >= 3) {
            var3 = k.a(var2.substring(2, 3)) % 5;
        } else {
            var3 = 0;
        }

        String var4 = var1.getString(2131099851, new Object[]{(new String[]{"A", "B", "C", "D", "E"})[var3]});
        long var5 = 0L;
        long var7 = var5;
        if (k.b(var2)) {
            var7 = var5;
            if (var2.length() >= 9) {
                var7 = k.b(var2) % 3L;
            }
        }

        var2 = k.a("%s / %s", new Object[]{var4, var1.getString(2131099851, new Object[]{k.a("%d", new Object[]{var7})})});
        this.aj.setText(var2);
    }

    private void Z() {
        JSONObject var1 = new JSONObject();
        JSONArray var2 = new JSONArray();
        if (this.as.isSelected()) {
            var2.put("0");
        }

        if (this.at.isSelected()) {
            var2.put("1");
        }

        if (this.au.isSelected()) {
            var2.put("2");
        }

        if (this.av.isSelected()) {
            var2.put("3");
        }

        if (this.aw.isSelected()) {
            var2.put("4");
        }

        JSONArray var3 = new JSONArray();
        if (this.ax.isSelected()) {
            var3.put("0");
        }

        if (this.ay.isSelected()) {
            var3.put("1");
        }

        if (this.az.isSelected()) {
            var3.put("2");
        }

        if (this.aA.isSelected()) {
            var3.put("3");
        }

        if (this.aB.isSelected()) {
            var3.put("4");
        }

        JSONArray var4 = new JSONArray();
        if (this.aC.isSelected()) {
            var4.put("0");
        }

        if (this.aD.isSelected()) {
            var4.put("1");
        }

        if (this.aE.isSelected()) {
            var4.put("2");
        }

        if (this.aF.isSelected()) {
            var4.put("3");
        }

        if (this.aG.isSelected()) {
            var4.put("4");
        }

        try {
            var1.put("0", var2);
            var1.put("1", var3);
            var1.put("2", var4);
        } catch (JSONException var7) {
            com.dnt7.padguide.c.g.b("PadGuide", var7);
        }

        this.bF.edit().putString("team", var1.toString()).commit();
        var1 = new JSONObject();
        var4 = new JSONArray();
        if (this.aH.isSelected()) {
            var4.put("0");
        }

        if (this.aI.isSelected()) {
            var4.put("1");
        }

        if (this.aJ.isSelected()) {
            var4.put("2");
        }

        var2 = new JSONArray();
        if (this.aK.isSelected()) {
            var2.put("0");
        }

        if (this.aL.isSelected()) {
            var2.put("1");
        }

        if (this.aM.isSelected()) {
            var2.put("2");
        }

        var3 = new JSONArray();
        if (this.aN.isSelected()) {
            var3.put("0");
        }

        if (this.aO.isSelected()) {
            var3.put("1");
        }

        if (this.aP.isSelected()) {
            var3.put("2");
        }

        try {
            var1.put("0", var4);
            var1.put("1", var2);
            var1.put("2", var3);
        } catch (JSONException var6) {
            com.dnt7.padguide.c.g.b("PadGuide", var6);
        }

        this.bF.edit().putString("new_team", var1.toString()).commit();
        var1 = new JSONObject();
        var4 = new JSONArray();
        if (this.aQ.isSelected()) {
            var4.put("0");
        }

        if (this.aR.isSelected()) {
            var4.put("1");
        }

        if (this.aS.isSelected()) {
            var4.put("2");
        }

        var3 = new JSONArray();
        if (this.aT.isSelected()) {
            var3.put("0");
        }

        if (this.aU.isSelected()) {
            var3.put("1");
        }

        if (this.aV.isSelected()) {
            var3.put("2");
        }

        var2 = new JSONArray();
        if (this.aW.isSelected()) {
            var2.put("0");
        }

        if (this.aX.isSelected()) {
            var2.put("1");
        }

        if (this.aY.isSelected()) {
            var2.put("2");
        }

        try {
            var1.put("0", var4);
            var1.put("1", var3);
            var1.put("2", var2);
        } catch (JSONException var5) {
            com.dnt7.padguide.c.g.b("PadGuide", var5);
        }

        this.bF.edit().putString("starter", var1.toString()).commit();
    }

    private void a(int var1, String var2) {
        try {
            var2 = com.dnt7.padguide.c.e.e(this.g).put(String.valueOf(var1), var2).toString();
            this.bF.edit().putString("server", var2).commit();
        } catch (JSONException var3) {
            com.dnt7.padguide.c.g.b("PadGuide", var3);
        }

    }

    private void a(int param1, boolean param2) {
        // $FF: Couldn't be decompiled
    }

    private void a(ViewGroup var1) {
        for(int var2 = 0; var2 < var1.getChildCount(); ++var2) {
            var1.getChildAt(var2).setSelected(false);
        }

        this.Z();
    }

    private void aa() {
        String var1 = com.dnt7.padguide.db.a.bd.a(this.g, "ALARM_SOUND", "B");
        Resources var2 = this.g.getResources();
        if (var1.equals("N")) {
            this.bC.setText(2131100152);
        } else if (var1.equals("Y")) {
            this.bC.setText(2131099875);
        } else {
            this.bC.setText(2131099704);
        }

        int var3 = var2.getIdentifier(k.a("AlarmTime%s", new Object[]{com.dnt7.padguide.db.a.bd.a(this.g, "ALARM_TIME", "0")}), "string", this.g.getPackageName());
        if (var3 != 0) {
            this.bD.setText(var3);
        }

    }

    private void ab() {
        String var1 = com.dnt7.padguide.db.a.bd.a(this.g, "ALARM_TIME", "0");
        if (var1.equals("0")) {
            var1 = "5";
        } else if (var1.equals("5")) {
            var1 = "10";
        } else {
            var1 = "0";
        }

        com.dnt7.padguide.db.a.bd.b(this.g, "ALARM_TIME", var1);
        this.aa();
    }

    private void ac() {
        if (com.dnt7.padguide.db.a.bd.b(this.g, "IMAGE_QUALITY", 0) == 0) {
            this.bE.setText(this.g.getResources().getString(2131099761));
        } else {
            this.bE.setText(this.g.getResources().getString(2131099753));
        }

    }

    private void ad() {
        if (com.dnt7.padguide.db.a.bd.b(this.g, "IMAGE_QUALITY", 0) == 0) {
            com.dnt7.padguide.db.a.bd.a(this.g, "IMAGE_QUALITY", 1);
        } else {
            com.dnt7.padguide.db.a.bd.a(this.g, "IMAGE_QUALITY", 0);
        }

        this.ac();
    }

    private void ae() {
        String var1 = com.dnt7.padguide.db.a.bd.a(this.g, "ALARM_SOUND", "Y");
        if (var1.equals("N")) {
            var1 = "B";
        } else if (var1.equals("B")) {
            var1 = "Y";
        } else {
            var1 = "N";
        }

        com.dnt7.padguide.db.a.bd.b(this.g, "ALARM_SOUND", var1);
        this.aa();
    }

    private void af() {
        if (this.bH > 0) {
            (new Handler()).postDelayed(new Runnable() {
                public void run() {
                    au.this.h.scrollTo(0, au.this.bH);
                    au.this.bH = 0;
                }
            }, 500L);
        }

    }

    private void b(int var1, boolean var2) {
        JSONObject var3 = com.dnt7.padguide.c.e.d(this.g);

        try {
            StringBuilder var4 = new StringBuilder();
            var3.put(var4.append("").append(var1).toString(), var2);
        } catch (JSONException var5) {
            com.dnt7.padguide.c.g.b("PadGuide", var5);
        }

        this.bF.edit().putString("serverEnable", var3.toString()).commit();
    }

    private void d(String var1) {
        byte var2 = 0;
        if (var1 != null && var1.length() >= 3) {
            long var3 = 0L;
            int var7;
            if (k.b(var1) && var1.length() >= 3) {
                String var5 = var1.substring(2, 3);
                if (k.e(var5)) {
                    int var6 = k.a(var5);
                    this.a(this.br);

                    for(var7 = 0; var7 < this.br.getChildCount(); ++var7) {
                        if (String.valueOf(this.br.getChildAt(var7).getTag()).equals(String.valueOf(var6 % 5))) {
                            this.br.getChildAt(var7).setSelected(true);
                        }
                    }

                    this.Z();
                }
            }

            long var8 = var3;
            if (k.b(var1)) {
                var8 = var3;
                if (var1.length() >= 9) {
                    var8 = var3;
                    if (k.e(var1)) {
                        var8 = k.b(var1) % 3L;
                    }
                }
            }

            this.a(this.bu);

            for(var7 = var2; var7 < this.bu.getChildCount(); ++var7) {
                if (String.valueOf(this.bu.getChildAt(var7).getTag()).equals(String.valueOf(var8))) {
                    this.bu.getChildAt(var7).setSelected(true);
                }
            }

            this.Z();
            this.bF.edit().putString("userID", var1).commit();
            this.Y();
        }

    }

    public void T() {
        this.W();
        if ("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoP0oLmGlmr6jALM1zJSevtPWryVq3HP91mLomk5hhZPIA04xaX62W+dqOqmiqUTj8AYrUDMBswayKdyZu+pdTN3XtFzYDSzBrjOPsmc4JaPFaml5IAAvr0vfJn0n4Up40D0jOJ/w7+sNW/ZTMtfM2PAtaUWyj9HvNXdX5c1bQhmVh5c3Cn9D44YGlHsYgT1aH9yU5nSJJsz6D8ums4l3m0l/kU/4V693qa6MYRN7PvHJ7sBcnkw/kvT+q5VjfOMu/gmdMVs8D7A09SYcUB+A29vL0WlzAo+b97DN6s9gn+mDVT5dbENrnBfWoKqX3l5iSg/pqVgFNnJdIqM2pR1+8QIDAQAB".contains("CONSTRUCT_YOUR")) {
            throw new RuntimeException("Please put your app's public key in MainActivity.java. See README.");
        } else if (this.g.getPackageName().startsWith("com.example")) {
            throw new RuntimeException("Please change the sample's package name! See README.");
        } else {
            com.dnt7.padguide.c.g.a("PadGuide", "Creating IAB helper.");
            this.c = new d(this.g, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoP0oLmGlmr6jALM1zJSevtPWryVq3HP91mLomk5hhZPIA04xaX62W+dqOqmiqUTj8AYrUDMBswayKdyZu+pdTN3XtFzYDSzBrjOPsmc4JaPFaml5IAAvr0vfJn0n4Up40D0jOJ/w7+sNW/ZTMtfM2PAtaUWyj9HvNXdX5c1bQhmVh5c3Cn9D44YGlHsYgT1aH9yU5nSJJsz6D8ums4l3m0l/kU/4V693qa6MYRN7PvHJ7sBcnkw/kvT+q5VjfOMu/gmdMVs8D7A09SYcUB+A29vL0WlzAo+b97DN6s9gn+mDVT5dbENrnBfWoKqX3l5iSg/pqVgFNnJdIqM2pR1+8QIDAQAB");

            try {
                this.c.a(true);
                com.dnt7.padguide.c.g.a("PadGuide", "Starting setup.");
                d var1 = this.c;
                c var2 = new c() {
                    public void a(e var1) {
                        com.dnt7.padguide.c.g.a("PadGuide", "Setup finished.");
                        if (!var1.b()) {
                            au.this.b("Problem setting up in-app billing: " + var1);
                        } else {
                            com.dnt7.padguide.c.g.a("PadGuide", "Setup successful. Querying inventory.");
                            au.this.c.a(au.this.d);
                        }

                    }
                };
                var1.a(var2);
            } catch (Exception var3) {
                com.dnt7.padguide.c.g.b("PadGuide", var3);
            }

        }
    }

    public void U() {
        if (this.b) {
            this.bA.setVisibility(8);
            this.bB.setVisibility(8);
            Intent var1 = new Intent("com.dnt7.padguide.REMOVE_ADS");
            android.support.v4.a.f.a(this.g).a(var1);
        }

    }

    void V() {
        this.bF.edit().putBoolean("isRemoveAds", this.b).commit();
        com.dnt7.padguide.c.g.a("PadGuide", "Saved data: mRemoveAds = " + String.valueOf(this.b));
    }

    void W() {
        this.b = this.bF.getBoolean("isRemoveAds", false);
        com.dnt7.padguide.c.g.a("PadGuide", "Loaded data: tank = " + String.valueOf(this.b));
    }

    public View a(LayoutInflater param1, ViewGroup param2, Bundle param3) {
        // $FF: Couldn't be decompiled
    }

    public void a(int var1, int var2, Intent var3) {
        if (var1 == 10001 && this.c != null && !this.c.a(var1, var2, var3)) {
            ;
        }

    }

    public void a(View var1) {
        com.dnt7.padguide.c.g.a("PadGuide", "Upgrade button clicked; launching purchase flow for upgrade.");
        this.a(true);

        try {
            this.c.a((MainActivity)this.g, "pad_remove_ads", 10001, this.e, "");
        } catch (Exception var2) {
            com.dnt7.padguide.c.g.b("PadGuide", var2);
            this.b(var2.getMessage());
        }

    }

    void a(boolean var1) {
    }

    boolean a(com.a.a.a.a.g var1) {
        com.dnt7.padguide.c.g.a("PadGuide", var1.c());
        return true;
    }

    void b(String var1) {
        com.dnt7.padguide.c.g.b("PadGuide", "**** Billing Process Error: " + var1);
        this.c("Error: " + var1);
    }

    void c(String var1) {
        Builder var2 = new Builder(this.g);
        var2.setMessage(var1);
        var2.setNeutralButton(2131099937, (android.content.DialogInterface.OnClickListener)null);
        var2.create().show();
    }

    public void g() {
        try {
            if (this.c != null) {
                this.c.a();
                this.c = null;
            }
        } catch (Exception var2) {
            com.dnt7.padguide.c.g.b("PadGuide", var2);
        }

        super.g();
    }

    public void onClick(View var1) {
        ImageButton var2 = null;
        Object var3 = null;
        Object var4 = null;
        ImageButton var5 = null;
        byte var6 = 0;
        boolean var7 = false;
        boolean var8 = false;
        boolean var9 = false;
        byte var10 = 0;
        if (var1 == this.i) {
            this.i.setCursorVisible(true);
            this.i.addTextChangedListener(this.bJ);
        } else {
            String var12;
            if (var1 != this.ak && var1 != this.al && var1 != this.am) {
                if (var1 != this.an && var1 != this.ao && var1 != this.ap) {
                    if (var1 == this.aq) {
                        this.a(1, com.dnt7.padguide.c.e.d[this.aq.getCurrentIndex()]);
                    } else {
                        byte var11;
                        TextView var15;
                        ViewGroup var16;
                        if (var1 == this.aZ) {
                            var15 = this.bf;
                            if (var1.isSelected()) {
                                var11 = 8;
                            } else {
                                var11 = 0;
                            }

                            var15.setVisibility(var11);
                            var16 = this.bh;
                            if (var1.isSelected()) {
                                var11 = var10;
                            } else {
                                var11 = 8;
                            }

                            var16.setVisibility(var11);
                            this.b(1, var1.isSelected());
                        } else if (var1 == this.ar) {
                            this.a(2, com.dnt7.padguide.c.e.d[this.ar.getCurrentIndex()]);
                        } else if (var1 == this.ba) {
                            var15 = this.bg;
                            if (var1.isSelected()) {
                                var11 = 8;
                            } else {
                                var11 = 0;
                            }

                            var15.setVisibility(var11);
                            var16 = this.bi;
                            if (var1.isSelected()) {
                                var11 = var6;
                            } else {
                                var11 = 8;
                            }

                            var16.setVisibility(var11);
                            this.b(2, var1.isSelected());
                        } else if (var1 == this.bb) {
                            this.bF.edit().putBoolean("hideFinished", var1.isSelected()).commit();
                        } else if (var1 == this.bc) {
                            this.bF.edit().putBoolean("isNewsNotification", var1.isSelected()).commit();
                        } else if (var1 == this.bj) {
                            var12 = this.a(2131100335);
                            com.dnt7.padguide.f.b.a(this.g, "", var12);
                        } else if (var1 == this.bp) {
                            com.dnt7.padguide.f.b.c(this.g, this.g.getPackageName());
                        } else if (var1 == this.bk) {
                            this.b((android.support.v4.app.k)(new ap()));
                        } else if (var1 == this.bl) {
                            this.ae();
                        } else if (var1 == this.bm) {
                            this.ab();
                        } else if (var1 == this.bn) {
                            this.ad();
                        } else if (var1 == this.bo) {
                            com.dnt7.padguide.d.bd var13 = new com.dnt7.padguide.d.bd();
                            var13.a(this, 1);
                            this.bH = this.h.getScrollY();
                            this.b((android.support.v4.app.k)var13);
                        } else if (var1 != this.as && var1 != this.at && var1 != this.au && var1 != this.av && var1 != this.aw && var1 != this.ax && var1 != this.ay && var1 != this.az && var1 != this.aA && var1 != this.aB && var1 != this.aC && var1 != this.aD && var1 != this.aE && var1 != this.aF && var1 != this.aG) {
                            ColorMatrixColorFilter var14;
                            if (var1 != this.aQ && var1 != this.aR && var1 != this.aS) {
                                if (var1 != this.aT && var1 != this.aU && var1 != this.aV) {
                                    if (var1 != this.aW && var1 != this.aX && var1 != this.aY) {
                                        if (var1 == this.bd) {
                                            if (this.c != null) {
                                                this.a(var1);
                                            } else {
                                                com.dnt7.padguide.f.b.a(this.g, 2131100052);
                                            }
                                        } else if (var1 == this.be) {
                                            if (this.c != null) {
                                                this.a = true;
                                                this.a(var1);
                                            } else {
                                                com.dnt7.padguide.f.b.a(this.g, 2131100052);
                                            }
                                        } else if (var1 == this.bq) {
                                            com.dnt7.padguide.f.b.a(this.g, 2131099722);
                                        }
                                    } else {
                                        if (var1.isSelected()) {
                                            var7 = var9;
                                        } else {
                                            var7 = true;
                                        }

                                        var1.setSelected(var7);
                                        var5 = (ImageButton)var1;
                                        if (var7) {
                                            var14 = (ColorMatrixColorFilter)var4;
                                        } else {
                                            var14 = this.bG;
                                        }

                                        var5.setColorFilter(var14);
                                    }
                                } else {
                                    if (var1.isSelected()) {
                                        var7 = var8;
                                    } else {
                                        var7 = true;
                                    }

                                    var1.setSelected(var7);
                                    var5 = (ImageButton)var1;
                                    if (var7) {
                                        var14 = (ColorMatrixColorFilter)var3;
                                    } else {
                                        var14 = this.bG;
                                    }

                                    var5.setColorFilter(var14);
                                }
                            } else {
                                if (!var1.isSelected()) {
                                    var7 = true;
                                }

                                var1.setSelected(var7);
                                var5 = (ImageButton)var1;
                                if (var7) {
                                    var14 = var2;
                                } else {
                                    var14 = this.bG;
                                }

                                var5.setColorFilter(var14);
                            }
                        }
                    }
                } else {
                    var2 = this.ao;
                    if (this.ao == var1) {
                        var7 = true;
                    } else {
                        var7 = false;
                    }

                    var2.setSelected(var7);
                    var2 = this.ap;
                    if (this.ap == var1) {
                        var7 = true;
                    } else {
                        var7 = false;
                    }

                    var2.setSelected(var7);
                    var2 = this.an;
                    if (this.an == var1) {
                        var7 = true;
                    } else {
                        var7 = false;
                    }

                    var2.setSelected(var7);
                    if (this.ao.isSelected()) {
                        var12 = com.dnt7.padguide.c.e.d[0];
                    } else if (this.ap.isSelected()) {
                        var12 = com.dnt7.padguide.c.e.d[1];
                    } else {
                        var12 = var5;
                        if (this.an.isSelected()) {
                            var12 = com.dnt7.padguide.c.e.d[2];
                        }
                    }

                    this.a(0, var12);
                }
            } else {
                var5 = this.al;
                if (this.al == var1) {
                    var7 = true;
                } else {
                    var7 = false;
                }

                var5.setSelected(var7);
                var5 = this.am;
                if (this.am == var1) {
                    var7 = true;
                } else {
                    var7 = false;
                }

                var5.setSelected(var7);
                var5 = this.ak;
                if (this.ak == var1) {
                    var7 = true;
                } else {
                    var7 = false;
                }

                var5.setSelected(var7);
                if (this.al.isSelected()) {
                    var12 = com.dnt7.padguide.c.e.a[0];
                } else if (this.am.isSelected()) {
                    var12 = com.dnt7.padguide.c.e.a[1];
                } else if (this.ak.isSelected()) {
                    var12 = com.dnt7.padguide.c.e.a[2];
                } else {
                    var12 = null;
                }

                this.bF.edit().putString("language", var12).commit();
            }
        }

    }

    public void u() {
        super.u();
        String var1 = this.bF.getString("userID", (String)null);
        if (var1 != null) {
            this.i.setText(var1);
        }

        this.af();
    }

    public void v() {
        super.v();
        this.Z();
        RegistrationIntentService.a(this.g, "");
    }
}
