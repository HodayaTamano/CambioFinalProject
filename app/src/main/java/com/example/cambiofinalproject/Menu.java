package com.example.cambiofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Stack;

public class Menu extends AppCompatActivity {

    static Button newGame;
    static Button easyLevel;
    static Button instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        easyLevel = (Button) findViewById(R.id.easyLevel);
        newGame = (Button) findViewById(R.id.newgame);
        instruction = (Button) findViewById(R.id.instruction);


        easyLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game.level = 0;
                Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(myIntent);
            }
        });


        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game.level = 1;
                Game.gameOn = false;
                Game.gameOn = false;
                Game.winner = "";
                Game.currentCard = new Card();
                Game.currentTurn = "";
                Game.garbage = new Stack<Card>();
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

        instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Instruction.class);
                startActivity(myIntent);
            }
        });
    }
}
