class cs2Practice4{
	public static void main(String[] args){
  	
    Circle a = new Circle(4);
    Circle b = new Circle(20.25);
    System.out.println("Testing getRadius constructor: ");
    System.out.println(b.getRadius());
    
    //array of objects
    Circle[] myCircles = new Circle[4];
    
    myCircles[0]= new Circle (10);
    myCircles[1] = new Circle(20);
    myCircles[2] = new Circle(30);
    myCircles[3] = new Circle(40);
    
    //for(int i=0; i<myCircles.length; i++){
    //	System.out.println(myCircles[i].getRadius());
    //}
    
    //linked list
    
    Circle c = new Circle (8.1);
    Circle d = new Circle (3.4);
    Circle e = new Circle (20);
    Circle f = new Circle (5);
    
    a.next = d;
    d.next = f;
    f.next = c;
    c.next = e;
    e.next = b;
    
    System.out.println();
    System.out.println("This is the linked list: ");
    printLL(a);
    System.out.println("-------");
    a = addLL(a, new Circle(456789), 6); 
    System.out.println();
    System.out.println("[Using the addLL method, 456789.0 was added to the sixth position of the linked list.]");
    System.out.println("This is the linked list after the value was added");
    System.out.println();
    printLL(a);
    
    
    /*Circle temp = a;
    while(temp!=null){
    	System.out.println(temp.getRadius());
      temp = temp.next;
    }
    */
    
    System.out.println();
    System.out.println("Testing sumArea method: ");
    System.out.println(sumArea(myCircles));
    
    System.out.println();
    System.out.println("Testing countLL method: ");
    System.out.println("Number of nodes within the provided linked list: " + countLL(a));
    
    System.out.println();
    System.out.println("Testing sumLL method: ");
    System.out.println("Recursive addition of areas of Circle nodes: " + sumLL(a));
    
    System.out.println();
    System.out.println("Testing averageArea method: ");
    System.out.println("The average is: " + averageArea(a));
  }
  
  //sumArea
  public static double sumArea(Circle[] myCircles){
    double area = 0;
    for(int i = 0; i < myCircles.length; i++){
			area += myCircles[i].getRadius() * myCircles[i].getRadius() * Math.PI;
    }
    return area;
  }
  
  //countLL-- recursive method
  public static int countLL(Circle head){
    if(head == null){
      return 0;
    }
      int count = 1 + countLL(head.next);
    return count;
  }
  
  //sumLL-- recurisve method
  public static double sumLL(Circle head){
    if(head == null){
      return 0;
    }
    	double currentAreaSum = head.getRadius() * head.getRadius() * Math.PI;
    	double nextSum = sumLL(head.next);
    	double total = currentAreaSum + nextSum;
    	
    return total;
  }
  
  //printLL-- recursive method
  public static void printLL (Circle head){
    
    if(head!=null){
    	System.out.println(head.getRadius());
      printLL(head.next);
    }
    return;
  }
  //averageArea
  public static double averageArea(Circle head){
    double average = sumLL(head)/countLL(head);
    
   	return average;
  }
  
  public static Circle addLL(Circle head, Circle toAdd, int pos){
  	
    if(head==null)
      return null;
    
    //insert at the beginning
    if(pos==0){
    	toAdd.next = head;
      return toAdd;
    }
    
    //adding in the middle
    
    int index = 1; 
    Circle previous = head;
    Circle current = head.next;
    
    while(current != null){
    
      if(pos==index){
      	previous.next = toAdd;
        toAdd.next = current;
        return head;
      }
      
      index++;
      previous = current;
      current = current.next;
    }
    //add at the tail
    previous.next = toAdd;
    return head;
  }
  
 	public static Circle removeLL (Circle head, int pos){
    if(pos == 0){
    	return head.next;
  	}
    if(head == null){
      return head;
    }
    
    int index = 1;
  	Circle current = head;
   
    while(current.next != null && index<pos){
      current = current.next;
      index++;
      
    	if(current.next != null){
				current.next = current.next.next;
    	}
    	else{
      	System.out.println("Invalid position to remove from");
    	}
    return head;
   	}
    return head;
  }
}