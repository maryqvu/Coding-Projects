class testCodeLab2{
	public static void main (String[]args){
		System.out.println("hi");
		int[] numbers = {1,5,6,7,3,2,4,8,10,5,5,5};
		//sortArray(numbers);
		mostAppearance2(numbers);
		myMethod(1234);

	}

	public static void sortArray(int[] nums) {
    	if (nums == null || nums.length == 0) {
       		System.out.println("empty");
        	return;
    	}

    	int n = nums.length;
    	boolean swapped;

    	do {
        	swapped = false;
        	for (int i = 1; i < n; i++) {
            	if (nums[i - 1] > nums[i]) {
                // Swap nums[i-1] and nums[i]
                	int temp = nums[i - 1];
                	nums[i - 1] = nums[i];
                	nums[i] = temp;
                	swapped = true;
            	}
        	}
        	n--;
    	} while (swapped);

    	// Print the sorted array
    	for (int i = 0; i < nums.length; i++) {
        	System.out.print(nums[i] + " ");
    	}
    	System.out.println();
	}

	public static void mostAppearance2(int[] nums) {
    	if (nums == null || nums.length == 0) {
        	System.out.println("Array is empty");
        	return;
    	}

    	int mostAppeared = nums[0];
    	int count1 = 1; // Initialize with the count of the first element

    	for (int i = 0; i < nums.length; i++) {
        	int count = 1; // Initialize with 1 because nums[i] itself counts as one occurrence
        	for (int j = i + 1; j < nums.length; j++) {
            	if (nums[i] == nums[j]) {
                	count++;
            	}
        	}
        	if (count > count1) {
            	mostAppeared = nums[i];
            	count1 = count;
        	}
    	}

    	System.out.println("The number that appeared the most is: " + mostAppeared);
    	System.out.println("It appeared: " + count1 + " times");
	}

	public static void myMethod (int n) {
		if(n==0)
			return;
		System.out.print(n%10);
		myMethod(n / 10);
	}	
}