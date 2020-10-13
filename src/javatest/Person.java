package javatest;

import java.io.*;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 21341324124L;

    private String name = "123";
    private String telephone = "133";
    private String address = "Shannxi";
    private int age = 21;
    private boolean sex = true;

    public Person(String name, String telephone, String address, int age) {
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // @Override
    // public String toString() {
    //     return "Person{" +
    //             "name='" + name + '\'' +
    //             ", telephone='" + telephone + '\'' +
    //             ", address='" + address + '\'' +
    //             ", age=" + age +
    //             '}';
    // }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public static void main(String[] args) {
        Person a = new Person("王埃及", "123312", "西安邮电大学", 21);
        a.age = 21;

        try {
            // ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("王埃及2.txt"));
            // outputStream.writeObject(a);

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("王埃及2.txt"));
            Person person = (Person) objectInputStream.readObject();
            System.out.println(person.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
