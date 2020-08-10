package javatest;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigInteger;
import java.util.Hashtable;
import java.util.LinkedList;

class JavaMain {
    static {
        System.out.println("JavaMain Static 1");
    }

    {
        System.out.println("JavaMain 1");
    }

    public JavaMain() {
        System.out.println("JavaMain Constructor");
    }

    static {
        System.out.println("JavaMain Static 2");
    }

    {
        System.out.println("JavaMain 1");
    }

    public static BigInteger test(int a) {
        if (a == 0) {
            return BigInteger.ONE;
        }
        BigInteger temp = BigInteger.valueOf(a).multiply(test(a - 1));
        return temp;
    }

    public static void nullableTest(@Nullable String a) {
        System.out.println(a);
    }

    public static void nonTest(@NotNull String a) {
        System.out.println(a);
    }

    public static void main(String[] args) {
        nullableTest(null);
        nonTest(null);
        System.out.println(test(100000));
    }
}

class ExtendsJavaMain extends JavaMain {
    static {
        System.out.println("ExtendsJavaMain Static 1");
    }

    {
        System.out.println("ExtendsJavaMain 1");
    }

    public ExtendsJavaMain() {
        System.out.println("ExtendsJavaMain Constructor");
    }

    static {
        System.out.println("ExtendsJavaMain Static 2");
    }

    {
        System.out.println("ExtendsJavaMain 1");
    }
}