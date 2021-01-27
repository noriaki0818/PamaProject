
package com.example.pamaproject;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Start_Userinfo extends AppCompatActivity implements View.OnClickListener {

    ImageButton next;
    EditText username = null;
    ImageButton man, noset, woman;
    Intent intent;
    String GENDER = null;
    String NAME = null;

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

        man.setAlpha((float) 0.5);
        woman.setAlpha((float) 0.5);
        noset.setAlpha((float) 0.5);

        //ヘルパーの準備
        helper = new DBHelper(this);

        //入力画面外をタップしたら入力画面を閉じる（oncreateの一番最後に配置）
//        ↓↓↓ここにeditTextをセット
        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
        next.requestFocus();
        return super.onTouchEvent(event);
    }
//    ここまで

    @Override
    public void onClick(View v) {
        //これも忘れずに
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        NAME = username.getText().toString();

        if (v == man) {
            GENDER = "男";
            man.setAlpha((float) 1.0);
            woman.setAlpha((float) 0.5);
            noset.setAlpha((float) 0.5);

        }
        if (v == noset) {
            GENDER = "設定なし";
            man.setAlpha((float) 0.5);
            woman.setAlpha((float) 0.5);
            noset.setAlpha((float) 1.0);

        }
        if (v == woman) {
            GENDER = "女";
            man.setAlpha((float) 0.5);
            woman.setAlpha((float) 1.0);
            noset.setAlpha((float) 0.5);

        }
        if (v == next) {
            if(GENDER == null || NAME == null) {
                Toast.makeText(this, "すべての項目を入力してください", Toast.LENGTH_SHORT).show();
            }else{
                NAME = username.getText().toString();
                Toast.makeText(this, NAME + "さん、" + "性別は"+ GENDER+ "を登録",Toast.LENGTH_SHORT).show();
                intent = new Intent(Start_Userinfo.this, Start_Babyinfo.class);
                intent.putExtra("username", NAME);
                intent.putExtra("usergender",GENDER);
                startActivity(intent);
            }
        }
    }
}