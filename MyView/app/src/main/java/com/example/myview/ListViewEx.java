package com.example.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class ListViewEx extends ListView {

    private static final String TAG = "ListViewEx";

    public void setHorizontalView1(HorizontalView1 mHorizontalView1) {
        this.mHorizontalView1 = mHorizontalView1;
    }

    private HorizontalView1 mHorizontalView1;

    //分别记录上次滑动的坐标
    private int mLastX = 0, mLastY = 0;

    public ListViewEx(Context context) {
        super(context);
    }

    public ListViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewEx(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                mHorizontalView1.requestDisallowInterceptTouchEvent(true);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    mHorizontalView1.requestDisallowInterceptTouchEvent(false);
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
            default:
                break;
        }
        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(event);
    }
}
