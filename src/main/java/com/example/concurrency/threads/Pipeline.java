package com.example.concurrency.threads;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Pipeline {

    private static Pipeline instance;
    private final List<Lane> lanes = new ArrayList<>();

    private Pipeline(int numberOfLanes) {
        for (int i = 0; i < numberOfLanes; i++) {
            lanes.add(new Lane("Lane #" + i));
        }
    }

    public static Pipeline create(int numberOfLanes) {
        if (instance == null){
            instance = new Pipeline(numberOfLanes);
        }
        return instance;
    }

    public List<Lane> getLanes(){
        return lanes;
    }

    public void seedEqually(int i) {
        for (int j = 0; j < i; j++) {
            Product p = new Product(j, "Product " + j);
            lanes.get(j % lanes.size()).addProduct(p);
        }
    }

    static class Lane implements Runnable{
        private final String laneNumber;
        private final Queue<Product> products = new ArrayDeque<>();

        Lane(String laneNumber) {
            this.laneNumber = laneNumber;
        }

        @Override
        public void run() {

        }

        public void addProduct(Product product){
            products.add(product);
        }

        public void poll(){
            products.poll();
        }

        public Product peek(){
            return products.peek();
        }

        @Override
        public String toString() {
            return "Lane{" +
                    "laneNumber='" + laneNumber + '\'' +
                    ", products=" + products +
                    '}';
        }
    }
}
