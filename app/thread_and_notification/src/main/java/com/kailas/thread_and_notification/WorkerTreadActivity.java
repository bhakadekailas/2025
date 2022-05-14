package com.kailas.thread_and_notification;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class WorkerTreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_tread);



        new Thread() {
            @Override
            public void run() {
                try {
                   Thread.sleep(5000);
                 runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(WorkerTreadActivity.this, "This is UI thread", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (Exception e) {
                    Log.e("WorkerTreadActivity", "Exception in thread");
                }
            }
        }.start();
    }
}