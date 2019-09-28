package com.skorobahatko.lecture7_threads.raceconditions;

public class IncrementCounterRunnable implements Runnable {

    @Override
    public void run() {
        increase();
        increase();
        increase();
        increase();
    }

    private void increase() {
        synchronized (Count.class) {
            Count.counter++;
            System.out.println("Counter = " + Count.counter);
        }
    }

}
