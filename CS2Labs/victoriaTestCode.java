import java.util.Scanner;

class victoriaTestCode{
	public static void main(String[] args){
		//int stopCode;
		System.out.println("hi");
		System.out.println("--testing code--");
		testLED();
	}

	public static void testLED(){
		Scanner userInput = new Scanner(System.in);
		boolean run = true;

		System.out.println("put in '1' to start the swtich cases: ");
		int user = userInput.nextInt();

		if(user == 1){
			switch(switchExpression){
				case 0:
					System.out.println("0");
					user = userInput.nextInt();

				case 1:
					System.out.println("1");
					user = userInput.nextInt();

				case 2:
					System.out.println("2");
					user = userInput.nextInt();

				case 3:
					System.out.println("3");
					user = userInput.nextInt();
			}
		}
	}
}