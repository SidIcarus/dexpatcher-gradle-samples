//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dnt7.padguide.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.dnt7.padguide.b.b;
import com.dnt7.padguide.c.e;
import com.dnt7.padguide.c.g;
import com.dnt7.padguide.c.i;
import com.dnt7.padguide.c.m;
import com.dnt7.padguide.db.a.u;
import com.dnt7.padguide.db.a.w;
import com.dnt7.padguide.db.a.x;
import com.dnt7.padguide.db.a.y;
import com.dnt7.padguide.f.d;
import com.dnt7.padguide.f.k;
import com.dnt7.padguide.widget.ResizableImageView;
import com.dnt7.padguide.widget.TintButtonSizeToFit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;
import org.json.JSONObject;

public class o extends b implements OnClickListener, com.dnt7.padguide.d.av.a {
    private Context a;
    private LayoutParams aA = null;
    private OnCheckedChangeListener aB = new OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup var1, int var2) {
            o.this.f = o.this.g.indexOfChild(o.this.g.findViewById(var2));
            o.this.b.edit().putString("EGG_MACHINE_SERVER", String.valueOf(o.this.f)).commit();
            o.this.T();
        }
    };
    private OnClickListener aC = new OnClickListener() {
        public void onClick(View var1) {
            String var4 = String.valueOf(var1.getTag());
            o.this.aj = var4;
            o.this.b.edit().putString("EGG_MACHINE_CATEGORY", var4).commit();

            for(int var2 = 0; var2 < o.this.aq.getChildCount(); ++var2) {
                TintButtonSizeToFit var3 = (TintButtonSizeToFit)o.this.aq.getChildAt(var2);
                var4 = String.valueOf(var3.getTag());
                if (k.d(var4) && var4.equals(o.this.aj)) {
                    var3.setSelected(true);
                } else {
                    var3.setSelected(false);
                }
            }

            o.this.T();
        }
    };
    private OnClickListener aD = new OnClickListener() {
        public void onClick(View var1) {
            o.this.b(af.b(k.a(String.valueOf(var1.getTag()))));
        }
    };
    private o.a aE;
    private String aj = null;
    private int ak = 0;
    private ArrayList<String> al = new ArrayList();
    private ArrayList<String> am = new ArrayList();
    private ArrayList<JSONObject> an = new ArrayList();
    private String ao = "";
    private LinearLayout ap = null;
    private LinearLayout aq = null;
    private ColorMatrixColorFilter ar = null;
    private int as = 0;
    private LayoutParams at = null;
    private LayoutParams au = null;
    private LayoutParams av = null;
    private LayoutParams aw = null;
    private LayoutParams ax = null;
    private LayoutParams ay = null;
    private LayoutParams az = null;
    private SharedPreferences b = null;
    private m c = null;
    private View d = null;
    private View e = null;
    private int f = 0;
    private RadioGroup g = null;
    private String h = "JP";
    private String i = null;

    public o() {
    }

    private void T() {
        this.h = com.dnt7.padguide.c.e.d[this.f];
        this.b.edit().putString("EGG_MACHINE_SERVER", this.h).commit();
        if (this.aE == null || this.aE.getStatus().equals(Status.FINISHED)) {
            this.aE = new o.a(this);
            this.aE.execute(new Void[0]);
        }

    }

    private void U() {
        LayoutInflater var1 = (LayoutInflater)this.a.getSystemService("layout_inflater");
        this.aq.removeAllViews();

        int var2;
        for(var2 = 0; var2 < this.al.size(); ++var2) {
            TintButtonSizeToFit var3 = (TintButtonSizeToFit)var1.inflate(2130903104, this.aq, false);
            var3.setText((CharSequence)this.am.get(var2));
            var3.setTag(this.al.get(var2));
            var3.setOnClickListener(this.aC);
            var3.setSelected(((String)this.al.get(var2)).equals(String.valueOf(this.ak)));
            this.aq.addView(var3);
        }

        this.ap.removeAllViews();
        String var18 = this.a.getString(this.a.getResources().getIdentifier(this.h, "string", this.a.getPackageName()));
        TextView var22 = new TextView(this.a);
        var22.setLayoutParams(this.at);
        var22.setTextSize(0, (float)this.a.getResources().getDimensionPixelSize(2131165251));
        var22.setTextColor(this.c.a());
        var22.setText("[" + var18 + "] " + this.ao + this.a.getString(2131100053));
        this.ap.addView(var22);
        Iterator var4 = this.an.iterator();

        while(var4.hasNext()) {
            JSONObject var19 = (JSONObject)var4.next();
            String var5 = var19.optString("NAME");
            String var6 = var19.optString("START_DATE");
            String var7 = var19.optString("END_DATE");
            int var8 = var19.optInt("TYPE");
            int var9 = var19.optInt("TET_SEQ");
            var18 = "";
            int var10 = 0;
            var2 = 0;
            int var15;
            if (k.b(var6)) {
                Date var11 = new Date();
                long var12 = (long)TimeZone.getDefault().getOffset(var11.getTime());
                Date var20 = null;
                String var23 = var6.substring(0, 16);

                Date var24;
                label89: {
                    try {
                        var24 = com.dnt7.padguide.f.d.a(var23, "yyyy-MM-dd HH:mm");
                    } catch (Exception var17) {
                        com.dnt7.padguide.c.g.b("PadGuide", var17);
                        break label89;
                    }

                    var20 = var24;
                }

                Date var14 = com.dnt7.padguide.f.d.a(var20, var12);
                com.dnt7.padguide.f.d.a("yyyy-MM-dd HH:mm", var14);
                var20 = null;
                var23 = var7.substring(0, 16);

                label84: {
                    try {
                        var24 = com.dnt7.padguide.f.d.a(var23, "yyyy-MM-dd HH:mm");
                    } catch (Exception var16) {
                        com.dnt7.padguide.c.g.b("PadGuide", var16);
                        break label84;
                    }

                    var20 = var24;
                }

                Date var31 = com.dnt7.padguide.f.d.a(var20, var12);
                com.dnt7.padguide.f.d.a("yyyy-MM-dd HH:mm", var31);
                var23 = com.dnt7.padguide.f.d.c(this.a, var14.getTime());
                var18 = com.dnt7.padguide.f.d.c(this.a, var31.getTime());
                this.c.c(1);
                byte var21;
                if (com.dnt7.padguide.f.d.a('S', var11.getTime(), var14.getTime()) > 0L) {
                    var21 = 0;
                } else if (com.dnt7.padguide.f.d.a('S', var31.getTime(), var11.getTime()) > 0L) {
                    var21 = 2;
                } else {
                    var21 = 1;
                }

                if (var21 == 0) {
                    var10 = this.c.c(1);
                    var18 = com.dnt7.padguide.f.d.a(this.a, var14, var21);
                    var18 = var23 + " ~ [" + var18 + "]";
                    var15 = 2130837794;
                    var2 = var10;
                    var10 = var15;
                } else if (var21 == 1) {
                    var15 = this.c.c(0);
                    var23 = com.dnt7.padguide.f.d.a(this.a, var31, var21);
                    var18 = "~ " + var18 + " [" + var23 + "]";
                    var10 = 2130837609;
                    var2 = var15;
                } else {
                    var10 = 2130837661;
                    var2 = this.c.c(2);
                    var18 = "~ " + var18 + " [" + this.a.getString(2131099711) + "]";
                }
            }

            ArrayList var32 = x.a(this.a, var9);
            LinearLayout var37 = new LinearLayout(this.a);
            LinearLayout var34 = new LinearLayout(this.a);
            var37.setLayoutParams(this.au);
            LinearLayout var25 = var34;
            if (k.b(var5)) {
                if (var8 == 0) {
                    var37.setOrientation(0);
                    var22 = new TextView(this.a);
                    var22.setLayoutParams(this.av);
                    var22.setTextColor(this.c.a());
                    var22.setTextSize(0, (float)this.a.getResources().getDimensionPixelSize(2131165248));
                    var22.setText(var5);
                    var37.addView(var22);
                    var25 = new LinearLayout(this.a);
                    var25.setLayoutParams(this.aw);
                    var25.setOrientation(1);
                    var37.addView(var25);
                } else {
                    var25 = var34;
                    if (var8 == 1) {
                        var37.setOrientation(1);
                        var22 = new TextView(this.a);
                        var22.setTextColor(this.c.a());
                        var22.setTextSize(0, (float)this.a.getResources().getDimensionPixelSize(2131165248));
                        var22.setText(var5);
                        var37.addView(var22);
                        var25 = var34;
                    }
                }
            }

            if (k.b(var6)) {
                var34 = new LinearLayout(this.a);
                var34.setLayoutParams(new LayoutParams(-2, -2));
                var34.setOrientation(0);
                var34.setGravity(16);
                ImageView var26 = new ImageView(this.a);
                var26.setLayoutParams(this.aA);
                var26.setImageResource(var10);
                var26.setColorFilter(var2, Mode.SRC_ATOP);
                var34.addView(var26);
                TextView var28 = new TextView(this.a);
                var28.setTextColor(this.c.a());
                var28.setTextSize(0, (float)this.a.getResources().getDimensionPixelSize(2131165248));
                var28.setText(var18);
                var28.setPadding(this.as / 2, 0, 0, 0);
                var34.addView(var28);
                var37.addView(var34);
            }

            this.ap.addView(var37);
            LinearLayout var27 = var25;
            if (var8 == 1) {
                var27 = var25;
                if (var32.size() > 0) {
                    var25 = new LinearLayout(this.a);
                    var25.setLayoutParams(this.au);
                    var25.setOrientation(0);
                    TextView var29 = new TextView(this.a);
                    var29.setLayoutParams(this.av);
                    var25.addView(var29);
                    var27 = new LinearLayout(this.a);
                    var27.setLayoutParams(this.aw);
                    var27.setOrientation(1);
                    var25.addView(var27);
                    this.ap.addView(var25);
                }
            }

            if (var32.size() > 0) {
                for(var2 = 0; var2 < var32.size() / 5 + 1; ++var2) {
                    if (var2 == 0) {
                        this.ax.setMargins(0, 1, 0, 0);
                    } else {
                        this.ax.setMargins(0, 0, 0, 0);
                    }

                    var25 = new LinearLayout(this.a);
                    var25.setLayoutParams(this.ax);

                    for(var10 = 0; var10 < 5; ++var10) {
                        View var36;
                        if (var32.size() > var2 * 5 + var10) {
                            JSONObject var35 = (JSONObject)var32.get(var2 * 5 + var10);
                            var15 = var35.optInt("MONSTER_NO");
                            if (var15 > 0) {
                                ResizableImageView var30 = new ResizableImageView(this.a, (AttributeSet)null);
                                var30.setLayoutParams(this.ay);
                                com.dnt7.padguide.c.i.a(this.a, var30, var15);
                                var30.setTag(var15);
                                var30.setOnClickListener(this.aD);
                                if (var35.optInt("ON_" + this.h) == 0) {
                                    var30.setColorFilter(this.ar);
                                }

                                var25.addView(var30);
                            } else {
                                var36 = new View(this.a);
                                var36.setLayoutParams(this.ay);
                                var25.addView(var36);
                            }
                        } else {
                            var36 = new View(this.a);
                            var36.setLayoutParams(this.ay);
                            var25.addView(var36);
                        }
                    }

                    var27.addView(var25);
                }
            }

            View var33 = new View(this.a);
            var33.setLayoutParams(this.az);
            var33.setBackgroundColor(this.c.a("PLACE_HOLDER_DARK"));
            this.ap.addView(var33);
        }

    }

    public View a(LayoutInflater var1, ViewGroup var2, Bundle var3) {
        this.a = this.f_();
        this.b = this.a.getSharedPreferences("setting", 0);
        this.c = m.a(this.a);
        this.aj = this.b.getString("EGG_MACHINE_CATEGORY", "");
        this.h = this.b.getString("EGG_MACHINE_SERVER", com.dnt7.padguide.c.e.e(this.a).optString("0"));
        this.i = com.dnt7.padguide.c.e.a(this.a);
        View var5 = var1.inflate(2130903103, var2, false);
        var5.findViewById(2131493271).setOnClickListener(this);
        var5.findViewById(2131493273).setOnClickListener(this);
        this.d = var5.findViewById(2131493275);
        this.e = var5.findViewById(2131493277);
        this.e.setVisibility(4);
        this.ap = (LinearLayout)var5.findViewById(2131493276);
        this.aq = (LinearLayout)var5.findViewById(2131493278);
        this.f = com.dnt7.padguide.c.e.e.indexOf(this.h);
        this.g = (RadioGroup)var5.findViewById(2131493272);
        if (this.f >= this.g.getChildCount()) {
            this.f = 0;
        }

        this.g.check(this.g.getChildAt(this.f).getId());
        this.g.setOnCheckedChangeListener(this.aB);
        ColorMatrix var6 = new ColorMatrix();
        var6.setSaturation(0.0F);
        this.ar = new ColorMatrixColorFilter(var6);
        this.as = this.a.getResources().getDimensionPixelSize(2131165212);
        this.at = new LayoutParams(-1, -2);
        this.at.setMargins(this.as, this.as, this.as, this.as * 2);
        this.au = new LayoutParams(-1, -2);
        this.au.setMargins(this.as, 0, 0, 0);
        this.av = new LayoutParams(0, -2, 2.0F);
        this.aw = new LayoutParams(0, -2, 5.0F);
        this.ax = new LayoutParams(-1, -2);
        this.ax.setMargins(0, 0, 0, 0);
        this.ay = new LayoutParams(0, -2, 1.0F);
        this.ay.setMargins(1, 0, 0, 0);
        this.az = new LayoutParams(-1, 1);
        this.az.setMargins(0, this.as, 0, this.as);
        int var4 = this.a.getResources().getDimensionPixelSize(2131165248);
        this.aA = new LayoutParams(var4, var4);
        return var5;
    }

    public String b_() {
        return this.a.getString(2131100006);
    }

    public void c_() {
        this.e.setVisibility(0);
    }

    public void e() {
        super.e();
        this.T();
    }

    public View h() {
        return this.d;
    }

    public String j() {
        return this.a.getString(2131100006);
    }

    public void l() {
        this.e.setVisibility(4);
    }

    public void onClick(View var1) {
        switch(var1.getId()) {
            case 2131493271:
                this.a();
            case 2131493272:
            default:
                break;
            case 2131493273:
                av var2 = com.dnt7.padguide.d.av.R();
                var2.a(this, 0);
                var2.a(this.f_().f(), (String)null);
        }

    }

    private class a extends com.dnt7.padguide.b.d<Void, Void, Void> {
        public a(android.support.v4.app.k var2) {
            super(var2);
        }

        protected Void a(Void... var1) {
            ArrayList var6 = u.a(o.this.a, o.this.i);
            o.this.al = new ArrayList();
            o.this.am = new ArrayList();
            Iterator var2 = var6.iterator();

            while(var2.hasNext()) {
                JSONObject var3 = (JSONObject)var2.next();
                o.this.al.add(var3.optString("TEC_SEQ"));
                o.this.am.add(var3.optString("NAME"));
            }

            var6.clear();
            int var4 = 0;

            boolean var5;
            for(var5 = false; var4 < o.this.al.size(); ++var4) {
                if (((String)o.this.al.get(var4)).equals(o.this.aj)) {
                    var5 = true;
                    o.this.ak = k.a((String)o.this.al.get(var4));
                }
            }

            if (!var5 && o.this.al.size() > 0) {
                String var7 = (String)o.this.al.get(0);
                o.this.ak = k.a(var7);
            }

            o.this.b.edit().putString("EGG_MACHINE_CATEGORY", String.valueOf(o.this.ak)).commit();
            o.this.ao = w.a(o.this.a, o.this.ak, o.this.i);
            o.this.an = y.a(o.this.a, o.this.ak, o.this.h, o.this.i);
            return null;
        }

        protected void a(Void var1) {
            if (o.this.p()) {
                o.this.U();
            }

            super.onPostExecute(var1);
        }

        protected void onPreExecute() {
            super.onPreExecute();
            o.this.ap.removeAllViews();
        }
    }
}
