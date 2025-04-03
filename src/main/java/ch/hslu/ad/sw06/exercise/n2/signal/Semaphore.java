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
package ch.hslu.ad.sw06.exercise.n2.signal;

/**
 * Ein nach oben begrenztes Semaphor. Der Semaphorenzähler kann nicht unendlich
 * wachsen.
 */
public final class Semaphore {

    private int sema; // Semaphorenzähler
    private int count; // Anzahl der wartenden Threads.
    private int limit; // maximum an möglichen Semaphoren
    private static final int DEFAULT_LIMIT = Integer.MAX_VALUE;

    /**
     * Erzeugt ein Semaphore mit 0 Passiersignalen.
     */
    public Semaphore() {
        this(0);
    }

    /**
     * Erzeugt ein Semaphore mit einem Initalwert für den Semaphorenzähler.
     *
     * @param permits Anzahl Passiersignale zur Initialisierung.
     * @throws IllegalArgumentException wenn der Initalwert negativ ist.
     */
    public Semaphore(final int permits) throws IllegalArgumentException {
        if (permits < 0) {
            throw new IllegalArgumentException(permits + " < 0");
        }
        this.sema = permits;
        this.count = 0;
        this.limit = DEFAULT_LIMIT;
    }

    /**
     * Erzeugt ein nach oben begrenztes Semaphore.
     *
     * @param permits Anzahl Passiersignale zur Initialisierung.
     * @param limit   maximale Anzahl der Passiersignale.
     * @throws IllegalArgumentException wenn Argumente ungültige Werte besitzen.
     */
    public Semaphore(final int permits, final int limit) throws IllegalArgumentException {
        if (permits < 0 || limit < 0) {
            throw new IllegalArgumentException("Neither permits or limit can have a value below 0");
        } else if (permits > limit) {
            throw new IllegalArgumentException("Permits can not be greater than the limit");
        }
        this.sema = permits;
        this.limit = limit;
        this.count = 0;
    }

    /**
     * Entspricht dem P() Eintritt (Passieren) in einen synchronisierten
     * Bereich, wobei mitgezählt wird, der wievielte Eintritt es ist. Falls der
     * Zähler null ist wird der Aufrufer blockiert.
     *
     * @throws java.lang.InterruptedException falls das Warten unterbrochen
     *                                        wird.
     */
    public synchronized void acquire() throws InterruptedException {
        while (sema == 0) {
            count++;
            this.wait();
            count--;
        }
        sema--;
    }

    /**
     * Entspricht dem P() Eintritt (Passieren) in einen synchronisierten
     * Bereich, wobei mitgezählt wird, der wievielte Eintritt es ist.Falls der
     * Zähler null ist wird der Aufrufer blockiert.
     *
     * @param permits Anzahl Passiersignale zum Eintritt.
     * @throws java.lang.InterruptedException falls das Warten unterbrochen
     *                                        wird.
     */
    public synchronized void acquire(final int permits) throws InterruptedException {
        if (permits < 1) {
            throw new IllegalArgumentException("Can not aquire semaphore less than 1");
        } else if (permits > limit) {
            throw new ArithmeticException("Requested permits exceeds the possible semaphore limit");
        }
        while (sema == 0 || permits > sema) {
            count += permits;
            this.wait();
            count -= permits;
        }
        sema -= permits;
    }

    /**
     * Entspricht dem V() Verlassen (Freigeben) eines synchronisierten
     * Bereiches, wobei ebenfalls mitgezählt wird, wie oft der Bereich verlassen
     * wird.
     */
    public synchronized void release() {
        sema++;
        this.notifyAll();
    }

    /**
     * Entspricht dem V() Verlassen (Freigeben) eines synchronisierten
     * Bereiches, wobei mitgezählt wird, wie oft der Bereich verlassen wird.
     *
     * @param permits Anzahl Passiersignale zur Freigabe.
     */
    public synchronized void release(final int permits) {
        if (permits < 1) {
            throw new IllegalArgumentException("Can not release semaphore less than 1");
        } else if ((sema + permits) > limit) {
            throw new ArithmeticException("Requested releases of permits exceeds the possible semaphore limit");
        }
        sema += permits;
        this.notifyAll();
    }

    /**
     * Lesen der Anzahl wartenden Threads.
     *
     * @return Anzahl wartende Threads.
     */
    public synchronized int pending() {
        return count;
    }
}
