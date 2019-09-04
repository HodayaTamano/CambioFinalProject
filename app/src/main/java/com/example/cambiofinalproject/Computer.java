package com.example.cambiofinalproject;

import android.graphics.drawable.Drawable;
import android.os.Handler;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


import static com.example.cambiofinalproject.MainActivity.*;

public class Computer {

    public static Card[] computerCards = new Card[4];
    public static ArrayList<CardLocation> computerMemory = new ArrayList<CardLocation>();    // Initialize computer memory ArrayList.

    public Computer() {
    }

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

    public static void computerTurn() {
        System.out.println("Now it's computer turn");
        Game.currentTurn = "computer";

        final Handler handler = new Handler();
        final int delay = 1500; //milliseconds
        final int delay1 = 3000; //milliseconds

        int minGarbage = 52;
        int minPlayerSwap = 52;
        int indexComputer = -1; // the index of the card that I want to replace.
        int indexPlayer = -1;
        int computerKnownCard = 0;
        int highValue = 0;
        boolean replaced = false;
        int minValue = 13;

        int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
        Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);

        int imageIdCurrent = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
        Drawable myDrawableCurrent = getContext().getResources().getDrawable(imageIdCurrent);

        int imageIdChosen = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
        Drawable myDrawableChosen = getContext().getResources().getDrawable(imageIdChosen);

        int imageIdCDeck = getContext().getResources().getIdentifier("cbackdeck", "drawable", getContext().getPackageName());
        Drawable myDrawableCDeck = getContext().getResources().getDrawable(imageIdCDeck);


        System.out.println("First element in the garbage is " + Game.garbage.peek());
        if (Game.garbage.peek().getValue() < 5) {
            System.out.println("The computer see that the value in the garbage is < 5");
            for (int i = 0; i < computerCards.length; i++) {
                if ((!Game.garbage.isEmpty()) && (ConfigurationValue.after(Game.garbage.peek(), i) <= minGarbage)) {
                    minGarbage = ConfigurationValue.after(Game.garbage.peek(), i);
                    indexComputer = i;
                }
            }

            System.out.print("The computer cards are: [");
            for (int i = 0; i < computerCards.length; i++) {
                System.out.print(computerCards[i] + " ");
            }
            System.out.print("]");

            System.out.println("swaping between garbage card and computer card");

            // display swaping between garbage card and computer card
            int c_imageId = getContext().getResources().getIdentifier("c" + Computer.computerCards[indexComputer].toString(), "drawable", getContext().getPackageName());
            Drawable c_myDrawable = getContext().getResources().getDrawable(c_imageId);
            getGarbage().setImageDrawable(c_myDrawable);

            // the real swaping
            Card temp = Computer.computerCards[indexComputer];
            Computer.computerCards[indexComputer] = Game.garbage.pop();
            Game.garbage.push(temp);
            Game.currentCard = Game.garbage.peek();

            if (indexComputer == 0)
                computerCard1.setImageDrawable(myDrawableChosen);
            else if (indexComputer == 1)
                computerCard2.setImageDrawable(myDrawableChosen);
            else if (indexComputer == 2)
                computerCard3.setImageDrawable(myDrawableChosen);
            else if (indexComputer == 3)
                computerCard4.setImageDrawable(myDrawableChosen);


            if (indexComputer == 0)
                handler.postDelayed(new Runnable() {
                    public void run() {
                        int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                        Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                        computerCard1.setImageDrawable(myDrawableBack);

                        int imageId = getContext().getResources().getIdentifier(Game.garbage.peek().toString(), "drawable", getContext().getPackageName());
                        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                        getGarbage().setImageDrawable(myDrawable);

                        handler.postDelayed(this, delay);
                    }
                }, delay);
            else if (indexComputer == 1)
                handler.postDelayed(new Runnable() {
                    public void run() {
                        int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                        Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                        computerCard2.setImageDrawable(myDrawableBack);

                        int imageId = getContext().getResources().getIdentifier(Game.garbage.peek().toString(), "drawable", getContext().getPackageName());
                        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                        getGarbage().setImageDrawable(myDrawable);
                        handler.postDelayed(this, delay);
                    }
                }, delay);
            else if (indexComputer == 2)
                handler.postDelayed(new Runnable() {
                    public void run() {
                        int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                        Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                        computerCard3.setImageDrawable(myDrawableBack);

                        int imageId = getContext().getResources().getIdentifier(Game.garbage.peek().toString(), "drawable", getContext().getPackageName());
                        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                        getGarbage().setImageDrawable(myDrawable);
                        handler.postDelayed(this, delay);
                    }
                }, delay);
            else if (indexComputer == 3)
                handler.postDelayed(new Runnable() {
                    public void run() {
                        int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                        Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                        computerCard4.setImageDrawable(myDrawableBack);

                        int imageId = getContext().getResources().getIdentifier(Game.garbage.peek().toString(), "drawable", getContext().getPackageName());
                        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                        getGarbage().setImageDrawable(myDrawable);
                        handler.postDelayed(this, delay);
                    }
                }, delay);


            System.out.print("The computer cards are: [");
            for (int i = 0; i < computerCards.length; i++) {
                System.out.print(computerCards[i] + " ");
            }
            System.out.print("]");

            //adding the cards to computer memory
            computerMemory.add(new CardLocation(temp, -1, "garbage"));
            computerMemory.add(new CardLocation(Computer.computerCards[indexComputer], indexComputer, "computer"));
        } else {
            System.out.println("The computer see that the value in the garbage is >= 5");
            Game.currentCard = Card.cardDeck.get(0);
            Game.currentCard.setKnown(true);
            Card.cardDeck.remove(0);


            if (Game.currentCard.getValue() == 7 || Game.currentCard.getValue() == 8) {
                System.out.println("The computer see that the value in the current is: " + Game.currentCard.getValue());
                for (int i = 0; i < computerCards.length; i++) {
                    if (computerCards[i].getKnown() == false) {
//						System.out.println("if (computerCards[i].getKnown() == false){");

//						getGarbage().setImageDrawable(myDrawableCurrent);

                        Computer.computerMemory.add(new CardLocation(computerCards[i], i, "computer"));
                        computerCards[i].setKnown(true);

                        // Showing to the player which card was peeked
                        my_Handler("computer", i, "peekcard", 0);

                        System.out.println("3");

                        // After 1.5 sec flip the card.

                        my_Handler("computer", i, "back", 1500);
//
                        System.out.print("The computer throws the card " + Game.currentCard.toString() + " to the garbage");


                        // Throw the card (7 or 8) to the garbage.
                        int imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
                        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                        getGarbage().setImageDrawable(myDrawable);

                        Game.garbage.push(Game.currentCard);
                        Game.currentCard = Game.garbage.peek();


                        break;
                    }
                }
            } else if (Game.currentCard.getValue() == 9 || Game.currentCard.getValue() == 10) {
                System.out.println("The computer see that the value in the current is: " + Game.currentCard.getValue());
                for (int i = 0; i < Player.playerCards.length; i++) {
                    if (Player.playerCards[i].getKnown() == false) {
//						System.out.println("if (Player.playerCards[i].getKnown() == false){");

//						getGarbage().setImageDrawable(myDrawableCurrent);

                        Computer.computerMemory.add(new CardLocation(Player.playerCards[i], i, "player"));
                        Player.playerCards[i].setKnown(true);

                        my_Handler("player", i, "peekcard", 0);
                        my_Handler("player", i, "back", 1500);

                        System.out.print("The computer throws the card " + Game.currentCard.toString() + " to the garbage");

                        int imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
                        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                        getGarbage().setImageDrawable(myDrawable);

                        Game.garbage.push(Game.currentCard);
                        Game.currentCard = Game.garbage.peek();

                        break;
                    }
                }
            } else if (Game.currentCard.getValue() == 11 || Game.currentCard.getValue() == 12) {
                System.out.println("the value in the current queen or jack");
                for (int i = 0; i < Player.playerCards.length; i++) {
                    if (Player.playerCards[i].getKnown() == true) {
                        for (int j = 0; j < computerCards.length; j++) {
                            if (ConfigurationValue.after(Player.playerCards[i], j) < minPlayerSwap) {
                                minPlayerSwap = ConfigurationValue.after(Player.playerCards[i], j);
                                indexPlayer = i;
                                indexComputer = j;
                            }
                        }
                    } else {
                        System.out.println("don't recognized");
                        continue;
                    }
                }
                // display swapping between player card and computer card
                System.out.println("swapping between player card and computer card");

                System.out.println("5");
                my_Handler("player", indexPlayer, "chosencard", 0);
                my_Handler("computer", indexComputer, "chosencard", 0);

                System.out.println("6");

                System.out.println("7");

                my_Handler("player", indexPlayer, "back", 1500);
                System.out.println("8");
                my_Handler("computer", indexComputer, "back", 1500);

                System.out.println("9");


                if (indexComputer != -1 && indexPlayer != -1) {
                    computerMemory.remove(new CardLocation(Player.playerCards[indexPlayer], indexPlayer, "player"));
                    computerMemory.add(new CardLocation(Player.playerCards[indexPlayer], indexComputer, "computer"));

                    computerMemory.remove(new CardLocation(Computer.computerCards[indexComputer], indexComputer, "computer"));
                    computerMemory.add(new CardLocation(Computer.computerCards[indexComputer], indexPlayer, "player"));

                    System.out.print("The computer cards are: [");
                    for (int i = 0; i < computerCards.length; i++) {
                        System.out.print(computerCards[i] + " ");
                    }
                    System.out.println("]");
                    System.out.println("");


                    System.out.print("The player cards are: [");
                    for (int i = 0; i < Player.playerCards.length; i++) {
                        System.out.print(Player.playerCards[i] + " ");
                    }
                    System.out.println("]");
                    System.out.println("");

                    // the real swaping
                    Card temp = Computer.computerCards[indexComputer];
                    Computer.computerCards[indexComputer] = Player.playerCards[indexPlayer];
                    Player.playerCards[indexPlayer] = temp;


                    System.out.println("10 - after swap");
                    System.out.print("The computer cards are: [");
                    for (int i = 0; i < computerCards.length; i++) {
                        System.out.print(computerCards[i] + " ");
                    }
                    System.out.println("]");
                    System.out.println("");


                    System.out.print("The player cards are: [");
                    for (int i = 0; i < Player.playerCards.length; i++) {
                        System.out.print(Player.playerCards[i] + " ");
                    }
                    System.out.println("]");
                    System.out.println("");

                    System.out.println("minPlayerSwap: " + minPlayerSwap);
                    System.out.println("indexPlayer: " + indexPlayer);
                    System.out.println("indexComputer: " + indexComputer);

                }

                Game.garbage.push(Game.currentCard);
                Game.currentCard = Game.garbage.peek();

                System.out.println("11 - after pushing to garbage");
                int imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
                Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                getGarbage().setImageDrawable(myDrawable);
                System.out.println("12");

            } else if (Game.currentCard.getValue() == 13 && Game.currentCard.getColor().equals("black")) {
                if (Player.playerCards[0].getKnown() == false && Player.playerCards[1].getKnown() == false
                        && Player.playerCards[2].getKnown() == false && Player.playerCards[3].getKnown() == false) {
                    // The computer does not know any of the player's cards.
                    //He peek at playercard3. If there is a good card (1,2, -1) he replaces it with his unknown card.

                    Player.playerCards[2].setKnown(true);
                    my_Handler("player", 2, "peekcard", 0);

                    //case 1:
                    if (Player.playerCards[2].getValue() == 1 || Player.playerCards[2].getValue() == 2 || Player.playerCards[2].getValue() == 3
                            || Player.playerCards[2].getValue() == 13 && Player.playerCards[2].getColor().equals("red")) {
                        //It's a good card
                        System.out.println("case 1");
                        for (int j = 0; j < Computer.computerCards.length; j++) {
                            if (Computer.computerCards[j].getKnown() == false) {

                                Computer.computerCards[j].setKnown(true);

                                // peek and swap
                                my_Handler("computer", j, "peekcard", 0);

                                if (Computer.computerCards[j].getValue() > Player.playerCards[2].getValue()) {
                                    //swap

                                    my_Handler("player", 2, "chosencard", 1500);
                                    my_Handler("computer", j, "chosencard", 1500);

                                    my_Handler("player", 2, "back", 3000);
                                    my_Handler("computer", j, "back", 3000);


                                    //the real swap
                                    Card temp = Computer.computerCards[j];
                                    Computer.computerCards[j] = Player.playerCards[2];
                                    Player.playerCards[2] = temp;
                                    Computer.computerMemory.add(new CardLocation(Player.playerCards[2], 2, "player"));
                                    Computer.computerMemory.add(new CardLocation(Computer.computerCards[j], j, "computer"));
                                    break;
                                } else {
                                    // dont make the swap

                                    my_Handler("player", 2, "back", 0);
                                    my_Handler("computer", j, "back", 0);


                                    Computer.computerMemory.add(new CardLocation(Player.playerCards[2], 2, "player"));
                                    Computer.computerMemory.add(new CardLocation(Computer.computerCards[j], j, "computer"));
                                    Player.playerCards[2].setKnown(true);
                                    Computer.computerCards[j].setKnown(true);

                                    break;
                                }
//

                            } else {
                                System.out.println("the card is known- continue to the next card");
                                computerKnownCard++;
                            }
                        }
                        if (computerKnownCard == 4) { // if I peek to the player good card and I know all my cards. I will swap with my high card/
                            for (int j = 0; j < computerCards.length; j++) {
                                if (Computer.computerCards[j].getValue() > highValue && Computer.computerCards[j].getValue() > Player.playerCards[3].getValue()) {
                                    highValue = Computer.computerCards[j].getValue();
                                    indexComputer = j;
                                }
                            }
                            if (highValue == 0) {
                                //the computer cards are Better than the player's card. I dont want to swap
                                //I will show to the player that I peek my first card
                                my_Handler("computer", indexComputer, "peekcard", 0);
                                Computer.computerCards[indexComputer].setKnown(true);

                                my_Handler("player", 2, "back", 1500);
                                my_Handler("computer", indexComputer, "back", 1500);

                            } else {
                                //swap

                                my_Handler("computer", indexComputer, "peekcard", 0);
                                Computer.computerCards[indexComputer].setKnown(true);

                                my_Handler("player", 2, "chosencard", 1500);
                                my_Handler("computer", indexComputer, "chosencard", 1500);

                                my_Handler("player", 2, "back", 3000);
                                my_Handler("computer", indexComputer, "back", 3000);

                                // the real swap
                                Card temp = Computer.computerCards[indexComputer];
                                Computer.computerCards[indexComputer] = Player.playerCards[2];
                                Player.playerCards[2] = temp;

                                Computer.computerMemory.add(new CardLocation(Player.playerCards[2], 2, "player"));
                                Computer.computerMemory.add(new CardLocation(Computer.computerCards[indexComputer], indexComputer, "computer"));
                            }
                        }
                    } else {// the card of the player are not very good
                        // case 2:
                        System.out.println("case 2");
                        for (int j = 0; j < Computer.computerCards.length; j++) {
                            if (Computer.computerCards[j].getKnown() == true) {
                                computerKnownCard++;
                                if (Computer.computerCards[j].getValue() > highValue && Computer.computerCards[j].getValue() > Player.playerCards[3].getValue()) {
                                    highValue = Computer.computerCards[j].getValue();
                                    indexComputer = j;
                                }
                            }
                        }

                        if (highValue - Player.playerCards[2].getValue() >= 4) {//I want to chek if I want this card
                            // peek and swap
                            my_Handler("computer", indexComputer, "peekcard", 0);
                            Computer.computerCards[indexComputer].setKnown(true);

                            my_Handler("player", 2, "chosencard", 1500);
                            my_Handler("computer", indexComputer, "chosencard", 1500);

                            my_Handler("player", 2, "back", 3000);
                            my_Handler("computer", indexComputer, "back", 3000);

                            // the real swap
                            Card temp = Computer.computerCards[indexComputer];
                            Computer.computerCards[indexComputer] = Player.playerCards[2];
                            Player.playerCards[2] = temp;

                            replaced = true;
                            Computer.computerMemory.add(new CardLocation(Player.playerCards[2], 2, "player"));
                            Computer.computerMemory.add(new CardLocation(Computer.computerCards[indexComputer], indexComputer, "computer"));


                        } else if (replaced == false && computerKnownCard != 4) {// I not replaced and thre are at least one unknown card

                            for (int j = 0; j < Computer.computerCards.length; j++) {
                                if (Computer.computerCards[j].getKnown() == false) {
                                    //peek and check if you want to swap
                                    Computer.computerCards[j].setKnown(true);
                                    my_Handler("computer", j, "peekcard", 0);

                                    if (Computer.computerCards[j].getValue() - Player.playerCards[2].getValue() > 0) {
                                        //want to swap

                                        my_Handler("player", 2, "chosencard", 1500);
                                        my_Handler("computer", j, "chosencard", 1500);// computer/player, index, which card, which delay
                                        my_Handler("player", 2, "back", 3000);
                                        my_Handler("computer", j, "back", 3000);

                                        //the real swap
                                        Card temp = Computer.computerCards[j];
                                        Computer.computerCards[j] = Player.playerCards[2];
                                        Player.playerCards[2] = temp;

                                        replaced = true;
                                        Computer.computerMemory.add(new CardLocation(Player.playerCards[2], 2, "player"));
                                        Computer.computerMemory.add(new CardLocation(Computer.computerCards[j], j, "computer"));
                                        break;
                                    } else {// I dont want to swap
                                        my_Handler("player", 2, "back", 1500);
                                        my_Handler("computer", j, "back", 1500);
                                        Computer.computerMemory.add(new CardLocation(Player.playerCards[2], 2, "player"));
                                        Computer.computerMemory.add(new CardLocation(Computer.computerCards[j], j, "computer"));
                                        break;
                                    }

                                } else
                                    System.out.println("you already check this card- this is known card");
                            }
                        } else if (computerKnownCard == 4) {
                            // All computer cards are known. I will swap with the highest card.

                            if (highValue == 0) {
                                //the computer cards are Better than the player's card. I dont want to swap
                                my_Handler("computer", indexComputer, "peekcard", 1500);
                                Computer.computerCards[indexComputer].setKnown(true);
                                my_Handler("player", 2, "back", 3000);
                                my_Handler("computer", indexComputer, "back", 3000);
                            } else {
                                my_Handler("player", 2, "chosencard", 1500);
                                my_Handler("computer", indexComputer, "chosencard", 1500);
                                my_Handler("player", 2, "back", 3000);
                                my_Handler("computer", indexComputer, "back", 3000);


                                // the real swap
                                Card temp = Computer.computerCards[indexComputer];
                                Computer.computerCards[indexComputer] = Player.playerCards[2];
                                Player.playerCards[2] = temp;

                                Computer.computerMemory.add(new CardLocation(Player.playerCards[2], 2, "player"));
                                Computer.computerMemory.add(new CardLocation(Computer.computerCards[indexComputer], indexComputer, "computer"));

                            }
                        }

                    }
                } else if (Player.playerCards[0].getKnown() == true && Player.playerCards[1].getKnown() == true
                        && Player.playerCards[2].getKnown() == true && Player.playerCards[3].getKnown() == true) {

                    for (int i = 0; i < Player.playerCards.length; i++) {
                        if (Player.playerCards[i].getValue() == 13 && Player.playerCards[i].getColor().equals("red")) {
                            minValue = -1;
                            indexPlayer = i;
                            break;
                        } else if (Player.playerCards[i].getValue() < minValue) {
                            minValue = Player.playerCards[i].getValue();
                            indexPlayer = i;
                        }
                    }
                    my_Handler("player", indexPlayer, "peekcard", 0);
                    Player.playerCards[indexPlayer].setKnown(true);
                    //case 3:
                    if (minValue == -1 || minValue == 1 || minValue == 2 || minValue == 3) { //the card is good. I want to take
                        System.out.println("case 3");
                        for (int j = 0; j < computerCards.length; j++) {
                            if (Computer.computerCards[j].getKnown() == false) {
                                //swap
                                my_Handler("computer", j, "peekcard", 0);
                                Computer.computerCards[j].setKnown(true);
                                my_Handler("player", indexPlayer, "chosencard", 1500);
                                my_Handler("computer", j, "chosencard", 1500);
                                my_Handler("player", indexPlayer, "back", 3000);
                                my_Handler("computer", j, "back", 3000);


                                // the real swap
                                Card temp = Computer.computerCards[j];
                                Computer.computerCards[j] = Player.playerCards[indexPlayer];
                                Player.playerCards[indexPlayer] = temp;

                                Computer.computerMemory.add(new CardLocation(Player.playerCards[indexPlayer], indexPlayer, "player"));
                                Computer.computerMemory.add(new CardLocation(Computer.computerCards[j], j, "computer"));
                                break;
                            }
                        }
                    } else {// the value is 4-13(black)
                        //case 4:
                        if (Computer.computerCards[0].getKnown() == true && Computer.computerCards[1].getKnown() == true
                                && Computer.computerCards[2].getKnown() == true && Computer.computerCards[3].getKnown() == true) {
                            System.out.println("case 4");
                            for (int j = 0; j < computerCards.length; j++) {
                                if (Computer.computerCards[j].getValue() > highValue && Computer.computerCards[j].getValue() > minValue) {
                                    highValue = Computer.computerCards[j].getValue();
                                    indexComputer = j;
                                }
                            }
                            if (highValue == 0) {
                                //the computer cards are Better than the player's card. I dont want to swap
                                //I will show to the player that I peek my first card
                                my_Handler("computer", indexComputer, "peekcard", 0);
                                Computer.computerCards[indexComputer].setKnown(true);

                                my_Handler("player", indexPlayer, "back", 1500);
                                my_Handler("computer", indexComputer, "back", 1500);

                            } else {
                                //swap

                                my_Handler("computer", indexComputer, "peekcard", 0);
                                Computer.computerCards[indexComputer].setKnown(true);

                                my_Handler("player", indexPlayer, "chosencard", 1500);
                                my_Handler("computer", indexComputer, "chosencard", 1500);

                                my_Handler("player", indexPlayer, "back", 3000);
                                my_Handler("computer", indexComputer, "back", 3000);

                                // the real swap
                                Card temp = Computer.computerCards[indexComputer];
                                Computer.computerCards[indexComputer] = Player.playerCards[indexPlayer];
                                Player.playerCards[indexPlayer] = temp;

                                Computer.computerMemory.add(new CardLocation(Player.playerCards[indexPlayer], indexPlayer, "player"));
                                Computer.computerMemory.add(new CardLocation(Computer.computerCards[indexComputer], indexComputer, "computer"));
                            }
                        } else { //I dont know all my card

                            for (int j = 0; j < Computer.computerCards.length; j++) {
                                if (Computer.computerCards[j].getKnown() == true) {
                                    computerKnownCard++;
                                    if (Computer.computerCards[j].getValue() - Player.playerCards[indexPlayer].getValue() >= 4) {//I want to chek if I want this card
                                        // peek and swap
                                        my_Handler("computer", j, "peekcard", 0);
                                        Computer.computerCards[indexComputer].setKnown(true);

                                        my_Handler("player", indexPlayer, "chosencard", 1500);
                                        my_Handler("computer", j, "chosencard", 1500);

                                        my_Handler("player", indexPlayer, "back", 3000);
                                        my_Handler("computer", j, "back", 3000);

                                        // the real swap
                                        Card temp = Computer.computerCards[j];
                                        Computer.computerCards[j] = Player.playerCards[indexPlayer];
                                        Player.playerCards[indexPlayer] = temp;

                                        replaced = true;
                                        Computer.computerMemory.add(new CardLocation(Player.playerCards[indexPlayer], indexPlayer, "player"));
                                        Computer.computerMemory.add(new CardLocation(Computer.computerCards[j], j, "computer"));
                                        break;


                                    } else {
                                        System.out.println("else - the difference < 4");
                                    }
                                }
                            }

                            if (replaced == false && computerKnownCard != 4) {// I not replaced and thre are at least one unknown card

                                for (int j = 0; j < Computer.computerCards.length; j++) {
                                    if (Computer.computerCards[j].getKnown() == false) {
                                        //peek and check if you want to swap
                                        Computer.computerCards[j].setKnown(true);
                                        my_Handler("computer", j, "peekcard", 0);

                                        if (Computer.computerCards[j].getValue() - Player.playerCards[indexPlayer].getValue() > 0) {
                                            //want to swap

                                            my_Handler("player", indexPlayer, "chosencard", 1500);
                                            my_Handler("computer", j, "chosencard", 1500);// computer/player, index, which card, which delay
                                            my_Handler("player", indexPlayer, "back", 3000);
                                            my_Handler("computer", j, "back", 3000);

                                            //the real swap
                                            Card temp = Computer.computerCards[j];
                                            Computer.computerCards[j] = Player.playerCards[indexPlayer];
                                            Player.playerCards[indexPlayer] = temp;

                                            replaced = true;
                                            Computer.computerMemory.add(new CardLocation(Player.playerCards[indexPlayer], indexPlayer, "player"));
                                            Computer.computerMemory.add(new CardLocation(Computer.computerCards[j], j, "computer"));
                                            break;
                                        } else {// I dont want to swap
                                            my_Handler("player", indexPlayer, "back", 1500);
                                            my_Handler("computer", j, "back", 1500);
                                            break;
                                        }
                                    } else
                                        System.out.println("you already check this card- this is known card");
                                }
                            } else if (computerKnownCard == 4) {
                                // All computer cards are known. I will swap with the highest card.
                                for (int j = 0; j < computerCards.length; j++) {
                                    if (Computer.computerCards[j].getValue() > highValue && Computer.computerCards[j].getValue() > Player.playerCards[indexPlayer].getValue()) {
                                        highValue = Computer.computerCards[j].getValue();
                                        indexComputer = j;
                                    }
                                }
                                //swap
//
                                if (highValue == 0) {
                                    //the computer cards are Better than the player's card. I dont want to swap

                                    my_Handler("computer", indexComputer, "peekcard", 1500);
                                    Computer.computerCards[indexComputer].setKnown(true);
                                    my_Handler("player", indexPlayer, "back", 3000);
                                    my_Handler("computer", indexComputer, "back", 3000);
                                } else {
                                    my_Handler("player", indexPlayer, "chosencard", 1500);
                                    my_Handler("computer", indexComputer, "chosencard", 1500);
                                    my_Handler("player", indexPlayer, "back", 3000);
                                    my_Handler("computer", indexComputer, "back", 3000);


                                    // the real swap
                                    Card temp = Computer.computerCards[indexComputer];
                                    Computer.computerCards[indexComputer] = Player.playerCards[indexPlayer];
                                    Player.playerCards[indexPlayer] = temp;

                                    Computer.computerMemory.add(new CardLocation(Player.playerCards[indexPlayer], indexPlayer, "player"));
                                    Computer.computerMemory.add(new CardLocation(Computer.computerCards[indexComputer], indexComputer, "computer"));

                                }
                            }
                        }


                    }


                } else {// I dont know all the player card
                    for (int i = 0; i < Player.playerCards.length; i++) {
                        if (Player.playerCards[i].getKnown() == true) {
                            if (Player.playerCards[i].getValue() == 13 && Player.playerCards[i].getColor().equals("red")) {
                                minValue = -1;
                                indexPlayer = i;
                                break;
                            } else if (Player.playerCards[i].getValue() < minValue) {
                                minValue = Player.playerCards[i].getValue();
                                indexPlayer = i;
                            }
                        }
                    }
//
                    //case 5:
                    if (minValue == -1 || minValue == 1 || minValue == 2 || minValue == 3) { //the card is good. I want to take
                        System.out.println("case 5");
                        my_Handler("player", indexPlayer, "peekcard", 0);
                        Player.playerCards[indexPlayer].setKnown(true);
                        for (int j = 0; j < computerCards.length; j++) {
                            if (Computer.computerCards[j].getKnown() == false) {
                                //swap
                                my_Handler("computer", j, "peekcard", 0);
                                Computer.computerCards[j].setKnown(true);
                                my_Handler("player", indexPlayer, "chosencard", 1500);
                                my_Handler("computer", j, "chosencard", 1500);
                                my_Handler("player", indexPlayer, "back", 3000);
                                my_Handler("computer", j, "back", 3000);


                                // the real swap
                                Card temp = Computer.computerCards[j];
                                Computer.computerCards[j] = Player.playerCards[indexPlayer];
                                Player.playerCards[indexPlayer] = temp;

                                Computer.computerMemory.add(new CardLocation(Player.playerCards[indexPlayer], indexPlayer, "player"));
                                Computer.computerMemory.add(new CardLocation(Computer.computerCards[j], j, "computer"));
                                break;
                            }
                        }
                    } else {// case 6: rest of the card (not very good cards)
                        System.out.println("case 6");
                        for (int j = 0; j < Computer.computerCards.length; j++) {
                            if (Computer.computerCards[j].getKnown() == true) {
                                computerKnownCard++;
                                if (Computer.computerCards[j].getValue() - Player.playerCards[indexPlayer].getValue() >= 4) {//I want to chek if I want this card
                                    // peek and swap
                                    my_Handler("player", indexPlayer, "peekcard", 0);
                                    Player.playerCards[indexPlayer].setKnown(true);
                                    my_Handler("computer", j, "peekcard", 0);
                                    Computer.computerCards[j].setKnown(true);

                                    my_Handler("player", indexPlayer, "chosencard", 1500);
                                    my_Handler("computer", j, "chosencard", 1500);

                                    my_Handler("player", indexPlayer, "back", 3000);
                                    my_Handler("computer", j, "back", 3000);

                                    // the real swap
                                    Card temp = Computer.computerCards[j];
                                    Computer.computerCards[j] = Player.playerCards[indexPlayer];
                                    Player.playerCards[indexPlayer] = temp;

                                    replaced = true;
                                    Computer.computerMemory.add(new CardLocation(Player.playerCards[indexPlayer], indexPlayer, "player"));
                                    Computer.computerMemory.add(new CardLocation(Computer.computerCards[j], j, "computer"));
                                    break;


                                } else {
                                    System.out.println("else - the difference < 4");
                                }
                            }
                        }

                        if (replaced == false && computerKnownCard != 4) {// I not replaced and thre are at least one unknown card

                            for (int j = 0; j < Computer.computerCards.length; j++) {
                                if (Computer.computerCards[j].getKnown() == false) {
                                    //peek and check if you want to swap
                                    my_Handler("player", indexPlayer, "peekcard", 0);
                                    Player.playerCards[indexPlayer].setKnown(true);
                                    Computer.computerCards[j].setKnown(true);
                                    my_Handler("computer", j, "peekcard", 0);

                                    if (Computer.computerCards[j].getValue() - Player.playerCards[indexPlayer].getValue() > 0) {
                                        //want to swap

                                        my_Handler("player", indexPlayer, "chosencard", 1500);
                                        my_Handler("computer", j, "chosencard", 1500);// computer/player, index, which card, which delay
                                        my_Handler("player", indexPlayer, "back", 3000);
                                        my_Handler("computer", j, "back", 3000);

                                        //the real swap
                                        Card temp = Computer.computerCards[j];
                                        Computer.computerCards[j] = Player.playerCards[indexPlayer];
                                        Player.playerCards[indexPlayer] = temp;

                                        replaced = true;
                                        Computer.computerMemory.add(new CardLocation(Player.playerCards[indexPlayer], indexPlayer, "player"));
                                        Computer.computerMemory.add(new CardLocation(Computer.computerCards[j], j, "computer"));
                                        break;
                                    } else {// I dont want to swap
                                        my_Handler("player", indexPlayer, "back", 1500);
                                        my_Handler("computer", j, "back", 1500);
                                        break;
                                    }
                                } else
                                    System.out.println("you already check this card- this is known card");
                            }
                        } else if (computerKnownCard == 4) {
                            // All computer cards are known. I will swap with the highest card.
                            for (int j = 0; j < computerCards.length; j++) {
                                if (Computer.computerCards[j].getValue() > highValue && Computer.computerCards[j].getValue() > Player.playerCards[2].getValue()) {
                                    highValue = Computer.computerCards[j].getValue();
                                    indexComputer = j;
                                }
                            }
                            //swap
//
                            if (highValue == 0) {
                                //the computer cards are Better than the player's card. I dont want to swap
                                my_Handler("player", indexPlayer, "peekcard", 0);
                                Player.playerCards[indexPlayer].setKnown(true);
                                my_Handler("computer", indexComputer, "peekcard", 1500);
                                Computer.computerCards[indexComputer].setKnown(true);
                                my_Handler("player", indexPlayer, "back", 3000);
                                my_Handler("computer", indexComputer, "back", 3000);
                            } else {
                                my_Handler("player", indexPlayer, "chosencard", 1500);
                                my_Handler("computer", indexComputer, "chosencard", 1500);
                                my_Handler("player", indexPlayer, "back", 3000);
                                my_Handler("computer", indexComputer, "back", 3000);
                                
                                // the real swap
                                Card temp = Computer.computerCards[indexComputer];
                                Computer.computerCards[indexComputer] = Player.playerCards[indexPlayer];
                                Player.playerCards[indexPlayer] = temp;

                                Computer.computerMemory.add(new CardLocation(Player.playerCards[indexPlayer], indexPlayer, "player"));
                                Computer.computerMemory.add(new CardLocation(Computer.computerCards[indexComputer], indexComputer, "computer"));
                            }
                        }
                    }
                }

                System.out.println("the value in the current is black king");

                //throw the black king to the garbage
                int imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
                Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                getGarbage().setImageDrawable(myDrawable);

                Game.garbage.push(Game.currentCard);
                Game.currentCard = Game.garbage.peek();

            } else {
                System.out.println("Other card - the value in the current 1-6");
                for (int i = 0; i < computerCards.length; i++) {

                    System.out.println("the card is " + computerCards[i]);
                    System.out.println("computerCards[i].getKnown() = " + computerCards[i].getKnown() + " && (computerCards[i].getValue() - Game.currentCard.getValue()) = " + (computerCards[i].getValue() - Game.currentCard.getValue()));

                    if ((computerCards[i].getKnown() == true) && (computerCards[i].getValue() > Game.currentCard.getValue())) {
                        System.out.println("if((computerCards[i].getKnown() == true ) && (computerCards[i].getValue() > Game.currentCard.getValue())");

                        cardDeck.setImageDrawable(myDrawableCDeck);
                        my_Handler("computer", i, "chosencard", 0);
                        my_Handler("computer", i, "back", 1500);
                        my_Handler("deck", 0, "backdeck", 1500);

                        System.out.println("the i is: " + i);

                        int cimageId = getContext().getResources().getIdentifier(Computer.computerCards[i].toString(), "drawable", getContext().getPackageName());
                        Drawable cmyDrawable = getContext().getResources().getDrawable(cimageId);
                        getGarbage().setImageDrawable(cmyDrawable);

                        System.out.println("current card before swap: " + Game.currentCard);
                        System.out.println("computer card before swap: " + Computer.computerCards[i]);
                        Card temp = Computer.computerCards[i];
                        Computer.computerCards[i] = Game.currentCard;
                        Game.garbage.push(temp);
                        Game.currentCard = Game.garbage.peek();

                        System.out.println("current card after swap: " + Game.currentCard);
                        System.out.println("computer card after swap: " + Computer.computerCards[i]);

                        current.setImageResource(android.R.color.transparent); //  Nothing in the current card is transparent
                        break;

                    } else {
                        System.out.println("there are no significant card");
                        cardDeck.setImageDrawable(myDrawableCDeck);
                        my_Handler("deck", 0, "backdeck", 1500);
                    }
                }

                int c_imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
                Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
                getGarbage().setImageDrawable(i_myDrawable);

                if (!Game.garbage.peek().equals(Game.currentCard)) {
                    Game.garbage.push(Game.currentCard);
                    Game.currentCard = Game.garbage.peek();
                }
                current.setImageResource(android.R.color.transparent); //  Nothing in the current card is transparent
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


    public static void my_Handler(String owner, int index, final String cardName, final int mydelay) {
        System.out.println("in the handler function");
        final Handler handler = new Handler();


//		final int delay = 1500; //milliseconds
//		final int delay1 = 3000; //milliseconds

        if (owner.equals("computer")) {
            if (index == 0) {
                handler.postDelayed(new Runnable() {
                    public void run() {
                        int imageId = getContext().getResources().getIdentifier(cardName, "drawable", getContext().getPackageName());
                        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                        computerCard1.setImageDrawable(myDrawable);
                    }
                }, mydelay);
                return;
            } else if (index == 1) {
                handler.postDelayed(new Runnable() {
                    public void run() {
                        int imageId = getContext().getResources().getIdentifier(cardName, "drawable", getContext().getPackageName());
                        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                        computerCard2.setImageDrawable(myDrawable);
                    }
                }, mydelay);
            } else if (index == 2) {
                handler.postDelayed(new Runnable() {
                    public void run() {
                        int imageId = getContext().getResources().getIdentifier(cardName, "drawable", getContext().getPackageName());
                        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                        computerCard3.setImageDrawable(myDrawable);
                        System.out.println("computer[3] is peeked");
                    }
                }, mydelay);

            } else if (index == 3) {
                handler.postDelayed(new Runnable() {
                    public void run() {
                        int imageId = getContext().getResources().getIdentifier(cardName, "drawable", getContext().getPackageName());
                        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                        computerCard4.setImageDrawable(myDrawable);
                    }
                }, mydelay);
            }
        } else if (owner.equals("player")) {
            if (index == 0) {
                handler.postDelayed(new Runnable() {
                    public void run() {
                        int imageId = getContext().getResources().getIdentifier(cardName, "drawable", getContext().getPackageName());
                        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                        playerCard1.setImageDrawable(myDrawable);
                    }
                }, mydelay);
            } else if (index == 1) {
                handler.postDelayed(new Runnable() {
                    public void run() {
                        int imageId = getContext().getResources().getIdentifier(cardName, "drawable", getContext().getPackageName());
                        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                        playerCard2.setImageDrawable(myDrawable);
                    }
                }, mydelay);
            } else if (index == 2) {
                handler.postDelayed(new Runnable() {
                    public void run() {
                        int imageId = getContext().getResources().getIdentifier(cardName, "drawable", getContext().getPackageName());
                        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                        playerCard3.setImageDrawable(myDrawable);
                    }
                }, mydelay);
            } else if (index == 3) {
                handler.postDelayed(new Runnable() {
                    public void run() {
                        int imageId = getContext().getResources().getIdentifier(cardName, "drawable", getContext().getPackageName());
                        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                        playerCard4.setImageDrawable(myDrawable);
                    }
                }, mydelay);
            }
        } else {
            handler.postDelayed(new Runnable() {
                public void run() {
                    int imageIdDeck = getContext().getResources().getIdentifier(cardName, "drawable", getContext().getPackageName());
                    Drawable myDrawableDeck = getContext().getResources().getDrawable(imageIdDeck);
                    cardDeck.setImageDrawable(myDrawableDeck);
                }
            }, mydelay);

        }
    }
}



