import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;

class testCSV{
	public static void main(String[] args){
		loadFromCSV("earthquakes.csv");
	}

	public static void loadFromCSV(String filename) {
    String line = "";
    String splitBy = ",";

    try {
        BufferedReader readCSV = new BufferedReader(new FileReader(filename));
        readCSV.readLine();

        while ((line = readCSV.readLine()) != null) {
            String[] earthquakeData = line.split(splitBy);
                Double magnitude = Double.valueOf(earthquakeData[4]);
                String date = earthquakeData[0];
               	String place = earthquakeData[13];
                System.out.println(magnitude + " " + place + " " + date);

                // Uncomment and complete the code for creating Earthquake objects
                // and adding them to your bsTree.
                // Earthquake eq = new Earthquake(magnitude, place, date);
                // bsTree.add(eq);
        }
        readCSV.close(); // Close the BufferedReader when done
    } catch (Exception e) {
        System.out.println("Error reading file: " + e.getMessage());
    }
	}
}