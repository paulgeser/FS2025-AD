package ch.hslu.ad.sw12;

import ch.hslu.ad.sw11.exercise.n4.fibo.FibonacciPerformance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dea {

    private static final Logger LOG = LoggerFactory.getLogger(Dea.class);

    public static void main(String[] args) {
        LOG.info("Class works");
        String testString = "";
        testString = "0";
        LOG.info("Result for '{}' should be 'true' and is '{}'", testString, isWordLanguage(testString));
        testString = "1";
        LOG.info("Result for '{}' should be 'false' and is '{}'", testString, isWordLanguage(testString));
        testString = "010";
        LOG.info("Result for '{}' should be 'true' and is '{}'", testString, isWordLanguage(testString));
        testString = "011";
        LOG.info("Result for '{}' should be 'false' and is '{}'", testString, isWordLanguage(testString));
        testString = "01110";
        LOG.info("Result for '{}' should be 'true' and is '{}'", testString, isWordLanguage(testString));
        testString = "0110";
        LOG.info("Result for '{}' should be 'false' and is '{}'", testString, isWordLanguage(testString));
        testString = "0111010";
        LOG.info("Result for '{}' should be 'true' and is '{}'", testString, isWordLanguage(testString));
        testString = "010101010111011111110";
        LOG.info("Result for '{}' should be 'true' and is '{}'", testString, isWordLanguage(testString));
    }

    public static boolean isWordLanguage(final String s) {
        Pattern p = Pattern.compile("^0(1(11)*0)*$");
        Matcher m = p.matcher(s);
        return m.find();
    }
}
