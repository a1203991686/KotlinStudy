package com.littlecorgi.suanfa.object2;

public class BeijingTime {
    private int hour;
    private int minute;
    private int second;

    public BeijingTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public BeijingTime() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    @Override
    public String toString() {
        return "北京时间： " + hour +
                ":" + minute +
                ":" + second;
    }

    public static void main(String[] args) {
        BeijingTime bj = new BeijingTime(16, 07, 00);
        System.out.println(bj.toString());
    }
}
