package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;



    RadioGroup rGroup;

    RadioButton rdoCal, rdoTime;

    DatePicker dPicker;

    TimePicker tPicker;

    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chrono = (Chronometer) findViewById(R.id.chronometer);



        rGroup = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoCal = (RadioButton) findViewById(R.id.Rdocal);
        rdoTime = (RadioButton) findViewById(R.id.Rdotime);

        dPicker = (DatePicker)  findViewById(R.id.DatePicker1);
        tPicker = (TimePicker) findViewById(R.id.Timepicker1);

        tvYear = (TextView) findViewById(R.id.TvYear);
        tvDay = (TextView) findViewById(R.id.TvDay);
        tvHour = (TextView) findViewById(R.id.TvHour);
        tvMonth = (TextView) findViewById(R.id.TvMonth);
        tvMinute = (TextView) findViewById(R.id.TvMinute);

        rGroup.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);
        dPicker.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                dPicker.setVisibility(View.INVISIBLE);
            }
        });

        chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
                rGroup.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.INVISIBLE);

            }
        });


        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));
                tvDay.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));

                return false;
            }
        });

        dPicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                selectYear = year;
                selectMonth = monthOfYear + 1;
                selectDay = dayOfMonth;
            }
        });






/*
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
            }
        });

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1;
                selectDay = dayOfMonth;
            }
        });

 */

    }
}

