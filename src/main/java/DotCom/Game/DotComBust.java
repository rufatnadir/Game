package DotCom.Game;

import java.util.ArrayList;

public class DotComBust {
	
	GameHelper helper = new GameHelper();
	ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	int numOfGuesses = 0;
	
	private void setupGame() {
		// creates and initialize dotcom objects with names and locations
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("Go2.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);

		// Display brief description to user
		System.out.println("Your goal is to sink 3 dotcoms");
		System.out.println(one.getName()+" "+two.getName()+" "+three.getName());
		System.out.println("Try to achieve that in fewest number of guesses");
		
		for (DotCom dotComToSet : dotComsList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}
	
	private void startPlaying() {
		// asks the player for guesses
		while(!dotComsList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter coordinates: ");
			
			// calls the checkUserGuess() method until all the dotcom objects removed from the play
			checkUserGuess(userGuess);
		}
		 finishGame();
	}

	private void checkUserGuess(String userGuess) {
		
		numOfGuesses++;
		String result = "miss";
		
		for (DotCom dotComToSet : dotComsList) {
			result = dotComToSet.checkYorself(userGuess);
			if (result == "hit") {
				break;
			}
			if (result == "kill") {
				break;
			}
		}
		System.out.println(result);
	}
	
	private void finishGame() {
		System.out.println("All dotcoms destroyed!");
		System.out.println("You did it in "+numOfGuesses+" guesses!");
	}
	
	public static void main(String[] args) {
		DotComBust game = new DotComBust();
		game.setupGame();
		game.startPlaying();
	}

}
