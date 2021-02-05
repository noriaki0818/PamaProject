package com.example.pamaproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
    TextView textView, textView2, textView3, textView4, textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);


        textView = (TextView) findViewById(R.id.articletext_title);
        textView2 = (TextView) findViewById(R.id.textView);
        textView3 = (TextView) findViewById(R.id.textView2);
        textView4 = (TextView) findViewById(R.id.textView3);
        textView5 = (TextView) findViewById(R.id.textView4);

        // インテントを取得
        Intent intent = getIntent();
        // インテントに保存されたデータを取得

        int da = intent.getIntExtra("list_item", 1);
        textView.setText("記事一覧");

        if (da == 1) {
            set1();
        }
        if (da == 2) {
            set2();
        }
        if (da == 3){
            set3();
        }
        if (da == 4){
            set4();
        }
        if (da == 5){
            set5();
        }
        if (da == 6){
            set6();
        }
        if (da == 7){
            set7();
        }
        if (da == 8){
            set8();
        }
        if (da == 9){
            set9();
        }
        if (da == 10){
            set10();
        }
        if (da == 11){
            set11();
        }
        if (da == 12){
            set12();
        }
    }



    @Override
    public void onClick(View v) {
        finish();
    }

    void set1() {
        textView2.setText("赤ちゃんが欲しがるだけ授乳しましょう。");
        textView3.setText("快適な室温と環境を保ちましょう。");
        textView4.setText("おむつはぬれたらすぐに取り替えましょう。");
        textView5.setText("窒息事故に気をつけましょう。");
    }

    void set2() {
        textView2.setText("生後4~6ヶ月記事");
        textView3.setText("あ");
        textView4.setText("い");
        textView5.setText("い");
    }

    void set3(){
        textView2.setText("生後7~9ヶ月記事");
        textView3.setText("あ");
        textView4.setText("い");
        textView5.setText("い");
    }

    void set4(){
        textView2.setText("生後10~12ヶ月記事");
        textView3.setText("あ");
        textView4.setText("い");
        textView5.setText("い");
    }

    void set5(){
        textView2.setText("生後1年1ヶ月~1年3ヶ月記事");
        textView3.setText("あ");
        textView4.setText("い");
        textView5.setText("い");
    }

    void set6(){
        textView2.setText("生後1年4ヶ月~1年6ヶ月記事");
        textView3.setText("あ");
        textView4.setText("い");
        textView5.setText("い");
    }

    void set7(){
        textView2.setText("生後1年7ヶ月~1年9ヶ月記事");
        textView3.setText("あ");
        textView4.setText("い");
        textView5.setText("い");
    }

    void set8(){
        textView2.setText("生後1年10ヶ月~1年12ヶ月記事");
        textView3.setText("あ");
        textView4.setText("い");
        textView5.setText("い");
    }

    void set9(){
        textView2.setText("生後2年1ヶ月~2年3ヶ月記事");
        textView3.setText("あ");
        textView4.setText("い");
        textView5.setText("い");
    }

    void set10(){
        textView2.setText("生後2年4ヶ月~2年6か月記事");
        textView3.setText("あ");
        textView4.setText("い");
        textView5.setText("い");
    }

    void set11(){
        textView2.setText("生後2年7ヶ月~2年9か月記事");
        textView3.setText("あ");
        textView4.setText("い");
        textView5.setText("い");
    }

    void set12(){
        textView2.setText("生後2年10ヶ月~2年12か月記事");
        textView3.setText("あ");
        textView4.setText("い");
        textView5.setText("い");
    }
}