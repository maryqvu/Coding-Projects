

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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class Cl1_Vu{
	public static void main (String[]args) throws FileNotFoundException{
		Scanner input = new Scanner(System.in);
		Scanner keyboard = new Scanner(System.in);

		boolean running = true;
		double subtotal = 0;
		int foodCount = 0;
		int tester = 0;
		System.out.printf("%n");
		System.out.println("Welcome to UTEP Eats!");
		System.out.println("------------Menu—----------");
		System.out.println("Choose an option (1-5): ");
		System.out.println("1. Add a food");
		System.out.println("2. View cart");
		System.out.println("3. Clear cart");
		System.out.println("4. Checkout");
		System.out.println("5. Exit");

		int mainSelection = input.nextInt();
		String food = null;
		double price = 0;
		String yes = "yes";
		String no = "no";

		while(running){
		File foodFile = new File("food.txt");
		Scanner readFile = new Scanner (foodFile);
		Scanner reReadFile = new Scanner (foodFile);
		double total = subtotal + (subtotal * .0725);
		if(mainSelection == 1){
		System.out.println("------------Food Menu----------");
			try{
				while(readFile.hasNextLine()){
					food = readFile.next();
					price = Double.valueOf(readFile.next());
					System.out.println(food + " " + price);
				}	
		}catch(Exception e){
			System.out.println("--------------------------");
		}
		System.out.println("Plese enter the food you like to add to your cart: ");
		String foodEntry = keyboard.nextLine();
		try{
			while(reReadFile.hasNextLine()){
				food = reReadFile.next();
				price =Double.valueOf(reReadFile.next());
				if(foodEntry.equalsIgnoreCase(food)){
					System.out.println("Enter the quantity: ");
					int foodQuantity = input.nextInt();
					foodCount += foodQuantity;
					subtotal += price * foodQuantity;
						if(foodQuantity == 1){
							System.out.printf("%n");
							System.out.println(foodQuantity + " " + foodEntry + " has been added to your cart!");
							System.out.println("--------------------------");
						}else if(foodQuantity > 1){
							System.out.printf("%n");
							System.out.println(foodQuantity + " " + foodEntry + "s" + " have been added to your cart!");
							System.out.println("--------------------------");
						}					
				}
			}
		}catch(Exception i){
		System.out.printf("%n");
		}
		System.out.println("------------Menu—----------");
		System.out.println("Choose an option (1-5): ");
		System.out.println("1. Add a food");
		System.out.println("2. View cart");
		System.out.println("3. Clear cart");
		System.out.println("4. Checkout");
		System.out.println("5. Exit");
		}else if(mainSelection == 2){
			System.out.println("------------Cart----------");
			System.out.printf("%n");
			System.out.println("Number of items: " + foodCount);
			System.out.println("Subtotal: " + subtotal);
			System.out.printf("%n");
			System.out.println("--------------------------");
			System.out.printf("%n");
			System.out.println("------------Menu—----------");
			System.out.println("Choose an option (1-5): ");
			System.out.println("1. Add a food");
			System.out.println("2. View cart");
			System.out.println("3. Clear cart");
			System.out.println("4. Checkout");
			System.out.println("5. Exit");
		}else if(mainSelection == 3){
			if(foodCount == 0 || subtotal == 0){
				System.out.println("--------------------------");
				System.out.printf("%n");
				System.out.println("Your cart is currently empty. There is nothing to clear.");
				System.out.println("Returning back to the main menu!");
				System.out.printf("%n");
				System.out.println("--------------------------");
				System.out.printf("%n");
				System.out.println("------------Menu—----------");
				System.out.println("Choose an option (1-5): ");
				System.out.println("1. Add a food");
				System.out.println("2. View cart");
				System.out.println("3. Clear cart");
				System.out.println("4. Checkout");
				System.out.println("5. Exit");		
			}else if(foodCount != 0 || subtotal != 0){
				System.out.println("--------------------------");
				System.out.println("Are you sure you want to clear your cart? Enter 'yes' to clear, enter 'no' to not make any changes.");
				String answer = keyboard.nextLine();
					if(answer.equals(yes)){
						foodCount = 0;
						subtotal = 0;
						System.out.println("------------Cart----------");
						System.out.printf("%n");
						System.out.println("Your cart is now empty.");
						System.out.println("Number of items: " + foodCount);
						System.out.println("Subtotal: " + subtotal);
						System.out.printf("%n");
						System.out.println("--------------------------");
						System.out.printf("%n");
						System.out.println("------------Menu—----------");
						System.out.println("Choose an option (1-5): ");
						System.out.println("1. Add a food");
						System.out.println("2. View cart");
						System.out.println("3. Clear cart");
						System.out.println("4. Checkout");
						System.out.println("5. Exit");				
					}else if(answer.equals(no)){
						System.out.println("--------------------------");
						System.out.printf("%n");
						System.out.println("No changes have been made to your cart.");
						System.out.println("Returning back to the main menu!");
						System.out.printf("%n");
						System.out.println("--------------------------");
						System.out.printf("%n");
						System.out.println("------------Menu—----------");
						System.out.println("Choose an option (1-5): ");
						System.out.println("1. Add a food");
						System.out.println("2. View cart");
						System.out.println("3. Clear cart");
						System.out.println("4. Checkout");
						System.out.println("5. Exit");		
					}
			}
		}else if(mainSelection == 4){
			System.out.printf("%n");
			System.out.println("Please choose an option below: ");
			System.out.println("1. Pickup  2. Delivery");
			int deliverySelection = input.nextInt();
				if(deliverySelection == 1){
					System.out.printf("%n");
					System.out.println("Order Information: ");
					System.out.println("Number of items: " + foodCount);
					System.out.println("Total: " + total);
					System.out.println("Please enter your 16 digit credit card number: ");
					double creditCardInfo = input.nextDouble();
					System.out.printf("%n");
					System.out.println("-------Receipt-------");
					System.out.printf("%n");
					System.out.println("Number of total items: " + foodCount);
					System.out.printf("%n");
					System.out.println("Subtotal: " + subtotal);
					System.out.println("Taxes: " + (subtotal * .0725));
					System.out.println("*************************");
					System.out.println("Total: " + total);
					System.out.printf("%n");
					System.out.println("-------Receipt-------");
					System.out.println("Success! Thank you for shopping with UTEP Eats!");
					return;
				}else if(deliverySelection == 2){
					System.out.printf("%n");
					System.out.println("There is a $5 delivery fee.");
					double deliveryFee = 5.0;
					System.out.println("Please enter your address: ");
					String deliveryAddress = keyboard.nextLine();
					System.out.println("You entered: " + deliveryAddress);
					System.out.printf("%n");		
					System.out.println("Would you like to add a tip?");
					System.out.println("1. Yes  2. No");
					int tipSelection = input.nextInt();
						if(tipSelection == 1){
							System.out.printf("%n");		
							System.out.println("Would you like to type in a percentage or a dollar amount?");
							System.out.println("1. Percentage  2. Dollar amount");
							int tipType = input.nextInt();
								if(tipType == 1){
									System.out.println("Please input in the percentage: ");
									double percentage = input.nextInt();
									percentage = percentage / 100;
									total = total + (subtotal * percentage) + deliveryFee;
									System.out.println("-------Order Information-------");
									System.out.println("Number of items: " + foodCount);
									System.out.println("Total: " + total);
									System.out.println("Please enter your 16 digit credit card number: ");
								double creditCardInfo = input.nextDouble();
								System.out.printf("%n");		
								System.out.println("-------Receipt-------");
								System.out.printf("%n");
								System.out.println("Number of total items: " + foodCount);
								System.out.printf("%n");
								System.out.println("Subtotal: " + subtotal);
								System.out.println("Taxes: " + (subtotal * .0725));
								System.out.println("Delivery Fee: " + deliveryFee);
								System.out.println("Tip amount: " + (subtotal * percentage));
								System.out.println("*************************");
								System.out.println("Total: " + total);
								System.out.printf("%n");
								System.out.println("-------Receipt-------");
								System.out.println("Success! Thank you for shopping with UTEP Eats!");
								return;
								}else if(tipType == 2){
									System.out.println("Please enter your tip amount: ");
									double tipAmount = input.nextDouble();
									total = total + tipAmount + deliveryFee;	
									System.out.println("-------Order Information-------");
									System.out.println("Number of items: " + foodCount);
									System.out.println("Total: " + total);
									System.out.println("Please enter your 16 digit credit card number: ");
									double creditCardInfo = input.nextDouble();
									System.out.printf("%n");		
									System.out.println("-------Receipt-------");
									System.out.printf("%n");
									System.out.println("Number of total items: " + foodCount);
									System.out.printf("%n");
									System.out.println("Subtotal: " + subtotal);
									System.out.println("Taxes: " + (subtotal * .0725));
									System.out.println("Delivery Fee: " + deliveryFee);
									System.out.println("Tip Amount: " + tipAmount);
									System.out.println("*************************");
									System.out.println("Total: " + total);
									System.out.printf("%n");
									System.out.println("-------Receipt-------");
									System.out.println("Success! Thank you for shopping with UTEP Eats!");
									return;
								}
						}else if(tipSelection == 2){
							total = total + deliveryFee;
							System.out.println("-------Order Information-------");
							System.out.println("Number of items: " + foodCount);
							System.out.println("Total: " + total);
							System.out.println("Please enter your 16 digit credit card number: ");
							double creditCardInfo = input.nextDouble();
							System.out.printf("%n");
							System.out.println("-------Receipt-------");
							System.out.printf("%n");
							System.out.println("Number of total items: " + foodCount);
							System.out.printf("%n");
							System.out.println("Subtotal: " + subtotal);
							System.out.println("Taxes: " + (subtotal * .0725));
							System.out.println("Delivery Fee: " + deliveryFee);
							System.out.println("*************************");
							System.out.println("Total: " + total);
							System.out.printf("%n");
							System.out.println("-------Receipt-------");
							System.out.println("Success! Thank you for shopping with UTEP Eats!");
							return;
						}
				}
		}else if(mainSelection == 5){
			System.out.println("Cart abandoned. Thank you for using UTEP Eats! Goodbye!");
			return;	
		}
	mainSelection = input.nextInt();		
		}
	}
}



