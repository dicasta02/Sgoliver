package com.softpolaris.sgoliver.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public class Utilities {
    public static boolean verifyConnection(Context ctx) {
        boolean isConnected = false;
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null) {
            if (activeNetwork.getState() == NetworkInfo.State.CONNECTED) {
                isConnected = true;
            }
        }

        return isConnected;
    }
}