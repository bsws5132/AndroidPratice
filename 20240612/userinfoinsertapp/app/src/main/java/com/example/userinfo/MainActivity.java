package com.example.userinfo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText tvName, tvEmail;

    Button btn1;
    EditText dlgEdtName,dlgEdtEmail;

    TextView toastText;

    View dialogView, toastView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = (EditText)  findViewById(R.id.Tvname);
        tvEmail = (EditText) findViewById(R.id.TvEmail);
        btn1 = (Button) findViewById(R.id.Btn1);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View) View.inflate(MainActivity.this,R.layout.dialog1, null);

                dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                dlgEdtEmail = (EditText) dialogView.findViewById(R.id.dlgEdt2);

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView);
                dlgEdtName.setText(tvName.getText().toString());
                dlgEdtName.setText(tvEmail.getText().toString());
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvName.setText(dlgEdtName.getText().toString());
                        tvEmail.setText(dlgEdtEmail.getText().toString());
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                        toastText = (TextView) toastView.findViewById(R.id.ToastText1);
                        toastText.setText("취소!");
                        toast.setView(toastView);
                        Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int Xoffset = (int) (Math.random()*display.getWidth());
                        int Yoffset = (int) (Math.random()*display.getHeight());
                        toast.setGravity(Gravity.TOP|Gravity.LEFT, Xoffset, Yoffset);
                        toast.show();
                    }
                });
                dlg.show();
            }
        });
    }
}