package com.kailas.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyStaticBroadcastReceiver extends BroadcastReceiver {
    private final String TAG = MyStaticBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: ");
        Toast.makeText(context, "Static Receiver", Toast.LENGTH_SHORT).show();
    }
}
