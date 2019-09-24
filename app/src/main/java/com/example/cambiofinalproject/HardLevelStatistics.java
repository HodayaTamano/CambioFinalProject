package com.example.cambiofinalproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.cambiofinalproject.MainActivity.getContext;

public class HardLevelStatistics extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    Button backToMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level_statistics);

        textView1 = (TextView) findViewById(R.id.textView2);
        textView2 = (TextView) findViewById(R.id.textView3);
        textView3 = (TextView) findViewById(R.id.textView4);
        backToMenu = (Button) findViewById(R.id.backToMenu2);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        database.getReference("Hard level").child("Computer").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    textView1.setText("Computer won "+String.valueOf(dataSnapshot.getValue())+" times.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        database.getReference("Hard level").child("Player").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    textView2.setText("\n"+"Player won "+String.valueOf(dataSnapshot.getValue())+" times.");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        database.getReference("Hard level").child("Computer Victory Statistics").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    textView3.setText("\n"+"Computer Victory Statistics: "+String.valueOf(dataSnapshot.getValue()));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HardLevelStatistics.this, MyMenu.class);
                startActivity(myIntent);
            }
        });
    }
}
