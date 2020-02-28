package com.beauty.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.beauty.retrofit.Rest.GetDataService;
import com.beauty.retrofit.Rest.RetrofitClientInstance;
import com.beauty.retrofit.domain.EmployeeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void getAllEmployees(){
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<EmployeeResponse> call=service.getAllEmployees();
        call.enqueue(new Callback<EmployeeResponse>() {
            @Override
            public void onResponse(Call<EmployeeResponse> call, Response<EmployeeResponse> response) {
                if (response.code()==200){
                    Log.i("@main","Employee===========>"+response.body().getData());
                }

            }

            @Override
            public void onFailure(Call<EmployeeResponse> call, Throwable t) {
                Log.i("@main","error===========>"+t.getMessage());

            }
        });
    }

}
