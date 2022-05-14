package com.kailas.services.bound;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.kailas.services.R;

import java.util.Random;

public class MyBoundService extends Service {
    MediaPlayer myPlayer;
    private final String TAG = MyBoundService.class.getSimpleName();
    private final Binder myBinder = new MyBinder();

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate: ");
        super.onCreate();
        myPlayer = MediaPlayer.create(this, R.raw.bahuballi);
//        myPlayer.setLooping(true);
    }

    public class MyBinder extends Binder {
        public MyBoundService getService() {
            return MyBoundService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: ");
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
        myPlayer.start();
        return myBinder;
    }

    public String getRandomNo() {
        Random rand = new Random();
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;
        return String.valueOf(randomNum);
    }
}