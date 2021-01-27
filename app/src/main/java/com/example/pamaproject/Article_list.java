package com.example.pamaproject;

import android.content.Intent;
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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.List;

public class Article_list extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemClickListener {
    private DBHelper helper = null;
    ImageButton articleMenuBtn,
            Record, Diary, Article, Summary;
    Intent intent;


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

        //listの作成
        String[] list = {
                "生後1ヶ月におすすめの記事","生後2ヶ月におすすめの記事","生後3ヶ月におすすめの記事",
                "生後4ヶ月におすすめの記事","生後5ヶ月におすすめの記事","生後6ヶ月におすすめの記事",
                "生後7ヶ月におすすめの記事","生後8ヶ月におすすめの記事","生後9ヶ月におすすめの記事",
                "生後10ヶ月におすすめの記事","生後11ヶ月におすすめの記事","生後1年0ヶ月におすすめの記事",
                "生後1年1ヶ月におすすめの記事","生後1年2ヶ月におすすめの記事","生後1年3ヶ月におすすめの記事",
                "生後1年4ヶ月におすすめの記事","生後1年5ヶ月におすすめの記事","生後1年6ヶ月におすすめの記事",
                "生後1年7ヶ月におすすめの記事","生後1年8ヶ月におすすめの記事","生後1年9ヶ月におすすめの記事",
                "生後1年10ヶ月におすすめの記事","生後1年11ヶ月におすすめの記事","生後2年0ヶ月におすすめの記事",
                "生後2年1ヶ月におすすめの記事","生後2年2ヶ月におすすめの記事","生後2年3ヶ月におすすめの記事",
                "生後2年4ヶ月におすすめの記事","生後2年5ヶ月におすすめの記事","生後2年6ヶ月におすすめの記事",
                "生後2年7ヶ月におすすめの記事","生後2年8ヶ月におすすめの記事","生後2年9ヶ月におすすめの記事",
                "生後2年10ヶ月におすすめの記事","生後2年11ヶ月におすすめの記事",
        };


        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item,list);

        ((ListView)findViewById(R.id.article_listview)).setAdapter(adapter);

        ((ListView)findViewById(R.id.article_listview)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Article_list.this, Article.class);
                intent.putExtra("article_ID", list[position]);
                startActivity(intent);
            }
        });

        //ヘルパーの準備
        helper = new DBHelper(this);
        //データベースを取得
        SQLiteDatabase db = helper.getWritableDatabase();

        try {
            Toast.makeText(this, "DBに接続完了", Toast.LENGTH_SHORT).show();

        }finally {
            db.close();
        }

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