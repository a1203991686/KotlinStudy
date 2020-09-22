package javatest;

import java.io.Serializable;

/**
 * @author littlecorgi
 * @date 2020/9/20
 */
public class Main {

    synchronized void sync1() {
        // System.out.println("enter");
        // sync2();
        // try {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread: 1");
                System.out.println("thread: 2");
                System.out.println("thread: 3");
                System.out.println("thread: 4");
                System.out.println("thread: 5");
                System.out.println("thread: 6");
                System.out.println("thread: 7");
                System.out.println("thread: 8");
                System.out.println("thread: 9");
                System.out.println("thread: 0");
                try {
                    Thread.sleep(3 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        synchronized (thread) {
            try {
                System.out.println("thread: " + Thread.currentThread().getName());
                thread.wait();
                System.out.println("thread 123123");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // wait();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        System.out.println("sync1 exit");
    }

    synchronized void sync2() {
        System.out.println("sync 2 enter");
        System.out.println("sync 2 exit");
    }

    public static void main(String[] args) {
        // File file;
        // try {
        // PersonBean person = new PersonBean();
        // ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("王埃及.txt"));
        // out.writeObject(person);
        // out.close();
        // ObjectInputStream in = new ObjectInputStream(new FileInputStream("王埃及.txt"));
        // PersonBean newPerson = (PersonBean) in.readObject();
        // newPerson.str = "1234";
        // in.close();
        // System.out.println(newPerson.toString());
        // Class clazz = newPerson.getClass();
        // Field[] fields = clazz.getDeclaredFields();
        // for (Field field : fields) {
        //     field.setAccessible(true);
        //     System.out.println(field.get(newPerson));
        // }

        // class Inner implements Stupid {
        //     @Override
        //     public void saySb() {
        //         System.out.println("Inner say sb!!");
        //     }
        // }
        // Inner inner = new Inner();
        // Stupid stupid = (Stupid) Proxy.newProxyInstance(Stupid.class.getClassLoader(), new Class[]{Stupid.class}, new InvocationHandler() {
        //     @Override
        //     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //         System.out.println("Proxy代理");
        //         return method.invoke(inner);
        //     }
        // });
        // stupid.saySb();

        // } catch (IOException | ClassNotFoundException | IllegalAccessException e) {
        //     e.printStackTrace();
        // }

        Main main = new Main();
        System.out.println(123);
        // new Thread(() -> {
        //     try {
        //         Thread.sleep(3 * 1000);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        //     System.out.println(2);
        //     synchronized (main) {
        //         main.notify();
        //     }
        // }).start();
        main.sync1();
        System.out.println("main end");
    }

}

interface Stupid {
    public void saySb();
}

class PersonBean implements Serializable {

    protected String str = "1234";

    private static final long serialVersionUID = 1234567890L;

    String name = "12";
    int age;
    String address;

    // public PersonBean(String name, int age, String address) {
    //     this.name = name;
    //     this.age = age;
    //     this.address = address;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}

class MainThread extends Thread implements B {
    @Override
    public void run() {
        super.run();
        System.out.println("王埃及是傻逼");
        B.test();
        this.bb();
    }
}

class MainRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("王埃及是智障");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

interface B {

    static void test() {

    }

    default void bb() {

    }

}
