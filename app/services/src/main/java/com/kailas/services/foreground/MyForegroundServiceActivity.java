package com.kailas.services.foreground;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kailas.services.R;

public class MyForegroundServiceActivity extends AppCompatActivity {
    Button buttonStartService, buttonStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_foreground_service);
        buttonStartService = findViewById(R.id.buttonStartService);
        buttonStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyForegroundServiceActivity.this, MyForegroundService.class);
                startForegroundService(intent);
            }
        });

        buttonStopService = findViewById(R.id.buttonStopService);
        buttonStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyForegroundServiceActivity.this, MyForegroundService.class);
                stopService(intent);
            }
        });
    }
}