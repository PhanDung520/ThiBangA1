package com.example.thibanga1.recycler;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.thibanga1.R;
import  com.example.thibanga1.utils.*;
import java.util.ArrayList;

public class RecycleBienAdapter extends RecyclerView.Adapter<RecycleBienAdapter.ViewHolder>  {

    private static final String Tag = "RecyclerView";

    private Context context;
    private ArrayList<BienbaoData> bienbaoDataList;

    public RecycleBienAdapter(Context context, ArrayList<BienbaoData> bienbaoDataList) {
        this.context = context;
        this.bienbaoDataList = bienbaoDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bienbao_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(bienbaoDataList.get(position).getTvTitle());
        holder.tvContent.setText(bienbaoDataList.get(position).getTvContent());
        Glide.with(context).load(bienbaoDataList.get(position).getImgBien()).into(holder.imgBien);


    }

    @Override
    public int getItemCount() {
        return bienbaoDataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgBien;
        TextView tvTitle,tvContent;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            imgBien= (ImageView) itemView.findViewById(R.id.imgBien);
            tvContent=(TextView) itemView.findViewById(R.id.tvContent);
            tvTitle=(TextView) itemView.findViewById(R.id.tvTitle);


            tvTitle.setVisibility(View.GONE);
            tvContent.setVisibility(View.GONE);


            imgBien.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvTitle.setVisibility(View.VISIBLE);
                    tvContent.setVisibility(View.VISIBLE);
                }
            });



        }
    }

}
