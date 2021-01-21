package com.example.pamaproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    //    データーベースのバージョン
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "PamaProject.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //テーブル作成
        db.execSQL(
                Dao.SQL_CREATE_USERTABLE
        );
        db.execSQL(
                Dao.SQL_CREATE_BABYTABLE
        );
        db.execSQL(
                Dao.SQL_CREATE_DIARYTABLE
        );
        db.execSQL(
                Dao.SQL_CREATE_ARTICLETABLE
        );
        db.execSQL(
                Dao.SQL_CREATE_FOODTABLE
        );
        db.execSQL(
                Dao.SQL_CREATE_SLEEPTABLE
        );
        db.execSQL(
                Dao.SQL_CREATE_BODYHEALTHTABLE
        );
        db.execSQL(
                Dao.SQL_CREATE_HOSPITALTABLE
        );
        db.execSQL(
                Dao.SQL_CREATE_EXCRETIONTABLE
        );
        db.execSQL(
                Dao.SQL_CREATE_CODETABLE
        );

        //識別テーブル内容入力
        insertCodeTable(db, 1, "食事", "授乳時間");
        insertCodeTable(db, 2, "食事", "授乳左");
        insertCodeTable(db, 3, "食事", "授乳右");
        insertCodeTable(db, 4, "食事", "母乳時間");
        insertCodeTable(db, 5, "食事", "母乳左");
        insertCodeTable(db, 6, "食事", "母乳右");
        insertCodeTable(db, 7, "食事", "ミルク");
        insertCodeTable(db, 8, "食事", "ごはん");
        insertCodeTable(db, 9, "食事", "飲み物");
        insertCodeTable(db, 10, "食事", "離乳食");
        insertCodeTable(db, 11, "食事", "おやつ");
        insertCodeTable(db, 12, "食事", "搾母乳");
        insertCodeTable(db, 13, "睡眠", "寝る");
        insertCodeTable(db, 14, "睡眠", "起きる");
        insertCodeTable(db, 15, "睡眠", "ふろ");
        insertCodeTable(db, 16, "排泄", "うんこ");
        insertCodeTable(db, 17, "排泄", "尿");
        insertCodeTable(db, 18, "排泄", "両方");
        insertCodeTable(db, 19, "病院", "せき");
        insertCodeTable(db, 20, "病院", "げろ");
        insertCodeTable(db, 21, "病院", "発疹");
        insertCodeTable(db, 22, "病院", "けが");
        insertCodeTable(db, 23, "病院", "病院");
        insertCodeTable(db, 24, "病院", "予防接種");
        insertCodeTable(db, 25, "病院", "薬");
        insertCodeTable(db, 26, "身体", "体温");
        insertCodeTable(db, 27, "身体", "身長");
        insertCodeTable(db, 28, "身体", "体重");

        Log.d("debug", "onCreate(SQLiteDatabase db)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        アップデートの判定
        db.execSQL(
                Dao.SQL_DELETE_TABLES
        );
        onCreate(db);
    }

    public void onDownGrade(SQLiteDatabase db, int oldversion, int newversion){
        onUpgrade(db, oldversion, newversion);

    }

    public void insertCodeTable(SQLiteDatabase db, int Code, String Class, String Code_Name) {
        ContentValues values = new ContentValues();
        values.put("Code", Code);
        values.put("Class", Class);
        values.put("Code_Name", Code_Name);

        db.insert("CodeTable", null, values);

    }

}
