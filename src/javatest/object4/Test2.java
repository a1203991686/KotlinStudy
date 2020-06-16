package com.littlecorgi.suanfa.object4;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int a[] = {1, 7, 9, 11, 13, 15, 17, 19};
        int b[] = {2, 4, 6, 8, 10};
        int[] c = new int[a.length + b.length];
        int i = 0;
        for (i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int j = 0; j < b.length; j++, i++) {
            c[i] = b[j];
        }
        Arrays.sort(c);
        for (int j = 0; j < c.length; j++) {
            System.out.printf("%d ", c[j]);
        }
    }
}
