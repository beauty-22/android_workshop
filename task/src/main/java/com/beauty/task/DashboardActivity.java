package com.beauty.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    int[] images;
    String[]names;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        images=new int[]{R.drawable.bk,R.drawable.bk2,R.drawable.bk3,R.drawable.bk4,R.drawable.bk5};
        names=new String[]{"bk1","bk2","bk3","bk4","bk5"};
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(DashboardActivity.this);

        VersionAdapter adapter=new VersionAdapter(DashboardActivity.this,getList(images,names),this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


    }
    private List<AndroidVersion> getList(int[]images, String[]names){
        List<AndroidVersion>list=new ArrayList<>();
        for(int i=0; i<images.length;i++){
            AndroidVersion version= new AndroidVersion();
            version.setImage(images[i]);
            version.setName((names[i]));
            list.add(version);
        }
        return  list;
    }
}

