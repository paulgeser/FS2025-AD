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
package ch.hslu.ad.n12.blackhole;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Der Versuch einer Demonstration eines schwarzen Loches
 */
public final class DemoBlackhole {

    private static final Logger LOG = LoggerFactory.getLogger(DemoBlackhole.class);

    /**
     * Privater Konstruktor.
     */
    private DemoBlackhole() {
    }
    
    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        final BlackHole blackhole = new BlackHole();
        LOG.info("Threads starts...");
        new Thread(() -> {
            try {
                LOG.info(blackhole.get());
            } catch (InterruptedException ex) {
                LOG.debug(ex.getMessage());
            }
        }, "Blackhole 'getter' thread").start();
        new Thread(() -> {
            blackhole.put("Sonne, Licht, irgendetwas...");
        }, "Blackhole 'putter' thread").start();
    }
}
