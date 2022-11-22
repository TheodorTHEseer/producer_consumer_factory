package com.company;

import com.company.objects.Consumer;
import com.company.objects.Producer;
import com.company.queues.BlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final int N_CUPs=Runtime.getRuntime().availableProcessors();
        final int buffer_capacity=10;
        final int delay=20;

        System.out.println("Available Processors: "+N_CUPs);

        ExecutorService executorService = Executors.newCachedThreadPool();

        BlockingQueue blockingQueue = new BlockingQueue(buffer_capacity);

        executorService.execute(new Producer(blockingQueue));
        executorService.execute(new Consumer(buffer_capacity,blockingQueue,delay));
    }
}
