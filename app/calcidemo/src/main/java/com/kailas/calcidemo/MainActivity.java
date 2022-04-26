package com.kailas.calcidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button_plus, button_minus, button_mul, button_div, button_clear;
    EditText edittext_first_number, edittext_second_number;
    TextView edittext_result;
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        initViews();
        addClickListeners();
    }

    private void addClickListeners() {
        button_plus.setOnClickListener(view -> {
//            Log.e(TAG, "addClickListeners: ");
//            Toast.makeText(MainActivity.this, "Add button Clicked", Toast.LENGTH_SHORT).show();
        });

        button_minus.setOnClickListener(view -> {
            Log.e(TAG, "addClickListeners: ");
            Toast.makeText(MainActivity.this, "Sub button Clicked", Toast.LENGTH_SHORT).show();
        });

        button_mul.setOnClickListener(view -> {
            Log.e(TAG, "addClickListeners: ");
            Toast.makeText(MainActivity.this, "Mul button Clicked", Toast.LENGTH_SHORT).show();
        });

        button_div.setOnClickListener(view -> {
            Log.e(TAG, "addClickListeners: ");
            Toast.makeText(MainActivity.this, "Div button Clicked", Toast.LENGTH_SHORT).show();
        });
        button_clear.setOnClickListener(view -> {
            Log.e(TAG, "addClickListeners: ");
            Toast.makeText(MainActivity.this, "Clear button Clicked", Toast.LENGTH_SHORT).show();
        });
    }

    private void initViews() {

        //find out buttons
        button_plus = findViewById(R.id.button_plus);
        button_minus = findViewById(R.id.button_minus);
        button_mul = findViewById(R.id.button_mul);
        button_div = findViewById(R.id.button_div);
        button_clear = findViewById(R.id.button_clear);

        // find out edittext
        edittext_first_number = findViewById(R.id.edittext_first_number);
        edittext_second_number = findViewById(R.id.edittext_second_number);

        //find out textview
        edittext_result = findViewById(R.id.edittext_result);

    }


}