package com.example.pamaproject;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nikki extends AppCompatActivity implements View.OnClickListener {
    ImageButton bo_tukibetu,bo_record,bo_nikki,bo_article,bo_summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nikki);

        bo_tukibetu = (ImageButton)findViewById(R.id.bo_tukibetu);
        bo_record = (ImageButton)findViewById(R.id.bo_record);
        bo_nikki = (ImageButton)findViewById(R.id.bo_nikki);
        bo_article = (ImageButton)findViewById(R.id.bo_article);
        bo_summary = (ImageButton)findViewById(R.id.bo_summary);

        bo_tukibetu.setOnClickListener(this);
        bo_record.setOnClickListener(this);
        bo_nikki.setOnClickListener(this);
        bo_article.setOnClickListener(this);
        bo_summary.setOnClickListener(this);

        Intent intent;
        intent = getIntent();
        String m = intent.getStringExtra("tuki");
        Toast.makeText(this,m,Toast.LENGTH_SHORT).show();


        //dbから持ってきたデータをlistに入れる
        //日
        List<String> hi = new ArrayList<>();
        hi.add("1");
        hi.add("2");
        hi.add("3");
        hi.add("4");
        //内容
        List<String> nai = new ArrayList<>();
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

        }
        if(v == bo_summary){
            intent = new Intent(this,Home_summary.class);
            startActivity(intent);
        }

    }
}