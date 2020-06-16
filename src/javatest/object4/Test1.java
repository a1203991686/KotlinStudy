package com.littlecorgi.suanfa.object4;

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {
        int oldArr[] = {1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5};
        ArrayList<Integer> oldArrList = new ArrayList<>();
        ArrayList<Integer> newArrList = new ArrayList<>();
        int zeroCount = 0;
        int zeroIndexs[] = new int[16];
        for (int i = 0; i < oldArr.length; i++) {
            if (oldArr[i] == 0) {
                zeroIndexs[zeroCount] = i;
                zeroCount++;
            } else {
                newArrList.add(oldArr[i]);
            }
        }
        int index = 0;
        for (int i = 0; i < oldArr.length - index; i++) {
            if (oldArr[i] == 0) {
                if (oldArr.length - index - 1 - i >= 0)
                    System.arraycopy(oldArr, i + 1, oldArr, i, oldArr.length - index - 1 - i);
                index++;
                i--;
            }
        }
        System.out.println("oldArr:");
        for (int i = 0; i < oldArr.length - zeroCount; i++) {
            System.out.printf("%d ", oldArr[i]);
        }
        System.out.println();
        System.out.println("newArr:");
        int[] newArr = new int[newArrList.size()];
        for (int i = 0; i < newArrList.size(); i++) {
            newArr[i] = newArrList.get(i);
        }
        for (int value : newArr) {
            System.out.printf("%d ", value);
        }
    }
}
