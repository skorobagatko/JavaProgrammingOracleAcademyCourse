package com.skorobahatko.lecture1;

public class Circle {

    private Point center;

    public Circle(int x, int y) {
        center = new Point(x, y);
    }

    public class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
