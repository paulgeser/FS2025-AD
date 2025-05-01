/*
 * Copyright 2025 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.sw11.exercise.n4.quicksort;

import ch.hslu.ad.n41.array.init.RandomInitTask;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Vergleich von verschiedenen Quicksort-Implementationen.
 */
public final class DemoQuicksort {

    private static final Logger LOG = LoggerFactory.getLogger(DemoQuicksort.class);

    /**
     * Privater Konstruktor.
     */
    private DemoQuicksort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int numberOfRuns = 5;
        final int size = 200_000_000;
        final int[] arrayOriginal = new int[size];
        try (final ForkJoinPool pool = new ForkJoinPool()) {
            long totalTime, startTime, endTime;
            RandomInitTask initTask = new RandomInitTask(arrayOriginal, 100);
            pool.invoke(initTask);


            totalTime = 0;
            for (int i = 0; i <= numberOfRuns; i++) {
                int[] arrayTask = Arrays.copyOf(arrayOriginal, size);
                startTime = System.nanoTime();
                final QuicksortTask sortTask = new QuicksortTask(arrayTask);
                pool.invoke(sortTask);
                endTime = System.nanoTime();
                if (i != 0) {
                    totalTime += (endTime - startTime) / 1000000L;
                }
            }
            LOG.info("QuicksortTask  : {} msec.", totalTime / numberOfRuns);

/*

            totalTime = 0;
            for (int i = 0; i <= numberOfRuns; i++) {
                int[] arrayRec = Arrays.copyOf(arrayOriginal, size);
                startTime = System.nanoTime();
                QuicksortRecursive.quicksort(arrayRec);
                endTime = System.nanoTime();
                if (i != 0) {
                    totalTime += (endTime - startTime) / 1000000L;
                }
            }
            LOG.info("QuicksortRec.  : {} msec.", totalTime / numberOfRuns);


            totalTime = 0;
            for (int i = 0; i <= numberOfRuns; i++) {
                int[] arraySort = Arrays.copyOf(arrayOriginal, size);
                startTime = System.nanoTime();
                Arrays.sort(arraySort);
                endTime = System.nanoTime();
                if (i != 0) {
                    totalTime += (endTime - startTime) / 1000000L;
                }
            }
            LOG.info("Arrays.sort    : {} msec.", totalTime / numberOfRuns);
*/


        } finally {
            // Executor shutdown
        }
    }
}
