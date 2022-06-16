package com.esoapps.prayertimings;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class PrayerTimesMainActivity extends AppCompatActivity {

    private Button btnStartPrayerTimes;
    private ProgressBar mProgressBar;
    private PrayerTimesMainViewModel prayerTimesMainViewModel;
    MyPrayerTimesAlarmReceiver prayerCallAlarm = new MyPrayerTimesAlarmReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prayerTimesMainViewModel = new ViewModelProvider(this).get(PrayerTimesMainViewModel.class);

        mProgressBar = findViewById(R.id.mProgressBar);

        btnStartPrayerTimes = findViewById(R.id.btn_startDownload);

        btnStartPrayerTimes.setOnClickListener(view -> {

            mProgressBar.setVisibility(View.VISIBLE);

            prayerTimes();

        });

    }

    private void prayerTimes() {
        prayerTimesMainViewModel.prayerTimes(PrayerTimesMainActivity.this).observeForever(prayerTimesDBResponse -> {
            if (prayerTimesDBResponse.getData().size() != 0) {

                prayerCallAlarm.setPrayerCallAlarm(PrayerTimesMainActivity.this, prayerTimesDBResponse.getData());

                mProgressBar.setVisibility(View.GONE);

                btnStartPrayerTimes.setText(R.string.prayer_times_are_set);
                btnStartPrayerTimes.setEnabled(false);
            }
        });
    }

}