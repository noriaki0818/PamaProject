package com.example.pamaproject;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Home extends AppCompatActivity implements View.OnClickListener ,DialogInterface.OnClickListener{
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
    int CHILD_ID ;
    String cid;

    private DBHelper helper=null;

    //しょうや ↓
    //listview変数設定
    ListView recodelist2;
    String nikki =null;
    //しょうや ↑
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        helper = new DBHelper(this);
        //データベースを取得
        SQLiteDatabase db = helper.getWritableDatabase();

        try {
            Toast.makeText(this, "DBに接続完了", Toast.LENGTH_SHORT).show();
        }
        finally {
            db.close();
        }


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

        //チャイルドID取得
        intent =getIntent();
        cid = intent.getStringExtra("child_id");
        System.out.println("IN HOme child_id ; " + cid);


        //listview表示
        selectListViewTable(cid);



        String kirokubi =today();
        nikki = getNikki(cid,kirokubi);
        diary.setText(nikki);

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

        //年月日時分秒
        String nowTime = getNowDate();
        long intnowTime = getintNowDate();

        //時分
        String jihunn = jihunn();

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

            String kirokubi =today();
            if(nikki == null) {
                setnikki(cid, nikki, kirokubi);
            }else {
                updatenikki(cid, nikki, kirokubi);

            }



        }

        //フッダーリスト
        if (view == Diary) {
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
            insertFoodtable(cid,7, nowTime,jihunn,intnowTime);
            selectListViewTable(cid);

        }
//        if (view == meal) {
//            //ごはん
//            insertFoodtable(CHILD_ID, 8, nowTime,jihunn,intnowTime);
//        }
//        if (view == drink) {
//            //飲み物
//            insertFoodtable(CHILD_ID, 9, nowTime,jihunn,intnowTime);
//        }
//        if (view == babyfood) {
//            //離乳食
//            insertFoodtable(CHILD_ID, 10, nowTime,jihunn,intnowTime);
//        }
//        if (view == snack) {
//            //おやつ
//            insertFoodtable(CHILD_ID, 11, nowTime,jihunn,intnowTime);
//        }
//        if (view == milk3) {
//            //搾乳
//            insertFoodtable(CHILD_ID, 12, nowTime,jihunn,intnowTime);
//        }

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
        if(view==recodelist2){

        }
    }




    //log時間取得
    private long getintNowDate() {
        String months;
        String days;
        String hours;
        String minutes;
        String seconds;

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);    //// 0 - 11eg
        month +=1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        String years = String.valueOf(year);
        //月が9以下なら左に0を足す
        if(month<=9){
            String zetrotasumae = String.valueOf(month);
            months = "0" + zetrotasumae;
        }else{
            months = String.valueOf(month);
        }
        //日が9以下なら左に0を足す
        if(day<=9){
            String zetrotasumae = String.valueOf(day);
            days = "0" + zetrotasumae;
        }else{
            days = String.valueOf(day);
        }
        //時が9以下なら左に0を足す
        if(hour<=9){
            String zetrotasumae = String.valueOf(hour);
            hours = "0" + zetrotasumae;
        }else{
            hours = String.valueOf(hour);
        }
        //分が9以下なら左に0を足す
        if(minute<=9){
            String zetrotasumae = String.valueOf(minute);
            minutes = "0" + zetrotasumae;
        }else{
            minutes = String.valueOf(minute);
        }
        //秒が9以下なら左に0を足す
        if(second<=9){
            String zetrotasumae = String.valueOf(second);
            seconds = "0" + zetrotasumae;
        }else{
            seconds = String.valueOf(second);
        }
        String stringdata = years + months + days + hours + minutes + seconds;
        System.out.println(stringdata);
        long intdate = Long.parseLong(stringdata);
        System.out.println(intdate);
        return intdate;
    }

    //    時間取得
    public static String getNowDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);    // 0 - 11eg
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        String date = year + "年" + (month + 1) + "月" + day + "日　" + hour + "時" + minute + "分" + second + "秒";

        System.out.println(date);

        return date;
    }
    //時間分取得
    public static String jihunn(){
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        String kirokutime = hour + ":"+  minute;
        return kirokutime;
    }
    public static String today(){
        String months;
        String days;
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);    //// 0 - 11eg
        month +=1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String years = String.valueOf(year);
        //月が9以下なら左に0を足す
        if(month<=9){
            String zetrotasumae = String.valueOf(month);
            months = "0" + zetrotasumae;
        }else{
            months = String.valueOf(month);
        }
        //日が9以下なら左に0を足す
        if(day<=9){
            String zetrotasumae = String.valueOf(day);
            days = "0" + zetrotasumae;
        }else{
            days = String.valueOf(day);
        }

        String a = years+months+days;
        return a;
    }







    //インサート文
    public void insertFoodtable(String cid,int code,String nowTime,String jihunn,long intnowTime) {
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();


            String Code = String.valueOf(code);
            String inttime =String.valueOf(intnowTime);

            values.put("Child_ID", cid);
            values.put("Code", Code);
            values.put("Registration_Time", nowTime);
            values.put("jihun", jihunn);
            values.put("IntNowdata", inttime);
            System.out.println("FoodTbleに、Child_ID:"+cid+"、Code:"+Code+"、Registration_Time:"+nowTime+"、jihun:"+jihunn+"、IntNowdata:"+inttime+"を登録");


            db.insert("FoodTable", null, values);
        }finally {
            db.close();
        }
        insertListViewTable(intnowTime,code, jihunn,cid);
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
    private void insertListViewTable(long intnowTime, int i, String jihunn,String cid) {
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            String inttime = String.valueOf(intnowTime);
            String Code = String.valueOf(i);

            values.put("IntNowdata", inttime);
            values.put("Code", Code);
            values.put("jihun", jihunn);
            values.put("Child_ID", cid);

            System.out.println("ListViewTableに、IntNowdata:"+inttime+"、Code:"+Code+"、jihun:"+jihunn+"、cid:"+cid+"を登録");

            db.insert("ListViewTable", null, values);
        }finally {
            db.close();
        }
    }



    String unko;
    String hennsyuusurutokinoID;
    String deleteI;
    //しょうや検索ののちlistviewに表示
    public void selectListViewTable(String CID){

        ArrayList<String>  IntNowdata = new ArrayList<>() ;

        ArrayList<Integer> Code = new ArrayList<>();

        ArrayList<Integer> img = new ArrayList<>();

        ArrayList<String> Jihun = new ArrayList<>();

        ArrayList<String> syousai = new ArrayList<>();

        ArrayList<String> Cid = new ArrayList<>();

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = null;
        try {
            String[] getcols = {"IntNowdata", "Code", "jihun", "syousai","Child_ID"};//0,1,2
            String[] SearchKey = {CID};
            cs = db.query("ListViewTable", getcols, "Child_ID = ?", SearchKey, null, null, "IntNowdata ASC",null);
            if (cs.moveToFirst()) {
                for(int i = 0;i < cs.getCount();i++) {

                    String inttime =cs.getString(0);
                    IntNowdata.add(inttime);

                    int code = cs.getInt(1);
                    Code.add(code);
                    if(code == 7) {
                        img.add(R.drawable.milk2);
                    }

                    String jihun = cs.getString(2);
                    Jihun.add(jihun);


                    String syousai1;
                    if(cs.getString(3)==null) {
                        syousai1 = "";
                    }else{
                        syousai1 = cs.getString(3);
                    }
                    syousai.add(syousai1);
                    System.out.println("inttime;"+ inttime+",Code;"+code+",jihun;"+jihun+"syousai;"+syousai1);
                    String cid =cs.getString(4);
                    Cid.add(cid);

                    System.out.println("ListViewTableから、IntNowdata:"+inttime+"、code:"+code+"、jihun:"+jihun+"、syousai:"+syousai1+"、Child_ID"+cid+
                            "を取得。arrayimgに"+img.get(i));

                    cs.moveToNext();
                }
            }else{
                Toast.makeText(this, "いみわかんね2", Toast.LENGTH_SHORT).show();
            }
        } finally {
            cs.close();
            db.close();
        }

        String[] IntNowdatas = IntNowdata.toArray(new String[IntNowdata.size()]);

        String[] Codes = new String[Code.size()];
        for (int i=0; i<Code.size(); i++) {
            String s = String.valueOf(Code.get(i));
            Codes[i] =s;
        }

        int[] Imgs = new int[img.size()];
        for (int i=0; i<img.size(); i++) {
            Imgs[i] = img.get(i);
        }

        String[] Jihuns = Jihun.toArray(new String[Jihun.size()]);
        String[] syousais = syousai.toArray(new String[syousai.size()]);
        String[] cids = Cid.toArray(new String[Cid.size()]);

        recodelist2 = (ListView)findViewById(R.id.recordlist2) ;
        BaseAdapter adapter = new Home_BaseAdapter(this.getApplicationContext(),
                R.layout.list_items, IntNowdatas,Codes,Imgs, Jihuns, syousais,cids);
        recodelist2.setAdapter(adapter);

        recodelist2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                hennsyuusurutokinoID = IntNowdata.get(i);
                System.out.println("選択したリストのintdata:"+hennsyuusurutokinoID);

                hensyuDialog();
//                System.out.println("ml:"+unko);
            }

        });
        recodelist2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                deleteI = String.valueOf(i);
                System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyy-------------------------"+deleteI);
                deleteDialog();
                return true;
            }



        });
    }
    private void deleteDialog() {
        AlertDialog.Builder altdialog = new AlertDialog.Builder(this);
        altdialog.setTitle("消しますか？");
        altdialog.setIcon(R.mipmap.ic_launcher);
        altdialog.setPositiveButton("yes", (DialogInterface.OnClickListener) this);
        altdialog.setNeutralButton("キャンセル", (DialogInterface.OnClickListener) this);
        altdialog.setNegativeButton("no", (DialogInterface.OnClickListener) this);
        altdialog.create().show();

    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if( i == DialogInterface.BUTTON_POSITIVE)
            Toast.makeText(this,"ポジティブボタン",Toast.LENGTH_LONG).show();
            deleteDB();
        if( i == DialogInterface.BUTTON_NEUTRAL)
            Toast.makeText(this,"ナチュラルボタン",Toast.LENGTH_LONG).show();
        if( i == DialogInterface.BUTTON_NEGATIVE)
            Toast.makeText(this,"ネガティブボタン",Toast.LENGTH_LONG).show();

    }

    private void deleteDB() {
        SQLiteDatabase db = helper.getWritableDatabase();
//        try{
//            String[] params = {};
//            db.delete("book","is")
//        }

        System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");

    }


    private void hensyuDialog() {
        ArrayList<Item> itemList = new ArrayList<>();
        ArrayList<Integer> ml = new ArrayList<>();

        for(int i=0;i<=500;i+=10){

            Item item = new Item();
            item.setIntItem(i);
            ml.add(i);
            item.setStringItem("ml");
            itemList.add(item);

        }

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), 0, itemList);
        ListView listView = new ListView(this);
        listView.setAdapter(adapter);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("選択してくだい。")
                .setView(listView).create();
        dialog.show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String msg ="選択されたもの:" + ml.get(i);

                unko = String.valueOf(ml.get(i))+"ml";
                System.out.println(msg);
                update(unko,hennsyuusurutokinoID,cid);

                dialog.dismiss();
            }
        });



    }
    public void update(String unko,String hensyu,String cid){
        System.out.println("ここ一"+unko+"koko"+hensyu+"cid:"+cid);

        SQLiteDatabase db = helper.getReadableDatabase();
        try {
            ContentValues cv = new ContentValues();

            cv.put("syousai", unko);

            db.update("ListViewTable", cv, "CHILD_ID = ? AND IntNowdata = ?" , new String[] {cid,hensyu}); // 入力文で書くと UPDATE UserTable SET name = '初め', gender = "男 WHERE ID = 1;
            db.update("FoodTable", cv, "CHILD_ID = ? AND IntNowdata = ?" , new String[] {cid,hensyu}); // 入力文で書くと UPDATE UserTable SET name = '初め', gender = "男 WHERE ID = 1;

            Toast.makeText(this, "編集",Toast.LENGTH_SHORT).show();
        }finally {
            db.close();
        }
        selectListViewTable(cid);
    }

    public class Item{
        private int intItem;
        private String stringItem;

        public void setStringItem(String stringItem){
            this.stringItem = stringItem;
        }
        public String getStringItem(){
            return this.stringItem;
        }
        public void setIntItem(int intItem){
            this.intItem = intItem;
        }
        public int getIntItem(){
            return this.intItem;
        }
    }

    // ListViewで使用するadapter
    public class CustomAdapter extends ArrayAdapter<Item> {
        private LayoutInflater inflater;

        public CustomAdapter(Context context, int resource, List<Item> objects) {
            super(context, resource, objects);
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public View getView(int position, View v, ViewGroup parent) {
            Item item = (Item)getItem(position);
            if (null == v) v = inflater.inflate(R.layout.custom_listview, null);

            TextView intTextView = (TextView)v.findViewById(R.id.int_item);
            intTextView.setText(item.getIntItem()+"");

            TextView stringTextView = (TextView)v.findViewById(R.id.string_item);
            stringTextView.setText(item.getStringItem());
            return v;
        }
    }

    private String getNikki(String CID,String today ) {
        String nikki;
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = null;
        try {
            String[] getcols = {"Diary"};//0,1,2
            String[] SearchKey = {CID,today};
            cs = db.query("DiaryTa" +
                    "ble", getcols, "Child_ID = ? AND today = ?", SearchKey, null, null, null,null);
            if (cs.moveToFirst()) {
                nikki = cs.getString(0);
            }else{
                nikki =null;
                Toast.makeText(this, "いみわかんね2", Toast.LENGTH_SHORT).show();
            }
        } finally {
            cs.close();
            db.close();
        }
        return nikki;
    }

    public void setnikki(String cid,String nikki,String kirokubi){

        final EditText editText = new EditText(this);
        new AlertDialog.Builder(this)
                .setTitle("日記")
                .setView(editText)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // お好きな処理をどうぞ
                        TextView textView = (TextView) findViewById(R.id.bo_diary);
                        textView.setText(editText.getText());
                        String text = textView.getText().toString();
                        setNikki(cid,text,kirokubi);
                    }

                    private void setNikki(String cid,String text,String kirokubi) {
                        SQLiteDatabase db = helper.getWritableDatabase();
                        try {
                            ContentValues values = new ContentValues();
                            values.put("Child_ID", cid);
                            values.put("Today", kirokubi);
                            values.put("Diary", text);

                            System.out.println("DiaryTableに、Child_ID:"+cid+"を登録");


                            db.insert("DiaryTable", null, values);
                        }finally {
                            db.close();
                        }
                    }
                })
                .show();
    }
    private void updatenikki(String cid,String nikki,String kirokubi) {
        final EditText editText = new EditText(this);
        new AlertDialog.Builder(this)
                .setTitle("日記")
                .setView(editText)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // お好きな処理をどうぞ
                        TextView textView = (TextView) findViewById(R.id.bo_diary);
                        textView.setText(editText.getText());
                        String text = textView.getText().toString();
                        setNikki(cid,text,kirokubi);
                    }

                    private void setNikki(String cid,String text,String kirokubi) {
                        SQLiteDatabase db = helper.getReadableDatabase();
                        try {
                            ContentValues cv = new ContentValues();

                            cv.put("Diary", text);

                            db.update("DiaryTable", cv, "CHILD_ID = ? AND Today = ?" , new String[] {cid,kirokubi}); // 入力文で書くと UPDATE UserTable SET name = '初め', gender = "男 WHERE ID = 1;

                        }finally {
                            db.close();
                        }
                    }
                })
                .show();
    }

}

