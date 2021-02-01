package com.example.pamaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
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

        //ボタンの色を変える
        summary.setBackgroundColor(Color.WHITE);
        food.setBackgroundColor(Color.RED);
        unko.setBackgroundColor(Color.RED);
        sleep.setBackgroundColor(Color.RED);
        height.setBackgroundColor(Color.CYAN);
        weight.setBackgroundColor(Color.RED);

        //時間
        String bar = getWeek().get(1);
        String bar2 = getWeek().get(2);
        String bar3 = getWeek().get(3);
        String bar4 = getWeek().get(4);
        String bar5 = getWeek().get(5);
        String bar6 = getWeek().get(6);
        String bar7 = getWeek().get(7);

        //テキスト
        next.setText(getWeek().get(7));
        back.setText(getWeek().get(1));


        //表示データ取得
        BarData data = new BarData(getBarData());
        chart.setData(data);

        //Y軸(左)
        YAxis left = chart.getAxisLeft();
        //Y軸(最低値)
        left.setAxisMinimum(0);
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
        final String[] labels = {"",bar7, bar6, bar5,bar4,bar3,bar2,bar};
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

    //今日の時間
    public static String getNowDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);    // 0 - 11eg
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        String date = year + "年" + (month + 1) + "月" + day + "日　" + hour + "時" + minute + "分";

        System.out.println(date);

        return date;
    }
    //1週間
    public static ArrayList<String> getWeek() {
        String date;

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);    // 0 - 11eg
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        String Year = year + "年";
        day = day+1;
        ArrayList<String> week = new ArrayList<>();

        for (int zikan = -1;zikan<= 6;zikan++){

            if (day == 0){
                month = month-1;
                if(month ==-1){year = year -1;month = 11;date = (month +1) + "月" + (day = 31) + "日";week.add(date) ; } //12月
                else if(month ==10){month = 10;date = (month +1) + "月" + (day = 30) + "日";week.add(date); }//11月
                else if(month ==9){month = 9;date = (month +1) + "月" + (day = 31) + "日";week.add(date); }//10月
                else if(month ==8){month = 8;date = (month +1) + "月" + (day = 30) + "日";week.add(date); }//9月
                else if(month ==7){month = 7;date = (month +1) + "月" + (day = 31) + "日";week.add(date); }//8月
                else if(month ==6){month = 6;date = (month +1) + "月" + (day = 31) + "日";week.add(date); }//7月
                else if(month ==5){month = 5;date = (month +1) + "月" + (day = 30) + "日";week.add(date); }//6月
                else if(month ==4){month = 4;date = (month +1) + "月" + (day = 31) + "日";week.add(date); }//5月
                else if(month ==3){month = 3;date = (month +1) + "月" + (day = 30) + "日";week.add(date); }//4月
                else if(month ==2){month = 2;date = (month +1) + "月" + (day = 31) + "日";week.add(date); }//3月
                else if(month ==1){month = 1;date = (month +1) + "月" + (day = 28) + "日";week.add(date); }//2月
                else if(month ==0){;date = (month +1) + "月" + (day = 31) + "日";week.add(date); }//1月
            }else{
                date = (month + 1) + "月" + day + "日　";
                week.add(date);
            }

            day = day-1;
        }
        week.add(Year);
        return week;
    }

    //身長テーブルにデータ保存
    public void insertBodyhealthTable(int Child_ID,int Code,String Registration_Time, String Memo,String Body_Amount) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Body_Amount", Body_Amount);
        values.put("Registration_Time", Registration_Time);
        values.put("Code", Code);
        values.put("Memo", Memo);
        values.put("Child_ID", Child_ID);

        db.insert("BodyhealthTable", null, values);
    }
    //    Bodyhealth_IDを取得
    public int ongetBodyhealth_ID(String Registration_Time){
        int Bodyhealth_ID = 0;
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = null;
        try {
            String[] getcols = {"Bodyhealth_ID"};//0,1,2
            String[] SearchKey = {Registration_Time};
            cs = db.query("BodyhealthTable", getcols, "Registration_Time = ?", SearchKey, null, null, null, null);
            if (cs.moveToFirst()){
                Bodyhealth_ID = cs.getCount();
                Toast.makeText(this, cs.getString(0) , Toast.LENGTH_SHORT).show();
                System.out.println("Bodyhealth " + Bodyhealth_ID);
            } else if (Bodyhealth_ID == 0){
                Toast.makeText(this, "Bodyhealth_ID取れてない", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(this, "いみわかんね2", Toast.LENGTH_SHORT).show();
            }
        } finally {
            cs.close();
            db.close();
        }
        return Bodyhealth_ID;
    }

    //棒グラフのデータを取得　
    private List<IBarDataSet> getBarData() {
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<BarEntry> entries = new ArrayList<>();

        for (int x = 1; x <= 7; x++) {
            if(x == 1){
                String Get = getWeek().get(8) + getWeek().get(1);
                entries.add(new BarEntry(7, ongetBodyhealth_ID(Get)));
                System.out.println(Get);
            }
            if(x == 2){
                String Get = getWeek().get(8) + getWeek().get(2);
                entries.add(new BarEntry(6, ongetBodyhealth_ID(Get)));
            }
            if(x == 3){
                String Get = getWeek().get(8) + getWeek().get(3);
                entries.add(new BarEntry(5, ongetBodyhealth_ID(Get)));
            }if(x == 4){
                String Get = getWeek().get(8) + getWeek().get(4);
                entries.add(new BarEntry(4, ongetBodyhealth_ID(Get)));
            }
            if(x == 5){
                String Get = getWeek().get(8) + getWeek().get(5);
                entries.add(new BarEntry(3, ongetBodyhealth_ID(Get)));
            }if(x == 6){
                String Get = getWeek().get(8) + getWeek().get(6);
                entries.add(new BarEntry(2, ongetBodyhealth_ID(Get)));
            }
            if(x == 7){
                String Get = getWeek().get(8) + getWeek().get(7);
                entries.add(new BarEntry(1, ongetBodyhealth_ID(Get)));
            }
        }

        List<IBarDataSet> bars = new ArrayList<>();
        BarDataSet dataSet = new BarDataSet(entries, "bar");
        //ハイライトさせない
        dataSet.setHighlightEnabled(false);

        //Barの色をセット
        dataSet.setColors(R.color.purple_200);
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

