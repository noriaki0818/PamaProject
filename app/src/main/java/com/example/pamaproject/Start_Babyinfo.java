package com.example.pamaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Start_Babyinfo extends AppCompatActivity implements View.OnClickListener{

    ImageView IV;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__babyinfo);

        IV = (ImageView) findViewById(R.id.next_to_userInfo);
        IV.setOnClickListener( this );

    }
    @Override
    public void onClick (View v){
        if(v == IV)
            intent = new Intent(Start_Babyinfo.this, Home.class);
        startActivity(intent);
    }
}