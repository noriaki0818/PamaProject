package com.example.pamaproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

//    データーベースのバージョン
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "PamaProject.db";

//    テーブルリスト
    private static final String User_TABLE = "UserTable";
    private static final String Baby_TABLE = "BabyTable";
    private static final String Diary_TABLE = "DiaryTable";
    private static final String Food_TABLE = "FoodTable";
    private static final String Sleep_TABLE = "SleepTable";
    private static final String Bodyhealth_TABLE = "BodyhealthTable";
    private static final String Hospital_TABLE = "HospitalTable";
    private static final String Excretion_TABLE = "ExcretionTable";

//    PRIMARY KEY リスト
    private static final String ID = "ID";
    private static final String Child_ID = "Chid_ID";
    private static final String Food_ID = "Food_ID";
    private static final String Sleep_ID = "Sleep_ID";
    private static final String Bodyhealth_ID = "Bodyhealth_ID";
    private static final String Hospital_ID = "Hospital_ID";
    private static final String Excretion_ID = "Excretion_ID";
    private static final String Code = "Code";

//    記録内容
    private static final String Registration_Time = "Registration_Time";
    private static final String Memo = "Memo";
    private static final String Amount = "Amount";
    private static final String Body_Amount = "Body_Amount";

//    ユーザーテーブル
    private static final String Name = "Name";
    private static final String Gender = "Gender";

//    赤ちゃんテーブル
    private static final String Baby_Name = "Baby_Name";
    private static final String Baby_gender = "Baby_Gender";
    private static final String Birth = "Birth";

//    食事テーブル
    private static final String milk1 = "milk1";
    private static final String milk2 = "milk2";
    private static final String meal = "meal";
    private static final String drink = "drink";
    private static final String babyfood = "babyfood";
    private static final String snack = "snack";
    private static final String milk3 = "milk3";

//    睡眠テーブル
    private static final String bath = "bath";
    private static final String getup = "getup";
    private static final String sleep = "sleep";

//    身体テーブル
    private static final String weight = "weight";
    private static final String height = "height";
    private static final String temperature = "temperature";

//    病院テーブル
    private static final String medicine = "medicine";
    private static final String preventional = "preventional";
    private static final String hospital = "hospital";
    private static final String lnjury = "lnjury";
    private static final String rash = "rash";
    private static final String vomit = "vomit";
    private static final String cough = "cough";

//    排泄テーブル
    private static final String both = "both";
    private static final String pee = "pee";
    private static final String poo = "poo";

//    識別テーブル
    private static final String Class = "Class";
    private static final String Code_Name = "Code_Name";


    private static final String SQL_CREATE_ENTRIES = "DROP TABLE IF EXISTS " + Baby_TABLE;


    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //テーブル作成
        db.execSQL(
                SQL_CREATE_ENTRIES
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
