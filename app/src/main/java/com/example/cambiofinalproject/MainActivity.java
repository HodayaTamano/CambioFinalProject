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

    int counter = 0;
    boolean cardIsPressed = true;
    boolean secondCardIsPressed = true;

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
                int imageId = getResources().getIdentifier(Computer.computerCards[0].toString(),"drawable", getPackageName());
                Drawable myDrawable = getResources().getDrawable(imageId);
                computerCard1.setImageDrawable(myDrawable);
                Toast.makeText(MainActivity.this,Computer.computerCards[0].toString(),Toast.LENGTH_SHORT).show();
            }
        });

        computerCard2 = (ImageButton) findViewById(R.id.computerCard2);
        computerCard2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays

                int imageId = getResources().getIdentifier(Computer.computerCards[1].toString(),"drawable", getPackageName());
                Drawable myDrawable = getResources().getDrawable(imageId);
                computerCard2.setImageDrawable(myDrawable);
                Toast.makeText(MainActivity.this,Computer.computerCards[1].toString(),Toast.LENGTH_SHORT).show();
            }
        });

        computerCard3 = (ImageButton) findViewById(R.id.computerCard3);
        computerCard3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                int imageId = getResources().getIdentifier(Computer.computerCards[2].toString(),"drawable", getPackageName());
                Drawable myDrawable = getResources().getDrawable(imageId);
                computerCard3.setImageDrawable(myDrawable);
                Toast.makeText(MainActivity.this,Computer.computerCards[2].toString(),Toast.LENGTH_SHORT).show();
            }
        });

        computerCard4 = (ImageButton) findViewById(R.id.computerCard4);
        computerCard4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//          clicking on the back of the card and card displays
                int imageId = getResources().getIdentifier(Computer.computerCards[3].toString(),"drawable", getPackageName());
                Drawable myDrawable = getResources().getDrawable(imageId);
                computerCard4.setImageDrawable(myDrawable);
                Toast.makeText(MainActivity.this,Computer.computerCards[3].toString(),Toast.LENGTH_SHORT).show();
            }
        });

///////////////////////////////////////////////// Player Cards ////////////////////////////////////////////////////////////

            playerCard1 = (ImageButton) findViewById(R.id.playerCard1);
            playerCard1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
//          clicking on the back of the card and card displays
                    if (cardIsPressed) {
                        int imageId = getResources().getIdentifier(Game.playerCards[0].toString(), "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        playerCard1.setImageDrawable(myDrawable);
                        Toast.makeText(MainActivity.this, Game.playerCards[0].toString(), Toast.LENGTH_SHORT).show();
                        cardIsPressed = false;
                    }
                    else{
                        int imageId = getResources().getIdentifier("back", "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        playerCard1.setImageDrawable(myDrawable);
                        cardIsPressed = true;
                    }
                }
            });

            playerCard2 = (ImageButton) findViewById(R.id.playerCard2);
            playerCard2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
//          clicking on the back of the card and card displays
                    if (cardIsPressed){
                        int imageId = getResources().getIdentifier(Game.playerCards[1].toString(), "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        playerCard2.setImageDrawable(myDrawable);
                        Toast.makeText(MainActivity.this, Game.playerCards[1].toString(), Toast.LENGTH_SHORT).show();
                        cardIsPressed = false;
                    }else{
                        int imageId = getResources().getIdentifier("back", "drawable", getPackageName());
                        Drawable myDrawable = getResources().getDrawable(imageId);
                        playerCard1.setImageDrawable(myDrawable);
                        cardIsPressed = true;
                    }

                }
            });

            playerCard3 = (ImageButton) findViewById(R.id.playerCard3);
            playerCard3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
//          clicking on the back of the card and card displays
                    int imageId = getResources().getIdentifier(Game.playerCards[2].toString(),"drawable", getPackageName());
                    Drawable myDrawable = getResources().getDrawable(imageId);
                    playerCard3.setImageDrawable(myDrawable);
                    Toast.makeText(MainActivity.this,Game.playerCards[2].toString(),Toast.LENGTH_SHORT).show();
                }
            });

            playerCard4 = (ImageButton) findViewById(R.id.playerCard4);
            playerCard4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
//          clicking on the back of the card and card displays
                    int imageId = getResources().getIdentifier(Game.playerCards[3].toString(),"drawable", getPackageName());
                    Drawable myDrawable = getResources().getDrawable(imageId);
                    playerCard4.setImageDrawable(myDrawable);
                    Toast.makeText(MainActivity.this,Game.playerCards[3].toString(),Toast.LENGTH_SHORT).show();
                }
            });



//        backComputerCard4 = (ImageButton) findViewById(R.id.computerCard4);
//        backComputerCard4.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
////          clicking on the back of the card and card displays
//                boolean isPressed= true;
//                if(isPressed) {
//                    int imageId = getResources().getIdentifier(Computer.computerCards[3].toString(), "drawable", getPackageName());
//                    Drawable myDrawable = getResources().getDrawable(imageId);
//                    backComputerCard4.setImageDrawable(myDrawable);
//                    isPressed = false;
//                }
//                else
//                    backComputerCard4.setImageDrawable(backCard);
//                Toast.makeText(MainActivity.this,Computer.computerCards[3].toString(),Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
