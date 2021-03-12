package com.example.pamaproject;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DBHelper extends SQLiteOpenHelper {

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
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "PamaProjectTest.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //テーブル作成
        db.execSQL(
                "CREATE TABLE UserTable(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT NOT NULL, Gender TEXT NOT NULL)"
        );
        db.execSQL(
                "CREATE TABLE BabyTable(Child_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                        ", ID INTEGER NOT NULL" +
                        ", Baby_Name TEXT NOT NULL" +
                        ", Baby_gender TEXT NOT NULL" +
                        ", Birth TEXT NOT NULL," +
                        " FOREIGN KEY (ID) REFERENCES UserTable(ID));"
        );
        db.execSQL(
                "CREATE TABLE DiaryTable(Diary_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                        ", Child_ID INTEGER NOT NULL" +
                        ", Today TEXT NOT NULL" +
                        ", nen TEXT " +
                        ", tuki TEXT " +
                        ", hi TEXT " +
                        ", Diary TEXT " +
                        ", Image  BLOB);"
        );
        db.execSQL(
                "CREATE TABLE ArticleTable(Article_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                        ", Article_Name TEXT NOT NULL" +
                        ", Article_text TEXT NOT NULL);"
        );
        db.execSQL(
                "CREATE TABLE FoodTable(Food_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                        ", Child_ID INTEGER NOT NULL" +
                        ", Code INTEGER NOT NULL" +
                        ", Registration_Time TEXT NOT NULL" +
                        ", jihun TEXT NOT NULL" +
                        ", IntNowdata BIGINT NOT NULL" +
                        ", syousai TEXT" +
                        ", ml INTEGER NOT NULL DEFAULT 0);"
        );
        db.execSQL(
                "CREATE TABLE SleepTable(Sleep_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                        ", Child_ID INTEGER NOT NULL" +
                        ", Code INTEGE NOT NULL" +
                        ", Registration_Time TEXT NOT NULL" +
                        ", Memo TEXT, " +
                        " FOREIGN KEY (Child_ID) REFERENCES BabyTable(Child_ID), " +
                        " FOREIGN KEY (Code) REFERENCES CodeTable(Code));"
        );
        db.execSQL(
                "CREATE TABLE BodyhealthTable(Bodyhealth_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                        ", Child_ID INTEGER NOT NULL" +
                        ", Code INTEGER NOT NULL" +
                        ", Registration_Time TEXT NOT NULL" +
                        ", Memo TEXT" +
                        ", Body_Amount TEXT NOT NULL, " +
                        " FOREIGN KEY (Child_ID) REFERENCES Baby_TABLE(Child_ID), " +
                        " FOREIGN KEY (Code) REFERENCES CodeTable(Code));"
        );
        db.execSQL(
                "CREATE TABLE HospitalTable(Hospital_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                        ", Child_ID INTEGER NOT NULL" +
                        ", Code INTEGER NOT NULL" +
                        ", Registration_Time TEXT NOT NULL" +
                        ", Memo TEXT" +
                        ", Vaccination TEXT, " +
                        " FOREIGN KEY (Child_ID) REFERENCES BabyTable(Child_ID), " +
                        " FOREIGN KEY (Code) REFERENCES CodeTable(Code));"
        );
        db.execSQL(
                "CREATE TABLE ExcretionTable(Excretion_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                        ", Child_ID INTEGER NOT NULL" +
                        ", Code INTEGER NOT NULL" +
                        ", Registration_Time TEXT NOT NULL" +
                        ", Memo TEXT," +
                        " FOREIGN KEY (Child_ID) REFERENCES BabyTable(Child_ID), " +
                        " FOREIGN KEY (Code) REFERENCES CodeTable(Code));"
        );
        db.execSQL(
                "CREATE TABLE CodeTable(Code INTEGER PRIMARY KEY AUTOINCREMENT" +
                        ", Class TEXT NOT NULL" +
                        ", Code_Name TEXT NOT NULL);"
        );
        db.execSQL(
                "CREATE TABLE ListViewTable(IntNowdata BIGINT PRIMARY KEY " +
                        ", Code INTEGER NOT NULL" +
                        ", jihun TEXT NOT NULL" +
                        ", syousai TEXT " +
                        ", Child_ID INTEGER );"
        );
        db.execSQL(
                "INSERT INTO BodyhealthTable(Child_ID, Code,Registration_Time,Body_Amount ) VALUES(2,28,'2021年2月3日',130)"
        );

        String[] Class = {"食事","食事","食事","食事","食事"
                ,"食事","食事","食事","食事","食事"
                ,"食事","食事", "睡眠","睡眠","睡眠"
                ,"排泄", "排泄", "排泄","病院","病院"
                ,"病院","病院","病院","病院","病院"
                , "身体","身体","身体"};
        String[] Code_Name = {"授乳時間", "授乳左", "授乳右", "母乳時間", "母乳左"
                ,"母乳右", "ミルク", "ごはん", "飲み物", "離乳食"
                ,"おやつ", "搾母乳", "寝る", "起きる", "ふろ"
                ,"うんこ", "尿", "両方", "せき", "げろ"
                ,"発疹", "けが", "病院", "予防接種", "薬"
                ,"体温", "身長", "体温"};

        String[] Article_Name = {"生後1ヶ月のおすすめ記事","生後2ヶ月のおすすめ記事","生後3ヶ月のおすすめ記事"
                ,"生後4ヶ月のおすすめ記事","生後5ヶ月のおすすめ記事","生後6ヶ月のおすすめ記事"
                ,"生後7ヶ月のおすすめ記事","生後8ヶ月のおすすめ記事","生後9ヶ月のおすすめ記事"
                ,"生後10ヶ月のおすすめ記事","生後11ヶ月のおすすめ記事","生後1年0ヶ月のおすすめ記事"
                ,"生後1年1ヶ月のおすすめ記事","生後1年2ヶ月のおすすめ記事","生後1年3ヶ月のおすすめ記事"
                ,"生後1年4ヶ月のおすすめ記事","生後1年5ヶ月のおすすめ記事","生後1年6ヶ月のおすすめ記事"
                ,"生後1年7ヶ月のおすすめ記事","生後1年8ヶ月のおすすめ記事","生後1年9ヶ月のおすすめ記事"
                ,"生後1年10ヶ月のおすすめ記事","生後1年11ヶ月のおすすめ記事","生後2年0ヶ月のおすすめ記事"
                ,"生後2年1ヶ月のおすすめ記事","生後2年2ヶ月のおすすめ記事","生後2年3ヶ月のおすすめ記事"
                ,"生後2年4ヶ月のおすすめ記事","生後2年5ヶ月のおすすめ記事","生後2年6ヶ月のおすすめ記事"
                ,"生後2年7ヶ月のおすすめ記事","生後2年8ヶ月のおすすめ記事","生後2年9ヶ月のおすすめ記事"
                ,"生後2年10ヶ月のおすすめ記事","生後2年11ヶ月のおすすめ記事"};

        String[] Article_text ={"ミルク"};

        db.beginTransaction();

        try{
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO "+ Code_TABLE +"(Class, Code_Name) VALUES(?,?)"
            );
            for (int i = 0; i < Code_Name.length; i++){
                sql.bindString(1, Class[i]);
                sql.bindString(2, Code_Name[i]);
                sql.executeInsert();//実行
            }

            SQLiteStatement sql2 = db.compileStatement(
                    "INSERT INTO "+ Article_TABLE +"(Article_Name, Article_text) VALUES(?,?)"
            );
            for (int i = 0; i < Article_text.length; i++){
                sql2.bindString(1, Article_Name[i]);
                sql2.bindString(2, Article_text[i]);
                sql2.executeInsert();//実行
            }
            db.setTransactionSuccessful();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        アップデートの判定
        db.execSQL(
                "DROP TABLE IF EXISTS " + User_TABLE
        );
        db.execSQL(
                "DROP TABLE IF EXISTS " + Baby_TABLE
        );
        db.execSQL(
                "DROP TABLE IF EXISTS " + Diary_TABLE
        );
        db.execSQL(
                "DROP TABLE IF EXISTS " + Article_TABLE
        );
        db.execSQL(
                "DROP TABLE IF EXISTS " + Food_TABLE
        );
        db.execSQL(
                "DROP TABLE IF EXISTS " + Sleep_TABLE
        );
        db.execSQL(
                "DROP TABLE IF EXISTS " + Bodyhealth_TABLE
        );
        db.execSQL(
                "DROP TABLE IF EXISTS " + Hospital_TABLE
        );
        db.execSQL(
                "DROP TABLE IF EXISTS " + Excretion_TABLE
        );
        db.execSQL(
                "DROP TABLE IF EXISTS " + Code_TABLE
        );
        onCreate(db);
    }

}
