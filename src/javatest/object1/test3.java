package com.littlecorgi.suanfa.object1;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();

        StringBuilder str = new StringBuilder("");
        str.append(a);
        System.out.println(str.reverse());
    }
}
