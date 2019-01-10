//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dnt7.padguide.service;

import com.dnt7.padguide.receiver.ExpansionAlarmReceiver;
import com.google.android.vending.expansion.downloader.a.g;

public class ExpansionDownloaderService extends g {
    private static final byte[] g = new byte[]{0, 1, 2, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    public ExpansionDownloaderService() {
    }

    public String a() {
        return "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoP0oLmGlmr6jALM1zJSevtPWryVq3HP91mLomk5hhZPIA04xaX62W+dqOqmiqUTj8AYrUDMBswayKdyZu+pdTN3XtFzYDSzBrjOPsmc4JaPFaml5IAAvr0vfJn0n4Up40D0jOJ/w7+sNW/ZTMtfM2PAtaUWyj9HvNXdX5c1bQhmVh5c3Cn9D44YGlHsYgT1aH9yU5nSJJsz6D8ums4l3m0l/kU/4V693qa6MYRN7PvHJ7sBcnkw/kvT+q5VjfOMu/gmdMVs8D7A09SYcUB+A29vL0WlzAo+b97DN6s9gn+mDVT5dbENrnBfWoKqX3l5iSg/pqVgFNnJdIqM2pR1+8QIDAQAB";
    }

    public byte[] b() {
        return g;
    }

    public String c() {
        return ExpansionAlarmReceiver.class.getName();
    }
}
