package com.example.firstproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();
    }

    public void setUp(){
        ResultView resultView = new ResultView((TextView)findViewById(R.id.resultTextView));

        Button[] numericBtns = new Button[Buttons.values().length];

        for(int i = 0; i < numericBtns.length; i++){
            numericBtns[i] = findViewById(getResources().getIdentifier(Buttons.values()[i].toString(), "id", getPackageName()));
            numericBtns[i].setOnClickListener(new ButtonListener(resultView , Buttons.values()[i].Value));
        }
    }

    private class ResultView {
        private TextView _TextView;
        private String[] operands = {"", ""};
        private byte i = 0;
        private boolean isDouble = false;
        private String operator;


        public ResultView(TextView textView) {
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

        private double parseInteger(String value){
            return Integer.parseInt(value);
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

            operator = "+";
            this._TextView.append(operator);
        }

        private void subtract(String value){
            if(operands[0].length() == 0)
                return;

            operate(value);

            operator = "-";
            this._TextView.append(operator);
        }

        private void multiply(String value){
            if(operands[0].length() == 0)
                return;

            operate(value);

            operator = "*";
            this._TextView.append(operator);
        }

        private void divide(String value){
            if(operands[0].length() == 0)
                return;

            operate(value);

            operator = "/";
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

            if(!isDouble){
                operands[0] = (int)answer + "";
            }else{
                operands[0] = answer + "";
            }


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

    private class ButtonListener implements View.OnClickListener {
        private ResultView _ResultView;
        private String _Value;

        public ButtonListener(ResultView ResultView, String value){
            this._ResultView = ResultView;
            this._Value = value;
        }

        @Override
        public void onClick(View v){
            this._ResultView.append(this._Value);
        }
    }
}
