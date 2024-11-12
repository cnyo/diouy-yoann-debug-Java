package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class grouping methods for reading a symptom file, counting them and writing
 * the result to a file
 * 
 */
public class AnalyticsCounter {
        private ISymptomReader reader;
        private ISymptomWriter writer;

        /**
         * 
         * @param reader Class reading file with symptom strings in it
         * @param writer class writing to a file the total number per symptom occurring, line by line
         */
        public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
                this.reader = reader;
                this.writer = writer;
        }

        /**
         * 
         * @return return a List of symptom names
         */
        public List<String> getSymptoms() {
                return reader.getSymptoms();
        }

        /**
         * 
         * @param symptoms a List of symptom names
         * @return return a map with total for each symptom
         */ 
        public Map<String, Integer> countSymptoms(List<String> symptoms) {
                Map<String, Integer> mapSymptoms = new HashMap<String, Integer>();

                for (String symptomName : symptoms) {
                        int symptomCount = 1;

                        if (mapSymptoms.containsKey(symptomName)) {
                                symptomCount = mapSymptoms.get(symptomName);
                                symptomCount++;
                        }
                        mapSymptoms.put(symptomName, symptomCount);
                }

                return mapSymptoms;
        }


        /**
         * Sorts a Map
         * 
         * @param symptoms a Map with total for each symptom
         * @return return a Map sorted alphabetically
         */
        public Map<String, Integer> sortSymptoms (Map<String, Integer> symptoms) {
                TreeMap<String, Integer> sortedSymptoms = new TreeMap<String, Integer>(symptoms);

                return sortedSymptoms;
        }

        /**
         * write the result of the symptom count to a file
         * 
         * @param symptoms a Map with total for each symptom
         */
        public void writeSymptoms (Map<String, Integer> symptoms) {
                this.writer.writeSymptoms(symptoms);
        }
}
