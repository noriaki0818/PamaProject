    package com.example.pamaproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Article_list extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemClickListener {
    private DBHelper helper ;
    ImageButton articleMenuBtn,
            Record, Diary, Article, Summary;

    private static final String[] article_title = {
            "生後0~3ヶ月におすすめの記事","生後4~6ヶ月におすすめの記事","生後7~9ヶ月におすすめの記事",
            "生後10~12ヶ月におすすめの記事","生後1年1~3ヶ月におすすめの記事","生後1年4~6ヶ月におすすめの記事",
            "生後1年7~9ヶ月におすすめの記事","生後1年10~12ヶ月におすすめの記事","生後2年1~3ヶ月におすすめの記事",
            "生後2年4~6ヶ月におすすめの記事","生後2年7~9ヶ月におすすめの記事","生後2年10~12ヶ月におすすめの記事"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);

        //フッダー
        Record = (ImageButton) findViewById(R.id.home_bo_record);
        Diary = (ImageButton) findViewById(R.id.home_bo_diary);
        Article = (ImageButton) findViewById(R.id.home_bo_article);
        Summary = (ImageButton) findViewById(R.id.home_bo_summary);
        Record.setOnClickListener(this);
        Diary.setOnClickListener(this);
        Article.setOnClickListener(this);
        Summary.setOnClickListener(this);
        //ボタンの色を変える
        Article.setBackgroundColor(Color.WHITE);
        //メニューボタンの追加
        articleMenuBtn = (ImageButton) findViewById(R.id.article_menu);
        articleMenuBtn.setOnClickListener( this );

        ListView list = (ListView)findViewById(R.id.article_listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,article_title);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listview = (ListView)parent;
                String item = (String)listview.getItemAtPosition(position);

                Intent intent = new Intent(getApplication(),Article.class);

                if (position == 0){
                    intent.putExtra("list_item",1);
                    startActivity(intent);
                }
                if (position == 1){
                    intent.putExtra("list_item",2);
                    startActivity(intent);
                }
                if (position == 2){
                    intent.putExtra("list_item",3);
                    startActivity(intent);
                }
                if (position == 3){
                    intent.putExtra("list_item",4);
                    startActivity(intent);
                }
                if (position == 4){
                    intent.putExtra("list_item",5);
                    startActivity(intent);
                }
                if (position == 5){
                    intent.putExtra("list_item",6);
                    startActivity(intent);
                }
                if (position == 6){
                    intent.putExtra("list_item",7);
                    startActivity(intent);
                }
                if (position == 7){
                    intent.putExtra("list_item",8);
                    startActivity(intent);
                }
                if (position == 8){
                    intent.putExtra("list_item",9);
                    startActivity(intent);
                }
                if (position == 9){
                    intent.putExtra("list_item",10);
                    startActivity(intent);
                }
                if (position == 10){
                    intent.putExtra("list_item",11);
                    startActivity(intent);
                }
                if (position == 11){
                    intent.putExtra("list_item",12);
                    startActivity(intent);
                }
                if (position == 12){
                    intent.putExtra("list_item",13);
                    startActivity(intent);
                }


            }
        });


//        ((ListView)findViewById(R.id.article_listview)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                ListView listView = (ListView)parent;
//                Intent intent = new Intent(getApplication(), Article.class);
//                intent.putExtra("article_ID", listView.getItemAtPosition(position).toString());
//                startActivity(intent);
//            }
//        });

    }


    //各画面遷移
    @Override
    public void onClick(View view) {
        Intent intent;
        if(view == Diary){
            intent = new Intent(this, Nikki.class);
            startActivity(intent);
        }
        if(view == Record){
            intent = new Intent(this,Home.class);
            startActivity(intent);
        }
        if(view == Summary){
            intent = new Intent(this,Home_summary.class);
            startActivity(intent);
        }
        if (view == articleMenuBtn){
            intent = new Intent(this,Menu_Baby.class);
            startActivity(intent);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }

}