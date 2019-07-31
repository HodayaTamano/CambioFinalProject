package com.example.cambiofinalproject;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cambiofinalproject.Game;
import com.example.cambiofinalproject.R;

public class MainActivity extends AppCompatActivity {

    ImageButton computerCard1;
    ImageButton computerCard2;
    ImageButton computerCard3;
    ImageButton computerCard4;

    ImageButton playerCard1;
    ImageButton playerCard2;
    ImageButton playerCard3;
    ImageButton playerCard4;

    ImageButton cardDeck;

    ImageView current;

    int counter1 = 0;
    int counter2 = 0;

    boolean p_cardIsPressed1 = true;
    boolean p_cardIsPressed2 = true;
    boolean p_cardIsPressed3 = true;
    boolean p_cardIsPressed4 = true;

    boolean c_cardIsPressed1 = true;
    boolean c_cardIsPressed2 = true;
    boolean c_cardIsPressed3 = true;
    boolean c_cardIsPressed4 = true;

    boolean available_computerCards = false;
    boolean available_playerCards = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Game.start();
///////////////////////////////////////////////// Computer Cards ////////////////////////////////////////////////////////////
        computerCard1 = (ImageButton) findViewById(R.id.computerCard1);
        computerCard1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                Toast.makeText(MainActivity.this, Boolean.toString(Game.gameOn), Toast.LENGTH_SHORT).show();
                if (available_computerCards) {
                    if (c_cardIsPressed1) {  //The card is exposed
                        int imageId = getResources().getIdentifier(Computer.computerCards[0].toString(), "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        computerCard1.setImageDrawable(myDrawable);
                        //  Toast.makeText(MainActivity.this,Computer.computerCards[0].toString(),Toast.LENGTH_SHORT).show();
                        c_cardIsPressed1 = false;
                    } else {                 // The card is hidden
                        int imageId = getResources().getIdentifier("back", "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        computerCard1.setImageDrawable(myDrawable);
                        c_cardIsPressed1 = true;
                    }
                } else {
                    Toast.makeText(MainActivity.this, "you can't pick the computer card", Toast.LENGTH_SHORT).show();

                }
            }
        });

        computerCard2 = (ImageButton) findViewById(R.id.computerCard2);
        computerCard2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                if (available_computerCards) {
                    if (c_cardIsPressed2) {                      //The card is exposed
                        int imageId = getResources().getIdentifier(Computer.computerCards[1].toString(), "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        computerCard2.setImageDrawable(myDrawable);
                        //   Toast.makeText(MainActivity.this,Computer.computerCards[1].toString(),Toast.LENGTH_SHORT).show();
                        c_cardIsPressed2 = false;
                    } else {                 // The card is hidden
                        int imageId = getResources().getIdentifier("back", "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        computerCard2.setImageDrawable(myDrawable);
                        c_cardIsPressed2 = true;
                    }
                } else {
                    Toast.makeText(MainActivity.this, "you can't pick the computer card", Toast.LENGTH_SHORT).show();

                }
            }
        });

        computerCard3 = (ImageButton) findViewById(R.id.computerCard3);
        computerCard3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                if (available_computerCards) {
                    if (c_cardIsPressed3) {                //The card is exposed
                        int imageId = getResources().getIdentifier(Computer.computerCards[2].toString(), "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        computerCard3.setImageDrawable(myDrawable);
                        // Toast.makeText(MainActivity.this,Computer.computerCards[2].toString(),Toast.LENGTH_SHORT).show();
                        c_cardIsPressed3 = false;
                    } else {                            // The card is hidden
                        int imageId = getResources().getIdentifier("back", "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        computerCard3.setImageDrawable(myDrawable);
                        c_cardIsPressed3 = true;
                    }
                } else {
                    Toast.makeText(MainActivity.this, "you can't pick the computer card", Toast.LENGTH_SHORT).show();

                }
            }
        });

        computerCard4 = (ImageButton) findViewById(R.id.computerCard4);
        computerCard4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                if (available_computerCards) {
                    if (c_cardIsPressed4) {              //The card is exposed
                        int imageId = getResources().getIdentifier(Computer.computerCards[3].toString(), "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        computerCard4.setImageDrawable(myDrawable);
                        //   Toast.makeText(MainActivity.this,Computer.computerCards[3].toString(),Toast.LENGTH_SHORT).show();
                        c_cardIsPressed4 = false;
                    } else {                   // The card is hidden
                        int imageId = getResources().getIdentifier("back", "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        computerCard4.setImageDrawable(myDrawable);
                        c_cardIsPressed4 = true;
                    }
                } else {
                    Toast.makeText(MainActivity.this, "you can't pick the computer card", Toast.LENGTH_SHORT).show();

                }
            }
        });

///////////////////////////////////////////////// Player Cards ////////////////////////////////////////////////////////////

        playerCard1 = (ImageButton) findViewById(R.id.playerCard1);
        playerCard1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                if (counter1 < 2) {
                    if (p_cardIsPressed1) {                 //The card is exposed
                        int imageId = getResources().getIdentifier(Player.playerCards[0].toString(), "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        playerCard1.setImageDrawable(myDrawable);
                        //   Toast.makeText(MainActivity.this, Game.playerCards[0].toString(), Toast.LENGTH_SHORT).show();
                        counter1++;
                        p_cardIsPressed1 = false;
                    } else {                        // The card is hidden
                        int imageId = getResources().getIdentifier("back", "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        playerCard1.setImageDrawable(myDrawable);
                        counter1++;
                        p_cardIsPressed1 = true;
                    }
                } else
                    Toast.makeText(MainActivity.this, "you already pick this card", Toast.LENGTH_SHORT).show();
            }
        });

        playerCard2 = (ImageButton) findViewById(R.id.playerCard2);
        playerCard2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                if (counter2 < 2) {
                    if (p_cardIsPressed2) {                        //The card is exposed
                        int imageId = getResources().getIdentifier(Player.playerCards[1].toString(), "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        playerCard2.setImageDrawable(myDrawable);
                        //    Toast.makeText(MainActivity.this, Game.playerCards[1].toString(), Toast.LENGTH_SHORT).show();
                        counter2++;
                        p_cardIsPressed2 = false;
                    } else {                                    // The card is hidden
                        int imageId = getResources().getIdentifier("back", "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        playerCard2.setImageDrawable(myDrawable);
                        counter2++;
                        p_cardIsPressed2 = true;
                    }

                } else
                    Toast.makeText(MainActivity.this, "you already pick this card", Toast.LENGTH_SHORT).show();
            }

        });

        playerCard3 = (ImageButton) findViewById(R.id.playerCard3);
        playerCard3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                if (available_playerCards) {
                    if (p_cardIsPressed3) {                         //The card is exposed
                        int imageId = getResources().getIdentifier(Player.playerCards[2].toString(), "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        playerCard3.setImageDrawable(myDrawable);
                        // Toast.makeText(MainActivity.this,Game.playerCards[2].toString(),Toast.LENGTH_SHORT).show();
                        p_cardIsPressed3 = false;
                    } else {                             // The card is hidden
                        int imageId = getResources().getIdentifier("back", "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        playerCard3.setImageDrawable(myDrawable);
                        p_cardIsPressed3 = true;
                    }
                } else {
                    Toast.makeText(MainActivity.this, "you can't pick more than 2 cards", Toast.LENGTH_SHORT).show();
                }
            }
        });

        playerCard4 = (ImageButton) findViewById(R.id.playerCard4);
        playerCard4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                if (available_playerCards) {
                    if (p_cardIsPressed4) {                          //The card is exposed
                        int imageId = getResources().getIdentifier(Player.playerCards[3].toString(), "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        playerCard4.setImageDrawable(myDrawable);
                        Toast.makeText(MainActivity.this, Player.playerCards[3].toString(), Toast.LENGTH_SHORT).show();
                        p_cardIsPressed4 = false;
                    } else {                                   // The card is hidden
                        int imageId = getResources().getIdentifier("back", "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        playerCard4.setImageDrawable(myDrawable);
                        p_cardIsPressed4 = true;
                    }
                } else {
                    Toast.makeText(MainActivity.this, "you can't pick more than 2 cards", Toast.LENGTH_SHORT).show();

                }
            }
        });

        current = (ImageView) findViewById(R.id.currentCard);

        cardDeck = (ImageButton) findViewById(R.id.deck);
        cardDeck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                if ((p_cardIsPressed1 == true) && (p_cardIsPressed2 == true)) {
                    if ((counter1 == 0) && (counter2 == 0))
                        Toast.makeText(MainActivity.this, "You didn't pick your cards", Toast.LENGTH_SHORT).show();
                    else if ((counter1 == 0) && (counter2 == 2))
                        Toast.makeText(MainActivity.this, "You pick only one card", Toast.LENGTH_SHORT).show();
                    else if ((counter1 == 2) && (counter2 == 0))
                        Toast.makeText(MainActivity.this, "You pick only one card", Toast.LENGTH_SHORT).show();
                    else {
                        Game.theGame();
                        int imageId = getResources().getIdentifier(Card.cardDeck.get(0).toString(), "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        current.setImageDrawable(myDrawable);

                    }

                } else {
                    if ((counter1 == 0) && (counter2 == 1))
                        Toast.makeText(MainActivity.this, "Your card is exposed", Toast.LENGTH_SHORT).show();
                    else if ((counter1 == 1) && (counter2 == 0))
                        Toast.makeText(MainActivity.this, "Your card is exposed", Toast.LENGTH_SHORT).show();
                    else if ((counter1 == 1) && (counter2 == 1))
                        Toast.makeText(MainActivity.this, "Your cards are exposed", Toast.LENGTH_SHORT).show();
                    else if ((counter1 == 1) && (counter2 == 2))
                        Toast.makeText(MainActivity.this, "Your card is exposed", Toast.LENGTH_SHORT).show();
                    else if ((counter1 == 2) && (counter2 == 1))
                        Toast.makeText(MainActivity.this, "Your card is exposed", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        currentCard = (ImageView) findViewById(R.id.currentCard);
//        currentCard.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//
//            }
//        });
    }
}


