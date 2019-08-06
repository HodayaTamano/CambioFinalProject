package com.example.cambiofinalproject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cambiofinalproject.Game;
import com.example.cambiofinalproject.R;

import java.lang.ref.WeakReference;

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

    static ImageView current;

    static int counter1 = 0;
    static int counter2 = 0;
    static int counter3 = 0;
    static int counter4 = 0;

    public static boolean pick_computerCard = false;

    static boolean p_cardIsPressed1 = true;
    static boolean p_cardIsPressed2 = true;
    static boolean p_cardIsPressed3 = true;
    static boolean p_cardIsPressed4 = true;

    boolean c_cardIsPressed1 = true;
    boolean c_cardIsPressed2 = true;
    boolean c_cardIsPressed3 = true;
    boolean c_cardIsPressed4 = true;

    public static boolean available_playerCards12 = true;
    public static boolean available_playerCards34 = false;
    public static boolean available_computerCards = false;
//    boolean available_playerCards = false;

// In order to use non-static function in static function,
// we saved the context to a static field named mContext and mCurrent,
// and we created a static methods that returns this field getContext() and getmCurrent().
    private static WeakReference <Context> mContext;
    private static WeakReference <ImageView> mCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Game.start();

        current = (ImageView) findViewById(R.id.currentCard);
        mCurrent = new WeakReference<ImageView>(current);
        mContext = new WeakReference<Context>(this);

///////////////////////////////////////////////// Computer Cards ////////////////////////////////////////////////////////////
        computerCard1 = (ImageButton) findViewById(R.id.computerCard1);
        computerCard1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(pick_computerCard) {
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
            }
        });

        computerCard1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (available_computerCards) {
                    // TODO Auto-generated method stub
                    Toast.makeText(MainActivity.this, "you click long press", Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });



        computerCard2 = (ImageButton) findViewById(R.id.computerCard2);
        computerCard2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(pick_computerCard) {
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
            }
        });

        computerCard2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (available_computerCards) {
                    // TODO Auto-generated method stub
                    Toast.makeText(MainActivity.this, "you click long press", Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });



        computerCard3 = (ImageButton) findViewById(R.id.computerCard3);
        computerCard3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (pick_computerCard) {
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
            }
        });

        computerCard3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (available_computerCards) {
                    // TODO Auto-generated method stub
                    Toast.makeText(MainActivity.this, "you click long press", Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });


        computerCard4 = (ImageButton) findViewById(R.id.computerCard4);
        computerCard4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(pick_computerCard) {
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
            }
        });

        computerCard4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (available_computerCards) {
                    // TODO Auto-generated method stub
                    Toast.makeText(MainActivity.this, "you click long press", Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });


///////////////////////////////////////////////// Player Cards ////////////////////////////////////////////////////////////

        playerCard1 = (ImageButton) findViewById(R.id.playerCard1);
        playerCard1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                if (available_playerCards12) {
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
            }
        });

        playerCard1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (available_playerCards12) {
                    // TODO Auto-generated method stub
                    Toast.makeText(MainActivity.this, "you click long press", Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });



        playerCard2 = (ImageButton) findViewById(R.id.playerCard2);
        playerCard2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                if (available_playerCards12) {
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
            }

        });

        playerCard2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (available_playerCards12) {
                    // TODO Auto-generated method stub
                    Toast.makeText(MainActivity.this, "you click long press", Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });


        playerCard3 = (ImageButton) findViewById(R.id.playerCard3);
        playerCard3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                if (available_playerCards34) {
                    if (counter3 < 2) {
                        if (p_cardIsPressed3) {                         //The card is exposed
                            int imageId = getResources().getIdentifier(Player.playerCards[2].toString(), "drawable", getPackageName());
                            Drawable myDrawable = getResources().getDrawable(imageId);
                            playerCard3.setImageDrawable(myDrawable);
                            // Toast.makeText(MainActivity.this,Game.playerCards[2].toString(),Toast.LENGTH_SHORT).show();
                            counter3++;
                            p_cardIsPressed3 = false;
                        } else {                             // The card is hidden
                            int imageId = getResources().getIdentifier("back", "drawable", getPackageName());
                            Drawable myDrawable = getResources().getDrawable(imageId);
                            playerCard3.setImageDrawable(myDrawable);
                            counter3++;
                            p_cardIsPressed3 = true;
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "you can't pick more than 2 cards", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        playerCard3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (available_playerCards34) {
                    // TODO Auto-generated method stub
                    Toast.makeText(MainActivity.this, "you click long press", Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });



        playerCard4 = (ImageButton) findViewById(R.id.playerCard4);
        playerCard4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                if (available_playerCards34) {
                    if (counter4 < 2) {
                        if (p_cardIsPressed4) {                          //The card is exposed
                            int imageId = getResources().getIdentifier(Player.playerCards[3].toString(), "drawable", getPackageName());
                            Drawable myDrawable = getResources().getDrawable(imageId);
                            playerCard4.setImageDrawable(myDrawable);
                            Toast.makeText(MainActivity.this, Player.playerCards[3].toString(), Toast.LENGTH_SHORT).show();
                            counter4++;
                            p_cardIsPressed4 = false;
                        } else {                                   // The card is hidden
                            int imageId = getResources().getIdentifier("back", "drawable", getPackageName());
                            Drawable myDrawable = getResources().getDrawable(imageId);
                            playerCard4.setImageDrawable(myDrawable);
                            counter4++;
                            p_cardIsPressed4 = true;
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "you can't pick more than 2 cards", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        playerCard4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (available_playerCards34) {
                    // TODO Auto-generated method stub
                    Toast.makeText(MainActivity.this, "you click long press", Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });


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
//                        Toast.makeText(MainActivity.this,Game.garbage.peek().toString(), Toast.LENGTH_SHORT).show();

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

    public static Context getContext(){
        return mContext.get();
    }
    public static ImageView getmCurrent(){
        return mCurrent.get();
    }
    public static void playerTurn(){

        Game.currentTurn = "player";
        int imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
        Drawable myDrawable = getContext().getResources().getDrawable(imageId);
        getmCurrent().setImageDrawable(myDrawable);

        counter1=0;
        counter2=0;
        counter3=0;
        counter4=0;

        if ((Game.currentCard.toString().endsWith("7")) || (Game.currentCard.toString().endsWith("8"))){
            available_playerCards12= true;
            available_playerCards34= true;
            available_computerCards = false;
        }

        else if ((Game.currentCard.toString().endsWith("9")) || (Game.currentCard.toString().endsWith("10"))) {
            pick_computerCard = true;
            available_computerCards = true;
            available_playerCards12 = false;
            available_playerCards34 = false;

        }
        else if ((Game.currentCard.toString().endsWith("jack")) || (Game.currentCard.toString().endsWith("queen"))) {
            counter1=2;
            counter2=2;
            counter3=2;
            counter4=2;
            pick_computerCard = false;
            available_computerCards = true;
            available_playerCards12= true;
            available_playerCards34= true;
        }
        else if ((Game.currentCard.toString().equals("spadesofking") || (Game.currentCard.toString().equals("clubsofking")))) {
            pick_computerCard = true;
            available_computerCards = true;
            available_playerCards12= true;
            available_playerCards34= true;
        }
        else {
            counter1=2;
            counter2=2;
            counter3=2;
            counter4=2;
            available_playerCards12 = true;
            available_playerCards34 = true;
        }


    }
}


