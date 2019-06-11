package com.example.cambiofinalproject;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

//import javafx.scene.image.*;


public class Card {
	
	public static List<Card> cardDeck = new ArrayList<Card>(); //create an ArrayList "cardDeck" 
	private int value; //initialize the value (2,3,4...King, Ace)
	private int type; //initialize the type (spades, hearts...)
	private String color;//initialize the color (black and red)
	private String use;
	private Boolean known; // if the card is known - return true. else, false.
	private ImageView image;

	public Card(){

	}
	public Boolean getKnown() {
		return known;
	}

	public void setKnown(Boolean known) {
		this.known = known;
	}


	//constructor
	public Card(int type,int value/*,String color ,String use,, ImageView image*/){
		this.value = value;
		this.type = type;
		this.color = color;
		this.use = use;
		this.known = false;
		this.image = image;
	}//end construcor


	//Getters
	public String getColor() {
		return color;
	}

	public int getValue() {
			return value;
	}

	public int getType() {
		return type;
	}

	public String getUse() {
		return use;
	}

	public ImageView getImage() {
		return image;
	}

	// Setters
	public void setColor(String color) {
		this.color = color;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public void setImage(ImageView image) {
		this.image = image;
	}


	@Override
	public String toString(){
		//combine rank and suit together into a single string(ex: Ace of Diamonds)

		//using StringBuilder for modifiability later on
		StringBuilder displayCard = new StringBuilder();

		//personal choice to use switch
		switch(type){
			case 0:
				displayCard.append("spades");
				break;
			case 1:
				displayCard.append("hearts");
				break;
			case 2:
				displayCard.append("clubs");
				break;
			case 3:
				displayCard.append("diamonds");
				break;
			default: //anything else, do nothing
				break;
		}//end suit switch

		displayCard.append("of"); //setting the format of the output

		switch(value){
			//since rank is int type, now match int 11 to String jack...14 to Ace
			case 11:
				displayCard.append("jack");
				break;
			case 12:
				displayCard.append("queen");
				break;
			case 13:
				displayCard.append("king");
				break;
			case 14:
				displayCard.append("ace");
				break;
			default:
				displayCard.append(value); //number from 2 to 10 does not need to modify
				break;
		}//end rank switch

		//return the result of an entire combined string
		return displayCard.toString();
	}//end toString

}//end Card Class