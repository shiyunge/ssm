package com.fable.dataReceiver.tets;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class etst {




    public static void main(String[]args){

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(calendar.getTime())+"-----------------------------------------------------");
    }


}
