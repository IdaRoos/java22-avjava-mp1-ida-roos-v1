package org.example.model;

import java.time.LocalTime;

public class Time{

   private LocalTime localTime = LocalTime.now();

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
}
