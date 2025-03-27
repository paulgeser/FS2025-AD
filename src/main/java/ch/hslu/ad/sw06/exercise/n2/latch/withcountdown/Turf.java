/*
 * Copyright 2025 Hochschule Luzern - Informatik.
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
package ch.hslu.ad.sw06.exercise.n2.latch.withcountdown;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * Eine Rennbahn für das Pferderennen.
 */
public final class Turf {

    private static final Logger LOG = LoggerFactory.getLogger(Turf.class);
    private static final int HORSES = 5;
    private static final CountDownLatch signalReady = new CountDownLatch(HORSES);
    private static final CountDownLatch signalStart = new CountDownLatch(1);


    /**
     * Privater Konstruktor.
     */
    private Turf() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) throws InterruptedException {
        for (int i = 1; i <= HORSES; i++) {
            Thread.startVirtualThread(new RaceHorse(signalReady, signalStart, "Horse " + i));
        }


        // Wait until all horses are ready
        signalReady.await();
        LOG.info("All horses are ready! Race starts NOW!");

        // Signal the race to start
        signalStart.countDown();
    }
}
