package com.example.simplediary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;

    EditText edtDiary;

    Button btnWrite;

    String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = (DatePicker) findViewById(R.id.DatePicker1);
        edtDiary = (EditText) findViewById(R.id.EdtDiary);
        btnWrite = (Button) findViewById(R.id.BtnWrite);

        Calendar cal = Calendar.getInstance();
        int Year = cal.get(Calendar.YEAR);
        int Month = cal.get(Calendar.MONTH);
        int Day = cal.get(Calendar.DAY_OF_MONTH);

        dp.init(Year, Month, Day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int i, int i1, int i2) {
                filename = Integer.toString(i) + "_" +
                        Integer.toString(i1 + 1) +"_" +
                        Integer.toString(i2) + ".txt";
                String str = readDiary(filename);
                edtDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    FileOutputStream outFs = openFileOutput(filename, Context.MODE_PRIVATE);
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), filename+"이 저장됨", Toast.LENGTH_SHORT).show();
                }
                catch (IOException e)
                {

                }
            }
        });

    }

    String readDiary(String fname)
    {
        String diaryStr = null;
        try
        {
            FileInputStream infs = openFileInput(fname);
            byte[] txt = new byte[500];
            infs.read(txt);
            infs.close();
            diaryStr = (new String(txt)).trim();
            btnWrite.setText("수정하기");
        }
        catch (IOException e)
        {
            edtDiary.setHint("일기 없음");
            btnWrite.setText("새로 저장");
        }
        return diaryStr;
    }



}