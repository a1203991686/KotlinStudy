package com.littlecorgi.suanfa.object3.four;

public class Staff {
    String name;
    int age;
    String sex;

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Staff(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
