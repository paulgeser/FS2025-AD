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
package ch.hslu.ad.sw07.exercise.n3.conclist;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * Produzent, der eine maximale Anzahl Werte produziert und diese in eine Queue
 * speichert.
 */
public final class Producer implements Callable<Long> {

    private final List<Integer> list;
    private final BlockingQueue<Integer> queue;
    private final int maxRange;

    /**
     * Erzeugt einen Produzent, der eine bestimmte Anzahl Integer-Werte
     * produziert.
     *
     * @param list Queue zum Speichern der Integer-Werte.
     * @param max  Anzahl Integer-Werte.
     */
    public Producer(final List<Integer> list, final int max) {
        this.list = list;
        this.maxRange = max;
        this.queue = null;
    }

    public Producer(final BlockingQueue<Integer> list, final int max) {
        this.list = null;
        this.maxRange = max;
        this.queue = list;
    }

    /**
     * Liefert die Summe aller zusammengezählter Integer Werte.
     *
     * @return Summe.
     * @throws java.lang.Exception falls Ausnahmen passieren.
     */
    @Override
    public Long call() throws Exception {
        if (list != null) {
            long sum = 0;
            for (int i = 0; i < maxRange; i++) {
                sum += i;
                list.add(i);
            }
            return sum;
        } else if (queue != null) {
            long sum = 0;
            for (int i = 0; i < maxRange; i++) {
                sum += i;
                queue.add(i);
            }
            return sum;
        }
        throw new RuntimeException("Neither a list or queue exists!");
    }

}
