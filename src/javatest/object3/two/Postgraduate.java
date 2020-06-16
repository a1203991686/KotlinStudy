package com.littlecorgi.suanfa.object3.two;

public class Postgraduate extends Undergraduate {
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
        Undergraduate u1 = new Undergraduate("田伟康", 19, "计算机科学与技术", "本科");
        Postgraduate p1 = new Postgraduate("王埃及", 20, "计算机科学与技术", "研究生", "计算机应用");
        System.out.println(u1.toString());
        System.out.println(p1.toString());
    }
}
