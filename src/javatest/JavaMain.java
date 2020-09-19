package javatest;

class JavaMain {
    static String str = "1";

    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        System.out.println(b);
        // a = "aaa";
        // System.out.println(b);
        String c = new String("a");
        System.out.println(c);
        System.out.println(a == c);
        System.out.println(a.equals(c));
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(str);
        change(str);
        System.out.println(str);
    }

    static void change(String a) {
        System.out.println(str == a);
    }
}