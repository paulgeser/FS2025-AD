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
    }

    public static boolean isWordLanguage(final String s) {
        Pattern p = Pattern.compile("[a-z]");
        Matcher m = p.matcher(s);
        return m.find();
    }
}
