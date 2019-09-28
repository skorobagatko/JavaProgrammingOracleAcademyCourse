package com.skorobahatko.practice6_threads;

import java.util.Map;

public class MySchedule {

    public void printMessagesByIntervals(Map<Long, String> messages) {
        for (Map.Entry<Long, String> entry : messages.entrySet()) {
            long interval = entry.getKey();
            String message = entry.getValue();
            new Thread(new IntervalTask(interval, message)).start();
        }
    }

    private class IntervalTask implements Runnable {

        private final long interval;
        private final String message;

        IntervalTask(long interval, String message) {
            this.interval = interval;
            this.message = message;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(message);
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
