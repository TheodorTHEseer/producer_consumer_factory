package com.company;

import com.company.objects.Consumer;
import com.company.objects.Producer;
import com.company.queues.BlockingQueue;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    Executor executor;

    public static void main(String[] args) throws InterruptedException {

        final int N_CUPs=Runtime.getRuntime().availableProcessors();
        final int buffer_capacity=10;
        final int delay= 250;

        System.out.println("available Processors: "+N_CUPs);

        ExecutorService executorServiceP = Executors.newCachedThreadPool();
        ExecutorService executorServiceC = Executors.newCachedThreadPool();

        BlockingQueue blockingQueue = new BlockingQueue(buffer_capacity);

        executorServiceP.execute(new Producer(blockingQueue));
        executorServiceC.execute(new Consumer(buffer_capacity,blockingQueue,delay));

    }
}
