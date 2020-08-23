package javatest.tencent;

import java.util.Scanner;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
