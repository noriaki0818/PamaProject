package com.example.pamaproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

public class BirthNP extends AppCompatActivity {

    NumberPicker year, month, day;
    ImageButton done;
    Intent intent;

    private final String[] figures = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_n_p);

        year = (NumberPicker) findViewById(R.id.numPicker_year);
        month = (NumberPicker) findViewById(R.id.numPicker_month);
        day = (NumberPicker) findViewById(R.id.numPicker_day);
        done = (ImageButton) findViewById(R.id.birthnp_done);
        intent = getIntent();
        String babyname = intent.getStringExtra("Baby_Name");
        String babygender = intent.getStringExtra("Bbay_Gender");

        System.out.println("名前　: " +babyname + babygender);

        year.setMaxValue(2050);
        year.setMinValue(2021);

        month.setMaxValue(12);
        month.setMinValue(1);

        day.setMaxValue(31);
        day.setMinValue(1);

        done.setOnClickListener( v -> {
            figures[0] = String.valueOf(year.getValue());
            figures[1] = String.valueOf(month.getValue());
            figures[2] = String.valueOf(day.getValue());

            String birthday = String.format("%s年%s月%s日",
                    figures[0], figures[1], figures[2]);

            System.out.println(birthday);
            intent = new Intent(this, Start_Babyinfo.class);
            intent.putExtra("birth",birthday);
            intent.putExtra("babyname", babyname);
            intent. putExtra("babygender", babygender);
            startActivity(intent);
        });

    }
}