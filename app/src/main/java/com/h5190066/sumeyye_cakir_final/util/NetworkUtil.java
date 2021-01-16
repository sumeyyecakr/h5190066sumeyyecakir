package com.h5190066.sumeyye_cakir_final.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {
    public static boolean internetiKontrolEt(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return true;
        }
        else{
            return false;
        }

    }
}
