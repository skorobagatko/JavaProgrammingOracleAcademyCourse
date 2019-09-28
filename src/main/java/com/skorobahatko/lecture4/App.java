package com.skorobahatko.lecture4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Pair<String> pair = new Pair<String>("Hello", "World");
        String s = pair.getFirst();
        System.out.println(s);

        Human<Integer, Character> human1 = new Human<>("John", 25, 'M');
        Human<Integer, Sex> human2 = new Human<>("Emily", 25, Sex.FEMALE);

        List<Human<Integer, Character>> humans = new ArrayList<>();
        humans.add(human1);
//        humans.add(human2);

    }

    public static <T extends Comparable> void sort(T[] arr) {
        Arrays.sort(arr);
    }

}

class A {

}

class B<T> extends A {
    T t;
}

class C extends B<String> {

}