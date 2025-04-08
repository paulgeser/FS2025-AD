package ch.hslu.ad.sw08.a1;

import ch.hslu.ad.sw08.a1.animation.SortingAnimation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ch.hslu.ad.sw08.a1.SortingMain.getShuffledNumbers;

public class BubbleSort {

    public static boolean gui = false;
    public static long count = 0;
    private static final Logger LOG = LoggerFactory.getLogger(BubbleSort.class);

    public static int[] sort(final int[] array) {
        int element;
        count = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    element = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = element;
                    if (gui) {
                        SortingAnimation.instance().showArray(array, 50);
                    }
                }
                count++;
            }
        }
        LOG.info("Took {} comparisons to sort the input array", count);
        return array;
    }

    public static void main(String[] args) {
        /*int[] numbers = getShuffledNumbers(50);
        BubbleSort.gui = true;
        int[] test = sort(numbers);*/

        testTime();
    }

    public static void testTime() {
        BubbleSort.gui = false;
        int[] numArray = {100_000, 200_000, 400_000};
        for (int i = 0; i < numArray.length; i++) {
            int numberOfRuns = 5;
            long totalTime = 0;
            for (int j = 0; j < (numberOfRuns + 1); j++) {
                int[] numbers = getShuffledNumbers(numArray[i]);
                long start = System.nanoTime();
                int[] test = sort(numbers);
                long end = System.nanoTime();
                if (j != 0) {
                    totalTime += (end - start) / 1000000L;
                }
            }
            LOG.info("For {} elements it took on average {}ms", numArray[i], (totalTime / numberOfRuns));
        }
    }
}

/*

2025-04-08 17:24:17.353 [main] INFO  c.h.a.s.a.BubbleSort - Took 9999800001 comparisons to sort the input array
2025-04-08 17:24:32.250 [main] INFO  c.h.a.s.a.BubbleSort - Took 9999800001 comparisons to sort the input array
2025-04-08 17:24:43.542 [main] INFO  c.h.a.s.a.BubbleSort - Took 9999800001 comparisons to sort the input array
2025-04-08 17:24:54.799 [main] INFO  c.h.a.s.a.BubbleSort - Took 9999800001 comparisons to sort the input array
2025-04-08 17:25:06.102 [main] INFO  c.h.a.s.a.BubbleSort - Took 9999800001 comparisons to sort the input array
2025-04-08 17:25:17.448 [main] INFO  c.h.a.s.a.BubbleSort - Took 9999800001 comparisons to sort the input array
2025-04-08 17:25:17.448 [main] INFO  c.h.a.s.a.BubbleSort - For 100000 elements it took on average 12009ms
2025-04-08 17:26:04.242 [main] INFO  c.h.a.s.a.BubbleSort - Took 39999600001 comparisons to sort the input array
2025-04-08 17:26:51.352 [main] INFO  c.h.a.s.a.BubbleSort - Took 39999600001 comparisons to sort the input array
2025-04-08 17:27:37.854 [main] INFO  c.h.a.s.a.BubbleSort - Took 39999600001 comparisons to sort the input array
2025-04-08 17:28:24.241 [main] INFO  c.h.a.s.a.BubbleSort - Took 39999600001 comparisons to sort the input array
2025-04-08 17:29:10.403 [main] INFO  c.h.a.s.a.BubbleSort - Took 39999600001 comparisons to sort the input array
2025-04-08 17:29:56.857 [main] INFO  c.h.a.s.a.BubbleSort - Took 39999600001 comparisons to sort the input array
2025-04-08 17:29:56.857 [main] INFO  c.h.a.s.a.BubbleSort - For 200000 elements it took on average 46516ms
2025-04-08 17:33:04.413 [main] INFO  c.h.a.s.a.BubbleSort - Took 159999200001 comparisons to sort the input array

*/
