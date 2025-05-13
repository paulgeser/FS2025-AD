package ch.hslu.ad.sw13.ex3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KMPTest {

    @Test
    void test1() {
        // Arrange
        String testString = "ENTENTE";
        int[] expectedResult = {0, 0, 0, 1, 2, 3, 4};

        // Act
        int[] result = KMP.randTabelle(testString);

        // Assert
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void test2() {
        // Arrange
        String testString = "EISBEIN";
        int[] expectedResult = {0, 0, 0, 0, 1, 2, 0};

        // Act
        int[] result = KMP.randTabelle(testString);

        // Assert
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void test3() {
        // Arrange
        String testString = "ANANAS";
        int[] expectedResult = {0, 0, 1, 2, 3, 0};

        // Act
        int[] result = KMP.randTabelle(testString);

        // Assert
        assertArrayEquals(expectedResult, result);
    }

}