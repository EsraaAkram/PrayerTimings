package com.esoapps.prayertimings;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RESTapis {

    @Headers({"Accept: application/json"})
    @GET("azan")
    Call<PrayerTimesDBResponse> prayerTimes();

}
