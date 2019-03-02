package com.example.firstproject;

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

        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = findViewById(R.id.firstNumEditText );
                EditText secondNumEditText = findViewById(R.id.secondNumEditText );
                TextView resultTextView = findViewById(R.id.resultTextView);

                resultTextView.setText(toInt(firstNumEditText) + toInt(secondNumEditText) + "");
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            }

            private int toInt(EditText text){
                return Integer.parseInt(text.getText().toString());
            }
        });
    }
}
