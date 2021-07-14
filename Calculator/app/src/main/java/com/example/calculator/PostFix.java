package com.example.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostFix {
    //The following function evaluates a postfix expression, using+, −, ∗, /, and ^ ending in =. It requires
    //spaces between all operators and =.

    public double evalPostFix(String token) {
        Stack<Double> s = new Stack<Double>();
        double a, b, result = 0.0;//ab是计算过程的中间变量，result是入栈时的变量
        boolean isNumber;
        for (int i = 0; i < token.length() - 1; i++) {
            try {
                isNumber = true;
                result = Double.parseDouble(token);//若输入字符不是数字，肯定报异常，即让布尔类型为false
            } catch (Exception e) {
                isNumber = false;
            }

            if (isNumber)//如果是数字，那么就入栈
                s.push(result);
            else//如果是运算符，那么就栈顶出两个数字，计算后再入栈
            {
                switch (token.charAt(0)) {//每个case后面都应该有break
                    case '+':
                        a = s.pop();
                        b = s.pop();
                        s.push(b + a);
                        break;
                    case '-':
                        a = s.pop();
                        b = s.pop();
                        s.push(b - a);
                        break;
                    case '÷':
                        a = s.pop();
                        b = s.pop();
                        s.push(b / a);
                        break;
                    case '×':
                        a = s.pop();
                        b = s.pop();
                        s.push(b * a);
                        break;
                }
            }
        }//当循环结束时，栈里只剩下一个元素
        return s.peek();//返回栈顶元素，并不删除
    }

    //完成逆波兰表达式
    public int calculate(String is) {
//创建栈
        String[] s = is.split("");
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, s);
        Stack<String> stack = new Stack<>();
        for (String item : list) {
//使用正则表达式
            if (item.matches("\\d+")) {
//入栈
                stack.push(item);


            } else {
//pop出两个数，并运算，在入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("×")) {
                    res = num1 * num2;
                } else if (item.equals("÷")) {
                    res = num1 / num2;
                }

//把结果压入栈中
                stack.push("" + res);

            }


        }
//最后停留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());

    }

}

