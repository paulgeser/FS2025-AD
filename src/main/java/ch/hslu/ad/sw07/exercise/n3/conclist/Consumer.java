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

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * Konsument, der soviele Integer Werte aus einer Liste liest, wie er nur kann.
 */
public final class Consumer implements Callable<Long> {

    private final List<Integer> list;
    private final BlockingQueue<Integer> queue;

    /**
     * Erzeugt einen Konsumenten, der soviel Integer-Werte ausliest, wie er nur
     * kann.
     *
     * @param list Queue zum Lesen der Integer-Werte.
     */
    public Consumer(final List<Integer> list) {
        this.list = list;
        this.queue = null;
    }

    public Consumer(final BlockingQueue<Integer> queue) {
        this.list = null;
        this.queue = queue;
    }


    /**
     * Liefert die Summe aller ausgelesener Werte.
     *
     * @return Summe.
     * @throws java.lang.Exception falls Ausnahmen passieren.
     */
    @Override
    public Long call() throws Exception {
        if (list != null) {
            long sum = 0;
            Iterator<Integer> iterable = list.iterator();
            while (iterable.hasNext()) {
                sum += iterable.next();
            }
            return sum;
        } else if (queue != null) {
            long sum = 0;
            Iterator<Integer> iterable = queue.iterator();
            while (iterable.hasNext()) {
                sum += iterable.next();
            }
            return sum;
        }
        throw new RuntimeException("Neither a list or queue exists!");
    }
}
