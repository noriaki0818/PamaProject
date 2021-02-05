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


        String[] list = {
                "生後1~3ヶ月におすすめの記事","生後4~6ヶ月におすすめの記事","生後7~9ヶ月におすすめの記事",
                "生後10~12ヶ月におすすめの記事","生後1年1~3ヶ月におすすめの記事","生後1年4~6ヶ月におすすめの記事",
                "生後1年7~10ヶ月におすすめの記事","生後1年11~2年1ヶ月におすすめの記事","生後2年2~4ヶ月におすすめの記事",
                "生後2年5~7ヶ月におすすめの記事","生後2年8~11ヶ月におすすめの記事"
        };
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item,list);
        ((ListView)findViewById(R.id.article_listview)).setAdapter(adapter);
        ((ListView)findViewById(R.id.article_listview)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView)parent;
                Intent intent = new Intent(getApplication(), Article.class);
                intent.putExtra("article_ID", listView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });




//        Cursor cs = null;
//        try {
//            cs = db.query("ArticleTable", cols, null, null, null, null, null, null);
//            cs.moveToFirst();
//            //layout
//            int db_layout = android.R.layout.simple_expandable_list_item_2;
//            //String from
//            String[]from = {DBHelper.COLUMN_NAME,DBHelper.COLUMN_TEXT};
//            //int to
//            int[] to = new int[]{android.R.id.text1,android.R.id.text2};
//            adapter = new SimpleCursorAdapter(this,db_layout,cs,from,to,0);
//
//            listView.setAdapter(adapter);
//
//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    ListView listView1 = (ListView)parent;
//                    Cursor item = (Cursor)listView1.getItemAtPosition(position);
//                    String string = item.getString(
//                            item.getColumnIndex(DBHelper.COLUMN_ID));
//
//                    Intent intent = new Intent(Article_list.this, Article.class);
//                    intent.putExtra("SELECTED_DATA",string);
//                    startActivity(intent);
//
//                }
//            });
//
//        }finally {
//            cs.close();
//            db.close();
//        }
//
//

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