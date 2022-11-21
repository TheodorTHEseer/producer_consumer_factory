package com.company;

import com.company.queues.BlockingQueue;

public class Main {

    public static void main(String[] args) {

        BlockingQueue blockingQueue = new BlockingQueue(10);
        for(int i=1; i<12;i++){
            blockingQueue.put(String.valueOf(i));
        }

        System.out.println("size: "+ blockingQueue.getSize());
        for(int i=1; i<10;i++){
            System.out.println(blockingQueue.take());
        }
    }
}
