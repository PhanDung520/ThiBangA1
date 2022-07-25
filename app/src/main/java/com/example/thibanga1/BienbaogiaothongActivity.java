package com.example.thibanga1;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.thibanga1.MainActivity;
import com.google.android.material.tabs.TabLayout;

import com.example.thibanga1.fragment.*;

import com.example.thibanga1.R;
import com.example.thibanga1.viewpager.viewPagerAdapter;

public class BienbaogiaothongActivity extends AppCompatActivity {
    Toolbar tbbackactivity;
    ViewPager viewPagerBien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bien_bao_giao_thong);
        backactivity();
        viewPager();

    }
    public void backactivity(){
        tbbackactivity = (Toolbar) findViewById(R.id.tbbackactivity);
        setSupportActionBar(tbbackactivity);
        tbbackactivity.setNavigationIcon(R.drawable.abc_vector_test);
        tbbackactivity.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intbackActivity = new Intent(BienbaogiaothongActivity.this, MainActivity.class);
                startActivity(intbackActivity);
            }
        });
    }
    public void  viewPager(){
        viewPagerBien = (ViewPager) findViewById(R.id.viewPagerbien);
        addTabs(viewPagerBien);
        ((TabLayout)findViewById(R.id.tabLayoutbien)).setupWithViewPager(viewPagerBien);
    }
    public void addTabs(ViewPager viewPagerBien){
        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
        adapter.addFrm(new FragmentBiencam(),"BIỂN BÁO CẤM");
        adapter.addFrm(new FragmentBienhieulenh(),"BIỂN HIỆU LỆNH");
        adapter.addFrm(new FragmentBienchidan(),"BIỂN CHỈ DẪN");
        adapter.addFrm(new FragmentBNguyhiemCanhbao(),"BIỂN BÁO NGUY HIỂM VÀ CẢNH BÁO");
        adapter.addFrm(new FragmentBienphu(),"BIỂN PHỤ");
        viewPagerBien.setAdapter(adapter);
    }
}
