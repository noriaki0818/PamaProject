package com.example.pamaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class article_list extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemClickListener , SearchView.OnQueryTextListener {

    ListView listview;
    ArrayAdapter<String> adapter;
    ImageButton articleMenuBtn;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);

        listview = (ListView)findViewById(R.id.article_listview);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item);

        adapter.add("生後1ヶ月におすすめの記事");
        adapter.add("生後2ヶ月におすすめの記事");
        adapter.add("生後3ヶ月におすすめの記事");
        adapter.add("生後4ヶ月におすすめの記事");
        adapter.add("生後5ヶ月におすすめの記事");
        adapter.add("生後6ヶ月におすすめの記事");
        adapter.add("生後7ヶ月におすすめの記事");
        adapter.add("生後8ヶ月におすすめの記事");
        adapter.add("生後9ヶ月におすすめの記事");
        adapter.add("生後10ヶ月におすすめの記事");
        adapter.add("生後11ヶ月におすすめの記事");
        adapter.add("生後1年0ヶ月におすすめの記事");
        adapter.add("生後1年1ヶ月におすすめの記事");
        adapter.add("生後1年2ヶ月におすすめの記事");
        adapter.add("生後1年3ヶ月におすすめの記事");
        adapter.add("生後1年4ヶ月におすすめの記事");
        adapter.add("生後1年5ヶ月におすすめの記事");
        adapter.add("生後1年6ヶ月におすすめの記事");
        adapter.add("生後1年7ヶ月におすすめの記事");
        adapter.add("生後1年8ヶ月におすすめの記事");
        adapter.add("生後1年9ヶ月におすすめの記事");
        adapter.add("生後1年10ヶ月におすすめの記事");
        adapter.add("生後1年11ヶ月におすすめの記事");
        adapter.add("生後2年0ヶ月におすすめの記事");
        adapter.add("生後2年1ヶ月におすすめの記事");
        adapter.add("生後2年2ヶ月におすすめの記事");
        adapter.add("生後2年3ヶ月におすすめの記事");
        adapter.add("生後2年4ヶ月におすすめの記事");
        adapter.add("生後2年5ヶ月におすすめの記事");
        adapter.add("生後2年6ヶ月におすすめの記事");
        adapter.add("生後2年7ヶ月におすすめの記事");
        adapter.add("生後2年8ヶ月におすすめの記事");
        adapter.add("生後2年9ヶ月におすすめの記事");
        adapter.add("生後2年10ヶ月におすすめの記事");
        adapter.add("生後2年11ヶ月におすすめの記事");
        adapter.add("生後3年0ヶ月におすすめの記事");

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView)parent;

                String item = (String)listView.getItemAtPosition(position);
                intent = new Intent(getApplication(), Menu_Baby.class);
                startActivity(intent);
            }
        });

        //メニューボタンの追加
        articleMenuBtn = (ImageButton) findViewById(R.id.article_menu);
        articleMenuBtn.setOnClickListener( this );

        //SearchViewの実装
        SearchView search = (SearchView) findViewById(R.id.article_search);


        // SearchViewの初期表示状態を設定
        search.setIconifiedByDefault(false);

        // SearchViewにOnQueryChangeListenerを設定
        search.setOnQueryTextListener(this);

        // SearchViewのSubmitボタンを使用不可にする
        search.setSubmitButtonEnabled(true);

        // SearchViewに何も入力していない時のテキストを設定
        search.setQueryHint("検索文字を入力して下さい。");



    }

    @Override
    public void onClick(View view) {
        if (view == articleMenuBtn){
            intent = new Intent(getApplication(), Menu_Baby.class);
            startActivity(intent);
        }
        adapter.remove( "a");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ListView listView = (ListView)adapterView;
        String item = (String)listView.getItemAtPosition(i);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if (TextUtils.isEmpty(query)) {
            listview.clearTextFilter();
        } else {
            listview.setFilterText(query.toString());
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        return false;
    }
}