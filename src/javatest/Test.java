package javatest;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class Test {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> vector = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            vector.add(i);
        }
        new Thread(() -> {
            Iterator<Integer> it = vector.iterator();
            while (it.hasNext()) {
                System.out.print(it.next());
            }
        }).start();
        new Thread(() -> {
            vector.clear();
        }).start();
    }

}
