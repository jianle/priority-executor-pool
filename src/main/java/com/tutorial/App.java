package com.tutorial;

import com.tutorial.model.Mini;
import com.tutorial.queue.PriorityThreadPoolExecutor;
import com.tutorial.task.MiniTask;

import java.util.concurrent.*;

/**
 * Created by jianle on 18-8-14.
 */
public class App {

    public static final int DEFAULT_INITIAL_CAPACITY = 2;

    public static void main(String[] args) {

        ThreadPoolExecutor executor = executor(DEFAULT_INITIAL_CAPACITY, DEFAULT_INITIAL_CAPACITY, 0L);
        executor.submit(new MiniTask(new Mini(1L, "A01"), 1));
        executor.submit(new MiniTask(new Mini(2L, "A02"), 5));
        executor.submit(new MiniTask(new Mini(3L, "A03"), 3));
        executor.submit(new MiniTask(new Mini(4L, "A04"), 8));
        executor.submit(new MiniTask(new Mini(5L, "A05"), 4));

        Mini v6 = new Mini(6L, "A06");
        Future<?> future = executor.submit(new MiniTask(v6, 7));
        System.out.println("Remove v6: " + executor.remove(new MiniTask(v6)));
        try {
            Thread.sleep(300);
            executor.setCorePoolSize(1);
            executor.setMaximumPoolSize(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Executor core pool size: " + executor.getCorePoolSize());

        executor.submit(new MiniTask(new Mini(7L, "A07"), 1));
        executor.submit(new MiniTask(new Mini(8L, "A08"), 5));
        executor.submit(new MiniTask(new Mini(9L, "A09"), 3));
        executor.submit(new MiniTask(new Mini(10L, "A10"), 8));
        executor.submit(new MiniTask(new Mini(11L, "A11"), 4));
        executor.submit(new MiniTask(new Mini(12L, "A12"), 8));
        executor.submit(new MiniTask(new Mini(13L, "A13"), 4));

        executor.shutdown();
    }

    private static ThreadPoolExecutor executor(int corePoolSize, int maximumPoolSize, long keepAliveTime) {
        BlockingQueue<Runnable> workQueue = new PriorityBlockingQueue<>();
        return new PriorityThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, workQueue);
    }
}
