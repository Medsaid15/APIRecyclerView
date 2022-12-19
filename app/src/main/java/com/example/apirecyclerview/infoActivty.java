package com.example.apirecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class infoActivty extends AppCompatActivity {
    Post post;
    TextView title,content;
    private Post extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_activty);

        title = findViewById(R.id.txtV);
        content = findViewById(R.id.txtV1);
        //extras.putString("postList");
        //extras=getIntent().getExtras("");
        extras =(Post) getIntent().getExtras().getSerializable("body") ;
        title.setText(extras.getTitle());
    }
}