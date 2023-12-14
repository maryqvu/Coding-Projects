class Factorial{
	public static void main (String[] args){
		System.out.println(factorialMethod(3));
		System.out.println(factorialMethod(4));
		System.out.println(factorialMethod(5));
		System.out.println(factorialMethod(0));

	}

	public static int factorialMethod(int n){
		if(n == 0){
			return 1;
		}
		if(n == 1){
			return 1;
		}
		return n * factorialMethod(n-1);
	}
}