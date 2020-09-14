package javatest.baidu.first;

import java.util.Scanner;

/**
 * @author littlecorgi
 * @date 2020/9/14
 */
public class Object1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        char temp = str.charAt(0);
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (temp != str.charAt(i)) {
                temp = str.charAt(i);
                sb.append(temp);
            }
        }
        System.out.println(sb.toString());
    }
}
