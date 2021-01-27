package com.example.pamaproject;

public class None {


//    //    日記テーブルにデータ保存
//    public void insertDiaryTable(SQLiteDatabase db, String Child_ID, String Registration_Time, String Diary, byte[] Image) {
//        ContentValues values = new ContentValues();
//
//        values.put("Child_ID", Child_ID);
//        values.put("Registration_Time", Registration_Time);
//        values.put("Disry", Diary);
//        values.put("Image", Image);
//
//        db.insert(Diary_TABLE, null, values);
//    }

//    BitmapFactory.decodeByteArray(blob, 0, blob.length); // blobはbyte[]です


//
//    //    画像取得
//    public static byte[] getBlob(Context context, String id) {
//        SQLiteDatabase db = null;
//        Cursor cursor = null;
//        try {
//            DBHelper helper = new DBHelper(context);
//            db = helper.getReadableDatabase();
//            String sql = String.format("select %s from %s where %s = ?", Image, Diary_TABLE, Child_ID);
//            String[] args = {id};
//
//            cursor = db.rawQuery(sql, args);
//
//            if (cursor.moveToFirst()) {
//                return cursor.getBlob(0);
//            }
//            return null;
//        } finally {
//            if (cursor != null) {
//                cursor.close();
//            }
//            if (db != null) {
//                db.close();
//            }
//        }
//    }
}
