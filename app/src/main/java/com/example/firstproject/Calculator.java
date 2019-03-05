package com.example.firstproject;

import android.widget.TextView;

public class Calculator {
    private TextView _TextView;
    private String[] operands = {"", ""};
    private byte i = 0;
    private boolean isDouble = false;
    private String operator;


    public Calculator(TextView textView) {
        this._TextView = textView;
    }

    public void append(String value){
        switch (value){
            case "+":
                add(value);
                break;
            case "-":
                subtract(value);
                break;
            case "*":
                multiply(value);
                break;
            case "/":
                divide(value);
                break;
            case "=":
                equal();
                break;
            case "":
                backspace(value);
                break;
            case ".":
                decimal(value);
                break;
            case "^":
                power(value);
                break;
            case "_":
                clear();
                break;
            default:
                operands[i] += value;
                _TextView.append(value);
        }

    }

    private double parseDouble(String value){
        return Double.parseDouble(value);
    }

    private void operate(String value){
        if(operands[1].length() > 0) {
            equal();
        }else if(i == 1){
            operator = value;
        }else{
            operands[i++] = this._TextView.getText().toString();
        }
    }

    private void add(String value){
        if(operands[0].length() == 0)
            return;

        operate(value);

        operator = Buttons.btnPlus.Value;
        this._TextView.append(operator);
    }

    private void subtract(String value){
        if(operands[0].length() == 0)
            return;

        operate(value);

        operator = Buttons.btnMinus.Value;
        this._TextView.append(operator);
    }

    private void multiply(String value){
        if(operands[0].length() == 0)
            return;

        operate(value);

        operator = Buttons.btnMultiply.Value;
        this._TextView.append(operator);
    }

    private void divide(String value){
        if(operands[0].length() == 0)
            return;

        operate(value);

        operator = Buttons.btnDivide.Value;
        this._TextView.append(operator);
    }

    private void power(String value){

    }

    private void decimal(String value){

    }

    private void equal(){
        if(i < 1){
            return;
        }

        double answer;
        switch(operator){
            case "+":
                answer = parseDouble(operands[0]) + parseDouble(operands[1]);
                break;
            case "-":
                answer = parseDouble(operands[0]) - parseDouble(operands[1]);
                break;
            case "*":
                answer = parseDouble(operands[0]) * parseDouble(operands[1]);
                break;
            case "/":
                answer = parseDouble(operands[0]) / parseDouble(operands[1]);
                break;
            default:
                answer = 0;
        }

        operands[0] = isDouble ? answer + "" : (int)answer + "";
        operands[1] = "";
        operator = "";
        i = 1;
        this._TextView.setText(operands[0]);
    }

    private void backspace(String value){

    }

    private void clear(){
        this._TextView.setText("");
        i = 0;

        operands[0] = "";
        operands[1] = "";
        operator = "";
    }
}
