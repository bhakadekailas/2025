package com.kailas.broadcastreceiverdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyDynamicBroadcastReceiver myDynamicBroadcastReceiver;
    Button buttonLocalBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLocalBroadcast = findViewById(R.id.buttonLocalBroadcast);
        buttonLocalBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        myDynamicBroadcastReceiver = new MyDynamicBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        registerReceiver(myDynamicBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        if (myDynamicBroadcastReceiver != null) {
            unregisterReceiver(myDynamicBroadcastReceiver);
            myDynamicBroadcastReceiver = null;
        }
        super.onDestroy();
    }
}