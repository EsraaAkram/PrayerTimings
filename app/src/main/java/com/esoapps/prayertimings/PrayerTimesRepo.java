package com.esoapps.prayertimings;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PrayerTimesRepo {

    private PrayerTimesDBResponse prayerTimesDBResponse;
    private final MutableLiveData<PrayerTimesDBResponse> mutableLiveData = new MutableLiveData<>();

    public PrayerTimesRepo() {
    }

    public MutableLiveData<PrayerTimesDBResponse> prayerTimes(final Context context) {
        final RESTapis api = RetrofitClient.getRESTapis(context);
        Call<PrayerTimesDBResponse> call = api.prayerTimes();
        call.enqueue(new Callback<PrayerTimesDBResponse>() {
            @Override
            public void onResponse(@NonNull Call<PrayerTimesDBResponse> call, @NonNull Response<PrayerTimesDBResponse> response) {
                try {
                    PrayerTimesDBResponse myResponse = response.body();
                    if (myResponse != null) {
                        prayerTimesDBResponse = myResponse;
                        mutableLiveData.setValue(prayerTimesDBResponse);
                    }
                } catch (Exception ignored) {
                }

            }

            @Override
            public void onFailure(@NonNull Call<PrayerTimesDBResponse> call, @NonNull Throwable t) {
            }
        });
        return mutableLiveData;
    }
}
