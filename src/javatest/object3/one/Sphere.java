package com.littlecorgi.suanfa.object3.one;

import com.littlecorgi.suanfa.object3.one.Circle;

public class Sphere extends Circle {
    public Sphere(float radius) {
        super(radius);
    }

    public double getSphereArea() {
        return Math.PI * radius * radius * 4;
    }

    public double getSphereCircumference() {
        return 4.0 / 3 * Math.PI * radius * radius * radius;
    }

    public static void main(String[] args) {
        Sphere sphere = new Sphere(3);
        System.out.println(sphere.getArea());
        System.out.println(sphere.getCircumference());
        System.out.println(sphere.getSphereArea());
        System.out.println(sphere.getSphereCircumference());
    }
}
