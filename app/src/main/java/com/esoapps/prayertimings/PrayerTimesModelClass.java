
package com.esoapps.prayertimings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrayerTimesModelClass {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("hour")
    @Expose
    private String hour;
    @SerializedName("min")
    @Expose
    private String min;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

}
