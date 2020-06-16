package javatest;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 面试题46. 把数字翻译成字符串
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
class JavaMain {
    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            new Timer("timer - " + i).schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " run ");
                }
            }, 2000, 3000);
        }
    }

    public int translateNum(int num) {
        String str = num + "";

        if (str.length() == 0) {
            return 0;
        } else if (str.length() == 1) {
            return 1;
        }

        int[] dps = new int[str.length()];
        dps[str.length() - 1] = 1;
        char a = str.charAt(str.length() - 2);
        char b = str.charAt(str.length() - 1);
        if (a > '2' || a == '0') {
            dps[str.length() - 2] = 1;
        } else if (a == '2' && b >= '6') {
            dps[str.length() - 2] = 1;
        } else if (a == '2' && b < '6') {
            dps[str.length() - 2] = 2;
        } else if (a == '1') {
            dps[str.length() - 2] = 2;
        }
        for (int i = str.length() - 3; i >= 0; i--) {
            if (str.charAt(i) > '2' || str.charAt(i) == '0') {
                dps[i] = dps[i + 1];
            } else if (str.charAt(i) == '2' && str.charAt(i + 1) >= '6') {
                dps[i] = dps[i + 1];
            } else if (str.charAt(i) == '2' && str.charAt(i + 1) < '6') {
                dps[i] = dps[i + 1] + dps[i + 2];
            } else if (str.charAt(i) == '1') {
                dps[i] = dps[i + 1] + dps[i + 2];
            }
        }
        return dps[0];
    }
}
