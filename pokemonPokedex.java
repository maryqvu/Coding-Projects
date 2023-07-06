import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;

public class pokemonPokedex{
	static Scanner userInput = new Scanner(System.in);
	static Scanner filterType = new Scanner(System.in);
	static Scanner filterSelection = new Scanner(System.in);
	static Scanner filterSelectionType1 = new Scanner(System.in);
	static Scanner filterSelectionType2 = new Scanner(System.in);
	static Scanner viewPokemonStatsFor = new Scanner(System.in);
	static Scanner addPokemonSelected = new Scanner(System.in);
	static Scanner removePokemonSelected = new Scanner(System.in);

	static String[][] pokemonBox = new String[387][13];

	public void displayPokemon(String[][] pokemonBox, String filter) throws FileNotFoundException{
		File pokemonListFile = new File("pokemonList.txt");
		Scanner readFile = new Scanner (pokemonListFile);

		if(filter.equalsIgnoreCase("type")){
			System.out.println("Please input the first type you want to filter by: ");
			String type1Filter = filterSelectionType1.nextLine();
			System.out.println("Please input the second type you want to filter by [if you don't want a second type, type -1]: ");
			String type2Filter = filterSelectionType2.nextLine();
			if(!type2Filter.equals("-1")){
				System.out.println("Searching for Pokemon that are: " + type1Filter + " + " + type2Filter + " types ... ");
			}else if(type2Filter.equals("-1")){
				System.out.println("Searching for Pokemon that are " + type1Filter + " types ...");
			}
			while(readFile.hasNextLine()){
				for(int r = 0; r < pokemonBox.length; r++){
	 				String[] line = readFile.nextLine().split(",");
	 					for(int c = 0; c < line.length; c++){
	 						pokemonBox[r][c] = line[c];
						}
				}
			}
			for(int r = 1; r < pokemonBox.length; r++){
				for(int c = 0; c < pokemonBox[0].length; c++){
					if((pokemonBox[r][c].equalsIgnoreCase(type1Filter) || pokemonBox[r][c].equalsIgnoreCase(type2Filter)) && (pokemonBox[r][c+1].equalsIgnoreCase(type2Filter) || pokemonBox[r][c+1].equalsIgnoreCase(type1Filter))){
						System.out.printf("%-3s)" + " %-20.20s" + "%S" + "%S" + "%20S"+ "%S" + "%n", pokemonBox[r][0], pokemonBox[r][1], "Type 1: ", pokemonBox[r][2], "Type 2: ", pokemonBox[r][3]);
					}else if(pokemonBox[r][c].equalsIgnoreCase(type1Filter) && type2Filter.equalsIgnoreCase("-1")){
						System.out.printf("%-3s)" + " %-20.20s" + "%S" + "%S" + "%n", pokemonBox[r][0], pokemonBox[r][1], "Type: ", type1Filter);
					}	
				}
			}
        System.out.printf("%n");		
		displayMainMenu();
		System.out.printf("%n");
		}else if(filter.equalsIgnoreCase("level")){
			System.out.println("Please input the lower bound level you want to filter by [minimum: 1  maximum: 100]: ");
			int minLevelFilter = filterSelection.nextInt();
			System.out.println("Please input the upper bound you want to filter by [must be equal or greater than your lower bound, maximum: 100]: ");
			int maxLevelFilter = filterSelection.nextInt();
			System.out.println("Searching for Pokemon that are between levels " + minLevelFilter + " and " + maxLevelFilter + " ...");
			while(readFile.hasNextLine()){
				for(int r = 0; r < pokemonBox.length; r++){
	 				String[] line = readFile.nextLine().split(",");
	 					for(int c = 0; c < line.length; c++){
	 					pokemonBox[r][c] = line[c];
						}
				}
			}
			for(int r = 1; r < pokemonBox.length; r++){
				int level = Integer.valueOf(pokemonBox[r][4]);
				if(level >= minLevelFilter && level <= maxLevelFilter){
					System.out.printf("%-3s)" + " %-20.20s" + "%S" + "%S" + "%n", pokemonBox[r][0], pokemonBox[r][1], "lvl ", pokemonBox[r][4]);
				}
			}
        System.out.printf("%n");
		displayMainMenu();
		System.out.printf("%n");
		}else if(filter.equalsIgnoreCase("generation")){
			System.out.println("Please input the generation by which you want to filter by [only generation 1, 2, and 3 are available]: ");
			int generationFilter = filterSelection.nextInt();
			while(readFile.hasNextLine()){
				for(int r = 0; r < pokemonBox.length; r++){
	 				String[] line = readFile.nextLine().split(",");
	 					for(int c = 0; c < line.length; c++){
	 						pokemonBox[r][c] = line[c];
						}
				}
			}
			for(int r = 1; r < pokemonBox.length; r++){
				int generation = Integer.valueOf(pokemonBox[r][12]);
				if(generation == generationFilter){
					System.out.printf("%-3s)" + " %-20.20s" + "%S" + "%S" + "%n", pokemonBox[r][0], pokemonBox[r][1], "Generation: ", pokemonBox[r][12]);
				}
			}
        System.out.printf("%n");
		displayMainMenu();
		}else if(!filter.equalsIgnoreCase("type") && !filter.equalsIgnoreCase("level") && !filter.equalsIgnoreCase("generation")){
			while(readFile.hasNextLine()){
				for(int r = 0; r < pokemonBox.length; r++){
	 				String[] line = readFile.nextLine().split(",");
	 				for(int c = 0; c < line.length; c++){
	 					pokemonBox[r][c] = line[c];
					}
				}	
			}
			for(int i = 1; i < pokemonBox.length; i++){
				System.out.printf("%-3s)" + " %-20.20s" + "%s" + "%S" + "%n", pokemonBox[i][0], pokemonBox[i][1], "lvl. ", pokemonBox[i][4]);
			}
        System.out.printf("%n");
		displayMainMenu();
		System.out.printf("%n");
		}
	}

	public void displayStats() throws FileNotFoundException{
		File pokemonListFile = new File("pokemonList.txt");
		Scanner readFile = new Scanner (pokemonListFile);

		System.out.println("What Pokemon would you like to view the stats for?");
		System.out.println("They can be from either your party or your box: ");
		String viewPokemonStats = viewPokemonStatsFor.nextLine();
		while(readFile.hasNextLine()){
			for(int r = 0; r < pokemonBox.length; r++){
	 			String[] line = readFile.nextLine().split(",");
	 			for(int c = 0; c < line.length; c++){
	 				pokemonBox[r][c] = line[c];
				}
			}	
		}
		for(int r = 1; r < pokemonBox.length; r++){
			if(pokemonBox[r][1].equalsIgnoreCase(viewPokemonStats)){
				System.out.printf("%n");
				System.out.printf("%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + 
				"%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%n", "Dex Number", "|", "Name", "|", "Type1", "|", "Type 2", "|",
				"Level", "|", "Total", "|", "HP", "|", "Attack", "|", "Defense", "|", "Sp. Attack", "|", "Sp. Defens", "|", "Speed", "|", "Generation");
				System.out.printf("%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + 
				"%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%1s" + "%-12.12s" + "%n", pokemonBox[r][0], "|", pokemonBox[r][1], "|", pokemonBox[r][2], "|", pokemonBox[r][3], "|",
				pokemonBox[r][4], "|", pokemonBox[r][5], "|", pokemonBox[r][6], "|", pokemonBox[r][7], "|", pokemonBox[r][8], "|", pokemonBox[r][9], "|", pokemonBox[r][10], "|", pokemonBox[r][11], "|", pokemonBox[r][12]);
			}
		}
		System.out.printf("%n");
		displayMainMenu();
		System.out.printf("%n");	
	}

	public void addPokemonToParty(LinkedList pokemonLinkedList) throws FileNotFoundException {
		File pokemonListFile = new File("pokemonList.txt");
		Scanner readFile = new Scanner (pokemonListFile);

		System.out.println("What Pokemon would you like to add to your party?");
		String pokemonSelected = addPokemonSelected.nextLine();

		while(readFile.hasNextLine()){
			for(int r = 0; r < pokemonBox.length; r++){
	 			String[] line = readFile.nextLine().split(",");
	 			for(int c = 0; c < line.length; c++){
	 				pokemonBox[r][c] = line[c];
				}
			}	
		}
		for(int r = 1; r < pokemonBox.length; r++){
			if(pokemonBox[r][1].equalsIgnoreCase(pokemonSelected)){
				pokemonSelected = pokemonBox[r][1] + "  " + "lvl. " + pokemonBox[r][4];
        		LinkedListNode addPokemon = new LinkedListNode(new String[]{pokemonSelected});
        		pokemonLinkedList.addToParty(addPokemon);
        		System.out.printf(pokemonSelected + "%n" + "was added to your party!");
        	}
        }
        System.out.printf("%n");
        displayMainMenu();
        System.out.printf("%n");
	}

	public void removeFromParty(LinkedList pokemonLinkedList) throws FileNotFoundException{
		File pokemonListFile = new File("pokemonList.txt");
		Scanner readFile = new Scanner (pokemonListFile);

		System.out.println("What Pokemon would you like to remove from your party?");
		String pokemonSelected = removePokemonSelected.nextLine();

		while(readFile.hasNextLine()){
			for(int r = 0; r < pokemonBox.length; r++){
	 			String[] line = readFile.nextLine().split(",");
	 			for(int c = 0; c < line.length; c++){
	 				pokemonBox[r][c] = line[c];
				}
			}	
		}
		for(int r = 1; r < pokemonBox.length; r++){
			if(pokemonBox[r][1].equalsIgnoreCase(pokemonSelected)){
				pokemonSelected = pokemonBox[r][1] + "  " + "lvl. " + pokemonBox[r][4];
        		pokemonLinkedList.removeFromParty(pokemonSelected);
        		System.out.printf(pokemonSelected + "%n" + "was removed from your party!");
        	}
        }
        System.out.printf("%n");
        displayMainMenu();
        System.out.printf("%n");
	}

	public void viewParty(LinkedList pokemonLinkedList) throws FileNotFoundException{
		System.out.println("Your current party: ");
		pokemonLinkedList.displayParty(pokemonLinkedList.getHead());
		displayMainMenu();
		System.out.printf("%n");
	}

	public void displayMainMenu() throws FileNotFoundException {
		File pokemonListFile = new File("pokemonList.txt");
		Scanner readFile = new Scanner (pokemonListFile);
		LinkedList pokemonLinkedList = new LinkedList();

		System.out.println("****************************************");
		System.out.println("Welcome To The Pokemon Center!");
		System.out.println("Please select one of the following options: ");
		System.out.println("1) View box");
		System.out.println("2) View party");
		System.out.println("3) Deposit Pokemon [Remove from party]");
		System.out.println("4) Withdraw Pokemon [Add to party]");
		System.out.println("5) View Pokemon stats");
		System.out.println("6) Log out");
		System.out.println("****************************************");
		int menuChoice = userInput.nextInt();

		if(menuChoice == 1){
			System.out.println("Choose a filter criteria [only one], or type anything else to see everyone in the box.");
			System.out.println("Filter options: ");
			System.out.println("1) Type");
			System.out.println("2) Level");
			System.out.println("3) Generation");
			String filter = filterType.nextLine();
			displayPokemon(pokemonBox, filter);
		}else if(menuChoice == 2){
			viewParty(pokemonLinkedList);
		}else if(menuChoice == 3){
			removeFromParty(pokemonLinkedList);
		}else if(menuChoice == 4){
			addPokemonToParty(pokemonLinkedList);
		}else if(menuChoice == 5){
			displayStats();
		}else if(menuChoice == 6){
			System.out.println("You exited the Pokemon Center!");
			System.out.println("See you later! :-)");
			return;
		}

	}

	public static void main (String[] args) throws FileNotFoundException {
		try{ // If the .wav file is found it will play the song while running the program
            File musicPath = new File("pokemonCenter.wav");
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            System.out.printf("%n");
            System.out.println("Now Playing: \"Pokémon Center\" from Pokémon Colosseum");
        }
        catch(Exception e){
        }
        CL3_Vu instance = new CL3_Vu();
		instance.displayMainMenu();

	}
}

