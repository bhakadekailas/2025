package com.kailas.services.background;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kailas.services.R;

public class MyBackgroundServiceActivity extends AppCompatActivity {
    Button buttonStartBackgroundService, buttonStopBackgroundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_background_service);
        buttonStartBackgroundService = findViewById(R.id.buttonStartBackgroundService);
        buttonStartBackgroundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyBackgroundServiceActivity.this, MyBackgroundService.class);
                startService(intent);
            }
        });

        buttonStopBackgroundService = findViewById(R.id.buttonStopBackgroundService);
        buttonStopBackgroundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyBackgroundServiceActivity.this, MyBackgroundService.class);
                stopService(intent);
            }
        });
    }
}