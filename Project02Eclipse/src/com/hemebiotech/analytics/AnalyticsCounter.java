package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
        private static int symptomNbr = 0;

	public static void main(String args[]) throws Exception {
            //final String FILE_SYMPTOMS_PATH = "C:\\Users\\ydiouy\\formation_java\\2_debug_java\\Project02Eclipse\\symptoms.txt";
            final String FILE_SYMPTOMS_PATH = "ressources/symptoms.txt";
            
            Map<String,Integer> symptoms = new HashMap<String,Integer>();

            try {
                // first get input
                FileReader fileReader = new FileReader(FILE_SYMPTOMS_PATH);
		BufferedReader reader = new BufferedReader (fileReader);
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;
		while (line != null) {
                    System.out.println(line);
                    i++;
                    System.out.println("symptom from file: " + line);

                    if (symptoms.get(line) != null) {
                        int count = symptoms.get(line);
                        symptoms.put(line, count);
                    }

                    line = reader.readLine();
		}
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
		
            try {
                // next generate output
                FileWriter writer = new FileWriter ("result.out");
                BufferedWriter bufferedwriter = new BufferedWriter(writer);
                
                // Boucler sur symptoms pour afficher le nombre de chaques symptomes réferencés
                bufferedwriter.write("headache: " + headacheCount + "\n");
                bufferedwriter.write("rash: " + rashCount + "\n");
                bufferedwriter.write("dialated pupils: " + pupilCount + "\n");
                bufferedwriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
	}
}
