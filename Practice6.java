class Practice6{
  public static void main (String[] args){
    Node a = new Node(5);
    Node b = new Node(10);
    Node c = new Node(15);
    Node d = new Node(20);
    
    a.next = b;
    b.next = c;
    c.next = d;
    
    printLL(a);
    System.out.println();
    System.out.println(addLL(a));
    System.out.println();
    System.out.println(oddLL(a));
    
    int[] testCase1 = {1,4,2,3,6,7,9,8,10};
    int[] testCase2 = {7,6,4,1,10,9,5};
    
    System.out.println();
    System.out.println("testCase1 Array before method: ");
    for(int i = 0; i < testCase1.length; i++){
      System.out.print(testCase1[i] + " ");
    }
    
    System.out.println();
    System.out.println();
    System.out.println("testCase1 Array after method: ");
    bubbleSort(testCase1);
    for(int i = 0; i < testCase1.length; i++){
    	System.out.print(testCase1[i] + " ");
    }
    
		System.out.println();
    System.out.println();
    System.out.println("testCase2 Array before method: ");
    for(int i = 0; i < testCase2.length; i++){
      System.out.print(testCase2[i] + " ");
    }
    
    System.out.println();
    System.out.println();
    System.out.println("testCase2 Array after method: ");
    selectionSort(testCase2);
    for(int i = 0; i < testCase2.length; i++){
    	System.out.print(testCase2[i] + " ");
    }
    
  }
  
	public static void printLL(Node head){
    if(head == null){
      return;
  	}
    System.out.println(head.getData());
    printLL(head.next);
  }
  
  public static int addLL(Node head){
    if(head == null){
      return 0;
    }
    
    return head.getData() + addLL(head.next);
  }
  
  public static int oddLL(Node head){
    if(head == null){
      return 0;
    }
    if(head.getData() % 2 == 1){
      System.out.println(head.getData());
    }
    return oddLL(head.next);
  }
  
  public static void bubbleSort(int[] intArray){
    int n = intArray.length;
    int temp = 0;
    
    for(int i = 0; i < n; i++){
      for(int j = 1; j < (n-i); j++){
        if(intArray[j-1] > intArray[j]){
          //swap the elements
          temp = intArray[j-1];
          intArray[j-1] = intArray[j];
          intArray[j] = temp;
        }
      }
    }
  }
  
  public static void selectionSort(int[] intArray){
    int n = intArray.length;
    
    for(int i = 0; i < n-1; i++){
      int min = i;
      for(int j = i+1; j < n; j++){
        if(intArray[min] > intArray[j]){
          min = j;
        }
      }
      
      if(min != i){
        int temp = intArray[i];
        intArray[i] = intArray[min];
        intArray[min] = temp;
      }
    }
  }
  
  public static void insertionSort[int[] intArray){
    int n = intArray.length;
    
    for(int i = 1; i < n; i++){
      int minNum = intArray[i];
      for(int j = i-1; (j >= 0) && (intArray[j] > key); j--){
        intArray[j+1] = intArray[j];
      }
      intArray[j+1] = minNum;
    }
  }
}

                                   
//keyword break = will stop whatever function/method/loop it is in
//keyword continue = continues the loop, but does not continue the rest