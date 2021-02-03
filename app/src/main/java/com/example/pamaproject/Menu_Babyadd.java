package com.example.pamaproject;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Menu_Babyadd extends AppCompatActivity implements View.OnClickListener{
    ImageView babyadd, boy, noset, girl;
    TextView birth;
    EditText babyname ;
    Intent intent;
    DBHelper helper;
    String CHILD_ID = null;
    String USER_ID = null;
    String BABY_NAME = null;
    String BABY_GENDER = null;
    String BIRTHDAY = null;

    // 日付設定時のリスナ作成
    DatePickerDialog.OnDateSetListener DateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(android.widget.DatePicker datePicker, int year,
                              int monthOfYear, int dayOfMonth) {

            // トーストとログ出力
            Toast.makeText(
                    Menu_Babyadd.this,
                    "year:" + year + " monthOfYear:" + monthOfYear
                            + " dayOfMonth:" + dayOfMonth, Toast.LENGTH_LONG)
                    .show();
            Log.d("DatePicker", "year:" + year + " monthOfYear:" + monthOfYear
                    + " dayOfMonth:" + dayOfMonth);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__babyadd);

        helper = new DBHelper(this);//これ絶対最初に書く←---------------------------------------------------------

        babyadd = (ImageView) findViewById(R.id.baby_add_bo_babyadd);
        boy = (ImageView) findViewById(R.id.baby_add_bo_boy);
        noset = (ImageView) findViewById(R.id.baby_add_bo_noset);
        girl = (ImageView) findViewById(R.id.baby_add_bo_girl);
        birth = (TextView) findViewById(R.id.baby_add_birth);
        babyname = (EditText) findViewById(R.id.baby_add_name);
        babyadd.setOnClickListener(this);
        boy.setOnClickListener(this);
        noset.setOnClickListener(this);
        girl.setOnClickListener(this);
        birth.setOnClickListener(this);

        boy.setAlpha((float) 0.3);
        girl.setAlpha((float) 0.3);
        noset.setAlpha((float) 0.3);

        birth.setText("誕生日");

        //            データベースからUserの ID を取得
        intent = getIntent();
        CHILD_ID = intent.getStringExtra("CHILD_ID");
        USER_ID = intent.getStringExtra("USER_ID");

        System.out.println("Child_IDは " + CHILD_ID + "　User_IDは　" + USER_ID);

        //入力画面外をタップしたら入力画面を閉じる（oncreateの一番最後に配置）
//        ↓↓↓ここにeditTextをセット
        babyname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    //キーボード非表示
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                }
            }
        });
//        ↑↑↑ここまでで
    }
    //        入力画面以外をタップしたらフォーカスを外す
    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        ↓↓↓適当なidを設定する（edittextのid以外）設定したidのレイアウトに　android:focusable="true"android:focusableInTouchMode="true"　を追加する
        babyadd.requestFocus();
        return super.onTouchEvent(event);
    }
    //    ここまで
    public void onClick (View v){
        //これも忘れずに
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        if(helper == null){
            helper = new DBHelper(getApplicationContext());
        }

        BABY_NAME = babyname.getText().toString();

        if (v == boy) {
            BABY_GENDER = "男";
            boy.setAlpha((float) 1.0);
            girl.setAlpha((float) 0.3);
            noset.setAlpha((float) 0.3);

        }
        if (v == noset) {
            BABY_GENDER = "設定なし";
            boy.setAlpha((float) 0.3);
            girl.setAlpha((float) 0.3);
            noset.setAlpha((float) 1.0);

        }
        if (v == girl) {
            BABY_GENDER = "女";
            boy.setAlpha((float) 0.3);
            girl.setAlpha((float) 1.0);
            noset.setAlpha((float) 0.3);

        }
        if(v == birth){
            //Calendarインスタンスを取得
            final Calendar date = Calendar.getInstance();

            //DatePickerDialogインスタンスを取得
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    Menu_Babyadd.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            //setした日付を取得して表示
                            month = month + 1;
                            birth.setText(String.format("%d 年 %02d 月 %02d 日", year, month, dayOfMonth));
                            BIRTHDAY = year + "年" + month + "月 " + dayOfMonth + "日";
                            System.out.println(BIRTHDAY);
                        }
                    },
                    date.get(Calendar.YEAR),
                    date.get(Calendar.MONTH),
                    date.get(Calendar.DATE)
            );
        }
        int cnt = 0;
        if (cnt == 0) {
            if (v == babyadd) {
                if (BABY_NAME == null || BABY_GENDER == null || BIRTHDAY == null) {
                    Toast.makeText(this, "すべての項目を入力してください", Toast.LENGTH_SHORT).show();

                }else if (CHILD_ID == null || USER_ID == null){
                    System.out.println("Child_ID UESR_IDにエラーがあります。");
                }
                else {
                    System.out.println("赤ちゃん追加画面　追加情報" + "Child_ID: " + CHILD_ID + "ID: " + USER_ID + "名前: "+ BABY_NAME + "性別: " + BABY_GENDER + "誕生日" + BIRTHDAY);
                    insertBabyTable(USER_ID, BABY_NAME, BABY_GENDER, BIRTHDAY);

                    intent = new Intent(Menu_Babyadd.this, Menu_Baby.class);
                    startActivity(intent);
                }
                cnt++;
            }
        }
    }

    //赤ちゃんテーブルにデータ保存
    public void insertBabyTable(String ID, String Baby_Name, String Baby_Gender, String Birth) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID", ID);
        cv.put("Baby_Name", Baby_Name);
        cv.put("Baby_Gender", Baby_Gender);
        cv.put("Birth", Birth);
        db.insert("BabyTable", null, cv);
    }
}