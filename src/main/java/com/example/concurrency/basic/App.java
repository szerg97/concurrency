package com.example.concurrency.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class App {
    public static void main(String[] args) {
        try (ExecutorService executorService = new ScheduledThreadPoolExecutor(3)) {
            for (int i = 0; i < 3; i++) {
                MyRunnable myRunnable = new MyRunnable(i);
                executorService.execute(myRunnable);
            }
        }
    }
}
