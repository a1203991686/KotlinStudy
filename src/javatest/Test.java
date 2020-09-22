package javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class Test {

    public static void main(String[] args) {
        String fullName = "src/javatest/Test.java";
        Enumeration<URL> configs;
        try {
            configs = ClassLoader.getSystemResources(fullName);
            InputStream in = configs.nextElement().openStream();
            BufferedReader r = new BufferedReader(new InputStreamReader(in, "utf-8"));

            PersonBean personBean = new PersonBean();
            personBean.str = "1234";
            do {
                System.out.println(r.readLine());
            } while (r.read() != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
