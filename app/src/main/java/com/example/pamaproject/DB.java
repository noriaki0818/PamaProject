package com.example.pamaproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

//    データーベースのバージョン
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "PamaProject.db";

//    テーブルリスト
    public static final String User_TABLE = "UserTable";
    public static final String Baby_TABLE = "BabyTable";
    public static final String Diary_TABLE = "DiaryTable";
    public static final String Article_TABLE = "ArticleTable";
    public static final String Food_TABLE = "FoodTable";
    public static final String Sleep_TABLE = "SleepTable";
    public static final String Bodyhealth_TABLE = "BodyhealthTable";
    public static final String Hospital_TABLE = "HospitalTable";
    public static final String Excretion_TABLE = "ExcretionTable";

//    PRIMARY KEY リスト
    public static final String ID = "ID";
    public static final String Child_ID = "Chid_ID";
    public static final String Diary_ID = "Diary_ID";
    public static final String Article_ID = "Article_ID";
    public static final String Food_ID = "Food_ID";
    public static final String Sleep_ID = "Sleep_ID";
    public static final String Bodyhealth_ID = "Bodyhealth_ID";
    public static final String Hospital_ID = "Hospital_ID";
    public static final String Excretion_ID = "Excretion_ID";
    public static final String Code = "Code";

//    記録内容
    public static final String Registration_Time = "Registration_Time";
    public static final String Memo = "Memo";
    public static final String Amount = "Amount";
    public static final String Body_Amount = "Body_Amount";

//    ユーザーテーブル
    public static final String Name = "Name";
    public static final String Gender = "Gender";

//    赤ちゃんテーブル
    public static final String Baby_Name = "Baby_Name";
    public static final String Baby_gender = "Baby_Gender";
    public static final String Birth = "Birth";

//    日記テーブル
    public static final String Diary = "Diary";
    public static final String Image = "Image";

//    記事テーブル
    public static final String Article_Name = "Article_Name";
    public static final String Article_text = "Article_Text";
//    食事テーブル
    public static final String ml = "ml";

//    病院テーブル
    public static final String Vaccination = "Vaccination";

    //    識別テーブル
    public static final String Class = "Class";
    public static final String Code_Name = "Code_Name";

    //    食事テーブル
    public static final String milk1 = "milk1";
    public static final String milk2 = "milk2";
    public static final String meal = "meal";
    public static final String drink = "drink";
    public static final String babyfood = "babyfood";
    public static final String snack = "snack";
    public static final String milk3 = "milk3";

//    睡眠テーブル
    public static final String bath = "bath";
    public static final String getup = "getup";
    public static final String sleep = "sleep";

//    身体テーブル
    public static final String weight = "weight";
    public static final String height = "height";
    public static final String temperature = "temperature";

//    病院テーブル
    public static final String medicine = "medicine";
    public static final String preventional = "preventional";
    public static final String hospital = "hospital";
    public static final String lnjury = "lnjury";
    public static final String rash = "rash";
    public static final String vomit = "vomit";
    public static final String cough = "cough";

//    排泄テーブル
    public static final String both = "both";
    public static final String pee = "pee";
    public static final String poo = "poo";


    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + User_TABLE + Baby_TABLE + Diary_TABLE
            + Food_TABLE + Sleep_TABLE + Bodyhealth_TABLE + Hospital_TABLE + Excretion_TABLE;

//    ユーザーテーブル
    public static final String SQL_CREATE_USERTABLE =
            "CREATE TABLE " + User_TABLE + "(" +
                    ID + " INTEGER PRIMARY KEY NOT NULL," +
                    Name + " TEXT NOT NULL," +
                    Gender + "TEXT NOT NULL);";

    //    赤ちゃんテーブル
    public static final String SQL_CREATE_BABYTABLE =
            "CREATE TABLE " + Baby_TABLE + "(" +
                    Child_ID + "INTEGER PRIMARY KEY NOT NULL," +
                    ID + "INTEGER FORIGN KEY NOT NULL, " +
                    Baby_Name + "TEXT NOT NULL, " +
                    Baby_gender + "TEXT NOT NULL, " +
                    Birth + "TEXT NOT NULL);";

//    日記テーブル
    public static final String SQL_CREATE_DIARYTABLE =
            "CREATE TABLE " + Diary_TABLE + "(" +
                    Diary_ID + "INTEGER PRIMARY KEY NOT NULL, " +
                    Child_ID + "INTEGER FORIGN KEY NOT NULL, " +
                    Registration_Time + "TEXT NOT NULL, " +
                    Diary + "TEXT NOT NULL, " +
                    Image + "BLOB);";

//    記事テーブル
    public static final String SQL_CREATE_ARTICLETABLE =
            "CREATE TABLE " + Article_TABLE + "(" +
                    Article_ID + "INTEGER PRIMARY KEY NOT NULL, " +
                    Article_Name + "TEXT NOT NULL, " +
                    Article_text + "TEXT NOT NULL);";

//    食事テーブル
    public static final String SQL_CREATE_FOODTABLE =
            "CREATE TABLE " + Food_TABLE + "(" +
                    Food_ID + "INTEGER PRIMARY KEY NOT NULL, " +
                    Child_ID + "INTEGER FORIGN KRY NOT NULL, " +
                    Code + "INTEGER FORIGN KEY NOT NULL, " +
                    Registration_Time + "TEXT NOT NULL, " +
                    Memo + "TEXT, " +
                    ml + "INTEGER NOT NULL DEFAULT 0);";

//    睡眠テーブル
    public static final String SQL_CREATE_SLEEPTABLE =
            "CREATE TABLE " + Sleep_TABLE + "(" +
                    Sleep_ID + "INTEGER PRIMARY KEY NOT NULL, " +
                    Child_ID + "INTEGER FORIGN KEY NOT NULL, " +
                    Code + "INTEGER FORIGN KEY NOT NULL, " +
                    Registration_Time + "TEXT NOT NULL, " +
                    Memo + "TEXT);";

//    身体テーブル
    public static final String SQL_CREATE_BODYHEALTHTABLE =
            "CREARTE TABLE " + Bodyhealth_TABLE + "(" +
                    Bodyhealth_ID + "INTEGER PRIMARY KEY NOT NULL, " +
                    Child_ID + "INTEGER FORIGN KEY NOT NULL, " +
                    Code + "INTEGER FORIGM KRY NOT NULL, " +
                    Registration_Time + "TEXT NOT NULL, " +
                    Memo + "TEXT, " +
                    Body_Amount + "TEXT NOT NULL);";

//    病院テーブル
    public static final String SQL_CREATE_HOSPITALTABLE =
            "CREATE TABLE " + Hospital_TABLE + "(" +
                    Hospital_ID + "INTEGER PRIMARY KRY NOT NULL, " +
                    Child_ID + "INTEGER FORIGN KEY NOT NULL, " +
                    Code + "INTEGER FORIGN KEY NOT NULL, " +
                    Registration_Time + "TEXT NOT NULL, " +
                    Memo + "TEXT, " +
                    Vaccination + "TEXT);";

//    排泄テーブル
    public static final String SQL_CREATE_EXCRETIONTABLE =
            "CREATE TABLE " + Excretion_TABLE + "(" +
                    Excretion_ID + "INTEGER PRIMERY KEY NOT NULL, " +
                    Child_ID + "INTEGER FORIGN KEY NOT NULL, " +
                    Code + "INTEGER FORIGN KEY NOT NULL, " +
                    Registration_Time + "TEXT NOT NULL, " +
                    Memo + "TEXT);";

//    識別テーブル
    public static final String SQL_CREATE_CODETABLE =
        "CREATE TABLE " + Code + "(" +
                Code + "INTEGER PRIMARY KEY NNOT NULL, " +
                Class + "TEXT NOT NULL, " +
                Code_Name + "TEXT NOT NULL);";

//    削除
    public static final String SQL_DELETE_ALL =
        "DROP TABLE IF EXISTS " + User_TABLE + Baby_TABLE + Food_TABLE + Sleep_TABLE
        + Bodyhealth_TABLE + Hospital_TABLE + Excretion_TABLE + Code ;






    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //テーブル作成
        db.execSQL(
            SQL_CREATE_USERTABLE
        );
        onCreate(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
