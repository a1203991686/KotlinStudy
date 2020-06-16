package com.littlecorgi.suanfa.object3.four;

public class Manager extends Staff {
    private String position;
    private int salary;

    @Override
    public String toString() {
        return "Manager{" +
                "position='" + position + '\'' +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Manager(String name, int age, String sex, String position, int salary) {
        super(name, age, sex);
        this.position = position;
        this.salary = salary;
    }

    public static void main(String[] args) {
        Manager m1 = new Manager("田伟康", 19, "男", "市场", 10000);
        System.out.println(m1.toString());
    }
}
