package com.example.thibanga1;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.thibanga1.R;
import com.example.thibanga1.lythuyet.LuatgiaothongActivity;
import com.example.thibanga1.lythuyet.QuestionCauDiemlietActivity;
import com.example.thibanga1.lythuyet.SahinhActivity;

public class LyThuyetActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar tbbackactivity;
    CardView cvCaudiemliet,cvKhainiem,cviewsahinh;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ly_thuyet);
        backactivity();
        getViews();

    }
    public void backactivity(){
        tbbackactivity = (Toolbar) findViewById(R.id.tbbackactivity);
        setSupportActionBar(tbbackactivity);
        tbbackactivity.setNavigationIcon(R.drawable.abc_vector_test);
        tbbackactivity.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intbackActivity = new Intent(LyThuyetActivity.this, MainActivity.class);
                startActivity(intbackActivity);
            }
        });
    }

    public void getViews(){
        cvCaudiemliet = (CardView) findViewById(R.id.cvCaudiemliet);
        cvKhainiem = (CardView) findViewById(R.id.cvKhainiem);
        cviewsahinh = (CardView) findViewById(R.id.cviewsahinh);
        //tao click
        cvCaudiemliet.setOnClickListener(this);
        cvKhainiem.setOnClickListener(this);
        cviewsahinh.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cvCaudiemliet:
                intent = new Intent(LyThuyetActivity.this, QuestionCauDiemlietActivity.class);
                startActivity(intent);
                break;
            case R.id.cvKhainiem:
                intent = new Intent(LyThuyetActivity.this, LuatgiaothongActivity.class);
                startActivity(intent);
                break;
            case R.id.cviewsahinh:
                intent = new Intent(LyThuyetActivity.this, SahinhActivity.class);
                startActivity(intent);
                break;
        }
    }
}
