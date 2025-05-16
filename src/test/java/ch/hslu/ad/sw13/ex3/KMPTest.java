package ch.hslu.ad.sw13.ex3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KMPTest {

    @Test
    void testRand1() {
        // Arrange
        String testString = "ENTENTE";
        int[] expectedResult = {0, 0, 0, 1, 2, 3, 4};

        // Act
        int[] result = KMP.randTabelle(testString);

        // Assert
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void testRand2() {
        // Arrange
        String testString = "EISBEIN";
        int[] expectedResult = {0, 0, 0, 0, 1, 2, 0};

        // Act
        int[] result = KMP.randTabelle(testString);

        // Assert
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void testRand3() {
        // Arrange
        String testString = "ANANAS";
        int[] expectedResult = {0, 0, 1, 2, 3, 0};

        // Act
        int[] result = KMP.randTabelle(testString);

        // Assert
        assertArrayEquals(expectedResult, result);
    }


    @Test
    void testSearch1() {
        // Pattern somewhere in text

        // Arrange
        String pattern = "ENTENTE";
        String text = "ABFENTENTEAKDMRFNE";
        int expectedIndex = 3;

        // Act
        int result = KMP.kmpSearch(text, pattern);

        // Assert
        assertEquals(expectedIndex, result);
    }

    @Test
    void testSearch2() {
        // Pattern at the beginning of the text

        // Arrange
        String pattern = "ENTENTE";
        String text = "ENTENTEAKDMRFNAMDMFERE";
        int expectedIndex = 0;

        // Act
        int result = KMP.kmpSearch(text, pattern);

        // Assert
        assertEquals(expectedIndex, result);
    }

    @Test
    void testSearch3() {
        // Pattern at the end of the text

        // Arrange
        String pattern = "ENTENTE";
        String text = "AKDMRFNAMDMFEREENTENTE";
        int expectedIndex = 15;

        // Act
        int result = KMP.kmpSearch(text, pattern);

        // Assert
        assertEquals(expectedIndex, result);
    }

    @Test
    void testSearch4() {
        // Pattern nowhere in the text

        // Arrange
        String pattern = "ENTENTE";
        String text = "AKDMRFNAMDMFEREEN";
        int expectedIndex = -1;

        // Act
        int result = KMP.kmpSearch(text, pattern);

        // Assert
        assertEquals(expectedIndex, result);
    }
}