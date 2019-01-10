//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dnt7.padguide.db.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.dnt7.padguide.c.b;
import com.dnt7.padguide.c.e;
import com.dnt7.padguide.c.g;
import com.dnt7.padguide.c.m;
import com.dnt7.padguide.db.a.z.a;
import com.dnt7.padguide.f.d;
import com.dnt7.padguide.f.k;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public class ba {
    private static final String[] a = new String[]{"SCHEDULE_SEQ", "DUNGEON_SEQ", "EVENT_SEQ", "SERVER", "EVENT_TYPE", "OPEN_WEEKDAY", "OPEN_DATE", "OPEN_HOUR", "OPEN_MINUTE", "OPEN_DATETIME", "CLOSE_WEEKDAY", "CLOSE_DATE", "CLOSE_HOUR", "CLOSE_MINUTE", "CLOSE_DATETIME", "TEAM_DATA", "TSTAMP", "REG_DATE", "ALARM_ON", "SERVER_OPEN_DATE", "URL", "SERVER_OPEN_HOUR"};

    public static int a(Context var0, az var1) {
        int var2 = var1.a;
        return var0.getContentResolver().update(p.a, var1.a(), "SCHEDULE_SEQ=?", new String[]{String.valueOf(var2)});
    }

    public static int a(SQLiteDatabase var0, String var1, String var2) {
        return var0.delete("TBL_SCHEDULE", "SERVER = ? and SERVER_OPEN_DATE = ? and EVENT_TYPE = " + com.dnt7.padguide.db.a.z.a.d.a(), new String[]{var1, var2});
    }

    public static int a(String var0) {
        int var1;
        if (var0.equals("JP")) {
            var1 = b.o;
        } else if (var0.equals("US")) {
            var1 = b.p;
        } else if (var0.equals("KR")) {
            var1 = b.q;
        } else {
            var1 = b.o;
        }

        return var1;
    }

    public static az a(Context param0, int param1) {
        // $FF: Couldn't be decompiled
    }

    public static az a(SQLiteDatabase param0, int param1) {
        // $FF: Couldn't be decompiled
    }

    public static String a(Context var0, Date var1, int var2, String var3, int var4) {
        Resources var5 = var0.getResources();
        long var6 = (var1.getTime() - (new Date()).getTime()) / 1000L;
        if (var6 % 60L == 0L) {
            var6 /= 60L;
        } else {
            var6 = var6 / 60L + 1L;
        }

        var2 = a(var3);
        int var8 = 1440 / var2;
        var2 = (int)var6 / var2;
        String var9;
        if (var2 <= var8) {
            var9 = k.a("%s%d", new Object[]{var5.getString(2131099837), var2});
        } else {
            var8 = var2 / var8;
            if (var4 == 0) {
                if (var8 > 1) {
                    var9 = var5.getString(2131099839, new Object[]{var8});
                } else {
                    var9 = var5.getString(2131099838, new Object[]{var8});
                }
            } else if (var8 > 1) {
                var9 = var5.getString(2131099740, new Object[]{var8});
            } else {
                var9 = var5.getString(2131099739, new Object[]{var8});
            }

            var9 = k.a("%s / %s%d", new Object[]{var9, var5.getString(2131099837), var2});
        }

        return var9;
    }

    public static ArrayList<JSONObject> a(Context param0, int param1, String param2) {
        // $FF: Couldn't be decompiled
    }

    public static ArrayList<JSONObject> a(Context param0, String param1, int param2, String param3, String param4, String param5) {
        // $FF: Couldn't be decompiled
    }

    public static ArrayList<JSONObject> a(Context param0, String param1, String param2, String param3) {
        // $FF: Couldn't be decompiled
    }

    public static ArrayList<JSONObject> a(Context param0, String param1, String param2, String param3, String param4, String param5) {
        // $FF: Couldn't be decompiled
    }

    private static JSONObject a(Context var0, Cursor var1, m var2, boolean var3, ArrayList<JSONObject> var4, String var5) {
        boolean var6 = e.k(var0);
        String var7 = e.a(var0);
        var3 = e.d(var0).getBoolean("1");
        boolean var8 = e.d(var0).getBoolean("2");
        boolean var9;
        if (!var3 && !var8) {
            var9 = false;
        } else {
            var9 = true;
        }

        JSONObject var10 = new JSONObject();

        int var11;
        for(var11 = 0; var11 < var1.getColumnCount(); ++var11) {
            var10.put(var1.getColumnName(var11), var1.getString(var11));
        }

        String var12 = var1.getString(var1.getColumnIndex("SCHEDULE_SEQ"));
        int var13 = var1.getInt(var1.getColumnIndex("DUNGEON_SEQ"));
        int var14 = var1.getInt(var1.getColumnIndex("EVENT_TYPE"));
        String var15 = var1.getString(var1.getColumnIndex("URL"));
        String var16 = com.dnt7.padguide.f.b.c(var0, var1.getString(var1.getColumnIndex("NAME_" + var7)), var1.getInt(var1.getColumnIndex("TDT_SEQ")));
        JSONArray var17 = var2.b("DIFF_COLORS");
        JSONArray var18 = var2.b("DIFF_COLORS3");
        var11 = var1.getInt(var1.getColumnIndex("TEAM_DATA"));
        String[] var19 = new String[]{"A", "B", "C", "D", "E"};
        int[] var20 = new int[]{2130837708, 2130837711, 2130837714};
        Resources var21 = var0.getResources();
        if (var14 == com.dnt7.padguide.db.a.z.a.d.a()) {
            if (var19.length > var11) {
                var16 = k.a("[%s] %s", new Object[]{var0.getResources().getString(2131099851, new Object[]{var19[var11]}), var16});
            }
        } else if (var14 == com.dnt7.padguide.db.a.z.a.c.a()) {
            if (var20.length > var11) {
                var10.put("STARTER_ICON", var20[var11]);
                var16 = k.a("[%s] %s", new Object[]{var21.getString(var21.getIdentifier("attribute0" + var11, "string", var0.getPackageName())), var16});
            }
        } else if (var14 == com.dnt7.padguide.db.a.z.a.e.a()) {
            var16 = k.a("[%s] %s", new Object[]{var21.getString(2131099851, new Object[]{k.a("%d", new Object[]{var11})}), var16});
        }

        var10.put("CELL_ID", var12);
        var10.put("TITLE", var16);
        var10.put("CELL_BG_COLOR", var2.a("CELL_BG_COLOR"));
        if (var14 == com.dnt7.padguide.db.a.z.a.d.a()) {
            var11 = var18.optInt(0);
            if (var13 != 47 && var13 != 137) {
                if (var13 != 44 && var13 != 52) {
                    if (var13 != 45 && var13 != 51) {
                        if (var13 == 48 || var13 == 49) {
                            var11 = var18.optInt(4);
                        }
                    } else {
                        var11 = var18.getInt(3);
                    }
                } else {
                    var11 = var18.optInt(2);
                }
            } else {
                var11 = var18.getInt(1);
            }

            var10.put("NOTI_COLOR", var11);
        } else {
            var10.put("NOTI_COLOR", var17.optInt(var1.getInt(var1.getColumnIndex("DUNGEON_TYPE"))));
        }

        String var22 = d.a("yyyy-MM-dd HH:mm");
        int var23 = TimeZone.getDefault().getOffset((new Date()).getTime());
        String var24 = var1.getString(var1.getColumnIndex("SERVER"));
        if (var9) {
            var10.put("SERVER_NAME", var0.getResources().getString(e.c[e.b.indexOf(var24)]));
        }

        int var25 = var2.a("MAIN_COLOR1");
        String var40;
        if (var9) {
            var40 = var0.getResources().getString(e.c[e.b.indexOf(var24)]);
        } else {
            var40 = "";
        }

        Date var26 = d.a(var5, "yyyy-MM-dd");
        Calendar var41 = Calendar.getInstance();
        var41.setTime(var26);
        var41.add(5, 1);
        var41.add(12, -1);
        Date var27 = var41.getTime();
        var41.setTime(var26);
        var41.add(5, -var41.get(7));
        var41.getTime();
        var41.add(13, var23 / 1000);
        Date var43 = var41.getTime();
        String var45 = var1.getString(var1.getColumnIndex("OPEN_DATE"));
        int var28 = var1.getInt(var1.getColumnIndex("OPEN_WEEKDAY")) + 1;
        var11 = var28;
        if (var28 > 7) {
            var11 = var28 - 7;
        }

        var28 = var1.getInt(var1.getColumnIndex("OPEN_HOUR"));
        int var29 = var1.getInt(var1.getColumnIndex("OPEN_MINUTE"));
        if (var12.equals("755")) {
            ;
        }

        Date var38;
        if (var14 == com.dnt7.padguide.db.a.z.a.a.a()) {
            var41.setTime(var43);
            var41.add(5, var11);
            var41.add(11, var28);
            var41.add(12, var29);
            if (var24.equals("US") && d.b(var41.getTime())) {
                var41.add(11, -1);
            }

            if (var41.getTime().after(var27)) {
                var41.add(5, -7);
            }

            var45 = d.a("yyyy-MM-dd HH:mm", var41.getTime());
            var38 = var41.getTime();
        } else {
            var38 = d.a(d.a(k.a("%s %02d:%02d", new Object[]{var45, var28, var29}), "yyyy-MM-dd HH:mm"), (long)var23);
            var45 = d.a("yyyy-MM-dd HH:mm", var38);
        }

        var10.put("OPEN_DATE", var45);
        String var30 = var1.getString(var1.getColumnIndex("CLOSE_DATE"));
        var28 = var1.getInt(var1.getColumnIndex("CLOSE_WEEKDAY")) + 1;
        var11 = var28;
        if (var28 > 7) {
            var11 = var28 - 7;
        }

        var28 = var1.getInt(var1.getColumnIndex("CLOSE_HOUR"));
        var29 = var1.getInt(var1.getColumnIndex("CLOSE_MINUTE"));
        Date var42;
        String var44;
        if (var14 == com.dnt7.padguide.db.a.z.a.a.a()) {
            var41.setTime(var43);
            var41.add(5, var11);
            var41.add(11, var28);
            var41.add(12, var29);
            if (var24.equals("US") && d.b(var41.getTime())) {
                var41.add(11, -1);
            }

            if (var41.getTime().before(var26)) {
                var41.add(5, 7);
            }

            var44 = d.a("yyyy-MM-dd HH:mm", var41.getTime());
            var42 = var41.getTime();
        } else {
            var42 = d.a(d.a(k.a("%s %02d:%02d", new Object[]{var30, var28, var29}), "yyyy-MM-dd HH:mm"), (long)var23);
            var44 = d.a("yyyy-MM-dd HH:mm", var42);
        }

        var10.put("CLOSE_DATE", var44);
        boolean var49 = false;
        boolean var46 = false;
        String var47;
        if (!var38.before(var26)) {
            var49 = true;
            var47 = d.b(var0, d.a(var45, "yyyy-MM-dd HH:mm").getTime());
        } else {
            var47 = d.d(var0, d.a(var45, "yyyy-MM-dd HH:mm").getTime());
        }

        String var48;
        if (var42.before(var27)) {
            var46 = true;
            var48 = d.b(var0, d.a(var44, "yyyy-MM-dd HH:mm").getTime());
        } else {
            var48 = d.d(var0, d.a(var44, "yyyy-MM-dd HH:mm").getTime());
        }

        JSONArray var35 = var2.b("DIFF_COLORS2");
        var35.getInt(1);
        JSONObject var31;
        byte var39;
        if (var45.compareTo(var22) > 0) {
            var39 = 0;
        } else if (var44.compareTo(var22) < 0) {
            if (var6 && var22.startsWith(var5)) {
                var31 = null;
                return var31;
            }

            var39 = 2;
        } else {
            var39 = 1;
        }

        String var32;
        if (var39 == 0) {
            var28 = var35.getInt(1);
            var32 = k.a("%s ~ %s [%s]", new Object[]{var47, var48, a(var0, var38, 0, var24, var39)});
            var23 = 2130837794;
        } else if (var39 != 1) {
            var23 = 2130837661;
            var28 = var35.getInt(2);
            var32 = k.a("%s ~ %s [%s]", new Object[]{var47, var48, var0.getResources().getString(2131099711)});
        } else {
            var29 = var35.getInt(0);
            var32 = a(var0, var42, 1, var24, var39);
            if (var49 && var46) {
                var32 = k.a("%s ~ %s [%s]", new Object[]{var47, var48, var32});
            } else {
                var32 = k.a("~ %s [%s]", new Object[]{var48, var32});
            }

            var28 = var29;
            var23 = 2130837609;
        }

        var10.put("LEFT_SUB_TEXT", var32);
        var10.put("LEFT_SUB_ICON", var23);
        var10.put("LEFT_SUB_ICON_COLOR", var28);
        var10.put("STATUS", var39);
        var12 = var1.getString(var1.getColumnIndex("EVENT_SEQ"));
        String var36 = "";
        if (!k.a(var12)) {
            var10.put("EVENT_SEQ", var12);
            var5 = var1.getString(var1.getColumnIndex("EVENT_NAME_" + var7));
            var36 = com.dnt7.padguide.f.a.c(var5);
            if (k.a(var36)) {
                var36 = var5;
            }

            var10.put("RIGHT_SUB_TEXT", var36);
            var23 = Integer.valueOf(var12);
            var28 = var17.getInt(2);
            if (var23 == 5) {
                var28 = var17.getInt(0);
            } else if (var23 == 3 || var23 == 4) {
                var28 = var17.getInt(1);
            }

            var10.put("RIGHT_SUB_TEXT_COLOR", var28);
        }

        if (var39 == 0) {
            var10.put("RIGHT_ICON", "icon_103_02.png");
        }

        var10.put("ALARM_ON", var1.getInt(var1.getColumnIndex("ALARM_ON")));
        if (!k.a(var40)) {
            var10.put("LEFT_TOP_TEXT", var40);
            var10.put("LEFT_TOP_TEXT_COLOR", var25);
        }

        if (var14 != com.dnt7.padguide.db.a.z.a.d.a() && var14 != com.dnt7.padguide.db.a.z.a.c.a() && var14 != com.dnt7.padguide.db.a.z.a.e.a() && a(var13, var4)) {
            for(var11 = 0; var11 < var4.size(); ++var11) {
                JSONObject var33 = (JSONObject)var4.get(var11);
                if (var33.optString("TITLE").equals(var16)) {
                    var12 = var33.optString("SERVER");
                    var5 = var33.optString("LEFT_SUB_TEXT");
                    if (var12.equals(var24) && var5.equals(var32)) {
                        String var34 = var33.optString("RIGHT_SUB_TEXT");
                        if (k.a(var34)) {
                            var4.remove(var11);
                            var4.add(var11, var10);
                            var31 = null;
                            return var31;
                        }

                        if (k.b(var34) && var34.equals(var36)) {
                            var31 = null;
                            return var31;
                        }
                    } else {
                        var12 = var33.optString("URL");
                        if (var5.equals(var32) && var12.equals(var15)) {
                            if (var9 && !k.a(var40)) {
                                String[] var37 = var40.split(" / ");
                                if (var37.length > 1) {
                                    var40 = var37[0].trim();
                                }

                                var36 = var33.optString("LEFT_TOP_TEXT");
                                if (!var36.contains(var40)) {
                                    var32 = var40;
                                    if (!k.a(var36)) {
                                        var32 = k.a("%s / %s", new Object[]{var40, var36});
                                    }

                                    var33.put("LEFT_TOP_TEXT", var32);
                                }
                            }

                            var31 = null;
                            return var31;
                        }
                    }
                }
            }
        }

        var31 = var10;
        return var31;
    }

    public static void a(Context var0) {
        b.o = k.a(com.dnt7.padguide.f.b.b(var0, "STAMINA_RECOVERY_JP", "3"), 3);
        b.p = k.a(com.dnt7.padguide.f.b.b(var0, "STAMINA_RECOVERY_US", "3"), 3);
        b.q = k.a(com.dnt7.padguide.f.b.b(var0, "STAMINA_RECOVERY_KR", "3"), 3);
    }

    public static void a(SQLiteDatabase var0, az var1) {
        var0.insertOrThrow("TBL_SCHEDULE", (String)null, var1.a());
    }

    public static boolean a(int var0, ArrayList<JSONObject> var1) {
        Iterator var3 = var1.iterator();

        boolean var2;
        while(true) {
            if (var3.hasNext()) {
                if (((JSONObject)var3.next()).optInt("DUNGON_SEQ") != var0) {
                    continue;
                }

                var2 = true;
                break;
            }

            var2 = false;
            break;
        }

        return var2;
    }

    public static int b(SQLiteDatabase var0, az var1) {
        int var2 = var1.a;
        return var0.update("TBL_SCHEDULE", var1.a(), "SCHEDULE_SEQ=?", new String[]{String.valueOf(var2)});
    }

    private static String b(Context var0, int var1, String var2) {
        StringBuffer var3 = new StringBuffer("SELECT \n");
        var3.append("A.SCHEDULE_SEQ, A.SERVER, A.EVENT_TYPE, A.TEAM_DATA, A.REG_DATE, A.URL \n");
        var3.append(", A.ALARM_ON, A.OPEN_WEEKDAY, A.OPEN_DATE, A.OPEN_HOUR, A.OPEN_MINUTE");
        var3.append(", A.OPEN_DATETIME, A.CLOSE_WEEKDAY, A.CLOSE_DATE, A.CLOSE_HOUR, A.CLOSE_MINUTE\t\n");
        var3.append(", A.CLOSE_DATETIME, A.SERVER_OPEN_DATE, A.URL, A.SERVER_OPEN_HOUR\t\n");
        var3.append(", B.DUNGEON_SEQ, B.NAME_JP, B.NAME_US, B.NAME_KR, B.DUNGEON_TYPE, B.ICON_SEQ, B.TDT_SEQ\t\n");
        var3.append(", C.EVENT_SEQ, C.EVENT_NAME_JP, C.EVENT_NAME_US, C.EVENT_NAME_KR\t\n");
        var3.append("FROM TBL_SCHEDULE A \n");
        if (b.a) {
            var3.append("INNER JOIN TBL_DUNGEON B ON A.DUNGEON_SEQ=B.DUNGEON_SEQ \n");
        } else {
            var3.append("INNER JOIN TBL_DUNGEON B ON A.DUNGEON_SEQ=B.DUNGEON_SEQ AND B.DUNGEON_SEQ NOT IN (295,311,312,313,315) \n");
        }

        if (var0.getSharedPreferences("setting", 0).getBoolean("isRemoveAds", false)) {
            var3.append("AND B.DUNGEON_SEQ NOT IN (578) ");
        }

        var3.append("AND A.SCHEDULE_SEQ NOT IN (168167, 167462, 175850) ");
        var3.append("LEFT JOIN TBL_EVENT_TYPE C ON A.EVENT_SEQ=C.EVENT_SEQ\t\n");
        var3.append("WHERE\t\n");
        int var4 = e.i(var0);
        JSONObject var5 = e.d(var0);
        JSONObject var6 = e.e(var0);
        int var7 = 0;

        String var8;
        for(var8 = ""; var7 < 3; ++var7) {
            boolean var9 = false;
            if (var7 == 0) {
                var9 = true;
            } else if (var5.optBoolean(String.valueOf(var7))) {
                var9 = true;
            }

            boolean var10 = var9;
            if (var4 > 0) {
                var10 = var9;
                if (var7 > 0) {
                    var10 = false;
                }
            }

            if (var10) {
                if (var7 > 0) {
                    var3.append("OR\t\n");
                }

                var3.append("(1=1\t\n");
                String var11 = e.a(var0, var7, "0,1,2,3,4");
                String var12 = e.a(var0, var7, "0,1,2", true);
                String var13 = e.b(var0, var7, "0,1,2");
                if (var4 > 0) {
                    var11 = e.c(var0, "team");
                    var12 = e.c(var0, "new_team");
                    var13 = e.c(var0, "starter");
                }

                var3.append(k.a("AND (A.EVENT_TYPE NOT IN (%d, %d, %d) OR (A.EVENT_TYPE IN (%d) AND A.TEAM_DATA IN (%s)) OR (A.EVENT_TYPE IN (%d) AND A.TEAM_DATA IN (%s)) OR (A.EVENT_TYPE=%d AND A.TEAM_DATA IN (%s))) \n", new Object[]{com.dnt7.padguide.db.a.z.a.d.a(), com.dnt7.padguide.db.a.z.a.c.a(), com.dnt7.padguide.db.a.z.a.e.a(), com.dnt7.padguide.db.a.z.a.d.a(), var11, com.dnt7.padguide.db.a.z.a.e.a(), var12, com.dnt7.padguide.db.a.z.a.c.a(), var13}));
                var12 = var6.optString(String.valueOf(var7));
                if (var4 > 0) {
                    var12 = e.j(var0);
                }

                var11 = var8;
                if (var8.length() == 0) {
                    var11 = var8;
                    if (var12.equals("JP")) {
                        var11 = "KR";
                    }
                }

                if (var11.length() == 0 && var12.equals("KR")) {
                    var8 = "JP";
                } else {
                    var8 = var11;
                }

                var3.append(k.a("AND A.SERVER='%s' \n", new Object[]{var12}));
                if (var1 == 1) {
                    var3.append(k.a("AND A.EVENT_TYPE IN (%d, %d, %d) \n", new Object[]{com.dnt7.padguide.db.a.z.a.d.a(), com.dnt7.padguide.db.a.z.a.c.a(), com.dnt7.padguide.db.a.z.a.e.a()}));
                } else if (var1 == 2) {
                    var3.append(k.a("AND A.EVENT_TYPE IN (%d) \n", new Object[]{com.dnt7.padguide.db.a.z.a.b.a()}));
                } else if (var1 == 3) {
                    var3.append(k.a("AND A.EVENT_TYPE IN (%d) \n", new Object[]{com.dnt7.padguide.db.a.z.a.f.a()}));
                }

                if (var2 != null) {
                    Date var19;
                    try {
                        var19 = d.b(var2, "yyyy-MM-dd");
                    } catch (ParseException var16) {
                        g.b("PadGuide", var16);
                        var19 = null;
                    }

                    Calendar var14 = Calendar.getInstance();
                    var14.setFirstDayOfWeek(2);
                    var14.setTime(var19);
                    int var17 = var14.get(11);
                    int var18 = var14.get(12);
                    var13 = k.a("%s %02d:%02d", new Object[]{d.a("yyyy-MM-dd", var14.getTime()), var17, var18});
                    var14.setTime((Date)var19.clone());
                    if (var12.equalsIgnoreCase("US") && d.b(var19)) {
                        var14.add(11, 1);
                        var14.getTime();
                    }

                    var14.get(11);
                    var14.get(12);
                    var17 = var14.get(7) - 1;
                    if (var17 < 0) {
                        ;
                    }

                    var14.setTime(var19);
                    var14.add(5, 1);
                    var14.add(12, -1);
                    Date var15 = var14.getTime();
                    var18 = var14.get(11);
                    var17 = var14.get(12);
                    var11 = k.a("%s %02d:%02d", new Object[]{d.a("yyyy-MM-dd", var14.getTime()), var18, var17});
                    var14.setTime((Date)var15.clone());
                    if (var12.equalsIgnoreCase("US") && d.b(var15)) {
                        var14.add(11, 1);
                        var14.getTime();
                    }

                    var14.get(11);
                    var14.get(12);
                    var17 = var14.get(7) - 1;
                    if (var17 < 0) {
                        ;
                    }

                    var3.append("AND (\t\n");
                    var3.append(k.a("       (A.CLOSE_DATETIME>='%s' AND A.OPEN_DATETIME<='%s')\t\n", new Object[]{var13, var11}));
                    var3.append(k.a("       OR (A.OPEN_DATETIME<='%s' AND A.CLOSE_DATETIME>='%s')\t\n", new Object[]{var11, var13}));
                    var3.append(")\t\n");
                }

                var3.append(")\t\n");
            }
        }

        if (k.d(var8)) {
            var3.append(k.a("AND (A.SERVER<>'%s' OR A.EVENT_TYPE<>'%d')\t\n", new Object[]{var8, com.dnt7.padguide.db.a.z.a.a.a()}));
        }

        var3.append("ORDER BY A.EVENT_TYPE DESC, ABS(B.DUNGEON_TYPE - 0.6) DESC, A.OPEN_DATETIME ASC, A.SERVER DESC, B.ORDER_IDX DESC, A.DUNGEON_SEQ DESC, A.SCHEDULE_SEQ DESC ");
        return var3.toString();
    }

    public static ArrayList<JSONObject> b(Context param0, String param1, String param2, String param3, String param4, String param5) {
        // $FF: Couldn't be decompiled
    }
}
