package jniexample;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class JNIExample {
    static {
        System.loadLibrary("test");
    }

    public native void getStringFromC();

    public static void main(String[] args) {

    }
}
