package com.skorobahatko.lecture7_threads.deadlock;

public class DeadLock {

    public static void main(String[] args) {
        Person john = new Person();
        Person bob = new Person();

        john.setPhone(new Phone(12345));
        john.setFriend(bob);

        bob.setPhone(new Phone(98765));
        bob.setFriend(john);

        john.start();
        bob.start();
    }

}
