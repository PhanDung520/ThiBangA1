package com.example.thibanga1.thi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import com.example.thibanga1.R;
import com.example.thibanga1.DepthPageTransformer;
import com.example.thibanga1.FirebaseLoadDone;
import com.example.thibanga1.ThiActivity;
import com.example.thibanga1.recycler.QuestionThiAdapter;
import com.example.thibanga1.utils.QuestionData;

public class DethiSo6Activity extends AppCompatActivity implements FirebaseLoadDone {

    Toolbar tbbackactivity;
    List<QuestionData> questionDataList;
    ViewPager viewPagerQuestion;
    DatabaseReference questionRef;
    QuestionThiAdapter adapter;
    FirebaseLoadDone firebaseLoadDone;
    Button btnNext,btnPrevious;
    private int coutQuestion =1;

    Button btnNopbai;
    TextView tvCountdown;
    /*private static final long START_TIME_IN_MILLIS = 1140000;

    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private long timeLeftInMillis = START_TIME_IN_MILLIS;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dethi);
        questionRef = FirebaseDatabase.getInstance().getReference("dethi").child("deso6");
        firebaseLoadDone = this;

        questionDataList = new ArrayList<>();
        loadDataFromFirebase();
        backactivity();
        getViews();
        viewPagerQuestion.setPageTransformer(true, new DepthPageTransformer());
        clearAll();
        nextpage();
        btnNopbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialog();
            }
        });
    }
    private void showdialog() {
        final Dialog dialog = new Dialog(DethiSo6Activity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.thongbao_dialog_item);
        dialog.setCanceledOnTouchOutside(false);
        final TextView tvKetqua = (TextView) dialog.findViewById(R.id.tvketqua);
        TextView tvNoidungkq =(TextView) dialog.findViewById(R.id.tvndthongbao);
        Button btnDongy = (Button) dialog.findViewById(R.id.btnxacnhan);
        Button btnHuy = (Button) dialog.findViewById(R.id.btnhuy);
        int kq = (int) adapter.getSocau();
        if(kq>=16&&kq<=20){
            tvNoidungkq.setText("bạn đã thi qua");
            tvKetqua.setText("Số câu đúng: "+kq + "/ 20" );
        }else if (kq<16){
            tvNoidungkq.setText("bạn đã thi trượt");
            tvKetqua.setText("Số câu đúng: "+ kq+ "/ 20" );
        }
        btnDongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DethiSo6Activity.this,ThiActivity.class);
                startActivity(intent);
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnHuy.setVisibility(View.GONE);
        dialog.show();

    }
    /*private void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                showdialog();
            }
        }.start();
        timerRunning = true;
    }
    private void updateCountDownText() {
        int minutes = (int) timeLeftInMillis / 1000 / 60;
        int seconds = (int) timeLeftInMillis / 1000 % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        tvCountdown.setText(timeLeftFormatted);
    }
    private void pauseTimer(){
        countDownTimer.cancel();
    }
    private void resetTimer(){
        timeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
    }*/
    private void loadDataFromFirebase() {
        questionRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                clearAll();
                for (DataSnapshot snapshot :dataSnapshot.getChildren()){
                    QuestionData data = new QuestionData();
                    data.setCau("CÂU "+ coutQuestion++);
                    if (snapshot.child("question").exists()){
                        data.setQuestion(snapshot.child("question").getValue().toString());
                    }
                    if(snapshot.child("1").exists()){
                        data.setDa1(snapshot.child("1").getValue().toString());
                    }
                    if(snapshot.child("2").exists()){
                        data.setDa2(snapshot.child("2").getValue().toString());
                    }
                    if (snapshot.child("3").exists()){
                        data.setDa3(snapshot.child("3").getValue().toString());
                    }
                    if (snapshot.child("4").exists()){
                        data.setDa4(snapshot.child("4").getValue().toString());
                    }
                    if (snapshot.child("image").exists()){
                        data.setImageQuestion(snapshot.child("image").getValue().toString());
                    }
                    if (snapshot.child("explain").exists()){
                        data.setExplain(snapshot.child("explain").getValue().toString());
                    }
                    if (snapshot.child("answer").exists()){
                        data.setAnswer(snapshot.child("answer").getValue().toString());
                    }
                    questionDataList.add(data);
                    firebaseLoadDone.onFirebaseLoadSuccess(questionDataList);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                firebaseLoadDone.onFirebaseLoadFailed(error.getMessage());
            }
        });
    }
    public void backactivity(){
        tbbackactivity = (Toolbar) findViewById(R.id.tbbackactivity);
        setSupportActionBar(tbbackactivity);
        tbbackactivity.setTitle("ĐỀ SỐ 6");
        tbbackactivity.setNavigationIcon(R.drawable.abc_vector_test);
        tbbackactivity.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intbackActivity = new Intent(DethiSo6Activity.this, ThiActivity.class);
                startActivity(intbackActivity);
            }
        });
    }
    private void getViews(){
        viewPagerQuestion =(ViewPager) findViewById(R.id.viewPagerQuestionthi);
        btnNext = (Button) findViewById(R.id.btnNextthi);
        btnPrevious = (Button) findViewById(R.id.btnPreviousthi);
        tvCountdown = (TextView) findViewById(R.id.tvCountDown);
        btnNopbai = (Button) findViewById(R.id.btnNopbai);
    }
    private void nextpage() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPagerQuestion.setCurrentItem(viewPagerQuestion.getCurrentItem()+1,true);
            }
        });
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPagerQuestion.setCurrentItem(viewPagerQuestion.getCurrentItem()-1,true);
            }
        });
        btnPrevious.setVisibility(View.GONE);

    }
    private void clearAll(){
        if(questionDataList!=null){
            questionDataList.clear();
        }
        questionDataList = new ArrayList<>();
    }


    @Override
    public void onFirebaseLoadSuccess(List<QuestionData> questionDataList) {
        adapter = new QuestionThiAdapter(this,questionDataList);
        viewPagerQuestion.setAdapter(adapter);
    }

    @Override
    public void onFirebaseLoadFailed(String mess) {
        Toast.makeText(this,""+mess,Toast.LENGTH_SHORT).show();
    }
}
