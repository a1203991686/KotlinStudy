package jniexample;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class JNIExample {
    static {
        System.loadLibrary("test");
    }

    /**
     * 声明是native方法
     */
    public static native String sayHello(String name);

    public static void main(String[] args) {
        System.out.println(sayHello("abc"));
    }
}
