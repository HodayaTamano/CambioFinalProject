package com.example.cambiofinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MyMenu extends AppCompatActivity {

    Button newGame;
    Button instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        newGame = (Button) findViewById(R.id.newgame);
        instruction = (Button) findViewById(R.id.instruction);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Levels.class);
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
