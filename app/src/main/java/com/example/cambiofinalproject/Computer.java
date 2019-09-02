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

                        System.out.println("3");

                        // After 1.5 sec flip the card.
                        if (i == 0) {
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                    Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                    computerCard1.setImageDrawable(myDrawableBack);
                                    handler.postDelayed(this, delay);
                                }
                            }, delay);
                        } else if (i == 1) {
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                    Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                    computerCard2.setImageDrawable(myDrawableBack);
                                    handler.postDelayed(this, delay);
                                }
                            }, delay);
                        } else if (i == 2) {
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                    Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                    computerCard3.setImageDrawable(myDrawableBack);
                                    handler.postDelayed(this, delay);
                                }
                            }, delay);
                        } else if (i == 3) {
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                    Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                    computerCard4.setImageDrawable(myDrawableBack);
                                    handler.postDelayed(this, delay);
                                }
                            }, delay);

                        }

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

                        if (i == 0) {
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                    Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                    playerCard1.setImageDrawable(myDrawableBack);
                                    handler.postDelayed(this, delay);
                                }
                            }, delay);
                        } else if (i == 1) {
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                    Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                    playerCard2.setImageDrawable(myDrawableBack);
                                    handler.postDelayed(this, delay);
                                }
                            }, delay);
                        } else if (i == 2) {
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                    Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                    playerCard3.setImageDrawable(myDrawableBack);
                                    handler.postDelayed(this, delay);
                                }
                            }, delay);
                        } else if (i == 3) {
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                    Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                    playerCard4.setImageDrawable(myDrawableBack);
                                    handler.postDelayed(this, delay);
                                }
                            }, delay);

                        }
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
//				int c_imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
//				Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
                System.out.println("5");

                if (indexPlayer == 0)
                    playerCard1.setImageDrawable(myDrawableChosen);
                else if (indexPlayer == 1)
                    playerCard2.setImageDrawable(myDrawableChosen);
                else if (indexPlayer == 2)
                    playerCard3.setImageDrawable(myDrawableChosen);
                else if (indexPlayer == 3)
                    playerCard4.setImageDrawable(myDrawableChosen);
                System.out.println("6");
                if (indexComputer == 0)
                    computerCard1.setImageDrawable(myDrawableChosen);
                else if (indexComputer == 1)
                    computerCard2.setImageDrawable(myDrawableChosen);
                else if (indexComputer == 2)
                    computerCard3.setImageDrawable(myDrawableChosen);
                else if (indexComputer == 3)
                    computerCard4.setImageDrawable(myDrawableChosen);
                System.out.println("7");
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
                System.out.println("8");

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


                    int pe_imageId = getContext().getResources().getIdentifier("peekcard", "drawable", getContext().getPackageName());
                    Drawable pe_myDrawable = getContext().getResources().getDrawable(pe_imageId);
                    playerCard3.setImageDrawable(pe_myDrawable);


//                    int imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
//                    Drawable myDrawable = getContext().getResources().getDrawable(imageId);
//                    getGarbage().setImageDrawable(myDrawable);
//
//                    Game.garbage.push(Game.currentCard);
//                    Game.currentCard = Game.garbage.peek();
//
//                    break;
//                }
                    if (Player.playerCards[2].getValue() == 1 || Player.playerCards[2].getValue() == 2 || Player.playerCards[2].getValue() == 3
                            || Player.playerCards[2].getValue() == 13 && Player.playerCards[2].getColor().equals("red")) {

                        for (int j = 0; j < Computer.computerCards.length; j++) {
                            if (Computer.computerCards[j].getKnown() == false) {

                                Computer.computerCards[j].setKnown(true);

                                // peek and swap
//                            int pe_imageId = getContext().getResources().getIdentifier("peekcard", "drawable", getContext().getPackageName());
//                            Drawable pe_myDrawable = getContext().getResources().getDrawable(pe_imageId);
                                if (j == 0)
                                    computerCard1.setImageDrawable(pe_myDrawable);
                                else if (j == 1)
                                    computerCard2.setImageDrawable(pe_myDrawable);
                                else if (j == 2)
                                    computerCard3.setImageDrawable(pe_myDrawable);
                                else if (j == 3)
                                    computerCard4.setImageDrawable(pe_myDrawable);


                                if (Computer.computerCards[j].getValue() > Player.playerCards[2].getValue()) {
                                    //swap


                                    handler.postDelayed(new Runnable() {
                                        public void run() {
                                            int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                            Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                            playerCard3.setImageDrawable(myDrawableChosen);
                                            handler.postDelayed(this, delay);
                                        }
                                    }, delay);

                                    if (j == 0) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                                Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                                computerCard1.setImageDrawable(myDrawableChosen);
                                                handler.postDelayed(this, delay);
                                            }
                                        }, delay);
                                    } else if (j == 1) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                                Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                                computerCard2.setImageDrawable(myDrawableChosen);
                                                handler.postDelayed(this, delay);
                                            }
                                        }, delay);
                                    } else if (j == 2) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                                Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                                computerCard3.setImageDrawable(myDrawableChosen);
                                                handler.postDelayed(this, delay);
                                            }
                                        }, delay);
                                    } else if (j == 3) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                                Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                                computerCard4.setImageDrawable(myDrawableChosen);
                                                handler.postDelayed(this, delay);
                                            }
                                        }, delay);
                                    }

                                    handler.postDelayed(new Runnable() {
                                        public void run() {
                                            int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                            Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                            playerCard3.setImageDrawable(myDrawableBack);
                                            handler.postDelayed(this, delay1);
                                        }
                                    }, delay1);

                                    if (j == 0) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                                Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                                computerCard1.setImageDrawable(myDrawableBack);
                                                handler.postDelayed(this, delay1);
                                            }
                                        }, delay1);
                                    } else if (j == 1) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                                Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                                computerCard2.setImageDrawable(myDrawableBack);
                                                handler.postDelayed(this, delay1);
                                            }
                                        }, delay1);
                                    } else if (j == 2) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                                Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                                computerCard3.setImageDrawable(myDrawableBack);
                                                handler.postDelayed(this, delay1);
                                            }
                                        }, delay1);
                                    } else if (j == 3) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                                Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                                computerCard4.setImageDrawable(myDrawableBack);
                                                handler.postDelayed(this, delay1);
                                            }
                                        }, delay1);
                                    }


                                    //the real swap
                                    Card temp = Computer.computerCards[j];
                                    Computer.computerCards[j] = Player.playerCards[2];
                                    Player.playerCards[2] = temp;
                                    Computer.computerMemory.add(new CardLocation(Player.playerCards[2], 2, "player"));
                                    Computer.computerMemory.add(new CardLocation(Computer.computerCards[j], j, "computer"));
                                    break;
                                } else {
                                    // dont make the swap

                                    playerCard3.setImageDrawable(myDrawableBack);
                                    if (j == 0)
                                        computerCard1.setImageDrawable(myDrawableBack);
                                    else if (j == 1)
                                        computerCard2.setImageDrawable(myDrawableBack);
                                    else if (j == 2)
                                        computerCard3.setImageDrawable(myDrawableBack);
                                    else if (j == 3)
                                        computerCard4.setImageDrawable(myDrawableBack);

                                    Computer.computerMemory.add(new CardLocation(Player.playerCards[2], 2, "player"));
                                    Computer.computerMemory.add(new CardLocation(Computer.computerCards[j], j, "computer"));
                                    Player.playerCards[2].setKnown(true);
                                    Computer.computerCards[j].setKnown(true);

                                    break;

                                }
//                                //throw the black king to the garbage
//                                int imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
//                                Drawable myDrawable = getContext().getResources().getDrawable(imageId);
//                                getGarbage().setImageDrawable(myDrawable);
//
//                                Game.garbage.push(Game.currentCard);
//                                Game.currentCard = Game.garbage.peek();


                            } else {
                                System.out.println("the card is known- continue to the next card");
                                computerKnownCard++;
                            }
                        }
                        if (computerKnownCard == 4) { // if I peek to the player good card and I know all my cards. I will swap with my high card/
                            for (int j = 0; j < computerCards.length; j++) {
                                if (Computer.computerCards[j].getValue() > highValue) {
                                    highValue = Computer.computerCards[j].getValue();
                                    indexComputer = j;
                                }
                            }
                            //swap
//                            int pe_imageId = getContext().getResources().getIdentifier("peekcard", "drawable", getContext().getPackageName());
//                            Drawable pe_myDrawable = getContext().getResources().getDrawable(pe_imageId);

                            if (indexComputer == 0)
                                computerCard1.setImageDrawable(pe_myDrawable);
                            else if (indexComputer == 1)
                                computerCard2.setImageDrawable(pe_myDrawable);
                            else if (indexComputer == 2)
                                computerCard3.setImageDrawable(pe_myDrawable);
                            else if (indexComputer == 3)
                                computerCard4.setImageDrawable(pe_myDrawable);

                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                    Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                    playerCard3.setImageDrawable(myDrawableChosen);
                                    handler.postDelayed(this, delay);
                                }
                            }, delay);

                            if (indexComputer == 0) {
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                        Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                        computerCard1.setImageDrawable(myDrawableChosen);
                                        handler.postDelayed(this, delay);
                                    }
                                }, delay);
                            } else if (indexComputer == 1) {
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                        Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                        computerCard2.setImageDrawable(myDrawableChosen);
                                        handler.postDelayed(this, delay);
                                    }
                                }, delay);
                            } else if (indexComputer == 2) {
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                        Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                        computerCard3.setImageDrawable(myDrawableChosen);
                                        handler.postDelayed(this, delay);
                                    }
                                }, delay);
                            } else if (indexComputer == 3) {
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                        Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                        computerCard4.setImageDrawable(myDrawableChosen);
                                        handler.postDelayed(this, delay);
                                    }
                                }, delay);
                            }

                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                    Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                    playerCard3.setImageDrawable(myDrawableBack);
                                    handler.postDelayed(this, delay1);
                                }
                            }, delay1);

                            if (indexComputer == 0) {
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                        Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                        computerCard1.setImageDrawable(myDrawableBack);
                                        handler.postDelayed(this, delay1);
                                    }
                                }, delay1);
                            } else if (indexComputer == 1) {
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                        Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                        computerCard2.setImageDrawable(myDrawableBack);
                                        handler.postDelayed(this, delay1);
                                    }
                                }, delay1);
                            } else if (indexComputer == 2) {
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                        Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                        computerCard3.setImageDrawable(myDrawableBack);
                                        handler.postDelayed(this, delay1);
                                    }
                                }, delay1);
                            } else if (indexComputer == 3) {
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                        Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                        computerCard4.setImageDrawable(myDrawableBack);
                                        handler.postDelayed(this, delay1);
                                    }
                                }, delay1);
                            }


                            // the real swap
                            Card temp = Computer.computerCards[indexComputer];
                            Computer.computerCards[indexComputer] = Player.playerCards[2];
                            Player.playerCards[2] = temp;

                            Computer.computerMemory.add(new CardLocation(Player.playerCards[2], 2, "player"));
                            Computer.computerMemory.add(new CardLocation(Computer.computerCards[indexComputer], indexComputer, "computer"));


                        }
                    } else {// the card of the player are not very good
                        for (int j = 0; j < Computer.computerCards.length; j++) {
                            if (Computer.computerCards[j].getKnown() == true) {
                                if (Computer.computerCards[j].getValue() - Player.playerCards[2].getValue() >= 4) {
                                    // peek and swap
//                            int pe_imageId = getContext().getResources().getIdentifier("peekcard", "drawable", getContext().getPackageName());
//                            Drawable pe_myDrawable = getContext().getResources().getDrawable(pe_imageId);

                                    computerKnownCard++;

                                    if (j == 0)
                                        computerCard1.setImageDrawable(pe_myDrawable);
                                    else if (j == 1)
                                        computerCard2.setImageDrawable(pe_myDrawable);
                                    else if (j == 2)
                                        computerCard3.setImageDrawable(pe_myDrawable);
                                    else if (j == 3)
                                        computerCard4.setImageDrawable(pe_myDrawable);

                                    handler.postDelayed(new Runnable() {
                                        public void run() {
                                            int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                            Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                            playerCard3.setImageDrawable(myDrawableChosen);
                                            handler.postDelayed(this, delay);
                                        }
                                    }, delay);

                                    if (j == 0) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                                Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                                computerCard1.setImageDrawable(myDrawableChosen);
                                                handler.postDelayed(this, delay);
                                            }
                                        }, delay);
                                    } else if (j == 1) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                                Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                                computerCard2.setImageDrawable(myDrawableChosen);
                                                handler.postDelayed(this, delay);
                                            }
                                        }, delay);
                                    } else if (j == 2) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                                Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                                computerCard3.setImageDrawable(myDrawableChosen);
                                                handler.postDelayed(this, delay);
                                            }
                                        }, delay);
                                    } else if (j == 3) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                                Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                                computerCard4.setImageDrawable(myDrawableChosen);
                                                handler.postDelayed(this, delay);
                                            }
                                        }, delay);
                                    }

                                    handler.postDelayed(new Runnable() {
                                        public void run() {
                                            int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                            Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                            playerCard3.setImageDrawable(myDrawableBack);
                                            handler.postDelayed(this, delay1);
                                        }
                                    }, delay1);

                                    if (j == 0) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                                Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                                computerCard1.setImageDrawable(myDrawableBack);
                                                handler.postDelayed(this, delay1);
                                            }
                                        }, delay1);
                                    } else if (j == 1) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                                Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                                computerCard2.setImageDrawable(myDrawableBack);
                                                handler.postDelayed(this, delay1);
                                            }
                                        }, delay1);
                                    } else if (j == 2) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                                Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                                computerCard3.setImageDrawable(myDrawableBack);
                                                handler.postDelayed(this, delay1);
                                            }
                                        }, delay1);
                                    } else if (j == 3) {
                                        handler.postDelayed(new Runnable() {
                                            public void run() {
                                                int imageIdBack = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                                Drawable myDrawableBack = getContext().getResources().getDrawable(imageIdBack);
                                                computerCard4.setImageDrawable(myDrawableBack);
                                                handler.postDelayed(this, delay1);
                                            }
                                        }, delay1);
                                    }


                                    // the real swap
                                    Card temp = Computer.computerCards[j];
                                    Computer.computerCards[j] = Player.playerCards[2];
                                    Player.playerCards[2] = temp;

                                    Computer.computerMemory.add(new CardLocation(Player.playerCards[2], 2, "player"));
                                    Computer.computerMemory.add(new CardLocation(Computer.computerCards[j], j, "computer"));
                                    break;

                                    
                                }else{
                                    System.out.println("else - the difference < 4");
                                    computerKnownCard++;
                                }
                            }else if (computerKnownCard == 3) { //this is the last card in the computer cards. the card is unknown. I want to peek and maybe replace.



                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        int imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                        Drawable myDrawableBack = getContext().getResources().getDrawable(imageId);
                                        playerCard3.setImageDrawable(myDrawableBack);
                                        handler.postDelayed(this, delay1);
                                    }
                                }, delay1);


                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        int imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                        Drawable myDrawableBack = getContext().getResources().getDrawable(imageId);
                                        computerCard4.setImageDrawable(myDrawableBack);
                                        handler.postDelayed(this, delay1);
                                    }
                                }, delay1);
                                computerCard4.setImageDrawable(pe_myDrawable);

                                if(Computer.computerCards[4].getValue() != Player.playerCards[3].getValue()) {

                                    handler.postDelayed(new Runnable() {
                                        public void run() {
                                            int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                            Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                            playerCard3.setImageDrawable(myDrawableChosen);
                                            handler.postDelayed(this, delay);
                                        }
                                    }, delay);


                                    handler.postDelayed(new Runnable() {
                                        public void run() {
                                            int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                                            Drawable myDrawableChosen = getContext().getResources().getDrawable(imageId);
                                            computerCard4.setImageDrawable(myDrawableChosen);
                                            handler.postDelayed(this, delay);
                                        }
                                    }, delay);

                                    handler.postDelayed(new Runnable() {
                                        public void run() {
                                            int imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                            Drawable myDrawableBack = getContext().getResources().getDrawable(imageId);
                                            playerCard3.setImageDrawable(myDrawableBack);
                                            handler.postDelayed(this, delay1);
                                        }
                                    }, delay1);


                                    handler.postDelayed(new Runnable() {
                                        public void run() {
                                            int imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                            Drawable myDrawableBack = getContext().getResources().getDrawable(imageId);
                                            computerCard4.setImageDrawable(myDrawableBack);
                                            handler.postDelayed(this, delay1);
                                        }
                                    }, delay1);

                                }else{

                                    playerCard3.setImageDrawable(pe_myDrawable);
                                    computerCard4.setImageDrawable(pe_myDrawable);

                                    handler.postDelayed(new Runnable() {
                                        public void run() {
                                            int imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                            Drawable myDrawableBack = getContext().getResources().getDrawable(imageId);
                                            playerCard3.setImageDrawable(myDrawableBack);
                                            handler.postDelayed(this, delay);
                                        }
                                    }, delay);


                                    handler.postDelayed(new Runnable() {
                                        public void run() {
                                            int imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                            Drawable myDrawableBack = getContext().getResources().getDrawable(imageId);
                                            computerCard4.setImageDrawable(myDrawableBack);
                                            handler.postDelayed(this, delay);
                                        }
                                    }, delay);

                                    Computer.computerMemory.add(new CardLocation(Player.playerCards[2], 2, "player"));
                                    Computer.computerMemory.add(new CardLocation(Computer.computerCards[4], 4, "computer"));

                                }
                            }
                        }
                    }


//                for (int j = 0; j < Computer.computerCards.length; j++) {
////                        if (Computer.computerCards[j].getValue() == 10
////                                || Computer.computerCards[j].getValue() == 11
////                                || Computer.computerCards[j].getValue() == 12
////                                || Computer.computerCards[j].getValue() == 13 && Computer.computerCards[j].getColor().equals("black")) {
////                                // swap between player card and one of the bad computer card
//////                            if (ConfigurationValue.after(Player.playerCards[i], j) < minPlayerSwap) {
//////                                minPlayerSwap = ConfigurationValue.after(Player.playerCards[i], j);
//////                                indexPlayer = i;
//////                                indexComputer = j;
//////                            }
////                        }else {
////                            //swap between unknown computer card and unknown player card
////                        }
//                    }

                    for (int i = 0; i < Player.playerCards.length; i++) {
                        if (Player.playerCards[i].getKnown() == true) {
                            if (Player.playerCards[i].getValue() == 1
                                    || Player.playerCards[i].getValue() == 2
                                    || Player.playerCards[i].getValue() == 13 && Player.playerCards[i].getColor().equals("red")) { //the player have the smallest value of cards (ace or red king)
                                for (int j = 0; j < Computer.computerCards.length; j++) {
                                    if (Computer.computerCards[j].getKnown() == true) {
                                        if (Computer.computerCards[j].getValue() == 10
                                                || Computer.computerCards[j].getValue() == 11
                                                || Computer.computerCards[j].getValue() == 12
                                                || Computer.computerCards[j].getValue() == 13 && Computer.computerCards[j].getColor().equals("black")) {
                                            //peek and swap between the good cards and the bad cards
                                        } else {
                                            System.out.println("not 10 jack queen or black king - else - peek and swap with unknown card");
                                        }
                                    } else if (Computer.computerCards[j].getKnown() == false) {
                                        //peek and swap between the good cards and the cards that I don't know

                                    }
                                }
                            }
                        } else {

                        }
                    }

                    System.out.println("the value in the current is black king");
                    Game.garbage.push(Game.currentCard);
                    Game.currentCard = Game.garbage.peek();

                } else {
                    System.out.println("Other card - the value in the current 1-6");
                    for (int i = 0; i < computerCards.length; i++) {

                        System.out.println("the card is " + computerCards[i]);
                        System.out.println("computerCards[i].getKnown() = " + computerCards[i].getKnown() + " && (computerCards[i].getValue() - Game.currentCard.getValue()) = " + (computerCards[i].getValue() - Game.currentCard.getValue()));

                        if ((computerCards[i].getKnown() == true) && (computerCards[i].getValue() > Game.currentCard.getValue())) {
                            System.out.println("if((computerCards[i].getKnown() == true ) && (computerCards[i].getValue() > Game.currentCard.getValue())");

                            int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                            Drawable myDrawable = getContext().getResources().getDrawable(imageId);


                            cardDeck.setImageDrawable(myDrawableCDeck);

                            if (i == 0) {
                                computerCard1.setImageDrawable(myDrawable);
                            } else if (i == 1) {
                                computerCard2.setImageDrawable(myDrawable);
                            } else if (i == 2) {
                                computerCard3.setImageDrawable(myDrawable);
                            } else if (i == 3) {
                                computerCard4.setImageDrawable(myDrawable);
                            }

                            if (i == 0) {
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                        Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
                                        computerCard1.setImageDrawable(i_myDrawable);

                                        int imageIdDeck = getContext().getResources().getIdentifier("backdeck", "drawable", getContext().getPackageName());
                                        Drawable myDrawableDeck = getContext().getResources().getDrawable(imageIdDeck);
                                        cardDeck.setImageDrawable(myDrawableDeck);

                                        handler.postDelayed(this, delay);
                                    }
                                }, delay);
                            } else if (i == 1) {
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                        Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
                                        computerCard2.setImageDrawable(i_myDrawable);

                                        int imageIdDeck = getContext().getResources().getIdentifier("backdeck", "drawable", getContext().getPackageName());
                                        Drawable myDrawableDeck = getContext().getResources().getDrawable(imageIdDeck);
                                        cardDeck.setImageDrawable(myDrawableDeck);

                                        handler.postDelayed(this, delay);
                                    }
                                }, delay);
                            } else if (i == 2) {
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                        Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
                                        computerCard3.setImageDrawable(i_myDrawable);

                                        int imageIdDeck = getContext().getResources().getIdentifier("backdeck", "drawable", getContext().getPackageName());
                                        Drawable myDrawableDeck = getContext().getResources().getDrawable(imageIdDeck);
                                        cardDeck.setImageDrawable(myDrawableDeck);

                                        handler.postDelayed(this, delay);
                                    }
                                }, delay);
                            } else if (i == 3) {
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        int c_imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                                        Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
                                        computerCard4.setImageDrawable(i_myDrawable);

                                        int imageIdDeck = getContext().getResources().getIdentifier("backdeck", "drawable", getContext().getPackageName());
                                        Drawable myDrawableDeck = getContext().getResources().getDrawable(imageIdDeck);
                                        cardDeck.setImageDrawable(myDrawableDeck);

                                        handler.postDelayed(this, delay);
                                    }
                                }, delay);
                            }
                            System.out.println("the i is: " + i);

                            int cimageId = getContext().getResources().getIdentifier(Computer.computerCards[i].toString(), "drawable", getContext().getPackageName());
                            Drawable cmyDrawable = getContext().getResources().getDrawable(cimageId);
                            getGarbage().setImageDrawable(cmyDrawable);

                            System.out.println("current card before swap: " + Game.currentCard);
                            System.out.println("computer card before swap: " + Computer.computerCards[i]);
                            Card temp = Computer.computerCards[i];
                            Computer.computerCards[i] = Game.currentCard;
//						Game.garbage.push(temp);
                            Game.currentCard = Game.garbage.peek();

                            System.out.println("current card after swap: " + Game.currentCard);
                            System.out.println("computer card after swap: " + Computer.computerCards[i]);

                            current.setImageResource(android.R.color.transparent); //  Nothing in the current card is transparent

                            break;
                        } else {
                            System.out.println("there are no significant card");
                            cardDeck.setImageDrawable(myDrawableCDeck);
                            handler.postDelayed(new Runnable() {
                                public void run() {

                                    int imageIdDeck = getContext().getResources().getIdentifier("backdeck", "drawable", getContext().getPackageName());
                                    Drawable myDrawableDeck = getContext().getResources().getDrawable(imageIdDeck);
                                    cardDeck.setImageDrawable(myDrawableDeck);

                                    handler.postDelayed(this, delay);
                                }
                            }, delay);
                        }
                    }

                    int c_imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
                    Drawable i_myDrawable = getContext().getResources().getDrawable(c_imageId);
                    getGarbage().setImageDrawable(i_myDrawable);


                    Game.garbage.push(Game.currentCard);
                    Game.currentCard = Game.garbage.peek();

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
    }
}

