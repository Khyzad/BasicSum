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
        Calculator calculator = new Calculator((TextView)findViewById(R.id.resultTextView));

        Button[] numericBtns = new Button[Buttons.values().length];

        for(int i = 0; i < numericBtns.length; i++){
            numericBtns[i] = findViewById(getResources().getIdentifier(Buttons.values()[i].toString(), "id", getPackageName()));
            numericBtns[i].setOnClickListener(new ButtonListener(calculator , Buttons.values()[i].Value));
        }
    }

    private class ButtonListener implements View.OnClickListener {
        private Calculator _Calculator;
        private String _Value;

        public ButtonListener(Calculator calculator, String value){
            this._Calculator = calculator;
            this._Value = value;
        }

        @Override
        public void onClick(View v){
            this._Calculator.append(this._Value);
        }
    }
}
