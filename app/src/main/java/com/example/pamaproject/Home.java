package com.example.pamaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Home extends AppCompatActivity  implements View.OnClickListener{
    ImageButton btn, articleBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn = (ImageButton) findViewById(R.id.home_menu);
        btn.setOnClickListener( this );

        articleBtn = (ImageButton)findViewById(R.id.home_bo_article);
        articleBtn.setOnClickListener(this);
    }
    @Override
    public void onClick (View v){
         if(v == btn) {
            intent = new Intent(getApplication(), Menu_Baby.class);
            startActivity(intent);
        }
         if (v== articleBtn){
             intent = new Intent(getApplication(), article_list.class);
             startActivity(intent);
         }
    }
}