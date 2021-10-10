package com.example.myview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RectView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mView = findViewById(R.id.rv_rect);
       // mView.setOnClickListener(v -> mView.setAlpha((float) 0.5));
    }


}
