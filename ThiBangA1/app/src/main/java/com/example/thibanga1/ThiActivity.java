package com.example.thibanga1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.thibanga1.R;
import com.example.thibanga1.thi.DethiSo1Activity;
import com.example.thibanga1.thi.DethiSo2Activity;
import com.example.thibanga1.thi.DethiSo3Activity;
import com.example.thibanga1.thi.DethiSo4Activity;
import com.example.thibanga1.thi.DethiSo5Activity;
import com.example.thibanga1.thi.DethiSo6Activity;

public class ThiActivity extends AppCompatActivity {
    Toolbar tbbackactivity;

    CardView de1,de2,de3,de4,de5,de6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_thi);
        backactivity();
        getViews();

        de1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1;
                intent1 = new Intent(ThiActivity.this,DethiSo1Activity.class);
                startActivity(intent1);
            }
        });
        de2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2;
                intent2 = new Intent(ThiActivity.this, DethiSo2Activity.class);
                startActivity(intent2);
            }
        });
        de3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(ThiActivity.this, DethiSo3Activity.class);
                startActivity(intent3);
            }
        });
        de4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(ThiActivity.this, DethiSo4Activity.class);
                startActivity(intent4);

            }
        });
        de5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 =  new Intent(ThiActivity.this, DethiSo5Activity.class);
                startActivity(intent5);
            }
        });
        de6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(ThiActivity.this, DethiSo6Activity.class);
                startActivity(intent6);

            }
        });

    }
    public void backactivity(){
        tbbackactivity = (Toolbar) findViewById(R.id.tbbackactivity);
        setSupportActionBar(tbbackactivity);
        tbbackactivity.setNavigationIcon(R.drawable.abc_vector_test);
        tbbackactivity.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intbackActivity = new Intent(ThiActivity.this, MainActivity.class);
                startActivity(intbackActivity);
            }
        });
    }
    private void getViews(){
        de1 = (CardView) findViewById(R.id.cvDe1);
        de2 = (CardView) findViewById(R.id.cvDe2);
        de3 = (CardView) findViewById(R.id.cvDe3);
        de4 = (CardView) findViewById(R.id.cvDe4);
        de5= (CardView) findViewById(R.id.cvDe5);
        de6 = (CardView) findViewById(R.id.cvDe6);

    }

}
