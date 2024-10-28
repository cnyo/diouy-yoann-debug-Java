package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    final static String FILE_SYMPTOMS_PATH = "../symptoms.txt";
    
    public static void main(String args[]) throws Exception {
        ISymptomReader reader = new ReadSymptomDataFromFile(FILE_SYMPTOMS_PATH);
        ISymptomWriter writer = new WriteSymptomDataFromFile();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
        
        List<String> listSymptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> mapSymptoms = analyticsCounter.countSymptoms(listSymptoms);
        mapSymptoms = analyticsCounter.sortSymptoms(mapSymptoms);
        
        analyticsCounter.writeSymptoms(mapSymptoms);
    }
}
