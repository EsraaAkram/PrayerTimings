package com.esoapps.prayertimings;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class PrayerTimesMainViewModel extends AndroidViewModel {

    private final PrayerTimesRepo prayerTimesRepo;

    public PrayerTimesMainViewModel(@NonNull Application application) {
        super(application);
        prayerTimesRepo = new PrayerTimesRepo();
    }

    public MutableLiveData<PrayerTimesDBResponse> prayerTimes(final Context context) {
        return prayerTimesRepo.prayerTimes(context);
    }

}