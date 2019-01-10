package com.dnt7.padguide.db;

import android.database.sqlite.SQLiteDatabase;

import lanchon.dexpatcher.annotation.DexEdit;
import lanchon.dexpatcher.annotation.DexReplace;

// The weird location, class name, and targeting are due to the fact that the actual class got
// obfuscated in an annoying way and we can't replace it properly.
@DexEdit(target="com.dnt7.padguide.db.a.ba", contentOnly = true)
public class Subpackage_a_Class_ba {

    @DexReplace
    public static int a(SQLiteDatabase var0, String var1, String var2) {
        // Disables purging of events which are too far in the future.
        // This was deleting events that are being published earlier than PadGuide expects.

        return 0;
    }
}
