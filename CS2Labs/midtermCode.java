class midtermCode{
	public static void main (String[] args){
		System.out.println("hi");
		int[] testCase1 = {1,2,3,7,5,6,7,10,9,7,6,5};
		System.out.println(count3(testCase1, 0));

		int[] after7Array = after7(testCase1);

		for(int i = 0; i < after7Array.length; i++){
			System.out.print(after7Array[i] + " ");
		}

		System.out.println();
		int count = 15;
		while (count < 30) {
			System.out.println("i");
  			count = count * 3;
  			//System.out.println("i");
  		}

  		System.out.println();
  		for (int i = 0; i < 10; i++) {
  			System.out.print('*');
		}

		System.out.println();
		int n = 0;
		for (int i = 0; i < 10; i++) {
  			for (int j = 0; j < 10; j++) {
    			System.out.print('*');
    			n++;
  			}
		}
		System.out.println();
		System.out.println(n);
		System.out.println();

		int r = 0;
		for (int k = 0; k < 20; k++) {
  			for (int i = 0; i < 20; i++) {
      			System.out.print('*');
      			r++;
  			}
		}
		System.out.println(r);
	}

	public static int[] after7(int[] nums){
		//find the index of the last 7

		int index = 0; //index of the last 7

		for(int i = 0; i < nums.length; i++){ //finds the index of the last 7
			if(nums[i] == 7){
				index = i; //tells the size of the new array
			}
		}
		//create a new array
		int[] newArray = new int[nums.length - (index+1)];

		//populate new array with the rest of the original array
		for(int i = 0; i < newArray.length; i++){
			newArray[i] = nums[index + i + 1];
		}
		return newArray;
	}

	/*
	public static double sumArray(Circle[] ca, double b){
		double sum = 0;

		for(int i = 0; i < ca.length; i++){
			if(ca[i].getRadius() >= b){
				sum = sum + ca[i].getArea();
			}
		}
		return sum;
	}
	*/

	public static int count3(int[] nums, int index){
		if(index >= nums.length){
			return 0;
		}

		if(nums[index] == 3){
			return 1 + count3(nums, index+1);
		}
		else{
			return count3(nums, index+1);
		}
	}
}