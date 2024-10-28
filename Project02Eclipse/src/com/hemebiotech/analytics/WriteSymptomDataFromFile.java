package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataFromFile implements ISymptomWriter {	
	
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            FileWriter writer = new FileWriter ("result.out");
        
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
                writer.write(entry.getKey() + " : " + entry.getValue() + "\n"); 
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }

}
