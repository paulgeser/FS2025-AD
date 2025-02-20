package ch.hslu.ad.sw01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task {

    private static final Logger LOG = LoggerFactory.getLogger(Task.class);

    public static void main(String[] args) throws InterruptedException {
        task(30);
    }

    public static void task(final int n) throws InterruptedException {
        long initialTime = System.currentTimeMillis();
        int iterationSum = 4;
        task1(); task1(); task1(); task1();
        for (int i = 0; i < n; i++) {
            task2(); task2(); task2();
            iterationSum += 3;
            for (int j = 0; j < n; j++) {
                task3(); task3();
                iterationSum += 2;
            }
        }
        LOG.info("Tasks were called {}", iterationSum);

        long finishTime = System.currentTimeMillis();
        LOG.info("Tasks finished in {} ms", finishTime - initialTime);
    }

    public static void task1() throws InterruptedException {
        /*LOG.info("Task 1 was called");*/
        Thread.sleep(5);
    }

    public static void task2() throws InterruptedException {
        /*LOG.info("Task 2 was called");*/
        Thread.sleep(5);
    }

    public static void task3() throws InterruptedException {
        /*LOG.info("Task 3 was called");*/
        Thread.sleep(5);
    }
}
