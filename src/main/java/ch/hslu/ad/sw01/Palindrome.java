package ch.hslu.ad.sw01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Palindrome {

    private static final Logger LOG = LoggerFactory.getLogger(Palindrome.class);


    public static void main(String[] args) {
        int number1 = 13531;
        boolean result1 = checkPalindrome(number1);
        LOG.info("Palindrome({}) result: {}", number1, result1);

        int number2 = 14531;
        boolean result2 = checkPalindrome(number2);
        LOG.info("Palindrome({}) result: {}", number2, result2);


        long number3 = 197L;
        long result3 = getNextPalinDrome(number3);
        LOG.info("Next Palindrome for {} : {}", number3, result3);
    }

    public static LinkedList<Long> ziffernInArray(long zahl) {
        LinkedList<Long> arrayList = new LinkedList<>();
        // Konvertiere die Zahl in einen String
        String zahlAlsString = Long.toString(Math.abs(zahl));

        // Befülle das Array mit den Ziffern
        for (int i = 0; i < zahlAlsString.length(); i++) {
            arrayList.add(Long.parseLong(String.valueOf(zahlAlsString.charAt(i)))); // Konvertiere von char zu int
        }
        return arrayList;
    }

    public static boolean checkPalindrome(long number) {
        LinkedList<Long> numberArray = ziffernInArray(number);
        LOG.info(numberArray.toString());
        while (numberArray.size() > 1) {
            long first = numberArray.getFirst();
            long last = numberArray.getLast();
            if (first == last) {
                numberArray.removeFirst();
                numberArray.removeLast();
            } else {
                return false;
            }
        }
        return true;
    }

    public static long getNextPalinDrome(Long number) {
        LinkedList<Long> numberArray = ziffernInArray(number);
        int symIndex = numberArray.size() / 2;
        int arrayLength = numberArray.size();
        for (int i = 0; i < symIndex; i++) {
            if (!(numberArray.get(i) == numberArray.get(arrayLength - i - 1))) {
                if (numberArray.get(arrayLength - i - 1) < numberArray.get(i)) {
                    numberArray.set(arrayLength - i - 1, numberArray.get(i));
                } else {
                    long newNumber = numberArray.get(i) + 1L;
                    numberArray.set(i, newNumber);
                    numberArray.set(arrayLength - i - 1, newNumber);
                    int rewriteIndexes = arrayLength - 2 * (i + 1);
                    for (int j = 1; j <= rewriteIndexes; j++) {
                        numberArray.set(i + j, 0L);
                    }
                    break;
                }
            }
        }

        // reverse long array to long
        return Long.parseLong(String.join("", numberArray.stream().map(Object::toString).toList()));
    }
}
