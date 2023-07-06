class miniLab3{
	public static boolean sixAppears (int[] a){
		//test case to make sure the array is not empty-- if empty, return false
		if(a.length == 0){
			return false;
		}
		//if 6 appears at either the first index or the last index return true
		if(a[0] == 6 || a[a.length - 1] == 6){
			return true;
		}
		return true;
	} 

	public static int[] combiningArrays (int[] a, int[] b){
		int[] combinedArray = new int [2]; //initializing an array with a length of 2 {[ , ]}
		//test case: if both arrays are empty
		if(a.length == 0 && b.length == 0){
			int[] emptyArray = {};
			return emptyArray;
		}
		//test case: if one of the array has a length of 0
		if(a.length == 0 || b.length == 0){
			int[] ignoreArray = new int [1]; //initializing an array with a length of 1 {[ ]}
			if(a.length == 0){             //if the first array has a length of zero, make the first index of the new array
				ignoreArray[0] = b[0];    // be the same value as the first value of the second array
				return ignoreArray;
			}
			else if(b.length == 0){       //if the second array has a length of zero, make the first index of the new array
				ignoreArray[0] = a[0];   // be the same value as the first value of the first tested array
				return ignoreArray;
			}
		}else if(a.length > 0 && b.length > 0){  //if both arrays have a length greater than zero
			combinedArray[0] = a[0];            //make the first index of combinedArray to the first value of the first tested array
			combinedArray[1] = b[0];		   //make the second index of combinedArray to the first value of the second tested array
			return combinedArray;
		}
		return combinedArray;
	}

	public static int[] changeValues (int[] a){
		int[] changedArray = new int [3];

		//test case: if the array is empty
		if(a.length == 0){
			int[] emptyArray = {};
			return emptyArray;  //if the array is empty, it will return the empty array
		}

		//testing to see if the first or last value is larger
		if(a[0] > a[2]){
			a[1] = a[0];
			a[2] = a[0];
			changedArray = a;     //make a new array the same as the tested array after changing the values to the larger value
			return changedArray; //returning changed array
		}else if(a[2] > a[0]){
			a[0] = a[2];
			a[1] = a[2];
			changedArray = a;     //make a new array the same as the tested array after changing the values to the larger value
			return changedArray; //returning changed array
		}
		return changedArray;
	}

	public static int sumOfValues (int[] a){
		int sum = 0; //initializing and declaring a sum int to be returned
		//test case to make sure the array is not empty
		if(a.length == 0){
			return 0;   //returning 0 if array is empty and has no numbers
		}
		for(int i = 0; i < a.length; i++){  //for loop to loop through the array from the start of the array
			if(a[i] != 6){				   //if index i does does not have a value of 6, add it to the sum
				sum += a[i];
			}
			if(a[i] == 6){     //if index i does have a value of 6, it will break out of the for loop and stop adding
				break;
			}
		}
		for(int x = a.length-1; x > 0; x--){  //for loop to loop through the array from the end of the array
			if(a[x] != 7){					 //if index x does not have a value of 7, add it to the sum
				sum += a[x];				
			} 
			if(a[x] == 7){				   //if index x does have a value of 7, it will break out of the for loop and stop adding
				break;
			}
		}
		return sum;     //return the sum at the end
	}

	public static void main (String [] args){
		System.out.printf("%n");
		System.out.println("------------Testing Method: sixAppears----------");
		//test case 1 for method sixAppears
		int[] testCase1 = {1,2,3,4,4,5,6,7,7,6};
		System.out.println("Testing sixAppears Test Case 1: Expecting true. Method actually returned: " + sixAppears(testCase1));

		//test case 2 for method sixAppears
		int[] testCase2 = {6,23,5,54,23,6,78,9,6};
		System.out.println("Testing sixAppears Test Case 2: Expecting true. Method actually returned: " + sixAppears(testCase2));

		//test case 3 for method sixAppears
		int[] testCase3 = {6};
		System.out.println("Testing sixAppears Test Case 3: Expecting true. Method actually returned: " + sixAppears(testCase3));

		//test case 4 for method sixAppears
		int[] testCase4 = {6,6};
		System.out.println("Testing sixAppears Test Case 4: Expecting true. Method actually returned: " + sixAppears(testCase4));

		//test case 5 for method sixAppears
		int[] testCase5 = {0,6};
		System.out.println("Testing sixAppears Test Case 5: Expecting true. Method actually returned: " + sixAppears(testCase5));

		//test case 6 for method sixAppears
		int[] testCase6 = {};
		System.out.println("Testing sixAppears Test Case 6: Expecting false. Method actually returned: " + sixAppears(testCase6));
		System.out.println("------------Done Testing Method: sixAppears----------");

		System.out.printf("%n");

		System.out.println("------------Testing Method: combiningArrays----------");
		//test case 1 for method combiningArrays
		int[] testCase1A1 = {1,2,3,4,4,5,6,7,7,6};
		int[] testCase1A2 = {};
		int[] testCombined = combiningArrays(testCase1A1, testCase1A2);
		System.out.println("Testing combiningArrays Test Case 1: Expecting 1. Method actually returned: " + testCombined[0]);

		//test case 2 for method combiningArrays
		int[] testCase2A1 = {};
		int[] testCase2A2 = {};
		int[] testCombined2 = combiningArrays(testCase2A1, testCase2A2);
		System.out.println("Testing combiningArrays Test Case 1: Expecting empty/0. Method actually returned: " + testCombined2.length);

		//test case 3 for method combiningArrays
		int[] testCase3A1 = {};
		int[] testCase3A2 = {1,2,3,4};
		int[] testCombined3 = combiningArrays(testCase3A1, testCase3A2);
		System.out.println("Testing combiningArrays Test Case 3: Expecting 1. Method actually returned: " + testCombined3[0]);

		//test case 4 for method combiningArrays
		int[] testCase4A1 = {45,324,12,46,4,3,1};
		int[] testCase4A2 = {};
		int[] testCombined4 = combiningArrays(testCase4A1, testCase4A2);
		System.out.println("Testing combiningArrays Test Case 4: Expecting 45. Method actually returned: " + testCombined4[0]);

		//test case 5 for method combiningArrays
		int[] testCase5A1 = {};
		int[] testCase5A2 = {123,4,3,1,2,34};
		int[] testCombined5 = combiningArrays(testCase5A1, testCase5A2);
		System.out.println("Testing combiningArrays Test Case 5: Expecting 123. Method actually returned: " + testCombined5[0]);

		//test case 6 for method combiningArrays
		int[] testCase6A1 = {123,13,46,23,1,2,3,6,7,8};
		int[] testCase6A2 = {45,4,3,1,2,34};
		int[] testCombined6 = combiningArrays(testCase6A1, testCase6A2);
		System.out.println("Testing combiningArrays Test Case 6: Expecting [123,45]. Method actually returned: " + "[" + testCombined6[0] + "," + testCombined6[1] + "]");

		//test case 7 for method combiningArrays
		int[] testCase7A1 = {1};
		int[] testCase7A2 = {2};
		int[] testCombined7 = combiningArrays(testCase7A1, testCase7A2);
		System.out.println("Testing combiningArrays Test Case 7: Expecting [1,2]. Method actually returned: " + "[" + testCombined7[0] + "," + testCombined7[1] + "]");
		System.out.println("------------Done Testing Method: combiningArrays----------");

		System.out.printf("%n");

		System.out.println("------------Testing Method: changeValues----------");
		//test case 1 for method changeValues
		int[] testCaseCV1 = {1,2,3};
		int[] testCaseNACV1 = changeValues(testCaseCV1);
		System.out.println("Testing changeValues Test Case 1: Expecting [3,3,3]. Method actually returned: " + "[" + testCaseNACV1[0] + "," + testCaseNACV1[1] + "," + testCaseNACV1[2] + "]" );

		//test case 2 for method changeValues
		int[] testCaseCV2 = {44,2,45};
		int[] testCaseNACV2 = changeValues(testCaseCV2);
		System.out.println("Testing changeValues Test Case 2: Expecting [45,45,45]. Method actually returned: " + "[" + testCaseNACV2[0] + "," + testCaseNACV2[1] + "," + testCaseNACV2[2] + "]" );

		//test case 3 for method changeValues
		int[] testCaseCV3 = {145,56,123};
		int[] testCaseNACV3 = changeValues(testCaseCV3);
		System.out.println("Testing changeValues Test Case 3: Expecting [145,145,145]. Method actually returned: " + "[" + testCaseNACV3[0] + "," + testCaseNACV3[1] + "," + testCaseNACV3[2] + "]" );

		//test case 4 for method changeValues
		int[] testCaseCV4 = {};
		int[] testCaseNACV4 = changeValues(testCaseCV4);
		System.out.println("Testing changeValues Test Case 4: Expecting empty/0. Method actually returned: " + testCaseNACV4.length);
		System.out.println("------------Done Testing Method: changeValues----------");

		System.out.printf("%n");

		System.out.println("------------Testing Method: sumOfValues----------");
		//test case 1 for method sumOfValues
		int[] testCase1SOM = {};
		System.out.println("Testing sumOfValues Test Case 1: Expecting 0. Method actually returned: " + sumOfValues(testCase1SOM));

		//test case 2 for method sumOfValues
		int[] testCase2SOM = {1,2,3,4,6,5,45,34,7,43,2,1};
		System.out.println("Testing sumOfValues Test Case 2: Expecting 56. Method actually returned: " + sumOfValues(testCase2SOM));

		//test case 3 for method sumOfValues
		int[] testCase3SOM = {3,2,3,4,4,67,6,32,5,2,5,1,2,3,7,2,14,5,4};
		System.out.println("Testing sumOfValues Test Case 3: Expecting 108. Method actually returned: " + sumOfValues(testCase3SOM));

		//test case 4 for method sumOfValues
		int[] testCase4SOM = {1,2,6,3,2,1,7,2};
		System.out.println("Testing sumOfValues Test Case 4: Expecting 5. Method actually returned: " + sumOfValues(testCase4SOM));

		//test case 5 for method sumOfValues
		int[] testCase5SOM = {1,6,7,1};
		System.out.println("Testing sumOfValues Test Case 5: Expecting 2. Method actually returned: " + sumOfValues(testCase5SOM));
		System.out.println("------------Done Testing Method: sumOfValues----------");
		System.out.printf("%n");

		System.out.println("Done testing all methods! :-)");
	}
}