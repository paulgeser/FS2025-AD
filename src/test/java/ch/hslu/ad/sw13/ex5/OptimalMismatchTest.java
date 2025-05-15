package ch.hslu.ad.sw13.ex5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptimalMismatchTest {

    @Test
    void runTests() {
        test("simple match", "abcdefgh", "cde", 2);
        test("match at start", "abcdef", "abc", 0);
        test("match at end", "abcdef", "def", 3);
        test("no match", "abcdef", "xyz", -1);
        test("pattern longer than text", "abc", "abcd", -1);
        test("full match", "pattern", "pattern", 0);
        test("repeating pattern", "abababab", "abab", 0);
        test("partial overlap no match", "aaaabaaa", "aaab", 1);
        test("multiple occurrences", "abcabcabc", "cab", 2);
        test("case sensitivity", "ABCabc", "abc", 3);
        test("empty pattern", "abc", "", 0);  // Define your behavior: often 0
        test("empty text", "", "abc", -1);
        test("both empty", "", "", 0);        // Define your behavior: often 0
    }

    void test(String name, String text, String pattern, int expectedIndex) {
        int result = OptimalMismatch.optimalMismatch(text, pattern);
        assertEquals(expectedIndex, result);
    }
}