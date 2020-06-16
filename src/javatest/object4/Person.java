package com.littlecorgi.suanfa.object4;

import java.util.Scanner;

class Person {
    String name;
    String sex;
    int age;

    Person() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入姓名:");
        this.name = in.nextLine();
        System.out.println("请输入性别:");
        while (true) {
            try {
                this.sex = in.next();
                if (sex.equals("male") || sex.equals("female"))
                    break;
                else
                    throw new Exception();
            } catch (Exception e) {
                System.out.println("性别输入有误，请重新输入！");
            }
        }
        System.out.println("请输入年龄:");
        while (true) {
            try {
                this.age = in.nextInt();
                if (age >= 0 && age <= 120)
                    break;
                else
                    throw new Exception();
            } catch (Exception e) {
                System.out.println("年龄输入有误，请重新输入！");
            }
        }
        System.out.println("姓名:" + name + "\n性别" + sex + "\n年龄：" + age);
    }
}

class q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Person p1 = new Person();
        Person p2 = new Person();
    }
}