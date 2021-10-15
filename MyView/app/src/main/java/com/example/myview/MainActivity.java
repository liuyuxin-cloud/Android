package com.example.myview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListViewEx lv_one,lv_two;
    private HorizontalView1 mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal_view);
        mView = findViewById(R.id.hv);
        lv_one = findViewById(R.id.lv_one);
        lv_one.setHorizontalView1(mView);
        lv_two = findViewById(R.id.lv_two);
        lv_two.setHorizontalView1(mView);
        String[] str1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (this, android.R.layout.simple_expandable_list_item_1,str1);
        lv_one.setAdapter(adapter1);
        //mView = findViewById(R.id.rv_rect);
       // mView.setOnClickListener(v -> mView.setAlpha((float) 0.5));
        String[] str2 = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_expandable_list_item_1,str2);
        lv_two.setAdapter(adapter2);
    }
}
