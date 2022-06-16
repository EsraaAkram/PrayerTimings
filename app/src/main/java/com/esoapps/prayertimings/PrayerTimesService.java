package com.esoapps.prayertimings;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;


public class PrayerTimesService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY_COMPATIBILITY;
    }

    public void startAzan(Context context) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.azan1);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(mediaPlayer1 -> mediaPlayer1.stop());

    }

}
