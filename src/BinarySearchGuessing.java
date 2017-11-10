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

		System.out.println("T�nk p� ett heltal i ett intervall.");

		// Kollar s� att inputen �r giltig och bara inneh�ller siffror.
		boolean inputValidator = false;
		while(!inputValidator) {
			try {
				System.out.println("Ange var intervallet b�rjar: ");
				low = Integer.parseInt(NumberGames.keyboardInput.next());

				System.out.println("Ange var intervallet slutar: ");
				high= Integer.parseInt(NumberGames.keyboardInput.next());

				inputValidator = true;
			}
			catch (NumberFormatException ex) {
				System.out.println("Bara siffror, tack!\n");
			}
		}

		//Printar ut valt intervall och r�knar ut hur m�nga gissningar det borde ta att l�sa
		System.out.println("Du har valt intervallet " + low + "-" + high);
		this.numOfGuesses = 1;
		this.maxGuesses = (int) (Math.log(high) / Math.log(2));

		boolean winCondition = false;  
		while(!winCondition) { 

			int guess = (high + low) / 2; 
			System.out.println("�r talet du t�nker p� " + guess + "? [1. Ja/2. H�gre/3. L�gre]");
			String playerInput = NumberGames.keyboardInput.next().toLowerCase();

			if (playerInput.contains("h") || playerInput.contains("2")) { 
				numOfGuesses++; 
				low = guess;

			} else if (playerInput.contains("l") || playerInput.contains("3")) {
				numOfGuesses++; 
				high = guess;

			} else if (playerInput.contains("j") || playerInput.contains("1")) {
				System.out.println("Det tog mig " + numOfGuesses + " f�rs�k att gissa r�tt!");
				System.out.println("Det borde tagit mig " + maxGuesses + " gissningar.");
				winCondition = true;
				System.out.println("Vill du spela igen? [Ja/Nej]");
				playerInput = NumberGames.keyboardInput.next().toLowerCase();

				if(playerInput.equals("nej")) {
					System.out.println("Ok, tack f�r idag!\n");
					return continuePlaying = false;
				}

			} else {
				System.out.println("Felaktig input, ange 'Ja', 'H�gre' eller 'L�gre'");
				System.out.println("�r talet du t�nker p� " + guess + "? [1. Ja/2. H�gre/3. L�gre]");
				playerInput = NumberGames.keyboardInput.next().toLowerCase();
				if(playerInput.contains("h") || playerInput.contains("l") || playerInput.contains("2") || playerInput.contains("3")) {
					numOfGuesses++;
				}
			} 
		}
		return continuePlaying;
	}
}
