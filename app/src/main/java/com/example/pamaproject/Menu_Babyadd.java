package com.example.pamaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Menu_Babyadd extends AppCompatActivity implements View.OnClickListener{
    ImageButton btn,btn2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__babyadd);

        btn = (ImageButton) findViewById(R.id.baby_add_bo_babyadd);
        btn.setOnClickListener( this );
        btn2 = (ImageButton) findViewById(R.id.babyadd_bo_home);
        btn2.setOnClickListener( this );
    }
    public void onClick (View v){
        if(v == btn) {
            intent = new Intent(getApplication(), Menu_Baby.class);
            startActivity(intent);
        }
        if(v == btn2) {
            intent = new Intent(getApplication(), Home.class);
            startActivity(intent);
        }
    }
}