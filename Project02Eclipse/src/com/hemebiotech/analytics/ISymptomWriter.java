package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * Anything that will write symptom data into a file
 * 
 */
public interface ISymptomWriter {
        /**
         * Write the result by symptom in a file
         * 
         * @param symptoms a Map with total for each symptom
         * @param filePath a full or partial path to the destination file for the symptom count result, one per line
         * @throws IOException 
         */
        void writeSymptoms (Map<String, Integer> symptoms, String filePath) throws IOException;
}
