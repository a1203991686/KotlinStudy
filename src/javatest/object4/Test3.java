package com.littlecorgi.suanfa.object4;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int wordCount = 0;
        int numCount = 0;
        int spaceCount = 0;
        int charCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                numCount++;
            } else if (Character.isSpaceChar(str.charAt(i))) {
                spaceCount++;
            } else if (Character.isLetter(str.charAt(i))) {
                wordCount++;
            } else {
                charCount++;
            }
        }
        System.out.println("字母个数:" + wordCount);
        System.out.println("空格个数:" + spaceCount);
        System.out.println("数字个数:" + numCount);
        System.out.println("其它字符个数:" + charCount);
    }
}
