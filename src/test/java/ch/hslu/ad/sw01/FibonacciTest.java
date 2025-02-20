package ch.hslu.ad.sw01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    public void testFiboRec1V1() {
        // arrange
        int input = 1;
        int expected = 1;

        // act
        int result = Fibonacci.fiboRec1(input);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void testFiboRec1V2() {
        // arrange
        int input = 7;
        int expected = 13;

        // act
        int result = Fibonacci.fiboRec1(input);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void testFiboRec1V3() {
        // arrange
        int input = 11;
        int expected = 89;

        // act
        int result = Fibonacci.fiboRec1(input);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void testFiboRec2V1() {
        // arrange
        int input = 1;
        int expected = 1;
        Fibonacci fibonacci = new Fibonacci();

        // act
        int result = fibonacci.fiboRec2(input);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void testFiboRec2V2() {
        // arrange
        int input = 7;
        int expected = 13;
        Fibonacci fibonacci = new Fibonacci();

        // act
        int result = fibonacci.fiboRec2(input);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void testFiboRec2V3() {
        // arrange
        int input = 11;
        int expected = 89;
        Fibonacci fibonacci = new Fibonacci();

        // act
        int result = fibonacci.fiboRec2(input);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void testFiboIterV1() {
        // arrange
        int input = 1;
        int expected = 1;

        // act
        int result = Fibonacci.fiboIter(input);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void testFiboIterV2() {
        // arrange
        int input = 7;
        int expected = 13;

        // act
        int result = Fibonacci.fiboIter(input);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void testFiboIterV3() {
        // arrange
        int input = 11;
        int expected = 89;

        // act
        int result = Fibonacci.fiboIter(input);

        // assert
        assertEquals(expected, result);
    }
}