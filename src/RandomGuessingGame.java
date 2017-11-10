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
			catch (NumberFormatException e) {
				System.out.println("Bara siffror, tack!\n");
			}
		}

		Random randomNumber = new Random();
		numOfGuesses = 1;
		System.out.println("Du har valt intervallet " + low + "-" + high);

		// Skapar ett set f�r att stoppa in integers i f�r att garantera att gissningarna �r unika, eftersom att ett set inte kan inneh�lla dubletter.
		Set<Integer> validate = new HashSet<>(); 

		// S�tter winCondition till false och k�rs s� l�nge wincondition �r false
		boolean winCondition = false; 
		while(!winCondition) {

			// Genererer f�rsta gissningen som ett slumpat tal mellan spelarens satta intervall
			guess = randomNumber.nextInt((high-low) +1) + low; 

			// Om "validate" redan inneh�ller integern i "guess", slumpa fram ett nytt tal. G�r detta tills det slumpade talet �r ett tal som inte finns i "validate"
			while(validate.contains(guess)) { 
				guess = randomNumber.nextInt((high-low) + 1) + low;
			}
			
			// L�gger till "guess" i v�rt set "validate"
			validate.add(guess);
			System.out.println("�r talet du t�nker p� " + guess + "? [1. Ja/2. H�gre/3. L�gre]");
			String playerInput = NumberGames.keyboardInput.next().toLowerCase();

			// Om spelaren s�ger att deras tal �r h�gre �n det gissade talet s� s�tter vi den nya l�gstaniv�n till samma niv� som "guess"
			if (playerInput.contains("h") || playerInput.contains("2")) { 
				low = guess;
				numOfGuesses++; 

			// Samma tanke som ovan, fast om spelaren v�ljer l�gre. "high" s�tts d� till samma tal som "guess" och blir det �vre taket p� intervallen.
			} else if (playerInput.contains("l") || playerInput.contains("3")) {
				high = guess;
				numOfGuesses++; 

			// Om spelaren s�ger att gissningen �r r�tt, ber�tta hur m�nga f�rs�k det tog och fr�ga om spelaren vill spela igen och starta om fr�n b�rjan i s� fall.	
			} else if (playerInput.contains("j") || playerInput.contains("1")) {
				System.out.println("Det tog mig " + numOfGuesses + " f�rs�k att gissa r�tt!");
				winCondition = true;
				System.out.println("Vill du spela igen? [Ja/Nej]");
				playerInput = NumberGames.keyboardInput.next().toLowerCase();

				if(playerInput.equals("nej")) {
					continuePlaying = false;
					System.out.println("Ok, tack f�r idag!\n");
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
