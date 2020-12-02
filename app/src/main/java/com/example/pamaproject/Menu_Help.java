package com.example.pamaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Menu_Help extends AppCompatActivity implements View.OnClickListener{
    ImageButton btn,btn2,btn3;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__help);
        btn = (ImageButton) findViewById(R.id.help_bo_share);
        btn.setOnClickListener( this );
        btn2 = (ImageButton) findViewById(R.id.help_bo_baby);
        btn2.setOnClickListener( this );
        btn3 = (ImageButton) findViewById(R.id.help_bo_hame);
        btn3.setOnClickListener( this );
    }
    @Override
    public void onClick (View v){
        if(v == btn) {
            intent = new Intent(getApplication(), Menu_Share.class);
            startActivity(intent);
        }
        if(v == btn2) {
            intent = new Intent(getApplication(), Menu_Baby.class);
            startActivity(intent);
        }
        if(v == btn3) {
            intent = new Intent(getApplication(), Home.class);
            startActivity(intent);
        }
    }
}