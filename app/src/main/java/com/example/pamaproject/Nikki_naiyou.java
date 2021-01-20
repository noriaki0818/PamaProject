package com.example.pamaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Nikki_naiyou extends AppCompatActivity implements View.OnClickListener {
    ImageButton bo_back,bo_back2;
    EditText memo;
    ImageView photo;
    String a = "abe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nikki_naiyou);

        bo_back =(ImageButton) findViewById(R.id.bo_bask);
        bo_back2 =(ImageButton) findViewById(R.id.bo_bask);
        memo = (EditText) findViewById(R.id.edit);
        photo =(ImageView) findViewById(R.id.nikki_Photo);
        bo_back.setOnClickListener(this);
        bo_back2.setOnClickListener(this);

        photo.setImageResource(R.drawable.abe);


        //dbからの内容をセット
        String naiyou = "ないようないようないよう";
        memo.setText(naiyou);
        if(naiyou == ""){
            memo.setText("日記");
        }










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