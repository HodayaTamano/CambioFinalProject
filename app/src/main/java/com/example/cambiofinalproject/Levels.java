package com.example.cambiofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.Stack;

import static com.example.cambiofinalproject.Game.garbage;
import static com.example.cambiofinalproject.MainActivity.counters;

public class Levels extends AppCompatActivity {

    Button easyLevel;
    Button hardLevel;
    Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        easyLevel = (Button) findViewById(R.id.easyLevel);
        hardLevel = (Button) findViewById(R.id.hardLevel);
        menu = (Button) findViewById(R.id.menu);


        easyLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game.level = 0;
                Arrays.fill(counters,0,7,0); // player cards are available
                MainActivity.currentFlag = true;
                MainActivity.garbageFlag = true;
                MainActivity.cardDeckFlag = true;
                MainActivity.peek_playerCard12 = true;
                MainActivity.peek_playerCard34 = false;
                MainActivity.swap_playerCards = false;
                MainActivity.peek_computerCard = false;   //short press on the computer cards.
                MainActivity.swap_computerCards = false;
                MainActivity.start = true;
                Game.gameOn = false;
                Game.winner = "";
                Game.currentCard = new Card();
                Game.currentTurn = "";
//                <Card> garbage = new Stack<Card>();
                Game.cambio_player = false;
                Game.cambio_computer = false;
                Game.computer_sum=0;
                Game.player_sum=0;
                Game.computerWins = 1;
                Game.playerWins = 1;
                Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(myIntent);
            }
        });


        hardLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Arrays.fill(counters,0,7,0); // player cards are available
                MainActivity.currentFlag = true;
                MainActivity.garbageFlag = true;
                MainActivity.cardDeckFlag = true;
                MainActivity.peek_playerCard12 = true;
                MainActivity.peek_playerCard34 = false;
                MainActivity.swap_playerCards = false;
                MainActivity.peek_computerCard = false;   //short press on the computer cards.
                MainActivity.swap_computerCards = false;
                MainActivity.start = true;
                Game.gameOn = false;
                Game.winner = "";
                Game.currentCard = new Card();
                Game.currentTurn = "";
//                <Card> garbage = new Stack<Card>();
                Game.cambio_player = false;
                Game.cambio_computer = false;
                Game.computer_sum=0;
                Game.player_sum=0;
                Game.computerWins = 1;
                Game.playerWins = 1;
                Game.level = 1;
                Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(myIntent);

            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Levels.this, MyMenu.class);
                startActivity(myIntent);
            }
        });
    }
}
