package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collection;

public class AnalyticsCounter {
    ISymptomReader reader;
    ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }
        
    public List<String> getSymptoms() {
        List<String> symptoms = new ArrayList<String>();
        
        try {
            BufferedReader reader = new BufferedReader (new FileReader("../symptoms.txt"));
            String line = reader.readLine();

            while (line != null) {
                System.out.println("symptom from file: " + line);

                symptoms.add(line);

                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return symptoms;
    }
        
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> mapSymptoms = new HashMap<String, Integer>();
        
        int symptomCount = 1;
        for (int i = 0; i < symptoms.size(); i++) {
            String symptomName = symptoms.get(i);
            
            if (mapSymptoms.containsKey(symptomName)) {
                symptomCount = mapSymptoms.get(symptomName);
                symptomCount++;
            }
            mapSymptoms.put(symptomName, symptomCount);
            
            System.out.println("symptom from file: " + symptomName);
            System.out.println("number of " + symptomName + " : " + mapSymptoms.get(symptomName));
        }
        
        return mapSymptoms;
    }
        
        
    public Map<String, Integer> sortSymptoms (Map<String, Integer> symptoms) {
        Map<String, Integer> sortedSymptoms = new HashMap<String, Integer>(); 
        
        ArrayList<String> symptomNames = new ArrayList<String>(symptoms.keySet());
        symptomNames.sort(null);
        for (int i = 0; i < symptomNames.size(); i++) {
            String symptomName = symptomNames.get(i);
            sortedSymptoms.put(symptomName, symptoms.get(symptomName));
        }
        
        return sortedSymptoms;
    }

    public void writeSymptoms (Map<String, Integer> symptoms) {
        this.writer.writeSymptoms(symptoms);
    }
}
