package com.example.pamaproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
public class Start_Userinfo2 extends AppCompatActivity implements View.OnClickListener{
    ImageButton btn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__userinfo2);
        btn = (ImageButton) findViewById(R.id.start_userInfo2_next_to);
        btn.setOnClickListener( this );

    }
    @Override
    public void onClick (View v){
        if(v == btn) {
            intent = new Intent(Start_Userinfo2.this, Start_Shared.class);
            startActivity(intent);
        }
    }
}