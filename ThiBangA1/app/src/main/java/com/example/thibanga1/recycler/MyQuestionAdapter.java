package com.example.thibanga1.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.squareup.picasso.Picasso;
import java.util.List;

import com.example.thibanga1.R;
import com.example.thibanga1.utils.QuestionData;

public class MyQuestionAdapter extends PagerAdapter {
    Context context;
    List<QuestionData>questionDataList;

    public MyQuestionAdapter(Context context, List<QuestionData> questionDataList) {
        this.context = context;
        this.questionDataList = questionDataList;
    }

    @Override
    public int getCount() {
        return questionDataList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager)container).removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.question_item,container,false);

        ImageView imageQuestion = (ImageView) view.findViewById(R.id.imageQuestion);
        TextView tvQuestion = (TextView) view.findViewById(R.id.tvQuestion);
        final RadioGroup rgAnswers = (RadioGroup) view.findViewById(R.id.rgAnswers);
        final RadioButton radio1 = (RadioButton) view.findViewById(R.id.radio1);
        final RadioButton radio2 = (RadioButton) view.findViewById(R.id.radio2);
        final RadioButton radio3 = (RadioButton) view.findViewById(R.id.radio3);
        final RadioButton radio4 = (RadioButton) view.findViewById(R.id.radio4);
        RelativeLayout reImage = (RelativeLayout) view.findViewById(R.id.reImage);
        final RelativeLayout reExplain = (RelativeLayout) view.findViewById(R.id.reExplain);
        TextView tvExplain = (TextView) view.findViewById(R.id.tvExplain);

        TextView tvCau = (TextView) view.findViewById(R.id.tvCau);
        tvCau.setText(questionDataList.get(position).getCau());
        tvQuestion.setText(questionDataList.get(position).getQuestion());
        radio1.setVisibility(View.GONE);
        radio2.setVisibility(View.GONE);
        radio3.setVisibility(View.GONE);
        radio4.setVisibility(View.GONE);
        reExplain.setVisibility(View.GONE);
        if (questionDataList.get(position).getDa1()!=null){
            radio1.setText(questionDataList.get(position).getDa1());
            radio1.setVisibility(View.VISIBLE);
        }
        if (questionDataList.get(position).getDa2()!=null){
            radio2.setText(questionDataList.get(position).getDa2());
            radio2.setVisibility(View.VISIBLE);
        }
        if (questionDataList.get(position).getDa3()!=null){
            radio3.setText(questionDataList.get(position).getDa3());
            radio3.setVisibility(View.VISIBLE);
        }
        if(questionDataList.get(position).getDa4()!=null){
            radio4.setText(questionDataList.get(position).getDa4());
            radio4.setVisibility(View.VISIBLE);
        }
        if (questionDataList.get(position).getImageQuestion()==null){
            reImage.setVisibility(View.GONE);
            imageQuestion.setVisibility(View.GONE);
        }else if (questionDataList.get(position).getImageQuestion()!=null){
            Picasso.get().load(questionDataList.get(position).getImageQuestion()).into(imageQuestion);
            reImage.setVisibility(View.VISIBLE);
            imageQuestion.setVisibility(View.VISIBLE);
        }
        if (questionDataList.get(position).getExplain()!=null){
            tvExplain.setText(questionDataList.get(position).getExplain());
        }
        rgAnswers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio1:
                        questionDataList.get(position).setUseAnswer(radio1.getText().toString());
                        break;
                    case R.id.radio2:
                        questionDataList.get(position).setUseAnswer(radio2.getText().toString());
                        break;
                    case R.id.radio3:
                        questionDataList.get(position).setUseAnswer(radio3.getText().toString());
                        break;
                    case R.id.radio4:
                        questionDataList.get(position).setUseAnswer(radio4.getText().toString());
                        break;
                }
                if (questionDataList.get(position).getUseAnswer().equalsIgnoreCase(questionDataList.get(position).getAnswer())){
                    reExplain.setVisibility(View.VISIBLE);
                }else
                {
                    reExplain.setVisibility(View.GONE);
                }
            }
        });
        container.addView(view);
        return view;
    }
}
