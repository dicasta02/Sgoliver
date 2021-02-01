package com.softpolaris.sgoliver.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public class NetworkUtils {
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm == null) {
            new LogManager(NetworkUtils.class).printDebug("Validation ConnectivityManager:", cm);
            return false;
        }

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork == null) {
            new LogManager(NetworkUtils.class).printDebug("Validation activeNetwork:", activeNetwork);
            return false;
        }

        boolean isConnected = activeNetwork.isConnectedOrConnecting() && activeNetwork.isAvailable() && activeNetwork.isConnected();

        new LogManager(NetworkUtils.class).printDebug("Validation activeNetwork.isConnectedOrConnecting():",
                activeNetwork.isConnectedOrConnecting());
        new LogManager(NetworkUtils.class).printDebug("Validation activeNetwork.isAvailable():", activeNetwork.isAvailable());
        new LogManager(NetworkUtils.class).printDebug("Validation activeNetwork.isConnected():", activeNetwork.isConnected());
        new LogManager(NetworkUtils.class).printDebug("Validation internet -> is internet Connection:", isConnected);

        return isConnected;
    }
}
