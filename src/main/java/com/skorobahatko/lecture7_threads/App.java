package com.skorobahatko.lecture7_threads;

public class App {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.start();
        myThread2.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        Runnable runnable = new AutoStartRunnable("AutoStartRunnableThread");

        thread.join();

        Runnable lambdaRunnable = () -> System.out.println("Lambda runnable");
        new Thread(lambdaRunnable).start();

        System.out.println("Finish thread " + Thread.currentThread().getName());
    }

}
