package com.skorobahatko.lecture7_threads.raceconditions;

public class RaceConditionsText {

    public static void main(String[] args) {
        IncrementCounterRunnable task = new IncrementCounterRunnable();

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        Thread thread4 = new Thread(task);
        Thread thread5 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

}
