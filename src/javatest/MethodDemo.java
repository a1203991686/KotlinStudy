package javatest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class MethodDemo {
    public static void main(String[] args) {
        Method[] methods = SampleClass.class.getMethods();
        Class[] parameterTypes = methods[1].getParameterTypes();

        for (Class parameterType : parameterTypes) {
            System.out.println(parameterType.getName());
        }

        Erasure<? super String> erasure = new Erasure<>("hello");
        Class eclz = erasure.getClass();
        System.out.println("erasure class is:" + eclz.getName());
        Field[] fs = eclz.getDeclaredFields();
        for (Field f : fs) {
            System.out.println("Field name " + f.getName() + " type:" + f.getType().getName());
        }
    }
}

class SampleClass {
    private String sampleField;

    public String getSampleField() {
        return sampleField;
    }

    public void setSampleField(String sampleField, int a) {
        this.sampleField = sampleField;
    }
}

// class Erasure<T> {
class Erasure<T extends String> {
    T object;

    public Erasure(T object) {
        this.object = object;
    }
}

