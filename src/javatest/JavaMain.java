package javatest;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class JavaMain {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        SynchronizedTest a = new SynchronizedTest("a", object1);
        SynchronizedTest b = new SynchronizedTest("b", object2);
        Thread aThread = new Thread(() -> {
            // SynchronizedTest.synchronizedStaticTest1();
            a.synchronizedThisTest();
        });
        Thread bThread = new Thread(() -> {
            // SynchronizedTest.synchronizedStaticTest2();
            a.synchronizedThisTest();
        });
        aThread.start();
        bThread.start();
        SynchronizedTest.InnerA innerA = a.new InnerA();
        System.out.println("*********");
        innerA.testA();
    }
}

class SynchronizedTest {

    class InnerA {
        public void testA() {
            synchronizedThisTest();
            System.out.println(name);
        }
    }

    private String name;
    private Object object;

    public SynchronizedTest(String s, Object obj) {
        name = s;
        object = obj;
    }

    public void synchronizedThisTest() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.print(name + i);
            }
            System.out.println();
            System.out.println("-----");
        }
    }

    public synchronized static void synchronizedStaticTest1() {
        for (int i = 0; i < 100; i++) {
            System.out.print("static 1 " + i);
        }
        System.out.println();
        System.out.println("-----");
    }

    public synchronized static void synchronizedStaticTest2() {
        for (int i = 0; i < 100; i++) {
            System.out.print("static 2 " + i);
        }
        System.out.println();
        System.out.println("-----");
    }

}
