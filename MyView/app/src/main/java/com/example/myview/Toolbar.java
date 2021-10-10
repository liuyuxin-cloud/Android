package com.example.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Toolbar extends ConstraintLayout {

    private ImageView iv_back;
    private TextView tv_title;
    private ImageView iv_right;
    private ConstraintLayout mLayout;
    private int mColor = Color.BLUE;
    private  int mTextColor = Color.WHITE;
    private String titleName = "";

    public Toolbar(Context context) {
        super(context);
        initView(context);
    }

    public Toolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.MyToolbar);
        mColor = mTypedArray.getColor(R.styleable.MyToolbar_title_bg,Color.BLUE);
        mTextColor = mTypedArray.getColor(R.styleable.MyToolbar_title_text_color,Color.WHITE);
        titleName = mTypedArray.getString(R.styleable.MyToolbar_title_text);
        mTypedArray.recycle();
        initView(context);
    }

    public Toolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.toolbar,this,true);
        iv_back = findViewById(R.id.iv_back);
        tv_title = findViewById(R.id.tv_title);
        iv_right = findViewById(R.id.iv_right);
        mLayout = findViewById(R.id.layout_toolbar_rootlayout);
        tv_title.setTextColor(mTextColor);
    }

    public void setTitle(String titleName){
        if(!TextUtils.isEmpty(titleName)){
            tv_title.setText(titleName);
        }
    }

    public void setBackListener(OnClickListener onClickListener){
        iv_back.setOnClickListener(onClickListener);
    }

    public void setRightListener(OnClickListener onClickListener){
        iv_right.setOnClickListener(onClickListener);
    }
}
