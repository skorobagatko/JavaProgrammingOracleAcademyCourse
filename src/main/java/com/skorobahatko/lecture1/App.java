package com.skorobahatko.lecture1;

import java.util.Comparator;

public class App {

    public static void main(String[] args) {
        Human human = new Human("Vasyan", 25);
        System.out.println(human);
//
//        Shape.Color color = new Shape.Color(125, 45, 23);
//
//        Circle.Point point = new Circle(1,1).new Point(3, 4);

        Comparator<Human> ageComparator = new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        System.out.println(ageComparator.getClass().getSimpleName());
    }

}
