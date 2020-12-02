package com.example.pamaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Menu_Baby extends AppCompatActivity implements View.OnClickListener{
    ImageView view;
    ImageButton btn,btn2,btn3;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__baby);
        view = (ImageView) findViewById(R.id.baby_bo_add);
        view.setOnClickListener( this );
        btn = (ImageButton) findViewById(R.id.baby_bo_help);
        btn.setOnClickListener( this );
        btn2 = (ImageButton) findViewById(R.id.baby_bo_share);
        btn2.setOnClickListener( this );
        btn3 = (ImageButton) findViewById(R.id.baby_bo_home);
        btn3.setOnClickListener( this );
    }
    @Override
    public void onClick (View v){
        if(v == view) {
            intent = new Intent(getApplication(), Menu_Babyadd.class);
            startActivity(intent);
        }
        if(v == btn) {
            intent = new Intent(getApplication(), Menu_Help.class);
            startActivity(intent);
        }
        if(v == btn2) {
            intent = new Intent(getApplication(), Menu_Share.class);
            startActivity(intent);
        }
        if(v == btn3) {
            intent = new Intent(getApplication(), Home.class);
            startActivity(intent);
        }
    }
}