import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;

class testCode{

  	public static int sum(int[] nums, int key, int index){
  		int sumOFNums = 0;

  		int length = nums.length;
  		if(index == length){
  			return sumOFNums;
  		}
  		if(nums[index] > key){
  			sumOFNums += nums[index];
  		}
  		return sumOFNums += sum(nums, key, index + 1);
  	}

    public static void loadFromCSV (String filename){
        String line;
        String splitBy = ",";

        try{
            BufferedReader readCSV = new BufferedReader(new FileReader(filename));
            readCSV.readLine();


            while((line = readCSV.readLine()) != null){
                String[] earthquakeData = line.split(splitBy);
                	Double magnitude = Double.valueOf(earthquakeData[4]);
                	String date = earthquakeData[0];
                	String place = earthquakeData[13];
        			Earthquake eq = new Earthquake(magnitude, place, date);
               		bsTree.add(eq);
            }
        }catch(Exception e){
            System.out.println("error reading file: " + e.getMessage());
        }
    }

    private static EarthquakeBinarySearchTree bsTree;

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {


        //Initialize the binary search tree (will be empty)
        bsTree = new EarthquakeBinarySearchTree();

        //Load default data to the BSTree
		loadFromCSV("earthquakes.csv");

        System.out.println();
        int choice;

        do {

            System.out.println("----- Earthquake Menu -----");
            System.out.println("1. Add to BSTree");
            System.out.println("2. Search by magnitude");
            System.out.println("3. Search by magnitude range");
            System.out.println("4. Display tree (asc)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addToBSTree();
                    break;
                case 2:
                    searchByMagnitude();
                    break;
                case 3:
                    rangeOfEarthquake();
                    break;
                case 4:
                    bsTree.display();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
            }
        } while (choice != 5);

    }

    private static void addToBSTree() {
        
        System.out.println("Enter earthquake data (magnitude, place, date):");
        System.out.print("Magnitude: " );
        double magnitude = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("place: " );
        String place = scanner.nextLine();
        System.out.print("date: " );
        String date = scanner.nextLine();
        Earthquake eq = new Earthquake(magnitude, place, date);
        bsTree.add(eq);
        System.out.println("Earthquake added to the tree.");
    }

    private static void searchByMagnitude() {
        
        System.out.println("Enter the magnitude to search for:");
        double magnitude = scanner.nextDouble();
        Earthquake result = bsTree.search(magnitude);
        if (result != null) {
            System.out.println("Earthquake found: [" + result.getMagnitude() + " || " + result.getPlace() + " || " + result.getDate() + "]");
        } else {
            System.out.println("No earthquake with the given magnitude found.");
        }
    }

    private static void rangeOfEarthquake(){
        System.out.println("Enter the minimum magnitude you would to search from: ");
        double minMag = scanner.nextDouble();
        System.out.println("Enter the maximum magnitude you would like to search from: ");
        double maxMag = scanner.nextDouble();
        Earthquake result = bsTree.searchRange(minMag, maxMag);
        while(result != null){
            System.out.println("The Earthquakes with magnitudes between the range are: ");
            System.out.println("Earthquake: [" + result.getMagnitude() + " || " + result.getPlace() + " || " + result.getDate() + "]");
        }
        System.out.println("No earthquake are found within the given range");
    }

    public static void test(){
        boolean i = true;
        int a = 0;
        int b = 0;

        while(i){
            a = 1;
            b = 1;
            System.out.println(a);
            System.out.println(b);
            a = 0;
            b = 0;
            System.out.println(a);
            System.out.println(b);
        }
    }

    static boolean isBalanced(String expr) {
    int open = 0;
    int close = 0;

    Stack aStack = new Stack();
    Stack bStack = new Stack();
        
    for(int i = 1; i < expr.length(); i++){
      if(expr.charAt(i) == '(' || expr.charAt(i) == ')'){
        aStack.push(expr.charAt(i));
      }
    }

    while(!aStack.isEmpty()){
      bStack.push(aStack.pop());
    }

    while(!bStack.isEmpty()){
      if((Character)bStack.peek() == '('){
        System.out.print(bStack.pop());
        open += 1;
      }else if((Character)bStack.peek() == ')'){
        System.out.print(bStack.pop());
        close += 1;
      }
    }


    System.out.println();
    System.out.println(open);
    System.out.println(close);

    if(open == close){
      System.out.println("The expression is: balanced");
      return true;
    }
    System.out.println("The expression is: not balanced");
    return false;
    }


}