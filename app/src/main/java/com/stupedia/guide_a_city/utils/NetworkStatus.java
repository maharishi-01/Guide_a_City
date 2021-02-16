package com.stupedia.guide_a_city.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkStatus {

    public static boolean isNetworkAvailable(Context context) {
        int retriesNum = 5;// a number that I put as 5 for retries to make consideration for bad connections
        if(context!=null)
            while (retriesNum > 0) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo network = connectivityManager.getActiveNetworkInfo();
                    boolean isConnected = network != null &&
                            network.isConnectedOrConnecting();
                    if (isConnected) {
                        return true;
                    } else {

                        network = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                        isConnected = network != null && network.isConnectedOrConnecting();
                        if (isConnected) {
                            return true;
                        } else {
                            network = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                            isConnected = network != null && network.isConnectedOrConnecting();
                            if (isConnected) {
                                return true;
                            } else {
                                retriesNum--;

                            }
                        }
                    }
                }catch (Exception ex){
                    return true;
                }
            }
        return false;
    }
}
