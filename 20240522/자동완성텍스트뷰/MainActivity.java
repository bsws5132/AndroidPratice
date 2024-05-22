package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] items = {"CSI-뉴욕","CSI-뉴욕","CSI-뉴욕","Friends","Fringe","Lost",};

        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.AutocomTV);
        MultiAutoCompleteTextView multi = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoTV);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,items);
        auto.setAdapter(adapter);


        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multi.setTokenizer(token);
        multi.setAdapter(adapter);


    }
}