package com.cs407.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber1, editTextNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextText);
        editTextNumber2 = findViewById(R.id.editTextText2);

        Button addButton = findViewById(R.id.button);
        addButton.setOnClickListener(v -> performOperation("+"));

        Button subtractButton = findViewById(R.id.button2);
        subtractButton.setOnClickListener(v -> performOperation("-"));

        Button multiplyButton = findViewById(R.id.button5);
        multiplyButton.setOnClickListener(v -> performOperation("*"));

        Button divideButton = findViewById(R.id.button6);
        divideButton.setOnClickListener(v -> performOperation("/"));
    }

    private void performOperation(String operation) {
        String num1Str = editTextNumber1.getText().toString();
        String num2Str = editTextNumber2.getText().toString();
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }
        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }
        Intent intent = new Intent(this, SecondaryActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}

