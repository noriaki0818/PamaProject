package com.example.pamaproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Menu_Share extends AppCompatActivity  implements View.OnClickListener{
    ImageButton btn,btn2,btn3;
    Intent intent;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__share);
        btn = (ImageButton) findViewById(R.id.share_bo_help);
        btn.setOnClickListener(this);
        btn2 = (ImageButton) findViewById(R.id.share_bo_baby);
        btn2.setOnClickListener(this);
        btn3 = (ImageButton) findViewById(R.id.share_bo_share);

        btn3.setBackgroundColor(Color.WHITE);

    }
    @Override
    public void onClick (View v){
        if(v == btn) {
            intent = new Intent(getApplication(), Menu_Help.class);
            startActivity(intent);
        }
        if(v == btn2) {
            intent = new Intent(getApplication(), Menu_Baby.class);
            startActivity(intent);
        }
    }
}
