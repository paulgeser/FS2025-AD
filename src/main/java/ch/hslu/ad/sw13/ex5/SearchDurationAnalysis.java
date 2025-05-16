package ch.hslu.ad.sw13.ex5;

import ch.hslu.ad.sw13.ex3.KMP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class SearchDurationAnalysis {

    private static final Logger LOG = LoggerFactory.getLogger(QuickSearch.class);


    public static void main(String[] args) throws Exception {
        timeTest();
    }

    public static void timeTest() throws Exception {
        String content, pattern;
        content = readResourceFile("simple-characters.txt");
        pattern = "aabbbaaaaaaabbbbaaaaabaaaa";
        testAllMethodsWithTextAndPattern("ABC text",content, pattern);
        content = null;
        System.gc();

        content = readResourceFile("genomic.fna");
        pattern = "GCCATCAACACGGGCCCTGCCCCTGCTGTCACCAAGACTGAGACTGAGGTCCAGAATCCAGATGTTCTGTGGGATTTGG";
        testAllMethodsWithTextAndPattern("DNA PATTERN", content, pattern);
        content = null;
        System.gc();

        content = readResourceFile("gct-file.txt");
        pattern = "CD14_PROT";
        testAllMethodsWithTextAndPattern("PROTEIN in GCT FILE", content, pattern);
        content = null;
        System.gc();

        content = readResourceFile("large-text.txt");
        pattern = "A popular exposition of theories of matter that have developed";
        testAllMethodsWithTextAndPattern("Sentence in long text", content, pattern);
        content = null;
        System.gc();

        content = readResourceFile("very-large-text.txt");
        pattern = "A popular exposition of theories of matter that have developed";
        testAllMethodsWithTextAndPattern("Sentence in very long text", content, pattern);
    }

    public static void testAllMethodsWithTextAndPattern(String name, String content, String pattern) {
        LOG.info("New run! =======================================================================");
        LOG.info("Name: {}", name);
        final int numberOfRuns = 30;
        long totalTime, startTime, endTime, result;

        SearchMethod[] methods = SearchMethod.values();
        for (int i = 0; i < methods.length; i++) {
            SearchMethod currentMethod = methods[i];
            totalTime = 0;
            result = 0;
            for (int j = 0; j <= numberOfRuns; j++) {
                result = 0;
                startTime = System.nanoTime();
                switch (currentMethod) {
                    case SearchMethod.SIMPLE_SEARCH:
                        result = SimpleStringSearch.findPattern(content, pattern);
                        break;
                    case SearchMethod.KMP_SEARCH:
                        result = KMP.kmpSearch(content, pattern);
                        break;
                    case SearchMethod.QUICK_SEARCH:
                        result = QuickSearch.quickSearch(content, pattern);
                        break;
                    case SearchMethod.OPTIMAL_MISMATCH_SEARCH:
                        result = OptimalMismatch.optimalMismatch(content, pattern);
                        break;
                }
                endTime = System.nanoTime();
                if (j != 0) {
                    totalTime += (endTime - startTime) / 1000000L;
                }
            }
            LOG.info("Algo '{}' Time : {} msec. {}", currentMethod, totalTime / numberOfRuns, result);
        }
        LOG.info("New finished! =======================================================================");
        LOG.info("");
        LOG.info("");
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
