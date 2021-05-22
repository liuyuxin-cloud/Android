package com.example.callbackdemo;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class Dialog extends android.app.Dialog {
    private Button mButton1;
    private Button mButton2;
    private EditText mEditText;
    private OnEnsureListener onEnsureListener;

    public Dialog(@NonNull Context context) {
        super(context);
    }
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
        mButton1 = findViewById(R.id.button1);
        mButton2 = findViewById(R.id.button2);
        mEditText = findViewById(R.id.et);


        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  msg = mEditText.getText().toString();
                if(!TextUtils.isEmpty(msg)){
                    if(onEnsureListener != null){
                        onEnsureListener.onEnsure(msg);
                    }
                }
                cancel();
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

    }
    public void setOnEnsureListener(OnEnsureListener onEnsureListener){
        this.onEnsureListener = onEnsureListener;
    }

    public void setTextView(String msg) {

    }

}
