package javatest.tencent;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class Object4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int result = 1;
            // 读取一组数据
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                int temp = in.nextInt();
                arr[j] = temp;
            }

            int[] dpPlus = new int[n];
            int[] dpDes = new int[n];
            dpPlus[0] = 1;
            dpDes[0] = 1;
            for (int j = 1; j < n; j++) {
                dpPlus[j] = 1;
                dpDes[j] = 1;
                for (int k = 0; k < j; k++) {
                    if (arr[k] < arr[j] && dpPlus[k] + 1 > dpPlus[j]) {
                        dpPlus[j] = dpPlus[k] + 1;
                        result = Math.max(result, dpPlus[j]);
                    }
                    if (arr[k] > arr[j] && dpDes[k] + 1 > dpDes[j]) {
                        dpDes[j] = dpDes[k] + 1;
                        result = Math.max(result, dpDes[j]);
                    }
                }
            }
            for (int j = 0; j < dpPlus.length; j++) {
                System.out.print(dpPlus[j] + " ");
            }
            System.out.println();
            for (int j = 0; j < dpDes.length; j++) {
                System.out.print(dpDes[j] + " ");
            }
            System.out.println(result);
        }
        in.close();
    }
}

/*
 3
 3
 1 1 1
 1 1 1
 1 1 1 0
 5
 1 2 1 2 3
 1 2 1 2 3
 1 1 2 1 1 3
 11
 1 2 11 12 13 14 3 4 5 6 7
 1 2 3 4 5 6 3 4 5 6 7
 1 1 1 1 1 1 2 2 2 2 2 7
 */