package com.example.thibanga1.lythuyet;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.thibanga1.DepthPageTransformer;
import com.example.thibanga1.FirebaseLoadDone;
import com.example.thibanga1.LyThuyetActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import com.example.thibanga1.R;
import com.example.thibanga1.recycler.MyQuestionAdapter;
import com.example.thibanga1.utils.QuestionData;

public class QuestionCauDiemlietActivity extends AppCompatActivity implements FirebaseLoadDone {
    Toolbar tbbackactivity;
    List<QuestionData> questionDataList;
    ViewPager viewPagerQuestion;
    DatabaseReference questionRef;
    MyQuestionAdapter adapter;
    FirebaseLoadDone firebaseLoadDone;
    Button btnNext,btnPrevious;
    private int coutQuestion =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_question_on);

        questionRef = FirebaseDatabase.getInstance().getReference("hoclythuyet").child("caudiemliet");

        firebaseLoadDone = this;
        questionDataList = new ArrayList<>();
        loadDataFromFirebase();
        backactivity();
        getViews();
        viewPagerQuestion.setPageTransformer(true,new DepthPageTransformer());
        clearAll();
        nextpage();
    }

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
        tbbackactivity.setNavigationIcon(R.drawable.abc_vector_test);
        tbbackactivity.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intbackActivity = new Intent(QuestionCauDiemlietActivity.this, LyThuyetActivity.class);
                startActivity(intbackActivity);
            }
        });
    }
    private void getViews(){
        viewPagerQuestion =(ViewPager) findViewById(R.id.viewPagerQuestion);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnPrevious = (Button) findViewById(R.id.btnPrevious);
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

    }

    private void clearAll(){
        if(questionDataList!=null){
            questionDataList.clear();
        }
        questionDataList = new ArrayList<>();
    }

    @Override
    public void onFirebaseLoadSuccess(List<QuestionData> questionDataList) {
        adapter = new MyQuestionAdapter(this,questionDataList);
        viewPagerQuestion.setAdapter(adapter);
    }

    @Override
    public void onFirebaseLoadFailed(String mess) {
        Toast.makeText(this,""+mess,Toast.LENGTH_SHORT).show();
    }
}
