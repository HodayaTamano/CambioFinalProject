package com.example.cambiofinalproject;

public class CardLocation {
	private Card card;
	private int index;
	private String owner; //which player the card belongs to.

	public CardLocation(){
		
	}
	
	public CardLocation(Card card, int index, String owner) {
		this.card = card;
		this.index = index;
		this.owner = owner;	
	}

	@Override
	public String toString() {
		return "CardLocation [card=" + card + ", index=" + index + ", owner=" + owner + "]";
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
}