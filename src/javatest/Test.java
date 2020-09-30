package javatest;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(testCatch());
    }

    private static String testCatch() {
        try {
            System.out.println("start");
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "catch";
        } finally {
            System.out.println("finally1");
            // return "finally";
        }
    }

    public static void addFromMidTest(int num, boolean flag) {
        if (flag) {
            ArrayList<String> list = new ArrayList<>();
            int i = 0;
            long timeStart = System.currentTimeMillis();
            while (i < num) {
                int temp = list.size();
                list.add(temp / 2, i + "王埃及");
                i++;
            }
            long timeEnd = System.currentTimeMillis();
            System.out.println("ArrayList花费: " + (timeEnd - timeStart) + " " + timeEnd + " " + timeStart);
        } else {
            LinkedList<String> list = new LinkedList<>();
            int i = 0;
            long timeStart = System.currentTimeMillis();
            while (i < num) {
                int temp = list.size();
                list.add(temp / 2, i + "王埃及");
                i++;
            }
            long timeEnd = System.currentTimeMillis();
            System.out.println("LinkedList花费: " + (timeEnd - timeStart) + " " + timeEnd + " " + timeStart);
        }
    }
}
