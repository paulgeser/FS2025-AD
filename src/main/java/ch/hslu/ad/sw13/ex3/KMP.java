package ch.hslu.ad.sw13.ex3;

public class KMP {

    public static int[] randTabelle(final String input) {
        int[] randTabelleResult = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            String partialString = input.substring(0, i + 1);
            int maxBorder = 0;
            for (int j = 1; j < partialString.length(); j++) {
                String start = partialString.substring(0, j);
                String end = partialString.substring(partialString.length() - j);
                if (start.equals(end)) {
                    maxBorder = j;
                }
            }

            randTabelleResult[i] = maxBorder;
        }
        return randTabelleResult;
    }

    public static int kmpSearch(final String text, String pattern) {
        int[] tabelle = randTabelle(pattern);
        int j = 0;

        for (int i = 0; i < text.length(); i++) {

            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = tabelle[j - 1];
            }


            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            if (j == pattern.length()) {
                return i - j + 1;
            }
        }

        return -1;
    }
}
