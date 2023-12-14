import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class Lab1_Vu{
	public static void main(String[]args){
		int[][] spookyArray = new int[10][10];

		int numRows = spookyArray.length;
        int numCols = spookyArray[0].length;
		int spookyNumberCount = 0;

		try{
			File spookyFile = new File("spooky.txt");
			Scanner ScanFile = new Scanner(spookyFile);

			while(ScanFile.hasNextLine()){
				for(int row = 0; row < spookyArray.length; row++){
					String[] line = ScanFile.nextLine().trim().split(", ");
					for(int column = 0; column < line.length; column++){
						spookyArray[row][column] = Integer.parseInt(line[column]);
					}
				}
			}
		for (int r = 0; r < numRows; r++) {
        	for (int c = 0; c < numCols; c++) {
                if (isSpooky(spookyArray[r][c], spookyArray, r, c)) {
                	spookyNumberCount += 1;
                	System.out.println();
                    System.out.println("Cell (" + r + ", " + c + ") with value " + spookyArray[r][c] + " is spooky. The spooky number is 2 times greater than the average: " + averageOfNieghbors(spookyArray[r][c], spookyArray, r, c));
                }
            }
        }
        System.out.println();
        System.out.println("Spooky number total count: " + spookyNumberCount);

		}
		catch(Exception e){
			System.out.println("Error reading file");
		}
}
	public static double averageOfNieghbors (int x, int[][] arr, int row, int col){
		int sum = 0;
        int count = 0;


        int[] rowCoordinateNeighbor = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] columnCoordinateNeighbor = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + rowCoordinateNeighbor[i];
            int newCol = col + columnCoordinateNeighbor[i];

            if (newRow >= 0 && newRow < arr.length && newCol >= 0 && newCol < arr[0].length) {
                sum += arr[newRow][newCol];
                count++;
            }
        }

        double average = (double) sum / count;
        return average;
	}

    //Function to check if a number is spooky
    public static boolean isSpooky(int x, int[][] arr, int row, int col) {
        int sum = 0;
        int count = 0;


        int[] rowCoordinateNeighbor = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] columnCoordinateNeighbor = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + rowCoordinateNeighbor[i];
            int newCol = col + columnCoordinateNeighbor[i];

            if (newRow >= 0 && newRow < arr.length && newCol >= 0 && newCol < arr[0].length) {
                sum += arr[newRow][newCol];
                count++;
            }
        }

        double average = (double) sum / count;
        return x > 2 * average;
    }

}