package ch.hslu.ad.sw01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ackermann {

    private static final Logger LOG = LoggerFactory.getLogger(Ackermann.class);
    private static long callerCount = 0;
    private static int maxDepth = 0;
    private static int currentDepth = 0;

    public static void main(String[] args) {
        int result0 = ack(0,4);
        LOG.info("Ackermann result: {} with {} calls and depth of {}", result0, callerCount, maxDepth);
        callerCount = 0;
        maxDepth = 0;
        currentDepth = 0;
        int result1 = ack(1,2);
        LOG.info("Ackermann result: {} with {} calls and depth of {}", result1, callerCount, maxDepth);
        callerCount = 0;
        maxDepth = 0;
        currentDepth = 0;
        int result2 = ack(2,2);
        LOG.info("Ackermann result: {} with {} calls and depth of {}", result2, callerCount, maxDepth);
        callerCount = 0;
        maxDepth = 0;
        currentDepth = 0;
        int result3 = ack(3,2);
        LOG.info("Ackermann result: {} with {} calls and depth of {}", result3, callerCount, maxDepth);
        callerCount = 0;
        maxDepth = 0;
        currentDepth = 0;
        int result4 = ack(3,3);
        LOG.info("Ackermann result: {} with {} calls and depth of {}", result4, callerCount, maxDepth);
        callerCount = 0;
        maxDepth = 0;
        currentDepth = 0;
    }

    public static int ack(int n, int m) {
        currentDepth++;
        maxDepth = Math.max(maxDepth, currentDepth);
        callerCount += 1;
        int result;
        if (n == 0) {
            result = m + 1;
        } else if (m == 0) {
            result = ack(n - 1, 1);
        } else {
            result = ack(n - 1, ack(n, m - 1));
        }

        currentDepth--;  // Decrease depth when returning
        return result;
    }
}
