package com.kailas.thread_and_notification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonWorkerThread, buttonHandlerRunnable, buttonAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonWorkerThread = findViewById(R.id.buttonWorkerThread);
        buttonWorkerThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WorkerTreadActivity.class);
                startActivity(intent);
            }
        });

        buttonHandlerRunnable = findViewById(R.id.buttonHandlerRunnable);
        buttonHandlerRunnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThreadRunnableHandlerActivity.class);
                startActivity(intent);
            }
        });

        buttonAsyncTask = findViewById(R.id.buttonAsyncTask);
        buttonAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AsyncTaskActivity.class);
                startActivity(intent);
            }
        });
    }
}