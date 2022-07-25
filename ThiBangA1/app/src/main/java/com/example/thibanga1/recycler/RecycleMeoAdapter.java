package com.example.thibanga1.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thibanga1.R;
import com.example.thibanga1.utils.*;
import java.util.ArrayList;

public class RecycleMeoAdapter extends RecyclerView.Adapter<RecycleMeoAdapter.ViewHolder> {

    private static final String Tag = "RecyclerView";

    private ArrayList<Meothidata> meothidataList;

    public RecycleMeoAdapter(ArrayList<Meothidata> meothidataList) {
        this.meothidataList = meothidataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meothi_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(meothidataList.get(position).getTvTitle());
        holder.tvContent.setText(meothidataList.get(position).getTvContent());
    }

    @Override
    public int getItemCount() {
        return meothidataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle,tvContent;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tvContentMeo);
            tvTitle = itemView.findViewById(R.id.tvTitleMeo);

        }
    }
}
