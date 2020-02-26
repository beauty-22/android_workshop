package com.beauty.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int[] images;
    String[]names;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView=findViewById(R.id.recyclerView);
        images=new int[]{R.drawable.cupcake,R.drawable.choco,R.drawable.donut,
                R.drawable.jelly,R.drawable.jelly2,R.drawable.kitkat,R.drawable.lollipop,R.drawable.oreo,R.drawable.pink};
        names=new String[]{"cupcake","choco","donut","jelly","jelly2","kitkat","lollipop","oreo","pink"};
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(MainActivity.this);

        VersionAdapter adapter=new VersionAdapter(MainActivity.this,getList(images,names),this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


    }
    private List<AndroidVersion> getList(int[]images,String[]names){
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
