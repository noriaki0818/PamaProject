package com.example.pamaproject;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;
import android.widget.Toast;

public class Nikki extends AppCompatActivity implements View.OnClickListener {
    ImageButton bo_tukibetu,bo_record,bo_nikki,bo_article,bo_summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nikki);

        bo_tukibetu = (ImageButton)findViewById(R.id.bo_tukibetu);
        bo_record = (ImageButton)findViewById(R.id.bo_record);
        bo_nikki = (ImageButton)findViewById(R.id.bo_nikki);
        bo_article = (ImageButton)findViewById(R.id.Summary_Food_article);
        bo_summary = (ImageButton)findViewById(R.id.Summary_Food_summary);

        bo_tukibetu.setOnClickListener(this);
        bo_record.setOnClickListener(this);
        bo_nikki.setOnClickListener(this);
        bo_article.setOnClickListener(this);
        bo_summary.setOnClickListener(this);

        Intent intent;
        intent = getIntent();
        String m = intent.getStringExtra("tuki");
        Toast.makeText(this,m,Toast.LENGTH_SHORT).show();










    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if(v == bo_tukibetu){
            intent = new Intent(this, Nikki_tosibetu.class);
            startActivity(intent);
        }
        if(v == bo_record){
            intent = new Intent(this,Home.class);
            startActivity(intent);
        }
        if(v == bo_article){

        }
        if(v == bo_summary){
            intent = new Intent(this,Home_summary.class);
            startActivity(intent);
        }

    }
}