/* MARY VU
[CS2401 - FA23]
This work is to be done individually. It is not permitted to share, reproduce, or alter any part of this
assignment for any purpose. Students are not permitted from sharing code, uploading this
assignment online in any form, or viewing/receiving/modifying code written from anyone else. This
assignment is part of an academic course at The University of Texas at El Paso and a grade will be
assigned for the work produced individually by the student. */

class Lab6_Vu {
    public static void main(String[] args) {
        Airplane[] airplanes = createAirplaneArray();
        System.out.println("-----------------------------------------------------");
        System.out.println("The number of airplanes in the array: " + airplanes.length);
        System.out.println("Printing the Airplane information");
        showAirplaneInfo(airplanes);
        System.out.println("-----------------------------------------------------");

        System.out.println("Linear Search on the array based on duration");
        System.out.println("-----------------------------------------------------");

        int LSDuration = 1415;
        linearSearchByDuration(airplanes, LSDuration);
        System.out.println();

        int LSDurationTwo = 100;
        linearSearchByDuration(airplanes, LSDurationTwo);
        System.out.println("-----------------------------------------------------");

        System.out.println("Linear Search on the array based on capacity");
        System.out.println("-----------------------------------------------------");

        int LSCapacity = 32;
        linearSearchByCapacity(airplanes, LSCapacity);
        System.out.println();

        int LSCapacityTwo = 50;
        linearSearchByCapacity(airplanes, LSCapacityTwo);

        System.out.println("-----------------------------------------------------");

        System.out.println("Sorting the array using Bubble Sort based on duration");
        System.out.println("-----------------------------------------------------");
        bubbleSortByDuration(airplanes);
        System.out.println("Printing the sorted array.....");
        showAirplaneInfo(airplanes);

        System.out.println("-----------------------------------------------------");

        System.out.println("Binary Search on the array based on duration");
        System.out.println("-----------------------------------------------------");

        int BSDuration = 1415;
        binarySearchDuration(airplanes, BSDuration);
        System.out.println();

        int BSDurationTwo = 100;
        binarySearchDuration(airplanes, BSDurationTwo);

        System.out.println("-----------------------------------------------------");
        bubbleSortByCapacity(airplanes);
        System.out.println("Printing the sorted array.....");
        showAirplaneInfo(airplanes);

        System.out.println("-----------------------------------------------------");
        System.out.println("Binary Search on the array based on capacity");
        System.out.println("-----------------------------------------------------");

        int BSCapacity = 32;
        binarySearchByCapacity(airplanes, BSCapacity);
        System.out.println();

        int BSCapacityTwo = 50;
        binarySearchByCapacity(airplanes, BSCapacityTwo);

    }

    /**
     * Change the body of this method to find the position based on duration
     * The method must use Binary Search
     * 
     * @param allAirplane
     * @param BSDuration
     * @return -1 if possition not found
     * @return position if found
     */

    static int binarySearchDuration(Airplane[] airplanes, int BSDuration) {
        int beginning = 0;
        int end = airplanes.length-1;

        while(beginning <= end){
            int middle = (end + beginning)/2;
            if(airplanes[middle].getDuration() > BSDuration){
                end = middle - 1;
            }else if(BSDuration > airplanes[middle].getDuration()){
                beginning = middle + 1;
            }else if(airplanes[middle].getDuration() == BSDuration){
                System.out.println("An airplane with a duration of " + BSDuration + " was found at position " + middle);
                System.out.println();
                System.out.println(airplanes[middle]);
                System.out.println();
                return middle;
            }
        }
        System.out.println("An airplane with a duration of " + BSDuration + " was not found in the array");
        System.out.println();
        return -1;
    }

    /**
     * Change the body of this method to find the position based on capacity
     * The method must use Binary Search
     * 
     * @param allAirplane
     * @param BSDuration
     * @return -1 if possition not found
     * @return position if found
     */
    static int binarySearchByCapacity(Airplane[] airplanes, int BSCapacity) {
        int beginning = 0;
        int end = airplanes.length-1;

        while(beginning <= end){
            int middle = (end + beginning)/2;
            if(airplanes[middle].getCapacity() > BSCapacity){
                end = middle - 1;
            }else if(BSCapacity > airplanes[middle].getCapacity()){
                beginning = middle + 1;
            }else if(airplanes[middle].getCapacity() == BSCapacity){
                System.out.println("An airplane with a capacity of " + BSCapacity + " was found at position " + middle);
                System.out.println();
                System.out.println(airplanes[middle]);
                System.out.println();
                return middle;
            }
        }
        System.out.println("An airplane with a capacity of " + BSCapacity + " was not found in the array");
        System.out.println();
        return -1;
    }

    /**
     * Change the body of this method to find the position based on capacity
     * The method must use linear Search
     * 
     * @param allAirplane
     * @param BSDuration
     * @return -1 if possition not found
     * @return position if found
     */
    static int linearSearchByCapacity(Airplane[] airplanes, int LSCapacity) {
      int position = 0;
      for(int i = 0; i < airplanes.length; i++){
        if(airplanes[i].getCapacity() == LSCapacity){
          position = i;
          System.out.println("Airplane with a capacity of " + LSCapacity + " was found at position " + position);
          System.out.println();
          System.out.println(airplanes[i]);
          return position;
        }
      }
    System.out.println();
    System.out.println("Airplane with a capacity of " + LSCapacity + " was not found in the array.");
    System.out.println();
    return -1;
    }

    /**
     * Change the body of this method to find the position based on duration
     * The method must use linear Search
     * 
     * @param allAirplane
     * @param BSDuration
     * @return -1 if possition not found
     * @return position if found
     */
    static int linearSearchByDuration(Airplane[] airplanes, int LSDuration) {
      int position = 0;
      for(int i = 0; i < airplanes.length; i++){
        if(airplanes[i].getDuration() == LSDuration){
          position = i;
          System.out.println("Airplane with a duration of " + LSDuration + " was found at position " + position);
          System.out.println();
          System.out.println(airplanes[i]);
          return position;
        }
      }
    System.out.println();
    System.out.println("Airplane with a duration of " + LSDuration + " was not found in the array.");
    System.out.println();
    return -1;
    }

    /**
     * Change the body of this method to arrange the Airplane
     * objects in ascending order of duration.
     * The method must use Bubble Sort.
     * Do NOT change the method header.
     * Consider method overloading.
     * 
     * @param allAirplane
     */

    public static void bubbleSortByDuration(Airplane[] allAirplane) {
    	int arrayLength = allAirplane.length;
    	Airplane tempAirplane = allAirplane[0];
    
    	for(int i = 0; i < arrayLength; i++){
            for(int j = 1; j < (arrayLength-i); j++){
        	   if(allAirplane[j-1].getDuration() > allAirplane[j].getDuration()){
          	//swap the elements
                tempAirplane = allAirplane[j-1];
                allAirplane[j-1] = allAirplane[j];
                allAirplane[j] = tempAirplane;
        	   }
            }
    	}
    }
  

    /**
     * Change the body of this method to arrange the Airplane
     * objects in ascending order of capacity.
     * The method must use Bubble Sort.
     * Do NOT change the method header.
     * 
     * @param allAirplane
     */
    public static void bubbleSortByCapacity(Airplane[] allAirplane) {
        int arrayLength = allAirplane.length;
        Airplane tempAirplane = allAirplane[0];
    
        for(int i = 0; i < arrayLength; i++){
            for(int j = 1; j < (arrayLength-i); j++){
               if(allAirplane[j-1].getCapacity() > allAirplane[j].getCapacity()){
            //swap the elements
                tempAirplane = allAirplane[j-1];
                allAirplane[j-1] = allAirplane[j];
                allAirplane[j] = tempAirplane;
               }
            }
        }
    }

    /**
     * Display all the variables of a
     * Airplane object in the same sequence
     * they appear in the parameter array.
     * 
     * @param allAirplane
     */

    static void showAirplaneInfo(Airplane[] allAirplane) {
        for (int i = 0; i < allAirplane.length; i++) {
            System.out.println(allAirplane[i].toString());
        }
    }

    static Airplane[] createAirplaneArray() {
        Airplane[] newAirplane = {
                new Airplane(296, "Boeing 747", 20, 920, 2300),
                new Airplane(333, "Boeing 737", 32, 900, 2030),
                new Airplane(234, "Cessna 172", 42, 1600, 2200),
                new Airplane(748, "Boeing 777", 40, 600, 2015),
                new Airplane(123, "Boeing 787", 70, 830, 2230),
                new Airplane(765, "Boeing 717", 58, 720, 2005),
                new Airplane(111, "Airbus A350", 63, 1000, 2050),
                new Airplane(365, "Airbus A380", 35, 500, 2030),
                new Airplane(900, "Airbus A330", 55, 700, 2030),
                new Airplane(222, "Airbus A320", 60, 1610, 2230),
        };
        return newAirplane;
    }
}
