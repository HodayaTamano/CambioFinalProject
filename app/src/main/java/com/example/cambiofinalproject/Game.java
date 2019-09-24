package com.example.cambiofinalproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;


//import com.google.firebase.FirebaseApp;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;


public class Game extends MainActivity{
//    public void onCreate(Bundle savedInstanceState) {
//        Game regularClass = new RegularClass(this);
//    }

	public static boolean gameOn = false;
	public static String winner = "";
	public static Card currentCard = new Card();
	public static String currentTurn = "";
	public static Stack<Card> garbage = new Stack<Card>();
	public static boolean cambio_player = false;
	public static boolean cambio_computer = false;
	public static int computer_sum=0;
	public static int player_sum=0;
	public static long computerWins = 1;
	public static long playerWins = 1;
	public static int level;
//	DatabaseReference ref;

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

		for (int i=0; i<4; i++) {//Dividing 4 cards for the players and remove from the deck.

			Player.playerCards[i] = Card.cardDeck.get(i);
			Computer.computerCards[i] = Card.cardDeck.get(i+4);
		}

		// the computer peek two of his cards at the begining of the game.
		Computer.computerCards[0].setKnown(true);
		Computer.computerCards[1].setKnown(true);


		for (int i=0; i<8; i++) { // Removing the cards from the Deck.
			Card.cardDeck.remove(0);
		}

		// Define current card to be the first card of the deck,
		// set it as known card and remove it from the deck.
		currentCard = Card.cardDeck.get(0);


		// The computer adds his two cards which are close to him into the ArrayList.
		Computer.computerMemory.add(new CardLocation(Computer.computerCards[0],0,"computer"));
		Computer.computerMemory.add(new CardLocation(Computer.computerCards[1],1,"computer"));

		return winner;
	}

	public static void theGame() {
		if(gameOn == true) {
			if (currentTurn == "computer") {
				if(level == 1) {
					Computer.computerTurn();
				}
				else if (level == 0)//the easy level
					Computer.computerTurnRandom();
			} else
				MainActivity.playerTurn();
		} else{ //game over
			Game.computer_sum = 0;
			Game.player_sum = 0;

			for (int i = 0; i < Computer.computerCards.length; i++) {
				if(Computer.computerCards[i].getValue() == 13 && Computer.computerCards[i].getColor().equals("black")){
					computer_sum = computer_sum -1;
				}
				else
				computer_sum = computer_sum+ Computer.computerCards[i].getValue();
			}
			for (int i = 0; i < Player.playerCards.length; i++) {
				if(Player.playerCards[i].getValue() == 13 && Player.playerCards[i].getColor().equals("black")){
					player_sum = player_sum -1;
				}
				else
					player_sum = player_sum + Player.playerCards[i].getValue();
			}

            // Write a message to the database
            final FirebaseDatabase database = FirebaseDatabase.getInstance();

			if(computer_sum == player_sum){ //tie
				winner = "no one";
				if(level == 0) {
                    Intent myIntent = new Intent(getContext(), EasyLevelStatistics.class);
                    getContext().startActivity(myIntent);
                }else if (level == 1){
                    Intent myIntent = new Intent(getContext(), HardLevelStatistics.class);
                    getContext().startActivity(myIntent);
                }
			}
			else if(computer_sum < player_sum) { //the computer win
                winner = "computer";

                if (level == 1) {
                    final DatabaseReference myRef = database.getReference("Hard level").child("Computer");
                    myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {

                                computerWins = (long) dataSnapshot.getValue();
                                computerWins++;
                                myRef.setValue(computerWins);

                                database.getReference("Hard level").child("Player").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        if (dataSnapshot.exists()) {
                                            playerWins = (long) dataSnapshot.getValue();
                                            System.out.println("computerWins: " + computerWins);
                                            System.out.println("playerWins: " + playerWins);
                                            System.out.println("playerWins+computerWins: " + (playerWins + computerWins));
                                            System.out.println((double) computerWins / (computerWins + playerWins));
                                            database.getReference("Hard level").child("Computer Victory Statistics").setValue((double) computerWins / (computerWins + playerWins));
                                            Intent myIntent = new Intent(getContext(), HardLevelStatistics.class);
                                            getContext().startActivity(myIntent);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });


                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }else if (level == 0){
                    final DatabaseReference myRef = database.getReference("Easy level").child("Computer");
                    myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {

                                computerWins = (long) dataSnapshot.getValue();
                                computerWins++;
                                myRef.setValue(computerWins);

                                database.getReference("Easy level").child("Player").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        if (dataSnapshot.exists()) {
                                            playerWins = (long) dataSnapshot.getValue();
                                            System.out.println("computerWins: " + computerWins);
                                            System.out.println("playerWins: " + playerWins);
                                            System.out.println("playerWins+computerWins: " + (playerWins + computerWins));
                                            System.out.println((double) computerWins / (computerWins + playerWins));
                                            database.getReference("Easy level").child("Computer Victory Statistics").setValue((double) computerWins / (computerWins + playerWins));
                                            Intent myIntent = new Intent(getContext(), EasyLevelStatistics.class);
                                            getContext().startActivity(myIntent);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });


                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
			else {
                winner = "player";

                if (level == 1) {
                    final DatabaseReference myRef = database.getReference("Hard level").child("Player");
                    myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {

                                playerWins = (long) dataSnapshot.getValue();
                                playerWins++;
                                myRef.setValue(playerWins);

                                database.getReference("Hard level").child("Computer").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        if (dataSnapshot.exists()) {
                                            computerWins = (long) dataSnapshot.getValue();
                                            System.out.println("computerWins: " + computerWins);
                                            System.out.println("playerWins: " + playerWins);
                                            System.out.println("playerWins+computerWins: " + (playerWins + computerWins));
                                            System.out.println((double) computerWins / (computerWins + playerWins));
                                            database.getReference("Hard level").child("Computer Victory Statistics").setValue((double) computerWins / (computerWins + playerWins));
                                            Intent myIntent = new Intent(getContext(), HardLevelStatistics.class);
                                            getContext().startActivity(myIntent);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });


                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });



                }else if (level == 0){
                    final DatabaseReference myRef = database.getReference("Easy level").child("Player");
                    myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {

                                playerWins = (long) dataSnapshot.getValue();
                                playerWins++;
                                myRef.setValue(playerWins);

                                database.getReference("Easy level").child("Computer").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        if (dataSnapshot.exists()) {
                                            computerWins = (long) dataSnapshot.getValue();
                                            System.out.println("computerWins: " + computerWins);
                                            System.out.println("playerWins: " + playerWins);
                                            System.out.println("playerWins+computerWins: " + (playerWins + computerWins));
                                            System.out.println((double) computerWins / (computerWins + playerWins));
                                            database.getReference("Easy level").child("Computer Victory Statistics").setValue((double) computerWins / (computerWins + playerWins));
                                            Intent myIntent = new Intent(getContext(), EasyLevelStatistics.class);
                                            getContext().startActivity(myIntent);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
			showToastMethod(Game.getContext().getApplicationContext());
            Game.gameOn = false;

		}
    }

	public static void showToastMethod(Context context) {
		if(computer_sum == player_sum){ //tie
			Toast.makeText(context, "It's a tie!", Toast.LENGTH_SHORT).show();
		}else Toast.makeText(context, "the winner is the "+winner, Toast.LENGTH_SHORT).show();
	}
}
