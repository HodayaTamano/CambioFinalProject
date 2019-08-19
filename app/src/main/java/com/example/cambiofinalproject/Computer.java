package com.example.cambiofinalproject;
import android.graphics.drawable.Drawable;
import android.os.Handler;

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

		final Handler handler = new Handler();
		final int delay = 1500; //milliseconds

		int minGarbage = 52;
		int minPlayerSwap = 52;
		int indexComputer = -1; // the index of the card that I want to replace.
		int indexPlayer = -1;

		int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
		Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);

		if (Game.garbage.peek().getValue() < 5){
			System.out.println("the value is < 5");
			for (int i = 0; i < computerCards.length; i++){
				if ((!Game.garbage.isEmpty()) && (ConfigurationValue.after(Game.garbage.peek(), i) <= minGarbage)){
					minGarbage = ConfigurationValue.after(Game.garbage.peek(), i);
					indexComputer = i;
				}
			}
			// display swaping between garbage card and computer card
			int imageId = getContext().getResources().getIdentifier(Computer.computerCards[indexComputer].toString(), "drawable", getContext().getPackageName());
			Drawable myDrawable = getContext().getResources().getDrawable(imageId);
			MainActivity.getGarbage().setImageDrawable(myDrawable);

			// the real swaping
			Card temp = Computer.computerCards[indexComputer];
			Computer.computerCards[indexComputer] = Game.garbage.pop();
			Game.garbage.push(temp);

			computerMemory.add(new CardLocation(temp, -1 , "garbage"));
			computerMemory.add(new CardLocation(Computer.computerCards[indexComputer], indexComputer, "computer"));
		}
		else {
			System.out.println("the value is >= 5");
			Game.currentCard = Card.cardDeck.get(0);
			Game.currentCard.setKnown(true);
			Card.cardDeck.remove(0);

			current.setImageDrawable(myDrawableBack);

			if (Game.currentCard.getValue() == 7 || Game.currentCard.getValue() == 8){
				System.out.println("the value is: "+Game.currentCard.getValue());
				for (int i = 0; i < computerCards.length; i++){
					if (computerCards[i].getKnown() == false){

						Computer.computerMemory.add(new CardLocation(computerCards[i] , i,"computer"));
						computerCards[i].setKnown(true);
						Game.garbage.push(Game.currentCard);

						// Showing to the player which card was peeked
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

						// After 1.5 sec flip the card.
						if (i == 0){
							handler.postDelayed(new Runnable(){
								public void run(){
									int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
									Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
									computerCard1.setImageDrawable(myDrawableBack);
									handler.postDelayed(this, delay);
								}
							}, delay);
						}
						else if (i == 1){
							handler.postDelayed(new Runnable(){
								public void run(){
									int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
									Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
									computerCard2.setImageDrawable(myDrawableBack);
									handler.postDelayed(this, delay);
								}
							}, delay);
						}

						else if (i == 2){
							handler.postDelayed(new Runnable(){
								public void run(){
									int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
									Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
									computerCard3.setImageDrawable(myDrawableBack);
									handler.postDelayed(this, delay);
								}
							}, delay);
						}
						else if (i == 3) {
							handler.postDelayed(new Runnable(){
								public void run(){
									int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
									Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
									computerCard4.setImageDrawable(myDrawableBack);
									handler.postDelayed(this, delay);
								}
							}, delay);

						}

						// Throw the card (7 or 8) to the garbage.
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

						if (i == 0){
							handler.postDelayed(new Runnable(){
								public void run(){
									int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
									Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
									playerCard1.setImageDrawable(myDrawableBack);
									handler.postDelayed(this, delay);
								}
							}, delay);
						}
						else if (i == 1){
							handler.postDelayed(new Runnable(){
								public void run(){
									int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
									Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
									playerCard2.setImageDrawable(myDrawableBack);
									handler.postDelayed(this, delay);
								}
							}, delay);
						}

						else if (i == 2){
							handler.postDelayed(new Runnable(){
								public void run(){
									int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
									Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
									playerCard3.setImageDrawable(myDrawableBack);
									handler.postDelayed(this, delay);
								}
							}, delay);
						}
						else if (i == 3) {
							handler.postDelayed(new Runnable(){
								public void run(){
									int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
									Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
									playerCard4.setImageDrawable(myDrawableBack);
									handler.postDelayed(this, delay);
								}
							}, delay);

						}

						int imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
						Drawable myDrawable = getContext().getResources().getDrawable(imageId);
						getGarbage().setImageDrawable(myDrawable);

						break;
					}
				}
			}
			else if(Game.currentCard.getValue() == 11 || Game.currentCard.getValue() == 12) {
				System.out.println("queen or jack");
				for (int i = 0; i < Player.playerCards.length; i++) {
					if (Player.playerCards[i].getKnown() == true) {
						for (int j = 0; j < computerCards.length; j++) {
							minPlayerSwap = ConfigurationValue.after(Player.playerCards[i], j);
							indexPlayer = i;
							indexComputer = j;
						}
					}
					else {
						System.out.println("don't recognized");
						continue;
					}
				}

				// display swapping between player card and computer card
				int c_imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
				Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);

				if (indexPlayer == 0)
					playerCard1.setImageDrawable(i_myDrawable);
				else if (indexPlayer == 1)
					playerCard2.setImageDrawable(i_myDrawable);
				else if (indexPlayer == 2)
					playerCard3.setImageDrawable(i_myDrawable);
				else if (indexPlayer == 3)
					playerCard4.setImageDrawable(i_myDrawable);

				if (indexComputer == 0)
					computerCard1.setImageDrawable(i_myDrawable);
				else if (indexComputer == 1)
					computerCard2.setImageDrawable(i_myDrawable);
				else if (indexComputer == 2)
					computerCard3.setImageDrawable(i_myDrawable);
				else if (indexComputer == 3)
					computerCard4.setImageDrawable(i_myDrawable);

				if (indexPlayer == 0) {
					handler.postDelayed(new Runnable() {
						public void run() {
							int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
							Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
							playerCard1.setImageDrawable(i_myDrawable);
							handler.postDelayed(this, delay);
						}
					}, delay);
				} else if (indexPlayer == 1) {
					handler.postDelayed(new Runnable() {
						public void run() {
							int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
							Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
							playerCard2.setImageDrawable(i_myDrawable);
							handler.postDelayed(this, delay);
						}
					}, delay);
				} else if (indexPlayer == 2) {
					handler.postDelayed(new Runnable() {
						public void run() {
							int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
							Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
							playerCard3.setImageDrawable(i_myDrawable);
							handler.postDelayed(this, delay);
						}
					}, delay);
				} else if (indexPlayer == 3) {
					handler.postDelayed(new Runnable() {
						public void run() {
							int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
							Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
							playerCard4.setImageDrawable(i_myDrawable);
							handler.postDelayed(this, delay);
						}
					}, delay);
				}


				if (indexComputer == 0) {
					handler.postDelayed(new Runnable() {
						public void run() {
							int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
							Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
							computerCard1.setImageDrawable(i_myDrawable);
							handler.postDelayed(this, delay);
						}
					}, delay);
				} else if (indexComputer == 1) {
					handler.postDelayed(new Runnable() {
						public void run() {
							int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
							Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
							computerCard2.setImageDrawable(i_myDrawable);
							handler.postDelayed(this, delay);
						}
					}, delay);
				} else if (indexComputer == 2) {
					handler.postDelayed(new Runnable() {
						public void run() {
							int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
							Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
							computerCard3.setImageDrawable(i_myDrawable);
							handler.postDelayed(this, delay);
						}
					}, delay);
				} else if (indexComputer == 3) {
					handler.postDelayed(new Runnable() {
						public void run() {
							int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
							Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
							computerCard4.setImageDrawable(i_myDrawable);
							handler.postDelayed(this, delay);
						}
					}, delay);
				}



				computerMemory.remove(new CardLocation(Player.playerCards[indexPlayer], indexPlayer, "player"));
				computerMemory.add(new CardLocation(Player.playerCards[indexPlayer], indexComputer, "computer"));

				computerMemory.remove(new CardLocation(Computer.computerCards[indexComputer], indexComputer, "computer"));
				computerMemory.add(new CardLocation(Computer.computerCards[indexComputer], indexPlayer, "player"));

				// the real swaping
				Card temp = Computer.computerCards[indexComputer];
				Computer.computerCards[indexComputer] = Player.playerCards[indexPlayer];
				Player.playerCards[indexPlayer] = temp;

				System.out.println("minPlayerSwap: "+minPlayerSwap);
				System.out.println("indexPlayer: "+indexPlayer);
				System.out.println("indexComputer: "+indexComputer);

				Game.garbage.push(Game.currentCard);

				int imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
				Drawable myDrawable = getContext().getResources().getDrawable(imageId);
				getGarbage().setImageDrawable(myDrawable);

			} else if (Game.currentCard.getValue() == 13 && Game.currentCard.getColor().equals("black")){
				Game.garbage.push(Game.currentCard);
				System.out.println("black king");
			} else{
				for (int i=0; i<computerCards.length; i++){
					if((computerCards[i].getKnown() == true ) && (computerCards[i].getValue() - Game.currentCard.getValue()) > 5){
						System.out.println("if((computerCards[i].getKnown() == true ) && (computerCards[i].getValue() - Game.currentCard.getValue()) > 5){");

						int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
						Drawable myDrawable = getContext().getResources().getDrawable(imageId);
						current.setImageDrawable(myDrawable);

						if(i == 0) {
						computerCard1.setImageDrawable(myDrawable);
						}
						else if(i == 1) {
							computerCard2.setImageDrawable(myDrawable);
						}
						else if(i == 2) {
							computerCard3.setImageDrawable(myDrawable);
						}
						else if(i == 3) {
							computerCard4.setImageDrawable(myDrawable);
						}

						if (i == 0) {
							handler.postDelayed(new Runnable() {
								public void run() {
									int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
									Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
									computerCard1.setImageDrawable(i_myDrawable);
									current.setImageDrawable(i_myDrawable);
									handler.postDelayed(this, delay);
								}
							}, delay);
						}
						else if (i == 1) {
							handler.postDelayed(new Runnable() {
								public void run() {
									int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
									Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
									computerCard2.setImageDrawable(i_myDrawable);
									current.setImageDrawable(i_myDrawable);
									handler.postDelayed(this, delay);
								}
							}, delay);
						}
						else if (i == 2) {
							handler.postDelayed(new Runnable() {
								public void run() {
									int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
									Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
									computerCard3.setImageDrawable(i_myDrawable);
									current.setImageDrawable(i_myDrawable);
									handler.postDelayed(this, delay);
								}
							}, delay);
						}
						else if (i == 3) {
							handler.postDelayed(new Runnable() {
								public void run() {
									int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
									Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
									computerCard4.setImageDrawable(i_myDrawable);
									current.setImageDrawable(i_myDrawable);
									handler.postDelayed(this, delay);
								}
							}, delay);
						}

						int c_imageId = getContext().getResources().getIdentifier(Computer.computerCards[i].toString(), "drawable", getContext().getPackageName());
						Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
						getGarbage().setImageDrawable(i_myDrawable);

						Card temp = Computer.computerCards[i];
						Computer.computerCards[i] = Game.currentCard;
						Game.garbage.push(temp);

						current.setImageResource(android.R.color.transparent); //  Nothing in the current card is transparent

						break;
					}
					else{

						System.out.println("there are no significant card");

					}

				}
				int c_imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
				Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
				getGarbage().setImageDrawable(i_myDrawable);

				Game.garbage.push(Game.currentCard);
				System.out.println("other cards");

			}
		}


		System.out.println("Current: " + Game.currentCard);
		System.out.println("Garbage: " + Game.garbage.toString());

		for (int i = 0; i < Player.playerCards.length; i++) {
			System.out.println("computer:  " + computerCards[i]);
			System.out.println("player:  " + Player.playerCards[i]);
		}

			Game.currentTurn = "player";
			Game.theGame();
		}
}
