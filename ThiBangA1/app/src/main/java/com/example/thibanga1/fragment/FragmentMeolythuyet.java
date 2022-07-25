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
import com.example.thibanga1.recycler.*;
import com.example.thibanga1.utils.*;

public class FragmentMeolythuyet extends Fragment {

    RecyclerView recycleViewMeolythuyet;
    private DatabaseReference meolythuyetRef;
    private ArrayList<Meothidata> meothidataList;
    private RecycleMeoAdapter recycleAdapter;

    public FragmentMeolythuyet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meolythuyet, container, false);
        meolythuyetRef = FirebaseDatabase.getInstance().getReference("meothi");
        recycleViewMeolythuyet = (RecyclerView)view.findViewById(R.id.recycleviewMeolythuyet);
        recycleViewMeolythuyet.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleViewMeolythuyet.setHasFixedSize(true);
        meothidataList= new ArrayList<>();
        clearAll();
        getdataFromFirebase();
        return view;
    }

    private void getdataFromFirebase() {

        Query query = meolythuyetRef.child("meolythuyet");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                clearAll();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Meothidata meothidata = new Meothidata();
                    meothidata.setTvTitle(snapshot.child("title").getValue().toString());
                    meothidata.setTvContent(snapshot.child("content").getValue().toString());
                    meothidataList.add(meothidata);
                }
                recycleAdapter = new RecycleMeoAdapter(meothidataList);
                recycleViewMeolythuyet.setAdapter(recycleAdapter);
                recycleAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void clearAll(){

        if(meothidataList!=null){
            meothidataList.clear();
            if(recycleAdapter!=null){
                recycleAdapter.notifyDataSetChanged();

            }
        }
        meothidataList = new ArrayList<>();
    }
}
