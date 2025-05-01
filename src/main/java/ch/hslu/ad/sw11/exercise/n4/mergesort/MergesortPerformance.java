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
package ch.hslu.ad.sw11.exercise.n4.mergesort;

import ch.hslu.ad.n41.array.init.RandomInitTask;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Performance Vergleich der Mergesort Implementationen.
 */
public final class MergesortPerformance {

    private static final Logger LOG = LoggerFactory.getLogger(MergesortPerformance.class);

    /**
     * Privater Konstruktor.
     */
    private MergesortPerformance() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int numberOfRuns = 5;
        final int size = 300_000_000;
        final int[] arrayOriginal = new int[size];
        try (final ForkJoinPool pool = new ForkJoinPool()) {
            long totalTime, startTime, endTime;
            RandomInitTask initTask = new RandomInitTask(arrayOriginal, 100);
            pool.invoke(initTask);
            int[] array;

/*            totalTime = 0;
            for (int i = 0; i <= numberOfRuns; i++) {
                array = Arrays.copyOf(arrayOriginal, size);
                startTime = System.nanoTime();
                final MergesortTask sortTask = new MergesortTask(array);
                pool.invoke(sortTask);
                endTime = System.nanoTime();
                if (i != 0) {
                    totalTime += (endTime - startTime) / 1000000L;
                }
            }
            LOG.info("Conc. Mergesort avg. : {} msec.", totalTime / numberOfRuns);*/
/*

            totalTime = 0;
            for (int i = 0; i <= numberOfRuns; i++) {
                array = Arrays.copyOf(arrayOriginal, size);
                startTime = System.nanoTime();
                MergesortRecursive.mergeSort(array);
                endTime = System.nanoTime();
                if (i != 0) {
                    totalTime += (endTime - startTime) / 1000000L;
                }
            }
            LOG.info("MergesortRec. avg.   : {} msec.", totalTime / numberOfRuns);
*/
            totalTime = 0;
            for (int i = 0; i <= numberOfRuns; i++) {
                array = Arrays.copyOf(arrayOriginal, size);
                startTime = System.nanoTime();
                Arrays.parallelSort(array);
                endTime = System.nanoTime();
                if (i != 0) {
                    totalTime += (endTime - startTime) / 1000000L;
                }
            }
            LOG.info("ParallelSort avg.   : {} msec.", totalTime / numberOfRuns);
        } finally {
            // Executor shutdown
        }
    }
}
