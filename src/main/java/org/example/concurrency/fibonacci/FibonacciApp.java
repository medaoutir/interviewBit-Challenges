package org.example.concurrency.fibonacci;

import java.util.concurrent.ForkJoinPool;

public class FibonacciApp {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FibonacciTask fibonacciTask = new FibonacciTask(12);
        forkJoinPool.invoke(fibonacciTask);
        System.out.println(fibonacciTask.getFibN());
    }
}