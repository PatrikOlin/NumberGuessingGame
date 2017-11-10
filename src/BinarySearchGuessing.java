/*
 * 
 *  Namn: Patrik Olin
 *  Datum 2017-10-02
 * 	Kurs: Java SE, Iftac
 *  Laboration 1
 * 
 */

public class BinarySearchGuessing {

	private int low;
	private int high;
	private int numOfGuesses;
	private int maxGuesses;
	private boolean continuePlaying = true;

	public boolean isContinuePlaying() {
		return continuePlaying;
	}

	public boolean PlayBinarySearchGuessingGame() {

		System.out.println("Tänk på ett heltal i ett intervall.");

		// Kollar så att inputen är giltig och bara innehåller siffror.
		boolean inputValidator = false;
		while(!inputValidator) {
			try {
				System.out.println("Ange var intervallet börjar: ");
				low = Integer.parseInt(NumberGames.keyboardInput.next());

				System.out.println("Ange var intervallet slutar: ");
				high= Integer.parseInt(NumberGames.keyboardInput.next());

				inputValidator = true;
			}
			catch (NumberFormatException ex) {
				System.out.println("Bara siffror, tack!\n");
			}
		}

		//Printar ut valt intervall och räknar ut hur många gissningar det borde ta att lösa
		System.out.println("Du har valt intervallet " + low + "-" + high);
		this.numOfGuesses = 1;
		this.maxGuesses = (int) (Math.log(high) / Math.log(2));

		boolean winCondition = false;  
		while(!winCondition) { 

			int guess = (high + low) / 2; 
			System.out.println("Är talet du tänker på " + guess + "? [1. Ja/2. Högre/3. Lägre]");
			String playerInput = NumberGames.keyboardInput.next().toLowerCase();

			if (playerInput.contains("h") || playerInput.contains("2")) { 
				numOfGuesses++; 
				low = guess;

			} else if (playerInput.contains("l") || playerInput.contains("3")) {
				numOfGuesses++; 
				high = guess;

			} else if (playerInput.contains("j") || playerInput.contains("1")) {
				System.out.println("Det tog mig " + numOfGuesses + " försök att gissa rätt!");
				System.out.println("Det borde tagit mig " + maxGuesses + " gissningar.");
				winCondition = true;
				System.out.println("Vill du spela igen? [Ja/Nej]");
				playerInput = NumberGames.keyboardInput.next().toLowerCase();

				if(playerInput.equals("nej")) {
					System.out.println("Ok, tack för idag!\n");
					return continuePlaying = false;
				}

			} else {
				System.out.println("Felaktig input, ange 'Ja', 'Högre' eller 'Lägre'");
				System.out.println("Är talet du tänker på " + guess + "? [1. Ja/2. Högre/3. Lägre]");
				playerInput = NumberGames.keyboardInput.next().toLowerCase();
				if(playerInput.contains("h") || playerInput.contains("l") || playerInput.contains("2") || playerInput.contains("3")) {
					numOfGuesses++;
				}
			} 
		}
		return continuePlaying;
	}
}
