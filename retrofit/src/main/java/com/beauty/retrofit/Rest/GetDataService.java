package com.beauty.retrofit.Rest;

import com.beauty.retrofit.domain.EmployeeResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/api/v1/employees")
    Call<EmployeeResponse> getAllEmployees();
}
