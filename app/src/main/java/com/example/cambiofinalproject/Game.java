package com.example.cambiofinalproject;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;



import java.util.Collections;
import java.util.Random;
import java.util.Stack;


public class Game extends MainActivity{
//    public void onCreate(Bundle savedInstanceState) {
//        Game regularClass = new RegularClass(this);
//    }

	public static boolean gameOn = false;
	public static String winner;
	public static Card currentCard;
	public static String currentTurn;
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
			for(int y=1; y<14; y++){     //2-14 for value (13 values)
				Card.cardDeck.add(new Card(x,y)); //create new card and add into the deck
			} //end value for
		}//end type for

		Collections.shuffle(Card.cardDeck, new Random()); //shuffle the deck randomly

        Card.cardDeck.set(8, (new Card (0,11)));
		Card.cardDeck.set(10, (new Card (0,7)));

		for (int i=0; i<4; i++) {//Dividing 4 cards for the players and remove from the deck.

			Player.playerCards[i] = Card.cardDeck.get(i);
			System.out.println("PLAYER: " + Player.playerCards[i]);
			Computer.computerCards[i] = Card.cardDeck.get(i+4);
			System.out.println("COMPUTER: " + Computer.computerCards[i]);
		}

		// the computer peek two of his cards at the begining of the game.
		Computer.computerCards[0].setKnown(true);
		Computer.computerCards[1].setKnown(true);

//		System.out.println("Card.cardDeck.get(0) before " +Card.cardDeck.get(0));

		for (int i=0; i<8; i++) { // Removing the cards from the Deck.
			Card.cardDeck.remove(0);
		}
		for (int i=0; i<Card.cardDeck.size(); i++) {
			System.out.println("DECK: " + Card.cardDeck.get(i));
		}
		// Define current card to be the first card of the deck,
		// set it as known card and remove it from the deck.

		currentCard = Card.cardDeck.get(0);
		System.out.println("CURRENT: " + currentCard);
		//currentCard.setKnown(true);
//		Card.cardDeck.remove(0);


		System.out.println(" ");
		System.out.println("SECOND CARD: " +Card.cardDeck.get(0));
		System.out.println(" ");

//		MainActivity.garbage.setImageResource(android.R.color.transparent); //  Nothing in the current card is transparent




		// The computer adds his two cards which are close to him into the ArrayList.
		Computer.computerMemory.add(new CardLocation(Computer.computerCards[0],0,"computer"));
		Computer.computerMemory.add(new CardLocation(Computer.computerCards[1],1,"computer"));


		return winner;
	}

	public static void theGame() {
		gameOn=true;
		System.out.println("theGame");

		if(currentTurn == "computer"){
			Computer.computerTurn();

		} else
		 	MainActivity.playerTurn();


    }



}
