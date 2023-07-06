/* 

	Mary Vu
   [CS1101] Comprehensive Lab 2
   This work is to be done individually. It is not permitted to. 
   share, reproduce, or alter any part of this assignment for any 
   purpose. Students are not permitted from sharing code, uploading 
   this assignment online in any form, or viewing/receiving/
   modifying code written from anyone else. This assignment is part. 
   of an academic course at The University of Texas at El Paso and 
   a grade will be assigned for the work produced individually by 
   the student.

*/
import java.util.*;
import java.util.Scanner;

class CL2_Vu{
    //allows these certain variables to be called anywhere within the class
    static Scanner input = new Scanner(System.in);  
    static int[] board = new int[0];   
    static int[] playingBoard = new int[0]; 
    static int boardSize = 0;   
    static int mainMenuSelection = 0;   
    static int userAttempts = 0;
    static int cellSelected = 0;
    static int matchingCell = 0;
    static int attempts = 0;
    static boolean running = true;
    static int boardLength = 0;

    private static int[] setupBoard(){
        System.out.println("Choose the size of the board you want to play with! It must be an even number greater than 0 >:-)");
        boardSize = input.nextInt();    //asks for user input to select the board size that they want
        while(running){                 //while the boolean running is true, it will run the method
            if(boardSize % 2 == 1 || boardSize == 0){   //if the board size is not even or it is equal to zero, the method will continue to ask the user to input a different number
                System.out.println("Please enter an even number greater than zero for the board");
                boardSize = input.nextInt();
            }else if(boardSize % 2 == 0){   //if the board size is an even number, it will set the board and playingBoard to that size
                board = new int[boardSize];
                playingBoard = new int[boardSize];
                boardLength = board.length;
                System.out.println("Your board size has been set!");
                System.out.println("Your board length is set to: " + board.length);
                placePairs(board);  //calls the placePair method to set up the board
                return board;
            }
        }
        running = false;    //ends the while loop
        return board;
    }
    
    private static void placePairs(int[] board) {
        Random rand = new Random();
        // place the values in the array in order
        for (int i = 0; i < board.length; i++)
            board[i] = i / 2 + 1;
        // perfect array shuffle
        // swap the ith value with a random value from index i to end of array
        for (int i = 0; i < board.length - 1; i++) {
            int j = rand.nextInt(board.length - i);
            int temp = board[i];
            board[i] = board[j];
            board[j] = temp;
        }
    }

    private static void displayMainMenu(int attempts){  //parameters is attempts
        attempts = boardSize + 2;   //sets the variable attempts to the board size + 2
        System.out.println("--------------------------");
        System.out.println("Do you wish to play for: ");
        System.out.println("1. " + attempts + " attempts");
        System.out.println("2. Unlimited amount of attempts");
        System.out.println("3. Exit game");
        mainMenuSelection = input.nextInt();    //asks what menu type they want to select
    }
    
    private static void displayBoard(int[] board, int index){
        //base case: if the index is equal to the length of the board, then it will print out the question marks
        if(index == board.length){  
            System.out.printf("%n" + "\u001B[0m");
            for(int i = 0; i < board.length; i++){  //loops through the board array
                if(playingBoard[i] != 0){   //if an index of the playingBoard contains a number, it will print out the number instead of a ?
                    System.out.print("\u001B[5m" + "\u001B[31m" + "\u001B[4m" + "\u001B[1m" + playingBoard[i] + "\u001B[0m" + "|" + "    ");
                }else{
                    System.out.print("\u001B[0m" + "?" + "|" + "    ");
                }
            }
            return;
        }
        else{
            System.out.print("\u001B[34m" + index + "|" + "    "); //recursive case: it will print out the index of the board
            displayBoard(board, index + 1); //recursively checks next element
        }
    }

    private static boolean isWithinBounds(int boardLength, int cell){
        if(cell > boardLength){ //if the cell they choose is greater than the board length then it will return false
            return false;
        }else if(cell >= 0 && cell < boardLength){  //if the cell they choose is greater than or equal to 0 and less than the board length, then it will return true
            return true;
        }
        return true;
    }

    private static boolean isCellSelected(int[] board, int cell){
        if(playingBoard[cell] != 0){    //if the cell within the playingBoard is not zero, then it will state that the board has been cleared
            return true;    //returns true
        }else if(playingBoard[cell] == 0){  //if the cell within the playingBoard is zero, it will state that there are pairs to be found
            return false;   //returns false
        }
        return true;
    }

    private static void clearCell(int[] board, int cell, int value){
        playingBoard[cell] = value; //the selected cell will be changed to the new value
        System.out.println("cell " + cell + " has been changed to: " + value);
    }

    private static boolean isBoardCleared(int[] board, int index){
        //base case: if it reaches the end of the array and no zero was found, then return true
        if(index == playingBoard.length){
            return true;
        }
        //returns false if a zero was found
        if(playingBoard[index] == 0){
            return false;
        }
        //recursively checks next element
        return isBoardCleared(board, index +1);
    }

    private static int runGame(int[] playingBoard, int[] board) throws ArrayIndexOutOfBoundsException{
        attempts = boardSize + 2; //makes attempt add up to the board size + 2
        //if the user decided to have a limited amount of attempts to match all of the numbers
        if(mainMenuSelection == 1){ //based on menu selection
            displayBoard(playingBoard,0);   //displays the playing board
            while(userAttempts < attempts){
                System.out.printf("%n");
                System.out.println("What cell would you like to guess?");
                cellSelected = input.nextInt(); //asks for user input to select which cell they would like to guess
                if(isCellSelected(playingBoard, cellSelected)){ //if the cell they selected has a value placed in it already, then it will not let them choose it again
                    System.out.println("It looks like that cell has already been found");
                    System.out.println("Try selecting a different cell");
                    displayBoard(playingBoard, 0);  //displays the board again for the user to select a different cell
                    System.out.printf("%n");
                    cellSelected = input.nextInt(); 
                    playingBoard[cellSelected] = board[cellSelected];   //the new selected cell on the playing board will then be made equal to the value of the number at the same index on the board
                    System.out.printf("%n");
                    displayBoard(playingBoard,0);   //displays the board to the user
                    System.out.printf("%n");
                    System.out.println("You discovered: " + "\u001B[1m" + playingBoard[cellSelected]);
                    System.out.printf("%n");
                }else{
                    //if the selected cell does not already contain a value, the program will let then set the selected cell on the playing board equal to the value of the number at the same index on the board
                    playingBoard[cellSelected] = board[cellSelected];   
                    System.out.printf("\u001B[0m" + "%n");
                    displayBoard(playingBoard,0);   //displays the board to the user
                    System.out.printf("%n");
                    System.out.println("You discovered: " + "\u001B[1m" + playingBoard[cellSelected]);
                }
                //after the board is displayed with the first value, the program will then ask for the matching cell to be selected
                System.out.println("\u001B[0m" + "What cell do you think is the matching cell?");
                matchingCell = input.nextInt();
                //if the selected matching cell already has a value, the program will not let the user select it again
                //will prompt user to choose a new cell that does not have a value already
                //it will then set the new selected cell to the value at the same index on the board
                if(isCellSelected(playingBoard, matchingCell)){
                    System.out.println("It looks like that cell has already been found");
                    System.out.println("Try selecting a different cell");
                    displayBoard(playingBoard, 0);
                    System.out.printf("%n");
                    matchingCell = input.nextInt();
                    playingBoard[matchingCell] = board[matchingCell];
                    System.out.printf("%n");
                    displayBoard(playingBoard,0);
                    System.out.printf("%n");
                    System.out.println("You discovered: " + "\u001B[1m" + playingBoard[matchingCell]);
                }else{
                    //if the selected cell does not already contain a value, the program will let then set the selected cell on the playing board equal to the value of the number at the same index on the board
                    playingBoard[matchingCell] = board[matchingCell];
                    System.out.printf("\u001B[0m" + "%n");
                    displayBoard(playingBoard,0);
                    System.out.printf("%n");
                    System.out.println("You discovered: " + "\u001B[1m" + playingBoard[matchingCell]);
                }
                //if the two selected cells do not match, the program will let the user know
                //it will then set the two selected cells back to zero in order for them to not be displayed by the method displayBoard
                if(playingBoard[cellSelected] != playingBoard[matchingCell]){
                    System.out.println("\u001B[0m" + "Dang, those weren't pairs. Try guessing again!");
                    playingBoard[cellSelected] = 0;
                    playingBoard[matchingCell] = 0;
                    userAttempts += 1;  //increments the userAttempts by 1
                    System.out.println("Attempts left: " + "\u001B[4m" + (attempts - userAttempts));
                    System.out.printf("\u001B[0m" + "%n");
                    displayBoard(playingBoard,0);
                //if the two selected cell do match, the program will let them know
                }else if(playingBoard[cellSelected] == playingBoard[matchingCell]){
                    System.out.println("\u001B[0m" + "Nice! You found a pair!");
                    userAttempts += 1;  //increments the userAttempts by 1
                    System.out.println("Attempts left: " + "\u001B[4m" + (attempts - userAttempts));
                    System.out.printf("\u001B[0m" + "%n");
                    displayBoard(playingBoard,0);
                }
                //if the user has used all of their attempts and was able to clear the board, then the program will congratulate them
                //and end the program
                if(userAttempts == attempts && isBoardCleared(playingBoard, 0)){
                    System.out.printf("%n");
                    System.out.printf("%n");
                    System.out.println("Good job! You found all the matching pairs! >:-)");
                    displayBoard(playingBoard, 0);
                    return 3;
                //if the user was able to clear the board before using all of their attempts, the program will congratulate them
                //and end the program
                }else if(isBoardCleared(playingBoard, 0)){
                    System.out.printf("%n");
                    System.out.printf("%n");
                    System.out.println("Good job! You found all the matching pairs! >:-)");
                    displayBoard(playingBoard, 0);
                    return 3;
                }
            }
            //if the user was not able to clear the board before all of their attempts were used, then the program will let them know
            //that the game is over and will display the board and all of the answers showing
            System.out.printf("%n");
            System.out.println("GAME OVER");
            System.out.println("You didn't find all the matching pairs in time :-(");
            System.out.println("This is what the board looked like: ");
            for(int i = 0; i < playingBoard.length; i++){   //for loop to print out the indexes of the board
                System.out.print((i) + "|" + "    ");
            }
                System.out.printf("%n");
                for(int i = 0; i < board.length; i++){
                    System.out.print(board[i] + "|" + "    ");  //for loop to print out the values at the indexes of the board
                }
            return 0;
        //if the user decided to have unlimited attempts at matching the numbers
        }else if(mainMenuSelection == 2){
            displayBoard(playingBoard,0);
            //while loop that continues to run as long as the board is not cleared
            while(!isBoardCleared(playingBoard, 0)){
                System.out.printf("%n");
                System.out.println("What cell would you like to guess?");
                cellSelected = input.nextInt();
                //if the selected cell already has a value, the program will not let the user select it again
                //will prompt user to choose a new cell that does not have a value already
                //it will then set the new selected cell to the value at the same index on the board
                if(isCellSelected(playingBoard, cellSelected)){
                    System.out.println("It looks like that cell has already been found");
                    System.out.println("Try selecting a different cell");
                    displayBoard(playingBoard, 0);
                    System.out.printf("%n");
                    cellSelected = input.nextInt();
                    playingBoard[cellSelected] = board[cellSelected];
                    System.out.printf("%n");
                    displayBoard(playingBoard,0);
                    System.out.printf("%n");
                    System.out.println("You discovered: " + "\u001B[1m" + playingBoard[cellSelected]);
                    System.out.printf("%n");
                }else{
                    //if the selected cell does not already contain a value, the program will let then set the selected cell on the playing board equal to the value of the number at the same index on the board
                    playingBoard[cellSelected] = board[cellSelected];
                    System.out.printf("\u001B[0m" + "%n");
                    displayBoard(playingBoard,0);
                    System.out.printf("%n");
                    System.out.println("You discovered: " + "\u001B[1m" + playingBoard[cellSelected]);
                    System.out.printf("\u001B[0m" + "%n");
                }
                //after the board is displayed with the first value, the program will then ask for the matching cell to be selected
                System.out.println("\u001B[0m" + "What cell do you think is the matching cell?");
                matchingCell = input.nextInt();
                //if the selected matching cell already has a value, the program will not let the user select it again
                //will prompt user to choose a new cell that does not have a value already
                //it will then set the new selected cell to the value at the same index on the board
                if(isCellSelected(playingBoard, matchingCell)){
                    System.out.println("It looks like that cell has already been found");
                    System.out.println("Try selecting a different cell");
                    displayBoard(playingBoard, 0);
                    System.out.printf("%n");
                    matchingCell = input.nextInt();
                    playingBoard[matchingCell] = board[matchingCell];
                    System.out.printf("%n");
                    displayBoard(playingBoard,0);
                    System.out.printf("%n");
                    System.out.println("You discovered: " + "\u001B[1m" + playingBoard[matchingCell]);
                }else{
                    //if the selected cell does not already contain a value, the program will let then set the selected cell on the playing board equal to the value of the number at the same index on the board
                    playingBoard[matchingCell] = board[matchingCell];
                    System.out.printf("\u001B[0m" + "%n");
                    displayBoard(playingBoard,0);
                    System.out.printf("%n");
                    System.out.println("You discovered: " + "\u001B[1m" + playingBoard[matchingCell]);
                }
                //if the two selected cells do not match, the program will let the user know
                //it will then set the two selected cells back to zero in order for them to not be displayed by the method displayBoard
                if(playingBoard[cellSelected] != playingBoard[matchingCell]){
                    System.out.println("\u001B[0m" + "Dang, those weren't pairs. Try guessing again!");
                    playingBoard[cellSelected] = 0;
                    playingBoard[matchingCell] = 0;
                    System.out.printf("%n");
                    displayBoard(playingBoard,0);
                //if the two selected cell do match, the program will let them know
                }else if(playingBoard[cellSelected] == playingBoard[matchingCell]){
                    System.out.println("\u001B[0m" + "Nice! You found a pair!");
                    System.out.printf("%n");
                    displayBoard(playingBoard,0);                            
                }
            }
            //if the board is clear, then the program will congratulate them
            //and end the program
            if(isBoardCleared(playingBoard, 0)){
                System.out.printf("%n");
                System.out.printf("%n");
                System.out.println("Good job! You found all the pairs! >:-)");
                displayBoard(playingBoard, 0);
                return 3;
            }
        //if the user decides to end the game then the program will end   
        }else if(mainMenuSelection == 3){
            System.out.printf("%n");
            System.out.println("Game ending ...");
            return 0;
        }
        return 3;
    }

    public static void main (String[] args){
        setupBoard();   //calls the setupBoard method in order for both the board and playingBoard to be set up
        displayMainMenu(attempts);  //calls the mainMenu method in order for the user to choose what option they want to play
        runGame(playingBoard, board);   //runs the game
    }
}

