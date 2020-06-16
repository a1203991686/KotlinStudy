package com.littlecorgi.suanfa.object3.two;

public class Undergraduate extends Student{
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
