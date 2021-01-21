package com.example.pamaproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Dao {
    public static final String o = ",";

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
    public static final String Code_TABLE = "CodeTable";

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

    //    ユーザーテーブル
    public static final String SQL_CREATE_USERTABLE =
            "CREATE TABLE " + User_TABLE + "(" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    Name + " TEXT NOT NULL," +
                    Gender + "TEXT NOT NULL);";

    //        赤ちゃんテーブル
    public static final String SQL_CREATE_BABYTABLE =
            "CREATE TABLE " + Baby_TABLE + "(" +
                    Child_ID + "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    ID + "INTEGER NOT NULL, " +
                    Baby_Name + "TEXT NOT NULL, " +
                    Baby_gender + "TEXT NOT NULL, " +
                    Birth + "TEXT NOT NULL, " +
                    "FOREIGN KEY (" + ID + ") REFERENCES " + User_TABLE + "(" + ID + "));";

    //    日記テーブル
    public static final String SQL_CREATE_DIARYTABLE =
            "CREATE TABLE " + Baby_TABLE + "(" +
                    Diary_ID + "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    Child_ID + "INTEGER NOT NULL, " +
                    Registration_Time + "TEXT NOT NULL, " +
                    Diary + "TEXT NOT NULL, " +
                    Image + "BLOB, " +
                    "FOREIGN KEY (" + Child_ID + ") REFERENCES " + Baby_TABLE + "(" + Child_ID + "));";

    //    記事テーブル
    public static final String SQL_CREATE_ARTICLETABLE =
            "CREATE TABLE " + Article_TABLE + "(" +
                    Article_ID + "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Article_Name + "TEXT NOT NULL, " +
                    Article_text + "TEXT NOT NULL);";

    //    食事テーブル
    public static final String SQL_CREATE_FOODTABLE =
            "CREATE TABLE " + Food_TABLE + "(" +
                    Food_ID + "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Child_ID + "INTEGER NOT NULL, " +
                    Code + "INTEGER NOT NULL, " +
                    Registration_Time + "TEXT NOT NULL, " +
                    Memo + "TEXT, " +
                    ml + "INTEGER NOT NULL DEFAULT 0, " +
                    "FOREIGN KEY (" + Child_ID + ") REFERENCES " + Baby_TABLE + "(" + Child_ID + "), " +
                    "FOREIGN KEY (" + Code + ") REFERENCES " + Code_TABLE + "(" + Code + "));";

    //    睡眠テーブル
    public static final String SQL_CREATE_SLEEPTABLE =
            "CREATE TABLE " + Sleep_TABLE + "(" +
                    Sleep_ID + "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Child_ID + "INTEGER NOT NULL, " +
                    Code + "INTEGE NOT NULL, " +
                    Registration_Time + "TEXT NOT NULL, " +
                    Memo + "TEXT, " +
                    "FOREIGN KEY (" + Child_ID + ") REFERENCES " + Baby_TABLE + "(" + Child_ID + "), " +
                    "FOREIGN KEY (" + Code + ") REFERENCES " + Code_TABLE + "(" + Code + "));";

    //    身体テーブル
    public static final String SQL_CREATE_BODYHEALTHTABLE =
            "CREATE TABLE " + Bodyhealth_TABLE + "(" +
                    Bodyhealth_ID + "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Child_ID + "INTEGER NOT NULL, " +
                    Code + "INTEGER NOT NULL, " +
                    Registration_Time + "TEXT NOT NULL, " +
                    Memo + "TEXT, " +
                    Body_Amount + "TEXT NOT NULL, " +
                    "FOREIGN KEY (" + Child_ID + ") REFERENCES " + Baby_TABLE + "(" + Child_ID + "), " +
                    "FOREIGN KEY (" + Code + ") REFERENCES " + Code_TABLE + "(" + Code + "));";

    //    病院テーブル
    public static final String SQL_CREATE_HOSPITALTABLE =
            "CREATE TABLE " + Hospital_TABLE + "(" +
                    Hospital_ID + "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Child_ID + "INTEGER NOT NULL, " +
                    Code + "INTEGER NOT NULL, " +
                    Registration_Time + "TEXT NOT NULL, " +
                    Memo + "TEXT, " +
                    Vaccination + "TEXT, " +
                    "FOREIGN KEY (" + Child_ID + ") REFERENCES " + Baby_TABLE + "(" + Child_ID + "), " +
                    "FOREIGN KEY (" + Code + ") REFERENCES " + Code_TABLE + "(" + Code + "));";

    //    排泄テーブル
    public static final String SQL_CREATE_EXCRETIONTABLE =
            "CREATE TABLE " + Excretion_TABLE + "(" +
                    Excretion_ID + "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Child_ID + "INTEGER NOT NULL, " +
                    Code + "INTEGER NOT NULL, " +
                    Registration_Time + "TEXT NOT NULL, " +
                    Memo + "TEXT, " +
                    "FOREIGN KEY (" + Child_ID + ") REFERENCES " + Baby_TABLE + "(" + Child_ID + "), " +
                    "FOREIGN KEY (" + Code + ") REFERENCES " + Code_TABLE + "(" + Code + "));";

    //    識別テーブル
    public static final String SQL_CREATE_CODETABLE =
            "CREATE TABLE " + Code + "(" +
                    Code + "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Class + "TEXT NOT NULL, " +
                    Code_Name + "TEXT NOT NULL);";

    //    削除
    public static final String SQL_DELETE_TABLES = "DROP TABLE IF EXISTS " + User_TABLE + o + Baby_TABLE + o + Diary_TABLE + o
            + Food_TABLE + o + Sleep_TABLE + o + Bodyhealth_TABLE + o + Hospital_TABLE + o + Excretion_TABLE + o + Code;


//--------------------------------------------インサートメソッズ------------------------------------------------------


    //赤ちゃんテーブルデータ保存
    public void insertBabyTable(SQLiteDatabase db, int ID, String Baby_Name, String Baby_Gender, String Birth) {
        ContentValues values = new ContentValues();
        //IDを取ってくる処理を書く
        values.put("ID", ID);
        values.put("Baby_Name", Baby_Name);
        values.put("Baby_Gender", Baby_Gender);
        values.put("Birth", Birth);

        db.insert(Baby_TABLE, null, values);

    }

    //    日記テーブルにデータ保存
    public void insertDiaryTable(SQLiteDatabase db, String Child_ID, String Registration_Time, String Diary, byte[] Image) {
        ContentValues values = new ContentValues();

        values.put("Child_ID", Child_ID);
        values.put("Registration_Time", Registration_Time);
        values.put("Disry", Diary);
        values.put("Image", Image);

        db.insert(Diary_TABLE, null, values);
    }

//    BitmapFactory.decodeByteArray(blob, 0, blob.length); // blobはbyte[]です



    //    画像取得
    public static byte[] getBlob(Context context, String id) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            DBHelper helper = new DBHelper(context);
            db = helper.getReadableDatabase();
            String sql = String.format("select %s from %s where %s = ?", Image, Diary_TABLE, Child_ID);
            String[] args = {id};

            cursor = db.rawQuery(sql, args);

            if (cursor.moveToFirst()) {
                return cursor.getBlob(0);
            }
            return null;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
    }
}
