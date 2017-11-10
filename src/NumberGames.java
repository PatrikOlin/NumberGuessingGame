/*
 * 
 *  Namn: Patrik Olin
 *  Datum 2017-10-02
 * 	Kurs: Java SE, Iftac
 *  Laboration 1
 * 
 */

import java.util.Scanner;

public class NumberGames {

	public static final Scanner keyboardInput = new Scanner(System.in);
	
	public static void main(String[] args) {

		boolean runGameSelect = true;
		while (runGameSelect) {
			System.out.println("Hej! Välkommen till nummergissningsspelet!\nVad vill du spela? [1. Binary search/2. Random guess/3. Exit]");
			String gameChoice = keyboardInput.next().toLowerCase();

			if(gameChoice.contains("b") || gameChoice.contains("1")){
				BinarySearchGuessing binaryGame = new BinarySearchGuessing();
				while (binaryGame.isContinuePlaying()) {
					binaryGame.PlayBinarySearchGuessingGame();
				}
			}else if (gameChoice.contains("r") || gameChoice.contains("2")) {
				RandomGuessingGame randomGame = new RandomGuessingGame();
				while (randomGame.isContinuePlaying()) {
					randomGame.PlayRandomGuessingGame();
				}
			} else if(gameChoice.contains("x") || gameChoice.contains("3")) {
				System.out.println("Hej då!");
				runGameSelect = false;
			}
		}
		keyboardInput.close();
	}
}
