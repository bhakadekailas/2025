package com.kailas.factorialdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    TextView textViewFactorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        double fact = getIntent().getDoubleExtra("MyFact", 0);
        textViewFactorial = findViewById(R.id.textViewFactorial);
        textViewFactorial.setText("Factorial is " + fact);
    }
}