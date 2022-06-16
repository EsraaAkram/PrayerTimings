package com.esoapps.prayertimings;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.legacy.content.WakefulBroadcastReceiver;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MyPrayerTimesAlarmReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        PrayerTimesService myService = new PrayerTimesService();
        myService.startAzan(context);
    }

    public void setPrayerCallAlarm(Context context, List<PrayerTimesModelClass> data) {
        try {
            AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            ArrayList<PendingIntent> intentArray = new ArrayList<>();
            int i;
            for (i = 0; i < data.size(); ++i) {
                Intent intent = new Intent(context, MyPrayerTimesAlarmReceiver.class);
                PendingIntent alarmIntent = PendingIntent.getBroadcast(context, i, intent, 0);
                Calendar calendar = Calendar.getInstance();
                Calendar cal_now = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(data.get(i).getHour()));
                calendar.set(Calendar.MINUTE, Integer.parseInt(data.get(i).getMin()));
                if (calendar.before(cal_now)) {
                    calendar.add(Calendar.DATE, 1);
                }

                Log.d("TAG", "startPrayerTimes: " + calendar.getTime().toString());

                alarmMgr.set(AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis(),
                        alarmIntent);

                ComponentName receiver = new ComponentName(context, SampleBootReceiver.class);
                PackageManager pm = context.getPackageManager();
                pm.setComponentEnabledSetting(receiver,
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                        PackageManager.DONT_KILL_APP);


                intentArray.add(alarmIntent);
            }

        } catch (Exception ignored) {

        }
    }


}
