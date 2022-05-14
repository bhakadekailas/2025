package com.kailas.services.foreground;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.kailas.services.R;

public class MyForegroundService extends Service {
    MediaPlayer myPlayer;
    public final String CHANNEL_ID = "MusicPlayerServiceChannelId";
    public final String CHANNEL_NAME = "MusicPlayerServiceChannelId";
    private final String TAG = MyForegroundService.class.getSimpleName();

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate: ");
        super.onCreate();
        myPlayer = MediaPlayer.create(this, R.raw.srivalli);
//        myPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: ");
        myPlayer.start();
        Intent notificationIntent = new Intent(this, MyForegroundServiceActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        //Create Notification Channel
        NotificationChannel serviceChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(serviceChannel);

        //Create Notification
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Music Player")
                .setContentText("You are playing Srivalli....")
                .setSmallIcon(R.drawable.pushpa)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification);
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