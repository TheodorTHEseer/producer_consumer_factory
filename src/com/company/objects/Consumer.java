package com.company.objects;

import com.company.queues.BlockingQueue;

public class Consumer implements Runnable{

    int bufferCapacity;
    int delay;
    BlockingQueue blockingQueue;

    public Consumer(int bufferCapacity, BlockingQueue blockingQueue, int delay) {
        this.bufferCapacity = bufferCapacity;
        this.blockingQueue = blockingQueue;
        this.delay=delay;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+" RUN NOW!!!");

        for(int i=0; i<bufferCapacity;i++){
            synchronized (blockingQueue){
                try {
                    System.out.println(Thread.currentThread().getName()+" прочитал: "+blockingQueue.take());
                }
                catch (NullPointerException e){
                    System.out.println(Thread.currentThread().getName()+": буфер пуст!");
                    Thread.currentThread().interrupt();
                }
            }
            Thread.interrupted();
        }
    }
}
