package com.example.thibanga1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.google.android.material.tabs.TabLayout;

import com.example.thibanga1.viewpager.*;
import com.example.thibanga1.fragment.*;
import com.example.thibanga1.R;


public class MeothiActivity extends AppCompatActivity {
    Toolbar tbbackactivity;
    ViewPager viewPagerMeothi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_meo_thi);
        backactivity();
        getViewPager();

    }
    public void backactivity(){
        tbbackactivity = (Toolbar) findViewById(R.id.tbbackactivity);
        setSupportActionBar(tbbackactivity);
        tbbackactivity.setNavigationIcon(R.drawable.abc_vector_test);
        tbbackactivity.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intbackActivity = new Intent(MeothiActivity.this, MainActivity.class);
                startActivity(intbackActivity);
            }
        });
    }
    public void getViewPager(){
        viewPagerMeothi = (ViewPager) findViewById(R.id.viewPagerMeothi);
        addTabs(viewPagerMeothi);
        ((TabLayout)findViewById(R.id.tabLayoutMeothi)).setupWithViewPager(viewPagerMeothi);
    }

    public void addTabs(ViewPager viewPagerMeothi){
        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
        adapter.addFrm(new FragmentMeolythuyet(),"MẸO LÝ THUYẾT");
        adapter.addFrm(new FragmentMeothuchanh(),"MẸO THỰC HÀNH");
        viewPagerMeothi.setAdapter(adapter);
    }
}