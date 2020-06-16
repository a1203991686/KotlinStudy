package com.littlecorgi.suanfa.object1;

import java.util.ArrayList;

public class test2 {
    public static void main(String[] args) {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.add(2);
        int flag = 0;
        for (int i = 2; i < 100; i++) {
            flag = 0;
            for (int j = 0; j < sums.size(); j++) {
                if (i % sums.get(j) == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.print(i + " ");
                sums.add(i);
            }
        }
    }
}
