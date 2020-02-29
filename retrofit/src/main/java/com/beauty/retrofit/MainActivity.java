package com.beauty.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.LinearLayout;

import com.beauty.retrofit.Rest.GetDataService;
import com.beauty.retrofit.Rest.RetrofitClientInstance;
import com.beauty.retrofit.domain.EmployeeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void getAllEmployees(){
        final ProgressDialog progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<EmployeeResponse> call=service.getAllEmployees();
        call.enqueue(new Callback<EmployeeResponse>() {
            @Override
            public void onResponse(Call<EmployeeResponse> call, Response<EmployeeResponse> response) {
                if (response.code()==200){
                    LinearLayout layoutManager=new LinearLayout(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    EmployeeAdapter adapter=new EmployeeAdapter(MainActivity.this,response.body().getData());
                    recyclerView.setAdapter(Adapter);
                    Log.i("@main","Employee===========>"+response.body().getData());
                }
                progressDoalog.cancel();

            }

            @Override
            public void onFailure(Call<EmployeeResponse> call, Throwable t) {
                Log.i("@main","error===========>"+t.getMessage());
                progressDoalog.cancel();

            }
        });
    }

}
