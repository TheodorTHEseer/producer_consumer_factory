package com.company.objects;

import com.company.queues.BlockingQueue;

import java.util.Random;

public class Producer implements Runnable{

    BlockingQueue blockingQueue;

    Random random = new Random();

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" RUN NOW!!!");
        int cap=random.nextInt(25);
        for (int i=0; i<cap;i++){
            synchronized (blockingQueue){
                System.out.println(Thread.currentThread().getName()+" Writing now!");
               blockingQueue.put(Thread.currentThread().getName()+": "+ i);
           }
           Thread.interrupted();
        }
    }
}
