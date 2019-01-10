package com.dnt7.padguide.service;

import lanchon.dexpatcher.annotation.DexEdit;
import lanchon.dexpatcher.annotation.DexReplace;

@DexEdit(contentOnly = true)
public class ExpansionDownloaderService  {
    @DexReplace
    public String a() {
        // DadGuide value
        return "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwqYxb8NKduSWGFiEbHnxUcpRNmXwhE7LDsRcLf8jF+X+hM0Wp41+BzzL3ZrbqqgvdICW/WcJMEl6GdU5XdxVfg4V52iXw3Y1EIJTjjMm7FMVXbCZB7nqp07fWxkTaqWy9rpx9RCXEFeio2R0p9uRGpPetCS3kKK/pb64tbDjunpx9JZ2QtALtu8YUzyO2UatZzaZvbXay/1NwX1a4Q+qgVH7gd6wuL1z1yTWMfagsr/qnVgqjYtOPuxrJmNoO/B0BUHnyPYLbubhxgndDsIlA/lmX0eMThdDKv0eOBkNR7Af5TzYZzIE1Qf85dvFaA8UN2GbJ9cGCafRIZDzfHx2UwIDAQAB";
    }
}
