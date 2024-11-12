package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * ISymptomWriter implementation
 *
 */
public class WriteSymptomDataFromFile implements ISymptomWriter {

        private String filepath;

        /**
         *
         * @param filepath a full or partial path to the destination file for the symptom count result, one per line
         */
        public WriteSymptomDataFromFile (String filepath) {
                this.filepath = filepath;
        }

        /**
         * Write the result by symptom in a file
         * 
         * @param symptoms a Map with total for each symptom
         */
        @Override
        public void writeSymptoms(Map<String, Integer> symptoms) {
                try (FileWriter writer = new FileWriter(filepath)) {
                        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                                writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
                        }
                } catch (IOException ioe) {
                        ioe.printStackTrace();
                }
        }
}
