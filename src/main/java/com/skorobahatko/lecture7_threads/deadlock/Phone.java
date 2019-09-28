package com.skorobahatko.lecture7_threads.deadlock;

public class Phone {

    private int number;

    public Phone(int number) {
        this.number = number;
    }

    public synchronized void makeCall(Phone phone) {
        System.out.println("Making call to phone " + phone.number);
        phone.receiveCall(this);
    }

    public synchronized void receiveCall(Phone phone) {
        System.out.println("Received call from phone " + phone.number);
    }

}
