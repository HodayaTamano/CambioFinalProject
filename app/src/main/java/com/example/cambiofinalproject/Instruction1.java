package com.example.cambiofinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import androidx.appcompat.app.AppCompatActivity;

public class Instruction1 extends AppCompatActivity {

    TextView tv2;
    Button next;
    Button prev;
    Button c78;
    Button c910;
    Button cJQ;
    Button cK;
    public static int cardNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction1);

        tv2 = (TextView)findViewById(R.id.textView5);
        next = (Button) findViewById(R.id.button5);
        prev = (Button) findViewById(R.id.button);
        c78 = (Button) findViewById(R.id.button2);
        c910 = (Button) findViewById(R.id.button3);
        cJQ = (Button) findViewById(R.id.button4);
        cK = (Button) findViewById(R.id.button6);

        tv2.setText("Card Rules:\n" +
                "Certain cards have rules when you get them from the deck:\n" +"\n"+
                "* 7 or 8 – Look at your own card - press short click on the card\n"+"\n"+
                "* 9 or 10 – Look at someone else’s card - press short click on the cards\n"+"\n"+
                "* Jack or Queen – Without looking at the card, you can blind switch one of your own with someone else’s. press long click on the cards , then, press swap button.\n"+"\n"+
                "* Black King – You can look at anyone’s card - press short click on the card  - and switch anyone’s card with any one of yours - press long click on the cards.\n"+"\n"+
                "Videos for example:");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Instruction2.class);
                startActivity(myIntent);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Instruction.class);
                startActivity(myIntent);
            }
        });

        c78.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardNum = 78;
                Intent myIntent = new Intent(getBaseContext(), MyVideos.class);
                startActivity(myIntent);
            }
        });

        c910.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardNum = 910;
                Intent myIntent = new Intent(getBaseContext(), MyVideos.class);
                startActivity(myIntent);
            }
        });

        cJQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardNum = 1112;
                Intent myIntent = new Intent(getBaseContext(), MyVideos.class);
                startActivity(myIntent);
            }
        });

        cK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardNum = 13;
                Intent myIntent = new Intent(getBaseContext(), MyVideos.class);
                startActivity(myIntent);
            }
        });
    }
}
