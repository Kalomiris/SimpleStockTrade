package com.kalomiris.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date computeSpecificDate(int time, int timePeriod){
        Calendar cal = Calendar.getInstance();
        cal.add(timePeriod,time);
        return cal.getTime();
    }
}
