package com.example.pamaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Summary_height extends AppCompatActivity implements View.OnClickListener {
    private DBHelper helper = null;
    private static SQLiteDatabase db;
    protected BarChart chart;
    ImageView menu,left,right,
            food,unko,sleep,height,weight;
    ImageButton record,diary,article,summary;
    TextView next, back;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_summary);
        chart = (BarChart) findViewById(R.id.Summary_bar_chart);

        menu =(ImageView)findViewById(R.id.Summary_menu) ;
        left =(ImageView)findViewById(R.id.Summary_bo_daybefore2) ;
        right =(ImageView)findViewById(R.id.Summary_bo_nextday2) ;
        food =(ImageView)findViewById(R.id.summary_imageView) ;
        unko =(ImageView)findViewById(R.id.summary_imageView2) ;
        sleep =(ImageView)findViewById(R.id.summary_imageView3) ;
        height =(ImageView)findViewById(R.id.summary_imageView4) ;
        weight =(ImageView)findViewById(R.id.summary_imageView5) ;
        record=(ImageButton)findViewById(R.id.Summary_bo_record) ;
        diary =(ImageButton)findViewById(R.id.Summary_bo_diary) ;
        article =(ImageButton)findViewById(R.id.Summary_bo_article) ;
        summary =(ImageButton)findViewById(R.id.Summary_bo_summary) ;

        next =(TextView)findViewById(R.id.Summary_textView) ;
        back =(TextView)findViewById(R.id.Summary_textView3);

        menu.setOnClickListener(this);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        food.setOnClickListener(this);
        unko.setOnClickListener(this);
        sleep.setOnClickListener(this);
        height.setOnClickListener(this);
        weight.setOnClickListener(this);
        record.setOnClickListener(this);
        diary.setOnClickListener(this);
        article.setOnClickListener(this);
        summary.setOnClickListener(this);
        next.setOnClickListener(this);
        back.setOnClickListener(this);

        //ヘルパーの準備
        helper = new DBHelper(this);
        //データベースを取得
        SQLiteDatabase db = helper.getWritableDatabase();

        try {
            Toast.makeText(this, "DBに接続完了", Toast.LENGTH_SHORT).show();

        } finally {
            db.close();
        }

        //ボタンの色を変える
        summary.setBackgroundColor(Color.WHITE);
        food.setBackgroundColor(Color.RED);
        unko.setBackgroundColor(Color.RED);
        sleep.setBackgroundColor(Color.RED);
        height.setBackgroundColor(Color.CYAN);
        weight.setBackgroundColor(Color.RED);

        //時間
        String now = getNowDate();
        String now2 = getNowDate();

        //テキスト
        next.setText("2021/2/1");
        back.setText(now);

        //表示データ取得
        BarData data = new BarData(getBarData());
        chart.setData(data);

        //Y軸(左)
        YAxis left = chart.getAxisLeft();
        //Y軸(最低値)
        left.setAxisMinimum(75);
        left.setLabelCount(3);
        left.setDrawTopYLabelEntry(true);
        //整数表示に

        //Y軸(右)
        YAxis right = chart.getAxisRight();
        right.setDrawLabels(false);
        right.setDrawGridLines(false);
        right.setDrawZeroLine(true);
        right.setDrawTopYLabelEntry(true);




        //X軸
        XAxis xAxis = chart.getXAxis();
        //X軸に表示するLabelのリスト(最初の""は原点の位置) 日付
        final String[] labels = {"","", "9/13", "9/14","9/15","9/16",now2,now};
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        XAxis bottomAxis = chart.getXAxis();
        bottomAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        bottomAxis.setDrawLabels(true);
        bottomAxis.setDrawGridLines(false);
        bottomAxis.setDrawAxisLine(true);

        //グラフ上の表示
        chart.setDrawValueAboveBar(true);
        chart.getDescription().setEnabled(false);
        chart.setClickable(false);

        //凡例
        chart.getLegend().setEnabled(false);

        chart.setScaleEnabled(false);
    }

    //時間取得
    public static String getNowDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);    // 0 - 11eg
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        String date = (month + 1) + "/" + day;

        System.out.println(date);

        return date;
    }

    //棒グラフのデータを取得　
    private List<IBarDataSet> getBarData(){

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1, 78));
        entries.add(new BarEntry(2, 79));
        entries.add(new BarEntry(3, 79));
        entries.add(new BarEntry(4, 80));
        entries.add(new BarEntry(5, 80));
        entries.add(new BarEntry(6, 81));
        entries.add(new BarEntry(7, 82));
        List<IBarDataSet> bars = new ArrayList<>();
        BarDataSet dataSet = new BarDataSet(entries, "bar");

        //ハイライトさせない
        dataSet.setHighlightEnabled(false);

        //Barの色をセット
        dataSet.setColors( R.color.purple_200);
        bars.add(dataSet);

        return bars;
    }

    @Override
    public void onClick(View view) {

        //ヘッダー
        if (view == back){
            //前日にする
        }
        if (view == next){
            //次の日にする
        }
        if (view == menu){
            //メニュー
            intent = new Intent(this, Menu_Baby.class);
            startActivity(intent);
        }

        if (view == diary){
            //日記に飛ぶ
            intent = new Intent(this, Nikki.class);
            startActivity(intent);
        }
        if (view == record){
            //日記に飛ぶ
            intent = new Intent(this, Home.class);
            startActivity(intent);
        }
        if (view == article){
            //記事画面に飛ぶ
            intent = new Intent(this, Article.class);
            startActivity(intent);
        }
        if (view == food){
            //食事記録画面に飛ぶ
            intent = new Intent(this, Home_summary.class);
            startActivity(intent);
        }
        if (view == unko){
            //排せつ記録画面に飛ぶ
            intent = new Intent(this, Summary_unko.class);
            startActivity(intent);
        }
        if (view == sleep){
            //睡眠記録画面に飛ぶ
            intent = new Intent(this, Summary_sleep.class);
            startActivity(intent);
        }
        if (view == weight){
            //体重記録画面に飛ぶ
            intent = new Intent(this, Summary_weight.class);
            startActivity(intent);
        }
    }
}