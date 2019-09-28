package com.skorobahatko.practice6_threads;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
//        Thread thread = new Thread(new ThreadNamePrintTask());
//        thread.start();

        Map<Long, String> messages = new HashMap<>();
        messages.put(250L, "Message for task with interval 250 ms");
        messages.put(1000L, "Message for task with interval 1000 ms");
        messages.put(500L, "Message for task with interval 500 ms");

        MySchedule schedule = new MySchedule();
        schedule.printMessagesByIntervals(messages);
    }

}
