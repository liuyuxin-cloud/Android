package com.example.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class ListViewEx extends ListView {

    private static final String TAG = "ListViewEx";
    private HorizontalView1 mHorizontalView1;

    //分别记录上次滑动的坐标

    public ListViewEx(Context context) {
        super(context);
    }

    public ListViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewEx(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
