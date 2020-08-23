package javatest.tencent;

import java.util.Scanner;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class Object5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int length = in.nextInt();
            int m = in.nextInt();
            if (m == 1) {
                System.out.println("YES");
                break;
            }
            String str = in.next();
            // System.out.println(length + " " + m + " " + str);
            // 判断整个字符串中是否有回文，如果有就为true，没有就为false
            boolean flag = false;
            for (int j = 0; j < length - m + 1; j++) {
                // 代表当前是否存在回文
                boolean tempFlag = false;
                String s = str.substring(j,
                        j + m);
                int left = 0;
                int right = s.length() - 1;
                System.out.println(s);
                while (left <= right) {
                    if (s.charAt(left) == s.charAt(right)) {
                    } else {
                        // 只要有一个不同，tempFlag变为true
                        tempFlag = true;
                        break;
                    }
                    System.out.println(s.charAt(left) + " " + s.charAt(right));
                    left++;
                    right--;
                }
                if (!tempFlag) {
                    System.out.println("YES");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("NO");
            }
        }
    }
}
