package com.stupedia.guide_a_city.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.stupedia.guide_a_city.utils.NetworkStatus;

public class NetworkChangeReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        System.out.println("okkkkk---");
        NetworkStatus.isNetworkAvailable(context);
        System.out.println("instatus-->" + NetworkStatus.isNetworkAvailable(context));

    }
}