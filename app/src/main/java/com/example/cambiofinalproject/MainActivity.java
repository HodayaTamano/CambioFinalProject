package com.example.cambiofinalproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.Arrays;

//import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    static ImageButton computerCard1;
    static ImageButton computerCard2;
    static ImageButton computerCard3;
    static ImageButton computerCard4;

    static ImageButton playerCard1;
    static ImageButton playerCard2;
    static ImageButton playerCard3;
    static ImageButton playerCard4;

    static ImageButton cardDeck;
    static ImageButton current;
    static ImageButton garbage;

    static Button swap;
    static Button endTurn;
    static Button cambio;
    static Button levels;

    public static int [] counters = new int [8]; // array counters for computer (0-3) and player (4-7) cards.
    public static boolean [] c_shortFlags = new boolean[4]; // array flags for computer cards (0-3).
    public static boolean [] p_shortFlags = new boolean[4]; // array flags for player cards (4-7).
    public static boolean [] c_longFlags = new boolean[4]; // array flags for computer cards (0-3).
    public static boolean [] p_longFlags = new boolean[4]; // array flags for player cards (4-7).
    public static boolean currentFlag = true;
    public static boolean garbageFlag = true;
    public static boolean cardDeckFlag = true;



    public static boolean peek_playerCard12 = true;
    public static boolean peek_playerCard34 = false;
    public static boolean swap_playerCards = false;
    public static boolean peek_computerCard = false;   //short press on the computer cards.
    public static boolean swap_computerCards = false;

    public static boolean start = true;



    // In order to use non-static function in static function,
    // we saved the context to a static field, and we created a static methods that returns this field.
    private static WeakReference<Context> mContext;
    private static WeakReference<ImageButton> mGarbage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Game.start();

        swap = (Button) findViewById(R.id.swap);
        endTurn = (Button) findViewById(R.id.endTurn);
        cambio = (Button) findViewById(R.id.cambio);

        current = (ImageButton) findViewById(R.id.currentCard);
        garbage = (ImageButton) findViewById(R.id.garbage);

        mContext = new WeakReference<Context>(this);
        mGarbage = new WeakReference<ImageButton>(garbage);

        computerCard1 = (ImageButton) findViewById(R.id.computerCard1);
        computerCard2 = (ImageButton) findViewById(R.id.computerCard2);
        computerCard3 = (ImageButton) findViewById(R.id.computerCard3);
        computerCard4 = (ImageButton) findViewById(R.id.computerCard4);

        playerCard1 = (ImageButton) findViewById(R.id.playerCard1);
        playerCard2 = (ImageButton) findViewById(R.id.playerCard2);
        playerCard3 = (ImageButton) findViewById(R.id.playerCard3);
        playerCard4 = (ImageButton) findViewById(R.id.playerCard4);

        Arrays.fill(c_shortFlags,0,4,true); // computer flags for short press
        Arrays.fill(p_shortFlags,0,4,true); // player flags for short press

        levels = (Button) findViewById(R.id.levels);

///////////////////////////////////////////////// Computer Cards ////////////////////////////////////////////////////////////

        ////////////////////////     Computer Card No.1     //////////////////////
        computerCard1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if ((peek_computerCard == true) && (swap_computerCards == true)) { // black king allows peeking and swaping
                    c_shortFlags[0] = peekYourCard(Computer.computerCards[0].toString(), computerCard1, 0);
                } else if ((peek_computerCard == true) && (swap_computerCards == false)) { // 9 10 allows peeking
                    c_shortFlags[0] = peekYourCard(Computer.computerCards[0].toString(), computerCard1, 0);
                } else if ((peek_computerCard == false) && (swap_computerCards == true)) { // jack queen allows swaping
                    // the player can't peek the computer cards
                } else if ((peek_computerCard == false) && (swap_computerCards == false)) {
                    // the player can't peek and swap the computer cards
                }
            }
        });


        computerCard1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if ((peek_computerCard == true) && (swap_computerCards == true)) { // black king
                    chooseYourCard(0,computerCard1);
                    System.out.println("you click long press, (peek_computerCard == true) && swap_computerCards == true");
                   // Toast.makeText(MainActivity.this, "you click long press, (peek_computerCard == true) && swap_computerCards == true", Toast.LENGTH_SHORT).show();
                }else if ((peek_computerCard == false) && (swap_computerCards == true)){ // queen and jack
                    chooseYourCard(0,computerCard1);
                  //  Toast.makeText(MainActivity.this, "you click long press,(peek_computerCard == false) && swap_computerCards == true", Toast.LENGTH_SHORT).show();
                }else if ((peek_computerCard == true) && (swap_computerCards == false)) { // 9 and 10
//                    System.out.println("you click long press, peek_computerCard == true && swap_computerCards == false");
                   // Toast.makeText(MainActivity.this, "you click long press, peek_computerCard == true && swap_computerCards == false", Toast.LENGTH_SHORT).show();
                }else if ((peek_computerCard == false) && (swap_computerCards == false)) { // other card (including 7 and 8)
//                    Toast.makeText(MainActivity.this, "you click long press, peek_computerCard == false && swap_computerCards == false", Toast.LENGTH_SHORT).show();
                }

                    return true;
                }
        });

        ////////////////////////     Computer Card No.2     //////////////////////

        computerCard2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {     //

                if ((peek_computerCard == true) && (swap_computerCards == true)) {
                    c_shortFlags[1] = peekYourCard(Computer.computerCards[1].toString(), computerCard2, 1);
                } else if ((peek_computerCard == true) && (swap_computerCards == false)) {
                    c_shortFlags[1] = peekYourCard(Computer.computerCards[1].toString(), computerCard2, 1);
                } else if ((peek_computerCard == false) && (swap_computerCards == true)) {

                } else if ((peek_computerCard == false) && (swap_computerCards == false)) {

                }
            }
        });

        computerCard2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if ((peek_computerCard == true) && (swap_computerCards == true)) { // black king
                    chooseYourCard(1,computerCard2);
                   // Toast.makeText(MainActivity.this, "you click long press, (peek_computerCard == true) && swap_computerCards == true", Toast.LENGTH_SHORT).show();
                }else if ((peek_computerCard == false) && (swap_computerCards == true)){ // queen and jack
                    chooseYourCard(1,computerCard2);
                   // Toast.makeText(MainActivity.this, "you click long press,(peek_computerCard == false) && swap_computerCards == true", Toast.LENGTH_SHORT).show();
                }else if ((peek_computerCard == true) && (swap_computerCards == false)) { // 9 and 10
//                    Toast.makeText(MainActivity.this, "you click long press, peek_computerCard == true && swap_computerCards == false", Toast.LENGTH_SHORT).show();
                }else if ((peek_computerCard == false) && (swap_computerCards == false)) { // other card (including 7 and 8)
//                    Toast.makeText(MainActivity.this, "you click long press, peek_computerCard == false && swap_computerCards == false", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });

        ////////////////////////     Computer Card No.3     //////////////////////

        computerCard3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {     //

                if ((peek_computerCard == true) && (swap_computerCards == true)) {
                    c_shortFlags[2] = peekYourCard(Computer.computerCards[2].toString(), computerCard3, 2);
                } else if ((peek_computerCard == true) && (swap_computerCards == false)) {
                    c_shortFlags[2] = peekYourCard(Computer.computerCards[2].toString(), computerCard3, 2);
                } else if ((peek_computerCard == false) && (swap_computerCards == true)) {

                } else if ((peek_computerCard == false) && (swap_computerCards == false)) {

                }
            }
        });

        computerCard3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if ((peek_computerCard == true) && (swap_computerCards == true)) { // black king
                    chooseYourCard(2,computerCard3);
//                    Toast.makeText(MainActivity.this, "you click long press, (peek_computerCard == true) && swap_computerCards == true", Toast.LENGTH_SHORT).show();
                }else if ((peek_computerCard == false) && (swap_computerCards == true)){ // queen and jack
                    chooseYourCard(2,computerCard3);
//                    Toast.makeText(MainActivity.this, "you click long press,(peek_computerCard == false) && swap_computerCards == true", Toast.LENGTH_SHORT).show();
                }else if ((peek_computerCard == true) && (swap_computerCards == false)) { // 9 and 10
//                    Toast.makeText(MainActivity.this, "you click long press, peek_computerCard == true && swap_computerCards == false", Toast.LENGTH_SHORT).show();
                }else if ((peek_computerCard == false) && (swap_computerCards == false)) { // other card (including 7 and 8)
//                    Toast.makeText(MainActivity.this, "you click long press, peek_computerCard == false && swap_computerCards == false", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });

        ////////////////////////     Computer Card No.4     //////////////////////

        computerCard4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {     //

                if ((peek_computerCard == true) && (swap_computerCards == true)) {
                    c_shortFlags[3] = peekYourCard(Computer.computerCards[3].toString(), computerCard4, 3);
                } else if ((peek_computerCard == true) && (swap_computerCards == false)) {
                    c_shortFlags[3] = peekYourCard(Computer.computerCards[3].toString(), computerCard4, 3);
                } else if ((peek_computerCard == false) && (swap_computerCards == true)) {
//                    Toast.makeText(MainActivity.this, "(peek_computerCard == false) && (swap_computerCards == true)", Toast.LENGTH_SHORT).show();
                    System.out.println("(peek_computerCard == false) && (swap_computerCards == true)");
                } else if ((peek_computerCard == false) && (swap_computerCards == false)) {
//                    Toast.makeText(MainActivity.this, "(peek_computerCard == false) && (swap_computerCards == false)", Toast.LENGTH_SHORT).show();
                    System.out.println("(peek_computerCard == false) && (swap_computerCards == false)");
                }
            }
        });

        computerCard4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                System.out.println("peek_computerCard = "+peek_computerCard+"swap_computerCards = "+swap_computerCards);
                if ((peek_computerCard == true) && (swap_computerCards == true)) { // black king
                    chooseYourCard(3,computerCard4);
//                    Toast.makeText(MainActivity.this, "you click long press, (peek_computerCard == true) && swap_computerCards == true", Toast.LENGTH_SHORT).show();
                }else if ((peek_computerCard == false) && (swap_computerCards == true)){ // queen and jack
                    chooseYourCard(3,computerCard4);
//                    Toast.makeText(MainActivity.this, "you click long press,(peek_computerCard == false) && swap_computerCards == true", Toast.LENGTH_SHORT).show();
                }else if ((peek_computerCard == true) && (swap_computerCards == false)) { // 9 and 10
//                    Toast.makeText(MainActivity.this, "you click long press, peek_computerCard == true && swap_computerCards == false", Toast.LENGTH_SHORT).show();
                }else if ((peek_computerCard == false) && (swap_computerCards == false)) { // other card (including 7 and 8)
//                    Toast.makeText(MainActivity.this, "you click long press, peek_computerCard == false && swap_computerCards == false", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

///////////////////////////////////////////////// Player Cards ////////////////////////////////////////////////////////////

        ////////////////////////     Player Card No.1     //////////////////////

        playerCard1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((swap_playerCards == true) && (peek_playerCard12 == true)) { // black king allows peeking and swaping
                    if (counters[4] < 2) {
                        p_shortFlags[0] = peekYourCard(Player.playerCards[0].toString(), playerCard1, 4);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek this card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == false) && (peek_playerCard12 == true)) {// 7 8 allows peeking
                    if (counters[4] < 2) {
                        p_shortFlags[0] = peekYourCard(Player.playerCards[0].toString(), playerCard1, 4);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek this card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == true) && (peek_playerCard12 == false)) {// jack queen allows swaping
                    // the player can't peek his cards
//                    Toast.makeText(MainActivity.this, "(swap_playerCards == true) && (peek_playerCard12 == false)", Toast.LENGTH_SHORT).show();
                    System.out.println("(swap_playerCards == true) && (peek_playerCard12 == false)");

                } else if ((swap_playerCards == false) && (peek_playerCard12 == false)) {
                    // the player can't peek and swap his cards
//                    Toast.makeText(MainActivity.this, "(swap_playerCards == false) && (peek_playerCard12 == false)", Toast.LENGTH_SHORT).show();
                    System.out.println("(swap_playerCards == false) && (peek_playerCard12 == false)");
                }
            }
        });

        playerCard1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if ((peek_playerCard12 == true) && (swap_playerCards == true)) { // black king
                    chooseYourCard(4,playerCard1);
//                    Toast.makeText(MainActivity.this, "you click long press, (peek_computerCard == true) && swap_computerCards == true", Toast.LENGTH_SHORT).show();
                }else if ((peek_playerCard12 == false) && (swap_playerCards == true)){ // queen and jack
                    chooseYourCard(4,playerCard1);
//                    Toast.makeText(MainActivity.this, "you click long press,(peek_computerCard == false) && swap_computerCards == true", Toast.LENGTH_SHORT).show();
                }else if ((peek_playerCard12 == true) && (swap_playerCards == false)) { // 7 and 8
//                    Toast.makeText(MainActivity.this, "you click long press, peek_computerCard == true && swap_computerCards == false", Toast.LENGTH_SHORT).show();
                }else if ((peek_playerCard12 == false) && (swap_playerCards == false)) { // other card (including 9 and 10)
//                    Toast.makeText(MainActivity.this, "you click long press, peek_computerCard == false && swap_computerCards == false", Toast.LENGTH_SHORT).show();
                }

                return true;
            }

        });

        ////////////////////////     Player Card No.2     //////////////////////

        playerCard2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((swap_playerCards == true) && (peek_playerCard12 == true)) {
                    if (counters[5] < 2) {
                        p_shortFlags[1] = peekYourCard(Player.playerCards[1].toString(), playerCard2, 5);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek this card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == false) && (peek_playerCard12 == true)) {
                    if (counters[5] < 2) {
                        p_shortFlags[1] = peekYourCard(Player.playerCards[1].toString(), playerCard2, 5);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek this card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == true) && (peek_playerCard12 == false)) {
                    System.out.println("(swap_playerCards == true) && (peek_playerCard12 == false)");

                } else if ((swap_playerCards == false) && (peek_playerCard12 == false)) {
                    System.out.println("(swap_playerCards == false) && (peek_playerCard12 == false)");
                }
            }
        });

        playerCard2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if ((peek_playerCard12 == true) && (swap_playerCards == true)) { // black king
                    chooseYourCard(5,playerCard2);
                }else if ((peek_playerCard12 == false) && (swap_playerCards == true)){ // queen and jack
                    chooseYourCard(5,playerCard2);
                }else if ((peek_playerCard12 == true) && (swap_playerCards == false)) { // 7 and 8
                }else if ((peek_playerCard12 == false) && (swap_playerCards == false)) { // other card (including 9 and 10)
                }


                return true;
            }

        });
        ////////////////////////     Player Card No.3     //////////////////////

        playerCard3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((swap_playerCards == true) && (peek_playerCard34 == true)) {
                    if (counters[6] < 2) {
                        p_shortFlags[2] = peekYourCard(Player.playerCards[2].toString(), playerCard3, 6);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == false) && (peek_playerCard34 == true)) {
                    if (counters[6] < 2) {
                        p_shortFlags[2] = peekYourCard(Player.playerCards[2].toString(), playerCard3, 6);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek this card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == true) && (peek_playerCard34 == false)) {
                  //  Toast.makeText(MainActivity.this, "(swap_playerCards == true) && (peek_playerCard34 == false)", Toast.LENGTH_SHORT).show();
                    System.out.println("(swap_playerCards == true) && (peek_playerCard34 == false)");

                } else if ((swap_playerCards == false) && (peek_playerCard34 == false)) {
                   // Toast.makeText(MainActivity.this, "(swap_playerCards == false) && (peek_playerCard34 == false)", Toast.LENGTH_SHORT).show();
                    System.out.println("(swap_playerCards == false) && (peek_playerCard34 == false)");

                }
            }
        });

        playerCard3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if ((peek_playerCard34 == true) && (swap_playerCards == true)) { // black king
                    chooseYourCard(6,playerCard3);
                }else if ((peek_playerCard34 == false) && (swap_playerCards == true)){ // queen and jack
                    chooseYourCard(6,playerCard3);
                }else if ((peek_playerCard34 == true) && (swap_playerCards == false)) { // 7 and 8
                }else if ((peek_playerCard34 == false) && (swap_playerCards == false)) { // other card (including 9 and 10)
                }

                return true;
            }

        });

        ////////////////////////     Player Card No.4     //////////////////////

        playerCard4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((swap_playerCards == true) && (peek_playerCard34 == true)) {
                    if (counters[7] < 2) {
                        p_shortFlags[3] = peekYourCard(Player.playerCards[3].toString(), playerCard4, 7);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek this card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == false) && (peek_playerCard34 == true)) {
                    if (counters[7] < 2) {
                        p_shortFlags[3] = peekYourCard(Player.playerCards[3].toString(), playerCard4, 7);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek this card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == true) && (peek_playerCard34 == false)) {
                 //   Toast.makeText(MainActivity.this, "(swap_playerCards == true) && (peek_playerCard34 == false)", Toast.LENGTH_SHORT).show();
                    System.out.println("(swap_playerCards == true) && (peek_playerCard34 == false)");

                } else if ((swap_playerCards == false) && (peek_playerCard34 == false)) {
                 //   Toast.makeText(MainActivity.this, "(swap_playerCards == false) && (peek_playerCard34 == false)", Toast.LENGTH_SHORT).show();
                    System.out.println("(swap_playerCards == false) && (peek_playerCard34 == false)");

                }
            }
        });

        playerCard4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if ((peek_playerCard34 == true) && (swap_playerCards == true)) { // black king
                    chooseYourCard(7 ,playerCard4);
                  //  Toast.makeText(MainActivity.this, "you click long press, (peek_computerCard == true) && swap_computerCards == true", Toast.LENGTH_SHORT).show();
                }else if ((peek_playerCard34 == false) && (swap_playerCards == true)){ // queen and jack
                    chooseYourCard(7 ,playerCard4);
                 //   Toast.makeText(MainActivity.this, "you click long press,(peek_computerCard == false) && swap_computerCards == true", Toast.LENGTH_SHORT).show();
                }else if ((peek_playerCard34 == true) && (swap_playerCards == false)) { // 7 and 8
                    System.out.println("you click long press, peek_computerCard == true && swap_computerCards == false");
                 //   Toast.makeText(MainActivity.this, "you click long press, peek_computerCard == true && swap_computerCards == false", Toast.LENGTH_SHORT).show();
                }else if ((peek_playerCard34 == false) && (swap_playerCards == false)) { // other card (including 9 and 10)
                    System.out.println("you click long press, peek_computerCard == false && swap_computerCards == false");
                 //   Toast.makeText(MainActivity.this, "you click long press, peek_computerCard == false && swap_computerCards == false", Toast.LENGTH_SHORT).show();
                }

                return true;
            }

        });


        cardDeck = (    ImageButton) findViewById(R.id.deck);
        cardDeck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                cardDeckFlag = false;
                if (start) {
                    if ((p_shortFlags[0] == true) && (p_shortFlags[1] == true)) {
                        if ((counters[4] == 0) && (counters[5] == 0))
                            Toast.makeText(MainActivity.this, "You didn't peek your cards", Toast.LENGTH_SHORT).show();
                        else if ((counters[4] == 0) && (counters[5] == 2))
                            Toast.makeText(MainActivity.this, "You peek only one card", Toast.LENGTH_SHORT).show();
                        else if ((counters[4] == 2) && (counters[5] == 0))
                            Toast.makeText(MainActivity.this, "You peek only one card", Toast.LENGTH_SHORT).show();
                        else {
                            System.out.println("cardDeck before theGame");
                            Game.setGameOn(true);
                            Game.theGame();
                            start = false;
                        }

                    } else {
                        if ((counters[4] == 0) && (counters[5] == 1))
                            Toast.makeText(MainActivity.this, "Your card is exposed", Toast.LENGTH_SHORT).show();
                        else if ((counters[4] == 1) && (counters[5] == 0))
                            Toast.makeText(MainActivity.this, "Your card is exposed", Toast.LENGTH_SHORT).show();
                        else if ((counters[4] == 1) && (counters[5] == 1))
                            Toast.makeText(MainActivity.this, "Your cards are exposed", Toast.LENGTH_SHORT).show();
                        else if ((counters[4] == 1) && (counters[5] == 2))
                            Toast.makeText(MainActivity.this, "Your card is exposed", Toast.LENGTH_SHORT).show();
                        else if ((counters[4] == 2) && (counters[5] == 1))
                            Toast.makeText(MainActivity.this, "Your card is exposed", Toast.LENGTH_SHORT).show();
                    }
                }else if(Game.gameOn == false){
                    Toast.makeText(MainActivity.this, "gameon = false", Toast.LENGTH_SHORT).show();
                }
                else if(Game.currentTurn == "computer"){
                    Toast.makeText(MainActivity.this, "now is the computer turn", Toast.LENGTH_SHORT).show();
                }
                else {
                    Game.currentTurn = "player";

//                    Game.theGame();

//                    System.out.println("The first in the deck: "+Card.cardDeck.get(0).toString());
//                    System.out.println("The current cardd: "+Game.currentCard);

                    int imageId = getContext().getResources().getIdentifier(Card.cardDeck.get(0).toString(), "drawable", getContext().getPackageName());
                    Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                    current.setImageDrawable(myDrawable);

//                    Game.currentCard = Card.cardDeck.get(0);
//                    Card.cardDeck.remove(0);
//                    System.out.println("The first in the deck: "+Card.cardDeck.get(0).toString());
//                    System.out.println("The current cardd: "+Game.currentCard);
                    playerTurn();
                }
            }

        });

        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int playerCardIndex = -1;
                int computerCardIndex = -1;


                for (int i = 0; i < p_longFlags.length; i++) {
                    if (p_longFlags[i] == false) {
                        playerCardIndex = i;   // if one of the player card are chosen.
                        break;
                    }
                    else playerCardIndex = -1;
                }

                for (int i = 0; i < c_longFlags.length; i++) {          // if one of the computer card are chosen.
                    if (c_longFlags[i] == false) {
                        computerCardIndex = i;
                        break;
                    } else if (!currentFlag){
                        computerCardIndex = -1;
                        System.out.println("computerCardIndex: "+computerCardIndex);
                    }
                    else if (!garbageFlag){
                        computerCardIndex = -2;
                        System.out.println("computerCardIndex: "+computerCardIndex);
                    }
                }

                if (computerCardIndex > -1 && playerCardIndex > -1 && !start) {
                    // swap between player card and computer card
                    System.out.println("swap between player card "+Player.playerCards[playerCardIndex]+" and computer card "+Computer.computerCards[computerCardIndex]);
                    if ((playerCardIndex == 0) && (computerCardIndex == 0)) {
                        swap(playerCardIndex, computerCardIndex, playerCard1, computerCard1);
                    } else if ((playerCardIndex == 0) && (computerCardIndex == 1)) {
                        swap(playerCardIndex, computerCardIndex, playerCard1, computerCard2);
                    } else if ((playerCardIndex == 0) && (computerCardIndex == 2)) {
                        swap(playerCardIndex, computerCardIndex, playerCard1, computerCard3);
                    } else if ((playerCardIndex == 0) && (computerCardIndex == 3)) {
                        swap(playerCardIndex, computerCardIndex, playerCard1, computerCard4);
                    } else if ((playerCardIndex == 1) && (computerCardIndex == 0)) {
                        swap(playerCardIndex, computerCardIndex, playerCard2, computerCard1);
                    } else if ((playerCardIndex == 1) && (computerCardIndex == 1)) {
                        swap(playerCardIndex, computerCardIndex, playerCard2, computerCard2);
                    } else if ((playerCardIndex == 1) && (computerCardIndex == 2)) {
                        swap(playerCardIndex, computerCardIndex, playerCard2, computerCard3);
                    } else if ((playerCardIndex == 1) && (computerCardIndex == 3)) {
                        swap(playerCardIndex, computerCardIndex, playerCard1, computerCard4);
                    } else if ((playerCardIndex == 2) && (computerCardIndex == 0)) {
                        swap(playerCardIndex, computerCardIndex, playerCard3, computerCard1);
                    } else if ((playerCardIndex == 2) && (computerCardIndex == 1)) {
                        swap(playerCardIndex, computerCardIndex, playerCard3, computerCard2);
                    } else if ((playerCardIndex == 2) && (computerCardIndex == 2)) {
                        swap(playerCardIndex, computerCardIndex, playerCard3, computerCard3);
                    } else if ((playerCardIndex == 2) && (computerCardIndex == 3)) {
                        swap(playerCardIndex, computerCardIndex, playerCard3, computerCard4);
                    } else if ((playerCardIndex == 3) && (computerCardIndex == 0)) {
                        swap(playerCardIndex, computerCardIndex, playerCard4, computerCard1);
                    } else if ((playerCardIndex == 3) && (computerCardIndex == 1)) {
                        swap(playerCardIndex, computerCardIndex, playerCard4, computerCard2);
                    } else if ((playerCardIndex == 3) && (computerCardIndex == 2)) {
                        swap(playerCardIndex, computerCardIndex, playerCard4, computerCard3);
                    } else if ((playerCardIndex == 3) && (computerCardIndex == 3)) {
                        swap(playerCardIndex, computerCardIndex, playerCard4, computerCard4);
                    }
//                    firstPress = false;
                }
                else if (playerCardIndex != -1 && computerCardIndex == -1) {
                    // swap between player card and current card
                    System.out.println("swap between player card "+Player.playerCards[playerCardIndex]+" and current card "+Game.currentCard);
                    if (playerCardIndex == 0) {
                        swap(playerCardIndex, -1, playerCard1, current);
                    }
                    if (playerCardIndex == 1) {
                        swap(playerCardIndex, -1, playerCard2, current);
                    }
                    if (playerCardIndex == 2) {
                        swap(playerCardIndex, -1, playerCard3, current);
                    }
                    if (playerCardIndex == 3) {
                        swap(playerCardIndex, -1, playerCard4, current);
                    }
//                    firstPress = false;
                }
                else if (playerCardIndex != -1 && computerCardIndex == -2){
                    // swap between player card and garbage card
                    System.out.println("swap between player card "+Player.playerCards[playerCardIndex]+" and garbage card "+Game.garbage.peek());
                    if (playerCardIndex == 0) {
                        swap(playerCardIndex, -2, playerCard1, garbage);
                    }
                    if (playerCardIndex == 1) {
                        swap(playerCardIndex, -2, playerCard2, garbage);
                    }
                    if (playerCardIndex == 2) {
                        swap(playerCardIndex, -2, playerCard3, garbage);
                    }
                    if (playerCardIndex == 3) {
                        swap(playerCardIndex, -2, playerCard4, garbage);
                    }
//                    firstPress = false;
                }
                else if (start) Toast.makeText(MainActivity.this, "You can't swap cards now - press on the deck", Toast.LENGTH_SHORT).show();

                else  Toast.makeText(MainActivity.this, "You didn't choose the cards you want to swap", Toast.LENGTH_SHORT).show();

                garbageFlag = true;
                currentFlag = true;
            }
        });

        current.setOnLongClickListener(new View.OnLongClickListener() { //The player wants to swap between one of his card and the current card.
            @Override
            public boolean onLongClick(View v) {

                if (currentFlag){
                    chooseYourCard(8, current);
                    currentFlag = false; //if the player choose the current card - change his flag to false
                    System.out.println("currentFlag = "+currentFlag);

                }
                else{
                    chooseYourCard(9, current);
                    currentFlag = true;
                    System.out.println("currentFlag = "+currentFlag);
                }
                return false;
            }
        });

        garbage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (garbageFlag && Game.currentCard == Game.garbage.peek()) {
                    chooseYourCard(10, garbage);
                    garbageFlag = false;
                    System.out.println("garbageFlag = "+garbageFlag);
                } else {
                    chooseYourCard(11, garbage);
                    garbageFlag = true;
                    System.out.println("garbageFlag = "+garbageFlag);
                }
                return false;
            }
        });


        endTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // After the player finished his turn it is the computer turn.
                int check = 16;

                for(int i= 0; i < c_shortFlags.length;i++) {
                    if (c_shortFlags[i] == false) {  //There is exposed card
                        check--;
                        Toast.makeText(MainActivity.this, "The computer card is exposed", Toast.LENGTH_SHORT).show();
                    } else if (p_shortFlags[i] == false) {  //There is exposed card
                        check--;
                        Toast.makeText(MainActivity.this, "Your card is exposed", Toast.LENGTH_SHORT).show();
                    } else if (c_longFlags[i] == false) {  //There is exposed card
                        check--;
                        Toast.makeText(MainActivity.this, "The computer card has chosen", Toast.LENGTH_SHORT).show();
                    } else if (p_longFlags[i] == false) {  //There is exposed card
                        check--;
                        Toast.makeText(MainActivity.this, "Your card has chosen", Toast.LENGTH_SHORT).show();
                    }
                }
                if(check == 16){
                    // Throw the current card into the garbage.
                        int c_imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
                        Drawable c_myDrawable = getContext().getResources().getDrawable(c_imageId);
                        garbage.setImageDrawable(c_myDrawable);

                    current.setImageResource(android.R.color.transparent); //  Nothing in the current card is transparent

                    Game.garbage.push(Game.currentCard);
                    Game.currentCard = Game.garbage.peek();
                    Game.currentTurn = "computer";

                    Computer.computerMemory.add(new CardLocation(Game.garbage.peek(), -1, "garbage"));
                    System.out.println("Garbage: "+Game.garbage);

                    final Handler handler = new Handler();
                    final int delay = 1500; //milliseconds

                    if(Game.cambio_computer == true){ // the last turn of the game
                        System.out.println("cambio_computer: "+ Game.cambio_computer);
                        Game.setGameOn(false);
                        Game.theGame();

                    }
                    else {
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                Game.theGame();
                            }
                        }, delay);
                    }
                }
            }
        });

        cambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if (Game.currentTurn.equals("")){
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                Toast.makeText(MainActivity.this, "You can't press cambio in the beginning of the game", Toast.LENGTH_SHORT).show();
            }
            if(cardDeckFlag == true && garbageFlag == true && Game.currentTurn.equals("player")){                Arrays.fill(counters,0,7,0); // player cards are available
                currentFlag = true;
                garbageFlag = true;
                cardDeckFlag = true;
                peek_playerCard12 = true;
                peek_playerCard34 = false;
                swap_playerCards = false;
                peek_computerCard = false;   //short press on the computer cards.
                swap_computerCards = false;
                start = true;

                Game.cambio_player = true;
                System.out.println("cambio_player button: "+ Game.cambio_player);

            }else{
                System.out.println("else");
            }
            }
        });



        levels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Levels.class));
                Intent myIntent = new Intent(MainActivity.this, Levels.class);
                startActivity(myIntent);

            }
        });
    }


    public static Context getContext() {
        return mContext.get();
    }
    public static ImageButton getGarbage() {
        return mGarbage.get();
    }

    public static void playerTurn() {


        System.out.println("playerTurn");
        Game.currentTurn = "player";
        System.out.println("cardDeckFlag = "+cardDeckFlag);
        if(start || !cardDeckFlag){
            System.out.println("cardDeck");
            int imageId = getContext().getResources().getIdentifier(Card.cardDeck.get(0).toString(), "drawable", getContext().getPackageName());
            Drawable myDrawable = getContext().getResources().getDrawable(imageId);
            current.setImageDrawable(myDrawable);
            Game.currentCard = Card.cardDeck.get(0);
            Card.cardDeck.remove(0);

        }else{
            System.out.println("garbage");
            Game.currentCard = Game.garbage.peek();
        }

        Arrays.fill(counters,0,7,0); // player cards are available

        Arrays.fill(c_longFlags,0,4,true); // computer flags for long press
        Arrays.fill(p_longFlags,0,4,true); // player flags for long press

        Arrays.fill(c_shortFlags,0,4,true); // computer flags for short press
        Arrays.fill(p_shortFlags,0,4,true); // player flags for short press

        if(!cardDeckFlag) {
            if ((Game.currentCard.toString().endsWith("7")) || (Game.currentCard.toString().endsWith("8"))) {
                System.out.println("playerTurn: card 7 or 8");
                Arrays.fill(counters, 4, 7, 0); // player cards are available
                Arrays.fill(counters, 0, 3, 2);// computer cards are unavailable
                peek_playerCard12 = true;
                peek_playerCard34 = true;
                peek_computerCard = false;
                swap_computerCards = false;
                swap_playerCards = true;
            } else if ((Game.currentCard.toString().endsWith("9")) || (Game.currentCard.toString().endsWith("10"))) {
                System.out.println("playerTurn: card 9 or 10");
                Arrays.fill(counters, 0, 7, 0); // all cards are available
                peek_playerCard12 = false;
                peek_playerCard34 = false;
                peek_computerCard = true;
                swap_computerCards = false;
                swap_playerCards = true;
            } else if ((Game.currentCard.toString().endsWith("jack")) || (Game.currentCard.toString().endsWith("queen"))) {
                System.out.println("playerTurn: card jack or queen");
                Arrays.fill(counters, 0, 7, 0); // all cards are available
                peek_playerCard12 = false;
                peek_playerCard34 = false;
                peek_computerCard = false;
                swap_computerCards = true;
                swap_playerCards = true;
            } else if ((Game.currentCard.toString().equals("spadesofking") || (Game.currentCard.toString().equals("clubsofking")))) {
                System.out.println("playerTurn: card black king");
                Arrays.fill(counters, 0, 7, 0); // all cards are available
                peek_playerCard12 = true;
                peek_playerCard34 = true;
                peek_computerCard = true;
                swap_computerCards = true;
                swap_playerCards = true;
            } else {
                System.out.println("playerTurn: other card");
                Arrays.fill(counters, 4, 7, 0); // player cards are available
                Arrays.fill(counters, 0, 3, 2); // computer cards are unavailable
                peek_playerCard12 = false;
                peek_playerCard34 = false;
                peek_computerCard = false;
                swap_computerCards = false;
                swap_playerCards = true;
            }
        }
        cardDeckFlag = true;


    }

    public static boolean flagIsFalse(int myIndex ,String press){

        boolean answer = true;
        if(press.equals("long")) {
            if (myIndex < 4)
                for (int i = 0; i < c_longFlags.length; i++)
                    if (c_longFlags[i]) answer = false;
                    else return true; // false is exist
            else
                for (int i = 0; i < p_longFlags.length; i++)
                    if (p_longFlags[i]) answer = false;
                    else return true; // false is exist
        }
        else if (press.equals("short")){
            if (myIndex < 4)
                for (int i = 0; i < c_shortFlags.length; i++)
                    if (c_shortFlags[i]) answer = false;
                    else return true; // false is exist
            else
                for (int i = 0; i < p_shortFlags.length; i++)
                    if (p_shortFlags[i]) answer = false;
                    else return true; // false is exist
        }
        return answer;
    }


    public static void swap (int playerIndex,int computerIndex, ImageButton playerButton, ImageButton otherButton) {


        if (computerIndex > -1 && playerIndex > -1) { // swap between player card and computer card
            System.out.println("swap function: swap between player card and computer card");
            int imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
            Drawable myDrawable = getContext().getResources().getDrawable(imageId);
            otherButton.setImageDrawable(myDrawable);
            playerButton.setImageDrawable(myDrawable);

            if(Computer.computerCards[computerIndex].getKnown() == true && Player.playerCards[playerIndex].getKnown() == true){//
                Computer.computerMemory.remove(new CardLocation(Player.playerCards[playerIndex], playerIndex, "player"));
                Computer.computerMemory.add(new CardLocation(Player.playerCards[playerIndex], computerIndex, "computer"));

                Computer.computerMemory.remove(new CardLocation(Computer.computerCards[computerIndex], computerIndex, "computer"));
                Computer.computerMemory.add(new CardLocation(Computer.computerCards[computerIndex], playerIndex, "player"));
            }
           else if(Computer.computerCards[computerIndex].getKnown() == true && Player.playerCards[playerIndex].getKnown() == false) {//
                Computer.computerMemory.remove(new CardLocation(Player.playerCards[playerIndex], playerIndex, "player"));
                Computer.computerMemory.add(new CardLocation(Player.playerCards[playerIndex], computerIndex, "computer"));
            }
            else if(Computer.computerCards[computerIndex].getKnown() == false && Player.playerCards[playerIndex].getKnown() == true) {//
                Computer.computerMemory.remove(new CardLocation(Computer.computerCards[computerIndex], computerIndex, "computer"));
                Computer.computerMemory.add(new CardLocation(Computer.computerCards[computerIndex], playerIndex, "player"));
            }


//  the real swap
            Card temp = Computer.computerCards[computerIndex];
            Computer.computerCards[computerIndex] = Player.playerCards[playerIndex];
            Player.playerCards[playerIndex] = temp;

            p_longFlags[playerIndex] = true;
            c_longFlags[computerIndex] = true;


        } else if (playerIndex != -1 && computerIndex == -1) {    // swap between player card and current card
            System.out.println("swap function: swap between player card and current card");
            System.out.println("playerIndex = "+ playerIndex);
            System.out.println("computerIndex = "+ computerIndex);

            int imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
            Drawable myDrawable = getContext().getResources().getDrawable(imageId);
            playerButton.setImageDrawable(myDrawable);

            int c_imageId = getContext().getResources().getIdentifier(Player.playerCards[playerIndex].toString(), "drawable", getContext().getPackageName());
            Drawable c_myDrawable = getContext().getResources().getDrawable(c_imageId);
            current.setImageDrawable(c_myDrawable);

            System.out.print("The computer cards before the swapping are: [");

            for (int i = 0; i < Computer.computerCards.length; i++) {
                System.out.print(Computer.computerCards[i] + " ");
            }
            System.out.print("]");
            System.out.print("The player cards before the swapping are: [");
            for (int i = 0; i < Computer.computerCards.length; i++) {
                System.out.print(Player.playerCards[i] + " ");
            }
            System.out.print("]");

            if(Player.playerCards[playerIndex].getKnown() == true) {//
                Computer.computerMemory.remove(new CardLocation(Player.playerCards[playerIndex], playerIndex, "player"));
                Player.playerCards[playerIndex].setKnown(false);
            }

//  the real swap
            Card temp = Player.playerCards[playerIndex];
            Player.playerCards[playerIndex] = Game.currentCard;
            Game.currentCard = temp;

            Player.playerCards[playerIndex].setKnown(false);//the computer doesn't know this card (the player took the card from the deck)

            p_longFlags[playerIndex] = true;
        }
        else if (playerIndex != -1 && computerIndex == -2){// swap between player card and garbage
            System.out.println("swap function: swap between player card and garbage card");
            int imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
            Drawable myDrawable = getContext().getResources().getDrawable(imageId);
            playerButton.setImageDrawable(myDrawable);

            int c_imageId = getContext().getResources().getIdentifier(Player.playerCards[playerIndex].toString(), "drawable", getContext().getPackageName());
            Drawable c_myDrawable = getContext().getResources().getDrawable(c_imageId);
            getGarbage().setImageDrawable(c_myDrawable);

            if(Player.playerCards[playerIndex].getKnown() == true) {//
                Computer.computerMemory.remove(new CardLocation(Player.playerCards[playerIndex], playerIndex, "player"));
                Computer.computerMemory.add(new CardLocation(Player.playerCards[playerIndex], -1, "garbage"));
                Computer.computerMemory.remove(new CardLocation(Game.garbage.peek(), -1, "garbage"));
                Computer.computerMemory.add(new CardLocation(Game.garbage.peek(), playerIndex, "player"));

                Player.playerCards[playerIndex].setKnown(true);
            }
            else if (Player.playerCards[playerIndex].getKnown() == false) {//
                Computer.computerMemory.add(new CardLocation(Player.playerCards[playerIndex], -1, "garbage"));
                Computer.computerMemory.remove(new CardLocation(Game.garbage.peek(), -1, "garbage"));
                Computer.computerMemory.add(new CardLocation(Game.garbage.peek(), playerIndex, "player"));
                Player.playerCards[playerIndex].setKnown(true);
            }


//  the real swap

            Card temp = Player.playerCards[playerIndex];
            Player.playerCards[playerIndex] = Game.garbage.pop();
            Game.garbage.push(temp);
            Game.currentCard = Game.garbage.peek();

            p_longFlags[playerIndex] = true;
        }
    }
    public static void chooseYourCard (int i, ImageButton button){

        if (i < 4){ // choosing one of the computer card
            if (c_longFlags[i] && !flagIsFalse(i ,"long")) {
                int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                button.setImageDrawable(myDrawable);
                c_longFlags[i] = false; // I choose the card

            }else{
                int imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                button.setImageDrawable(myDrawable);
                c_longFlags[i] = true;
            }
        } else if (i < 8){ // choosing one of the player card
            if (p_longFlags[i-4] && !flagIsFalse(i,"long")) {
                int imageId = getContext().getResources().getIdentifier("chosencard", "drawable", getContext().getPackageName());
                Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                button.setImageDrawable(myDrawable);
                p_longFlags[i-4] = false;

            }else{
                int imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                button.setImageDrawable(myDrawable);
                p_longFlags[i-4] = true;
            }
        } else if (i == 8){ // choosing the current card
            String chooseCurrent = "c"+Game.currentCard;
            int imageId = getContext().getResources().getIdentifier(chooseCurrent, "drawable", getContext().getPackageName());
            Drawable myDrawable = getContext().getResources().getDrawable(imageId);
            current.setImageDrawable(myDrawable);
        } else if (i == 9){ // player regret - don't want to choose current
            int imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
            Drawable myDrawable = getContext().getResources().getDrawable(imageId);
            current.setImageDrawable(myDrawable);
        } else if (i == 10){ // choosing the current card
            String chooseGarbage = "c"+Game.garbage.peek().toString();
            int imageId = getContext().getResources().getIdentifier(chooseGarbage, "drawable", getContext().getPackageName());
            Drawable myDrawable = getContext().getResources().getDrawable(imageId);
            garbage.setImageDrawable(myDrawable);
        } else if (i == 11){ // player regret - don't want to choose current
            int imageId = getContext().getResources().getIdentifier(Game.garbage.peek().toString(), "drawable", getContext().getPackageName());
            Drawable myDrawable = getContext().getResources().getDrawable(imageId);
            garbage.setImageDrawable(myDrawable);
        }
    }

    public static boolean peekYourCard(String cardName, ImageButton button, int i) {
        if (i < 4){
            if (c_shortFlags[i] && !flagIsFalse(i ,"short")) {  //to expose the card
                int imageId = getContext().getResources().getIdentifier(cardName, "drawable", getContext().getPackageName());
                Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                button.setImageDrawable(myDrawable);
                counters[i]++;
                return false;
            } else {                 //to hide the card
                int imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                button.setImageDrawable(myDrawable);
                counters[i]++;
                return true;
            }
        }
        else{
            if (p_shortFlags[i-4] && !flagIsFalse(i ,"short")) {  //The card is exposed
                int imageId = getContext().getResources().getIdentifier(cardName, "drawable", getContext().getPackageName());
                Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                button.setImageDrawable(myDrawable);
                counters[i]++;
                return false;
            } else {                 // The card is hidden
                int imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                button.setImageDrawable(myDrawable);
                counters[i]++;
                return true;
            }
        }
    }

}


