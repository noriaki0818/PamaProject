package com.example.pamaproject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
public abstract class Start_Complete extends AppCompatActivity implements View.OnClickListener{
    ImageButton btn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__complete);
        btn = (ImageButton) findViewById(R.id.Start_Complete_next);
        btn.setOnClickListener( this );
    }
    @Override
    public void onClick (View v){
        if(v == btn) {
            intent = new Intent(getApplication(), Home.class);
            startActivity(intent);
        }
    }
}





