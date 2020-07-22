package javatest;

class JavaMain {
    public static void main(String[] args) {
        if (true
                || print()) {
            System.out.println(2);
        }
        System.out.println(3);
    }

    private static boolean print() {
        System.out.println(1);
        return System.currentTimeMillis() == 1;
    }
}
