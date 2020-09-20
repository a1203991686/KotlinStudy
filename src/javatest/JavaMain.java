package javatest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

class JavaMain {

    static String staticStr = "1";
    String str = "1";

    static class StaticInner {
        public int main() {

            ArrayList<? extends JavaMain> arrayList = new ArrayList<>();
            ArrayList<? extends ExtendsJavaMain> extendsArrayList = new ArrayList<>();
            arrayList = extendsArrayList;
            ArrayList<Number> numberArrayList = new ArrayList<>();
            ArrayList<Integer> integers = new ArrayList<>();


            JavaMain javaMain = arrayList.get(0);

            ArrayList<? super ExtendsJavaMain> arrayList1 = new ArrayList<>();
            arrayList1.add(new ExtendsJavaMain());

            Class clazz = getClass();
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Override.class)) {
                    try {
                        method.invoke(clazz.newInstance());
                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                        e.printStackTrace();
                    }
                    // ...
                }
            }

            staticStr = "123";
            staticTest();
            OutputStream out;
            try {
                out = new FileOutputStream("王埃及是傻逼.txt");
                out.write(123);
                return 1;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return 2;
            } finally {
                System.out.println("finally");
                return 3;
            }
        }
    }

    class Inner {
        public void main() {
            str = "123";
        }
    }

    {
        System.out.println("JavaMain 1");
    }

    public JavaMain() {
        System.out.println("2");
    }

    {
        System.out.println("JavaMain 2");
    }

    protected void test(String a) {
        System.out.println("JavaMain test");
    }

    static protected void staticTest() {
        System.out.println("JavaMain test");
    }

    public static void main(String[] args) {
        // ExtendsJavaMain extendsJavaMain = new ExtendsJavaMain();
        // extendsJavaMain.test();
        // StaticInner staticInner = new StaticInner();
        // System.out.println(staticInner.main());
        // String a = "a";
        // String b = "a";
        // System.out.println(b);
        // // a = "aaa";
        // // System.out.println(b);
        // String c = new String("a");
        // System.out.println(c);
        // System.out.println(a == c);
        // System.out.println(a.equals(c));
        // System.out.println(a == b);
        // System.out.println(a.equals(b));
        // System.out.println(str);
        // change(str);
        // System.out.println(str);

        DateInter dateInter = new DateInter();
        dateInter.setValue(new Date());
        // dateInter.setValue(new Object());
        ExtendsJavaMain extendsJavaMain = new ExtendsJavaMain();
        extendsJavaMain.test("123");
        extendsJavaMain.test(1234);
    }

    static void change(String a) {
        System.out.println(staticStr == a);
    }
}

class ExtendsJavaMain extends JavaMain {
    public ExtendsJavaMain() {
        System.out.println(1);
    }

    protected void test(int a) {
        System.out.println("ExtendsJavaMain test");
    }
}

class Pair<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class DateInter extends Pair<Date> {
    @Override
    public void setValue(Date value) {
        super.setValue(value);
    }

    @Override
    public Date getValue() {
        return super.getValue();
    }
}