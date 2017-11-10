/*
 * 
 *  Namn: Patrik Olin
 *  Datum 2017-10-02
 * 	Kurs: Java SE, Iftac
 *  Laboration 1
 * 
 */

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomGuessingGame {

	private int low;
	private int high;
	private int numOfGuesses;
	private int guess;
	private boolean continuePlaying = true;

	public boolean isContinuePlaying() {
		return continuePlaying;
	}

	public boolean PlayRandomGuessingGame() {

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
			catch (NumberFormatException e) {
				System.out.println("Bara siffror, tack!\n");
			}
		}

		Random randomNumber = new Random();
		numOfGuesses = 1;
		System.out.println("Du har valt intervallet " + low + "-" + high);

		// Skapar ett set för att stoppa in integers i för att garantera att gissningarna är unika, eftersom att ett set inte kan innehålla dubletter.
		Set<Integer> validate = new HashSet<>(); 

		// Sätter winCondition till false och körs så länge wincondition är false
		boolean winCondition = false; 
		while(!winCondition) {

			// Genererer första gissningen som ett slumpat tal mellan spelarens satta intervall
			guess = randomNumber.nextInt((high-low) +1) + low; 

			// Om "validate" redan innehåller integern i "guess", slumpa fram ett nytt tal. Gör detta tills det slumpade talet är ett tal som inte finns i "validate"
			while(validate.contains(guess)) { 
				guess = randomNumber.nextInt((high-low) + 1) + low;
			}
			
			// Lägger till "guess" i vårt set "validate"
			validate.add(guess);
			System.out.println("Är talet du tänker på " + guess + "? [1. Ja/2. Högre/3. Lägre]");
			String playerInput = NumberGames.keyboardInput.next().toLowerCase();

			// Om spelaren säger att deras tal är högre än det gissade talet så sätter vi den nya lägstanivån till samma nivå som "guess"
			if (playerInput.contains("h") || playerInput.contains("2")) { 
				low = guess;
				numOfGuesses++; 

			// Samma tanke som ovan, fast om spelaren väljer lägre. "high" sätts då till samma tal som "guess" och blir det övre taket på intervallen.
			} else if (playerInput.contains("l") || playerInput.contains("3")) {
				high = guess;
				numOfGuesses++; 

			// Om spelaren säger att gissningen är rätt, berätta hur många försök det tog och fråga om spelaren vill spela igen och starta om från början i så fall.	
			} else if (playerInput.contains("j") || playerInput.contains("1")) {
				System.out.println("Det tog mig " + numOfGuesses + " försök att gissa rätt!");
				winCondition = true;
				System.out.println("Vill du spela igen? [Ja/Nej]");
				playerInput = NumberGames.keyboardInput.next().toLowerCase();

				if(playerInput.equals("nej")) {
					continuePlaying = false;
					System.out.println("Ok, tack för idag!\n");
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
