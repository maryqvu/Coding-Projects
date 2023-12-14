class homework2 {
	public static void main (String[] args){

		//test case arrays for testing both methods
		int[] array1 = {1, 7, 9, 42, 17, 100, 10};
		int[][] array2 = {{1,4,5}, {1,6,9}, {10,45,34}};
		int[] coordinatesfor2D = getMax2D(array2); //provides an array that holds the array that getMax2D is returning

		System.out.println("Index of max for 1D array: " + getMax(array1));
		System.out.println();
		System.out.println("Row of max for 2D array: " + coordinates[0]);
		System.out.println("Column of max for 2D array: " + coordinates[1]);
	}

	//method to return the index of the max value of a 1D array
	public static int getMax (int[] nums){
		int maxNum = nums[0];
		int maxIndex = 0;

		for(int i = 0; i < nums.length; i++){
			if(maxNum < nums[i]){
				maxIndex = i;
				maxNum = nums[i];
			}
		}
		return maxIndex;
	}
		//method to return a 1D array as the coordinates for the max value of a 2D array 
		public static int[] getMax2D (int[][] nums){
			int maxNum = nums[0][0];
			int[] coordinates = {0,0};

			for(int r = 0; r < nums.length; r++){
				for(int c = 0; c < nums[r].length; c++){
					if(maxNum < nums[r][c]){
						maxNum = nums[r][c];
						coordinates[0] = r;
						coordinates[1] = c;
					}
				}
			}
			return coordinates;
		}

}