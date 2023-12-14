/* MARY VU
[CS2401 - FA23]
This work is to be done individually. It is not permitted to share, reproduce, or alter any part of this
assignment for any purpose. Students are not permitted from sharing code, uploading this
assignment online in any form, or viewing/receiving/modifying code written from anyone else. This
assignment is part of an academic course at The University of Texas at El Paso and a grade will be
assigned for the work produced individually by the student. */

public class Lab5_Vu {

	public static void main(String[] args) {

		AsteroidLinkedList myAwesomeAsteroidList = new AsteroidLinkedList();

		myAwesomeAsteroidList.getAsteroidFromDataFile("input.txt");
		System.out.println("--------------------------------------");
		System.out.println("Printing the Linked List");
		myAwesomeAsteroidList.printLL();

		System.out.println("--------------------------------------");
		System.out.println("Average mass of all the elements in the list: " + myAwesomeAsteroidList.getAverageMass());

		Asteroid[] asteroidsAsArray = myAwesomeAsteroidList.toArray();

		System.out.println("--------------------------------------");
		System.out.println("Average mass of all the elements in the array: " + computeAverageMass(asteroidsAsArray));

		System.out.println("--------------------------------------");
		System.out.println("[Collatz Sequence] The sequence should end in 4 2 1 regardless of what the input number is: ");
		collatzSequence(915);

	}

	/**
	 * Compute the average mass of all objects (helper function)
	 * 
	 * @param asteroids
	 * @return
	 */
	public static double computeAverageMass(Asteroid[] asteroids) {
		double sum = 0.0;
		double average = 0.0;

		for(int i = 0; i < asteroids.length; i++){
			sum += asteroids[i].getMass();
		}

		average = sum/asteroids.length;
		return average;
	}

	/**
	 * Compute the sum of the mass of all the objects in the array using recursion
	 * 
	 * @param asteroids
	 * @param index
	 * @return
	 */
	public static double computeSumMassRecursive(Asteroid[] asteroids, int index) {
		
       if(asteroids == null){
       	return 0.0;
       }

       double total = asteroids[index].getMass();
       System.out.println(total);
       return total + asteroids[index+1].getMass();
	}

	/**
	 * Generates the Collatz sequence for a given positive integer.
	 *
	 * The Collatz sequence is generated recursively based on the following rules:
	 * - If the current number is even, the next number is obtained by dividing it
	 * by 2.
	 * - If the current number is odd, the next number is obtained by multiplying it
	 * by 3 and adding 1.
	 * - If n is 1, print the number and terminate the recursion
	 * The sequence is printed to the console.
	 *
	 * @param n The positive integer for which the Collatz sequence will be
	 *          generated.
	 */
	public static void collatzSequence(int n) {
		System.out.print(n + "  ");
		if(n == 1){
			return;
		}

		else if(n % 2 == 1){
			n = (n * 3) + 1;
			collatzSequence(n);
		}

		else if(n % 2 == 0){
			n = n/2;
			collatzSequence(n);
		}
		
	}

}