package com.example.pictureview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.util.Arrays;

public class MainActivity extends Activity {

    Button btnPrev, btnNext;
    myPictureView myPicture;
    int curNum = 0;
    File[] imageFiles = new File[0];
    String imageFname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        btnPrev = (Button) findViewById(R.id.BtnPrev);
        btnNext = (Button) findViewById(R.id.BtnNext);
        myPicture = (myPictureView) findViewById(R.id.MyPictureView1);

        File[] allFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures").listFiles();

        for(int i = 0; i<allFiles.length; i++)
        {
            if(allFiles[i].isFile()==true)
            {
                imageFiles = Arrays.copyOf(imageFiles, imageFiles.length+1);
                imageFiles[imageFiles.length-1] = allFiles[i];
            }
        }
        imageFname = imageFiles[curNum].toString();
        myPicture.imagePath = imageFname;

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curNum <= 0)
                {
                    Toast.makeText(getApplicationContext(),"첫번쨰 그림",Toast.LENGTH_SHORT).show();
                    curNum = imageFiles.length -1;
                }
                else
                {
                    curNum--;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath=imageFname;
                    myPicture.invalidate();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(curNum >= imageFiles.length-1)
                {
                    Toast.makeText(getApplicationContext(),"마지막 그림",Toast.LENGTH_SHORT).show();
                    curNum =0;
                }
                else
                {
                    curNum++;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath=imageFname;
                    myPicture.invalidate();
                }
            }
        });
    }
}