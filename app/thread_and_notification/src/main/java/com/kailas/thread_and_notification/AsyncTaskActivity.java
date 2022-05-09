package com.kailas.thread_and_notification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncTaskActivity extends AppCompatActivity {
    Button buttonDownloadFile;
    TextView textViewProgress;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        textViewProgress = findViewById(R.id.textViewProgress);
        progressBar = findViewById(R.id.progressBar);
        buttonDownloadFile = findViewById(R.id.buttonDownloadFile);
        buttonDownloadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadFileTask downloadFileTask = new DownloadFileTask();
                downloadFileTask.execute("This is input string for async task");
            }
        });
    }

    class DownloadFileTask extends AsyncTask<String, Integer, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.e("Kailas", "onPreExecute: " + Thread.currentThread().getName());
        }

        @Override
        protected String doInBackground(String... strings) {
            Log.e("Kailas", "doInBackground: " + Thread.currentThread().getName());
            Log.e("Kailas", "doInBackground: " + strings[0]);
            for (int i = 1; i <= 10; i++) {
                Log.e("Kailas", "For Loop Start: " + i);
                try {
                    publishProgress((i));
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Download Successfully!!";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textViewProgress.setText(String.valueOf(values[0]));
            progressBar.setProgress(values[0]);
            Log.e("Kailas", "onProgressUpdate: " + Thread.currentThread().getName());
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.e("Kailas", "onPostExecute: " + Thread.currentThread().getName());
            Toast.makeText(AsyncTaskActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }
}

