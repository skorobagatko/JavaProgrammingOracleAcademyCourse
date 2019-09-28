package com.skorobahatko.lecture7_threads;

public class AutoStartRunnable implements Runnable {

    private Thread thread;

    public AutoStartRunnable(String name) {
        thread  = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
