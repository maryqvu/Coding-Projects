class eqDataType{
	//declares the attributes of a eqDataType object
	private double latitude;
	private double longtitude;
	private double magnitude;
	private String place; 
	
	//initializes the attributes of a eqDataType object 
	public eqDataType(){
		latitude = 0;
		longtitude = 0;
		magnitude = 0;
		place = "City, State, Country";
	}

	/*
	Setter methods that take in a specific parameter and sets the initialized attributes to the parameter
	[The initialized attribute is now set equal to the parameter]
	*/
	public void setLatitude(double newLatitude){
		latitude = newLatitude;
	}
	public void setLongtitude(double newLongtitude){
		longtitude = newLongtitude;
	}
	public void setMagnitude(double newMagnitude){
		magnitude = newMagnitude;
	}
	public void setPlace(String newPlace){
		place = newPlace;
	}

	/*
	Getter methods that returns the value of the specific attributes
	*/
	public double getLatitude(){
		return latitude;
	}
	public double getLongtitude(){
		return longtitude;
	}
	public double getMagnitude(){
		return magnitude;
	}
	public String getPlace(){
		return place;
	}

}