package javatest.neteasy.firsy;

import java.util.Scanner;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class Object2 {

    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        int n = inputStr.length();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = inputStr.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) {
                    check(i, j, a);
                }
            }
        }
        System.out.println(count);
    }

    public static void check(int m, int n, int[] a) {
        if (m - n == 1 || m == n) {
            count++;
        } else {
            if (a[m] == a[n]) {
                check(m + 1, n - 1, a);
            } else {
                return;
            }
        }
    }
}
