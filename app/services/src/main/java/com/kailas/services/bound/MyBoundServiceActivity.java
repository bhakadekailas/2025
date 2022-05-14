package com.kailas.services.bound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kailas.services.R;

public class MyBoundServiceActivity extends AppCompatActivity {
    private final String TAG = MyBoundServiceActivity.class.getSimpleName();
    Button buttonBoundService, buttonUnboundService, buttonPrintTimestamp;
    TextView textViewRandomNumber;
    private boolean isBound = false;
    MyBoundService myBoundService;
    private final ServiceConnection myServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e(TAG, "onServiceConnected: " + iBinder);
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) iBinder;
            myBoundService = myBinder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e(TAG, "onServiceDisconnected: ");
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bound_service);
        textViewRandomNumber = findViewById(R.id.textViewRandomNumber);
        buttonBoundService = findViewById(R.id.buttonBoundService);
        buttonBoundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyBoundServiceActivity.this, MyBoundService.class);
                bindService(intent, myServiceConnection, Context.BIND_AUTO_CREATE);
            }
        });
        buttonUnboundService = findViewById(R.id.buttonUnboundService);
        buttonUnboundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBound) {
                    unbindService(myServiceConnection);
                    isBound = false;
                }
            }
        });

        buttonPrintTimestamp = findViewById(R.id.buttonPrintTimestamp);
        buttonPrintTimestamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBound) {
                    textViewRandomNumber.setText(myBoundService.getRandomNo());
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "onDestroy: ");
        super.onDestroy();
        if (isBound) {
            unbindService(myServiceConnection);
            isBound = false;
        }
    }
}