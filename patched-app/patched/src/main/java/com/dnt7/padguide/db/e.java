//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dnt7.padguide.db;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import com.dnt7.padguide.c.g;
import com.dnt7.padguide.e.b.c;
import com.dnt7.padguide.f.k;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {
    public Context a;
    public SQLiteDatabase b;
    public boolean c = false;
    public int d = 30000;
    public int e = 200000;
    public int f = 0;
    public ProgressDialog g = null;
    public com.dnt7.padguide.e.b.a h = new com.dnt7.padguide.e.b.a() {
        public void a(String var1, String var2) {
            e.this.c();
        }

        public void a(JSONObject var1, String var2) {
            Iterator var9 = var1.keys();

            while(var9.hasNext()) {
                String var3 = (String)var9.next();
                long var4 = var1.optLong(var3, 0L);
                var3 = e.this.c(var3);
                if (com.dnt7.padguide.f.k.d(var3)) {
                    long var6 = e.this.a(e.this.b, var3);
                    if (var4 > 0L && var4 > var6) {
                        var3 = e.this.d(var3);
                        if (com.dnt7.padguide.f.k.d(var3)) {
                            var3 = e.this.b(var3);
                            e var8 = e.this;
                            ++var8.f;
                            e.b var10 = e.this.new b(e.this.a);
                            var10.e = e.this.d;
                            var10.c = var3;
                            var10.d = String.valueOf(var6);
                            e.this.i.add(var10);
                            var10.execute(new String[0]);
                        }
                    }
                }
            }

            if (e.this.f == 0) {
                e.this.c();
            }

        }
    };
    private ArrayList<e.b> i = null;
    private ArrayList<String> j = null;
    private ArrayList<String> k = null;
    private ArrayList<String> l = null;
    private ArrayList<String> m = null;
    private String[] n = new String[]{"LOCALDATA|TBL_LOCALDATA|/api/localDataList.jsp|", "MULTI_MASTER|TBL_MULTI_MASTER|/api/multiMasterList.jsp|", "MCOL_TAG|TBL_MCOL_TAG|/api/mcolTagList.jsp|TG,AC", "MULTI_INPUT_FORM|TBL_MULTI_INPUT_FORM|/api/multiInputFormList.jsp|URL,STG", "GUIDE|TBL_GUIDE|/api/guideList.jsp|"};
    private String o = "TS";
    private String p = "http://api.gamekiji.com";

    public e(Context var1) {
        this.a = var1;
        this.b = com.dnt7.padguide.db.d.b(this.a).getWritableDatabase();
        this.d();
    }

    private long a(SQLiteDatabase param1, String param2) {
        // $FF: Couldn't be decompiled
    }

    private String a(String var1, ArrayList<String> var2, ArrayList<String> var3, JSONObject var4) {
        String var5 = "";
        Iterator var6 = var3.iterator();

        String var7;
        String var8;
        String var10;
        for(var10 = ""; var6.hasNext(); var10 = com.dnt7.padguide.f.k.b(var10, var7 + "='" + var8 + "'", ",")) {
            var7 = (String)var6.next();
            var8 = com.dnt7.padguide.f.k.e(var4.optString(var7));
        }

        var6 = var2.iterator();

        String var9;
        for(var9 = var5; var6.hasNext(); var9 = com.dnt7.padguide.f.k.b(var9, var5 + "='" + var8 + "'", " AND ")) {
            var5 = (String)var6.next();
            var8 = com.dnt7.padguide.f.k.e(var4.optString(var5));
        }

        return "UPDATE " + var1 + " SET " + var10 + " WHERE " + var9 + " ";
    }

    private String a(String var1, ArrayList<String> var2, JSONObject var3) {
        Iterator var4 = var2.iterator();

        String var5;
        String var6;
        String var7;
        for(var7 = ""; var4.hasNext(); var7 = com.dnt7.padguide.f.k.b(var7, var5 + "='" + var6 + "' ", " AND ")) {
            var5 = (String)var4.next();
            var6 = com.dnt7.padguide.f.k.e(var3.optString(var5));
        }

        return "SELECT * FROM " + var1 + " WHERE " + var7 + " ";
    }

    private JSONArray a(JSONArray var1, String var2) {
        int var3 = this.k.indexOf(var2);
        var2 = (String)this.m.get(var3);
        String[] var8;
        if (com.dnt7.padguide.f.k.d(var2)) {
            var8 = var2.split(",");
        } else {
            var8 = null;
        }

        if (var8 != null && var8.length > 0) {
            int var4 = var8.length;

            for(var3 = 0; var3 < var4; ++var3) {
                String var5 = var8[var3].trim();

                for(int var6 = 0; var6 < var1.length(); ++var6) {
                    JSONObject var7 = var1.getJSONObject(var6);
                    var7.put(var5, com.dnt7.padguide.f.a.b(var7.optString(var5)));
                }
            }
        }

        return var1;
    }

    private void a(e.b var1) {
        if (var1 != null) {
            this.i.remove(var1);
            var1.cancel(true);
        }

        if (this.i.size() == 0) {
            this.c();
        }

    }

    private String b(String var1, ArrayList<String> var2, ArrayList<String> var3, JSONObject var4) {
        Iterator var5 = var2.iterator();
        String var6 = "";

        String var7;
        String var8;
        for(var8 = ""; var5.hasNext(); var8 = com.dnt7.padguide.f.k.b(var8, "'" + var7 + "'", ",")) {
            var7 = (String)var5.next();
            var6 = com.dnt7.padguide.f.k.b(var6, var7, ",");
            var7 = com.dnt7.padguide.f.k.e(var4.optString(var7));
        }

        String var9;
        for(Iterator var11 = var3.iterator(); var11.hasNext(); var8 = com.dnt7.padguide.f.k.b(var8, "'" + var9 + "'", ",")) {
            var9 = (String)var11.next();
            var6 = com.dnt7.padguide.f.k.b(var6, var9, ",");
            String var10 = var4.optString(var9);
            var9 = var10;
            if (com.dnt7.padguide.f.k.b(var10)) {
                var9 = com.dnt7.padguide.f.k.e(var10);
            }
        }

        return "INSERT INTO " + var1 + " (" + var6 + ") VALUES (" + var8 + ") ";
    }

    private void b(e.b var1) {
        int var2 = var1.e + this.d;
        if (var2 < this.e) {
            e.b var3 = new e.b(this.a);
            var3.e = var2;
            var3.c = var1.c;
            var3.d = var1.d;
            var3.execute(new String[0]);
            this.i.add(var3);
        }

        this.a(var1);
    }

    private String c(String var1) {
        int var2 = 0;

        while(true) {
            if (var2 >= this.j.size()) {
                var1 = "";
                break;
            }

            if (((String)this.j.get(var2)).equals(var1)) {
                var1 = (String)this.k.get(var2);
                break;
            }

            ++var2;
        }

        return var1;
    }

    private String d(String var1) {
        if (this.k.contains(var1)) {
            var1 = (String)this.l.get(this.k.indexOf(var1));
        } else {
            var1 = "";
        }

        return var1;
    }

    private void d() {
        if (this.j == null) {
            this.j = new ArrayList();
        }

        if (this.k == null) {
            this.k = new ArrayList();
        }

        if (this.l == null) {
            this.l = new ArrayList();
        }

        if (this.m == null) {
            this.m = new ArrayList();
        }

        String[] var1 = this.n;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String[] var4 = var1[var3].split("[|]", 4);
            this.j.add(var4[0]);
            this.k.add(var4[1]);
            this.l.add(var4[2]);
            this.m.add(var4[3]);
        }

        if (this.i == null) {
            this.i = new ArrayList();
        }

    }

    public void a(SQLiteDatabase param1, JSONArray param2, String param3, e.a param4) {
        // $FF: Couldn't be decompiled
    }

    public void a(String var1) {
        try {
            com.dnt7.padguide.db.d.a(this.b);
            if (com.dnt7.padguide.f.k.d(var1)) {
                this.getClass().getMethod(var1).invoke(this);
            }
        } catch (NoSuchMethodException var2) {
            com.dnt7.padguide.c.g.b("PadGuide", var2);
        } catch (IllegalAccessException var3) {
            com.dnt7.padguide.c.g.b("PadGuide", var3);
        } catch (IllegalArgumentException var4) {
            com.dnt7.padguide.c.g.b("PadGuide", var4);
        } catch (InvocationTargetException var5) {
            com.dnt7.padguide.c.g.b("PadGuide", var5);
        }

    }

    public boolean a() {
        boolean var1 = false;
        SharedPreferences var2 = PreferenceManager.getDefaultSharedPreferences(this.a);
        int var3 = com.dnt7.padguide.f.b.c(this.a);
        if (var2.getInt("APP_VERSION", 0) < var3) {
            var1 = true;
        }

        return var1;
    }

    public String b(String var1) {
        return this.p + var1;
    }

    public void b() {
        this.c = true;
        this.f = 0;
        com.dnt7.padguide.e.b.a(this.a, this.b("/api/getTimestamp.jsp"), (Map)null, this.h);
    }

    public void c() {
        this.c = false;
    }

    private class a extends AsyncTask<JSONObject, String, Void> {
        private ProgressDialog b;
        private e.b c;

        public a(e.b var2, ProgressDialog var3) {
            this.b = var3;
            this.c = var2;
        }

        protected Void a(JSONObject... param1) {
            // $FF: Couldn't be decompiled
        }

        protected void a(Void var1) {
            super.onPostExecute(var1);
            e.this.a(this.c);
        }

        protected void a(String... var1) {
            super.onProgressUpdate(var1);
            if (this.b != null) {
                this.b.setMessage(var1[0]);
            }

        }

        public void b(String... var1) {
            this.publishProgress(var1);
        }
    }

    private class b extends AsyncTask<String, Void, String> {
        private JSONObject b;
        private String c;
        private String d;
        private int e = 0;
        private Context f;

        public b(Context var2) {
            this.f = var2;
        }

        protected String a(String... var1) {
            String var4;
            try {
                if (this.e == 0) {
                    this.e = e.this.d;
                }

                String var2 = this.c;
                HashMap var5 = new HashMap();
                var5.put(e.this.o, this.d);
                c var6 = com.dnt7.padguide.e.b.a(this.f, var2, var5);
                if (!var6.a().equals("9000")) {
                    var4 = var6.a();
                    return var4;
                }

                this.b = var6.c();
                this.b.put("API_URL", this.c);
                e.a var7 = e.this.new a(this, e.this.g);
                var7.execute(new JSONObject[]{this.b});
            } catch (Exception var3) {
                com.dnt7.padguide.c.g.b("PadGuide", var3);
                var4 = "9999";
                return var4;
            }

            var4 = "9000";
            return var4;
        }

        protected void a(String var1) {
            if (!var1.equals("9000")) {
                e.this.b(this);
            }

            super.onPostExecute(var1);
        }
    }
}
