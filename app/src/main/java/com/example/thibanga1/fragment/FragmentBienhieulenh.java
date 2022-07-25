package com.example.thibanga1.fragment;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import com.example.thibanga1.R;
import com.example.thibanga1.recycler.RecycleBienAdapter;
import com.example.thibanga1.utils.BienbaoData;

public class FragmentBienhieulenh extends Fragment {

    RecyclerView recyclerViewBienhieulenh;
    private DatabaseReference bienhieulenhRef;
    private ArrayList<BienbaoData> bienbaoDataList;
    private RecycleBienAdapter recycleAdapter;
    public FragmentBienhieulenh() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_bienhieulenh, container, false);
        bienhieulenhRef = FirebaseDatabase.getInstance().getReference("bienbaogiaothong");
        recyclerViewBienhieulenh = (RecyclerView) view.findViewById(R.id.recycleviewBienhieulenh);
        recyclerViewBienhieulenh.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewBienhieulenh.setHasFixedSize(true);
        bienbaoDataList = new ArrayList<>();
        clearAll();
        getdataFromFirebase();
        return view;
    }
    public void getdataFromFirebase(){
        Query query = bienhieulenhRef.child("bienhieulenh");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                clearAll();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    BienbaoData bienbaoData = new BienbaoData();
                    bienbaoData.setImgBien(snapshot.child("image").getValue().toString());
                    bienbaoData.setTvTitle(snapshot.child("title").getValue().toString());
                    bienbaoData.setTvContent(snapshot.child("content").getValue().toString());
                    bienbaoDataList.add(bienbaoData);
                }
                recycleAdapter = new RecycleBienAdapter(getContext(),bienbaoDataList);
                recyclerViewBienhieulenh.setAdapter(recycleAdapter);
                recycleAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void clearAll(){

        if(bienbaoDataList!=null){
            bienbaoDataList.clear();
            if(recycleAdapter!=null){
                recycleAdapter.notifyDataSetChanged();

            }
        }
        bienbaoDataList = new ArrayList<>();
    }
}
