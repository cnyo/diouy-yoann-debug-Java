package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ISymptomReader implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
        private String filepath;

        /**
         * 
         * @param filepath a full or partial path to file with symptom strings in it, one per line
         */
        public ReadSymptomDataFromFile (String filepath) {
                 this.filepath = filepath;
        }

        /**
         * If no data is available, return an empty List
         * 
         * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
         */
        @Override
        public List<String> getSymptoms() {
                ArrayList<String> result = new ArrayList<String>();

                if (filepath != null) {
                        try (BufferedReader reader = new BufferedReader (new FileReader(filepath))) {
                                String line = reader.readLine();

                                while (line != null) {
                                    result.add(line);
                                    line = reader.readLine();
                                }
                        } catch (IOException e) {
                                 e.printStackTrace();
                        }
                }

                return result;
        }
}