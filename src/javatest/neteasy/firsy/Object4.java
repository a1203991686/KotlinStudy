package javatest.neteasy.firsy;

import java.util.Scanner;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class Object4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] aTemp = s.split(" ");
        int[] nums = new int[aTemp.length];
        for (int i = 0; i < aTemp.length; i++) {
            nums[i] = Integer.parseInt(aTemp[i]);
        }
        int[] dp = new int[]{0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i] % 7;
            int a = dp[(7 + 0 - k) % 7];
            int b = dp[(7 + 1 - k) % 7];
            int c = dp[(7 + 2 - k) % 7];
            int d = dp[(7 + 3 - k) % 7];
            int e = dp[(7 + 4 - k) % 7];
            int f = dp[(7 + 5 - k) % 7];
            int g = dp[(7 + 6 - k) % 7];
            if (a != 0 || k == 0) {
                dp[0] = Math.max(dp[0], a + nums[i]);
            }
            if (b != 0 || k == 1) {
                dp[1] = Math.max(dp[1], b + nums[i]);
            }
            if (c != 0 || k == 2) {
                dp[2] = Math.max(dp[2], c + nums[i]);
            }
            if (d != 0 || k == 3) {
                dp[3] = Math.max(dp[3], d + nums[i]);
            }
            if (e != 0 || k == 4) {
                dp[4] = Math.max(dp[4], e + nums[i]);
            }
            if (f != 0 || k == 5) {
                dp[5] = Math.max(dp[5], f + nums[i]);
            }
            if (g != 0 || k == 6) {
                dp[6] = Math.max(dp[6], g + nums[i]);
            }
        }
        System.out.println(dp[0]);
    }
}
