import java.util.Scanner;

class PasswordChecker{
	static Scanner input = new Scanner(System.in);
	static int capitalLetterLocated = 0;
	static int lowerCaseLetterLocated = 0;
	static int characterAmountPassed = 0;
	static int digitLocated = 0;
	static int specialCharacterLocated = 0;
	static int otherCharactersLocated = 0;
	static int digitLocated2 = 0;
	static int specialCharacterLocated2 = 0;

	public static boolean characterAmount(String password){
		if(password.length() > 8){
			characterAmountPassed = 1;
		}else if(password.length() < 8){
			characterAmountPassed = 0;
		}if(characterAmountPassed == 1){
			System.out.println("Does the password have more than 8 characters? : Yes");
			return true;
		}else if(characterAmountPassed == 0){
			System.out.println("Does the password have more than 8 characters? : No, your password has to be at least more than 8 characters long");
			return false;
		}
		return true;
	}

	public static boolean capitalLetterPresent(String password){
		for(int i = 0; i < password.length(); i++){
			if(password.charAt(i) > 64 && password.charAt(i) < 91){
				capitalLetterLocated += 1;
			}else{
				otherCharactersLocated += 1;
			}
		}if(capitalLetterLocated > 0){
			System.out.println("Has a captial letter been located? : Yes");
			return true;
		}else if(capitalLetterLocated == 0){
			System.out.println("Has a capital letter been located? : No, your password needs at least one captial letter");
			return false;
		}
		return true;
	}

	public static boolean lowerCaseLetterPresent(String password){
		for(int x = 0; x < password.length(); x++){
			if(password.charAt(x) > 96 && password.charAt(x) < 123){
				lowerCaseLetterLocated += 1;
			}else{
				otherCharactersLocated += 1;
			}if(lowerCaseLetterLocated > 0){
				System.out.println("Has a lowercase letter been located? : Yes");
				return true;
			}else if(capitalLetterLocated == 0){
				System.out.println("Has a lowercase letter been located? : No, your password needs at least one lowercase letter");
				return false;
			}
		}
		return true;
	}	

	public static int digitPresent(String password){
		if(password.length() == 0){
			return 0;
		}
		int n = 0;
		if(password.charAt(n) > 47 && password.charAt(n) < 58){
			digitLocated += 1;
			n += 1;
		}
		if(n == 1){
			digitLocated2 = 1;
		}
		String remainingPassword = password.substring(1);
		return digitLocated + digitPresent(remainingPassword);
	}

	public static int speicalCharacterPresent(String password){
		int s = 0;
		if(password.length() == 0){
			return 0;
		}
		if((password.charAt(s) > 35 && password.charAt(s) < 39) || password.charAt(s) == 33 || password.charAt(s) == 64){
			specialCharacterLocated += 1;
			s += 1;
		}
		if(s == 1){
			specialCharacterLocated2 = 1;
		}
		String remainingPassword = password.substring(1);
		return specialCharacterLocated + speicalCharacterPresent(remainingPassword);
	}

	public static void main (String[]args){
		boolean running = true;
		System.out.printf("%n");
		System.out.println("Your password is ready to be set!");
		System.out.println("*************************");
		System.out.println("Your password must have: more than 8 characters, 1 capital letter, 1 lowercase letter, 1 digit, and 1 special character!");
		System.out.printf("%n");
		System.out.println("Please enter in a password you would like to use: ");
		String password = input.nextLine();
		System.out.printf("%n");
		characterAmount(password);
		capitalLetterPresent(password);
		lowerCaseLetterPresent(password);
		digitPresent(password);
		speicalCharacterPresent(password);
			if(characterAmountPassed == 1 && capitalLetterLocated >= 1 && lowerCaseLetterLocated >= 1 && speicalCharacterPresent(password) > 0 && digitPresent(password) > 0){
				System.out.println("Has a digit been located? : Yes");
				System.out.println("Has a special character been located? : Yes");
				System.out.println("*************************");
				System.out.println("Your password is strong and good to go :-)! ");
				return;
			}
			if(digitLocated2 == 0){
				System.out.println("Has a digit been located? : No, your password needs at least one digit");
			}
			if(digitLocated2 == 1){
				System.out.println("Has a digit been located? : Yes");
			}
			if(specialCharacterLocated2 == 0){
				System.out.println("Has a special character been located? : No, your password needs at least one special character");
			}
			if(specialCharacterLocated2 == 1){
				System.out.println("Has a special character been located? : Yes");
			}
			if(characterAmountPassed == 0 || capitalLetterLocated == 0 || lowerCaseLetterLocated == 0){
				System.out.println("*************************");
				System.out.println("Invalid Password. Your password did not meet the criteria :-(");
			}
	}
}


