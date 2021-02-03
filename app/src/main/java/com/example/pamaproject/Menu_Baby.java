package com.example.pamaproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Menu_Baby extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener{
    //    フッダー
    ImageView MENU_baby, MENU_help, MENU_share,
    //    フッダー
    toHome,
    //    赤ちゃんの画像
    baby, baby2, baby3, baby4, baby5, baby6, baby7, baby8, baby9;

    //赤ちゃんのボタン
    CardView babyic, babyic2, babyic3, babyic4, babyic5, babyic6, babyic7, babyic8, babyic9;
    //赤ちゃんの名前
    TextView
            babyname, babyname2, babyname3, babyname4, babyname5, babyname6, babyname7, babyname8, babyname9;

    Intent intent;
    DBHelper helper;

    int BabyCnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__baby);


        toHome = (ImageButton) findViewById(R.id.baby_bo_home);
        MENU_baby = (ImageButton) findViewById(R.id.baby_bo_baby);
        MENU_help = (ImageButton) findViewById(R.id.baby_bo_help);
        MENU_share = (ImageButton) findViewById(R.id.baby_bo_share);
        babyic = (CardView) findViewById(R.id.babyic);
        babyic2 = (CardView) findViewById(R.id.babyic2);
        babyic3 = (CardView) findViewById(R.id.babyic3);
        babyic4 = (CardView) findViewById(R.id.babyic4);
        babyic5 = (CardView) findViewById(R.id.babyic5);
        babyic6 = (CardView) findViewById(R.id.babyic6);
        babyic7 = (CardView) findViewById(R.id.babyic7);
        babyic8 = (CardView) findViewById(R.id.babyic8);
        babyic9 = (CardView) findViewById(R.id.babyic9);
        baby = (ImageView) findViewById(R.id.baby_bo_babyic);
        baby2 = (ImageView) findViewById(R.id.baby_bo_babyic2);
        baby3 = (ImageView) findViewById(R.id.baby_bo_babyic3);
        baby4 = (ImageView) findViewById(R.id.baby_bo_babyic4);
        baby5 = (ImageView) findViewById(R.id.baby_bo_babyic5);
        baby6 = (ImageView) findViewById(R.id.baby_bo_babyic6);
        baby7 = (ImageView) findViewById(R.id.baby_bo_babyic7);
        baby8 = (ImageView) findViewById(R.id.baby_bo_babyic8);
        baby9 = (ImageView) findViewById(R.id.baby_bo_babyic9);
        babyname = (TextView) findViewById(R.id.baby_babyname);
        babyname2 = (TextView) findViewById(R.id.baby_babyname2);
        babyname3 = (TextView) findViewById(R.id.baby_babyname3);
        babyname4 = (TextView) findViewById(R.id.baby_babyname4);
        babyname5 = (TextView) findViewById(R.id.baby_babyname5);
        babyname6 = (TextView) findViewById(R.id.baby_babyname6);
        babyname7 = (TextView) findViewById(R.id.baby_babyname7);
        babyname8 = (TextView) findViewById(R.id.baby_babyname8);
        babyname9 = (TextView) findViewById(R.id.baby_babyname9);

        toHome.setOnClickListener(this);
        MENU_baby.setOnClickListener(this);
        MENU_help.setOnClickListener(this);
        MENU_share.setOnClickListener(this);
        babyic.setOnClickListener(this);
        babyic2.setOnClickListener(this);
        babyic3.setOnClickListener(this);
        babyic4.setOnClickListener(this);
        babyic5.setOnClickListener(this);
        babyic6.setOnClickListener(this);
        babyic7.setOnClickListener(this);
        babyic8.setOnClickListener(this);
        babyic9.setOnClickListener(this);
//        長押し
        babyic.setOnLongClickListener(this);
        babyic2.setOnLongClickListener(this);
        babyic3.setOnLongClickListener(this);
        babyic4.setOnLongClickListener(this);
        babyic5.setOnLongClickListener(this);
        babyic6.setOnLongClickListener(this);
        babyic7.setOnLongClickListener(this);
        babyic8.setOnLongClickListener(this);
        babyic9.setOnLongClickListener(this);

        helper = new DBHelper(this);

        MENU_baby.setBackgroundColor(Color.WHITE);

        //画面に赤ちゃんの情報を表示
        BabyCnt = onGetChildData();
        System.out.println("赤ちゃんの数は" + BabyCnt + " です");

    }
    @Override
    public void onClick (View v){
//        ホームボタン
        if (v == toHome) {
            intent = new Intent(Menu_Baby.this, Home.class);
            startActivity(intent);
        }
//        フッダー
        if (v == MENU_help) {
            intent = new Intent(Menu_Baby.this, Menu_Help.class);
            startActivity(intent);
        }
        if (v == MENU_share) {
            intent = new Intent(Menu_Baby.this, Menu_Share.class);
            startActivity(intent);
        }
//        赤ちゃんの画像
        if (v == babyic && BabyCnt >= 1) {
            intent = new Intent(Menu_Baby.this, Home.class);
            intent.putExtra("CHILD_ID","1");
            startActivity(intent);

        }
        if (v == babyic2 && BabyCnt >= 2) {
            intent = new Intent(Menu_Baby.this, Home.class);
            intent.putExtra("CHILD_ID","2");
            startActivity(intent);

        }
        if (v == babyic3 && BabyCnt >= 3) {
            intent = new Intent(Menu_Baby.this, Home.class);
            intent.putExtra("CHILD_ID","3");
            startActivity(intent);

        }
        if (v == babyic4 && BabyCnt >= 4) {
            intent = new Intent(Menu_Baby.this, Home.class);
            intent.putExtra("CHILD_ID","4");
            startActivity(intent);

        }
        if (v == babyic5 && BabyCnt >= 5) {
            intent = new Intent(Menu_Baby.this, Home.class);
            intent.putExtra("CHILD_ID","5");
            startActivity(intent);

        }
        if (v == babyic6 && BabyCnt >= 6) {
            intent = new Intent(Menu_Baby.this, Home.class);
            intent.putExtra("CHILD_ID","6");
            startActivity(intent);

        }
        if (v == babyic7 && BabyCnt >= 7) {
            intent = new Intent(Menu_Baby.this, Home.class);
            intent.putExtra("CHILD_ID","7");
            startActivity(intent);

        }
        if (v == babyic8 && BabyCnt >= 8) {
            intent = new Intent(Menu_Baby.this, Home.class);
            intent.putExtra("CHILD_ID","8");
            startActivity(intent);

        }
        if (v == babyic9 && BabyCnt >= 9) {
            intent = new Intent(Menu_Baby.this, Home.class);
            intent.putExtra("CHILD_ID","9");
            startActivity(intent);

        }
        if (BabyCnt > 9) {
            Toast.makeText(this, "赤っちゃんが多すぎます", Toast.LENGTH_SHORT).show();
        }

//        赤ちゃん追加
        if (v == babyic && BabyCnt == 0) {
            intent = new Intent(Menu_Baby.this, Menu_Babyadd.class);
            intent.putExtra("CHILD_ID","1");
            intent.putExtra("USER_ID", OnSearchUSER_ID("1"));
            startActivity(intent);

        }
        if (v == babyic2 && BabyCnt == 1) {
            intent = new Intent(Menu_Baby.this, Menu_Babyadd.class);
            intent.putExtra("CHILD_ID","2");
            intent.putExtra("USER_ID", OnSearchUSER_ID("2"));
            startActivity(intent);

        }
        if (v == babyic3&& BabyCnt == 2) {
            intent = new Intent(Menu_Baby.this, Menu_Babyadd.class);
            intent.putExtra("CHILD_ID","3");
            intent.putExtra("USER_ID", OnSearchUSER_ID("3"));
            startActivity(intent);

        }
        if (v == babyic4 && BabyCnt == 3) {
            intent = new Intent(Menu_Baby.this, Menu_Babyadd.class);
            intent.putExtra("CHILD_ID","4");
            intent.putExtra("USER_ID", OnSearchUSER_ID("4"));
            startActivity(intent);

        }
        if (v == babyic5 && BabyCnt == 4) {
            intent = new Intent(Menu_Baby.this, Menu_Babyadd.class);
            intent.putExtra("CHILD_ID","5");
            intent.putExtra("USER_ID", OnSearchUSER_ID("5"));
            startActivity(intent);

        }
        if (v == babyic6 && BabyCnt == 5) {
            intent = new Intent(Menu_Baby.this, Menu_Babyadd.class);
            intent.putExtra("CHILD_ID","6");
            intent.putExtra("USER_ID", OnSearchUSER_ID("6"));

            startActivity(intent);

        }
        if (v == babyic7 && BabyCnt == 6) {
            intent = new Intent(Menu_Baby.this, Menu_Babyadd.class);
            intent.putExtra("CHILD_ID","7");
            intent.putExtra("USER_ID", OnSearchUSER_ID("7"));
            startActivity(intent);

        }
        if (v == babyic8 && BabyCnt == 7) {
            intent = new Intent(Menu_Baby.this, Menu_Babyadd.class);
            intent.putExtra("CHILD_ID","8");
            intent.putExtra("USER_ID", OnSearchUSER_ID("8"));
            startActivity(intent);

        }
        if (v == babyic9 && BabyCnt == 8) {
            intent = new Intent(Menu_Baby.this, Menu_Babyadd.class);
            intent.putExtra("CHILD_ID","9");
            intent.putExtra("USER_ID", OnSearchUSER_ID("9"));
            startActivity(intent);

        }
    }

    //    赤ちゃんの編集
    @Override
    public boolean onLongClick(View v) {

        if(BabyCnt == 0 ){
            Toast.makeText(this, "BabyCNTが0です。", Toast.LENGTH_LONG).show();
        }
        if (v == babyic && BabyCnt >= 1) {
            intent = new Intent(Menu_Baby.this, Menu_Babyedit.class);
            intent.putExtra("CHILD_ID", "1");
            intent.putExtra("USER_ID", OnSearchUSER_ID("1"));
            startActivity(intent);
        }
        if (v == babyic2 && BabyCnt >= 2 ) {
            intent = new Intent(Menu_Baby.this, Menu_Babyedit.class);
            intent.putExtra("CHILD_ID", "2");
            intent.putExtra("USER_ID", OnSearchUSER_ID("2"));
            startActivity(intent);
        }
        if (v == babyic3 && BabyCnt >= 3 ) {
            intent = new Intent(Menu_Baby.this, Menu_Babyedit.class);
            intent.putExtra("CHILD_ID", "3");
            intent.putExtra("USER_ID", OnSearchUSER_ID("3"));

            startActivity(intent);
        }
        if (v == babyic4 && BabyCnt >= 4 ) {
            intent = new Intent(Menu_Baby.this, Menu_Babyedit.class);
            intent.putExtra("CHILD_ID", "4");
            intent.putExtra("USER_ID", OnSearchUSER_ID("4"));
            startActivity(intent);
        }
        if (v == babyic5 && BabyCnt >= 5 ) {
            intent = new Intent(Menu_Baby.this, Menu_Babyedit.class);
            intent.putExtra("CHILD_ID", "5");
            intent.putExtra("USER_ID", OnSearchUSER_ID("5"));
            startActivity(intent);
        }
        if (v == babyic6 && BabyCnt >= 6 ) {
            intent = new Intent(Menu_Baby.this, Menu_Babyedit.class);
            intent.putExtra("CHILD_ID", "6");
            intent.putExtra("USER_ID", OnSearchUSER_ID("6"));
            startActivity(intent);
        }
        if (v == babyic7 && BabyCnt >= 7 ) {
            intent = new Intent(Menu_Baby.this, Menu_Babyedit.class);
            intent.putExtra("CHILD_ID", "7");
            intent.putExtra("USER_ID", OnSearchUSER_ID("7"));
            startActivity(intent);
        }
        if (v == babyic8 && BabyCnt >= 8 ) {
            intent = new Intent(Menu_Baby.this, Menu_Babyedit.class);
            intent.putExtra("CHILD_ID", "8");
            intent.putExtra("USER_ID", OnSearchUSER_ID("8"));
            startActivity(intent);
        }
        if (v == babyic9 && BabyCnt >= 9 ) {
            intent = new Intent(Menu_Baby.this, Menu_Babyedit.class);
            intent.putExtra("CHILD_ID", "9");
            intent.putExtra("USER_ID", OnSearchUSER_ID("9"));
            startActivity(intent);
        }

        return false;
    }
    public int onGetChildData(){
        System.out.println("onGetChildData");
        int Child_ID = 0;
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = null;
        int CNT = 0;
        babyic.setVisibility(View.VISIBLE);
        try {
            String[] getcols = {"Child_ID", "ID", "Baby_Name", "Baby_Gender", "Birth"};//0,1,2
            cs = db.query("BabyTable", getcols, null, null, null, null, null, null);
            if (cs.moveToFirst()){
                for (int cnt = 0; cnt < cs.getCount(); cnt++){
                    CNT = cnt + 1;
                    String NAME = cs.getString(2);
                    System.out.println("Child_ID" + cs.getInt(0) + "ID、" + cs.getInt(1) + "名前、" + cs.getString(2) + "性別、" + cs.getString(3) + "誕生日、" + cs.getString(4));

                    //赤ちゃんのじょうほうを表示する
                    babyic.setVisibility(View.VISIBLE);

                    if (cnt == 0) {
                        babyic2.setVisibility(View.VISIBLE);
                        baby.setImageResource(R.drawable.bo_babyic);
                        babyname.setVisibility(View.VISIBLE);
                        babyname.setText(NAME);
                    }
                    if (cnt == 1) {
                        babyic3.setVisibility(View.VISIBLE);
                        baby2.setImageResource(R.drawable.bo_babyic);
                        babyname2.setVisibility(View.VISIBLE);
                        babyname2.setText(NAME);
                    }
                    if (cnt == 2) {
                        babyic4.setVisibility(View.VISIBLE);
                        baby3.setImageResource(R.drawable.bo_babyic);
                        babyname3.setVisibility(View.VISIBLE);
                        babyname3.setText(NAME);
                    }
                    if (cnt == 3) {
                        babyic5.setVisibility(View.VISIBLE);
                        baby4.setImageResource(R.drawable.bo_babyic);
                        babyname4.setVisibility(View.VISIBLE);
                        babyname4.setText(NAME);
                    }
                    if (cnt == 4) {
                        babyic6.setVisibility(View.VISIBLE);
                        baby5.setImageResource(R.drawable.bo_babyic);
                        babyname5.setVisibility(View.VISIBLE);
                        babyname5.setText(NAME);
                    }
                    if (cnt == 5) {
                        babyic7.setVisibility(View.VISIBLE);
                        baby6.setImageResource(R.drawable.bo_babyic);
                        babyname6.setVisibility(View.VISIBLE);
                        babyname6.setText(NAME);
                    }
                    if (cnt == 6) {
                        babyic8.setVisibility(View.VISIBLE);
                        baby7.setImageResource(R.drawable.bo_babyic);
                        babyname7.setVisibility(View.VISIBLE);
                        babyname7.setText(NAME);
                    }
                    if (cnt == 7) {
                        babyic9.setVisibility(View.VISIBLE);
                        baby8.setImageResource(R.drawable.bo_babyic);
                        babyname8.setVisibility(View.VISIBLE);
                        babyname8.setText(NAME);
                    }
                    if(cnt == 8) {
                        baby9.setImageResource(R.drawable.bo_babyic);
                        babyname9.setVisibility(View.VISIBLE);
                        babyname9.setText(NAME);
                    }
                    if (cnt > 9){
                        Toast.makeText(this, "これ以上登録することはできません", Toast.LENGTH_SHORT).show();

                    }
                    cs.moveToNext();
                }

            }else if (Child_ID == 0 ){
                Toast.makeText(this, "子供がいません", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "どうゆうこと", Toast.LENGTH_SHORT).show();
            }
        } finally {
            cs.close();
            db.close();
        }
        System.out.println("カウントは" + CNT);
        return CNT;
    }


    public String OnSearchUSER_ID(String CHILD_ID){
        System.out.println("OnSaerchUSER_ID : Child_ID " + CHILD_ID);
        String ID = "1";
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = null;
        try {
            String[] getcols = {"ID"};//0,1,2取得してきたいもの
            String[] SearchKey = {CHILD_ID};//これで検索する
            cs = db.query("babyTable", getcols, "Child_ID = ?", SearchKey, null, null, null, null);
            if (cs.moveToFirst()){
                ID = cs.getString(0);//getcolsの選択
                System.out.println("MENU BABY IDは "+ ID);
            }else if (ID == "0"){
                System.out.println("メニューのOnSearchUSER_IDは　"+ ID);

            } else{
                System.out.println("ない");
            }
        }finally {
            cs.close();
            db.close();
        }
        return ID;
    }
}