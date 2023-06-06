package com.example.concurrency.basic;

public class MyRunnable implements Runnable{
    private final int number;

    public MyRunnable(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("#" + number + " is running " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
