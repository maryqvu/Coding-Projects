/* Mary Vu
[CS2401 - FA23]
This work is to be done individually. It is not permitted to share, reproduce, or alter any part of this
assignment for any purpose. Students are not permitted from sharing code, uploading this
assignment online in any form, or viewing/receiving/modifying code written from anyone else. This
assignment is part of an academic course at The University of Texas at El Paso and a grade will be
assigned for the work produced individually by the student. */

import java.util.Random;

class Lab7_Vu {
  public static void main(String[] args) {
    Airplane[] airplanes = createAirplaneArray();
    System.out.println("-----------------------------------------------------");
    System.out.println("The number of airplanes in the array: " + airplanes.length);
    System.out.println("Printing the Airplane information [Not sorted]");
    System.out.println();
    showAirplaneInfo(airplanes);
    System.out.println("-----------------------------------------------------");

    System.out.println("Sorting the array using Selection Sort based on duration");
    System.out.println("-----------------------------------------------------");
    long start = System.nanoTime();
    SelectionSortByDuration(airplanes);
    long end = System.nanoTime();
    long timeSelectionSortDuration = (end - start);
    System.out.println("Printing the sorted array.....");
    System.out.println();
    showAirplaneInfo(airplanes);

    // Restoring the array to its initial state
    airplanes = createAirplaneArray();

    System.out.println("-----------------------------------------------------");

    System.out.println("Sorting the array using Selection Sort based on capacity");
    airplanes = createAirplaneArray();
    System.out.println("-----------------------------------------------------");
    start = System.nanoTime();
    SelectionSortByCapacity(airplanes);
    end = System.nanoTime();
    long timeSelectionSortCapacity = (end - start);
    System.out.println("Printing the sorted array.....");
    System.out.println();
    showAirplaneInfo(airplanes);

    // Restoring the array to its initial state
    airplanes = createAirplaneArray();

    System.out.println("-----------------------------------------------------");

    System.out.println("Sorting the array using Merge Sort based on duration");
    airplanes = createAirplaneArray();
    System.out.println("-----------------------------------------------------");
    start = 0;
    end = 0;
    start = System.nanoTime();
    MergeSortByDuration(airplanes);
    end = System.nanoTime();
    long timeMergeSortDuration = (end - start);
    System.out.println("Printing the sorted array.....");
    System.out.println();
    showAirplaneInfo(airplanes);

    // Restoring the array to its initial state
    airplanes = createAirplaneArray();

    System.out.println("-----------------------------------------------------");

    System.out.println("Sorting the array using Merge Sort based on capacity");
    airplanes = createAirplaneArray();
    System.out.println("-----------------------------------------------------");
    start = 0;
    end = 0;
    start = System.nanoTime();
    MergeSortByCapacity(airplanes);
    end = System.nanoTime();
    long timeMergeSortCapacity = (end - start);
    System.out.println("Printing the sorted array.....");
    System.out.println();
    showAirplaneInfo(airplanes);

    System.out.println("-----------------------------------------------------");
    System.out.println("************ Runtime Statistics **************");
    System.out.println();
    System.out.println("Selection sort - duration: " + timeSelectionSortDuration + " ns");
    System.out.println("Selection sort - capacity: " + timeSelectionSortCapacity + " ns");
    System.out.println("Merge sort - duration: " + timeMergeSortDuration + " ns");
    System.out.println("Merge sort - capacity: " + timeMergeSortCapacity + " ns");
  }

  /**
   * Change the body of this method to arrange the Airplane
   * objects in ascending order of duration.
   * The method must use Selection Sort.
   * Do NOT change the method header.
   * Consider method overloading.
   * 
   * @param allAirplane
   */

  public static void SelectionSortByDuration(Airplane[] allAirplane) {
    for (int i=0; i<allAirplane.length-1; i++) {
        int minIndex = i; // Index of smallest remaining value.
        for (int j=i+1; j<allAirplane.length; j++) {
            if (allAirplane[minIndex].getDuration() > allAirplane[j].getDuration()) {
                minIndex = j;  // Remember index of new minimum
            }
        }
        if (minIndex != i) { 
            //Exchange current element with smallest remaining.
            Airplane temp = allAirplane[i];
            allAirplane[i] = allAirplane[minIndex];
            allAirplane[minIndex] = temp;
        }
    }
  }

  /**
   * Change the body of this method to arrange the Airplane
   * objects in ascending order of capacity.
   * The method must use Selection Sort.
   * Do NOT change the method header.
   * 
   * @param allAirplane
   */
  public static void SelectionSortByCapacity(Airplane[] allAirplane) {
    for (int i=0; i<allAirplane.length-1; i++) {
        int minIndex = i; // Index of smallest remaining value.
        for (int j=i+1; j<allAirplane.length; j++) {
            if (allAirplane[minIndex].getCapacity() > allAirplane[j].getCapacity()) {
                minIndex = j;  // Remember index of new minimum
            }
        }
        if (minIndex != i) { 
            //Exchange current element with smallest remaining.
            Airplane temp = allAirplane[i];
            allAirplane[i] = allAirplane[minIndex];
            allAirplane[minIndex] = temp;
        }
    }
  }

  /**
   * Change the body of this method to arrange the Airplane
   * objects in ascending order of duration.
   * The method must use Merge Sort.
   * Do NOT change the method header.
   * Consider method overloading.
   * 
   * @param allAirplane
   */

  public static void MergeSortByDuration(Airplane[] allAirplane) {
    if(allAirplane.length == 1){
      return;
    }
    mergeSort(allAirplane, 0, allAirplane.length-1);
  }

  static void mergeSort(Airplane[] allAirplane, int left, int right) {
    if(right > left){
      int middle = (left + right)/2;
      mergeSort(allAirplane, left, middle);
      mergeSort(allAirplane, middle+1, right);

      merge(allAirplane, left, middle, right);
    }
  }

  static void merge(Airplane[] allAirplane, int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
    int subArray1 = middle - left + 1;
    int subArray2 = right - middle;
 
        // Create temp arrays
    Airplane l[] = new Airplane[subArray1];
    Airplane r[] = new Airplane[subArray2];
 
        // Copy data to temp arrays
    for (int i = 0; i < subArray1; ++i)
      l[i] = allAirplane[left + i];
    for (int j = 0; j < subArray2; ++j)
      r[j] = allAirplane[middle + 1 + j];
      int i = 0;
      int j = 0;
      int k = left;
    while (i < subArray1 && j < subArray2) {
      if (l[i].getDuration() <= r[j].getDuration()) {
        allAirplane[k] = l[i];
        i++;
      }
      else {
        allAirplane[k] = r[j];
        j++;
      }
      k++;
    }
      // Copy remaining elements of L[] if any
    while (i < subArray1) {
      allAirplane[k] = l[i];
      i++;
      k++;
    }
 
        // Copy remaining elements of R[] if any
    while (j < subArray2) {
      allAirplane[k] = r[j];
      j++;
      k++;
    }
  }

  /**
   * Change the body of this method to arrange the Airplane
   * objects in ascending order of capacity.
   * The method must use Merge Sort.
   * Do NOT change the method header.
   * 
   * @param allAirplane
   */
  public static void MergeSortByCapacity(Airplane[] allAirplane) {
    mergeSortByCapacity(allAirplane, 0, allAirplane.length-1);
  }

  static void mergeSortByCapacity(Airplane[] allAirplane, int left, int right) {
    if(right > left){
      int middle = (left + right)/2;
      mergeSortByCapacity(allAirplane, left, middle);
      mergeSortByCapacity(allAirplane, middle+1, right);

      mergeByCapacity(allAirplane, left, middle, right);
    }
  }

  static void mergeByCapacity(Airplane[] allAirplane, int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
    int subArray1 = middle - left + 1;
    int subArray2 = right - middle;
 
        // Create temp arrays
    Airplane l[] = new Airplane[subArray1];
    Airplane r[] = new Airplane[subArray2];
 
        // Copy data to temp arrays
    for (int i = 0; i < subArray1; ++i)
      l[i] = allAirplane[left + i];
    for (int j = 0; j < subArray2; ++j)
      r[j] = allAirplane[middle + 1 + j];
      int i = 0;
      int j = 0;
      int k = left;
    while (i < subArray1 && j < subArray2) {
      if (l[i].getCapacity() <= r[j].getCapacity()) {
        allAirplane[k] = l[i];
        i++;
      }
      else {
        allAirplane[k] = r[j];
        j++;
      }
      k++;
    }
      // Copy remaining elements of L[] if any
    while (i < subArray1) {
      allAirplane[k] = l[i];
      i++;
      k++;
    }
 
        // Copy remaining elements of R[] if any
    while (j < subArray2) {
      allAirplane[k] = r[j];
      j++;
      k++;
    }
  }



  /************************************************************************************************************************************************
   * Don't change anything below this line
   */
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
    Airplane[] airplanes = new Airplane[25];
        Random rand = new Random();
        for (int i = 0; i < 25; i++) {
            int capacity = rand.nextInt(300) + 1; // generates capacity between 1 to 300
            int startTime = rand.nextInt(2300); // generates start time between 0 to 2300
            int endTime = startTime + rand.nextInt(2400 - startTime) + 1; // ensures end time > start time
            airplanes[i] = new Airplane(i+1, "Plane" + (i+1), capacity, startTime, endTime);
        }
        return airplanes;

  }
}