package ch.hslu.ad.sw02.ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testPush() {
        // arrange
        Stack<String> stack = new Stack<>(5);

        // act
        stack.push("a");

        // assert
        assertEquals(1, stack.size());
    }

    @Test
    void testPop() {
        // arrange
        Stack<String> stack = new Stack<>(5);
        stack.push("a");
        assertEquals(1, stack.size());

        // act
        String result = stack.pop();

        // assert
        assertEquals("a", result);
        assertTrue(stack.isEmpty());
    }

    @Test
    void testSizeEmpty() {
        // arrange
        Stack<String> stack = new Stack<>(5);

        // assert
        assertEquals(0, stack.size());
    }

    @Test
    void testSizeTwoElements() {
        // arrange
        Stack<String> stack = new Stack<>(5);

        // act
        stack.push("a");
        stack.push("b");

        // assert
        assertEquals(2, stack.size());
    }

    @Test
    void isEmpty() {
        // arrange
        Stack<String> stack = new Stack<>(5);

        // act
        boolean result = stack.isEmpty();

        // assert
        assertTrue(result);
    }
}