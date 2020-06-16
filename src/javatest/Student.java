package javatest;

public class Student {
    private String name;
    private int age;

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

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String studyWay() {
        return "read";
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Postgraduate extends Undergraduate {
    private String researchDirection;

    @Override
    public String toString() {
        return "Postgraduate{" +
                "researchDirection='" + researchDirection + '\'' +
                ", profession='" + profession + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }

    public String getResearchDirection() {
        return researchDirection;
    }

    @Override
    public String studyWay() {
        return "listen";
    }

    public void setResearchDirection(String researchDirection) {
        this.researchDirection = researchDirection;
    }

    public Postgraduate(String name, int age, String profession, String degree, String researchDirection) {
        super(name, age, profession, degree);
        this.researchDirection = researchDirection;
    }

    public static void main(String[] args) {
        Undergraduate u1 = new Undergraduate("方璐", 20, "计算机科学与技术", "本科");
        Postgraduate p1 = new Postgraduate("王埃及", 20, "计算机科学与技术", "研究生", "计算机应用");
        System.out.println(u1.toString());
        System.out.println(p1.toString());
    }
}

class Undergraduate extends Student {
    @Override
    public String toString() {
        return "Undergraduate{" +
                "profession='" + profession + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }

    String profession;
    String degree;

    public Undergraduate(String name, int age, String profession, String degree) {
        super(name, age);
        this.profession = profession;
        this.degree = degree;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String studyWay() {
        return "speak";
    }
}