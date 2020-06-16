package com.littlecorgi.suanfa.object1;

public class test5 {
    public static void main(String[] args) {
        float num = 0;
        int a = 1, b = 2;
        for (int i = 0; i < 20; i++) {
            num += (float) b / a;
            int temp = b;
            b = a + b;
            a = temp;
        }
        System.out.println(num);
    }
}
