package ch.hslu.ad.sw08.a1;

import ch.hslu.ad.sw08.a1.animation.SortingAnimation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ch.hslu.ad.sw08.a1.SortingMain.getShuffledNumbers;

public class ShellSort {

    public static boolean gui = false;
    public static long count = 0;
    private static final Logger LOG = LoggerFactory.getLogger(ShellSort.class);

    public static int[] sort(final int[] array) {
        int n = array.length;
        count = 0;

        // Start with the largest Knuth gap less than n
        int gap = 1;
        while (gap < n / 3) {
            gap = gap * 3 + 1; // Knuth's formula: 1, 4, 13, 40, 121, ...
        }

        while (gap >= 1) {
            // Do insertion sort for this gap
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;

                // Shift earlier gap-sorted elements up until the correct location is found
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                    if (gui) {
                        SortingAnimation.instance().showArray(array, 50);
                    }
                    count++;
                }

                // Place the temp at its correct location
                array[j] = temp;
            }

            // Reduce the gap
            gap /= 3;
        }

        LOG.info("Took {} comparisons to sort the input array", count);
        return array;
    }

    public static void main(String[] args) {
        int[] numbers = getShuffledNumbers(50);
        ShellSort.gui = true;
        LOG.info("Array: {}", numbers);
        int[] test = sort(numbers);
        LOG.info("Array: {}", test);


        /*testTime();*/
    }

    public static void testTime() {
        SelectionSort.gui = false;
        int[] numArray = {100_000, 200_000, 400_000, 800_000, 1_600_000};
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
2025-04-08 17:35:28.726 [main] INFO  c.h.a.s.a1.ShellSort - Took 2883060 comparisons to sort the input array
2025-04-08 17:35:28.760 [main] INFO  c.h.a.s.a1.ShellSort - Took 2853714 comparisons to sort the input array
2025-04-08 17:35:28.782 [main] INFO  c.h.a.s.a1.ShellSort - Took 2983056 comparisons to sort the input array
2025-04-08 17:35:28.792 [main] INFO  c.h.a.s.a1.ShellSort - Took 2945057 comparisons to sort the input array
2025-04-08 17:35:28.803 [main] INFO  c.h.a.s.a1.ShellSort - Took 2864997 comparisons to sort the input array
2025-04-08 17:35:28.811 [main] INFO  c.h.a.s.a1.ShellSort - Took 2936193 comparisons to sort the input array
2025-04-08 17:35:28.811 [main] INFO  c.h.a.s.a1.ShellSort - For 100000 elements it took on average 8ms
2025-04-08 17:35:28.844 [main] INFO  c.h.a.s.a1.ShellSort - Took 7058111 comparisons to sort the input array
2025-04-08 17:35:28.870 [main] INFO  c.h.a.s.a1.ShellSort - Took 7227315 comparisons to sort the input array
2025-04-08 17:35:28.899 [main] INFO  c.h.a.s.a1.ShellSort - Took 7158173 comparisons to sort the input array
2025-04-08 17:35:28.917 [main] INFO  c.h.a.s.a1.ShellSort - Took 6981390 comparisons to sort the input array
2025-04-08 17:35:28.951 [main] INFO  c.h.a.s.a1.ShellSort - Took 7287212 comparisons to sort the input array
2025-04-08 17:35:28.969 [main] INFO  c.h.a.s.a1.ShellSort - Took 7622566 comparisons to sort the input array
2025-04-08 17:35:28.969 [main] INFO  c.h.a.s.a1.ShellSort - For 200000 elements it took on average 19ms
2025-04-08 17:35:29.030 [main] INFO  c.h.a.s.a1.ShellSort - Took 17558003 comparisons to sort the input array
2025-04-08 17:35:29.078 [main] INFO  c.h.a.s.a1.ShellSort - Took 18672487 comparisons to sort the input array
2025-04-08 17:35:29.145 [main] INFO  c.h.a.s.a1.ShellSort - Took 17089700 comparisons to sort the input array
2025-04-08 17:35:29.201 [main] INFO  c.h.a.s.a1.ShellSort - Took 16646771 comparisons to sort the input array
2025-04-08 17:35:29.249 [main] INFO  c.h.a.s.a1.ShellSort - Took 17230078 comparisons to sort the input array
2025-04-08 17:35:29.313 [main] INFO  c.h.a.s.a1.ShellSort - Took 15880334 comparisons to sort the input array
2025-04-08 17:35:29.313 [main] INFO  c.h.a.s.a1.ShellSort - For 400000 elements it took on average 44ms
2025-04-08 17:35:29.439 [main] INFO  c.h.a.s.a1.ShellSort - Took 37605685 comparisons to sort the input array
2025-04-08 17:35:29.582 [main] INFO  c.h.a.s.a1.ShellSort - Took 39727997 comparisons to sort the input array
2025-04-08 17:35:29.725 [main] INFO  c.h.a.s.a1.ShellSort - Took 37867431 comparisons to sort the input array
2025-04-08 17:35:29.868 [main] INFO  c.h.a.s.a1.ShellSort - Took 39540048 comparisons to sort the input array
2025-04-08 17:35:30.215 [main] INFO  c.h.a.s.a1.ShellSort - Took 39862733 comparisons to sort the input array
2025-04-08 17:35:30.372 [main] INFO  c.h.a.s.a1.ShellSort - Took 40660226 comparisons to sort the input array
2025-04-08 17:35:30.372 [main] INFO  c.h.a.s.a1.ShellSort - For 800000 elements it took on average 92ms
2025-04-08 17:35:30.799 [main] INFO  c.h.a.s.a1.ShellSort - Took 97340264 comparisons to sort the input array
2025-04-08 17:35:31.147 [main] INFO  c.h.a.s.a1.ShellSort - Took 91363895 comparisons to sort the input array
2025-04-08 17:35:31.507 [main] INFO  c.h.a.s.a1.ShellSort - Took 93889380 comparisons to sort the input array
2025-04-08 17:35:31.841 [main] INFO  c.h.a.s.a1.ShellSort - Took 96315603 comparisons to sort the input array
2025-04-08 17:35:32.125 [main] INFO  c.h.a.s.a1.ShellSort - Took 92568149 comparisons to sort the input array
2025-04-08 17:35:32.533 [main] INFO  c.h.a.s.a1.ShellSort - Took 96134884 comparisons to sort the input array
2025-04-08 17:35:32.533 [main] INFO  c.h.a.s.a1.ShellSort - For 1600000 elements it took on average 222ms
*/