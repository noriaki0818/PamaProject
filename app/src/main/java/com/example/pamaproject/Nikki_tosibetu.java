package com.example.pamaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Nikki_tosibetu extends AppCompatActivity implements View.OnClickListener {
    ImageButton bo_menu,bo_record,bo_nikki,bo_article,bo_summary;
    private DBHelper helper=null;
    String cid;

    List<String> nen1 = new ArrayList<>();
    List<String> tuki1 = new ArrayList<>();
    List<List<String>> cars = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nikki_tosibetu);

        helper = new DBHelper(this);
        //データベースを取得
        SQLiteDatabase db = helper.getWritableDatabase();

        try {
            Toast.makeText(this, "DBに接続完了", Toast.LENGTH_SHORT).show();

        }finally {
            db.close();
        }

        //ボタン設定
        bo_menu = (ImageButton)findViewById(R.id.bo_menu);
        bo_record = (ImageButton)findViewById(R.id.bo_record);
        bo_nikki = (ImageButton)findViewById(R.id.bo_nikki);
        bo_article = (ImageButton)findViewById(R.id.Summary_Food_article);
        bo_summary = (ImageButton)findViewById(R.id.Summary_Food_summary);
        bo_menu.setOnClickListener(this);
        bo_record.setOnClickListener(this);
        bo_nikki.setOnClickListener(this);
        bo_article.setOnClickListener(this);
        bo_summary.setOnClickListener(this);

        Intent intent;
        intent = getIntent();
        cid =intent.getStringExtra("child_id");

        getNikkiYear(cid);


        //親要素のリスト

//        nen1.add("2020");
//        nen1.add("2021");
//        nen1.add("2022");

        //子要素のリスト

//        tuki1.add("1");
//        tuki1.add("2");
//        tuki1.add("3");
//        tuki1.add("4");
//        tuki1.add("5");
//        tuki1.add("6");
//        tuki1.add("7");
//        tuki1.add("8");
//        tuki1.add("9");
//        tuki1.add("10");
//        tuki1.add("11");
//        tuki1.add("12");


//        cars.add(tuki1);
//        cars.add(tuki1);
//        cars.add(tuki1);

        for(int i = 0 ; i < nen1.size() ; i++){
            tuki1.clear();
            String nen2 = nen1.get(i);
            getNikkiMonth(cid,nen2);
            cars.add(tuki1);
        }



        //ExpandableListViewの初期化
        ExpandableListView exListView = findViewById(R.id.exlistview);
        CarMakerListAdapter adapter = new CarMakerListAdapter(this, nen1,cars);
        exListView.setAdapter(adapter);

        exListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //子要素をタップした時の処理

                CarMakerListAdapter adapter1 = (CarMakerListAdapter) parent.getExpandableListAdapter();
                String nen =  (String)adapter1.getGroup(groupPosition);       //親要素からメーカー名を取得
                String tuki = (String)adapter1.getChild(groupPosition, childPosition);   //子要素から車名を取得
                //Toast.makeText(getApplicationContext(), nen1, Toast.LENGTH_LONG).show();  //Toast生成

                Intent intent = new Intent(getApplication(), Nikki.class);
                intent.putExtra("tuki",tuki);
                intent.putExtra("nen",nen);
                intent.putExtra("child_id",cid);
                startActivity(intent);
                finish();
                return true;

            }
        });
    }




    class CarMakerListAdapter extends BaseExpandableListAdapter {
        //メンバ変数
        List<String> listMaker;     //親要素のリスト
        List<List<String>> listCar; //子要素のリスト
        Context context;

        //コンストラクタ
        CarMakerListAdapter (Context context, List<String> listMaker, List<List<String>> listCar) {
            this.context    = context;
            this.listMaker = listMaker;
            this.listCar = listCar;
        }

        @Override
        public int getGroupCount() {
            return listMaker.size();    //親要素の数を返す
        }

        @Override
        public int getChildrenCount(int childPosition) {

            return listCar.get(childPosition).size();   //子要素の数を返す

        }

        @Override
        public Object getGroup(int groupPosition) {
            return listMaker.get(groupPosition);    //親要素を取得
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return listCar.get(groupPosition).get(childPosition);   //子要素を取得
        }

        @Override
        public long getGroupId(int groupPosition) {
            //親要素の固有IDを返す
            //このサンプルでは固有IDは無いので0
            return 0;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            //子要素の固有IDを返す
            //このサンプルでは固有IDは無いので0
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            //固有IDを持つかどうかを返す
            //このサンプルでは持たないのでfalse
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            //親要素のレイアウト生成
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listitem_makers, parent, false);
            }
            TextView tv = convertView.findViewById(R.id.listitem_makers_name);
            tv.setText(listMaker.get(groupPosition));
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            //子要素のレイアウト生成
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listitem_cars, parent, false);
            }
            TextView tv = convertView.findViewById(R.id.listitem_cars_name);
            tv.setText(listCar.get(groupPosition).get(childPosition));
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            //子要素がタップ可能かどうかを返す
            //このサンプルでは可能にするのでtrue
            return true;
        }
    }

    //画面遷移
    @Override
    public void onClick(View v) {
        Intent intent;
        if(v == bo_menu){
            intent = new Intent(this, Menu_Baby.class);
            startActivity(intent);
        }
        if(v == bo_record){
            intent = new Intent(this,Home.class);
            startActivity(intent);
        }
        if(v == bo_article){
            intent = new Intent(this,Article_list.class);
            startActivity(intent);
        }
        if(v == bo_summary){
            intent = new Intent(this,Home_summary.class);
            startActivity(intent);
        }
    }

    private void getNikkiYear(String cid) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = null;
        String c = null;
        String c2 = null;
        try {
            String[] getcols = {"nen"};//0,1,2
            String[] SearchKey = {cid};
            cs = db.query("DiaryTable", getcols, "Child_ID = ? ", SearchKey, null, null, "nen ASC",null);
            if (cs.moveToFirst()) {
                for(int i = 0;i < cs.getCount();i++) {

                    String kirokunen = cs.getString(0);
                    c =kirokunen;

                    if(c2 == null){
                        nen1.add(kirokunen);
                        System.out.println("年"+kirokunen+"を取得。add");
                        c2 =kirokunen;
                    }else if(c == c2){

                    }else if(c != c2){
                        nen1.add(kirokunen);
                        System.out.println("年"+kirokunen+"を取得。add");
                        c2 =kirokunen;
                    }

                    System.out.println("DiaryTable、記録年:"+kirokunen+"、を取得。");

                    cs.moveToNext();
                }
            }else{
                Toast.makeText(this, "いみわかんね2", Toast.LENGTH_SHORT).show();
            }
        } finally {
            cs.close();
            db.close();
        }
    }
    private void getNikkiMonth(String cid,String nen2) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = null;

        try {
            String[] getcols = {"tuki",};//0,1,2
            String[] SearchKey = {cid,nen2};
            cs = db.query("DiaryTable", getcols, "Child_ID = ? AND nen = ?", SearchKey, null, null, "nen ASC",null);
            if (cs.moveToFirst()) {
                for(int i = 0;i < cs.getCount();i++) {

                    String kirokutuki = cs.getString(0);
                    tuki1.add(kirokutuki);



                    System.out.println("DiaryTable、記録tuki:"+kirokutuki+"、を取得。");

                    cs.moveToNext();
                }
            }else{
                Toast.makeText(this, "いみわかんね2", Toast.LENGTH_SHORT).show();
            }
        } finally {
            cs.close();
            db.close();
        }
    }

}