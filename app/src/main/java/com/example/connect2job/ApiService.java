package com.example.connect2job;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {


    @POST("/signup")
    Call<User> signUp(@Body User user);
    @POST("/loginjobseeker")
    Call<ResponseBody> login(@Body LoginRequest request);

    @POST("/logincompany")
    Call<ResponseBody> login2(@Body LoginRequest request);


    @POST("/store_opportunity")
    Call<Void> storeOpportunity(@Body storeOpportunities_Model data);


    @GET("/opportunities")
    Call<List<OpportunitiesModel>> getOpportunities();

    @GET("/viewapplications")
    Call<List<View_ApplicationsModel>> getApplications();


    @POST("/apply_job")
    Call<Void> applyjob(@Body Apply_JobModel data);



}
