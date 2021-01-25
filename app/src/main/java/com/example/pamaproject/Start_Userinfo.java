package com.example.pamaproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
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

    String gender = "設定なし";
    String name = "noname";
    int id = 1;

    private DBHelper helper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__userinfo);

        next = (ImageButton) findViewById(R.id.next_to_userInfo);
        username = (EditText) findViewById(R.id.username);
        man = (ImageButton) findViewById(R.id.user_bo_man);
        noset = (ImageButton) findViewById(R.id.user_bo_noset);
        woman = (ImageButton) findViewById(R.id.user_bo_woman);
        next.setOnClickListener(this);
        man.setOnClickListener(this);
        noset.setOnClickListener(this);
        woman.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == man) {
            gender = "男";
            man.setAlpha((float) 1.0);
            woman.setAlpha((float) 0.5);
            noset.setAlpha((float) 0.5);

        }
        if (v == noset) {
            gender = "設定なし";
            man.setAlpha((float) 0.5);
            woman.setAlpha((float) 0.5);
            noset.setAlpha((float) 1.0);

        }
        if (v == woman) {
            gender = "女";
            man.setAlpha((float) 0.5);
            woman.setAlpha((float) 1.0);
            noset.setAlpha((float) 0.5);

        }
        if (v == next) {
            if(helper == null){
                helper = new DBHelper(getApplicationContext());
            }
            name = username.getText().toString();
//            データベースに挿入
            insertUserTable(name, gender);

            intent = new Intent(Start_Userinfo.this, Start_Babyinfo.class);

            id = readUserID();
            String strid = String.valueOf(id);

            intent.putExtra("id", strid);

            startActivity(intent);

        }
    }

//    ユーザーテーブルに挿入
    public void insertUserTable(String Name, String Gender) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("Name", Name);
        values.put("Gender", Gender);
        db.insert("UserTable", null, values);

    }

//    ユーザーテーブルからIDを取得
    public int readUserID() {
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(
                "UserTable",
                new String[]{"ID"},//返り血
                name + " = ?",
                null,
                null,
                null,
                null
        );

        cursor.moveToFirst();
        int id = 0;
        for (int i = 0; i < cursor.getCount(); i++) {
            id = cursor.getInt(0);
            cursor.moveToNext();
        }
        cursor.close();

        return id;
    }
}