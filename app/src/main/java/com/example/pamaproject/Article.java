package com.example.pamaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Article extends AppCompatActivity implements View.OnClickListener {

    ImageButton articleMenuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        //メニューの追加
        articleMenuBtn = (ImageButton)findViewById(R.id.article_menu2);
        articleMenuBtn.setOnClickListener( this );

        TextView textView1 = (TextView) findViewById(R.id.articletext_title);
        Intent intent = getIntent();
        String name = intent.getStringExtra( "article_ID");

        if (name!= null){
            textView1.setText(name);
        }




    }

    @Override
    public void onClick(View v) {
        if (v == articleMenuBtn){
            Intent intent = new Intent(this,Menu_Baby.class);
            startActivity(intent);
        }
    }

    void seigo1(){

    }

}