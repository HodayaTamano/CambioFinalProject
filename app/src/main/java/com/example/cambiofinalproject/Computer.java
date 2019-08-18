package com.example.cambiofinalproject;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


import static com.example.cambiofinalproject.MainActivity.*;

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
		System.out.println("computerTurn");
		Game.currentTurn = "computer";

		int minGarbage = 52;
		int minIndex = -1;
		if (Game.garbage.peek().getValue() < 5){
			System.out.println("the value is < 5");
			for (int i = 0; i < computerCards.length; i++){
				if ((!Game.garbage.isEmpty()) && (ConfigurationValue.after(Game.garbage.peek(), i) <= minGarbage)){
					minGarbage = ConfigurationValue.after(Game.garbage.peek(), i);
					minIndex = i;
				}
			}
			// display swaping between garbage card and computer card
			int imageId = getContext().getResources().getIdentifier(Computer.computerCards[minIndex].toString(), "drawable", getContext().getPackageName());
			Drawable myDrawable = getContext().getResources().getDrawable(imageId);
			MainActivity.getGarbage().setImageDrawable(myDrawable);

			// the real swaping
			Card temp = Computer.computerCards[minIndex];
			Computer.computerCards[minIndex] = Game.garbage.pop();
			Game.garbage.push(temp);

			computerMemory.add(new CardLocation(temp, -1 , "garbage"));
			computerMemory.add(new CardLocation(Computer.computerCards[minIndex], minIndex, "computer"));
		}
		else {
			System.out.println("the value is >= 5");
			Game.currentCard = Card.cardDeck.get(0);
			Game.currentCard.setKnown(true);
			Card.cardDeck.remove(0);
			if (Game.currentCard.getValue() == 7 || Game.currentCard.getValue() == 8){
				System.out.println("the value is: "+Game.currentCard.getValue());
				for (int i = 0; i < computerCards.length; i++){
					if (computerCards[i].getKnown() == false){

						Computer.computerMemory.add(new CardLocation(computerCards[i] , i,"computer"));
						computerCards[i].setKnown(true);
						Game.garbage.push(Game.currentCard);

						int pe_imageId = getContext().getResources().getIdentifier("peekcard", "drawable", getContext().getPackageName());
						Drawable pe_myDrawable = getContext().getResources().getDrawable(pe_imageId);
						if (i == 0)
							computerCard1.setImageDrawable(pe_myDrawable);
						else if (i == 1)
							computerCard2.setImageDrawable(pe_myDrawable);
						else if (i == 2)
							computerCard3.setImageDrawable(pe_myDrawable);
						else if (i == 3)
							computerCard4.setImageDrawable(pe_myDrawable);

						int imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
						Drawable myDrawable = getContext().getResources().getDrawable(imageId);
						getGarbage().setImageDrawable(myDrawable);

						break;
					}
				}
			}
			else if (Game.currentCard.getValue() == 9 || Game.currentCard.getValue() == 10){
				System.out.println("the value is: "+Game.currentCard.getValue());
				for (int i = 0; i < Player.playerCards.length; i++){
					if (Player.playerCards[i].getKnown() == false){
						Computer.computerMemory.add(new CardLocation(Player.playerCards[i] , i,"player"));
						Player.playerCards[i].setKnown(true);
						Game.garbage.push(Game.currentCard);

						int pe_imageId = getContext().getResources().getIdentifier("peekcard", "drawable", getContext().getPackageName());
						Drawable pe_myDrawable = getContext().getResources().getDrawable(pe_imageId);

						if (i == 0)
							playerCard1.setImageDrawable(pe_myDrawable);
						else if (i == 1)
							playerCard2.setImageDrawable(pe_myDrawable);
						else if (i == 2)
							playerCard3.setImageDrawable(pe_myDrawable);
						else if (i == 3)
							playerCard4.setImageDrawable(pe_myDrawable);

//						new Timer().schedule(new TimerTask() {
//							@Override
//							public void run() {
//								// this code will be executed after 2 seconds
//								int pe_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
//								Drawable pe_myDrawable = getContext().getResources().getDrawable(pe_imageId);
//							}
//						}, 2000);



//						if (i == 0){
//							int i_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
//							Drawable i_myDrawable = getContext().getResources().getDrawable(pe_imageId);
//							playerCard1.setImageDrawable(i_myDrawable);
//						}
//						else if (i == 1){
//							int i_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
//							Drawable i_myDrawable = getContext().getResources().getDrawable(pe_imageId);
//							playerCard2.setImageDrawable(i_myDrawable);
//						}
//
//						else if (i == 2){
//							int i_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
//							Drawable i_myDrawable = getContext().getResources().getDrawable(pe_imageId);
//							playerCard3.setImageDrawable(i_myDrawable);
//						}
//						else if (i == 3) {
//							int i_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
//							Drawable i_myDrawable = getContext().getResources().getDrawable(pe_imageId);
//							playerCard4.setImageDrawable(i_myDrawable);
//						}


						int imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
						Drawable myDrawable = getContext().getResources().getDrawable(imageId);
						getGarbage().setImageDrawable(myDrawable);

						break;
					}
				}
			}
		}

		System.out.println("Current: " + Game.currentCard);
		System.out.println("Garbage: " + Game.garbage.peek());

//	//	Game.currentTurn = "computer";
//		int minCurrent = 52;
//		int minGarbage = 52;
//
//		int minIndex = 0;
//		//		System.out.println("The current card: " +Game.currentCard);
//		for (int i = 0; i < computerCards.length; i++) {
//			System.out.println("The current card: " +Game.currentCard);
//			// if the garbage is empty - Checking the ConfigurationValue with the current card.
//			if ((Game.garbage.isEmpty()) && (ConfigurationValue.after(Game.currentCard, i) <= minCurrent)) {
//				minCurrent = ConfigurationValue.after(Game.currentCard, i);
//				minIndex = i;
//				System.out.println("the garbage is null! "+Game.garbage.toString());
//			}
//			// if the garbage is full - Checking the ConfigurationValue with the first in the garbage.
//			else if ((!Game.garbage.isEmpty()) && (ConfigurationValue.after(Game.garbage.peek(), i) <= minGarbage)) {
//				minGarbage = ConfigurationValue.after(Game.garbage.peek(), i);
//				minIndex = i;
//				System.out.println("the garbage is full! "+Game.garbage.toString());
//			}
//		}
//
//		// if the ConfigurationValue of the current card is
//		// less than the ConfigurationValue of the first card on the garbage.
//		if (minCurrent <= minGarbage){
//			// if ConfigurationValue of the current card is better
//			if (minCurrent <= ConfigurationValue.before()) {
//				// swap between the card from cardDeck and computerCards[minIndex].
////				swap(Game.currentCard, minIndex);
//			}
//			else {
//				// throw the current card to the stack.
//				//*************************************************************//
////				Game.garbage.add(Game.currentCard);
//				//*************************************************************//
////				System.out.println("GARBAGE "+Game.garbage.peek());
//			}
//		}
//		else{
//			if (minGarbage <= ConfigurationValue.before()) {
//				// swap between the card from garbage and computerCards[minIndex].
////				swap(Game.garbage.peek(), minIndex);
//			}else{
//				// take card from the cardDeck and check again with the current card.
//				// Define current card to be the first card of the deck,
//				// set it as known card and remove it from the deck.
//				Game.currentCard = Card.cardDeck.get(0);
//				Game.currentCard.setKnown(true);
//				Card.cardDeck.remove(0);
//
//				for (int i = 0; i < computerCards.length; i++) {
//					if (ConfigurationValue.after(Game.currentCard, i) <= minCurrent) {
//						minCurrent = ConfigurationValue.after(Game.currentCard, i);
//						minIndex = i;
//					}
//				}
//				if (minCurrent <= ConfigurationValue.before()) {
//					// swap between the card from cardDeck and computerCards[minIndex].
////					swap(Game.currentCard, minIndex);
//				}
//				else {
//					// throw the current card to the stack.
//					//*************************************************************//
////				Game.garbage.add(Game.currentCard);
//					//*************************************************************//
////					System.out.println("GARBAGE: " + Game.garbage.peek());
//				}
//				}
		}

//
//
//	public static void swap(Card card, int minIndex) {
//
//		// Throw the card to the garbage and set it as known.
//		Game.garbage.add(computerCards[minIndex]);
////		System.out.println("GARBAGE: "+Game.garbage.peek());
//		Game.garbage.peek().setKnown(true);;
//
//		// Put the current card in the computer cards
//		computerCards[minIndex] = card;
//
//		// Add the card of the computer to computerMemory.
//		if (Game.currentTurn.equals("computer")) {
//			computerMemory.add(new CardLocation(computerCards[minIndex],minIndex,"computer"));
//		}
//		// Add the card of the player to computerMemory.
//		else if(Game.currentTurn.equals("player"))
//			computerMemory.add(new CardLocation(computerCards[minIndex],minIndex,"player"));
//
//		// Add the currentCard in the garbage to the computerMemory.
//		computerMemory.add(new CardLocation(card,minIndex,"garbage"));
//	}

}
