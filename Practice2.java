// Write your code
class Practice2{

	public static void main (String[] args){
    int[] testCaseHas1 = {2,5};
    int[] testCaseHas2 = {2,3};
    int[] testCaseHas3 = {4,5};
    
    System.out.println("++++++ Testing has45 Method ++++++");
    System.out.println();
		System.out.println("The results for the first test case is: " + has45(testCaseHas1));
    System.out.println("The results for the second test case is: " + has45(testCaseHas2));
    System.out.println("The results for the third test case is: " + has45(testCaseHas3));
    System.out.println();
    System.out.println("++++++ Done Testing has45 Method ++++++");
    System.out.println();
    System.out.println();
    
    int[] testCaseCommon1A = {1,8,3};
    int[] testCaseCommon1B = {11,3};
    int[] testCaseCommon2A = {1,2,3};
    int[] testCaseCommon2B = {7,3,2};
    int[] testCaseCommon3A = {1,2,4,3};
    int[] testCaseCommon3B = {1,9,3};
    
    System.out.println("++++++ Testing commonStartOrEnd Method ++++++");
    System.out.println();
		System.out.println("The results for the first test case is: " + commonStartOrEnd(testCaseCommon1A, testCaseCommon1B));
    System.out.println("The results for the second test case is: " + commonStartOrEnd(testCaseCommon2A, testCaseCommon2B));
    System.out.println("The results for the third test case is: " + commonStartOrEnd(testCaseCommon3A, testCaseCommon3B));
    System.out.println();    
    System.out.println("++++++ Done Testing commonStartOrEnd Method ++++++");
  }
  
  public static boolean has45 (int[] nums) {
    for(int i = 0; i < nums.length; i++){
      if((nums[i] == 5) || (nums[i] == 4)){
        return true;
    	}
  	}
    return false;
  }
    
	public static boolean commonStartOrEnd (int[] a, int[] b){
    if((a[a.length-1] == b[b.length-1]) || a[0] == b[0]){
      return true;
  	}
    return false;
  }
}
    
  