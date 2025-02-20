package ch.hslu.ad.sw01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Fibonacci {

    private HashMap<Integer, Integer> tempResults = new HashMap<>();

    private static final Logger LOG = LoggerFactory.getLogger(Fibonacci.class);

    public Fibonacci() {
        tempResults.put(0, 0);
        tempResults.put(1, 1);
    }

    public static void main(String[] args) {
        LOG.info("Result: {}", fiboRec1(0));
        LOG.info("Result: {}", fiboRec1(1));
        LOG.info("Result: {}", fiboRec1(2));
        LOG.info("Result: {}", fiboRec1(3));
        LOG.info("Result: {}", fiboRec1(4));
        LOG.info("Result: {}", fiboRec1(5));
        LOG.info("Result: {}", fiboRec1(6));
        LOG.info("Result: {}", fiboRec1(7));
        LOG.info("Result: {}", fiboRec1(8));
        LOG.info("Result: {}", fiboRec1(9));
        LOG.info("Result: {}", fiboRec1(10));

        Fibonacci f = new Fibonacci();
        int n = 50;
        LOG.info("-----------------------------");
        LOG.info("Test execution duration: (n={})", n);
        long startRec1 = System.currentTimeMillis();
        fiboRec1(n);
        long endRec1 = System.currentTimeMillis();
        LOG.info("Test execution duration of Rec1: " + (endRec1 - startRec1));
        long startRec2 = System.currentTimeMillis();
        f.fiboRec2(n);
        long endRec2 = System.currentTimeMillis();
        LOG.info("Test execution duration of Rec2: " + (endRec2 - startRec2));
        long startIter = System.currentTimeMillis();
        fiboIter(n);
        long endIter = System.currentTimeMillis();
        LOG.info("Test execution duration of Iter: " + (endIter - startIter));

    }

    public static int fiboRec1(int n) {
        // Das folgende IF ist die Rekursionsbasis
        if (n <= 1)
            return n;

        // Der folgende Code ist die Rekursionsvorschrift
        return fiboRec1(n - 1) + fiboRec1(n - 2);
    }

    public int fiboRec2(int n) {
        if (n <= 1)
            return n;

        if (this.tempResults.containsKey(n - 1) && this.tempResults.containsKey(n - 2)) {
            int newResult = this.tempResults.get(n - 1) + this.tempResults.get(n - 2);
            this.tempResults.put(n, newResult);
            return newResult;
        } else if (this.tempResults.containsKey(n - 2)) {
            int newResult = this.tempResults.get(n - 2) + fiboRec2(n - 1);
            this.tempResults.put(n, newResult);
            return newResult;
        } else {
            return fiboRec2(n - 1) + fiboRec2(n - 2);
        }
    }

    public static int fiboIter(int n) {
        int num1 = 0, num2 = 1;

        for (int i = 0; i < n; i++) {
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
        }
        return num1;
    }
}
