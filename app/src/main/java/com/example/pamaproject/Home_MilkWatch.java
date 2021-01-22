package com.example.pamaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class Home_MilkWatch extends AppCompatActivity implements
        Runnable, View.OnClickListener {

    private long startTime;

    private TextView timerText;
    private Button left_start,right_start,stop;

    // 'Handler()' is deprecated as of API 30: Android 11.0 (R)
    private final Handler handler = new Handler(Looper.getMainLooper());
    private volatile boolean stopRun = false;

    private final SimpleDateFormat dataFormat =
            new SimpleDateFormat("mm:ss", Locale.JAPAN);


    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__milk_watch);

        timerText = findViewById(R.id.timer);
        timerText.setText(dataFormat.format(0));
        timerText.setTextColor(Color.RED);

        left_start = findViewById(R.id.left_start_button);
        left_start.setOnClickListener(this);

        right_start = findViewById(R.id.right_start_button);
        right_start.setOnClickListener(this);

        stop = findViewById(R.id.stop_button);
        stop.setOnClickListener(this);

        left_start.setBackgroundColor(Color.YELLOW);
        right_start.setBackgroundColor(Color.YELLOW);
        stop.setBackgroundColor(Color.YELLOW);
        left_start.setTextColor(Color.BLACK);
        right_start.setTextColor(Color.BLACK);
        stop.setTextColor(Color.BLACK);

    }

    @Override
    public void onClick(View v) {
        Thread thread;
        if (v == left_start){
            stopRun = false;
            thread = new Thread(this);
            thread.start();

            startTime = System.currentTimeMillis();

        }
        else if (v == right_start){
            stopRun = false;
            thread = new Thread(this);
            thread.start();

            startTime = System.currentTimeMillis();

        }
        else{
            stopRun = true;
            timerText.setText(dataFormat.format(0));
            intent = new Intent(this, Home.class);
            startActivity(intent);
        }
    }

    @Override
    public void run() {
        // 10 msec order
        int period = 10;

        while (!stopRun) {
            // sleep: period msec
            try {
                Thread.sleep(period);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                stopRun = true;
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    long endTime = System.currentTimeMillis();
                    // カウント時間 = 経過時間 - 開始時間
                    long diffTime = (endTime - startTime);

                    timerText.setText(dataFormat.format(diffTime));

                }
            });
        }
    }
}