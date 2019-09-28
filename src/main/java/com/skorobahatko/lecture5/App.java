package com.skorobahatko.lecture5;

import java.util.*;

public class App {

    public static void main(String[] args) {

        Map<String, Human> map = new HashMap<>();
        map.put("John", new Human("John", 25));
        map.put("Bob", new Human("Bob", 30));
        map.put("Alex", new Human("Alex", 35));

        System.out.println(map);

        for (Map.Entry<String, Human> humanEntry : map.entrySet()) {
            System.out.println(humanEntry.getKey() + " -> " + humanEntry.getValue());
        }

    }

}
