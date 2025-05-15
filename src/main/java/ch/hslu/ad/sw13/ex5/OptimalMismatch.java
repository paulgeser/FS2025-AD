package ch.hslu.ad.sw13.ex5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class OptimalMismatch {

    private static final Logger LOG = LoggerFactory.getLogger(OptimalMismatch.class);

    public static void main(String[] args) throws Exception {
        timeTest();
    }

    public static int optimalMismatch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        final int range = 25600; // -> ASCII-Range

        // Zeichenhäufigkeit im Muster
        int[] frequenz = new int[range];
        for (int i = 0; i < m; i++) {
            frequenz[p.charAt(i)]++;
        }

        // Vergleichsreihenfolge im Pattern: seltene Zeichen zuerst
        Integer[] order = new Integer[m];
        for (int i = 0; i < m; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (i1, i2) -> {
            int f1 = frequenz[p.charAt(i1)];
            int f2 = frequenz[p.charAt(i2)];
            if (f1 != f2) return Integer.compare(f1, f2);
            return Integer.compare(i1, i2); // stabiler Sort
        });

        final int[] shift = new int[range];
        // Shift-array erzeugen, Grundbelegung
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }
        // Shifts aufgrund von Muster eintragen
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }

        int i = 0; // Text-Index

        // Suche im Text
        while ((i + m) <= n) {
            int j = 0;
            while (j < m && a.charAt(i + order[j]) == p.charAt(order[j])) {
                j++;
            }
            if (j == m) {
                return i; // Pattern gefunden
            }
            if ((i + m) < n) {
                i += shift[a.charAt(i + m)]; // Sprung
            } else {
                break; // sonst Ende
            }
        }
        return -1; // nicht gefunden
    }


    public static void timeTest() throws Exception {
        String content = readResourceFile("large-text.txt");
        String pattern = "A popular exposition of theories of matter that have developed";
        final int numberOfRuns = 5;
        long totalTime, startTime, endTime, result;
        result = 0;

        totalTime = 0;
        for (int i = 0; i <= numberOfRuns; i++) {
            startTime = System.nanoTime();
            result = optimalMismatch(content, pattern);
            endTime = System.nanoTime();
            if (i != 0) {
                totalTime += (endTime - startTime) / 1000000L;
            }
            // LOG.info("Conc. recursive = {}", result);
        }
        LOG.info("Time : {} msec. {}", totalTime / numberOfRuns, result);

    }

    public static String readResourceFile(String filename) throws Exception {
        InputStream inputStream = OptimalMismatch.class.getClassLoader().getResourceAsStream(filename);
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found: " + filename);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
