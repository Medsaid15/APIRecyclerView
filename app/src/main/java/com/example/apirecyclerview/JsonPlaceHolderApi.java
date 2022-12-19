package com.example.apirecyclerview;

import java.util.List;
//import android.telecom.Call;
import retrofit2.Call;
import retrofit2.http.GET;
public interface JsonPlaceHolderApi {
    @GET("/Posts")
    Call<List<Post>> getPosts();
}
