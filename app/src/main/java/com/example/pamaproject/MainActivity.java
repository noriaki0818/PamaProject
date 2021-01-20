package com.example.pamaproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView IV;
    ImageButton btn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IV = (ImageView) findViewById(R.id.start_to_UserInfo);
        IV.setOnClickListener( this );
        btn = (ImageButton) findViewById(R.id.start_to_UserInfo2);
        btn.setOnClickListener( this );

    }
    @Override
    public void onClick (View v){
        if(v == IV){
            intent = new Intent(MainActivity.this, Start_Userinfo.class);
            startActivity(intent);
        }
        else if(v == btn) {
            intent = new Intent(MainActivity.this, Start_Userinfo2.class);
            startActivity(intent);
        }
    }
}