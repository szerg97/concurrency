package com.example.concurrency.threads;

public class ThreadsApp {
    public static void main(String[] args) {
        Pipeline pipeline = Pipeline.create(3);
        pipeline.seedEqually(10);
        pipeline.getLanes().forEach(System.out::println);
        watchLanes(pipeline);
    }

    private static void watchLanes(Pipeline pipeline){
        int i = 0;
        while(i < 10){
            System.out.println("Iteration: " + i);
            pipeline.getLanes().forEach(System.out::println);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }
}
