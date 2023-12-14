
/* MARY VU
[CS2401 - FA23]
This work is to be done individually. It is not permitted to share, reproduce, or alter any part of this
assignment for any purpose. Students are not permitted from sharing code, uploading this
assignment online in any form, or viewing/receiving/modifying code written from anyone else. This
assignment is part of an academic course at The University of Texas at El Paso and a grade will be
assigned for the work produced individually by the student. */
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AsteroidLinkedList_Vu {

    Asteroid head = null;

    /**
     * Constructor to create and add one element to the linked list
     * 
     * @param newHead This asteroid will be the first element of the list (head)
     */
    AsteroidLinkedList(Asteroid newHead) {
        head = newHead;
    }

    /**
     * Default constructor
     */
    AsteroidLinkedList() {
        head = null;
    }

    /**
     * Computes the average mass of all asteroids in the list. (This is a helper
     * function to compute the average)
     * 
     * @return A double representing the average mass, if list is empty then it
     *         returns 0.0
     */
    public double getAverageMass() {
        Asteroid currentAsteroid = head;
        double sum = 0.0;
        double size = 0.0;

        if(currentAsteroid == null){
            return 0.0;
        }

        while(currentAsteroid != null){
            sum += currentAsteroid.getMass();
            size += 1;
            currentAsteroid = currentAsteroid.next;
        }
        return sum/size;
    }

    /**
     * This method computes the size in the list. Notice the modifier (private) -
     * Recursive method 
     * 
     * @param current An object to analyze in the list
     * @return
     */
    private int sizeRecursive(Asteroid current) {
        if(current.next == null){
            return 1;
        }

        return 1 + sizeRecursive(current.next);
    }

    /**
     * This method computes the sum of all the masses of the objects in the list.
     * Notice the modifier (private) - Recursive method
     * 
     * @param current An object to analyze in the list
     * @return
     */
    private double computeMassSumRecursive(Asteroid current) {

        if(current == null){
            return 0.0;
        }
        return current.getMass() + computeMassSumRecursive(current.next);
    }
    
    /**
     * Returns an array that represents this linked list
     * @return
     */
    public Asteroid[] toArray(){
        String fileName = "input.txt";
        Asteroid[] asteroidArray = new Asteroid[linesinFile(fileName)];
        Asteroid currentAsteroid = head;

        for(int i = 0; i < asteroidArray.length; i++){
            if(currentAsteroid != null){
                asteroidArray[i] = currentAsteroid;
                currentAsteroid = currentAsteroid.next;
            }
        }
        return asteroidArray;
    }

    public static int linesinFile(String fileName){
        int count = 0;
        try{
          Scanner fileScanner = new Scanner(new File(fileName));
          while (fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            count++;
          }

        }catch (Exception e){
          System.out.println(
          "Error occured in counting number of rows.");
          e.printStackTrace();          
        }
        return count;
    }

    /**
     * *******************************************************************************************
     * Don't change anything below this line!
     */

    /**
     * Prints the Asteroid Linkedlist
     * given the head of the Asteroid LinkedList
     * 
     * @param head of the Asteroid LinkedList
     */

    public void printLL() {
        Asteroid currentAsteroid = head;

        while (currentAsteroid != null) {
            System.out.println(currentAsteroid.toString());
            currentAsteroid = currentAsteroid.next;
        }
    }

    /**
     * Fill the linked list with objects from a file
     * 
     * @param filename The file that contains objects
     */
    public void getAsteroidFromDataFile(String fileName) {

        Asteroid tail = null;
        try {

            File myObj = new File(fileName);

            Scanner scanFile = new Scanner(myObj);
            while (scanFile.hasNextLine()) {
                String scanLine = scanFile.nextLine();

                // For Splitting you need to use split("\t")
                String[] split_line = scanLine.split("\\t");

                // Storing the values in variables

                if (split_line.length >= 5) {
                    // Ensure there are at least 5 elements before accessing them
                    String name = split_line[0];
                    String discoverBy = split_line[1];
                    double diameter = Double.parseDouble(split_line[2]);
                    double mass = Double.parseDouble(split_line[3]);
                    int yearDiscovered = Integer.parseInt(split_line[4]);

                    Asteroid currentAsteroid = new Asteroid(name, discoverBy, diameter, mass, yearDiscovered);

                    if (head == null) {
                        head = currentAsteroid;
                        tail = head;
                    } else {
                        tail.next = currentAsteroid;
                        tail = tail.next;
                    }
                }
            }
            scanFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}