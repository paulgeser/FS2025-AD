package ch.hslu.ad.sw13.ex5;

import ch.hslu.ad.sw11.exercise.n4.fibo.FibonacciPerformance;
import ch.hslu.ad.sw11.exercise.n4.fibo.FibonacciTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class QuickSearch {

    private static final Logger LOG = LoggerFactory.getLogger(QuickSearch.class);

    public static void main(String[] args) throws Exception {
        timeTest();
    }

    /**
     * Durchsucht eine Zeichenkette mittels quickSearch.
     *
     * @param a Zeichenkette, die durchsucht wird.
     * @return Index der Fundstelle oder -1, falls Pattern in a nicht gefunden wurde.
     */
    public static int quickSearch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        final int range = 25600; // -> ASCII-Range
        final int[] shift = new int[range];
        // Shift-array erzeugen, Grundbelegung
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }
        // Sjhifts aufgrund von Muster eintragen
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }
        int i = 0; // Text-Index
        int j = 0; // Pattern-Index
        do {
            if (a.charAt(i + j) == p.charAt(j)) { // Match?
                j++;
            } else {
                if ((i + m) < n) { // falls a.charAt(i1+m) nicht ausserhalb ist…
                    i += shift[a.charAt(i + m)]; // Sprung
                    j = 0;
                } else {
                    break; // sonst Ende
                }
            }
        } while ((j < m) && ((i + m) <= n));
        if (j == m) {
            return i; // Pattern gefunden
        } else {
            return -1; // nicht gefunden
        }
    }

    public static void timeTest() throws Exception {
        String content = readResourceFile("large-text.txt");
        String pattern = "A popular exposition of theories of matter that have developed";
        final int numberOfRuns = 1;
        long totalTime, startTime, endTime, result;

        totalTime = 0;
        for (int i = 0; i <= numberOfRuns; i++) {
            startTime = System.nanoTime();
            result = quickSearch(content, pattern);
            endTime = System.nanoTime();
            if (i != 0) {
                totalTime += (endTime - startTime) / 1000000L;
            }
            // LOG.info("Conc. recursive = {}", result);
        }
        LOG.info("Time : {} msec.", totalTime / numberOfRuns);

    }

    public static String readResourceFile(String filename) throws Exception {
        InputStream inputStream = QuickSearch.class.getClassLoader().getResourceAsStream(filename);
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found: " + filename);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
