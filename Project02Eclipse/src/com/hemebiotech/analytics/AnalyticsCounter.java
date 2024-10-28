package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
    ISymptomReader reader;
    ISymptomWriter writer;
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
        public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
            this.reader = reader;
            this.writer = writer;
        }
        
        public List<String> getSymptoms() {
            try {
                List<String> symptoms = new ArrayList<String>();
                BufferedReader reader = new BufferedReader (new FileReader("../symptoms.txt"));
                String line = reader.readLine();

                while (line != null) {
                    System.out.println("symptom from file: " + line);

                    symptoms.add(line);

                    line = reader.readLine();
                }

                reader.close();
                
                return symptoms;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        public Map<String, Integer> countSymptoms(List<String> symptoms) {
            try {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
        public Map<String, Integer> sortSymptoms (Map<String, Integer> symptoms) {
            ArrayList<String> symptomNames = new ArrayList<String>(symptoms.keySet());
            ArrayList<String> sortedSymptomNames = Collection.sort(symptomNames);
            Map<String, Integer> sortedSymptoms = new HashMap<String, Integer>(); 

            for (i = 0; i < sortedSymptomNames.length(); i++) {
                String symptomName = sortedSymptomNames.get(i);
                sortedSymptoms.put(symptomName, symptoms.get(symptomName));
            }
            
            return sortedSymptoms;
        }
        
        public void writeSymptoms (Map<String, Integer> symptoms) {
            this.writer.writeSymptoms(symptoms);
        }
        
	public static void main(String args[]) throws Exception {
            
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("../symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
                                headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.equals("dialated pupils")) {
				pupilCount++;
			}

			line = reader.readLine();
		}
		
                WriteSymptomDataFromFile symptomWriter = new WriteSymptomDataFromFile(); 
                symptomWriter.writeSymptoms();
                        
		// next generate output
		/*FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();*/
	}
}
