package com.kailas.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyDynamicBroadcastReceiver extends BroadcastReceiver {

    private final String TAG = MyDynamicBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: ");
        Toast.makeText(context, "Dynamic Receiver", Toast.LENGTH_SHORT).show();
    }
}