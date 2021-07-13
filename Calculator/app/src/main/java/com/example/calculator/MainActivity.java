package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    ImageButton one,two,three,four,five,six,seven,eight,nine,zero,point,back,add,dec,div,mul,per,equ,ce;
    TextView result;
    String formula = " ";
    boolean operator = false,pointed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }
    void initView(){
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        point = findViewById(R.id.point);
        back = findViewById(R.id.back);
        add = findViewById(R.id.add);
        dec = findViewById(R.id.dec);
        div = findViewById(R.id.div);
        mul = findViewById(R.id.mul);
        per = findViewById(R.id.per);
        equ = findViewById(R.id.equ);
        ce = findViewById(R.id.ce);
        result = findViewById(R.id.result);
    }

    void initListener(){
        one.setOnClickListener(v -> {
            formula = String.valueOf(result.getText());
            formula = formula + "1";
            result.setText(formula);
        });
        two.setOnClickListener(v -> {
            formula = String.valueOf(result.getText());
            formula = formula + "2";
            result.setText(formula);
        });
        three.setOnClickListener(v -> {
            formula = String.valueOf(result.getText());
            formula = formula + "3";
            result.setText(formula);
        });
        four.setOnClickListener(v -> {
            formula = String.valueOf(result.getText());
            formula = formula + "4";
            result.setText(formula);
        });
        five.setOnClickListener(v -> {
            formula = String.valueOf(result.getText());
            formula = formula + "5";
            result.setText(formula);
        });
        six.setOnClickListener(v -> {
            formula = String.valueOf(result.getText());
            formula = formula + "6";
            result.setText(formula);
        });
        seven.setOnClickListener(v -> {
            formula = String.valueOf(result.getText());
            formula = formula + "7";
            result.setText(formula);
        });
        eight.setOnClickListener(v -> {
            formula = String.valueOf(result.getText());
            formula = formula + "8";
            result.setText(formula);
        });
        nine.setOnClickListener(v -> {
            formula = String.valueOf(result.getText());
            formula = formula + "9";
            result.setText(formula);
        });
        zero.setOnClickListener(v -> {
            formula = String.valueOf(result.getText());
            formula = formula + "0";
            result.setText(formula);
        });
        add.setOnClickListener(v -> {
            if (!operator) {
                formula = String.valueOf(result.getText());
                formula = formula + "+";
                operator = true;
            }else{
                formula = String.valueOf(result.getText());
                formula = formula.substring(0,formula.length()-1);
                formula = formula + "+";
            }
            result.setText(formula);
        });
        dec.setOnClickListener(v -> {
            if(!operator){
                formula = String.valueOf(result.getText());
                formula = formula + "-";
                operator = true;
            }else {
                formula = String.valueOf(result.getText());
                formula = formula.substring(0,formula.length()-1);
                formula = formula + "-";
            }
            result.setText(formula);
        });
        mul.setOnClickListener(v -> {
            if(!operator){
                formula = String.valueOf(result.getText());
                formula = formula + "×";
                operator = true;
            }else{
                formula = String.valueOf(result.getText());
                formula = formula.substring(0,formula.length()-1);
                formula = formula + "×";
            }
            result.setText(formula);
        });
        div.setOnClickListener(v -> {
            if(!operator){
                formula = String.valueOf(result.getText());
                formula = formula + "÷";
                operator = true;
            }else{
                formula = String.valueOf(result.getText());
                formula = formula.substring(0,formula.length()-1);
                formula = formula + "÷";
            }

            result.setText(formula);
        });
        point.setOnClickListener(v -> {
            if(!pointed) {
                formula = String.valueOf(result.getText());
                formula = formula + ".";
                result.setText(formula);
                pointed = true;
            }
        });
        back.setOnClickListener(v -> {
            formula = String.valueOf(result.getText());
            if(formula.length()-1 != 0){
                formula = formula.substring(0,formula.length()-1);
            }
            result.setText(formula);
            if(formula.length() ==  0){
                operator = false;
                pointed = false;
            }
        });
        per.setOnClickListener(v -> {
            formula = String.valueOf(result.getText());
            formula = formula + "%";
            operator = true;
            result.setText(formula);
        });
        equ.setOnClickListener(v -> {

        });
        ce.setOnClickListener(v -> {
            formula = "";
            result.setText(formula);
            operator = false;
            pointed = false;
        });
    }
}