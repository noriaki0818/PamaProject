package com.example.pamaproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Article extends AppCompatActivity implements View.OnClickListener {
    private DBHelper helper = null;
    ImageButton articleMenuBtn;
    protected String strData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        //メニューの追加
        articleMenuBtn = (ImageButton)findViewById(R.id.article_menu2);
        articleMenuBtn.setOnClickListener( this );

//        String strName = "";
//        String strText = "";
//
//        SQLiteDatabase db = helper.getWritableDatabase();
//        try {
//            Toast.makeText(this, "DBに接続完了", Toast.LENGTH_SHORT).show();
//
//        }finally {
//            db.close();
//        }
//
//        String strSQL = "SELECT Article_Name, Article_text FROM ArticleTable WHERE Article_ID = " + strData;
//        Cursor cursor = db.rawQuery(strSQL, null);
//
///*
//        Cursor cursor = db.query(DatabaseOpenHelper.TABLE_NAME,
//                new String[] {
//                        DatabaseOpenHelper.COLUMN_NAME,
//                        DatabaseOpenHelper.COLUMN_PRICE },
//                DatabaseOpenHelper.COLUMN_ID + "='" + strData + "'",
//                null, null, null, null);
//*/
//
////        while (cursor.moveToNext()){
////            strName = cursor.getString(
////                    cursor.getColumnIndex(DBHelper.COLUMN_NAME));
////            strText = cursor.getString(
////                    cursor.getColumnIndex(DBHelper.COLUMN_TEXT));
////        }
//
//        ListView listView = (ListView)findViewById(R.id.article_list2);
//        TextView textView = (TextView)findViewById(R.id.textView4);
//        textView.setText(strData);

    }

    @Override
    public void onClick(View v) {
        if (v == articleMenuBtn){
            Intent intent = new Intent(this,Menu_Baby.class);
            startActivity(intent);
        }
    }
}
