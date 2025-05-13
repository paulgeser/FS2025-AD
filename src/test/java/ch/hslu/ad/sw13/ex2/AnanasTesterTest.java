package ch.hslu.ad.sw13.ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnanasTesterTest {

    @Test
    void emptyTest() {
        // Arrange
        String testString = "";

        // Act
        int result = AnanasTester.stateSearch(testString);

        // Assert
        assertEquals(-1, result);
    }

    @Test
    void onlyAnanasTest() {
        // Arrange
        String testString = "ANANAS";

        // Act
        int result = AnanasTester.stateSearch(testString);

        // Assert
        assertEquals(0, result);
    }

    @Test
    void ananasNotAtTheBeginningTest() {
        // Arrange
        String testString = "TSKBANANASKLP";

        // Act
        int result = AnanasTester.stateSearch(testString);

        // Assert
        assertEquals(4, result);
    }

    @Test
    void ananasTest2() {
        // Arrange
        String testString = "TANANAKBANANASKLP";

        // Act
        int result = AnanasTester.stateSearch(testString);

        // Assert
        assertEquals(8, result);
    }

    @Test
    void ananasTest3() {
        // Arrange
        String testString = "ANANANANANASKLP";

        // Act
        int result = AnanasTester.stateSearch(testString);

        // Assert
        assertEquals(6, result);
    }

    @Test
    void ananasTest4() {
        // Arrange
        String testString = "KLMDNRANANANANANAS";

        // Act
        int result = AnanasTester.stateSearch(testString);

        // Assert
        assertEquals(12, result);
    }

}