package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    ImageButton one,two,three,four,five,six,seven,eight,nine,zero,point,back,add,dec,div,mul,equ,ce,left,right;
    TextView result;
    String formula = null;
    int operator = 0;//0表示开头不可用运算符1表示可以用运算符2表示运算符的更改
    int pointed = 0;//0表示不能用小数点1表示可以用小数点
    int sign = 0;//0在最前方可加左括号1非最前方前有运算符可加左括号2已有左括号需加数3需加运算符4需加数5可加右括号6前方是非运算符则不可加左括号7右括号后不可直接加数字
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
        equ = findViewById(R.id.equ);
        ce = findViewById(R.id.ce);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        result = findViewById(R.id.result);
    }

    void initListener(){
        one.setOnClickListener(v -> {
            if(sign == 2){
                sign = 3;
            }else if(sign == 3){
                sign = 4;
            }else if(sign == 4){
                sign = 5;
            }else if(sign == 0){
                sign = 6;
            }
            if(sign != 7){
                operator = 1;
                pointed = 1;
                formula = String.valueOf(result.getText());
                formula = formula + "1";
                result.setText(formula);
            }
            System.out.println(sign);
        });
        two.setOnClickListener(v -> {
            if(sign == 2){
                sign = 3;
            }else if(sign == 3){
                sign = 4;
            }else if(sign == 4){
                sign = 5;
            }else if(sign == 0){
                sign = 6;
            }
            if(sign != 7) {
                operator = 1;
                pointed = 1;
                formula = String.valueOf(result.getText());
                formula = formula + "2";
                result.setText(formula);
            }
            System.out.println(sign);
        });
        three.setOnClickListener(v -> {
            if(sign == 2){
                sign = 3;
            }else if(sign == 3){
                sign = 4;
            }else if(sign == 4){
                sign = 5;
            }else if(sign == 0){
                sign = 6;
            }
            if(sign != 7) {
                operator = 1;
                pointed = 1;
                formula = String.valueOf(result.getText());
                formula = formula + "3";
                result.setText(formula);
            }
            System.out.println(sign);
        });
        four.setOnClickListener(v -> {
            if(sign == 2){
                sign = 3;
            }else if(sign == 3){
                sign = 4;
            }else if(sign == 4){
                sign = 5;
            }else if(sign == 0){
                sign = 6;
            }
            if(sign != 7) {
                operator = 1;
                pointed = 1;
                formula = String.valueOf(result.getText());
                formula = formula + "4";
                result.setText(formula);
            }
            System.out.println(sign);
        });
        five.setOnClickListener(v -> {
            if(sign == 2){
                sign = 3;
            }else if(sign == 3){
                sign = 4;
            }else if(sign == 4){
                sign = 5;
            }else if(sign == 0){
                sign = 6;
            }
            if(sign != 7) {
                operator = 1;
                pointed = 1;
                formula = String.valueOf(result.getText());
                formula = formula + "5";
                result.setText(formula);
            }
            System.out.println(sign);
        });
        six.setOnClickListener(v -> {
            if(sign == 2){
                sign = 3;
            }else if(sign == 3){
                sign = 4;
            }else if(sign == 4){
                sign = 5;
            }else if(sign == 0){
                sign = 6;
            }
            if(sign != 7) {
                operator = 1;
                pointed = 1;
                formula = String.valueOf(result.getText());
                formula = formula + "6";
                result.setText(formula);
            }
            System.out.println(sign);
        });
        seven.setOnClickListener(v -> {
            if(sign == 2){
                sign = 3;
            }else if(sign == 3){
                sign = 4;
            }else if(sign == 4){
                sign = 5;
            }else if(sign == 0){
                sign = 6;
            }
            if(sign != 7) {
                operator = 1;
                pointed = 1;
                formula = String.valueOf(result.getText());
                formula = formula + "7";
                result.setText(formula);
            }
            System.out.println(sign);
        });
        eight.setOnClickListener(v -> {
            if(sign == 2){
                sign = 3;
            }else if(sign == 3){
                sign = 4;
            }else if(sign == 4){
                sign = 5;
            }else if(sign == 0){
                sign = 6;
            }
            if(sign != 7) {
                operator = 1;
                pointed = 1;
                formula = String.valueOf(result.getText());
                formula = formula + "8";
                result.setText(formula);
            }
            System.out.println(sign);
        });
        nine.setOnClickListener(v -> {
            if(sign == 2){
                sign = 3;
            }else if(sign == 3){
                sign = 4;
            }else if(sign == 4){
                sign = 5;
            }else if(sign == 0){
                sign = 6;
            }
            if(sign != 7) {
                operator = 1;
                pointed = 1;
                formula = String.valueOf(result.getText());
                formula = formula + "9";
                result.setText(formula);
            }
            System.out.println(sign);
        });
        zero.setOnClickListener(v -> {
            if(sign == 2){
                sign = 3;
            }else if(sign == 3){
                sign = 4;
            }else if(sign == 4){
                sign = 5;
            }else if(sign == 0){
                sign = 6;
            }
            if(sign != 7) {
                operator = 1;
                pointed = 1;
                formula = String.valueOf(result.getText());
                formula = formula + "0";
                result.setText(formula);
            }
            System.out.println(sign);
        });
        add.setOnClickListener(v -> {
            if (operator == 1) {
                formula = String.valueOf(result.getText());
                formula = formula + "+";
                operator = 2;
                //sign = 1;
            }else if(operator == 2){
                formula = String.valueOf(result.getText());
                formula = formula.substring(0,formula.length()-1);
                formula = formula + "+";
            }
            if(sign == 3){
                sign = 4;
            }else if(sign == 6){
                sign = 1;
            }else if(sign == 7){
                sign = 6;
            }
            result.setText(formula);
            System.out.println(sign);
        });
        dec.setOnClickListener(v -> {
            if(operator == 1){
                formula = String.valueOf(result.getText());
                formula = formula + "-";
                operator = 2;
                //sign = 1;
            }else if(operator == 2) {
                formula = String.valueOf(result.getText());
                formula = formula.substring(0,formula.length()-1);
                formula = formula + "-";
            }
            if(sign == 3){
                sign = 4;
            }else if(sign == 6){
                sign = 1;
            }else if(sign == 7){
                sign = 6;
            }
            result.setText(formula);
            System.out.println(sign);
        });
        mul.setOnClickListener(v -> {
            if(operator == 1){
                formula = String.valueOf(result.getText());
                formula = formula + "×";
                operator = 2;
                //sign = 1;
            }else if(operator == 2){
                formula = String.valueOf(result.getText());
                formula = formula.substring(0,formula.length()-1);
                formula = formula + "×";
            }
            if(sign == 3){
                sign = 4;
            }else if(sign == 6){
                sign = 1;
            }else if(sign == 7){
                sign = 6;
            }
            result.setText(formula);
            System.out.println(sign);
        });
        div.setOnClickListener(v -> {
            if(operator == 1){
                formula = String.valueOf(result.getText());
                formula = formula + "÷";
                operator = 2;
                //sign = 1;
            }else if(operator == 2){
                formula = String.valueOf(result.getText());
                formula = formula.substring(0,formula.length()-1);
                formula = formula + "÷";
            }
            if(sign == 3){
                sign = 4;
            }else if(sign == 6){
                sign = 1;
            }else if(sign == 7){
                sign = 6;
            }
            result.setText(formula);
            System.out.println(sign);
        });
        point.setOnClickListener(v -> {
            if(pointed == 1 && formula.charAt(formula.length()-1) >= '0' && formula.charAt(formula.length()-1) <= '9') {
                formula = String.valueOf(result.getText());
                formula = formula + ".";
                result.setText(formula);
                pointed = 0;
                operator = 0;
            }
            System.out.println(sign);
        });
        back.setOnClickListener(v -> {
            formula = String.valueOf(result.getText());
            if(formula.length() != 0){
                switch (formula.charAt(formula.length()-1)){
                    case ')':
                        sign = 5;
                        formula = formula.substring(0,formula.length()-1);
                        break;
                    case '+':
                    case '-':
                    case '÷':
                    case '×':
                        if(sign == 4){
                            sign = 3;
                        }else if(sign == 1){
                            sign = 6;
                        }
                        operator = 1;
                        formula = formula.substring(0,formula.length()-1);
                        break;
                    case '(':
                        formula = formula.substring(0,formula.length()-1);
                        sign = 1;
                        break;
                    case '.':
                        formula = formula.substring(0,formula.length()-1);
                        pointed = 1;
                        operator = 1;
                        break;
                    default://数字
                        if(sign == 3){
                            sign = 2;
                        }else if(sign == 4){
                            sign = 3;
                        }else if(sign == 5){
                            sign = 4;
                        }else if(sign == 6){
                            sign = 0;
                        }
                        formula = formula.substring(0,formula.length()-1);
                        break;
                }
                System.out.println(sign);
            }
            if(formula.length() ==  0){
                operator = 0;
                pointed = 0;
                sign = 0;
                formula = " ";
            }
            result.setText(formula);
            System.out.println(sign);
        });
        left.setOnClickListener(v -> {
            if(sign == 0 || sign == 1){
                formula = String.valueOf(result.getText());
                formula = formula + "(";
                result.setText(formula);
                sign = 2;
                operator = 0;
            }
            System.out.println(sign);
        });
        right.setOnClickListener(v->{
            if(sign == 5){
                formula = String.valueOf(result.getText());
                formula = formula + ")";
                result.setText(formula);
                sign = 7;
                operator = 1;
            }
            System.out.println(sign);
        });
        equ.setOnClickListener(v -> {
            formula = formula.substring(1,formula.length());
            InfixToSuffix str = new InfixToSuffix(formula);
            MyCharStack arr = str.doTrans();
            String jisuan;
            int res = 0;
            jisuan = arr.StackToString();
            PostFix postfix = new PostFix();
            res = postfix.calculate(jisuan);
            result.setText(String.valueOf(res));
            formula = " ";
        });
        ce.setOnClickListener(v -> {
            formula = " ";
            result.setText(formula);
            operator = 0;
            pointed = 0;
            sign = 0;
            System.out.println(sign);
        });
    }
}