package com.example.pamaproject;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nikki extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    ImageButton bo_tukibetu,bo_record,bo_nikki,bo_article,bo_summary;

    List<String> hi = new ArrayList<>();
    List<String> nai = new ArrayList<>();
    String tuki,nen,cid;
    String today = null;

    private DBHelper helper=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nikki);
        helper = new DBHelper(this);
        //データベースを取得
        SQLiteDatabase db = helper.getWritableDatabase();

        try {
            Toast.makeText(this, "DBに接続完了", Toast.LENGTH_SHORT).show();

        }finally {
            db.close();
        }

        bo_tukibetu = (ImageButton)findViewById(R.id.bo_tukibetu);
        bo_record = (ImageButton)findViewById(R.id.bo_record);
        bo_nikki = (ImageButton)findViewById(R.id.bo_nikki);
        bo_article = (ImageButton)findViewById(R.id.Summary_Food_article);
        bo_summary = (ImageButton)findViewById(R.id.Summary_Food_summary);

        bo_tukibetu.setOnClickListener(this);
        bo_record.setOnClickListener(this);
        bo_nikki.setOnClickListener(this);
        bo_article.setOnClickListener(this);
        bo_summary.setOnClickListener(this);

        bo_nikki.setBackgroundColor(Color.WHITE);

        TextView txt_tuki= (TextView)findViewById(R.id.txt_tuki);
        TextView txt_nen = (TextView)findViewById(R.id.txt_nen);

        //前の画面から年月を取得
        Intent intent;
        intent = getIntent();
        tuki = intent.getStringExtra("tuki");
        nen = intent.getStringExtra("nen");
        cid =intent.getStringExtra("child_id");

        //ない場合
        if(tuki ==null){

            int thisyear =getNowyear();
            nen = String.valueOf(thisyear);
            txt_nen.setText(nen+"年");

            int thismonth =getNowmonth();
            tuki = String.valueOf(thismonth);
            txt_tuki.setText(tuki+"月");
            System.out.println("111111111111111111111111111111111111111111111111111111111111111111");



        }else{

            txt_nen.setText(nen+"年");
            txt_tuki.setText(tuki+"月");
            System.out.println("2222222222222222222222222222222222222222222222222222222222222222222");
            System.out.println(nen+tuki);
        }

        getNikki(cid,today,nen,tuki);

        showlistview();

    }

    private void showlistview() {
        // listを配列に入れる
        String[] hiniti = hi.toArray(new String[hi.size()]);
        String[] naiyou = nai.toArray(new String[hi.size()]);

        // ListViewに表示するリスト項目をArrayListで準備する
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (int i=0; i<hiniti.length; i++){
            Map<String, String> item = new HashMap<String, String>();
            item.put("hiniti", hiniti[i]);
            item.put("naiyou", naiyou[i]);
            data.add(item);
        }


        // リスト項目とListViewを対応付けるArrayAdapterを用意する
        SimpleAdapter adapter = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2,
                new String[] { "hiniti", "naiyou" },
                new int[] { android.R.id.text1, android.R.id.text2});

        // ListViewにArrayAdapterを設定する
        ListView listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        if(v == bo_tukibetu){
            intent = new Intent(this, Nikki_tosibetu.class);
            intent.putExtra("child_id",cid);
            startActivity(intent);
        }
        if(v == bo_record){
            intent = new Intent(this,Home.class);
            intent.putExtra("child_id",cid);
            startActivity(intent);
        }
        if(v == bo_article){
            intent = new Intent(this,Article_list.class);
            intent.putExtra("child_id",cid);
            startActivity(intent);
        }
        if(v == bo_summary){
            intent = new Intent(this,Home_summary.class);
            intent.putExtra("child_id",cid);
            startActivity(intent);
        }

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this.getApplicationContext(), Nikki_naiyou.class);
        String[] list = hi.toArray(new String[hi.size()]);
        String hi = list[i];
        String[] list2 = nai.toArray(new String[nai.size()]);
        String nai = list2[i];

        String tuki2 = tuki;
        String nen2 = nen;
        // インテントにセット
        intent.putExtra("tuki", tuki2);
        intent.putExtra("nen",nen2);
        intent.putExtra("hi", hi);
        intent.putExtra("nai",nai);
        intent.putExtra("child_id",cid);
        // Activity をスイッチする
        startActivity(intent);
    }
    public static int getNowyear() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return year;
    }
    public static int getNowmonth() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);    // 0 - 11
        return month +1;
    }

    private void getNikki(String CID,String today ,String nen ,String tuki) {

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = null;
        try {
            String[] getcols = {"hi", "Diary"};//0,1,2
            String[] SearchKey = {CID,nen,tuki};
            cs = db.query("DiaryTable", getcols, "Child_ID = ? AND nen = ? AND tuki = ?", SearchKey, null, null, "tuki ASC",null);
            if (cs.moveToFirst()) {
                for(int i = 0;i < cs.getCount();i++) {



                    String kirokutuki = cs.getString(0);

                    hi.add(kirokutuki);

                    String syousai1 = cs.getString(1);
                    nai.add(syousai1);

                    System.out.println("DiaryTable、Today:"+kirokutuki+"、Diary:"+syousai1+"を取得。");

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