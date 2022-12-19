package com.example.apirecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    MyAdapter Adapter;
    List<Post>PostList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Adapter = new MyAdapter(this, PostList);
        recyclerView.setAdapter(Adapter);
        fetchPost();
        }
        private void fetchPost() {
            RetrofitClient.getRetrofitClient().getPosts().enqueue(new Callback<List<Post>>(){
                @Override
                public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                    if(response.isSuccessful() && response.body() != null){
                            PostList.addAll(response.body());
                            Adapter.notifyDataSetChanged();
                    }
                }
                @Override
                public void onFailure(Call<List<Post>> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Error :" + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
}