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
package ch.hslu.ad.sw06.exercise.n2.waitpool;

/**
 * Demonstration eines Wait-Pools.
 */
public final class DemoWaitPool {

    private static final Object LOCK = new Object();

    /**
     * Privater Konstruktor.
     */
    private DemoWaitPool() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn das warten unterbrochen wird.
     */
    public static void main(final String args[]) throws InterruptedException {
        // Neuen Task erstellen (mit Lock)
        final MyTask waiter = new MyTask(LOCK);
        // Starte neuen Task in Thread
        new Thread(waiter).start();
        // Pausiere aktuellen Thread für 1sek
        Thread.sleep(1000);
        // Wenn das übergebene Lock wieder frei ist
        synchronized (LOCK) {
            // Alle informieren, welche auch an dem Lock hängen
            LOCK.notifyAll();
        }
    }
}
