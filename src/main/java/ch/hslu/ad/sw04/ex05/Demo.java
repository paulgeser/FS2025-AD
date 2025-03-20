package ch.hslu.ad.sw04.ex05;

import ch.hslu.ad.sw02.ex2.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.UUID;
import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;

public class Demo {

    private static final Logger LOG = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        LOG.info("Starting with test cases");
        LOG.info("_________________________");
        final int itemAmountTest1 = 100000;
        String[] testData1 = generateTestData(itemAmountTest1);
        LOG.info("Test 1 ({})", itemAmountTest1);
        LOG.info("Personal Stackresults: {}", testPersonalStack(itemAmountTest1, testData1));
        LOG.info("Java Stackresults: {}", testJavaStack(itemAmountTest1, testData1));
        LOG.info("Java Dequeresults: {}", testJavaDeque(itemAmountTest1, testData1));
        LOG.info("Eclipse stackresults: {}", testJavaEclipseCollection(itemAmountTest1, testData1));
        LOG.info("End test 1");
        LOG.info("__________________________");
        final int itemAmountTest2 = 1000000;
        String[] testData2 = generateTestData(itemAmountTest2);
        LOG.info("Test 2 ({})", itemAmountTest2);
        LOG.info("Personal Stackresults: {}", testPersonalStack(itemAmountTest2, testData2));
        LOG.info("Java Stackresults: {}", testJavaStack(itemAmountTest2, testData2));
        LOG.info("Java Dequeresults: {}", testJavaDeque(itemAmountTest2, testData2));
        LOG.info("Eclipse stackresults: {}", testJavaEclipseCollection(itemAmountTest2, testData2));
        LOG.info("End test 2");
        LOG.info("__________________________");
        final int itemAmountTest3 = 10000000;
        String[] testData3 = generateTestData(itemAmountTest3);
        LOG.info("Test 3 ({})", itemAmountTest3);
        LOG.info("Personal Stackresults: {}", testPersonalStack(itemAmountTest3, testData3));
        LOG.info("Java Stackresults: {}", testJavaStack(itemAmountTest3, testData3));
        LOG.info("Java Dequeresults: {}", testJavaDeque(itemAmountTest3, testData3));
        LOG.info("Eclipse stackresults: {}", testJavaEclipseCollection(itemAmountTest3, testData3));
        LOG.info("End test 3");
        LOG.info("__________________________");
        /*final int itemAmountTest4 = 100000000;
        String[] testData4 = generateTestData(itemAmountTest4);
        LOG.info("Test 4 ({})", itemAmountTest4);
        LOG.info("Personal Stackresults: {}", testPersonalStack(itemAmountTest4, testData4));
        LOG.info("Java Stackresults: {}", testJavaStack(itemAmountTest4, testData4));
        LOG.info("Java Dequeresults: {}", testJavaDeque(itemAmountTest4, testData4));
        LOG.info("End test 4");
        LOG.info("__________________________");*/
        LOG.info("All test cases completed!");
    }

    public static long testPersonalStack(final int itemAmount, final String[] data) {
        final Stack<String> myStack = new Stack<>(itemAmount);
        final long testStart = System.nanoTime();

        for (String obj : data) {
            myStack.push(obj);
        }

        final long testEnd = System.nanoTime();

        return (testEnd - testStart) / 1000000L;
    }

    public static long testJavaStack(final int itemAmount, final String[] data) {
        final java.util.Stack<String> javaStack = new java.util.Stack<>();
        javaStack.setSize(itemAmount);
        final long testStart = System.nanoTime();

        for (String obj : data) {
            javaStack.push(obj);
        }

        final long testEnd = System.nanoTime();

        return (testEnd - testStart) / 1000000L;
    }

    public static long testJavaDeque(final int itemAmount, final String[] data) {
        final Deque<String> javaDeque = new ArrayDeque<>(itemAmount);

        final long testStart = System.nanoTime();

        for (String obj : data) {
            javaDeque.push(obj);
        }

        final long testEnd = System.nanoTime();

        return (testEnd - testStart) / 1000000L;
    }

    public static long testJavaEclipseCollection(final int itemAmount, final String[] data) {
        final MutableStack<String> eclipseStack = new ArrayStack<>();
        final long testStart = System.nanoTime();

        for (String obj : data) {
            eclipseStack.push(obj);
        }

        final long testEnd = System.nanoTime();

        return (testEnd - testStart) / 1000000L;
    }

    public static String[] generateTestData(int size) {
        String[] data = new String[size];
        for (int i = 0; i < size; i++) {
            data[i] = getRandomString(3);
        }
        return data;
    }

    public static String getRandomString(int length) {
        String randomStr = UUID.randomUUID().toString();
        while (randomStr.length() < length) {
            randomStr += UUID.randomUUID().toString();
        }
        return randomStr.substring(0, length);
    }
}
