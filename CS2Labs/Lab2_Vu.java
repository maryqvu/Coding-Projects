
import java.io.File;
import java.util.Scanner;

public class Lab2_Vu {
    public static void main(String[] args) {
        
        // Create an array of Mountain objects
        String fileName = "mountains.txt";        
        Mountain[] allTheMountains = getMountainFromFile(fileName);

        System.out.println("-------------------------------");
        System.out.println("--------Printing the mountains (recursively)-------------");
        System.out.printf("%n");
        printArrayRecursively(allTheMountains, 0);
        System.out.println("--------------Tallest mountain-----------------");
        System.out.printf("%n");
        System.out.println(findTallestMountain(allTheMountains).toString());
        System.out.printf("%n");
        System.out.println("---------------3rd tallest mountain-----------------");
        System.out.printf("%n");
        System.out.println(find3rdTallestMountain(allTheMountains).toString());
        System.out.printf("%n");
        System.out.println("--------------Shorest mountain-----------------");
        System.out.printf("%n");
        System.out.println(findShortestMountain(allTheMountains).toString());
        System.out.printf("%n");
        System.out.println("--------------Mountain with earliest ascent-----------------");
        System.out.printf("%n");
        System.out.println(findMountainWithEarliestAscentYear(allTheMountains).toString());
        System.out.printf("%n");
        System.out.println("--------------Mountain with recent ascent-----------------");
        System.out.printf("%n");
        System.out.println(findMountainWithRecentAscentYear(allTheMountains).toString());
        System.out.printf("%n");
        System.out.println("--------------Year with the most ascents-----------------");
        System.out.printf("%n");
        findYearWithMostAscents(allTheMountains);
    }

    /**
     * Recursively prints the objects in an array.
     *
     * @param arr   The array of objects to print.
     * @param index The current index to process.
     */
    public static void printArrayRecursively(Object[] arr, int index) {
        if(index == arr.length){
            return;
        }
            System.out.println(arr[index]);
            System.out.printf("%n");
            System.out.printf("%n");
            printArrayRecursively(arr, index+1);
    }

    /**
     * Finds and returns the year with the most mountain ascents in an array of Mountain objects.
     *
     * @param mountains An array of Mountain objects to search for the year with the most ascents.
     */
    public static void findYearWithMostAscents(Mountain[] mountains) {
        int mostAscentYear = mountains[0].getYearFirstClimbed();
        int yearCount = 1;
        // Initialize with the count of the first element

        for (int i = 0; i < mountains.length; i++) {
            int count = 1; 
            for (int j = i + 1; j < mountains.length; j++) {
                if (mountains[i].getYearFirstClimbed() == mountains[j].getYearFirstClimbed()) {
                    count++;
                }
            }
            if (count > yearCount) {
                mostAscentYear = mountains[i].getYearFirstClimbed();
                yearCount = count;
            }
        }

        System.out.println("The year that has the most ascent is: " + mostAscentYear);
        System.out.println("It was ascended: " + yearCount + " times");
    }

    
    /**
     * Finds and returns the mountain with the most recdnt year of first ascent in
     * an array of Mountain objects.
     *
     * @param mountains An array of Mountain objects to search for the mountain
     *  with the recent ascent year.
     * @return The mountain with the recent year of first ascent found in the
     *  array, or null if the array is empty or null.
     */

    public static Mountain findMountainWithRecentAscentYear(Mountain[] mountains) {
        if(mountains == null){
            return null;
        }
        int recentYear = mountains[0].getYearFirstClimbed();
        Mountain recentMountain = mountains[0];
        for(int i = 0; i < mountains.length; i++){
            if(mountains[i].getYearFirstClimbed() > recentYear){
                recentYear = mountains[i].getYearFirstClimbed();
                recentMountain = mountains[i];
            }
        }
        return recentMountain;
    }

    /**
     * Finds and returns the mountain with the earliest year of first ascent in
     * an array of Mountain objects.
     *
     * @param mountains An array of Mountain objects to search for the mountain
     *  with the earliest ascent year.
     * @return The mountain with the earliest year of first ascent found in the
     *  array, or null if the array is empty or null.
     */
    
    public static Mountain findMountainWithEarliestAscentYear(Mountain[] mountains) {
        if(mountains == null){
            return null;
        }
        int earliestYear = mountains[0].getYearFirstClimbed();
        Mountain earliestMountain = mountains[0];
        for(int i = 0; i < mountains.length; i++){
            if(mountains[i].getYearFirstClimbed() < earliestYear){
                earliestYear = mountains[i].getYearFirstClimbed();
                earliestMountain = mountains[i];
            }
        }
        return earliestMountain;
    }


    /**
     * Finds and returns the smallest mountain in an array of Mountain objects
     * based on height.
     *
     * @param mountains An array of Mountain objects to search for the smallest
     *  mountain.
     * @return The smallest mountain found in the array, or null if the array is
     *  empty or null.
     */
    public static Mountain findShortestMountain(Mountain[] mountains) {
        if(mountains == null){
            return null;
        }
        double shortestHeight = mountains[0].getHeightInFeet();
        Mountain shortestMountain = mountains[0];
        for(int i = 0; i < mountains.length; i++){
            if(mountains[i].getHeightInFeet() < shortestHeight){
                shortestHeight = mountains[i].getHeightInFeet();
                shortestMountain = mountains[i];
            }
        }
        return shortestMountain;
    }


    /**
     * Finds and returns the tallest mountain in an array of Mountain objects.
     *
     * @param mountains An array of Mountain objects to search for the tallest
     *  mountain.
     * @return The tallest mountain found in the array, or null if the array is
     *  empty or null.
     */

    public static Mountain findTallestMountain(Mountain[] mountains) {
        if(mountains == null){
            return null;
        }
        double tallestHeight = mountains[0].getHeightInFeet();
        Mountain tallestMountain = mountains[0];
        for(int i = 0; i < mountains.length; i++){
            if(mountains[i].getHeightInFeet() > tallestHeight){
                tallestHeight = mountains[i].getHeightInFeet();
                tallestMountain = mountains[i];
            }
        }
        return tallestMountain;
    }

    /**
     * Finds and returns the 3rd tallest mountain in an array of Mountain objects.
     *
     * @param mountains An array of Mountain objects to search for the 3rd tallest
     *  mountain.
     * @return The 3rd tallest mountain found in the array, or null if the array is
     *  empty or null.
     */

    public static Mountain find3rdTallestMountain(Mountain[] mountains) {
        if(mountains == null){
            return null;
        }

        int arrayLength = mountains.length;
        boolean swapped;

        do{
            swapped = false;
            for(int i = 1; i < arrayLength; i++){
                if(mountains[i-1].getHeightInFeet() < mountains[i].getHeightInFeet()){
                    Mountain placeHolder = mountains[i-1];
                    mountains[i-1] = mountains[i];
                    mountains[i] = placeHolder;
                    swapped = true;
                }
            }
        }while(swapped);
        return mountains[2];
    }

    /**
     * Finds and returns the 3rd tallest mountain in an array of Mountain objects.
     *
     * @param fileName The name of the input file containing the mountain objects.
     * @return An array of Mountain objects called mountains .
     */

    public static Mountain[] getMountainFromFile (String fileName){
        int line = linesinFile(fileName);
        Mountain[] mountains = new Mountain[line];
        try{
            Scanner fileScanner = new Scanner(new File(fileName));
            for(int i = 0; i < line && fileScanner.hasNextLine(); i++){
                String mountainName = fileScanner.next();
                Double height = Double.valueOf(fileScanner.next());
                String mountainRange = fileScanner.next();
                int ascendYear = Integer.valueOf(fileScanner.next());
            	mountains[i] = new Mountain(mountainName, height, mountainRange, ascendYear);
          	}
        }catch (Exception e){
            System.out.println(
          	"Error occured in counting number of rows.");
          	e.printStackTrace();
        }
       return mountains;     
    }

    public static int linesinFile(String filename){
        int count=0;
        try{
          Scanner fileScanner = new Scanner(new File(filename));
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
}
