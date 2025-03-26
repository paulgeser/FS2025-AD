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
package ch.hslu.ad.n22.executor.virtual;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Demo eines virtuellen ThreadPool Executors. Dieser Executor liefert für jeden
 * neuen Task einen Thread.
 */
public final class DemoVirtualThreadPool {

    private static final Logger LOG = LoggerFactory.getLogger(DemoVirtualThreadPool.class);

    /**
     * Privater Konstruktor.
     */
    private DemoVirtualThreadPool() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try (final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int nTask = 1; nTask <= 4; nTask++) {
                final char ch = (char) (64 + nTask);
                final char chStop = 'X';
                executor.execute(() -> {
                    LOG.info("starts {}", ch);
                    for (int i = 0; i < 200; i++) {
                        System.out.print(ch);
                        if (ch == chStop && i == 100) {
                            //Thread.currentThread().stop(); // nur zur Demonstration!
                        }
                    }
                    System.out.println("");
                    LOG.info("finished {}", ch);
                });
            }
        } finally {
            LOG.info("shutdown");
        }
    }
}
