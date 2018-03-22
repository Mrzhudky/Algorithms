package com.company;

public class TimeAsXAxis {
    private int year;
    private int month;
    private  int day;
//    private int hour;
//    private int minute;
//    private int second;

    public void Set(int y,int mon,int d){
        this.year = y;
        this.month = mon;
        this.day = d;
//        this.hour = h;
//        this.minute = min;
//        this.second = sec;
    }

    public double TranseToXAxis(TimeAsXAxis timeX){
        double xValue = 0;
        xValue += (this.year - timeX.year)*365;
        xValue += (this.month - timeX.month)*30;
        xValue += this.day - timeX.day;
//        xValue += (this.hour - timeX.hour)/24;
//        xValue += (this.minute - timeX.minute)/24/60;
//        xValue += (this.second - timeX.second)/24/60/60;
        return xValue;
    }
}
