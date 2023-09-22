package com.cs407.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        TextView textViewResult = findViewById(R.id.textView);
        Intent intent = getIntent();
        double result = intent.getDoubleExtra("result", 0.0);
        textViewResult.setText("" + result);
    }
}
