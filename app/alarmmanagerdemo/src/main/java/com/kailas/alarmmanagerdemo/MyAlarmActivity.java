package com.kailas.alarmmanagerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyAlarmActivity extends AppCompatActivity {
    Button buttonStopAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_alarm);
        buttonStopAlarm = findViewById(R.id.buttonStopAlarm);
        buttonStopAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyBroadcastReceiver.mediaPlayer.stop();
                finish();
            }
        });
    }
}