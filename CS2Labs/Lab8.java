/* Mary Vu
[CS2401 - FA23]
This work is to be done individually. It is not permitted to share, reproduce, or alter any part of this
assignment for any purpose. Students are not permitted from sharing code, uploading this
assignment online in any form, or viewing/receiving/modifying code written from anyone else. This
assignment is part of an academic course at The University of Texas at El Paso and a grade will be
assigned for the work produced individually by the student. */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Lab8_Vu {

    /**
     * Loads earthquakes from a CSV file into the binary search tree.
     * Notice that the BST is a global variable declared in this file (bsTree)
     * @param filename the path to the CSV file
     */
    public static void loadFromCSV (String filename){
        String line;
        String splitBy = ",";

        try{
            BufferedReader readCSV = new BufferedReader(new FileReader(filename));
            readCSV.readLine();


            while((line = readCSV.readLine()) != null){
                String[] earthquakeData = line.split(splitBy);
                    Double magnitude = Double.valueOf(earthquakeData[4]);
                    String date = earthquakeData[0];
                    String place = earthquakeData[13];
                    Earthquake eq = new Earthquake(magnitude, place, date);
                    bsTree.add(eq);
            }
        }catch(Exception e){
            System.out.println("error reading file: " + e.getMessage());
        }
    }


    /***************************************************************************
     * Don't modify anything below this line
     */
    private static EarthquakeBinarySearchTree bsTree;

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        //Initialize the binary search tree (will be empty)
        bsTree = new EarthquakeBinarySearchTree();

        //Load default data to the BSTree
        loadFromCSV("earthquakes.csv");

        System.out.println();
        int choice;

        do {

            System.out.println("----- Earthquake Menu -----");
            System.out.println("1. Add to BSTree");
            System.out.println("2. Search by magnitude");
            System.out.println("3. Display tree (asc)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addToBSTree();
                    break;
                case 2:
                    searchByMagnitude();
                    break;
                case 3:
                    bsTree.display();
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
            }
        } while (choice != 5);

    }

    private static void addToBSTree() {
        
        System.out.println("Enter earthquake data (magnitude, place, date):");
        System.out.print("Magnitude: " );
        double magnitude = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("place: " );
        String place = scanner.nextLine();
        System.out.print("date: " );
        String date = scanner.nextLine();
        Earthquake eq = new Earthquake(magnitude, place, date);
        bsTree.add(eq);
        System.out.println("Earthquake added to the tree.");
    }

    private static void searchByMagnitude() {
        
        System.out.println("Enter the magnitude to search for:");
        double magnitude = scanner.nextDouble();
        Earthquake result = bsTree.search(magnitude);
        if (result != null) {
            System.out.println("Earthquake found: [" + result.getMagnitude() + " || " + result.getPlace() + " || " + result.getDate() + "]");
        } else {
            System.out.println("No earthquake with the given magnitude found.");
        }
    }

}
