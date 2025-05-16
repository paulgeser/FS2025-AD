package ch.hslu.ad.sw13.ex5;

public class SimpleStringSearch {

    public static int findPattern(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;

            for (j = 0; j < patternLength; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == patternLength) {
                return i;
            }
        }

        return -1;
    }
}
