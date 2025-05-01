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
package ch.hslu.ad.sw11.exercise.n4.findfile;

import java.io.File;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Codevorlage für eine Dateisuche.
 */
public final class FindFilePerformance {

    private static final Logger LOG = LoggerFactory.getLogger(FindFilePerformance.class);

    /**
     * Privater Konstruktor.
     */
    private FindFilePerformance() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        final String search = "find.me";
        final int numberOfRuns = 5;
        final File rootDir = new File(System.getProperty("user.home"));
        LOG.info(rootDir.getAbsolutePath());
        long totalTime, startTime, endTime;

        /*totalTime = 0;
        for (int i = 0; i <= numberOfRuns; i++) {
            //LOG.info("Start searching '{}' recurive in '{}'", search, rootDir);
            startTime = System.nanoTime();
            FindFile.findFile(search, rootDir);
            endTime = System.nanoTime();
            if (i != 0) {
                totalTime += (endTime - startTime) / 1000000L;
            }
        }
        LOG.info("Found in {} msec.", totalTime / numberOfRuns);*/

        totalTime = 0;
        for (int i = 0; i <= numberOfRuns; i++) {
            //LOG.info("Find '{}' concurrent in '{}'", search, rootDir);
            startTime = System.nanoTime();
            final FindFileTask root = new FindFileTask(search, rootDir);
            root.invoke();
            endTime = System.nanoTime();
            if (i != 0) {
                totalTime += (endTime - startTime) / 1000000L;
            }
        }
        LOG.info("Found in {} msec.", totalTime / numberOfRuns);
    }
}
