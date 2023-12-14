import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class Lab4_Vu{ 

	public static void main(String[] args){ 
		
    String fileName = "input.txt";
    
		Asteroid head = null;
		head = getAsteroidFromDataFile("input.txt"); 
		System.out.println("--------------------------------------");
		System.out.println("Printing the Linked List");
		printLL(head);

    Asteroid newAsteroid = new Asteroid("Hygiea", "de Gasparis, A.", 433, 87, 1849);
		head = addAsteroid(head, newAsteroid, 0);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Adding a new asteroid at position 0\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

        Asteroid newAsteroid2 = new Asteroid("Juno", "Kopff, A.", 254, 27, 1804);
		head = addAsteroid(head, newAsteroid2, 3);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Adding a new asteroid at position 3\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

        head = deleteAsteroid(head, 3);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Deleting asteroid information from position 3\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

        head = deleteAsteroid(head, 0);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Deleting asteroid information from position 0\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

        System.out.println("\n\n--------------------------------------");
		System.out.println("\nThe name of the person with the first discovery: ");
		firstDiscovery(head);

        System.out.println("\n\n--------------------------------------");
		System.out.println("\nThe name of the asteroid with the lowest mass: ");
	    lowestMass(head);

        System.out.println("\n\n--------------------------------------");
		System.out.println("\nThe asteroids and their density: ");
	    calculateDensity(head);

	} 

	/** 
	 * Complete this method to print the Asteroid Linkedlist
	 * given the head of the Asteroid LinkedList
	 * @param head of the Asteroid LinkedList 
	 */ 

	public static void printLL (Asteroid head) { 

		if(head != null){
			System.out.println(head);
      printLL(head.next);
    }
	} 

	/**  
     * This method will add asteroids to your linked list at a specific position.
	 * @param head
	 * @param newPerson 
	 * @param position
	 * @return head
	 */   
	public static Asteroid addAsteroid(Asteroid head, Asteroid newAsteroid, int position) { 

		if(head==null)
      return null;
    
    //insert at the beginning
    if(position == 0){
    	newAsteroid.next = head;
      return newAsteroid;
    }

    int index = 1; 
    Asteroid previous = head;
    Asteroid current = head.next;
    
    while(current != null){
    
      if(position == index){
      	previous.next = newAsteroid;
        newAsteroid.next = current;
        return head;
      }
      index++;
      previous = current;
      current = current.next;
    }
    while(current != null){
    	current = current.next;
    }
    current.next = newAsteroid;
    return head;
	} 

    /**  
     * This method will delete the asteroid located at a specific position from your linked list.
	 * @param head
	 * @param position
	 * @return head
	 */      
	public static Asteroid deleteAsteroid (Asteroid head, int position) { 
		if(position == 0){
    	return head.next;
  	}
    if(head == null){
      return head;
    }
    
    int index = 1;
  	Asteroid current = head;
   
    while(current != null && index < position){
      current = current.next;
      index++;
    }
    if(current == null || current.next == null){
      System.out.println("Unable to remove from");
      return head;
    }
   	current.next = current.next.next;
   	return head;
   	}

	/**  
     * This method finds and displays the first discovered asteroid.
	 * @param head
	 * @return head
	 */   
    public static void firstDiscovery(Asteroid head) {
    	Asteroid current = head;
    	int currentYear = head.getYearDiscovered();
    	String nameOfFirstDiscoverer = head.getDiscoverBy(); 

    	while(current != null){
    		if(current.getYearDiscovered() < currentYear){
    			currentYear = current.getYearDiscovered();
    			nameOfFirstDiscoverer = current.getDiscoverBy();
    		}
    		current = current.next;
    	}
    	System.out.println("Name: " + nameOfFirstDiscoverer);
    	System.out.println("Year: " + currentYear);
    }

	/**  
     * This method finds and displays the asteroid with the lowest mass.
	 * @param head
	 * @return head
	 */   
    public static void lowestMass(Asteroid head) { 
      Asteroid current = head;
    	Double currentMass = head.getMass();
    	String nameOfAsteroid = head.getName(); 

    	while(current != null){
    		if(current.getMass() < currentMass){
    			currentMass = current.getMass();
    			nameOfAsteroid = current.getName();
    		}
    		current = current.next;
    	}
    	System.out.println("Name: " + nameOfAsteroid);
    	System.out.println("Mass: " + currentMass);
    }

    /**  
     * This method calculates the density of all the asteroids.
	 * Density = mass * 1e18/ ((4.0 / 3.0) * Math.PI * Math.pow(diameter / 2, 3))
	 * Units using this formula are g/cm^3
	 * @param head
	 * @return head
	 */  
	public static void calculateDensity(Asteroid head) {
		Double currentMass = head.getMass();
		Double currentDiameter = head.getDiameter();
		Double density = 0.0;

		try{
			if(head != null){
				density = currentMass * 1e18/((4.0/3.0) * Math.PI * Math.pow(currentDiameter/2,3));
				System.out.println("Asteroid Name: " + head.getName());
				System.out.println("Asteroid's Density: " + density);
				System.out.println();
				calculateDensity(head.next);
			}
		}catch(Exception e){
			System.out.println("--------------------------------------");
		}
  }

    /** 
	 * Change the body of this method to return   
	 * the head of linkedlist of Asteroid, created after reading the file. 
	 * @param filename 
	 * @return head of the created Linked List  
	 */     
	static Asteroid getAsteroidFromDataFile (String fileName){

		Asteroid head = null;

    int lineCount = lineCount(fileName);
    try{
      Scanner fileScanner = new Scanner(new File(fileName));
      while(fileScanner.hasNextLine()){
        String row = fileScanner.nextLine();
				String[] asteroidData = row.split("	");
				if (asteroidData.length == 5){
					String name = asteroidData[0];
					String discoverBy = asteroidData[1];
					Double diameter = Double.valueOf(asteroidData[2]);
					Double mass = Double.valueOf(asteroidData[3]);
					int yearDiscovered = Integer.valueOf(asteroidData[4]);

   				Asteroid newAsteroid = new Asteroid(name, discoverBy, diameter, mass, yearDiscovered);

   				if(head == null){
   					head = newAsteroid;
   				}else{
   					Asteroid current = head;
   					while(current.next != null){
   						current = current.next;
   					}
   					current.next = newAsteroid;
   				}
   			}
      }
    }catch(Exception e){
     	System.out.println("There was an error with reading the file");
      e.printStackTrace();
   	}
   	return head;
	}
  
  public static int lineCount (String fileName){
    int count = 0;
    
    try{
      Scanner fileScanner = new Scanner(new File(fileName));
      while(fileScanner.hasNextLine()){
        String line = fileScanner.nextLine();
        count++;
      }
      
    }catch(Exception e){
      System.out.println("There was an error counting the lines");
      e.printStackTrace();
    }
    return count;
  }
} 