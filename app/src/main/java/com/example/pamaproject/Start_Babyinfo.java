package com.example.pamaproject;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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

public class Start_Babyinfo extends AppCompatActivity implements View.OnClickListener{
    TextView birth;
    ImageView start;
    ImageView boy, noset, girl;
    EditText babyname;
    Intent intent;
    private SQLiteDatabase db;
    private DBHelper helper;

    String BIRTHDAY = null;
    String BABY_GENDER = null;
    String BABY_NAME = null;
    int CHILD_ID = 0;
    int USER_ID = 1;
    String USER_NAME = null;
    String USER_GENDER = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__babyinfo);

        helper = new DBHelper(this);//これ絶対最初に書く←---------------------------------------------------------

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

        boy.setAlpha((float) 0.3);
        girl.setAlpha((float) 0.3);
        noset.setAlpha((float) 0.3);
        intent = getIntent();

        // 日付設定時のリスナ作成
        DatePickerDialog.OnDateSetListener DateSetListener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(android.widget.DatePicker datePicker, int year,
                                  int monthOfYear, int dayOfMonth) {

                // トーストとログ出力
                Toast.makeText(
                        Start_Babyinfo.this,
                        "year:" + year + " monthOfYear:" + monthOfYear
                                + " dayOfMonth:" + dayOfMonth, Toast.LENGTH_LONG)
                        .show();
                Log.d("DatePicker", "year:" + year + " monthOfYear:" + monthOfYear
                        + " dayOfMonth:" + dayOfMonth);
            }
        };

        //            データベースからUserの ID を取得
        USER_NAME = intent.getStringExtra("username");//キーを間違いないよウニ←←←←←←←←←←←←←←←←←←←←←←←
        USER_GENDER = intent.getStringExtra("usergender");

        birth.setText("誕生日を入力してください");

        onSaveUser(USER_NAME, USER_GENDER);
        USER_ID = onSearch_ID(USER_NAME);
        System.out.println(USER_NAME + "さん、性別は" + USER_GENDER + "　ID、" + USER_ID + "です。");

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
        start.requestFocus();
        return super.onTouchEvent(event);
    }
    //    ここまで

    @Override
    public void onClick (View v) {
        //これも忘れずに
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        if (helper == null) {
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
        if (v == birth) {
            //Calendarインスタンスを取得
            final Calendar date = Calendar.getInstance();

            //DatePickerDialogインスタンスを取得
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    Start_Babyinfo.this,
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

            //dialogを表示
            datePickerDialog.show();
        }

        int cnt = 0;
        if (cnt == 0) {
            if (v == start) {
                System.out.println("赤ちゃん登録　情報" + "Child_ID: " + CHILD_ID + "　ID: " + USER_ID + "　名前: "+ BABY_NAME + "　性別: " + BABY_GENDER + "　誕生日" + BIRTHDAY);
                if (USER_ID == 0 || BABY_NAME == null || BABY_GENDER == null || BIRTHDAY == null) {
                    Toast.makeText(this, "すべての項目を入力してください", Toast.LENGTH_SHORT).show();

                } else {
                    insertBabyTable(USER_ID, BABY_NAME, BABY_GENDER, BIRTHDAY);

                    CHILD_ID = ongetChild_ID(BABY_NAME);
                    intent = new Intent(Start_Babyinfo.this, Home.class);
                    intent.putExtra("child_id", CHILD_ID);//ホームにChild_IDを渡す
                    startActivity(intent);
                }
                cnt++;
            }
        }
    }


    //赤ちゃんテーブルにデータ保存
    public void insertBabyTable(int ID, String Baby_Name, String Baby_Gender, String Birth) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", ID);
        values.put("Baby_Name", Baby_Name);
        values.put("Baby_Gender", Baby_Gender);
        values.put("Birth", Birth);
        db.insert("BabyTable", null, values);
    }
    //    CHILD_IDを取得
    public int ongetChild_ID(String babyname){
        int Child_ID = 0;
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = null;
        try {
            String[] getcols = {"Child_ID", "ID", "Baby_Name", "Baby_Gender", "Birth"};//0,1,2
            String[] SearchKey = {babyname};
            cs = db.query("BabyTable", getcols, "Baby_Name = ?", SearchKey, null, null, null, null);
            if (cs.moveToFirst()){
                Child_ID = cs.getInt(0);
                Toast.makeText(this, cs.getString(2) + "さんを登録", Toast.LENGTH_SHORT).show();
                System.out.println("Child_ID"+ cs.getInt(0) + "ID、" + cs.getInt(1) + "名前、" + cs.getString(2) + "性別、" + cs.getString(3) + "誕生日、" + cs.getString(4));

            } else if (Child_ID == 0){
                Toast.makeText(this, "ID取れてない", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(this, "いみわかんね2", Toast.LENGTH_SHORT).show();
            }
        } finally {
            cs.close();
            db.close();
        }
        return Child_ID;
    }
    //    ユーザーを登録
    public void onSaveUser(String name, String gender) {
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put("Name", name);
            cv.put("Gender", gender);
            db.insert("UserTable", null, cv);
            Toast.makeText(this, name + "さんを登録しました。", Toast.LENGTH_SHORT).show();

        } finally {
            db.close();
        }
    }
    //    ユーザーIDを取得
    public int onSearch_ID(String name) {
        int ID = 0;
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = null;
        try {
            String[] getcols = {"ID", "Name", "Gender"};//0,1,2取得してきたいもの
            String[] SearchKey = {name};//これで検索する
            cs = db.query("UserTable", getcols, "Name = ?", SearchKey, null, null, null, null);
            if (cs.moveToFirst()){
                ID = cs.getInt(0);//getcolsの選択
                Toast.makeText(this, cs.getString(1) + "さん"+ cs.getString(2) +"のIDは" + ID, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "いみわかんね", Toast.LENGTH_SHORT).show();
            }
        }finally {
            cs.close();
            db.close();
        }
        return ID;
    }
}