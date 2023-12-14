/* Mary Vu
[CS2401 - FA23]
This work is to be done individually. It is not permitted to share, reproduce, or alter any part of this
assignment for any purpose. Students are not permitted from sharing code, uploading this
assignment online in any form, or viewing/receiving/modifying code written from anyone else. This
assignment is part of an academic course at The University of Texas at El Paso and a grade will be
assigned for the work produced individually by the student. */

public class Earthquake {
  private Double magnitude;
  private String date;
  private String place;
  Earthquake left;
  Earthquake right;
  
  Earthquake(){}
  
  Earthquake(Double m, String p, String d){
    magnitude = m;
    date = d;
    place = p;
  }

  Earthquake(Earthquake earthquake){
    this.magnitude = earthquake.getMagnitude();
    this.place = earthquake.getPlace();
    this.date = earthquake.getDate();
  }
  
  public Double getMagnitude(){
    return magnitude;
  }
  
  public String getDate(){
    return date;
  }
  
  public String getPlace(){
    return place;
  }
  
  public void setMagnitude(Double m){
    magnitude = m;
  }
  
  public void setDate(String d){
    date = d;
  }
  
  public void setPlace(String p){
    place = p;
  }
  
}
