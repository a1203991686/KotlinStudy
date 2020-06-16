package com.littlecorgi.suanfa.object2;

public class Line {
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    private Point point1;
    private Point point2;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.point1 = new Point(x1, y1);
        this.point2 = new Point(x2, y2);
    }

    public double length() {
        return Math.sqrt(Math.sqrt(point1.x - point2.x) + Math.sqrt(point1.y - point2.y));
    }

    public boolean isHorizontal() {
        int height = point1.y - point2.y;
        return height == 0;
    }

    public boolean isVertical() {
        int width = point1.x - point2.x;
        return width == 0;
    }

    public double slope() {
        return ((double) point1.x - point2.x) / (point1.y - point2.y);
    }

    public String mid() {
        return "(" + (point1.x - point2.x) + "," + (point1.y - point2.y) + ")";
    }

    public boolean equals(Line _line) {
        return this.length() == _line.length();
    }

    public static void main(String[] args) {
        Line l1 = new Line(1, 2, 3, 4);
        Point point1 = new Line.Point(1, 2);
        Point point2 = new Point(3, 4);
        Line l2 = new Line(point1, point2);
        System.out.println("l1是不是水平的:" + l1.isHorizontal());
        System.out.println("l2是不是垂直的:" + l2.isVertical());
        System.out.println("l1的斜率:" + l1.slope());
        System.out.println("l2的中点:" + l2.mid());
        System.out.println("l1和l2是否相等:" + l1.equals(l2));
    }
}
