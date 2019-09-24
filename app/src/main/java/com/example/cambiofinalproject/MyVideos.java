package com.example.cambiofinalproject;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

//import androidx.appcompat.app.AppCompatActivity;

public class MyVideos extends AppCompatActivity {

    Button prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        prev = (Button) findViewById(R.id.button);

        getWindow().setFormat(PixelFormat.UNKNOWN);

        VideoView vv = (VideoView) findViewById(R.id.videoView);

        if (Instruction1.cardNum == 78) {
            String uriPath = "android.resource://com.example.cambiofinalproject/" + R.raw.seveneight;
            Uri uri2 = Uri.parse(uriPath);
            vv.setVideoURI(uri2);
            vv.requestFocus();
            vv.start();
        } else if (Instruction1.cardNum == 910) {
            String uriPath = "android.resource://com.example.cambiofinalproject/" + R.raw.nineten;
            Uri uri2 = Uri.parse(uriPath);
            vv.setVideoURI(uri2);
            vv.requestFocus();
            vv.start();
        } else if (Instruction1.cardNum == 1112) {
            String uriPath = "android.resource://com.example.cambiofinalproject/" + R.raw.jackqueen;
            Uri uri2 = Uri.parse(uriPath);
            vv.setVideoURI(uri2);
            vv.requestFocus();
            vv.start();
        }else if (Instruction1.cardNum == 13){
            String uriPath = "android.resource://com.example.cambiofinalproject/" + R.raw.blackking;
            Uri uri2 = Uri.parse(uriPath);
            vv.setVideoURI(uri2);
            vv.requestFocus();
            vv.start();
        }


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Instruction1.class);
                startActivity(myIntent);
            }
        });
    }
}

