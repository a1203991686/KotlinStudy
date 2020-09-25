package javatest;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(i);
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            linkedList.add(i);
        }

        long start1 = System.currentTimeMillis();
        arrayList.add(50, 1);
        for (int i = 0; i < 10000; i++) {
            int temp = arrayList.size();
            arrayList.add(temp / 2, 100 + i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("ArrayList花费: " + (end1 - start1) + " " + end1 + " " + start1);

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int temp = linkedList.size();
            linkedList.add(temp / 2, 100 + i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("LinkedList花费: " + (end2 - start2) + " " + end2 + " " + start2);

        addFromMidTest(10000, true);
        addFromMidTest(10000, false);
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
