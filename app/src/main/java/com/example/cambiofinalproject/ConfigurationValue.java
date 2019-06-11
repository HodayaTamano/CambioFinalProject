package com.example.cambiofinalproject;
public class ConfigurationValue {

	public static Card x0;
	public static Card x1;
	public static Card x2;
	public static Card x3;


	public ConfigurationValue(){

	}

	public ConfigurationValue(Card computerCards[]){

		this.x0 = computerCards[0];
		this.x1 = computerCards[1];
		this.x2 = computerCards[2];
		this.x3 = computerCards[3];


	}

	public static int before() { 

		int sum= 0;
		for (int i = 0; i < Computer.computerCards.length; i++) {
			if (Computer.computerCards[i].getKnown()== false)  sum+= 6;
			else sum += Computer.computerCards[i].getValue();
		}

		return sum;

	}

	public static int after (Card card,int index) {

		int sum = 0;
		for (int i = 0; i < Computer.computerCards.length; i++) {
			if (i==index) sum += card.getValue();
			else if(Computer.computerCards[i].getKnown()== false)  sum+= 6;
			else sum += Computer.computerCards[i].getValue();
		}

		return sum;
	}

}
