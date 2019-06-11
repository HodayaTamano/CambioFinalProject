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

    ImageButton backComputerCard1;
    ImageView viewComputerCard1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Game.start();

        backComputerCard1 = (ImageButton) findViewById(R.id.computerCard1);
        viewComputerCard1 = (ImageView) findViewById(R.id.viewComputerCard1);

        backComputerCard1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

//            Example of displaying specific card:
                int imageId = R.drawable.clubsof2;
                String s = "R.drawable".concat(Computer.computerCards[1].toString());
                Drawable myDrawable = getResources().getDrawable(imageId);
                viewComputerCard1.setImageDrawable(myDrawable);
                Toast.makeText(MainActivity.this,Computer.computerCards[1].toString()+" ",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
