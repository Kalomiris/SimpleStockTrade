package com.kalomiris.dateUtils;

import java.util.Calendar;
import java.util.Date;

public class ComputeDate {

    public static Date computeSpecificDate(int time){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE,time);
        return cal.getTime();
    }
}
