package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * ISymptomWriter implementation
 *
 */
public class WriteSymptomDataFromFile implements ISymptomWriter {	
	
        /**
         * Write the result by symptom in a file
         * 
         * @param symptoms a Map with total for each symptom
         * @param filePath a full or partial path to the destination file for the symptom count result, one per line
         * @throws IOException 
         */
        @Override
        public void writeSymptoms(Map<String, Integer> symptoms, String filePath) throws IOException {
                FileWriter writer = new FileWriter (filePath);

                try {
                        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                            writer.write(entry.getKey() + " : " + entry.getValue() + "\n"); 
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                } finally {
                        writer.close();
                }
        }
}
