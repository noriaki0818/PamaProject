package com.example.pamaproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class Home extends AppCompatActivity  implements View.OnClickListener {
    TextView day, passingday, babyname,
            diary;//日記入力ボタン、表示

    LinearLayout meallist, sleeplist, excretionlist, hospitallist, bodyhealthlist; //ボタンリスト

    ImageButton daybefore, daynext, photo, menu,
            bo_babylist, bo_meallist, bo_sleeplist, bo_excretionlist, bo_hospitallist, bo_bodyhealthlist, bo_milkwatch, //リスト一覧
            Record, Diary, Article, Summary, //フッダー
            milk1, milk2, meal, drink, babyfood, snack, milk3, //食事リスト
            bath, getup, sleep, //睡眠リスト
            weight, height, temperature, //身体リスト
            medicine, preventional, hospital, lnjury, rash, vomit, cough, //病院リスト
            both, pee, poo; //排泄リスト

    ImageView babypic,//赤ちゃんの画像
            mealBG, sleepBG, bodyhealthBG, hospitalBG, excretionBG, //リストバックグラウンド
            background; //バックグラウンド

    Intent intent;

    private DBHelper helper;
    private static SQLiteDatabase db;

    int CHILD_ID;

    //しょうや ↓
    //記録時間
    String kirokujikan;

    //listview変数設定
    ListView recodelist2;

    //表示したいの内容のlist
    ArrayList<String> time = new ArrayList<>();
    String[] times = time.toArray(new String[time.size()]);

    ArrayList<Integer> ic = new ArrayList<>();


    ArrayList<String> syousai = new ArrayList<>();
    String[] syousais = syousai.toArray(new String[syousai.size()]);


    //しょうや ↑




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //記録した時間のリストに追加
        kirokujikan=kirokutime();
        time.add(kirokujikan);

        ic.add(R.drawable.milk2);
        int[] ics = new int[ic.size()];
        for (int i=0; i<ic.size(); i++) {
            ics[i] = ic.get(i);
        }

        //記録を表示するリストしょうや
        recodelist2 = (ListView)findViewById(R.id.recordlist2) ;
        BaseAdapter adapter = new Home_BaseAdapter(this.getApplicationContext(),
                R.layout.list_items, times, ics, syousais);
        recodelist2.setAdapter(adapter);



        //child_idの入力
        CHILD_ID = 1;

        //テキスト
        day = (TextView) findViewById(R.id.home_text_day);
        passingday = (TextView) findViewById(R.id.home_text_passingdate);
        babyname = (TextView) findViewById(R.id.textview_babyname);
        //赤ちゃん画像
        babypic = (ImageView) findViewById(R.id.home_babypic);
        //日記入力ボタン、表示
        diary = (TextView) findViewById(R.id.bo_diary);
        //ヘッダー
        daybefore = (ImageButton) findViewById(R.id.home_bo_daybefore);
        daynext = (ImageButton) findViewById(R.id.home_bo_nextday);
        photo = (ImageButton) findViewById(R.id.home_photo);
        menu = (ImageButton) findViewById(R.id.home_menu);
        //ボタンリスト
        bo_babylist = (ImageButton) findViewById(R.id.bo_babylist);
        bo_meallist = (ImageButton) findViewById(R.id.bo_meallist);
        bo_sleeplist = (ImageButton) findViewById(R.id.bo_sleeplist);
        bo_excretionlist = (ImageButton) findViewById(R.id.bo_excretionlist);
        bo_hospitallist = (ImageButton) findViewById(R.id.bo_hospitallist);
        bo_bodyhealthlist = (ImageButton) findViewById(R.id.bo_bodyhealthlist);
        bo_milkwatch = (ImageButton) findViewById(R.id.bo_milkwatch);
        //リスト
        meallist = (LinearLayout) findViewById(R.id.meallist);
        sleeplist = (LinearLayout) findViewById(R.id.sleeplist);
        excretionlist = (LinearLayout) findViewById(R.id.excretionlist);
        hospitallist = (LinearLayout) findViewById(R.id.hospitallist);
        bodyhealthlist = (LinearLayout) findViewById(R.id.bodyhealthlist);
        //フッダー
        Record = (ImageButton) findViewById(R.id.home_bo_record);
        Diary = (ImageButton) findViewById(R.id.home_bo_diary);
        Article = (ImageButton) findViewById(R.id.home_bo_article);
        Summary = (ImageButton) findViewById(R.id.home_bo_summary);
        //食事リスト
        milk1 = (ImageButton) findViewById(R.id.milk1);
        milk2 = (ImageButton) findViewById(R.id.milk2);
        meal = (ImageButton) findViewById(R.id.meal);
        drink = (ImageButton) findViewById(R.id.drink);
        babyfood = (ImageButton) findViewById(R.id.babyfood);
        snack = (ImageButton) findViewById(R.id.snack);
        milk3 = (ImageButton) findViewById(R.id.milk3);
        //睡眠リスト
        bath = (ImageButton) findViewById(R.id.bath);
        getup = (ImageButton) findViewById(R.id.getup);
        sleep = (ImageButton) findViewById(R.id.sleep);
        //身体リスト
        weight = (ImageButton) findViewById(R.id.weight);
        height = (ImageButton) findViewById(R.id.height);
        temperature = (ImageButton) findViewById(R.id.temperature);
        //病院リスト
        medicine = (ImageButton) findViewById(R.id.medicine);
        preventional = (ImageButton) findViewById(R.id.preventional);
        hospital = (ImageButton) findViewById(R.id.hospital);
        lnjury = (ImageButton) findViewById(R.id.lnjury);
        rash = (ImageButton) findViewById(R.id.rash);
        vomit = (ImageButton) findViewById(R.id.vomit);
        cough = (ImageButton) findViewById(R.id.cough);
        //排泄リスト
        both = (ImageButton) findViewById(R.id.both);
        pee = (ImageButton) findViewById(R.id.pee);
        poo = (ImageButton) findViewById(R.id.poo);
        //バックグラウンド
        background = (ImageView) findViewById(R.id.background);
        //リストバックグラウンド
        mealBG = (ImageView) findViewById(R.id.meallistbg);
        sleepBG = (ImageView) findViewById(R.id.sleeplistbg);
        bodyhealthBG = (ImageView) findViewById(R.id.bodyhealthlistbg);
        hospitalBG = (ImageView) findViewById(R.id.hospitallistbg);
        excretionBG = (ImageView) findViewById(R.id.excretionlistbg);





        diary.setOnClickListener(this);
        daybefore.setOnClickListener(this);
        daynext.setOnClickListener(this);
        photo.setOnClickListener(this);
        menu.setOnClickListener(this);
        bo_babylist.setOnClickListener(this);
        bo_meallist.setOnClickListener(this);
        bo_sleeplist.setOnClickListener(this);
        bo_excretionlist.setOnClickListener(this);
        bo_hospitallist.setOnClickListener(this);
        bo_bodyhealthlist.setOnClickListener(this);
        bo_milkwatch.setOnClickListener(this);
        Record.setOnClickListener(this);
        Diary.setOnClickListener(this);
        Article.setOnClickListener(this);
        Summary.setOnClickListener(this);
        milk1.setOnClickListener(this);
        milk2.setOnClickListener(this);
        meal.setOnClickListener(this);
        drink.setOnClickListener(this);
        babyfood.setOnClickListener(this);
        snack.setOnClickListener(this);
        milk3.setOnClickListener(this);
        bath.setOnClickListener(this);
        getup.setOnClickListener(this);
        sleep.setOnClickListener(this);
        weight.setOnClickListener(this);
        height.setOnClickListener(this);
        temperature.setOnClickListener(this);
        medicine.setOnClickListener(this);
        preventional.setOnClickListener(this);
        hospital.setOnClickListener(this);
        lnjury.setOnClickListener(this);
        rash.setOnClickListener(this);
        vomit.setOnClickListener(this);
        cough.setOnClickListener(this);
        both.setOnClickListener(this);
        pee.setOnClickListener(this);
        poo.setOnClickListener(this);
        background.setOnClickListener(this);

        //ボタンの色を変える
        Record.setBackgroundColor(Color.WHITE);

        //テキスト
        day.setText("2021/8/18");
        passingday.setText("218");
        babyname.setText("のりくん");

        //赤ちゃんの画像
        photo.setImageResource(R.drawable.abe);

    }

    @Override
    public void onClick(View view) {

//        時間の取得
        String nowTime = getNowDate();

        //ヘッダー
        if (view == daybefore) {
            //前日にする
        }
        if (view == daynext) {
            //次の日にする
        }
        if (view == photo) {
            //赤ちゃんの画像
            intent = new Intent();
            startActivity(intent);
        }
        if (view == menu) {
            //メニュー
            intent = new Intent(Home.this, Menu_Baby.class);
            startActivity(intent);
        }

        //日記入力
        if (view == diary) {
            //日記に飛ぶ
            intent = new Intent(Home.this, Nikki.class);
            startActivity(intent);
        }

        //フッダーリスト
        if (view == Diary) {
            //日記画面に飛ぶ
            intent = new Intent(Home.this, Nikki.class);
            startActivity(intent);
        }
        if (view == Article) {
            //記事画面に飛ぶ
            intent = new Intent(Home.this, Article.class);
            startActivity(intent);
        }
        if (view == Summary) {
            //まとめ画面に飛ぶ
            intent = new Intent(Home.this, Home_summary.class);
            startActivity(intent);
        }

        //ボタンリスト
        if (view == bo_meallist) {
            //食事リスト
            bo_meallist.setVisibility(View.INVISIBLE);
            meallist.setVisibility(View.VISIBLE);
            mealBG.setVisibility(View.VISIBLE);
            background.setVisibility(View.VISIBLE);
        }
        if (view == bo_sleeplist) {
            //睡眠リスト
            bo_sleeplist.setVisibility(View.INVISIBLE);
            sleeplist.setVisibility(View.VISIBLE);
            sleepBG.setVisibility(View.VISIBLE);
            background.setVisibility(View.VISIBLE);
        }
        if (view == bo_excretionlist) {
            //排泄リスト
            bo_excretionlist.setVisibility(View.INVISIBLE);
            excretionlist.setVisibility(View.VISIBLE);
            excretionBG.setVisibility(View.VISIBLE);
            background.setVisibility(View.VISIBLE);
        }
        if (view == bo_hospitallist) {
            //病院リスト
            bo_hospitallist.setVisibility(View.INVISIBLE);
            hospitallist.setVisibility(View.VISIBLE);
            hospitalBG.setVisibility(View.VISIBLE);
            background.setVisibility(View.VISIBLE);
        }
        if (view == bo_bodyhealthlist) {
            //身体リスト
            bo_bodyhealthlist.setVisibility(View.INVISIBLE);
            bodyhealthlist.setVisibility(View.VISIBLE);
            bodyhealthBG.setVisibility(View.VISIBLE);
            background.setVisibility(View.VISIBLE);
        }
        if (view == bo_milkwatch) {
            //ミルクウォッチ

        }

        //食事リスト
        if (view == milk1) {
            //母乳

        }
        if (view == milk2) {
            //ミルク
            insertFoodtable(CHILD_ID, 7, nowTime);






        }
        if (view == meal) {
            //ごはん
            insertFoodtable(CHILD_ID, 8, nowTime);
        }
        if (view == drink) {
            //飲み物
            insertFoodtable(CHILD_ID, 9, nowTime);
        }
        if (view == babyfood) {
            //離乳食
            insertFoodtable(CHILD_ID, 10, nowTime);
        }
        if (view == snack) {
            //おやつ
            insertFoodtable(CHILD_ID, 11, nowTime);
        }
        if (view == milk3) {
            //搾乳
            insertFoodtable(CHILD_ID, 12, nowTime);
        }

        //睡眠リスト
        if (view == sleep) {
            //寝る
            insertSleeptable(CHILD_ID, 13, nowTime);
        }
        if (view == getup) {
            //起きる
            insertSleeptable(CHILD_ID, 14, nowTime);
        }
        if (view == bath) {
            //風呂
            insertSleeptable(CHILD_ID, 15, nowTime);
        }

        //身体リスト
        if (view == temperature) {
            //体温
            insertBodyhealthtable(CHILD_ID, 26, nowTime);
        }
        if (view == height) {
            //身長
            insertBodyhealthtable(CHILD_ID, 27, nowTime);
        }
        if (view == weight) {
            //体重
            insertBodyhealthtable(CHILD_ID, 28, nowTime);
        }

        //病院リスト
        if (view == cough) {
            //せき
            insertHospitaltable(CHILD_ID, 19, nowTime);
        }
        if (view == vomit) {
            //げろ
            insertHospitaltable(CHILD_ID, 20, nowTime);
        }
        if (view == rash) {
            //発疹
            insertHospitaltable(CHILD_ID, 21, nowTime);
        }
        if (view == lnjury) {
            //けが
            insertHospitaltable(CHILD_ID, 22, nowTime);
        }
        if (view == hospital) {
            //病院
            insertHospitaltable(CHILD_ID, 23, nowTime);
        }
        if (view == preventional) {
            //予防接種
            insertHospitaltable(CHILD_ID, 24, nowTime);
        }
        if (view == medicine) {
            //薬
            insertHospitaltable(CHILD_ID, 25, nowTime);
        }

        //排泄リスト
        if (view == poo) {
            //うんこ
            insertExcretiontable(CHILD_ID, 16, nowTime);
        }
        if (view == pee) {
            //尿
            insertExcretiontable(CHILD_ID, 17, nowTime);
        }
        if (view == both) {
            //両方
            insertExcretiontable(CHILD_ID, 18, nowTime);
        }

        //バックグラウンド
        if (view == background) {
            meallist.setVisibility(View.INVISIBLE);
            sleeplist.setVisibility(View.INVISIBLE);
            excretionlist.setVisibility(View.INVISIBLE);
            hospitallist.setVisibility(View.INVISIBLE);
            bodyhealthlist.setVisibility(View.INVISIBLE);
            mealBG.setVisibility(View.INVISIBLE);
            sleepBG.setVisibility(View.INVISIBLE);
            bodyhealthBG.setVisibility(View.INVISIBLE);
            hospitalBG.setVisibility(View.INVISIBLE);
            excretionBG.setVisibility(View.INVISIBLE);
            bo_meallist.setVisibility(View.VISIBLE);
            bo_sleeplist.setVisibility(View.VISIBLE);
            bo_excretionlist.setVisibility(View.VISIBLE);
            bo_hospitallist.setVisibility(View.VISIBLE);
            bo_bodyhealthlist.setVisibility(View.VISIBLE);
            background.setVisibility(View.INVISIBLE);

        }
    }

    //    時間取得
    public static String getNowDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);    // 0 - 11
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        String date = year + "年" + (month + 1) + "月" + day + "日　" + hour + "時" + minute + "分" + second + "秒";

        System.out.println(date);

        return date;
    }
    public static String kirokutime(){
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        String kirokutime = hour + ":"+  minute;
        return kirokutime;
    }
    public void insertFoodtable(int Child_ID, int Code, String Registraction_Time) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Child_ID", Child_ID);
        values.put("Code", Code);
        values.put("Registraction_Time", Registraction_Time);
        db.insert("FoodTable", null, values);

    }
    public void insertSleeptable(int Child_ID, int Code, String Registraction_Time) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Child_ID", Child_ID);
        values.put("Code", Code);
        values.put("Registraction_Time", Registraction_Time);
        db.insert("SleepTable", null, values);

    }
    public void insertBodyhealthtable(int Child_ID, int Code, String Registraction_Time) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Child_ID", Child_ID);
        values.put("Code", Code);
        values.put("Registraction_Time", Registraction_Time);
        db.insert("BodyhealthTable", null, values);

    }
    public void insertHospitaltable(int Child_ID, int Code, String Registraction_Time) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Child_ID", Child_ID);
        values.put("Code", Code);
        values.put("Registraction_Time", Registraction_Time);
        db.insert("HospitalTable", null, values);

    }
    public void insertExcretiontable(int Child_ID, int Code, String Registraction_Time) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Child_ID", Child_ID);
        values.put("Code", Code);
        values.put("Registraction_Time", Registraction_Time);
        db.insert("ExcretionTable", null, values);

    }
}

