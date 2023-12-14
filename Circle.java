// Write your code
class Circle{

  private double radius;
  Circle	next;
    
  Circle(){
  }
  
  Circle (double r){
  radius = r;}
  
  Circle(int i){
  	radius = (double)(i);
  }
  public void setRadius(double r){
 	 radius = r;
  }
  
	public double getRadius(){
  	return radius;
  }
  
  public double getArea(){
  	return Math.PI*radius*radius;
  }
  
}