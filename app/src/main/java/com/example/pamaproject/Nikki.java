package com.example.pamaproject;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    String tuki,nen;
    int today = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nikki);

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

        TextView txt_tuki= (TextView)findViewById(R.id.txt_tuki);
        TextView txt_nen = (TextView)findViewById(R.id.txt_nen);

        //前の画面から年月を取得
        Intent intent;
        intent = getIntent();
        tuki = intent.getStringExtra("tuki");
        nen = intent.getStringExtra("nen");

        //ない場合
        if(tuki ==null){

            int thisyear =getNowyear();
            nen = String.valueOf(thisyear);
            txt_nen.setText(nen+"年");

            int thismonth =getNowmonth();
            tuki = String.valueOf(thismonth);
            txt_tuki.setText(tuki+"月");
            today +=1;

        }else{

            txt_nen.setText(nen+"年");
            txt_tuki.setText(tuki+"月");

        }




        //dbから持ってきたデータをlistに入れる
        //日
        hi.add("1");
        hi.add("2");
        hi.add("3");
        hi.add("4");
        //内容

        nai.add("さ");
        nai.add("む");
        nai.add("ら");
        nai.add("い");

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
}