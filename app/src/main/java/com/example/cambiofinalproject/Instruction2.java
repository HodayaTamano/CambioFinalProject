package com.example.cambiofinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import androidx.appcompat.app.AppCompatActivity;

public class Instruction2 extends AppCompatActivity {

    TextView tv3;
    Button next;
    Button prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction2);

        tv3 = (TextView)findViewById(R.id.textView5);
        next = (Button) findViewById(R.id.button5);
        prev = (Button) findViewById(R.id.button);

        tv3.setText("Winning:\n" +"\n" +
                "In order to win, one player has to call “Cambio” by pressing cambio, during their turn and cannot play a card if they call it.\n" +"\n" +
                "Once the player calls Cambio, the rest of the players get one more turn to play before everyone flips their cards and adds up their points.\n" +"\n" +
                "The person with the least amount of points wins. If there is a tie, the player who didn’t call Cambio wins.\n");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), MyMenu.class);
                startActivity(myIntent);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Instruction1.class);
                startActivity(myIntent);
            }
        });
    }
}
