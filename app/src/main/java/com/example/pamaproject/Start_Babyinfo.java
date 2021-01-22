package com.example.pamaproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.pamaproject.Dao.Baby_TABLE;

public class Start_Babyinfo extends AppCompatActivity implements View.OnClickListener{

    TextView birth;
    ImageView start;
    ImageView boy, noset, girl;
    EditText babyname;
    Intent intent;
    private SQLiteDatabase db;
    private DBHelper helper;

    String birthday = "";
    int UserID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__babyinfo);

        start = (ImageView) findViewById(R.id.next_to_userInfo);
        boy = (ImageView) findViewById(R.id.baby_boy);
        noset = (ImageView) findViewById(R.id.baby_none);
        girl = (ImageView) findViewById(R.id.baby_girl);
        birth = (TextView) findViewById(R.id.baby_birth);
        babyname = (EditText) findViewById(R.id.babyname);
        start.setOnClickListener( this );
        boy.setOnClickListener(this);
        noset.setOnClickListener(this);
        girl.setOnClickListener(this);
        birth.setOnClickListener(this);


    }
    @Override
    public void onClick (View v){
        String gender = "設定なし";
        String name = "noname";

        name = babyname.getText().toString();

        if (v == boy) {
            gender = "男";
            boy.setAlpha((float) 1.0);
            girl.setAlpha((float) 0.5);
            noset.setAlpha((float) 0.5);

        }
        if (v == noset) {
            gender = "設定なし";
            boy.setAlpha((float) 0.5);
            girl.setAlpha((float) 0.5);
            noset.setAlpha((float) 1.0);

        }
        if (v == girl) {
            gender = "女";
            boy.setAlpha((float) 0.5);
            girl.setAlpha((float) 1.0);
            noset.setAlpha((float) 0.5);

        }
        if(v == birth){
            intent = new Intent(Start_Babyinfo.this, BirthNP.class);
            startActivity(intent);

            intent = getIntent();
            birthday = intent.getStringExtra("birthday");
            System.out.println("誕生日"+ birthday);

        }
        if(v == start) {
            name = babyname.getText().toString();
//            データベースに挿入
            intent = getIntent();
            String strid = intent.getStringExtra("id");
            int id = Integer.parseInt(strid);

            insertBabyTable(id, name, gender, birthday);

            intent = new Intent(Start_Babyinfo.this, Home.class);
            startActivity(intent);
        }
    }
    //赤ちゃんテーブルデータ保存
    public void insertBabyTable(int ID, String Baby_Name, String Baby_Gender, String Birth) {
        ID = 1;
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        //IDを取ってくる処理を書く
        values.put("ID", ID);
        values.put("Baby_Name", Baby_Name);
        values.put("Baby_Gender", Baby_Gender);
        values.put("Birth", Birth);

        db.insert(Baby_TABLE, null, values);

    }

}