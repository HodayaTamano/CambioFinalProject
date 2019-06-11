package com.example.cambiofinalproject;
import java.util.ArrayList;

public class Computer {

	public static Card [] computerCards = new Card[4];
	public static ArrayList<CardLocation> computerMemory = new ArrayList<CardLocation>();	// Initialize computer memory ArrayList.

	public Computer() {}

	public static Card[] getComputerCards() {
		return computerCards;
	}

	public static void setComputerCards(Card[] computerCards) {
		Computer.computerCards = computerCards;
	}

	public static ArrayList<CardLocation> getComputerMemory() {
		return computerMemory;
	}

	public static void setComputerMemory(ArrayList<CardLocation> computerMemory) {
		Computer.computerMemory = computerMemory;
	}

	public static void computerTurn () {

		Game.currentTurn = "computer";
		int minCurrent = 52;
		int minGarbage = 52;

		int minIndex = 0;
		//		System.out.println("The current card: " +Game.currentCard);
		for (int i = 0; i < computerCards.length; i++) {
			System.out.println("The current card: " +Game.currentCard);
			// if the garbage is empty - Checking the ConfigurationValue with the current card.
			if ((Game.garbage.isEmpty()) && (ConfigurationValue.after(Game.currentCard, i) <= minCurrent)) {
				System.out.println("ConfigurationValue.after(Game.currentCard, i) <= minCurrent ? "+ ConfigurationValue.after(Game.currentCard, i) +", "+ minCurrent);
				minCurrent = ConfigurationValue.after(Game.currentCard, i);
				minIndex = i;
				System.out.println("the garbage is null! "+Game.garbage.toString());
			}
			// if the garbage is full - Checking the ConfigurationValue with the first in the garbage.
			else if ((!Game.garbage.isEmpty()) && (ConfigurationValue.after(Game.garbage.peek(), i) <= minGarbage)) {
				System.out.println("ConfigurationValue.after(Game.garbage.peek(), i) <= minGarbage ?" + ConfigurationValue.after(Game.garbage.peek(), i)+", "+minGarbage);
				minGarbage = ConfigurationValue.after(Game.garbage.peek(), i);
				minIndex = i;
				System.out.println("the garbage is full! "+Game.garbage.toString());
			}
		}

		// if the ConfigurationValue of the current card is
		// less than the ConfigurationValue of the first card on the garbage.
		if (minCurrent <= minGarbage){ 
			// if ConfigurationValue of the current card is better
			if (minCurrent <= ConfigurationValue.before()) {
				// swap between the card from cardDeck and computerCards[minIndex].
				swap(Game.currentCard, minIndex);
			}	
			else 
				// throw the current card to the stack.
				Game.garbage.add(Game.currentCard); 
		}
		else{
			if (minGarbage <= ConfigurationValue.before()) {
				// swap between the card from garbage and computerCards[minIndex].
				swap(Game.garbage.peek(), minIndex);
			}else{
				// take card from the cardDeck and check again with the current card.
				// Define current card to be the first card of the deck,
				// set it as known card and remove it from the deck. 
				Game.currentCard = Card.cardDeck.get(0); 
				Game.currentCard.setKnown(true);
				Card.cardDeck.remove(0);

				for (int i = 0; i < computerCards.length; i++) {
					if (ConfigurationValue.after(Game.currentCard, i) <= minCurrent) {
						minCurrent = ConfigurationValue.after(Game.currentCard, i);
						minIndex = i;
					}
				}
				if (minCurrent <= ConfigurationValue.before()) {
					// swap between the card from cardDeck and computerCards[minIndex].
					swap(Game.currentCard, minIndex);
				}	
				else 
					// throw the current card to the stack.
					Game.garbage.add(Game.currentCard); 
			}
		}
	}


	public static void swap(Card card, int minIndex) {

		// Throw the card to the garbage and set it as known.
		Game.garbage.add(computerCards[minIndex]);
		Game.garbage.peek().setKnown(true);;

		// Put the current card in the computer cards
		computerCards[minIndex] = card;

		// Add the card of the computer to computerMemory. 
		if (Game.currentTurn.equals("computer")) {
			computerMemory.add(new CardLocation(computerCards[minIndex],minIndex,"computer"));
		}
		// Add the card of the player to computerMemory. 
		else if(Game.currentTurn.equals("player"))
			computerMemory.add(new CardLocation(computerCards[minIndex],minIndex,"player"));

		// Add the currentCard in the garbage to the computerMemory.
		computerMemory.add(new CardLocation(card,minIndex,"garbage"));
	}

}
