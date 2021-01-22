package com.example.pamaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Nikki_tosibetu extends AppCompatActivity implements View.OnClickListener {
    ImageButton bo_menu,bo_record,bo_nikki,bo_article,bo_summary;

    String nikki_nen ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nikki_tosibetu);

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

        //親要素のリスト
        List<String> makers = new ArrayList<>();
        makers.add("2020");
        makers.add("2021");
        makers.add("2022");

        //子要素のリスト
        List<String> cars_toyota = new ArrayList<>();
        cars_toyota.add("1");
        cars_toyota.add("2");
        cars_toyota.add("3");
        cars_toyota.add("4");
        cars_toyota.add("5");
        cars_toyota.add("6");
        cars_toyota.add("7");
        cars_toyota.add("8");
        cars_toyota.add("9");
        cars_toyota.add("10");
        cars_toyota.add("11");
        cars_toyota.add("12");

        List<List<String>> cars = new ArrayList<>();
        cars.add(cars_toyota);
        cars.add(cars_toyota);


        //ExpandableListViewの初期化
        ExpandableListView exListView = findViewById(R.id.exlistview);
        CarMakerListAdapter adapter = new CarMakerListAdapter(this, makers, cars);
        exListView.setAdapter(adapter);

        exListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //子要素をタップした時の処理
                //このサンプルではToastメッセージを表示するだけ
                CarMakerListAdapter adapter1 = (CarMakerListAdapter) parent.getExpandableListAdapter();
                String makername =  (String)adapter1.getGroup(groupPosition);       //親要素からメーカー名を取得
                String carname = (String)adapter1.getChild(groupPosition, childPosition);   //子要素から車名を取得
//                Toast.makeText(getApplicationContext(), makername + " : " + carname, Toast.LENGTH_LONG).show();  //Toast生成

                Intent intent = new Intent(getApplication(), Nikki.class);
                intent.putExtra("tuki",carname);
                startActivity(intent);

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
        public int getChildrenCount(int groupPosition) {
            return listCar.get(groupPosition).size();   //子要素の数を返す
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


        }
        if(v == bo_summary){
            intent = new Intent(this,Home_summary.class);
            startActivity(intent);
        }
    }
}