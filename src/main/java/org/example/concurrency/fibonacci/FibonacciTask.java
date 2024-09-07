package org.example.concurrency.fibonacci;

import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Integer> {
    private final Integer n;
    private Integer fibN;

    public FibonacciTask(Integer n) {
        this.n = n;
        fibN = 0;
    }

    @Override
    protected Integer compute() {
        if (n == 0) {
            fibN = 0;
        } else if (n == 1) {
            fibN = 1;
        } else {
            FibonacciTask fibLeft = new FibonacciTask(n - 2);
            FibonacciTask fibRight = new FibonacciTask(n - 1);
            fibLeft.fork();
            fibRight.fork();
            fibN += fibLeft.join();
            fibN += fibRight.join();
        }
        return fibN;

    }

    public Integer getFibN() {
        return fibN;
    }
}
