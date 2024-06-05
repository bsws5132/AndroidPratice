package com.example.a4_2picture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView text1, text2;
    Switch switchAgree;

    RadioGroup rGroup1;

    RadioButton rdoDog, rdoCat, rdoRabbit;

    Button btn_shutdown, btn_reset;

    ImageView imgPet;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        text2 = (TextView) findViewById(R.id.Text2);

        switchAgree = (Switch) findViewById(R.id.SwitchAgree);

        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);

        rdoDog = (RadioButton) findViewById(R.id.RdoDog);
        rdoCat = (RadioButton) findViewById(R.id.RdoCat);
        rdoRabbit = (RadioButton) findViewById(R.id.RdoRabbit);


        btn_shutdown = (Button) findViewById(R.id.BtnShutDown);
        btn_reset = (Button) findViewById(R.id.BtnReset);

        imgPet = (ImageView) findViewById(R.id.ImgPet);

        switchAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton CompoundButton, boolean b) {
                if(switchAgree.isChecked()==true)
                {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);

                    btn_reset.setVisibility(View.VISIBLE);
                    btn_shutdown.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                    imgPet.setImageResource(0);
                }
                else
                {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);

                    btn_reset.setVisibility(View.INVISIBLE);
                    btn_shutdown.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });


        rdoDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgPet.setImageResource(R.drawable.a12);
            }
        });

        rdoCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgPet.setImageResource(R.drawable.a13);
            }
        });

        rdoRabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgPet.setImageResource(R.drawable.a14);
            }
        });




        btn_shutdown.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setVisibility(View.INVISIBLE);
                rGroup1.setVisibility(View.INVISIBLE);
                btn_reset.setVisibility(View.INVISIBLE);
                btn_shutdown.setVisibility(View.INVISIBLE);
                imgPet.setVisibility(View.INVISIBLE);

                rGroup1.clearCheck();
                switchAgree.setChecked(false);
            }
        });

    }
}