import java.util.Scanner;
import java.util.Random;

/*notes
can set an int named count and while it is less than the number of hints-- increment by 1
*/

/* Mary Vu
   [CS1101] Comprehensive Lab 1
   This work is to be done individually. It is not permitted to. 
   share, reproduce, or alter any part of this assignment for any 
   purpose. Students are not permitted from sharing code, uploading 
   this assignment online in any form, or viewing/receiving/
   modifying code written from anyone else. This assignment is part. 
   of an academic course at The University of Texas at El Paso and 
   a grade will be assigned for the work produced individually by 
   the student.
*/

class GuessingGame{
	public static void main (String[]args){

		//intializing the variables
		String yes = "yes";
		String no = "no";
		int hints = 0;
		int guessCounter = 0;
		int i = 0;
		int minimum = 0;
		int maximum = 100;

		Scanner input = new Scanner(System.in);
		Scanner keyboard = new Scanner(System.in);

		//initializing the random class and adding a range for the random number generator
		Random number = new Random();
		int randomNumber;
		randomNumber = number.nextInt(minimum,maximum);

		System.out.println("Welcome to the Guessing Game! You will have to guess the msyterious number!");

		//turning on/off the hints and quit setting
		System.out.println("Would you like to know if your number needs to be lower or higher? Type yes or no.");
			String answer = keyboard.nextLine();
			if(answer.equals(yes)){
				hints = 1;
				System.out.println("You have requested hints to be given!");
			}else if(answer.equals(no)){
				hints = 0;
				System.out.println("You have opted out of hints.");
			}

		//user sets the amounts of lives that they want
		System.out.println("Please enter the amount of lives you want >:-) : ");
		int lives = input.nextInt();

		//while loop to keep the game running as long i is less than the amount of lives the user requested
		System.out.println("Please enter you guess ranging from 0-100: ");
		while(i < lives){
		i++;
		int playerNumberChoice = input.nextInt();

			if(hints == 1 && playerNumberChoice > randomNumber){
				guessCounter = guessCounter +1;
				System.out.println("You need to guess lower.");
				System.out.println("You have " + (lives - guessCounter) + " lives left.");
			}else if(hints == 1 && playerNumberChoice < randomNumber){
				guessCounter = guessCounter +1;
				System.out.println("You need to guess higher.");
				System.out.println("You have " + (lives - guessCounter) + " lives left.");
			}else{
				guessCounter = guessCounter +1;
				System.out.println("You have " + (lives - guessCounter) + " lives left.");
			}
			if(guessCounter == lives){
				System.out.println("You used up all your lives :-(");
				System.out.println("The correct number was " + randomNumber + ".");
			}else if(playerNumberChoice == randomNumber){
				System.out.println("You guessed the number " + randomNumber + " correctly!");
				System.out.println("You guessed the number with " + (lives - guessCounter) + " lives left! :-)");
				break;
			}
		}
	}
}
