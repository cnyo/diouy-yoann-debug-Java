package com.hemebiotech.analytics;

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
         */
        void writeSymptoms (Map<String, Integer> symptoms);
}
