package com.example.pamaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Nikki_naiyou extends AppCompatActivity implements View.OnClickListener {
    ImageButton bo_back,bo_back2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nikki_naiyou);

        bo_back =(ImageButton) findViewById(R.id.bo_bask);
        bo_back2 =(ImageButton) findViewById(R.id.bo_bask);
        bo_back.setOnClickListener(this);
        bo_back2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if(v==bo_back || v==bo_back2){
            intent = new Intent(this,Nikki.class);
            startActivity(intent);
        }


    }
}