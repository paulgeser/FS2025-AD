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
package ch.hslu.ad.sw07.exercise.n3.prime;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * 100 grosse Primzahlen finden.
 */
public final class PrimeCheck {

    private static final Logger LOG = LoggerFactory.getLogger(PrimeCheck.class);
    private static final AtomicInteger count = new AtomicInteger(0);
    private static final int numberOfThreads = Runtime.getRuntime().availableProcessors();

    /**
     * Privater Konstruktor.
     */
    private PrimeCheck() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        final Callable<BigInteger> primeTask = () -> {
            boolean foundPrime = false;
            BigInteger bi = null;
            while (!foundPrime) {
                bi = new BigInteger(1024, new Random());
                if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                    count.getAndIncrement();
                    foundPrime = true;
                    LOG.info("Found prime number ({})", count.get());
                }
            }
            return bi;
        };

        final int wantedPrimeNumbers = 100;
        List<Future<BigInteger>> list = new ArrayList<>();
        while (count.get() < wantedPrimeNumbers) {
            try (final ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads)) {

                for (int i = 0; i < wantedPrimeNumbers - count.get(); i++) {
                    Future<BigInteger> task = executor.submit(primeTask);
                    list.add(task);
                }

                LOG.info("{}", count.get());
                executor.shutdown();

                for (Future<BigInteger> task : list) {
                    task.get();
                }
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
