package com.littlecorgi.suanfa.object2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static String isWhatDay(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String str = dateFormat.format(calendar.getTime());
        String[] dates = str.split("-");
        int count = day - Integer.parseInt(dates[2]);
        switch (count) {
            case 0:
                return "今天";
            case 1:
                return "明天";
            case -1:
                return "昨天";
            case -2:
                return "前天";
            case 2:
                return "后天";
        }
        return "日期不是前天、昨天、明天或后天";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请一次输入年月日：");
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        System.out.println(Date.isWhatDay(year, month, day));
    }
}
