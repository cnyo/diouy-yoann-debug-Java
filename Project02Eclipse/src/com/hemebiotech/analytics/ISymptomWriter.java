package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data into a file
 * 
 */
public interface ISymptomWriter {
    /**
     * Write symptoms in result file
     */
    void writeSymptoms (Map<String, Integer> symptoms);
}
