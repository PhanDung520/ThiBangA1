package com.example.thibanga1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
ImageView imgSaHinh;
TextView txtLuyenThiBLX;
LinearLayout imgMenuHocLT, imgMenuBienBao, imgMenuThiSatHach, imgMenuMeoThi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidget();
        SetEventClick();

    }
    public void InitWidget(){

        txtLuyenThiBLX = (TextView) findViewById(R.id.txtLuyenThiBLX);
        imgMenuHocLT =  findViewById(R.id.imgMenuHocLT);
        imgMenuBienBao =  findViewById(R.id.imgMenuBienBao);
        imgMenuThiSatHach =  findViewById(R.id.imgMenuThiSatHach);
        imgMenuMeoThi = findViewById(R.id.imgMenuMeoThi);
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