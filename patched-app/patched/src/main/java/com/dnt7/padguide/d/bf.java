//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dnt7.padguide.d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.dnt7.padguide.activity.MonsterExpActivity;
import com.dnt7.padguide.b.b;
import com.dnt7.padguide.c.e;
import com.dnt7.padguide.c.i;
import com.dnt7.padguide.c.m;
import com.dnt7.padguide.db.a.ai;
import com.dnt7.padguide.db.a.at;
import com.dnt7.padguide.db.a.bd;
import com.dnt7.padguide.db.a.bl;
import com.dnt7.padguide.db.a.bo;
import com.dnt7.padguide.db.a.br;
import com.dnt7.padguide.db.a.bv;
import com.dnt7.padguide.db.a.bx;
import com.dnt7.padguide.db.a.f;
import com.dnt7.padguide.db.a.g;
import com.dnt7.padguide.db.a.h;
import com.dnt7.padguide.f.d;
import com.dnt7.padguide.f.k;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import org.json.JSONObject;

public class bf extends b {
    private Context a;
    private LinearLayout aj = null;
    private RadioGroup ak = null;
    private SharedPreferences al = null;
    private OnCheckedChangeListener am = new OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup var1, int var2) {
            var2 = bf.this.ak.indexOfChild(bf.this.ak.findViewById(var2));
            bf.this.b(var2);
        }
    };
    private String b = "JP";
    private ArrayList<ArrayList<bf.a>> c = null;
    private ArrayList<bf.a> d = null;
    private ArrayList<bf.a> e = null;
    private ArrayList<bf.a> f = null;
    private ArrayList<bf.a> g = null;
    private ArrayList<bf.a> h = null;
    private ScrollView i = null;

    public bf() {
    }

    private void b(int var1) {
        this.al.edit().putInt("UTIL_MENU", var1).commit();
        ArrayList var2 = null;

        for(int var3 = 0; var3 < this.ak.getChildCount(); ++var3) {
            boolean var4;
            if (var3 == var1) {
                var4 = true;
            } else {
                var4 = false;
            }

            if (var4) {
                var2 = (ArrayList)this.c.get(var3);
            }
        }

        LayoutInflater var5 = this.f_().getLayoutInflater();
        this.aj.removeAllViews();

        for(var1 = 0; var1 < var2.size(); ++var1) {
            final bf.a var6 = (bf.a)var2.get(var1);
            LinearLayout var7 = (LinearLayout)var5.inflate(2130903225, this.aj, false);
            ImageView var8 = (ImageView)var7.findViewById(2131494482);
            TextView var9 = (TextView)var7.findViewById(2131494483);
            TextView var10 = (TextView)var7.findViewById(2131494484);
            if (var6.c != null) {
                var8.setImageDrawable(var6.c);
            } else {
                com.dnt7.padguide.c.i.a(this.a, var8, var6.d);
            }

            var9.setText(var6.e);
            if (k.c(var6.f)) {
                var10.setVisibility(8);
            } else {
                var10.setText(var6.f);
            }

            var7.setOnClickListener(new OnClickListener() {
                public void onClick(View var1) {
                    if (var6.a != null) {
                        bf.this.a(var6.a);
                    } else if (var6.b != null) {
                        bf.this.b(var6.b);
                    }

                }
            });
            this.aj.addView(var7);
        }

        m.a(this.a, this.aj);
        this.i.fullScroll(33);
    }

    public View a(LayoutInflater var1, ViewGroup var2, Bundle var3) {
        this.a = this.f_();
        this.b = com.dnt7.padguide.c.e.a(this.a);
        this.al = this.a.getSharedPreferences("setting", 0);
        View var4 = var1.inflate(2130903224, var2, false);
        this.i = (ScrollView)var4.findViewById(2131494480);
        this.aj = (LinearLayout)var4.findViewById(2131494481);
        this.ak = (RadioGroup)var4.findViewById(2131494473);
        this.ak.setOnCheckedChangeListener(this.am);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.c.add(this.d);
        this.c.add(this.e);
        this.c.add(this.f);
        this.c.add(this.g);
        this.c.add(this.h);
        return var4;
    }

    public void e() {
        super.e();
        String var1 = bx.b(this.a);
        String var2 = this.al.getString("profileID", "");
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.h.clear();
        JSONObject var3 = br.a(this.a, var1, var2);
        String var4 = var3.optString("TM_NAME_" + this.b);
        bf.a var5 = new bf.a(null);
        var5.b = new aj();
        var5.d = var3.optInt("MONSTER_NO");
        var5.e = this.a(2131100110);
        if (k.b(var4)) {
            var5.f = "[No." + var3.optInt("LOCAL_MONSTER_NO") + "] " + var4;
        } else {
            var5.f = this.a(2131100111);
        }

        this.d.add(var5);
        JSONObject var19 = bv.a(this.a, var1, var2);
        String var15 = var19.optString("TM_NAME_" + this.b);
        bf.a var16 = new bf.a(null);
        var16.b = new al();
        var16.d = var19.optInt("MONSTER_NO");
        var16.e = this.a(2131100296);
        if (k.b(var15)) {
            var16.f = "[No." + var19.optInt("LOCAL_MONSTER_NO") + "] " + var15;
        } else {
            var16.f = this.a(2131100297);
        }

        this.d.add(var16);
        var3 = bo.c(this.a, var1, var2);
        String var20 = var3.optString("TM_NAME_" + this.b);
        var16 = new bf.a(null);
        var16.b = new ac();
        var16.d = var3.optInt("MONSTER_NO");
        var16.e = this.a(2131100086);
        if (k.b(var20)) {
            var16.f = "[No." + var3.optInt("LOCAL_MONSTER_NO") + "] " + var20;
        } else {
            var16.f = this.a(2131100087);
        }

        this.d.add(var16);
        var16 = new bf.a(null);
        var16.b = new c();
        var16.c = this.m().getDrawable(2130837675);
        var16.e = this.a(2131099896);
        var16.f = "";
        this.d.add(var16);
        JSONObject var11 = br.b(this.a, var1, var2, this.al.getInt("MY_MONSTER_ORDER", 0));
        var4 = var11.optString("TM_NAME_" + this.b);
        bf.a var13 = new bf.a(null);
        var13.b = new ah();
        var13.d = var11.optInt("MONSTER_NO");
        var13.e = this.a(2131099772);
        if (k.b(var4)) {
            var13.f = "[No." + var11.optInt("LOCAL_MONSTER_NO") + "] " + var4;
        } else {
            var13.f = this.a(2131099773);
        }

        this.d.add(var13);
        Iterator var21 = com.dnt7.padguide.db.a.g.a(this.a).iterator();

        int var6;
        bf.a var12;
        while(var21.hasNext()) {
            f var14 = (f)var21.next();
            var6 = com.dnt7.padguide.db.a.h.a(this.a, var14.a);
            var12 = new bf.a(null);
            var12.b = com.dnt7.padguide.d.e.b(var14.a);
            var12.d = var6;
            var12.e = this.a(this.a.getResources().getIdentifier(var14.a("US").replaceAll("\\p{Space}", ""), "string", this.a.getPackageName()));
            var12.f = this.a(this.a.getResources().getIdentifier(var14.a("US").replaceAll("\\p{Space}", "") + "Desc", "string", this.a.getPackageName()));
            this.d.add(var12);
        }

        var13 = new bf.a(null);
        var13.b = new s();
        var13.d = 781;
        var13.e = this.a(2131100040);
        var13.f = this.a(2131100041);
        this.e.add(var13);
        JSONObject var22 = ai.a(this.a);
        var1 = var22.optString("TM_NAME_" + this.b);
        var13 = new bf.a(null);
        var13.b = new ao();
        var13.d = var22.optInt("MONSTER_NO");
        var13.e = this.a(2131100183);
        if (k.b(var1)) {
            var13.f = "[No." + var22.optInt("LOCAL_MONSTER_NO") + "] " + var1;
        } else {
            var13.f = this.a(2131100184);
        }

        this.e.add(var13);
        var13 = new bf.a(null);
        var13.b = r.b(0);
        var13.d = 752;
        var13.e = this.a(2131100035);
        var13.f = this.a(2131100036);
        this.e.add(var13);
        var13 = new bf.a(null);
        var13.b = r.b(1);
        var13.d = 1422;
        var13.e = this.a(2131100135);
        Calendar var23 = Calendar.getInstance();
        var1 = com.dnt7.padguide.f.d.a(this.a, var23.getTimeInMillis());
        var23.add(5, -30);
        var4 = com.dnt7.padguide.f.d.a(this.a, var23.getTimeInMillis());
        var13.f = var4 + " ~ " + var1;
        this.e.add(var13);
        var13 = new bf.a(null);
        var13.b = x.a(new com.dnt7.padguide.c.f(this.a, 3));
        var13.d = 980;
        var13.e = this.a(2131099903);
        this.f.add(var13);
        var13 = new bf.a(null);
        var13.b = x.a(new com.dnt7.padguide.c.f(this.a, 2));
        var13.d = 1818;
        var13.e = this.a(2131099794);
        this.f.add(var13);
        var12 = new bf.a(null);
        com.dnt7.padguide.c.f var18 = new com.dnt7.padguide.c.f(this.a, 4);
        var18.b = true;
        var18.c = true;
        var18.i = true;
        var18.l = true;
        var18.d = true;
        var18.e = true;
        var18.f = this.a(2131099819);
        var18.h = "IMAGE_BOARD_ROOM_ID";
        var18.j = true;
        var12.b = x.a(var18);
        var12.d = 1922;
        var12.e = this.a(2131099782);
        this.f.add(var12);
        var12 = new bf.a(null);
        var18 = new com.dnt7.padguide.c.f(this.a, 5);
        var18.b = true;
        var18.d = true;
        var18.e = true;
        var18.f = this.a(2131099754);
        var18.g = this.a(2131099744);
        var18.h = "IMAGE_BOARD_FINDER_ID";
        var18.i = true;
        var18.j = true;
        var18.k = this.a(2131099820);
        var12.b = x.a(var18);
        var12.d = 2085;
        var12.e = this.a(2131099743);
        this.f.add(var12);
        var13 = new bf.a(null);
        var13.b = x.a(new com.dnt7.padguide.c.f(this.a, 1));
        var13.d = 2251;
        var13.e = this.a(2131099811);
        this.f.add(var13);
        var13 = new bf.a(null);
        var13.b = new bh();
        var13.c = this.m().getDrawable(2130837815);
        var13.e = this.a(2131099864);
        this.f.add(var13);
        boolean var7;
        if (this.b.equals("JP")) {
            var7 = true;
        } else {
            var7 = false;
        }

        if (var7) {
            var13 = new bf.a(null);
            var13.b = new n();
            var13.d = 2290;
            var13.e = this.a(2131099792);
            this.f.add(var13);
            var13 = new bf.a(null);
            var13.b = bg.b("http://yuuoku.blog.fc2.com/");
            var13.d = 1099;
            var13.e = "エキドナ速報";
            var13.f = "パズドラ速報・最新情報＆攻略情報まとめ";
            this.f.add(var13);
            var13 = new bf.a(null);
            var13.b = new aq();
            var13.c = this.m().getDrawable(2130837673);
            var13.e = this.a(2131099909);
            var13.f = this.a(2131099910);
            this.f.add(var13);
        }

        var11 = at.g(this.a);
        var13 = new bf.a(null);
        var13.b = new ba();
        var13.d = var11.optInt("MONSTER_NO");
        var13.e = this.a(2131099830);
        this.g.add(var13);
        JSONObject var24 = at.f(this.a);
        var12 = new bf.a(null);
        var12.b = new aw();
        var12.d = var24.optInt("MONSTER_NO");
        var12.e = this.a(2131099828);
        this.g.add(var12);
        var22 = com.dnt7.padguide.db.a.ac.a(this.a);
        var2 = var22.optString("TM_NAME_" + this.b);
        var12 = new bf.a(null);
        var12.b = new q();
        var12.d = var22.optInt("MONSTER_NO");
        var12.e = this.a(2131100026);
        if (k.b(var2)) {
            var12.f = "[No." + var22.optInt("LOCAL_MONSTER_NO") + "] " + var2;
        } else {
            var12.f = this.a(2131100026);
        }

        this.g.add(var12);
        var22 = at.a(this.a);
        var12 = new bf.a(null);
        var12.b = new ay();
        var12.d = var22.optInt("MONSTER_NO");
        var12.e = this.a(2131100262);
        var12.f = "";
        this.g.add(var12);
        var22 = at.c(this.a);

        StringBuilder var17;
        label93: {
            try {
                var17 = new StringBuilder();
                var1 = com.dnt7.padguide.f.a.c(var22.optString(var17.append("TS_NAME_").append(this.b).toString()));
            } catch (Exception var10) {
                com.dnt7.padguide.c.g.b("PadGuide", var10);
                break label93;
            }

            var2 = var1;
        }

        var12 = new bf.a(null);
        var12.b = az.a(1, 0);
        var12.d = var22.optInt("MONSTER_NO");
        var12.e = this.a(2131099865);
        if (k.b(var2)) {
            var12.f = "[No." + var22.optInt("LOCAL_MONSTER_NO") + "] " + var2;
        } else {
            var12.f = this.a(2131099865);
        }

        this.g.add(var12);
        var22 = at.d(this.a);

        label88: {
            try {
                var17 = new StringBuilder();
                var1 = com.dnt7.padguide.f.a.c(var22.optString(var17.append("TS_NAME_").append(this.b).toString()));
            } catch (Exception var9) {
                com.dnt7.padguide.c.g.b("PadGuide", var9);
                break label88;
            }

            var2 = var1;
        }

        var12 = new bf.a(null);
        var12.b = az.a(2, 0);
        var12.d = var22.optInt("MONSTER_NO");
        var12.e = this.a(2131100069);
        if (k.b(var2)) {
            var12.f = "[No." + var22.optInt("LOCAL_MONSTER_NO") + "] " + var2;
        } else {
            var12.f = this.a(2131100069);
        }

        this.g.add(var12);
        var13 = new bf.a(null);
        var13.b = new com.dnt7.padguide.d.b();
        var13.d = 797;
        var13.e = this.a(2131099890);
        var13.f = this.a(2131099892);
        this.g.add(var13);
        var24 = at.a(this.a);
        var1 = var24.optString("TM_NAME_" + this.b);
        var16 = new bf.a(null);
        var16.b = new com.dnt7.padguide.d.at();
        var16.d = var24.optInt("MONSTER_NO");
        var16.e = this.a(2131100227);
        if (k.b(var1)) {
            var16.f = "[No." + var24.optInt("LOCAL_MONSTER_NO") + "] " + var1;
        } else {
            var16.f = this.a(2131100228);
        }

        this.g.add(var16);
        var13 = new bf.a(null);
        var13.b = new bc();
        var13.c = this.m().getDrawable(2130837675);
        var13.e = this.a(2131099955);
        var13.f = this.a(2131099956);
        this.h.add(var13);
        int var8 = bd.b(this.a, "COMPARE_MONSTER_2", 0);
        var6 = var8;
        if (var8 <= 0) {
            var6 = bd.b(this.a, "COMPARE_MONSTER_1", 0);
        }

        var8 = var6;
        if (var6 <= 0) {
            var8 = at.b(this.a);
        }

        var13 = new bf.a(null);
        var13.b = new ae();
        var13.d = var8;
        var13.e = this.a(2131099717);
        var13.f = "";
        this.h.add(var13);
        var13 = new bf.a(null);
        var13.b = new z();
        var13.d = 304;
        var13.e = this.a(2131100188);
        var13.f = "";
        this.h.add(var13);
        var13 = new bf.a(null);
        var13.b = j.a(true);
        var13.d = 2526;
        var13.e = this.a(2131099810);
        var13.f = "";
        this.h.add(var13);
        if (var7) {
            var13 = new bf.a(null);
            var13.b = new am();
            var13.c = this.m().getDrawable(2130837706);
            var13.e = this.a(2131099706);
            this.h.add(var13);
        }

        var13 = new bf.a(null);
        var13.b = new ab();
        var13.d = 2250;
        var13.e = this.a(2131099732);
        var13.f = "";
        this.h.add(var13);
        var13 = new bf.a(null);
        var13.b = ab.a(true);
        var13.d = 2253;
        var13.e = this.a(2131099762);
        var13.f = "";
        this.h.add(var13);
        var13 = new bf.a(null);
        var13.b = new j();
        var13.d = bl.a(this.a);
        var13.e = this.a(2131099991);
        var13.f = this.a(2131099992);
        this.h.add(var13);
        var13 = new bf.a(null);
        var13.a = new Intent(this.a, MonsterExpActivity.class);
        var13.d = 178;
        var13.e = this.a(2131100030);
        var13.f = "";
        this.h.add(var13);
        var13 = new bf.a(null);
        var13.b = new bb();
        var13.c = this.m().getDrawable(2130837792);
        var13.e = this.a(2131100274);
        var13.f = "";
        this.h.add(var13);
        var13 = new bf.a(null);
        var13.b = new aa();
        var13.d = 306;
        var13.e = this.a(2131100073);
        var13.f = "";
        this.h.add(var13);
        int var25 = this.al.getInt("UTIL_MENU", 2);
        var6 = var25;
        if (var25 >= this.ak.getChildCount()) {
            var6 = 0;
        }

        this.ak.check(this.ak.getChildAt(var6).getId());
        this.b(var6);
    }

    public void e(Bundle var1) {
        super.e(var1);
    }

    private class a {
        public Intent a;
        public android.support.v4.app.k b;
        public Drawable c;
        public int d;
        public String e;
        public String f;

        private a() {
            this.c = null;
            this.d = 0;
            this.e = "";
            this.f = "";
        }
    }
}
