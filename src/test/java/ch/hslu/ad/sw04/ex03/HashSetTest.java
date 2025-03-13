package ch.hslu.ad.sw04.ex03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashSetTest {

    @Test
    void testEmtpyHashSet() {
        // arrange
        HashSet<String> hashSet = new HashSet<>();

        // act
        int size = hashSet.size();
        boolean full = hashSet.full();

        // assert
        assertEquals(0, size);
        assertFalse(full);
    }

    @Test
    void testAddOneHashSet() {
        // arrange
        HashSet<String> hashSet = new HashSet<>();

        // act
        hashSet.add("Hello there");

        // assert
        assertEquals(1, hashSet.size());
        assertFalse(hashSet.full());
    }

    @Test
    void testAddTwoHashSet() {
        // arrange
        HashSet<String> hashSet = new HashSet<>();

        // act
        hashSet.add("Hello");
        hashSet.add("Cool stuff");

        // assert
        assertEquals(2, hashSet.size());
        assertFalse(hashSet.full());
    }

    @Test
    void testContainsHashSet() {
        // arrange
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hello");
        hashSet.add("Cool stuff");

        // act
        boolean result = hashSet.contains("Hello");

        // assert
        assertTrue(result);
    }

    @Test
    void testRemoveOneHashSet() {
        // arrange
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hello");
        hashSet.add("Cool stuff");
        assertEquals(2, hashSet.size());

        // act
        boolean result = hashSet.remove("Cool stuff");

        // assert
        assertTrue(result);
        assertEquals(1, hashSet.size());
    }

    @Test
    void testAddCollisonHashSet() {
        // arrange
        HashSet<String> hashSet = new HashSet<>();

        // act
        hashSet.add("Hello there");
        hashSet.add("Wow crazy");

        // assert
        assertEquals(2, hashSet.size());
        assertFalse(hashSet.full());
    }

    @Test
    void testContainsCollisonHashSet() {
        // arrange
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hello there");
        hashSet.add("Wow crazy");

        // act
        boolean result = hashSet.contains("Wow crazy");

        // assert
        assertTrue(result);
    }

    @Test
    void testRemoveCollisionHashSet() {
        // arrange
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hello there");
        hashSet.add("Wow crazy");
        assertEquals(2, hashSet.size());

        // act
        boolean result = hashSet.remove("Wow crazy");

        // assert
        assertTrue(result);
        assertEquals(1, hashSet.size());
    }
}