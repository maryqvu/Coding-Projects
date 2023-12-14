public class act3{
	public static void main (String[] args){
		System.out.println(recursive(10));
		System.out.println(recursive(5));

	}

	public static int recursive(int n){
		if(n <= 1){
			return n;
		}
		return 3 * recursive(n-1) + 5;
	}
}
