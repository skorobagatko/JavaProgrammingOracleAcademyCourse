package com.skorobahatko.lecture2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {

    public static void main(String[] args) {
        Day day = Day.FRIDAY;
        System.out.println("day.getNumber() = " + day.getNumber());
        System.out.println(Day.getDayByNumber(7));
        System.out.println(day.name());
        System.out.println(Day.valueOf("SUNDAY").isHoliday());

    }

}

class A {
    public void f() throws Exception {

    }
}

class B extends A {
    public void f() throws IOException {

    }
}

class C extends B {
    public void f() throws FileNotFoundException {

    }
}