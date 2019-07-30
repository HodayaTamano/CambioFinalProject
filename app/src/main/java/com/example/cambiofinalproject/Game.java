package com.example.cambiofinalproject;

import android.widget.Toast;

import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Game{

	public static boolean gameOn = false;
	public static String winner;
	public static Card currentCard;
	public static String currentTurn;
	public static Card [] playerCards = new Card[4];
	public static Stack<Card> garbage = new Stack<Card>(); 

	public Game() {}

	public static String getCurrentTurn() {
		return currentTurn;
	}

	public static void setCurrentTurn(String currentTurn) {
		Game.currentTurn = currentTurn;
	}

	public static boolean isGameOn() {
		return gameOn;
	}

	public static void setGameOn(boolean gameOn) {
		Game.gameOn = gameOn;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public static String start() {

		for(int x=0; x<4; x++){          //0-3 for type (4 types)
			for(int y=2; y<15; y++){     //2-14 for value (13 values)
				Card.cardDeck.add(new Card(x,y)); //create new card and add into the deck
			} //end value for
		}//end type for

		Collections.shuffle(Card.cardDeck, new Random()); //shuffle the deck randomly

		for (int i=0; i<4; i++) {//Dividing 4 cards for the players and remove from the deck.
			playerCards[i] = Card.cardDeck.get(i);
			Computer.computerCards[i] = Card.cardDeck.get(i+4);
			if (i < 2) {// the computer peek two of his cards.
				Computer.computerCards[i].setKnown(true);
			}
		}

		for (int i=0; i<8; i++) { // Removing the cards from the Deck.
			Card.cardDeck.remove(i);
		}

		// Define current card to be the first card of the deck,
		// set it as known card and remove it from the deck. 
		currentCard = Card.cardDeck.get(0); 
		currentCard.setKnown(true);
		Card.cardDeck.remove(0);

		// The computer adds his two cards which are close to him into the ArrayList.
		Computer.computerMemory.add(new CardLocation(Computer.computerCards[0],0,"computer"));
		Computer.computerMemory.add(new CardLocation(Computer.computerCards[1],1,"computer"));

		theGame();
		return winner;
	}

	public static void theGame () {
		gameOn=true;
//		Toast.makeText(MainActivity.this,"the game work",Toast.LENGTH_SHORT).show();
		//while (gameOn) {
		for (int i=0; i<4; i++) { // Printing the cards in the arrays.
			//System.out.println("myCards: "+myCards[i]);
			System.out.println("computerCards: "+Computer.computerCards[i]);
		}
		Computer.computerTurn();
		for (int i=0; i<4; i++) { // Printing the cards in the arrays.
			//System.out.println("myCards: "+myCards[i]);
			System.out.println("computerCards: "+Computer.computerCards[i]);
		}
		Computer.computerTurn();
		for (int i=0; i<4; i++) { // Printing the cards in the arrays.
			//System.out.println("myCards: "+myCards[i]);
			System.out.println("computerCards: "+Computer.computerCards[i]);
		}

		//}

	}



}
