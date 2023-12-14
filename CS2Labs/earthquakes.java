import java.util.Scanner;

class earthquakes{
	static Scanner userInput = new Scanner(System.in);
	static Scanner earthquakeLocInput = new Scanner(System.in);

	public static void main (String[] args){

		//creates 4 objects of the eqDataType data type
		eqDataType earthquake1 = new eqDataType();
		eqDataType earthquake2 = new eqDataType();
		eqDataType earthquake3 = new eqDataType();
		eqDataType earthquake4 = new eqDataType();


		//calls the eqInformation method in regards for object earthquake1
		System.out.println();
		System.out.println("Information regarding Earthquake 1: ");
		eqInformation(earthquake1);

		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println();

		//calls the eqInformation method in regards for object earthquake2
		System.out.println("Information regarding Earthquake 2: ");
		eqInformation(earthquake2);

		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println();

		//calls the eqInformation method in regards for object earthquake3
		System.out.println("Information regarding Earthquake 3: ");
		eqInformation(earthquake3);

		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println();

		////calls the eqInformation method in regards for object earthquake4
		System.out.println("Information regarding Earthquake 4: ");
		eqInformation(earthquake4);

		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println();

		//prints all the data for all 4 eqDataType objects at the very end of the program --> Provides an overview for all 4 earthquakes
		System.out.println("All 4 Earthquakes: ");
		System.out.println("Earthquake 1: ");
		System.out.println("Latitude: " + earthquake1.getLatitude());
		System.out.println("Longtitude: " + earthquake1.getLongtitude());
		System.out.println("Magnitude: " + earthquake1.getMagnitude());
		System.out.println("Location of the Earthquake: " + earthquake1.getPlace());
		System.out.println();

		System.out.println("Earthquake 2: ");
		System.out.println("Latitude: " + earthquake2.getLatitude());
		System.out.println("Longtitude: " + earthquake2.getLongtitude());
		System.out.println("Magnitude: " + earthquake2.getMagnitude());
		System.out.println("Location of the Earthquake: " + earthquake2.getPlace());
		System.out.println();

		System.out.println("Earthquake 3: ");
		System.out.println("Latitude: " + earthquake3.getLatitude());
		System.out.println("Longtitude: " + earthquake3.getLongtitude());
		System.out.println("Magnitude: " + earthquake3.getMagnitude());
		System.out.println("Location of the Earthquake: " + earthquake3.getPlace());
		System.out.println();

		System.out.println("Earthquake 4: ");
		System.out.println("Latitude: " + earthquake4.getLatitude());
		System.out.println("Longtitude: " + earthquake4.getLongtitude());
		System.out.println("Magnitude: " + earthquake4.getMagnitude());
		System.out.println("Location of the Earthquake: " + earthquake4.getPlace());
		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++++++++++");

	}


	/*
	a method named eqInformation that takes in the data type eqDataType as a parameter
	- Allows the user to set the latitude of an eqDataType object
	- Allows the user to set the longtitude of an eqDataType object
	- Allows the user to set the magnitude of an eqDataType object
	- Allows the user to set the location/place of an eqDataType object
	[using the setter methods in the eqDataType class]

	Prints a summary of the specific eqDataType object that is currently being passed through the method at the end
	[using the getter methods in the eqDataType class]
	*/
	public static void eqInformation(eqDataType earthquake){
		System.out.println("What is the latitude of the earthquake?");
		System.out.println("A latitude can range from: -90 to 90")
		double earthquakeLat = userInput.nextDouble();
		earthquake.setLatitude(earthquakeLat);

		System.out.println();
		System.out.println("What is the longtitude of the earthquake?");
		System.out.println("A longtitude can range from: -180 to 180");
		double earthquakeLong = userInput.nextDouble();
		earthquake.setLongtitude(earthquakeLong);

		System.out.println();
		System.out.println("What is the magnitude of the earthquake?");
		System.out.println("The magnitude of an earthquake can range from: 0.0 to >8");
		double earthquakeMag = userInput.nextDouble();
		earthquake.setMagnitude(earthquakeMag);

		System.out.println();
		System.out.println("Where is the earthquake occurring at?");
		System.out.println("Please name the location in this order: City, State, Country");
		String earthquakeLoc = earthquakeLocInput.nextLine();
		earthquake.setPlace(earthquakeLoc);

		System.out.println();
		System.out.println("Summary of the Earthquake: ");
		System.out.println("Latitude: " + earthquake.getLatitude());
		System.out.println("Longtitude: " + earthquake.getLongtitude());
		System.out.println("Magnitude: " + earthquake.getMagnitude());
		System.out.println("Location of the Earthquake: " + earthquake.getPlace());

	}

}