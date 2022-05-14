package com.kailas.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kailas.services.background.MyBackgroundServiceActivity;
import com.kailas.services.bound.MyBoundServiceActivity;
import com.kailas.services.foreground.MyForegroundServiceActivity;

public class MainActivity extends AppCompatActivity {
    Button buttonForegroundService, buttonBackgroundService, buttonBoundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonForegroundService = findViewById(R.id.buttonForegroundService);
        buttonBackgroundService = findViewById(R.id.buttonBackgroundService);
        buttonBoundService = findViewById(R.id.buttonBoundService);


        buttonForegroundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyForegroundServiceActivity.class);
                startActivity(intent);
            }
        });

        buttonBackgroundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyBackgroundServiceActivity.class);
                startActivity(intent);
            }
        });

        buttonBoundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyBoundServiceActivity.class);
                startActivity(intent);
            }
        });
    }
}