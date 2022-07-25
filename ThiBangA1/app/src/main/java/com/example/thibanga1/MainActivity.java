package com.example.thibanga1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
ImageView imgSaHinh;
TextView txtLuyenThiBLX;
ImageButton imgMenuHocLT, imgMenuBienBao, imgMenuThiSatHach, imgMenuMeoThi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidget();
        SetEventClick();
    }
    public void InitWidget(){
        imgSaHinh = (ImageView) findViewById(R.id.imgSaHinh);
        txtLuyenThiBLX = (TextView) findViewById(R.id.txtLuyenThiBLX);
        imgMenuHocLT = (ImageButton) findViewById(R.id.imgMenuHocLT);
        imgMenuBienBao = (ImageButton) findViewById(R.id.imgMenuBienBao);
        imgMenuThiSatHach = (ImageButton) findViewById(R.id.imgMenuThiSatHach);
        imgMenuMeoThi =(ImageButton) findViewById(R.id.imgMenuMeoThi);
    }

    public void SetEventClick(){
        imgMenuHocLT.setOnClickListener(this);
        imgMenuBienBao.setOnClickListener(this);
        imgMenuThiSatHach.setOnClickListener(this);
        imgMenuMeoThi.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.imgMenuHocLT:
                intent = new Intent(MainActivity.this, LyThuyetActivity.class);
                startActivity(intent);
                break;
            case R.id.imgMenuBienBao:
                intent = new Intent(MainActivity.this, BienbaogiaothongActivity.class);
                startActivity(intent);
                break;
            case R.id.imgMenuThiSatHach:
                intent = new Intent(MainActivity.this, ThiActivity.class);
                startActivity(intent);
                break;
            case R.id.imgMenuMeoThi:
                intent = new Intent(MainActivity.this, MeothiActivity.class);
                startActivity(intent);
                break;
        }
    }
}