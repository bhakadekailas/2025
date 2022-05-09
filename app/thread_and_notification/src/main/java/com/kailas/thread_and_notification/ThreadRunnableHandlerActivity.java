package com.kailas.thread_and_notification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ThreadRunnableHandlerActivity extends AppCompatActivity {
    Button buttonStart;
    Context context;
    ProgressBar progressBar;
    TextView textViewProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = ThreadRunnableHandlerActivity.this;
        setContentView(R.layout.activity_thread_runnable_handler);
        progressBar = findViewById(R.id.progressBar);
        textViewProgress = findViewById(R.id.textViewProgress);
        buttonStart = findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doWork();
            }
        });
    }

    private void doWork() {
        Handler handler = new Handler();
        // Runnable running on main thread
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10; i++) {
//                    final int currentProgressCount = i;
                    try {
                        Thread.sleep(500);
                        Log.e("Kailas", "For loop Running = " + Thread.currentThread().getName());
                        int myInt = i;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(myInt);
                                Log.e("Kailas", "With the help of Handler = " + Thread.currentThread().getName());
//                                Toast.makeText(context, "Running = "+ myInt
//                                        , Toast.LENGTH_SHORT).show();
                                textViewProgress.setText(String.valueOf(myInt));
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Log.e("Kailas", "Out of fromFor loop = " + Thread.currentThread().getName());
            }
        };
//        runnable.run();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}