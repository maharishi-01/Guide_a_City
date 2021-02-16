package com.stupedia.guide_a_city.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.stupedia.guide_a_city.utils.NetworkStatus;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        NetworkStatus.isNetworkAvailable(context);
    }
}