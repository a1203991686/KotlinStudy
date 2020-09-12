package javatest.neteasy.firsy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class Object3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int[] temp = new int[64];
        Arrays.fill(temp, -1);
        // 用cur来保存状态,第i位的0或者1代表了第i个字母出现次数的寄偶性
        int cur = 0;
        int ans = 0;
        // 前缀和，代表前面这么多数，
        temp[0] = 0;
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                // 每当有值，对应的将cur对应位置上进行相与，如果存在的次数是偶数，那么就经历偶数次相异或
                // 异或：值相同时为0，不同时为1，那么如果有偶数次，那么经历偶数次异或之后，最后的结果肯定为1
                case 'a':
                    cur ^= 1;
                    break;
                case 'b':
                    cur ^= 2;
                    break;
                case 'c':
                    cur ^= 4;
                    break;
                case 'x':
                    cur ^= 8;
                    break;
                case 'y':
                    cur ^= 16;
                    break;
                case 'z':
                    cur ^= 32;
                    break;
                default:
                    break;
            }
            // 对应的，如果
            if (temp[cur] >= 0) {
                ans = Math.max(ans, i + 1 - temp[cur]);
            } else {
                temp[cur] = i + 1;
            }
        }
        System.out.println(ans);
    }
}
