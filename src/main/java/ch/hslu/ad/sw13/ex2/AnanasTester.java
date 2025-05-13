package ch.hslu.ad.sw13.ex2;

public class AnanasTester {

    public static void main(String[] args) {

    }

    public static int stateSearch(final String input) {
        int state = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            switch (state) {
                case 0:
                    if (c == 'A') {
                        state = 1;
                    }
                    break;
                case 1:
                    if (c == 'N') {
                        state = 2;
                    } else if (c != 'A') {
                        state = 0;
                    }
                    break;
                case 2:
                    if (c == 'A') {
                        state = 3;
                    } else {
                        state = 0;
                    }
                    break;
                case 3:
                    if (c == 'N') {
                        state = 4;
                    } else if (c == 'A') {
                        state = 1;
                    } else {
                        state = 0;
                    }
                    break;
                case 4:
                    if (c == 'A') {
                        state = 5;
                    } else {
                        state = 0;
                    }
                    break;
                case 5:
                    if (c == 'S') {
                        return i - 5;
                    } else if (c == 'N') {
                        state = 4;
                    } else if (c == 'A') {
                        state = 1;
                    } else {
                        state = 0;
                    }
                    break;
            }
        }
        return -1;
    }
}
