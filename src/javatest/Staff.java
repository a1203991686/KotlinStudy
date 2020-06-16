package javatest;

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

class Manager extends Staff {
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
        Manager m1 = new Manager("方璐", 19, "女", "市场", 10000);
        System.out.println(m1.toString());
    }
}
