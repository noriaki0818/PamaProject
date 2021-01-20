package com.example.pamaproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity  implements View.OnClickListener{
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
    public void onClick (View view){


        //ヘッダー
        if (view == daybefore){
            //前日にする
        }
        if (view == daynext){
            //次の日にする
        }
        if (view == photo){
            //赤ちゃんの画像
            intent = new Intent();
            startActivity(intent);
        }
        if (view == menu){
            //メニュー
            intent = new Intent(Home.this, Menu_Baby.class);
            startActivity(intent);
        }

        //日記入力
        if (view == diary){
            //日記に飛ぶ
            intent = new Intent(Home.this, Nikki.class);
            startActivity(intent);
        }

        //フッダーリスト
        if (view == Diary){
            //日記画面に飛ぶ
            intent = new Intent(Home.this, Nikki.class);
        }
        if (view == Article){
            //記事画面に飛ぶ
//            intent = new Intent(Home.this, Article.class);
        }
        if (view == Summary){
            //まとめ画面に飛ぶ
//            intent = new Intent(Home.this, Summary.class);
        }

        //ボタンリスト
        if (view == bo_babylist){
            //ベイビーリスト
        }
        if (view == bo_meallist){
            //食事リスト
            bo_meallist.setVisibility(View.INVISIBLE);
            meallist.setVisibility(View.VISIBLE);
            mealBG.setVisibility(View.VISIBLE);
            background.setVisibility(View.VISIBLE);
        }
        if (view == bo_sleeplist){
            //睡眠リスト
            bo_sleeplist.setVisibility(View.INVISIBLE);
            sleeplist.setVisibility(View.VISIBLE);
            sleepBG.setVisibility(View.VISIBLE);
            background.setVisibility(View.VISIBLE);
        }
        if (view == bo_excretionlist){
            //排泄リスト
            bo_excretionlist.setVisibility(View.INVISIBLE);
            excretionlist.setVisibility(View.VISIBLE);
            excretionBG.setVisibility(View.VISIBLE);
            background.setVisibility(View.VISIBLE);
        }
        if (view == bo_hospitallist){
            //病院リスト
            bo_hospitallist.setVisibility(View.INVISIBLE);
            hospitallist.setVisibility(View.VISIBLE);
            hospitalBG.setVisibility(View.VISIBLE);
            background.setVisibility(View.VISIBLE);
        }
        if (view == bo_bodyhealthlist){
            //身体リスト
            bo_bodyhealthlist.setVisibility(View.INVISIBLE);
            bodyhealthlist.setVisibility(View.VISIBLE);
            bodyhealthBG.setVisibility(View.VISIBLE);
            background.setVisibility(View.VISIBLE);
        }
        if (view == bo_milkwatch){
            //ミルクウォッチ

        }

        //食事リスト
        if (view == milk1){
            //母乳
        }
        if (view == milk2){
            //ミルク
        }
        if (view == meal){
            //ごはん
        }
        if (view == drink){
            //飲み物
        }
        if (view == babyfood){
            //離乳食
        }
        if (view == snack){
            //おやつ
        }
        if (view == milk3){
            //搾乳
        }

        //睡眠リスト
        if (view == sleep){
            //寝る
        }
        if (view == getup){
            //起きる
        }
        if (view == bath){
            //風呂
        }

        //身体リスト
        if (view == temperature){
            //体温
        }
        if (view == height){
            //身長
        }
        if (view == weight){
            //体重
        }

        //病院リスト
        if (view == cough){
            //せき
        }
        if (view == vomit){
            //げろ
        }
        if (view == rash){
            //発疹
        }
        if (view == lnjury){
            //けが
        }
        if (view == hospital){
            //病院
        }
        if (view == preventional){
            //予防接種
        }
        if (view == medicine){
            //薬
        }

        //排泄リスト
        if (view == poo){
            //うんこ
        }
        if (view == pee){
            //尿
        }
        if (view == both){
            //両方
        }

        //バックグラウンド
        if (view == background){
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
}