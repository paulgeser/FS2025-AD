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
package ch.hslu.ad.sw06.exercise.n2.latch;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Eine Rennbahn für das Pferderennen.
 */
public final class Turf {

    private static final Logger LOG = LoggerFactory.getLogger(Turf.class);
    private static final int HORSES = 5;

    /**
     * Privater Konstruktor.
     */
    private Turf() {
    }

    /**
     * Main-Demo.
     * @param args not used.
     */
    public static void main(final String[] args) throws InterruptedException {
        // Synch starter box erstellen
        final Synch starterBox = new Latch();
        // Threads starten für alle Pferde
        for (int i = 1; i <= HORSES; i++) {
            Thread.startVirtualThread(new RaceHorse(starterBox, "Horse " + i));
        }
        // Warten bis sicher alle Pferde bereit sind zum laufen.
        Thread.sleep(1000);

        LOG.info("Start...");
        // Starte alle Pferde
        starterBox.release();

        // Warte 4 Sekunden das Pferde Zeit haben ins Ziel zu laufen
        Thread.sleep(4000);
        // Sleep nötig, weil wenn Main terminiert, tun das auch alle virtuellen Threads
    }
}
