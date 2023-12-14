class found7{
	public static void main (String[] args){
		int[] array = {4, 5, 0, 7, 7, 10};

		System.out.println(contain7(array, 6));
	}

	public static boolean contain7(int[] arr, int length){
		if(length != 0){
			if(arr[length-1] != 7){
				return contain7(arr, length -1);
			}
			else{
				return true;
			}
		}
		return false;
	}
}