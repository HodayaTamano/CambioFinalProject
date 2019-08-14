package com.example.cambiofinalproject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Player extends MainActivity{



    public static Card [] playerCards = new Card[4];



//    public static void playerTurn(){
//
//       Game.currentTurn = "player";
//       int imageId = getContext().getResources().getIdentifier(Game.currentCard.toString(), "drawable", getContext().getPackageName());
//       Drawable myDrawable = getContext().getResources().getDrawable(imageId);
//       getmCurrent().setImageDrawable(myDrawable);
//
//
//	    if ((Game.currentCard.toString().endsWith("7")) || (Game.currentCard.toString().endsWith("8"))){
//
//
//        }
//    }


//    @Override
//    public void onClick(View v) {
//        if (MainActivity.p_shortFlags[3]) {                          //The card is exposed
//            int imageId = getResources().getIdentifier(Player.playerCards[3].toString(), "drawable", getPackageName());
//            Drawable myDrawable = getResources().getDrawable(imageId);
//            playerCard4.setImageDrawable(myDrawable);
////            Toast.makeText(MainActivity.this, Player.playerCards[3].toString(), Toast.LENGTH_SHORT).show();
//            p_shortFlags[3] = false;
//        } else {                                   // The card is hidden
//            int imageId = getResources().getIdentifier("back", "drawable", getPackageName());
//            Drawable myDrawable = getResources().getDrawable(imageId);
//            playerCard4.setImageDrawable(myDrawable);
//            p_shortFlags[3] = true;
//        }
//    }
}
