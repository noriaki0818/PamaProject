package com.example.pamaproject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ImageView;
public class Start_Shared extends AppCompatActivity implements View.OnClickListener{
    ImageView view;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__shared);
        view = (ImageView) findViewById(R.id.Start_Shared_next);
        view.setOnClickListener( this );
    }
    @Override
    public void onClick (View v){
        if(v == view) {
            intent = new Intent(getApplication(), Start_Complete.class);
            startActivity(intent);
        }
    }
}