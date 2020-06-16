package com.littlecorgi.suanfa.object1;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        int max = 0;
        int min = 0;
        int i = 0;
        Scanner in = new Scanner(System.in);
        int weight;
        while ((weight = in.nextInt()) > 0) {
            if (i == 0) {
                max = weight;
                min = weight;
                i++;
            } else {
                if (max < weight)
                    max = weight;
                if (min > weight)
                    min = weight;
            }
        }
        System.out.println("最大:" + max + ", 最小:" + min);
    }
}
