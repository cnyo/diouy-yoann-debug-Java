package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * main class calling all application methods
 * 
 */
public class Main {
        final static String FILE_SYMPTOMS_PATH = "resources/symptoms.txt";
        final static String FILE_OUT_PATH = "result.out";

        /**
         * 
         * @param args
         */
        public static void main(String args[]) {
                ISymptomReader reader = new ReadSymptomDataFromFile(FILE_SYMPTOMS_PATH);
                ISymptomWriter writer = new WriteSymptomDataFromFile(FILE_OUT_PATH);
                AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

                List<String> listSymptoms = analyticsCounter.getSymptoms();
                Map<String, Integer> mapSymptoms = analyticsCounter.countSymptoms(listSymptoms);
                mapSymptoms = analyticsCounter.sortSymptoms(mapSymptoms);

                analyticsCounter.writeSymptoms(mapSymptoms);
        }
}
