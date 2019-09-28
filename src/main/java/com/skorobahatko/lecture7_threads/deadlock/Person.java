package com.skorobahatko.lecture7_threads.deadlock;

public class Person extends Thread {

    private Person friend;
    private Phone phone;

    public Person getFriend() {
        return friend;
    }

    public void setFriend(Person friend) {
        this.friend = friend;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void run() {
        phone.makeCall(friend.phone);
    }
}
