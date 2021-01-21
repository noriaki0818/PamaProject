package com.example.pamaproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Start_Userinfo extends AppCompatActivity implements View.OnClickListener {

    ImageButton next;
    EditText username;
    ImageButton man, noset, woman;
    Intent intent;
    private SQLiteDatabase db;
    private DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__userinfo);

        next = (ImageButton) findViewById(R.id.next_to_userInfo);
        username = (EditText) findViewById(R.id.username);
        man = (ImageButton) findViewById(R.id.user_bo_man);
        noset = (ImageButton) findViewById(R.id.user_bo_noset);
        woman = (ImageButton) findViewById(R.id.user_bo_woman);
        next.setOnClickListener( this );
        man.setOnClickListener(this);
        noset.setOnClickListener(this);
        woman.setOnClickListener(this);

    }
    @Override
    public void onClick (View v){

        String gender = "設定なし";
        String name = "noname";

        if (v == man){
            gender = "男";

        }
        if (v == noset){
            gender = "設定なし";

        }
        if (v == woman){
            gender = "女";

        }
        if(v == next){
            name = username.getText().toString();
//            データベースに挿入
            insertUserTable(name, gender);

            intent = new Intent(Start_Userinfo.this, Start_Babyinfo.class);
            startActivity(intent);

        }
    }
    public void insertUserTable(String Name, String Gender){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("Name", Name);
        values.put("Gender",Gender);
        db.insert("UserTable",null, values);

    }
}