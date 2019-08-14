package com.example.cambiofinalproject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cambiofinalproject.Game;
import com.example.cambiofinalproject.R;

import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.Arrays;

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
    static Button swap;

    private static int [] counters = new int [8]; // array counters for computer (0-3) and player (4-7) cards.
    private static boolean [] c_shortFlags = new boolean[4]; // array flags for computer cards (0-3).
    private static boolean [] p_shortFlags = new boolean[4]; // array flags for player cards (4-7).
    private static boolean [] c_longFlags = new boolean[4]; // array flags for computer cards (0-3).
    private static boolean [] p_longFlags = new boolean[4]; // array flags for player cards (4-7).
    private static boolean currentFlag = true;



    private static boolean peek_computerCard = false;   //short press on the computer cards.
    private static boolean swap_computerCards = false;
    private static boolean peek_playerCard12 = true;
    private static boolean peek_playerCard34 = false;
    private static boolean swap_playerCards = false;

    private static boolean start = true;


    // In order to use non-static function in static function,
// we saved the context to a static field named mContext and mCurrent,
// and we created a static methods that returns this field getContext() and getmCurrent().
    private static WeakReference<Context> mContext;
//    private static WeakReference<ImageButton> mCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Game.start();

        swap= (Button) findViewById(R.id.swap);

        current = (ImageButton) findViewById(R.id.currentCard);
//        mCurrent = new WeakReference<ImageButton>(current);
        mContext = new WeakReference<Context>(this);

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

///////////////////////////////////////////////// Computer Cards ////////////////////////////////////////////////////////////

        ////////////////////////     Computer Card No.1     //////////////////////
        computerCard1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if ((peek_computerCard == true) && (swap_computerCards == true)) { // black king allows peeking and swaping
                    c_shortFlags[0] = shortPress(Computer.computerCards[0].toString(), computerCard1, 0);
                } else if ((peek_computerCard == true) && (swap_computerCards == false)) { // 9 10 allows peeking
                    c_shortFlags[0] = shortPress(Computer.computerCards[0].toString(), computerCard1, 0);
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
                    if ((peek_computerCard == true) || (swap_computerCards == true)) {// black king allows swaping
                        chooseYourCard(0,computerCard1);
                        Toast.makeText(MainActivity.this, "you click long press, swap_computerCards == true", Toast.LENGTH_SHORT).show();
                    }else if ((peek_computerCard == true) && (swap_computerCards == false )) {
                        // the player can't swap the computer cards
                        Toast.makeText(MainActivity.this, "you click long press, swap_computerCards == false", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
        });

        ////////////////////////     Computer Card No.2     //////////////////////

        computerCard2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {     //

                if ((peek_computerCard == true) && (swap_computerCards == true)) {
                    c_shortFlags[1] = shortPress(Computer.computerCards[1].toString(), computerCard2, 1);
                } else if ((peek_computerCard == true) && (swap_computerCards == false)) {
                    c_shortFlags[1] = shortPress(Computer.computerCards[1].toString(), computerCard2, 1);
                } else if ((peek_computerCard == false) && (swap_computerCards == true)) {

                } else if ((peek_computerCard == false) && (swap_computerCards == false)) {

                }
            }
        });

        computerCard2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if ((peek_computerCard == true) || (swap_computerCards == true)) {
                    chooseYourCard(1,computerCard2);
                    Toast.makeText(MainActivity.this, "you click long press, swap_computerCards == true", Toast.LENGTH_SHORT).show();
                }else if ((peek_computerCard == true) && (swap_computerCards == false)) {
                    Toast.makeText(MainActivity.this, "you click long press, swap_computerCards == false", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        ////////////////////////     Computer Card No.3     //////////////////////

        computerCard3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {     //

                if ((peek_computerCard == true) && (swap_computerCards == true)) {
                    c_shortFlags[2] = shortPress(Computer.computerCards[2].toString(), computerCard3, 2);
                } else if ((peek_computerCard == true) && (swap_computerCards == false)) {
                    c_shortFlags[2] = shortPress(Computer.computerCards[2].toString(), computerCard3, 2);
                } else if ((peek_computerCard == false) && (swap_computerCards == true)) {

                } else if ((peek_computerCard == false) && (swap_computerCards == false)) {

                }
            }
        });

        computerCard3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if ((peek_computerCard == true) || (swap_computerCards == true)) {
                    chooseYourCard(2,computerCard3);
                    Toast.makeText(MainActivity.this, "you click long press, swap_computerCards == true", Toast.LENGTH_SHORT).show();
                }else if ((peek_computerCard == true) && (swap_computerCards == false)) {
                    Toast.makeText(MainActivity.this, "you click long press, swap_computerCards == false", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        ////////////////////////     Computer Card No.4     //////////////////////

        computerCard4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {     //

                if ((peek_computerCard == true) && (swap_computerCards == true)) {
                    c_shortFlags[3] = shortPress(Computer.computerCards[3].toString(), computerCard4, 3);
                } else if ((peek_computerCard == true) && (swap_computerCards == false)) {
                    c_shortFlags[3] = shortPress(Computer.computerCards[3].toString(), computerCard4, 3);
                } else if ((peek_computerCard == false) && (swap_computerCards == true)) {

                } else if ((peek_computerCard == false) && (swap_computerCards == false)) {

                }
            }
        });

        computerCard4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if ((peek_computerCard == true) || (swap_computerCards == true)) {
                    chooseYourCard(3,computerCard4);
                    Toast.makeText(MainActivity.this, "you click long press, swap_computerCards == true", Toast.LENGTH_SHORT).show();
                }else if ((peek_computerCard == true) && (swap_computerCards == false)) {
                    Toast.makeText(MainActivity.this, "you click long press, swap_computerCards == false", Toast.LENGTH_SHORT).show();
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
                        p_shortFlags[0] = shortPress(Player.playerCards[0].toString(), playerCard1, 4);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek this card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == false) && (peek_playerCard12 == true)) {// 7 8 allows peeking
                    if (counters[4] < 2) {
                        p_shortFlags[0] = shortPress(Player.playerCards[0].toString(), playerCard1, 4);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek this card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == true) && (peek_playerCard12 == false)) {// jack queen allows swaping
                    // the player can't peek his cards

                } else if ((swap_playerCards == false) && (peek_playerCard12 == false)) {
                    // the player can't peek and swap his cards
                }
            }
        });

        playerCard1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if ((swap_playerCards == true) && (peek_playerCard12 == true)) {// black king allows peeking and swaping
                    // TODO Auto-generated method stub
                    chooseYourCard(4,playerCard1);
                    Toast.makeText(MainActivity.this, "you click long press, peek_playerCard12 == true", Toast.LENGTH_SHORT).show();
                }else if ((swap_playerCards == true) && (peek_playerCard12 == false)){// jack queen allows swaping
                    chooseYourCard(4,playerCard1);
                    Toast.makeText(MainActivity.this, "you click long press, peek_playerCard12 == false", Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });

        ////////////////////////     Player Card No.2     //////////////////////

        playerCard2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((swap_playerCards == true) && (peek_playerCard12 == true)) {
                    if (counters[5] < 2) {
                        p_shortFlags[1] = shortPress(Player.playerCards[1].toString(), playerCard2, 5);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek this card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == false) && (peek_playerCard12 == true)) {
                    if (counters[5] < 2) {
                        p_shortFlags[1] = shortPress(Player.playerCards[1].toString(), playerCard2, 5);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek this card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == true) && (peek_playerCard12 == false)) {

                } else if ((swap_playerCards == false) && (peek_playerCard12 == false)) {

                }
            }
        });

        playerCard2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if ((swap_playerCards == true) && (peek_playerCard12 == true)) {
                    // TODO Auto-generated method stub
                    chooseYourCard(5,playerCard2);
                }else if ((swap_playerCards == true) && (peek_playerCard12 == false)){
                    chooseYourCard(5,playerCard2);
                }

                return true;
            }

        });
        ////////////////////////     Player Card No.3     //////////////////////

        playerCard3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((swap_playerCards == true) && (peek_playerCard34 == true)) {
                    if (counters[6] < 2) {
                        p_shortFlags[2] = shortPress(Player.playerCards[2].toString(), playerCard3, 6);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek this card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == false) && (peek_playerCard34 == true)) {
                    if (counters[6] < 2) {
                        p_shortFlags[2] = shortPress(Player.playerCards[2].toString(), playerCard3, 6);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek this card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == true) && (peek_playerCard34 == false)) {

                } else if ((swap_playerCards == false) && (peek_playerCard34 == false)) {

                }
            }
        });

        playerCard3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if ((swap_playerCards == true) && (peek_playerCard34 == true)) {
                    // TODO Auto-generated method stub
                    chooseYourCard(6,playerCard3);
                }else if ((swap_playerCards == true) && (peek_playerCard34 == false)){
                    chooseYourCard(6,playerCard3);
                }
                return true;
            }

        });

        ////////////////////////     Player Card No.4     //////////////////////

        playerCard4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((swap_playerCards == true) && (peek_playerCard34 == true)) {
                    if (counters[7] < 2) {
                        p_shortFlags[3] = shortPress(Player.playerCards[3].toString(), playerCard4, 7);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek this card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == false) && (peek_playerCard34 == true)) {
                    if (counters[7] < 2) {
                        p_shortFlags[3] = shortPress(Player.playerCards[3].toString(), playerCard4, 7);
                    } else
                        Toast.makeText(MainActivity.this, "you already peek this card", Toast.LENGTH_SHORT).show();
                } else if ((swap_playerCards == true) && (peek_playerCard34 == false)) {

                } else if ((swap_playerCards == false) && (peek_playerCard34 == false)) {

                }
            }
        });

        playerCard4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if ((swap_playerCards == true) && (peek_playerCard34 == true)) {
                    // TODO Auto-generated method stub
                    chooseYourCard(7 ,playerCard4);
                }else if ((swap_playerCards == true) && (peek_playerCard34 == false)){
                    chooseYourCard(7,playerCard4);
                    Toast.makeText(MainActivity.this, "you click long press, peek_playerCard34 == false", Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });


        cardDeck = (ImageButton) findViewById(R.id.deck);
        cardDeck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                if (start) {
                    if ((p_shortFlags[0] == true) && (p_shortFlags[1] == true)) {
                        if ((counters[4] == 0) && (counters[5] == 0))
                            Toast.makeText(MainActivity.this, "You didn't peek your cards", Toast.LENGTH_SHORT).show();
                        else if ((counters[4] == 0) && (counters[5] == 2))
                            Toast.makeText(MainActivity.this, "You peek only one card", Toast.LENGTH_SHORT).show();
                        else if ((counters[4] == 2) && (counters[5] == 0))
                            Toast.makeText(MainActivity.this, "You peek only one card", Toast.LENGTH_SHORT).show();
                        else {
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
                }else Game.theGame();
            }

        });

        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int playerCardIndex = -1;
                int computerCardIndex = -1;
                for (int i = 0; i < p_longFlags.length; i++){
                    if(p_longFlags[i] == false) playerCardIndex = i;
                    else playerCardIndex = -1;
                }
                for (int i = 0; i < c_longFlags.length; i++){
                    if(c_longFlags[i] == false) computerCardIndex = i;
                    else computerCardIndex = -1;
                }
                if (computerCardIndex != -1 && playerCardIndex != -1){
                    // swap between player card and computer card
//                    swap()
                }
                else if (playerCardIndex != -1){
                    // swap between player card and current card
//                    swap()
                }
                else{
                    // You didn't chose cards to swap
                }
            }
        });

        current.setOnLongClickListener(new View.OnLongClickListener() { //The player wants to swap between one of his card and the current card.
            @Override
            public boolean onLongClick(View v) {

                if (currentFlag){
                    chooseYourCard(8, current);
                    currentFlag = false;
                }
                else{
                    chooseYourCard(9, current);
                    currentFlag = true;
                }
                return false;
            }
        });

    }


    public static Context getContext() {
        return mContext.get();
    }

    public static void playerTurn() {

        Game.currentTurn = "player";
        int imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
        current.setImageDrawable(myDrawable);

        Arrays.fill(counters,0,7,0); // player cards are available

        Arrays.fill(c_longFlags,0,4,true); // computer flags for long press
        Arrays.fill(p_longFlags,0,4,true); // player flags for long press

        Arrays.fill(c_shortFlags,0,4,true); // computer flags for short press
        Arrays.fill(p_shortFlags,0,4,true); // player flags for short press

        if ((Game.currentCard.toString().endsWith("7")) || (Game.currentCard.toString().endsWith("8"))) {
            Arrays.fill(counters,4,7,0); // player cards are available
            Arrays.fill(counters,0,3,2);// computer cards are unavailable
            peek_playerCard12 = true;
            peek_playerCard34 = true;
            peek_computerCard = false;
            swap_computerCards = false;
            swap_playerCards = true;
        }
        else if ((Game.currentCard.toString().endsWith("9")) || (Game.currentCard.toString().endsWith("10"))) {
            Arrays.fill(counters,0,7,0); // all cards are available
            peek_playerCard12 = false;
            peek_playerCard34 = false;
            peek_computerCard = true;
            swap_computerCards = false;
            swap_playerCards = true;
        }
        else if ((Game.currentCard.toString().endsWith("jack")) || (Game.currentCard.toString().endsWith("queen"))) {
            Arrays.fill(counters,0,7,0); // all cards are available
            peek_playerCard12 = false;
            peek_playerCard34 = false;
            peek_computerCard = false;
            swap_computerCards = true;
            swap_playerCards = true;
        }
        else if ((Game.currentCard.toString().equals("spadesofking") || (Game.currentCard.toString().equals("clubsofking")))) {
            Arrays.fill(counters,0,7,0); // all cards are available
            peek_playerCard12 = true;
            peek_playerCard34 = true;
            peek_computerCard = true;
            swap_computerCards = true;
            swap_playerCards = true;
        }
        else {
            Arrays.fill(counters,4,7,0); // player cards are available
            Arrays.fill(counters,0,3,2); // computer cards are unavailable
            peek_playerCard12 = false;
            peek_playerCard34 = false;
            peek_computerCard = false;
            swap_computerCards = false;
            swap_playerCards = true;
        }
        Computer.computerTurn();
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

    public static void swap (int playerIndex,int computerIndex, ImageButton playerButton, ImageButton otherButton){

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
        } else { // player regret - don't want to choose current
            int imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
            Drawable myDrawable = getContext().getResources().getDrawable(imageId);
            current.setImageDrawable(myDrawable);
        }
    }

    public static boolean shortPress(String cardName, ImageButton button, int i) {

        if (i < 4){
            if (c_shortFlags[i] && !flagIsFalse(i ,"short")) {  //The card is exposed
                int imageId = getContext().getResources().getIdentifier(cardName, "drawable", getContext().getPackageName());
                Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                button.setImageDrawable(myDrawable);
                System.out.println("counter " + i+": "+counters[i]);
                counters[i]++;
                System.out.println("counter " + i+": "+counters[i]);

                return false;
            } else {                 // The card is hidden
                int imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                button.setImageDrawable(myDrawable);
                System.out.println("back counter " + i+": "+counters[i]);
                counters[i]++;
                System.out.println("back counter " + i+": "+counters[i]);

                return true;
            }
        }
        else{
            if (p_shortFlags[i-4] && !flagIsFalse(i ,"short")) {  //The card is exposed
                int imageId = getContext().getResources().getIdentifier(cardName, "drawable", getContext().getPackageName());
                Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                button.setImageDrawable(myDrawable);
                System.out.println("counter " + i+": "+counters[i]);
                counters[i]++;
                System.out.println("counter " + i+": "+counters[i]);

                return false;
            } else {                 // The card is hidden
                int imageId = getContext().getResources().getIdentifier("back", "drawable", getContext().getPackageName());
                Drawable myDrawable = getContext().getResources().getDrawable(imageId);
                button.setImageDrawable(myDrawable);
                System.out.println("back counter " + i+": "+counters[i]);
                counters[i]++;
                System.out.println("back counter " + i+": "+counters[i]);

                return true;
            }
        }
    }
}


