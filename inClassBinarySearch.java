class inClassBinarySearch{
	public static void main(String[] args){
    int[] testCase = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
    binarySearch(testCase, 1);
    binarySearch(testCase, 3);
  }
  
  /*
  public static int recursiveBinarySearch(int[] list, int key, int low, int high){
    if (low > high){
      return low - 1;
    }
    
    int mid = (low + high)/2;
    
    if(key < list[mid]){
      return recursive
  */
  
  public static int binarySearch(int[]list, int key){
    int high = list.length-1;
    int low = 0;
    
    if(high < low){
      return -1;
    }
    
    if(high >= low){
      int mid = list[((high + low)/2)];   
    	if(key < list[mid]){
      	high = mid - 1;
    	}else if(key == list[mid]){
      	return mid;
    	}
    	else{
      	low = mid + 1;
    	}
    }else{
      return -1 - low;
    }
  	return binarySearch(list, key);
  }
  
}