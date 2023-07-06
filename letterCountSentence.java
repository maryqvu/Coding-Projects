import java.util.Scanner;

class letterCountSentence{
	
	public static void main (String[]args){

		Scanner keyboard = new Scanner(System.in);
		System.out.print("Type in any sentence: ");
		String sentence = keyboard.nextLine(); //nextLine takes the entire into account the entire string until it is ended; while next just takes the first section of the string into account

		int charCount = 0; // <--- desired variable || setting the integer charCount variable to 0 
		for(int i =0; i<sentence.length(); i++){ 
			charCount++;
		}
/*
- A for loop to count the number of characters in the string
- You dont have to use the letter i specifically for the for loop; any letter is fine.

- Explaining the structure of the for loop:

1. You set your desried variable to 0 before structuring the for loop;
2. Begin structuring the for loop right below the desired variable
3. set an int variable to 0; you don't have to specifically use 'i', but it is the most common one
4. When i is still less than the length of the sentence, increment i;
5. As i continues to increase, increase your desired variable

*/
		System.out.println("Your sentence: " + sentence + " has a total of " + charCount + " characters.");

	}
}