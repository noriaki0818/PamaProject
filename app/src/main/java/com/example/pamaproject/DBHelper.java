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
        //記事テーブル
        insertCodeTable(db, 29, "生後1ヶ月のおすすめ記事","");
        insertCodeTable(db, 30, "生後1ヶ月のおすすめ記事","");
        insertCodeTable(db, 31, "生後1ヶ月のおすすめ記事","");
        insertCodeTable(db, 32, "生後1ヶ月のおすすめ記事","");
        insertCodeTable(db, 33, "生後2ヶ月のおすすめ記事","");
        insertCodeTable(db, 34, "生後2ヶ月のおすすめ記事","");
        insertCodeTable(db, 35, "生後2ヶ月のおすすめ記事","");
        insertCodeTable(db, 36, "生後2ヶ月のおすすめ記事","");
        insertCodeTable(db, 37, "生後3ヶ月のおすすめ記事","");
        insertCodeTable(db, 38, "生後3ヶ月のおすすめ記事","");
        insertCodeTable(db, 39, "生後3ヶ月のおすすめ記事","");
        insertCodeTable(db, 40, "生後3ヶ月のおすすめ記事","");
        insertCodeTable(db, 41, "生後4ヶ月のおすすめ記事","");
        insertCodeTable(db, 42, "生後4ヶ月のおすすめ記事","");
        insertCodeTable(db, 43, "生後4ヶ月のおすすめ記事","");
        insertCodeTable(db, 44, "生後4ヶ月のおすすめ記事","");
        insertCodeTable(db, 45, "生後5ヶ月のおすすめ記事","");
        insertCodeTable(db, 46, "生後5ヶ月のおすすめ記事","");
        insertCodeTable(db, 47, "生後5ヶ月のおすすめ記事","");
        insertCodeTable(db, 48, "生後5ヶ月のおすすめ記事","");
        insertCodeTable(db, 49, "生後6ヶ月のおすすめ記事","");
        insertCodeTable(db, 50, "生後6ヶ月のおすすめ記事","");
        insertCodeTable(db, 51, "生後6ヶ月のおすすめ記事","");
        insertCodeTable(db, 52, "生後6ヶ月のおすすめ記事","");
        insertCodeTable(db, 53, "生後7ヶ月のおすすめ記事","");
        insertCodeTable(db, 54, "生後7ヶ月のおすすめ記事","");
        insertCodeTable(db, 55, "生後7ヶ月のおすすめ記事","");
        insertCodeTable(db, 56, "生後7ヶ月のおすすめ記事","");
        insertCodeTable(db, 57, "生後8ヶ月のおすすめ記事","");
        insertCodeTable(db, 58, "生後8ヶ月のおすすめ記事","");
        insertCodeTable(db, 59, "生後8ヶ月のおすすめ記事","");
        insertCodeTable(db, 60, "生後8ヶ月のおすすめ記事","");
        insertCodeTable(db, 61, "生後9ヶ月のおすすめ記事","");
        insertCodeTable(db, 62, "生後9ヶ月のおすすめ記事","");
        insertCodeTable(db, 63, "生後9ヶ月のおすすめ記事","");
        insertCodeTable(db, 64, "生後9ヶ月のおすすめ記事","");
        insertCodeTable(db, 65, "生後10ヶ月のおすすめ記事","");
        insertCodeTable(db, 66, "生後10ヶ月のおすすめ記事","");
        insertCodeTable(db, 67, "生後10ヶ月のおすすめ記事","");
        insertCodeTable(db, 68, "生後10ヶ月のおすすめ記事","");
        insertCodeTable(db, 69, "生後11ヶ月のおすすめ記事","");
        insertCodeTable(db, 70, "生後11ヶ月のおすすめ記事","");
        insertCodeTable(db, 71, "生後11ヶ月のおすすめ記事","");
        insertCodeTable(db, 72, "生後11ヶ月のおすすめ記事","");
        insertCodeTable(db, 73, "生後1年0ヶ月のおすすめ記事","");
        insertCodeTable(db, 74, "生後1年0ヶ月のおすすめ記事","");
        insertCodeTable(db, 75, "生後1年0ヶ月のおすすめ記事","");
        insertCodeTable(db, 76, "生後1年0ヶ月のおすすめ記事","");
        insertCodeTable(db, 77, "生後1年1ヶ月のおすすめ記事","");
        insertCodeTable(db, 78, "生後1年1ヶ月のおすすめ記事","");
        insertCodeTable(db, 79, "生後1年1ヶ月のおすすめ記事","");
        insertCodeTable(db, 80, "生後1年1ヶ月のおすすめ記事","");
        insertCodeTable(db, 81, "生後1年2ヶ月のおすすめ記事","");
        insertCodeTable(db, 82, "生後1年2ヶ月のおすすめ記事","");
        insertCodeTable(db, 83, "生後1年2ヶ月のおすすめ記事","");
        insertCodeTable(db, 84, "生後1年2ヶ月のおすすめ記事","");
        insertCodeTable(db, 85, "生後1年3ヶ月のおすすめ記事","");
        insertCodeTable(db, 86, "生後1年3ヶ月のおすすめ記事","");
        insertCodeTable(db, 87, "生後1年3ヶ月のおすすめ記事","");
        insertCodeTable(db, 88, "生後1年3ヶ月のおすすめ記事","");
        insertCodeTable(db, 89, "生後1年4ヶ月のおすすめ記事","");
        insertCodeTable(db, 90, "生後1年4ヶ月のおすすめ記事","");
        insertCodeTable(db, 91, "生後1年4ヶ月のおすすめ記事","");
        insertCodeTable(db, 92, "生後1年4ヶ月のおすすめ記事","");
        insertCodeTable(db, 93, "生後1年5ヶ月のおすすめ記事","");
        insertCodeTable(db, 94, "生後1年5ヶ月のおすすめ記事","");
        insertCodeTable(db, 95, "生後1年5ヶ月のおすすめ記事","");
        insertCodeTable(db, 96, "生後1年5ヶ月のおすすめ記事","");
        insertCodeTable(db, 97, "生後1年6ヶ月のおすすめ記事","");
        insertCodeTable(db, 98, "生後1年6ヶ月のおすすめ記事","");
        insertCodeTable(db, 99, "生後1年6ヶ月のおすすめ記事","");
        insertCodeTable(db, 100, "生後1年6ヶ月のおすすめ記事","");
        insertCodeTable(db, 101, "生後1年7ヶ月のおすすめ記事","");
        insertCodeTable(db, 102, "生後1年7ヶ月のおすすめ記事","");
        insertCodeTable(db, 103, "生後1年7ヶ月のおすすめ記事","");
        insertCodeTable(db, 104, "生後1年7ヶ月のおすすめ記事","");
        insertCodeTable(db, 105, "生後1年8ヶ月のおすすめ記事","");
        insertCodeTable(db, 106, "生後1年8ヶ月のおすすめ記事","");
        insertCodeTable(db, 107, "生後1年8ヶ月のおすすめ記事","");
        insertCodeTable(db, 108, "生後1年8ヶ月のおすすめ記事","");
        insertCodeTable(db, 109, "生後1年9ヶ月のおすすめ記事","");
        insertCodeTable(db, 110, "生後1年9ヶ月のおすすめ記事","");
        insertCodeTable(db, 111, "生後1年9ヶ月のおすすめ記事","");
        insertCodeTable(db, 112, "生後1年9ヶ月のおすすめ記事","");
        insertCodeTable(db, 113, "生後1年10ヶ月のおすすめ記事","");
        insertCodeTable(db, 114, "生後1年10ヶ月のおすすめ記事","");
        insertCodeTable(db, 115, "生後1年10ヶ月のおすすめ記事","");
        insertCodeTable(db, 116, "生後1年10ヶ月のおすすめ記事","");
        insertCodeTable(db, 117, "生後1年11ヶ月のおすすめ記事","");
        insertCodeTable(db, 118, "生後1年11ヶ月のおすすめ記事","");
        insertCodeTable(db, 119, "生後1年11ヶ月のおすすめ記事","");
        insertCodeTable(db, 120, "生後1年11ヶ月のおすすめ記事","");
        insertCodeTable(db, 121, "生後2年0ヶ月のおすすめ記事","");
        insertCodeTable(db, 122, "生後2年0ヶ月のおすすめ記事","");
        insertCodeTable(db, 123, "生後2年0ヶ月のおすすめ記事","");
        insertCodeTable(db, 124, "生後2年0ヶ月のおすすめ記事","");
        insertCodeTable(db, 125, "生後2年1ヶ月のおすすめ記事","");
        insertCodeTable(db, 126, "生後2年1ヶ月のおすすめ記事","");
        insertCodeTable(db, 127, "生後2年1ヶ月のおすすめ記事","");
        insertCodeTable(db, 128, "生後2年1ヶ月のおすすめ記事","");
        insertCodeTable(db, 129, "生後2年2ヶ月のおすすめ記事","");
        insertCodeTable(db, 130, "生後2年2ヶ月のおすすめ記事","");
        insertCodeTable(db, 131, "生後2年2ヶ月のおすすめ記事","");
        insertCodeTable(db, 132, "生後2年2ヶ月のおすすめ記事","");
        insertCodeTable(db, 133, "生後2年3ヶ月のおすすめ記事","");
        insertCodeTable(db, 134, "生後2年3ヶ月のおすすめ記事","");
        insertCodeTable(db, 135, "生後2年3ヶ月のおすすめ記事","");
        insertCodeTable(db, 136, "生後2年3ヶ月のおすすめ記事","");
        insertCodeTable(db, 137, "生後2年4ヶ月のおすすめ記事","");
        insertCodeTable(db, 138, "生後2年4ヶ月のおすすめ記事","");
        insertCodeTable(db, 139, "生後2年4ヶ月のおすすめ記事","");
        insertCodeTable(db, 140, "生後2年4ヶ月のおすすめ記事","");
        insertCodeTable(db, 141, "生後2年5ヶ月のおすすめ記事","");
        insertCodeTable(db, 142, "生後2年5ヶ月のおすすめ記事","");
        insertCodeTable(db, 143, "生後2年5ヶ月のおすすめ記事","");
        insertCodeTable(db, 144, "生後2年5ヶ月のおすすめ記事","");
        insertCodeTable(db, 145, "生後2年6ヶ月のおすすめ記事","");
        insertCodeTable(db, 146, "生後2年6ヶ月のおすすめ記事","");
        insertCodeTable(db, 147, "生後2年6ヶ月のおすすめ記事","");
        insertCodeTable(db, 148, "生後2年6ヶ月のおすすめ記事","");
        insertCodeTable(db, 149, "生後2年7ヶ月のおすすめ記事","");
        insertCodeTable(db, 150, "生後2年7ヶ月のおすすめ記事","");
        insertCodeTable(db, 151, "生後2年7ヶ月のおすすめ記事","");
        insertCodeTable(db, 152, "生後2年7ヶ月のおすすめ記事","");
        insertCodeTable(db, 153, "生後2年8ヶ月のおすすめ記事","");
        insertCodeTable(db, 154, "生後2年8ヶ月のおすすめ記事","");
        insertCodeTable(db, 155, "生後2年8ヶ月のおすすめ記事","");
        insertCodeTable(db, 156, "生後2年8ヶ月のおすすめ記事","");
        insertCodeTable(db, 157, "生後2年9ヶ月のおすすめ記事","");
        insertCodeTable(db, 158, "生後2年9ヶ月のおすすめ記事","");
        insertCodeTable(db, 159, "生後2年9ヶ月のおすすめ記事","");
        insertCodeTable(db, 160, "生後2年9ヶ月のおすすめ記事","");
        insertCodeTable(db, 161, "生後2年10ヶ月のおすすめ記事","");
        insertCodeTable(db, 162, "生後2年10ヶ月のおすすめ記事","");
        insertCodeTable(db, 163, "生後2年10ヶ月のおすすめ記事","");
        insertCodeTable(db, 164, "生後2年10ヶ月のおすすめ記事","");
        insertCodeTable(db, 165, "生後2年11ヶ月のおすすめ記事","");
        insertCodeTable(db, 166, "生後2年11ヶ月のおすすめ記事","");
        insertCodeTable(db, 167, "生後2年11ヶ月のおすすめ記事","");
        insertCodeTable(db, 168, "生後2年11ヶ月のおすすめ記事","");



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
