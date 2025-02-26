package ch.hslu.ad.sw02;

import ch.hslu.ad.sw02.ex1.Data;
import ch.hslu.ad.sw02.ex1.Liste;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest {

    @Test
    void testEmptyListe() {
        // arrange & act
        Liste<Data> liste = new Liste<Data>();

        // assert
        assertEquals(0, liste.size());
    }

    @Test
    void testListeOneElement() {
        // arrange
        Liste<Data> liste = new Liste<Data>();

        // act
        liste.add(new Data(1));

        // assert
        assertEquals(1, liste.size());
    }

    @Test
    void testListeThreeElements() {
        // arrange
        Liste<Data> liste = new Liste<Data>();

        // act
        liste.add(new Data(1));
        liste.add(new Data(2));
        liste.add(new Data(3));

        // assert
        assertEquals(3, liste.size());
    }

    @Test
    void testListeCheckExistsTrue() {
        // arrange
        Liste<Data> liste = new Liste<Data>();

        // act
        liste.add(new Data(1));
        liste.add(new Data(2));
        liste.add(new Data(3));

        // assert
        assertTrue(liste.checkExist(new Data(2)));
    }

    @Test
    void testListeCheckExistsFalse() {
        // arrange
        Liste<Data> liste = new Liste<Data>();

        // act
        liste.add(new Data(1));
        liste.add(new Data(2));
        liste.add(new Data(3));

        // assert
        assertFalse(liste.checkExist(new Data(4)));
    }

    @Test
    void testListeGetFirstElementNull() {
        // arrange
        Liste<Data> liste = new Liste<Data>();

        // act
        Data entry = liste.getFirstAndRemove();

        // assert
        assertNull(entry);
    }

    @Test
    void testListeGetFirstElementTrue() {
        // arrange
        Liste<Data> liste = new Liste<Data>();
        Data expectedEntry = new Data(1);
        liste.add(new Data(1));
        liste.add(new Data(2));
        liste.add(new Data(3));
        assertEquals(3, liste.size());

        // act
        Data result = liste.getFirstAndRemove();

        // assert
        assertTrue(expectedEntry.equals(result));
        assertEquals(2, liste.size());
    }

    @Test
    void testListeGetFirstElementIndexTrue() {
        // arrange
        Liste<Data> liste = new Liste<Data>();
        Data expectedEntry = new Data(1);
        liste.add(new Data(1));
        liste.add(new Data(2));
        liste.add(new Data(3));
        assertEquals(3, liste.size());

        // act
        Data result = liste.getByIndex(0);

        // assert
        assertTrue(expectedEntry.equals(result));
    }

    @Test
    void testListeGetThirdElementIndexTrue() {
        // arrange
        Liste<Data> liste = new Liste<Data>();
        Data expectedEntry = new Data(3);
        liste.add(new Data(1));
        liste.add(new Data(2));
        liste.add(new Data(3));
        assertEquals(3, liste.size());

        // act
        Data result = liste.getByIndex(2);

        // assert
        assertTrue(expectedEntry.equals(result));
    }

    @Test
    void testListeGetElementIndexNull() {
        // arrange
        Liste<Data> liste = new Liste<Data>();

        // act
        Data result = liste.getByIndex(0);

        // assert
        assertNull(result);
    }

    @Test
    void testListeGetElementIndexOutOfBounds() {
        // arrange
        Liste<Data> liste = new Liste<Data>();
        liste.add(new Data(1));
        liste.add(new Data(2));
        liste.add(new Data(3));
        assertEquals(3, liste.size());

        // act
        Data result = liste.getByIndex(4);

        // assert
        assertNull(result);
    }
}