package com.kailas.services.background;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.kailas.services.R;

public class MyBackgroundService extends Service {
    MediaPlayer myPlayer;
    private final String TAG = MyBackgroundService.class.getSimpleName();

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate: ");
        super.onCreate();
        myPlayer = MediaPlayer.create(this, R.raw.bahuballi);
//        myPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: ");
        myPlayer.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy: ");
        myPlayer.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: ");
        return null;
    }
}