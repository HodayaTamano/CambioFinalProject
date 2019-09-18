package com.example.cambiofinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class Instruction extends AppCompatActivity {

    TextView tv1;
    Button next;
    Button prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        tv1 = (TextView)findViewById(R.id.textView5);
        next = (Button) findViewById(R.id.button5);
        prev = (Button) findViewById(R.id.button);

        tv1.setText("Basics:\n" +
                "Cambio is played with two players – you vs. computer.\n" +
                "The goal is to have the least amount of points by the end of the game.\n" +
                " Each player is given one chance to check out the 2 cards closest to them and memorize them. \n" +"\n"+
                "In order to peek your 2 close cards, you need to press short click on the cards, and flip them  back by pressing short click again.\n" +
                "The game starts by picking a card from the deck.\n" +"\n"+
                "You may swap the card you pull with one of your own. This would be in order to reduce the amount of points you have.\n" +
                "In order to swap between the cards, you need to press long click on the cards you want to swap between them, then press on swap button. \n" +"\n"+
                "If you ended your turn press end turn button, and now it’s the computer turn.\n"+"\n");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), instruction1.class);
                startActivity(myIntent);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Menu.class);
                startActivity(myIntent);
            }
        });

//        sv.addView(tv1);

    }
}
